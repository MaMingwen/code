from sys import argv # module, later explained

script, filename = argv # 输入文件名

txt = open(filename) # open 文件

print(f"Here's your file {filename}:") # 输出
print(txt.read()) # 读取并输出

print("Type the filename again: ") # 输出
file_again = input("> ") # 输出并接受输入

txt_again = open(file_again) # open 文件

print(txt_again.read()) # 读取并输出

# txt.close()
# txt_again.close()
