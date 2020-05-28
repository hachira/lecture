'''
11-4.py
Plot using pandas
'''
import pandas as pd
import matplotlib.pyplot as plt

covid = pd.read_csv("covid19a.csv",
                    parse_dates=["date"],
                    dayfirst=True)
r = covid.groupby("date").sum().sort_index()

plt.plot(r)
plt.title("Covid-19 cases/deaths")
plt.xlabel("date")
plt.ylabel("persons")
plt.legend(r.columns)

plt.show()
