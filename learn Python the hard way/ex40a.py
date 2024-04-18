Mystuff = {'apple': "I AM APPLES!"}
print(Mystuff['apple'])

import mystuff
mystuff.apple()
print(mystuff.tangerine)

class MyStuff(object):
    def __init__(self):
        self.tangerine = "And now a thousand years between"

    def apple(self):
        print("I AM CLASSY APPLES!")


# dict style
Mystuff['apple']

# module style
mystuff.apple()
print(mystuff.tangerine)

# class style
thing = MyStuff()
thing.apple()
print(thing.tangerine)