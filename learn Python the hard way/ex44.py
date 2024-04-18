# Implicit Inheritance
class Parent(object):
    def implict(self):
        print("Parent.implict()")

    def override(self):
        print("Parent.override()")

    def altered(self):
        print("Parent.altered()")

class Child(Parent):
    pass
    def override(self):
        print("Child.override()")

    def altered(self):
        print("Child.altered.before()")
        super(Child, self).altered()
        print("Child.aftered.after()")

Dad = Parent()
Son = Child()

Dad.implict()
Son.implict()
Dad.override()
Son.override()
Dad.altered()
Son.altered()