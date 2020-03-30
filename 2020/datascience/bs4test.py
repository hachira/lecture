from bs4 import BeautifulSoup

"""
print("--------------")
html = '''<HTML><HEAD><TITLE>Title</TITLE></HEAD>
<BODY>
<H1>What is Python</H1>
I don't know.
</BODY></HTML>
'''
soup = BeautifulSoup(html, "html.parser")
print(soup.get_text())
"""

"""
print("---------------")
with open("a.html", mode="r", encoding="utf-8") as f:
    html = ""
    for s in f.readlines():
        html += s
soup = BeautifulSoup(html, "html.parser")
print(soup.prettify())
"""

"""
from urllib.request import urlopen
print("---------------")
html = urlopen("https://sdev.tistory.com/")
soup = BeautifulSoup(html, "html.parser")
links = [link["href"] for link in soup.find_all("a")]
for k in links:
    print(k)
"""

import csv
with open("a.csv") as f:
    frozen = list(csv.reader(f))
print(frozen)
