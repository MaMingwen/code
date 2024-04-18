# -*- coding: utf-8 -*-
"""
Created on Sat Jul 23 15:42:22 2022

@author: Fate
"""

# -*- coding: utf-8 -*-
"""
Created on Wed Oct 21 20:45:06 2020

@author: Fate-LD

E-mail: lidi.math@whu.edu.cn
"""

import torch 
import numpy as np
from typing import Callable
from torch import autograd, Tensor
import torch.nn as nn
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D

#from mpl_toolkits.mplot3d import axes3d
#import matplotlib.pyplot as plt

#problem: -\laplace u = f in [0,2*pi] and f = sin(x) ; u = 0 on x=0 and x=2*pi, exact solution u_exact = sin(x)

long_x = np.pi
long_y = np.pi

N_Gauss = 20000
N_Gauss_bound = 20000
BatchSize = 256

beta = 1
learning_rate = 0.001

num_epochs = 20000

input_size = 2
output_size = 1

f_source = lambda x: 2 * torch.sin(x[:,0])*torch.sin(x[:,1])

#xi = torch.randn(N_Gauss,1)
u = lambda x,y: torch.sin(x)*torch.sin(y)
#u_exact = u(xi)

@torch.no_grad() # 紧随的定义的函数的返回值的梯度属性是'false'。
def _init_params(m):
    if isinstance(m, nn.Linear):#Xavier Initialization。Xavier Glorot 认为：优秀的初始化应该使得各层的激活值和状态梯度在传播过程中的方差保持一致。即方差一致性。
        nn.init.xavier_normal_(m.weight)
        nn.init.constant_(m.bias, 0.0)
        
class Block(nn.Module):
    def __init__(self, input_size, hidden_width, output_size):
        super(Block, self).__init__()
        self.fc1 = nn.Linear(input_size, hidden_width)
        self.fc2 = nn.Linear(hidden_width, output_size)
        self.apply(_init_params) # 初始化参数
        
    def forward(self, x):
        res = torch.tanh(self.fc1(x))
        res = torch.tanh(self.fc2(res))
        return torch.add(x, res)

#class MyReLU(torch.autograd.Function):
#    """
#    We can implement our own custom autograd Functions by subclassing
#    torch.autograd.Function and implementing the forward and backward passes
#    which operate on Tensors.
#    relu = MyReLU.apply
#    """
#
#    @staticmethod
#    def forward(ctx, input):
#        """
#        In the forward pass we receive a Tensor containing the input and return
#        a Tensor containing the output. ctx is a context object that can be used
#        to stash information for backward computation. You can cache arbitrary
#        objects for use in the backward pass using the ctx.save_for_backward method.
#        """
#        ctx.save_for_backward(input)
#        return input.clamp(min=0)
#
#    @staticmethod
#    def backward(ctx, grad_output):
#        """
#        In the backward pass we receive a Tensor containing the gradient of the loss
#        with respect to the output, and we need to compute the gradient of the loss
#        with respect to the input.
#        """
#        input, = ctx.saved_tensors
#        grad_input = grad_output.clone()
##        grad_input = torch.pow(grad_input,3)
#        grad_input[input < 0] = 0
#        return grad_input
        
