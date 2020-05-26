'''
11-2.py : Networkx, clique and isolate
'''
import networkx as nx
import matplotlib.pyplot as plt

# Make a new Graph.
G = nx.Graph()
G.add_nodes_from(["Japan", "England", "Austrailia"])
G.add_edges_from([("South Korea", "North Korea"),
                  ("North Korea", "China"),
                  ("North Korea", "Russia"),
                  ("China", "Russia"),
                  ("France", "Spain"),
                  ("France", "Deuch"),
                  ("Spain", "Portugal")])

nx.draw_networkx(G)
plt.show()

print(list(nx.find_cliques(G)))
print(list(nx.isolates(G)))
