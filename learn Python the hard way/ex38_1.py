list = ['温', '良', '恭', '俭', '让', '仁']

list_more = ['仁', '义', '礼', '智', '信']

while len(list) != 10:
    middle = list_more.pop()
    print("list内元素不足十个，新添加元素：", middle)
    list.append(middle)

print(list[1])
print(list[-1])
print(' '.join(list))
print('#'.join(list[3:5]))
