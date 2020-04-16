#   pymysql 테스트
import pymysql

#   데이터베이스에 접속
conn = pymysql.connect(host="localhost", port=3306, user="dbuser",
                       passwd="blabla", db="lecture")

'''
#   데이터베이스에 명령을 주고받기 위하여 cur이란 핸들 사용
with conn.cursor() as cur:
    sql = "insert into student values(%s, %s)"
    for k in range(11, 21):
        cur.execute(sql, (k, "student"+str(k)))

#   데이터베이스에 작업된 값을 반영한다
conn.commit()
'''

'''
#   데이터베이스로부터 데이터를 읽는다
with conn.cursor() as cur:
    sql = "select * from student"
    cur.execute(sql)
    result = cur.fetchall()
for k in result:
    print("No.=%s, Name=%s"%(k[0],k[1]))
'''

#   입력된 id로 학생 검색
id = int(input("Enter no : "))
with conn.cursor() as cur:
    sql = "select * from student where no=%s"
    cur.execute(sql, id)
    print(cur.fetchall())

#   데이터베이스 접속 종료
conn.close()
    
