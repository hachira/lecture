# 리스트에 값 넣기
a = [0]*10
for i in range(1, 11):
    a[i-1] = i*i
print(a)

# 리스트 내포 방식으로 리스트에 값 넣기
b = [ i*i for i in range(1, 11) ]
print(b)

# 리스트 내포 방식으로 리스트에 홀수 넣기
c = [ i for i in range(1, 11) if i%2 != 0 ]
print(c)

# 나머지 연산 필요한 내용 정리
k = input("Enter the number : ")
r = int(k)
s = [ i for i in range(1, 101) if i%r == 0 ]
print(s)
