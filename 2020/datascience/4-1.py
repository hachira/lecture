import nltk
wn = nltk.corpus.wordnet
#  cat에 대한 유의어 리스트
cset = wn.synsets("cat")
print(cset)
#  cat.n.01에 대한 상의어와 하의어
print(wn.synset("cat.n.01").hypernyms())
print(wn.synset("cat.n.01").hyponyms())

#  cat 과 dog의 단어 관련도
x = wn.synset("cat.n.01")
y = wn.synset("lion.n.01")
print(x.path_similarity(y))
