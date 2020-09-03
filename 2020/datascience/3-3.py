#   웹페이지로부터 HTML 파싱을 하고, BeautifulSoup 객체 생성
from bs4 import BeautifulSoup
from urllib.request import urlopen

html = urlopen("https://sdev.tistory.com/553")
soup = BeautifulSoup(html, "html.parser")
#print(soup.prettify())
#print(soup.get_text())

#   <pre> tag를 찾아서 pres에 저장한다.
pres = soup.find_all("pre")
for s in pres:
    print(s)

#   모든 링크를 가져오자.
links = [(link.string, link["href"])
         for link in soup.find_all("a")
         if link.has_attr("href")]
for s in links:
    print(s)

