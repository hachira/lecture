import pandas as pd
import numpy as np

students = ["Cheolsoo", "Minsik", "Jaein", "Yeonghee", "Mansoo", "Mina"]
subjects = ["Korean", "English", "Mathematics"]
years = [2017, 2018, 2019]
nr, nc, ny = len(students), len(subjects), len(years)
score = pd.DataFrame(np.random.randint(50, 100, nr*nc*ny).reshape(nr*ny, nc),
                     index=[[s for s in students for y in years],
                            [y for s in students for y in years]],
                     columns=subjects)
score.rename_axis(["name", "year"], inplace=True)

t = score.reset_index()
print(t.groupby("year").mean())
