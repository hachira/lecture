'''
13-1 Web site crawling
링크들을 모아서 사이트 전체를 크롤링하고,
div class="area_view" 안의 내용을 단어별로 자르고,
빈도를 계산하여 그래프로 그리도록 한다
'''
from urllib.request import urlopen
from bs4 import BeautifulSoup
import re

#  베이스 URL을 설정
baseUrl = "https://sdev.tistory.com/"

#   링크를 저장할 자료구조를 생성(중복제거 목적도 포함)
links = { baseUrl }

#   방문해야할 링크를 리스트로 관리(큐를 사용하는 게 더 나음)
toVisit = [ baseUrl ]

#   크롤링할 횟수 제한을 위해 remain 변수 선언
remain = 10

#   자주 쓰는 정규 표현식을 위해서 전처리
wpattern = re.compile(r"\w+")

#   wpattern에 의해서 수집된 단어들을 저장할 변수 선언
words = [ ]

#   크롤링을 위한 while 루프
while len(toVisit) > 0 and remain > 0:
    #   web page 접속하여 html 문서를 읽어온다
    url = toVisit.pop()
    remain -= 1
    print("Crawling %s..."%url)
    with urlopen(url) as f:
        soup = BeautifulSoup(f, "html.parser")


    #   링크들을 수집한다
    for link in soup.find_all("a"):
        #   href 속성이 없다면 무시
        if not link.has_attr("href"): continue

        #   href 속성을 가져온다
        r = link.get("href")

        #   #으로 시작하는 것은 내부 페이지 링크이므로 무시
        if r.startswith("#"): continue
    
        #   #이 중간에 있는 경우 # 이후의 링크 삭제
        t = r.find("#")
        if t != -1: r = r[:t]

        #   /으로 시작하는 경우에는 base url을 앞에 붙이자
        if r.startswith("/"): r = baseUrl + r[1:]

        #   base url로 시작하지 않는 링크는 무시한다
        if not r.startswith(baseUrl): continue

        #   불필요한 링크들 제거
        if r.startswith(baseUrl+"manage"): continue
        if r.startswith(baseUrl+"tag"): continue
        if r.startswith(baseUrl+"rss"): continue
        if r.startswith(baseUrl+"archive"): continue

        #   이미 등록된 링크라면, 무시
        if r in links: continue
        links.add(r)

        #   방문해야할 곳 추가
        toVisit.append(r)
        
    #   컨텐츠에 있는 단어들을 수집
    divs = soup.findAll("div", { "class" : "area_view" })
    if len(divs)==0: continue
    for s in wpattern.findall(divs[0].text):
        if len(s) < 4: continue
        words.append(s)
    
