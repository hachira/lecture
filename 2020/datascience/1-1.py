"""
  Lecture 1-1
"""

# "Hello World!"를 화면에 출력한다
print("Hello World!")

# a+b의 결과를 출력한다
a = 3
b = 5
print(a+b)

# 두개의 문자열 연산 예제
s1 = "Hello "
s2 = "World!"
print(s1+s2)

# 줄바꿈
twoline = "My name is Changrak.\nAnd You?"
print(twoline)

# List
print("List Example")
list = [ 1, 2, 3, 5 ]
print(list[0])

# Loop (for)
print("Loop Example 1")
for i in range(1, 10, 2):
    print(i)

# Loop (for)
print("Loop Example 2")
for i in list:
    print(i)

# 1부터 n까지 합 구하기
n = int(input("Enter a number : "))
sum = 0
for i in range(1, n+1):
    sum = sum + i
print("sum from 1 to %d is %d"%(n, sum))

# print문 꾸미기
print("[%s], [%10d], [%.3f]"%("NAME", 321, 3.141592))

# if문
a = int(input("Enter a : "))
if a == 1:
    print("a is one.")
else:
    print("a is not one.")

