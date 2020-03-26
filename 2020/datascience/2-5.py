# regular expression
# 정규표현식을 파이썬에서 사용하기 위해서는 re 모듈을 포함해야 한다
# \w : 숫자와 영문자
# \d : 숫자
# \W : 숫자와 영문자 제외
# \D : 숫자 제외
import re
r = re.findall(r"(?:ca)\w*t", "abc 35 cat ct caat 123ab rope u34574p")
print(r)
