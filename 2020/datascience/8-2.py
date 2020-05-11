'''
Pandas Data Series and Data Frames.
'''
import pandas as pd
import numpy as np

students = ["Culsoo", "Yeonghee", "Minjae", "Nayeon", "Mansoo", "Yongtae"]
subjects = ["Korean", "English", "Math"]
years = [2017, 2018, 2019]
nr, nc, ny = len(students), len(subjects), len(years)

# students, subjects, years를 이용해서 데이터프레임 생성
score = pd.DataFrame(np.random.randint(50, 100, nr*nc*ny).reshape(nr*ny, nc),
                     index=[
                         [s for s in students for y in years],
                         [y for s in students for y in years]],
                     columns=subjects)

# index 컬럼에 이름을 지정하자
score.rename_axis(["name", "year"], inplace=True)

# index 를 없애고, year에 대해서 그룹을 묶는다
t = score.reset_index()
s = t.groupby("year").mean()

