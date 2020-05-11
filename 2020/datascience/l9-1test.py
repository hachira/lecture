import pandas as pd

account = pd.read_csv("lecture9-1.csv",
                      header=None,
                      names=("date", "money")).ffill()
print(account)
