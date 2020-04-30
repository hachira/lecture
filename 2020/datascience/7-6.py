'''
데이터의 기술통계(descriptive statistics)
'''
import pandas as pd
import numpy as np

df = pd.DataFrame(np.random.randn(20, 3), columns=["C1", "C2", "C3"])
df.iloc[3, 2] = np.nan
df.iloc[4, [0, 1, 2]] = np.nan
df.iloc[5, 2] = np.nan
df.iloc[[6, 7, 8, 9], 2] = np.nan

print(df)
#print(df.sum())
#print(df.mean())
#print(df.median())
#print(df.std())
#print(df.fillna(df.mean()).std())
print(df.count())
print(df.min())
print(df.max())
