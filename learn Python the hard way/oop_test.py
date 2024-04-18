import random
from urllib.request import urlopen
import sys

WORD_URL = "http://learncodethehardway.org/words.txt"
WORDS = []

PHRASES = {
    "class %%%(%%%):":
      "Make a class named %%% that is-a %%%.",
    "class %%%(object):\n\tdef __init__(self, ***)" :
      "class %%% has-a __init__ that takes self and *** params.",
    "class %%%(object):\n\tdef ***(self, @@@)":
      "class %%% has-a function *** that takes self and @@@ params. ",
    "*** = %%%()":
      "Set *** to an instance of class %%%.",
    "***.***(@@@)":
      "From *** get the *** function, call it with params self, @@@.",
    "***.*** = '***'":
      "From *** get the *** attribute and set it to '***'."
}

# do they want to drill phrases first
if len(sys.argv) == 2 and sys.argv[1] == "english":
    PHRASE_FIRST = True
else:
    PHARSE_FIRST = False

# load up the words from the website
# readlines() method 返回值是列表
for word in urlopen(WORD_URL).readlines():
    WORDS.append(str(word.strip(), encoding = "utf-8"))


def convert(snippet, phrase):
    class_names = [w.capitalize() for w in # capitalize() method 首字母大写，其余字母小写
                   random.sample(WORDS, snippet.count("%%%"))] # random.sample: 随机取样。 count()计数字符串
    other_names = random.sample(WORDS, snippet.count("***"))
    results = []
    param_names = []

    for i in range(0, snippet.count("@@@")):# range(a, b) 左闭右开
        param_count = random.randint(1,3)# randint(a, b) 左闭右闭
        param_names.append(', '.join(
            random.sample(WORDS, param_count)))# append: 拼接。 join: 插入。返回一个字符串。

    for sentence in snippet, phrase:# `for ... in a, b, c:` :依次取 a, b, c 。
        result = sentence[:] # [:]: 复制

        # fake class names
        for word in class_names:
            result = result.replace("%%%", word, 1) # replace 替代。这里是用word替换%%%，且替换一个。

        # fake other names
        for word in other_names:
            result = result.replace("***", word, 1)

        # fake parameter lists
        for word in param_names:
            result = result.replace("@@@", word, 1)

        results.append(result)

    return results


# keep going until they hit CTRL-D
try:
    while True:
        snippets = list(PHRASES.keys())# .keys() method: 获取字典数据的`索引`。
        random.shuffle(snippets)# shuffle 随机排列列表，并替代原来的列表.

        for snippet in snippets:
            phrase = PHRASES[snippet]
            question, answer = convert(snippet, phrase)
            print(convert(snippet, phrase))
            if PHRASE_FIRST:
                question, answer = answer, question

            print(question)

            input("> ")
            print(f"ANSWER: {answer}\n\n")
except EOFError:
    print("\nBye")    