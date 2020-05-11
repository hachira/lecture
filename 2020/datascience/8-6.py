'''
8-6 교차 집계
'''
import pandas as pd
import numpy as np

students=["Student"+str(k) for k in range(1,101)]
subjects=["Korean", "English", "Math"]
nr, nc = len(students), len(subjects)

score=pd.DataFrame(np.random.randint(50, 101, nr*nc).reshape(nr, nc),
                   index=students,
                   columns=subjects)

# 각각의 과목 평균이 넘는 학생들의 경우 True가 되게 한다
kor = score["Korean"] > score["Korean"].mean()
eng = score["English"] > score["English"].mean()
mat = score["Math"] > score["Math"].mean()

# 국어와 영어 점수간의 상관관계
print(pd.crosstab(kor, eng))

# 3과목 분석
print(pd.crosstab(kor, [eng, mat]))
