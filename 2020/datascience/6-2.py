'''
배열의 누적합과 누적곱 표현
'''
import numpy as np

x = np.arange(1, 11)
print("x = %s"%x)
y = np.cumsum(x)
print("y = %s"%y)
z = np.cumprod(x)
print("z = %s"%z)
