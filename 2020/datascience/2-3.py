from collections import Counter
s = input("Enter the string : ")
words = s.split()
print(words)
# words에 있는 문자열들의 빈도를 카운팅
cntr = Counter(words)
d = dict(cntr)
print(d)



