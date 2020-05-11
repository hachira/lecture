import pandas as pd

chunks = pd.read_csv("lecture9-1.csv",
                      header=None,
                      names=("date", "money"),
                      chunksize=5)
for it in chunks:
    print("----------")
    print(it)
