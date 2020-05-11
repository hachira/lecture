'''
8-5, Data Frame Cut & QCut
'''
import pandas as pd
import numpy as np

students = [ "Cheolsoo", "Mandu", "Bona", "Jaein",
             "Kicheol", "Younghee", "Dongwoo", "Mina" ]
subjects = [ "Korean", "English", "Math" ]

nr, nc = len(students), len(subjects)

score = pd.DataFrame(np.random.randint(50, 101, nr*nc).reshape(nr, nc),
                     index=students, columns=subjects)

# 점수 구간을 5개로 나누어서 점수를 매긴다
print(score["Korean"])
#print(pd.cut(score["Korean"], 5, labels=["F", "D", "C", "B", "A"]))

# 점수 구간을 5개로 나누되, 구간값을 정해서 매긴다
#bins = [ 0, 56, 70, 80, 90, 100 ]
#print(pd.cut(score["Korean"], bins, labels=["F", "D", "C", "B", "A"]))

# 분위의 수 별로 나누어서 점수를 매긴다
print(pd.qcut(score["Korean"], 5, labels=["F", "D", "C", "B", "A"]))
