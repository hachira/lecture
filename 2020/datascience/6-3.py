'''
배열에서 unique(x) 함수를 이용해서 셋 형태로 만들기
'''
import numpy as np

dna = "AGTCCGCGATACAGGCTCGGT"
dna_list = list(dna)
print(dna_list)
dna_array = np.array(dna_list)
print(dna_array)

dna_set = np.unique(dna_array)
print(dna_set)
