from sys import argv 
print("How old are you?", end=' ')
age = input()
print("How tall are you?", end=' ')
height = input() # 增加的
print("How much do you weigh?", end=' ') # 补上了右括号
weight = input()

print(f"So, you're {age} old, {height} tall and {weight} heavy.")

script, filename = argv # 需要补上 `from sys import argv`

txt = open(filename)

print(f"Here's your file {filename}:") #补上 f
print(txt.read()) # 补全命令

print("Type the filename again:")
file_again = input("> ")

txt_again = open(file_again)

print(txt_again.read()) # 修改命令


print('Let\'s practice everything.') # escape sequence
print("""You\'d need to know \'bout escapes 
      with \\ that do \n newlines and \t tabs.""") # 单引号变双引号

poem = """
\tThe lovely world
with logic so firmly planted
cannot discern \n the needs of love
nor comprehend passion from intuition
and requires an explanation
\n\t\twhere there is none.
"""

print("--------------")
print(poem)
print("--------------")


five = 10 - 2 + 3 - 6 
print(f"This should be five: {five}")

def secret_formula(started):
    jelly_beans = started * 500
    jars = jelly_beans / 1000
    crates = jars / 100
    return jelly_beans, jars, crates


start_point = 10000
beans, jars, crates = secret_formula(start_point)

# remember that this is another way to format a string
print("With a starting point of: {}".format(start_point))
# it's just like with an f"" string
print(f"We'd have {beans} beans, {jars} jars, and {crates} crates.")

start_point = start_point / 10

print("We can also do that this way:")
formula = secret_formula(start_point)
# this is an easy way to apply a list to a format string
print("We'd have {} beans, {} jars, and {} crates.".format(*formula)) # *是什么意思？



people = 20
cats = 30
dogs = 15


if people < cats:
    print ("Too many cats! The world is doomed!")

if people >= cats:
    print("Not many cats! The world is saved!")

if people < dogs:
    print("The world is drooled on!")

if people > dogs:
    print("The world is dry!")


dogs += 5

if people >= dogs:
    print("People are greater than or equal to dogs.")

if people <= dogs:
    print("People are less than or equal to dogs.")

if people == dogs:
    print("People are dogs.")