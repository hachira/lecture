#numpy library
import numpy as np

'''
numbers1 = np.array(range(1, 11))
print(numbers1)

numbers2 = np.arange(1, 11)
print(numbers2)

#y = x^2
x = np.arange(1, 11)
y = x**2
print(y)

xl = [k for k in range(1, 11)]
yl = [k**2 for k in xl]
print(yl)

#nth dimension array
mat = np.array( [ [1, 2, 3], [4, 5, 6], [7, 8, 9], [10, 11, 12] ] )
print(mat.ndim)
print(mat.shape)
print(mat)

#reshape
mat1 = mat.reshape(3, 2, 2)
print(mat1.ndim)
print(mat1.shape)
print(mat1)
'''

'''
#indexing
x = np.array([ -3, 1, 2, 5, -1, 6 ])
cz = x < 0
print(cz)

#cz에 True로 지정된 원소만 주어진 연산 수행
x[cz] = 0
print(x)
'''

#broadcasting
x = np.arange(1, 11, 2)
y = np.arange(2, 11, 2)
print(x)
print(y)
print(x+y)
print(x*y)
print(x*y+y)
