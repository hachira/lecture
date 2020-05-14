'''
9-1.py Read csv file
'''
import pandas as pd

# header는 없고, names로 컬럼이름을 설정하고,
# ffill()로 결측치를 처리.
'''
account = pd.read_csv("lecture9-1.csv",
                      header=None,
                      names=["date", "money"],
                      thousands=",").ffill()
print(account)
'''
'''
account = pd.read_csv("lecture9-1.tsv",
                      header=None,
                      names=["date", "money"],
                      sep="\t").ffill()
print(account)

# account.money를 숫자로 바꾼다
account.money = account.money.str.replace(",", "").astype(int)
print(account.groupby("date").sum())
'''

# 덩어리(chunk) 단위로 읽고 데이터를 처리한다.
chunks = pd.read_csv("lecture9-1.csv",
                     header=None,
                     names=["date", "money"],
                     chunksize=3)
total = 0
for k in chunks:
    print("-----------")
    print(k)
    total += k.money.str.replace(",","").astype(int).sum()
print("total money %s"%total)
