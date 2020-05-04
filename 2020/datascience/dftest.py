import pandas as pd
import numpy as np

students = ["Cheolsoo", "Minsik", "Jaein", "Yeonghee", "Mansoo", "Mina"]
subjects = ["Korean", "English", "Mathematics"]
nr, nc = len(students), len(subjects)
score = pd.DataFrame(np.random.randint(50, 100, nr*nc).reshape(nr, nc),
                     index=students,
                     columns=subjects)
st2cl = { "Cheolsoo" : "classA", "Minsik" : "classA", "Jaein" : "classB",
          "Yeonghee" : "classA", "Mansoo" : "classB", "Mina" : "classB" }
print(score.groupby(st2cl).mean())
