'''
결측치를 채우는 예제
'''
import pandas as pd
import numpy as np

df = pd.DataFrame(np.random.randn(5,3), columns=["C1", "C2", "C3"])
df.iloc[1, 1] = np.nan
df.iloc[2, [0, 1, 2]] = np.nan

# 결측치가 아닌 데이터를 True로 만드는 notnull을 이용해서 비결측치 논리값 저장
clean = df.notnull()
print(clean)

# 비결측치에 대해서 평균값 계산
mean = df[clean].mean()
print(mean)

# 결측치에 대해서 평균값을 이용해서 보정
print(df.fillna(mean))

# 결측치를 가장 최근에 성공한 값으로 복사
print(df.fillna(method="ffill"))

