'''
csv file to database
'''
import csv
import pymysql
import re

#   숫자 패턴
dpattern = re.compile(r"\d+")

#   weather.csv 파일을 읽어오자
data = []
with open("weather.csv") as f:
    weather = csv.reader(f)
    first = True
    for k in weather:
        if first:
            first = False
            continue
        t = []
        t.append(k[0])
        print(k[0])
        for i in range(1, 5):
            t.append(int(dpattern.findall(k[i])[0]))
        t.append(float(k[5][:-3]))
        data.append(t)

# mysql connect
conn = pymysql.connect(host="localhost", port=3306, user="dbuser",
                       passwd="blabla", db="lecture")

# database write
with conn.cursor() as cur:
    sql = "insert into weather values(%s, %s, %s, %s, %s, %s)"
    for k in data:
        cur.execute(sql, (k[0], k[1], k[2], k[3], k[4], k[5]))

conn.commit()
