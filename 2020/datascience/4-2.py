import nltk
from collections import Counter

#  hamlet book reading
hamlet = nltk.corpus.gutenberg.raw("shakespeare-hamlet.txt")

#  word tokenize
words = nltk.word_tokenize(hamlet)

#  make lower words
words = [w.lower() for w in words]

#  Lancaster Stemmer
ls = nltk.LancasterStemmer()
words = [ls.stem(w)
         for w in words[:1000]
         if w not in nltk.corpus.stopwords.words("english") and w.isalnum()
         ]

#  빈도 계산
freqs = Counter(words)
print(freqs.most_common(10))
