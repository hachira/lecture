'''
NumPy를 이용하여, 조건 연산을 하는 예제 작성
'''
import numpy as np;

arr1 = np.array([ 1, 3, 5, 7, 2, 4, 6, 8 ])
arr2 = np.array([ 1, 2, 3, 4, 5, 6, 7, 8 ])

#   any() 함수는 배열의 원소중 조건이 하나라도 맞으면 True 반환
print("== any() Test ==")
print(np.any(arr1 > 0))
print(np.any(arr1 > 5))
print(np.any(arr1 > 8))

#   all() 함수는 배열의 원소 모두가 조건이 맞아야 True 반환
print("== all() Test ==")
print(np.all(arr1 > 0))
print(np.all(arr1 > 5))
print(np.all(arr1 > 8))

#   where(조건, 참일때, 거짓일때) 함수는 조건에 따라 다른 값을 반영
print("=== where() Test ==")
c = np.where(np.abs(arr1-arr2) > 1, arr1, 0)
print(c)
c = np.where(arr1%2 == 0, arr1, arr2)
print(c)
