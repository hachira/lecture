'''
pandas 시리즈 테스트
'''
import pandas as pd
import numpy as np

"""
List는 다양한 자료형을 하나의 자료에 넣을 수 있다
"""
a = [ "pi", 3.141592, 22, 7 ]
b = [ 1.1, 1.3, 1.0, 0.9, 0.8 ]

"""
Series 또는 Numpy의 ndarray는 하나의 자료형만 가능하다
"""
aa = np.array(a)
pa = pd.Series(a)

pb = pd.Series(b)
print(pb)

"""
Dictionary 자료를 이용해서 인덱싱하기
"""
print("Dictionary -> Seires")
pop1 = { 2011 : 3500, 2012 : 3560, 2013 : 3600, 2014 : 3550 }
pop2 = pd.Series(pop1)
print(pop2)
print(pop2.values)
print(pop2.index)

"""
값과 인덱스 값을 따로 지정하여 인덱싱하기
"""
print("Tuples -> Seires")
pop3 = ( 3500, 3560, 3600, 3550 )
pop4 = pd.Series(pop3)
print(pop4)
pop4.index = ( 2011, 2012, 2013, 2014 )
print(pop4)
pop4[2015] = 3500
print(pop4)

"""
인덱스와 컬럼의 이름 지정하기
"""
pop4.name = "population"
pop4.index.name = "year"
print(pop4)



