i = 0
numbers = []

while i < 6:
    print(f"At the top i is {i}") # top
    numbers.append(i)

    i = i + 1
    print("Numbers now: ", numbers)
    print(f"At the bottom i is {i}") # bottom

# Conver the while-loop to a function

i = 0
numbers = []
j = 6
def while_loop(i, numbers, j):
    
    print(f"At the top i is {i}") # top
    numbers.append(i)

    i = i + 1
    print("Numbers now: ", numbers)
    print(f"At the bottom i is {i}") # bottom
    if i < j:
        return while_loop(i, numbers, j)

while_loop(i, numbers, j)

print(i, numbers, j)
# Use `for-loops` and `range`.

numbers = []
j = 0
for i in range(0,6): # 在这一步 i 被从新赋值。
    print(f"At the top i is {i}") # top
    numbers.append(i)

    print("Numbers now: ", numbers)
    print(f"At the bottom i is {i}") # bottom


print("The numbers: ")

for num in numbers:
    print(num)