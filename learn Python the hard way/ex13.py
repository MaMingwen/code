from sys import argv
# read the WYSS section for how to run this
script, first, second, third = argv

print("The script is called:", script)

print("Your first variable is:", first)
print("Your sencond variable is:", second)
print("Your third variable is:", third)

print(len(argv))

x = input('?')