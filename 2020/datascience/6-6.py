"""
csv 파일로부터 데이터를 읽어서,
데이터프레임(data frame) 자료를 만들고,
인덱싱 처리
"""
import pandas as pd

population = pd.read_csv("locations.csv", index_col="country")
print(population)

# 인덱스에 해당 원소가 있는지 검사
if "North_Korea" in population.index:
    print(population.loc["South_Korea"])
else:
    print("North_Korea is not exist.")

# reindexing
r = population.reindex(index=list(population.index)+["North_Korea"],
                       columns=["year", "population", "area"])
print(r)

if "North_Korea" in r.index:
    print(r.loc["North_Korea"])
else:
    print("North_Korea is not exist.")
