import pandas as pd
import numpy as np

students = ["Cheolsoo", "Minsik", "Jaein", "Yeonghee", "Mansoo", "Mina"]
subjects = ["Korean", "English", "Mathematics"]
nr, nc = len(students), len(subjects)
score = pd.DataFrame(np.random.randint(50, 100, nr*nc).reshape(nr, nc),
                     index=students,
                     columns=subjects)
kor = score["Korean"] > score["Korean"].mean()
eng = score["English"] > score["English"].mean()
mat = score["Mathematics"] > score["Mathematics"].mean()
print(pd.crosstab(kor, [eng, mat]))
