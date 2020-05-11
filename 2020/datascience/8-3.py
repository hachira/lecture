'''
covid-19 자료로부터 대륙별 확진자 수 통계내기
'''
import pandas as pd

covid = pd.read_csv("covid19.csv")
print(covid.groupby("continentExp").sum()["cases"])
print(covid.groupby("continentExp").sum()["deaths"])
