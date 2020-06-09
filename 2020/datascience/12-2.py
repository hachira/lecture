'''
12-2. Correlation and Skewness
'''
import numpy as np, numpy.random as rnd
import pandas as pd
import matplotlib, matplotlib.pyplot as plt

# 데이터 갯수
N = 100

# 데이터간 상관성을 갖게 하기 위해서 base 설정
base = rnd.randint(20, 90, N)

# 다양한 데이터 생성
df = pd.DataFrame( {
    "Korean" : base,
    "English" : base + rnd.binomial(50, 0.4, N),
    "Math" : 100-base + rnd.randint(0, 20, N),
    "History" : rnd.randint(0, 10, N)**2,
    "Program" : np.abs(base-50)+50+
    rnd.randint(0, 5, N) } )

# correlation and skewness
print(df.corr().round(2))
print(df.skew().round(2))

# plot graphs
matplotlib.style.use("bmh")
_, ax = plt.subplots(2, 2)
ax[0, 0].scatter(df["Korean"], df["English"])
ax[0, 1].scatter(df["Korean"], df["Math"])
ax[1, 0].scatter(df["Korean"], df["History"])
ax[1, 1].scatter(df["Korean"], df["Program"])
plt.show()