class RitzNN(nn.Module):
    def __init__(self, input_size, output_size):
        super(RitzNN, self).__init__()
        
        m = 16
        self.fc_input = nn.Linear(input_size, m)
        self.block1 = Block(m, m, m) # 相当于两个中间层
        self.block2 = Block(m, m, m)
        self.block3 = Block(m, m, m)
        self.block4 = Block(m, m, m)
        self.block5 = Block(m, m, m)
        self.block6 = Block(m, m, m)
        self.fc_output = nn.Linear(m, output_size)
        self.apply(_init_params)
                
        # self.fc1 = nn.Linear(input_size, 16, bias=True)
        # self.fc2 = nn.Linear(16, 64, bias=True)
        # self.fc3 = nn.Linear(64, 128, bias=True)
        # self.fc4 = nn.Linear(128, 256, bias=True)
        # self.fc5 = nn.Linear(256, 128, bias=True)
        # self.fc6 = nn.Linear(128, 64, bias=True)
        # self.fc7 = nn.Linear(64, 16, bias=True)
        # self.fc8 = nn.Linear(16, output_size, bias=True)
        # self.relu = nn.ReLU()
        # self.apply(_init_params)

    
    def forward(self, x):
    #     out = self.fc1(x)
    #     out = torch.tanh(out)
    #     out = self.fc2(out)
    #     out = torch.tanh(out)
    #     out = self.fc3(out)
    #     out = torch.tanh(out)
    #     out = self.fc4(out)
    #     out = torch.tanh(out)
    #     out = self.fc5(out)
    #     out = torch.tanh(out)
    #     out = self.fc6(out)
    #     out = torch.tanh(out)
    #     out = self.fc7(out)
    #     out = torch.tanh(out)
    #     out = self.fc8(out)


        x = torch.tanh(self.fc_input(x))
        x = self.block1(x)
        x = self.block2(x)
        x = self.block3(x)
        x = self.block4(x)
        x = self.block5(x)
        x = self.block6(x)
        out = self.fc_output(x)
        
        return out
    
    def grad(self, x):
      xclone = x.clone().detach().requires_grad_(True)
      uforward = self.forward(xclone)
      
      grad = autograd.grad(uforward, xclone, grad_outputs=torch.ones_like(uforward), 
                            only_inputs=True, create_graph=True)
      gradx = grad[0][:,0].reshape((-1,1))
      grady = grad[0][:,1].reshape((-1,1))
      return gradx, grady
  
    def laplace(self, x):
      xclone = x.clone().detach().requires_grad_(True)
      uforward = self.forward(xclone)
  
      grad = autograd.grad(uforward, xclone, grad_outputs=torch.ones_like(uforward), 
                        only_inputs=True, create_graph=True)[0]

      gradgradx = autograd.grad(grad[:,0:1], xclone, grad_outputs=torch.ones_like(grad[:,0:1]),
                            only_inputs=True, create_graph=True)[0][:,0:1]
      gradgrady = autograd.grad(grad[:,1:2], xclone, grad_outputs=torch.ones_like(grad[:,1:2]), 
                         only_inputs=True, create_graph=True)[0][:,1:2]

   
      return gradgradx, gradgrady
  
# def _gradient(outputs: Tensor, inputs: Tensor) -> Tensor:
#     grad = autograd.grad(outputs, inputs, grad_outputs=torch.ones_like(
#         outputs), create_graph=True, only_inputs=True)
#     return grad[0]


# def grad(func: Callable[[Tensor], Tensor], x: torch.Tensor) -> Tensor:
#     x_clone = x.clone().detach().requires_grad_(True)
#     fx = func(x_clone)
#     return _gradient(fx, x_clone)


# def div(func_vec: Callable[[Tensor], Tensor], x: torch.Tensor) -> Tensor:
#     x_clone = x.clone().detach().requires_grad_(True)
#     fx_vec = func_vec(x_clone)
#     partial_f1x1 = _gradient(fx_vec[:, 0:1], x_clone)[:, 0:1]
#     partial_f2x2 = _gradient(fx_vec[:, 1:2], x_clone)[:, 1:2]
#     return torch.add(partial_f1x1, partial_f2x2)


# def laplace(func: Callable[[Tensor], Tensor], x: torch.Tensor) -> Tensor:
#     x_clone = x.clone().detach().requires_grad_(True)
#     fx = func(x_clone)
#     grad = _gradient(fx, x_clone)
#     partial_x1x1 = _gradient(grad[:, 0:1], x_clone)[:, 0:1]
#     partial_x2x2 = _gradient(grad[:, 1:2], x_clone)[:, 1:2]
#     return partial_x1x1, partial_x2x2

