'''
dataframe에서 결측치를 삭제하는 예제
'''
import pandas as pd
import numpy as np

# data frame을 생성합니다
df = pd.DataFrame(np.random.randn(5, 3), columns=["C1", "C2", "C3"])
print("== Original ==")
print(df)

# 결측치를 강제로 만듭니다
df.iloc[1, 1] = np.nan
df.iloc[2, [0, 1, 2]] = np.nan
print("== 결측치를 만든 결과 ==")
print(df)

# 결측치가 있는 행을 삭제합니다
print("== after drop(how=any) ==")
print(df.dropna())
print("== after drop(how=all) ==")
print(df.dropna(how="all"))
