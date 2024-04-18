from turtle import shape
import numpy as np

# dot operator
# z = np.dot(x , y)
## vector_dot
def naive_vector_dot(x,y) :
    assert len(x.shape) == 1
    assert len(y.shape) == 1
    assert x.shape[0] == y.shape[0]
    z = 0.
    for i in range(x.shape[0]) :
        z += x[i]*y[i]
    return z