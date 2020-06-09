'''
12-1 Lecture Probability and Statistics
'''
import numpy as np
import numpy.random as rnd
import matplotlib.pyplot as plt

data = np.array([1, 1, 2, 2, 3])
bins = [ 0, 2, 4 ]
plt.hist(data, bins)
plt.show()

'''
#   이항 분포로 된 난수들을 생성합니다
data = rnd.binomial(100, 0.4, 1000)
print("Mean : %.2f, Standard Deviation : %.2f"%
      (data.mean(), data.std()))

bins = np.arange(data.min(), data.max()+1, 1)-0.5
plt.hist(data, bins)
plt.show()

#   정규 분포로 된 난수들을 생성합니다
data = rnd.normal(0, 1, 1000)
print("Mean : %.2f, Standard Deviation : %.2f"%
      (data.mean(), data.std()))
bins = np.arange(data.min(), data.max()+1, 0.5)-0.5
plt.hist(data, bins)
plt.show()

#   균등 분포로 된 난수들을 생성합니다
data = rnd.uniform(0, 1, 1000)
print("Mean : %.2f, Standard Deviation : %.2f"%
      (data.mean(), data.std()))
bins = np.arange(data.min()-0.1, data.max()+0.1, 0.1)-0.5
plt.hist(data, bins)
plt.show()
'''
