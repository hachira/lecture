'''
Lecture 10-1
NetworkX를 사용하여 네트웍 데이터 사용하기
'''
#   networkx와 matplotlib.pyplot 모듈을 import
import networkx as nx
import matplotlib.pyplot as plt
import pandas as pd

#   Make a new graph
g = nx.Graph()
g.add_nodes_from( ("Japan", "England", "Austraillia") )
g.add_edge("South Korea", "North Korea")
g.add_edges_from( (
    ("North Korea", "China"),
    ("China", "Russia"),
    ("North Korea", "Russia"),
    ("China", "India"),
    ("China", "Thai"),
    ("China", "Vietnam"),
    ("Thai", "Laos") ) )
g.add_edges_from( (
    ("France", "Spain"),
    ("Spain", "Portugal"),
    ("France", "Belgium"),
    ("Belgium", "Netherland"),
    ("France", "Italy") ) )
g.add_edges_from( (
    ("United States", "Canada"),
    ("United States", "Mexico"),
    ("Mexico", "Guatemala") ) )

#   Draw Graph
nx.draw_networkx(g)
plt.show()

#   nodes & edges
'''
print("Total nodes is %s"%(len(g)))
print(g.nodes())
print(g.edges())
print(list(g.neighbors("China")))
'''

#   degree를 계산한 결과를 pandas의 dataframe으로 옮겨서 작업
'''
degrees = pd.DataFrame(list(g.degree()),
        columns=("country", "degree")).set_index("country")
print(degrees.sort_values("degree", ascending=False).head(10))
'''

#   clustering 계수를 계산하고 출력
'''
cc = nx.clustering(g)
for k in cc:
    print("%s  %s"%(k, cc[k]))
'''

#   component 리스트 계산
'''
comps = list(nx.connected_components(g))
for k in comps:
    print(k)
'''

#   중심성을 계산한 결과를 출력
print("North Korea : %.2f"%nx.degree_centrality(g)["North Korea"])
print(nx.closeness_centrality(g))
print(nx.betweenness_centrality(g))
print(nx.eigenvector_centrality(g))