def mini_batch(X, mini_batch_size = 64, seed = 0):
    # np.random.seed(seed)
    np.random.seed()
    m = X.shape[0]
    mini_batches = []
    permutation = list(np.random.permutation(m))
    shuffle_X = X[permutation]
    
    num_complete_minibatches = int(m//mini_batch_size)
    for i in range(num_complete_minibatches):
        mini_batch_X = shuffle_X[i*mini_batch_size : (i+1)*mini_batch_size]
        mini_batches.append(mini_batch_X)
    if m%num_complete_minibatches != 0:
        mini_batch_X = shuffle_X[num_complete_minibatches*mini_batch_size:]
        mini_batches.append(mini_batch_X)
    return mini_batches

def DirichletWithZeros(model, xbound):
    xbound_x0 = torch.cat((torch.zeros_like(xbound),xbound),dim=1)
    xbound_x1 = torch.cat((np.pi*torch.ones_like(xbound),xbound),dim=1)
    xbound_y0 = torch.cat((xbound,torch.zeros_like(xbound)),dim=1)
    xbound_y1 = torch.cat((xbound,np.pi*torch.ones_like(xbound)),dim=1)
    return model(xbound_x0), model(xbound_x1), model(xbound_y0), model(xbound_y1)

class RitzLoss(nn.Module):
    def __init__(self, beta, f_source):
      super(RitzLoss, self).__init__()
      self.beta = beta
      self.f_source = f_source
      
    def forward(self, xi, Ggradgrad_x1, Ggradgrad_x2, u_x0, u_x1, u_y0, u_y1):
      loss_f = self.f_source(xi).reshape((-1,1))
      loss = torch.square(torch.add((torch.add(Ggradgrad_x1, Ggradgrad_x2)), loss_f))# square是逐项求平方
      
      # Ggrad = torch.add(torch.square(Ggrad_x1),torch.square(Ggrad_x2))
      # loss_g = torch.mul(Ggrad, 0.5)
      u_x0_square = torch.square(u_x0)
      u_x1_square = torch.square(u_x1)
      u_y0_square = torch.square(u_y0)
      u_y1_square = torch.square(u_y1)
      
      # loss_fu = torch.mul(loss_f, ui)
      # loss = torch.sub(loss_g, loss_fu)
      loss = torch.mean(loss)
      loss_bound = torch.add(torch.add(torch.add(u_x0_square,u_x1_square),u_y0_square),u_y1_square)
      loss_bound = torch.mean(loss_bound)
      
      loss = torch.add(loss, loss_bound, alpha = self.beta)
      # loss = torch.mean(loss)
      return loss      


## begin Fit
model = RitzNN(input_size, output_size)

optimizer = torch.optim.Adam(model.parameters(), lr=learning_rate)
# lossfunction = torch.nn.MSELoss()
lossfunction=RitzLoss(beta, f_source)

lossitem = np.zeros([num_epochs,1])
error = np.zeros([num_epochs,1])

NTest=100
x_test = torch.linspace(0, long_x, NTest)
y_test = torch.linspace(0, long_y, NTest)
X,Y = torch.meshgrid(x_test, y_test)
X = X.reshape((-1,1))
Y = Y.reshape((-1,1))
x = torch.zeros(NTest*NTest,2)
## mesh point
x=torch.cat((X,Y),dim=1)

u_exact = u(x[:,0],x[:,1]).reshape((-1,1))
u_exact = u_exact.detach().numpy()
u_exact = u_exact.reshape((-1,1))

X_re = X.reshape((NTest,NTest))
Y_re = Y.reshape((NTest,NTest))

## all data
xi_all = long_x * torch.rand(N_Gauss, 2)
xbound_all = long_y * torch.rand(N_Gauss_bound, 1)

for epoch in range(num_epochs):
    mini_batches_xi = mini_batch(xi_all, mini_batch_size = BatchSize)
    mini_batches_xbound = mini_batch(xbound_all, mini_batch_size = BatchSize)
    loss_epoch = 0
    for i in range(len(mini_batches_xi)):
        xi = mini_batches_xi[i]
        xbound = mini_batches_xbound[i]
        
        Ggradgrad_x1, Ggradgrad_x2= model.laplace(xi)
        u_x0, u_x1, u_y0, u_y1 = DirichletWithZeros(model, xbound)
        
        loss = lossfunction(xi, Ggradgrad_x1, Ggradgrad_x2, u_x0, u_x1, u_y0, u_y1)
        optimizer.zero_grad()
        loss.backward()
        optimizer.step()
        loss_epoch += loss.item()
    lossitem[epoch]= loss_epoch/(len(mini_batches_xi))

## 每过10步输出一次误差图, 以此来观察训练过程
    if (epoch+1) % 10 == 0:
      print ('Epoch [{}/{}], Loss: {:.10f}' 
             .format(epoch+1, num_epochs, loss.item()))
      u_test = model(x)

      u_exact_re= u_exact.reshape((NTest,NTest))

      u_test_re = u_test.reshape((NTest,NTest))

      u_test = u_test.detach().numpy()
      u_test_re = u_test_re.detach().numpy()
      
      fig = plt.figure()

      axes = Axes3D(fig)
      axes.plot_surface(X_re, Y_re, u_test_re,cmap='rainbow')
      plt.title('$u_{test}$')
      #plt.show()

#    error[epoch]=np.linalg.norm(u_test-u_exact)
#    print ('error[epoch]',error[epoch])

## u_test in the mesh point x
u_test = model(x)

u_exact_re= u_exact.reshape((NTest,NTest))

u_test_re = u_test.reshape((NTest,NTest))

u_test = u_test.detach().numpy()
u_test_re = u_test_re.detach().numpy()

#error = u_test-u_exact
#error_re = error.reshape(NTest,NTest)

fig = plt.figure()
axes = Axes3D(fig)
axes.plot_surface(X_re, Y_re, u_test_re,cmap='rainbow')
plt.title('$u_{test}$')
plt.show()

fig = plt.figure()
axes = Axes3D(fig)
axes.plot_surface(X_re, Y_re, u_exact_re,cmap='rainbow')
plt.title('$u_{exact}$')
plt.show()

fig = plt.figure()
axes = Axes3D(fig)
axes.plot_surface(X_re, Y_re, u_exact_re-u_test_re,cmap='rainbow')
plt.title('$err$')
plt.show()

#error = np.linalg.norm(u_exact-u_test,2)
