import pandas as pd
import numpy as np

covid = pd.read_csv("covid19.csv", index_col="country")
print(covid.groupby("continentExp").sum()["cases"])
