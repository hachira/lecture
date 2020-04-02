#   파일로부터 HTML 문서를 읽고, BeautifulSoup 객체화
from bs4 import BeautifulSoup

#   3-2.html 문서를 열어서 그 내용을 BeautifulSoup 객체로 저장한다.
with open("3-2.html") as f:
    soup = BeautifulSoup(f, "html.parser")

print(soup.prettify())
