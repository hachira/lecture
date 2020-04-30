'''
중복 데이터 제거
'''
import pandas as pd
import numpy as np

df1 = pd.DataFrame(np.random.randn(3, 3), index=["Apple", "Banana", "Mango"])
df2 = pd.DataFrame(np.random.randn(3, 3), index=["Apple", "Mango", "Tomato"])
df3 = pd.DataFrame(np.random.randn(3, 3), index=["Orange", "Mango", "Pineapple"])

newdf = pd.concat([df1, df2, df3]).reset_index()
print(newdf)

# 중복된 데이터 제거
print("== keep=first ==")
print(newdf.drop_duplicates(subset=["index"], keep="first"))
print("== keep=last ==")
print(newdf.drop_duplicates(subset=["index"], keep="last"))
print("== keep=False ==")
print(newdf.drop_duplicates(subset=["index"], keep=False))
