from email.policy import strict


line = "abcd?一"
line_encode = line.encode("utf-8", "strict")
print(line.encode("utf-8", "strict"))
print(line_encode.decode("utf-8", "strict"))
