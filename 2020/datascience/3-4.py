#   csv 파일을 읽고 출력하는 프로그램입니다
import csv

with open("3-4.csv", mode="r") as f:
    frozen = list(csv.reader(f))

for row in frozen:
    print(row)

#   2번째 행에 2번째 열 출력
print(frozen[1][1])
