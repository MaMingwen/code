import numpy as np
import matplotlib.pyplot
from keras.datasets import mnist

# scalar : 0D tensor
x_0 = np.array(12)
print(x_0 , x_0.ndim)

# vector : 1D tensor
x_1 = np.array([1 , 2 , 3 , 7])
print(x_1 , x_1.ndim)

# matrices : 2 ranks tensor
x_2 = np.array([[1,3],
                [2,5],
                [5,9]])
print(x_2 , x_2.ndim)

# 3D tensors or higher
x_3 = np.array([[[1,3,42],
                 [4,4,23]],
                [[23,23,24],
                 [3,3,2]]])
print(x_3 , x_3.ndim)

# 3 key attributes of tensor : rank , shape , dtype

(train_images , train_labels) , (test_images , test_labels) = mnist.load_data()

## rank , shape , dtype of train_images
print("train_images' rank , shape and dtype :" ,train_images.ndim , train_images.shape , train_images.dtype)

## display fourth digit
digit = train_images[4]
matplotlib.pyplot.imshow(digit , cmap=matplotlib.pyplot.cm.binary)
matplotlib.pyplot.show()