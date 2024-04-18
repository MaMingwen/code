import tensorflow as tf
from keras.datasets import mnist
from keras import models
from keras import layers
from keras.utils import to_categorical

# load mnist dataset in Keras
(train_images, train_labels), (test_images, test_labels) = mnist.load_data()

## training data
print(train_images.shape)
print(train_labels.shape)
print(len(train_images.shape))
print(len(train_labels.shape))

## test data
print(test_images.shape)
print(test_labels)
print(len(test_labels))

# The network architecture
network = models.Sequential()
network.add(layers.Dense(512 , activation = 'relu', input_shape=(28*28,)))
network.add(layers.Dense(10 , activation = 'softmax'))

# The compilation steps
network.compile(optimizer = 'rmsprop' ,
                loss = 'categorical_crossentropy' ,
                metrics = ['accuracy'])

# preparing the image data
train_images = train_images.reshape((60000 , 28*28))
train_images = train_images.astype('float32') / 255

test_images = test_images.reshape((10000 , 28*28))
test_images = test_images.astype('float32') / 255

# preparing the labels
train_labels = to_categorical(train_labels)
test_labels = to_categorical(test_labels)

# train (FIT)
network.fit(train_images, train_labels, epochs=5, batch_size=128)

# perform on test data
test_loss, test_acc = network.evaluate(test_images, test_labels)
print(test_loss , test_acc)