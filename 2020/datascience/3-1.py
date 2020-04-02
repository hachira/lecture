# 라이브러리를 import합니다.
from bs4 import BeautifulSoup

#  HTML 문자열을 지정
html = """<HTML>
<HEAD><TITLE>This is a Title</TITLE></HEAD>
<BODY>This is a Body</BODY>
</HTML>"""

#   BeautifulSoup 객체(오브젝트)를 생성한다.
soup = BeautifulSoup(html, "html.parser")

#   BeautifulSoup을 이용해서 예쁘게 출력해본다.
print(soup.prettify())
