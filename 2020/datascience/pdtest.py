import pandas as pd
import numpy as np
x = pd.DataFrame(np.random.randn(3, 3),
                 index=["Apple", "Banana", "Mango"], 
                 columns=["C1", "C2", "C3"])
y = pd.DataFrame(np.random.randn(3, 2),
                 index=["Apple", "Pear", "Tomato"], 
                 columns=["C1", "R1"])
z = pd.concat([x, y]).reset_index()
print(z.drop_duplicates(subset=["index"]))
