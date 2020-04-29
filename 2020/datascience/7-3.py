'''
데이터 합치기 - 결합
'''
import pandas as pd
import numpy as np

# 두개의 데이터프레임을 생성한다.
left = pd.DataFrame(np.random.randn(3, 3),
                    index=["Apple", "Banana", "Mango"],
                    columns=["C1", "C2", "C3"])
right = pd.DataFrame(np.random.randn(3, 3),
                    index=["Apple", "Mango", "Tomato"],
                    columns=["R1", "R2", "R3"])


# 두개의 데이터프레임의 index를 리셋하고, index를 기준으로 결합하게 한다
print(pd.merge(left.reset_index(), right.reset_index()).set_index("index"))

# join()을 이용해서 여러가지 출력결과 확인
print("== left join ==")
print(left.join(right))
print("== right join ==")
print(left.join(right, how="right"))
print("== inner join ==")
print(left.join(right, how="inner"))
print("== outer join ==")
print(left.join(right, how="outer"))

'''
데이터 붙이기
'''
right = pd.DataFrame(np.random.randn(3, 3),
                    index=["Apple", "Mango", "Tomato"],
                    columns=["C1", "C2", "R1"])
print(pd.concat([left, right]))
