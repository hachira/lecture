'''
Pandas Data Series and Data Frames.
'''
import pandas as pd
import numpy as np

students = ["Culsoo", "Yeonghee", "Minjae", "Nayeon", "Mansoo", "Yongtae"]
subjects = ["Korean", "English", "Math"]
nr, nc = len(students), len(subjects)

#   여기서 데이터프레임을 생성 난수를 이용해서 점수표 완성
score = pd.DataFrame(np.random.randint(50, 101, nr*nc).reshape(nr, nc),
                     index=students, columns=subjects)

#   세 과목을 더해서 새로운 컬럼 total에 넣는다
score["total"] = score["Korean"] + score["English"] + score["Math"]

print(score)

#   세 과목의 합을 통해서 평균을 구한다
score["avg"] = np.floor(score["total"]/3).astype(int)

print(score)

# dictionary로 매핑 데이터를 만들어서 groupby로 집계
st2cl = { "Culsoo":"A", "Yeonghee":"B", "Minjae":"C", "Mansoo":"A",
          "Yongtae":"B", "Nayeon":"A" }
r = score.groupby(st2cl).mean()
