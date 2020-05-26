'''
11-1.py : NetworkX with attributes
'''
import networkx as nx
import matplotlib.pyplot as plt

# Make a new graph(G)
G = nx.Graph()

# Add nodes with attribute "pos"
G.add_node("Seoul", pos=(2, 8), capital=True)
G.add_node("Incheon", pos=(1, 8), port=True)
G.add_node("Cheonan", pos=(3, 7))
G.add_node("Gangneung", pos=(5, 8), port=True)
G.add_node("Daejeon", pos=(3, 6))
G.add_node("Jeonju", pos=(2, 5))
G.add_node("Gwangju", pos=(1, 4))
G.add_node("Jeju", pos=(1,1), port=True)
G.add_node("Daegu", pos=(4, 4))
G.add_node("Busan", pos=(5, 3), port=True)

# Add edges with attribute "weight"
G.add_edge("Seoul", "Incheon", weight=1)
G.add_edges_from([("Seoul", "Cheonan"), ("Seoul", "Gangneung"),
                  ("Cheonan", "Daejeon"), ("Daejeon", "Jeonju"),
                  ("Jeonju", "Gwangju"), ("Daejeon", "Daegu"),
                  ("Daegu", "Busan")], weight=3)
G["Seoul"]["Gangneung"]["weight"]=5

pos=nx.get_node_attributes(G, "pos")
nx.draw_networkx(G, pos)
weight=nx.get_edge_attributes(G, "weight")
nx.draw_networkx_edge_labels(G, pos, edge_labels=weight)
plt.show()
print(G.nodes(data=True))
print(G.edges(data=True))
print("Port cities")
print(nx.get_node_attributes(G, "port"))


