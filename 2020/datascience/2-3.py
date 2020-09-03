from collections import Counter

s = input("Enter the string : ")
words = s.split()
cntr = Counter(words)
d = dict(cntr)
print(d)



