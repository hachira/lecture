"""
# split, join
s = input("Enter the string : ")
# 전화번호 입력을 .을 이용해서 구분된 것을 -로 바꾸도록 한다
ss = s.split(".")
print(ss)
sj = "-".join(ss)
print(sj)
print("-".join(s.split(".")))
"""
# tuple and list
"""
t = (1, 3, 5, 8)
print(t[0])
t[0] = 2
"""
"""
t = [1, 3, 5, 8]
print(t[0])
t[0] = 2
"""
"""
# 리스트 내포
a = [ i*i for i in range(1,11) ]
print(a)
"""
"""
# Open a file and read lines.
f = open("2-4.txt", mode="r")
lines = f.readlines()
f.close()
for x in lines:
    t = [ k.lower() for k in x.split() ]
    print(t)
"""
"""
# with open을 이용해서 파일 읽기
with open("2-4.txt", mode="r") as f:
    lines = f.readlines()
print(lines)
"""
"""
# 입력을 받아서 파일에 내용 쓰기
with open("2-4w.txt", mode="w") as f:
    for i in range(1, 11):
        x = input("Enter a string : ")
        f.write(x)
"""
# naver 웹페이지를 열어보고 그 내용을 출력해보자
# urlopen 함수를 사용하려면, urllib.request 모듈이 필요하다
import urllib.request
with urllib.request.urlopen("http://www.naver.com") as hdoc:
    html = hdoc.read()
r = html.split()
for i in range(0, 10):
    print(r[i])







