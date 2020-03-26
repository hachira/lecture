# 문자열을 입력받습니다
s = input("Enter the string : ")

"""
# 입력된 문자열을 공백을 기준으로 나누어서 리스트로 만든다
fruits = s.split()
print(fruits)
b = "-".join(fruits)
print(b)
c = b.count("-")
print(c)
"""

"""
# strip 함수는 공백을 제거하는 역할을 합니다
rs = s.rstrip()
ls = s.lstrip()
ss = s.strip()
print("original=[%s], rstrip=[%s], lstrip=[%s], strip=[%s]"%(s, rs, ls, ss))
"""

"""
# predicate functions
print(s.isupper())
print(s.islower())
print(s.isspace())
print(s.isdigit())
"""

"""
# 대소문자 변환
print(s.upper())
print(s.lower())
"""

