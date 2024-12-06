def read_scores():
    # 初始化一个空列表来存储分数
    scores = []

    print("请输入分数（输入 'a' 结束）：")

    # 持续读取输入直到用户输入 'd'
    while True:
        user_input = input()
        
        if user_input.lower() == 'a':  # 检查输入是否为 'd'
            break
        else:
            try:
                # 将输入转换为整数并添加到分数列表中
                score = int(user_input)
                scores.append(score)
            except ValueError:
                print("请输入一个有效的数字或 'a' 结束。")

    # 计算分数的总和
    total_score = sum(scores)
    print(f"输入的分数之和为: {total_score}")

# 主程序部分
while True:
    read_scores()
    print("重新运行")
#    repeat = input("是否要重新运行该程序？(输入 'y' 重新运行, 其他键退出): ")
#    if repeat.lower() != 'y':
#        break

