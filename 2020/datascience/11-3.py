'''
11-3.py
Draw graphs with pyplot
'''
import matplotlib.pyplot as plt
import matplotlib
import numpy as np

'''
# list를 하나 주고 그림 그리기
plt.plot([1, 3, 7, 11, 15, 21])

# list를 쌍으로 주고 그림 그리기
plt.plot([1, 2, 3, 5, 7], [1, 4, 9, 19, 23])

# x-label & y-label 그리기
plt.xlabel("x-label")
plt.ylabel("y-label")
'''

'''
# 3개의 그래프를 그린다
x = [k for k in range(1, 11)]
y = [k**2 for k in range(1, 11)]
s = ["bs-", "<-.", "+:"]
for i in range(0, 3):
    plt.plot(x, [k+i*10 for k in y], s[i])

# 그래프 범위를 (0, 11), (0, 120)으로 설정
plt.axis([0, 11, 0, 120])
'''

'''
# make a x data
x = np.arange(-5, 5, 0.1)

# 다양한 그래프를 그린다
plt.plot(x, 5*x, "--", x, x**2, x, 0.2*x**3, "+")
'''
'''
# Use Solarize_Light2 theme style.
matplotlib.style.use("ggplot")
fig, ax = plt.subplots(2, 2)
x = np.arange(0, 10)
y1 = np.random.randint(1, 10, 10)
y2 = np.random.randint(0, 10, 100)
p = np.array([30, 20, 10, 5])
ax[0, 0].bar(x, y1)
ax[0, 1].scatter(x, y1)
ax[1, 0].hist(y2)
ax[1, 1].pie(p, labels=["A", "B", "C", "D"])
'''
cities=["Seoul", "Busan", "Daejeon"]
y = np.arange(2000, 2020, dtype=int)
min, max = 0, 0
for c in cities:
    t = np.random.randn(20).cumsum()
    plt.plot(y, t, "o-")
    plt.annotate(s=c, xy=(2020, t[19]))
    if min > t.min(): min = t.min()
    if max < t.max(): max = t.max()
plt.axis([1999, 2024, min-1, max+3])
plt.title("City growth")
plt.xlabel("year")
plt.ylabel("growth")
plt.legend(cities)

# 현재까지 그려진 그래프를 표시하기
plt.show()









