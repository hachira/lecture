'''
데이터 정렬하기
'''
import pandas as pd

population = pd.read_csv("locations.csv", index_col=["country", "year"])
print("=== sort by index ===")
print(population.sort_index().head(10))
print("=== sort by population ===")
print(population.sort_values("population", ascending=False).head(10))
print("=== ranks ===")
print(population.rank(numeric_only=True, ascending=False).head(30))
ranks = population.rank(numeric_only=True, ascending=False).sort_values("population")
print(ranks.head(10))
