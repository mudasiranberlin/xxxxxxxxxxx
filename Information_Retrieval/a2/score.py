""" Assignment 2
"""
import abc
from collections import defaultdict
import math

import index


def idf(term, index):
    """ Compute the inverse document frequency of a term according to the
    index. IDF(T) = log10(N / df_t), where N is the total number of documents
    in the index and df_t is the total number of documents that contain term
    t.

    Params:
      terms....A string representing a term.
      index....A Index object.
    Returns:
      The idf value.

    >>> idx = index.Index(['a b c a', 'c d e', 'c e f'])
    >>> idf('a', idx) # doctest:+ELLIPSIS
    0.477...
    >>> idf('d', idx) # doctest:+ELLIPSIS
    0.477...
    >>> idf('e', idx) # doctest:+ELLIPSIS
    0.176...
    """
    ###TODO
    temp_idf = 0.0
    if term in index.doc_freqs:
        temp_idf = math.log10((len(index.documents)*1.0)/index.doc_freqs[term])
    
    return temp_idf

class ScoringFunction:
    """ An Abstract Base Class for ranking documents by relevance to a
    query. """
    __metaclass__ = abc.ABCMeta

    @abc.abstractmethod
    def score(self, query_vector, index):
        """
        Do not modify.

        Params:
          query_vector...dict mapping query term to weight.
          index..........Index object.
        """
        return


class RSV(ScoringFunction):
    """
    See lecture notes for definition of RSV.

    idf(a) = log10(3/1)
    idf(d) = log10(3/1)
    idf(e) = log10(3/2)
    >>> idx = index.Index(['a b c', 'c d e', 'c e f'])
    >>> rsv = RSV()
    >>> rsv.score({'a': 1.}, idx)[1]  # doctest:+ELLIPSIS
    0.4771...
    """

    def score(self, query_vector, index):
        ###TODO
        count = 0
        dict_final = defaultdict(lambda:0.0)
        y = set(query_vector)
        for i in index.documents:
            tot = 0.0
            count = count + 1
            t = y & set(i)
            for j in t:
                tot = tot + idf(j, index)
            dict_final[count] = dict_final[count] + tot  
                
        return dict_final

    def __repr__(self):
        return 'RSV'


class BM25(ScoringFunction):
    """
    See lecture notes for definition of BM25.

    log10(3) * (2*2) / (1(.5 + .5(4/3.333)) + 2) = log10(3) * 4 / 3.1 = .6156...
    >>> idx = index.Index(['a a b c', 'c d e', 'c e f'])
    >>> bm = BM25(k=1, b=.5)
    >>> bm.score({'a': 1.}, idx)[1]  # doctest:+ELLIPSIS
    0.61564032...
    """
    def __init__(self, k=1, b=.5):
        self.k = k
        self.b = b

    def score(self, query_vector, index):
        ###TODO
        dict_final = defaultdict(lambda:0.0)
        count = 0
        x = 1
       
        y = set(query_vector)
        for i in index.documents:
            tf = 0.0
            tot = 0.0
            count = count + 1
            t = y & set(i)
            for j in t:
                z = float(len(i))/index.mean_doc_length
                rsv = idf(j, index)
                
                templi = index.index[j]
                for ea in templi:
                    if ea[0] == x:
                        tf = ea[1]
                        break
                        
                numerator = (self.k + 1) * tf
                denominator = self.k * ( (1 - self.b) + (self.b * z) ) + tf
                tot = tot + (rsv * (float(numerator) / denominator ))
            dict_final[count] = dict_final[count] + tot  
            
            x += 1
                
        return dict_final

    def __repr__(self):
        return 'BM25 k=%d b=%.2f' % (self.k, self.b)


class Cosine(ScoringFunction):
    """
    See lecture notes for definition of Cosine similarity.  Be sure to use the
    precomputed document norms (in index), rather than recomputing them for
    each query.

    >>> idx = index.Index(['a a b c', 'c d e', 'c e f'])
    >>> cos = Cosine()
    >>> cos.score({'a': 1.}, idx)[1]  # doctest:+ELLIPSIS
    0.792857...
    """
    def score(self, query_vector, index):
        ###TODO
        
        dict_8 = defaultdict(lambda : 0)

        N = len(index.documents)
        doc_id = 0
        
        for doc in index.documents:
            doc_id = doc_id + 1
            tempdict = 0.0
            for each in set(doc):
                if each in query_vector:
                    templi = index.index[each]
                    for ea in templi:
                        if ea[0] == doc_id:
                            tf = ea[1]
                            break
                        
                    p = (1 + math.log10(tf)) * math.log10(float(N)/ index.doc_freqs[each])
                    tempdict = tempdict + (query_vector[each] * p)
            
            dict_8[doc_id] = float(tempdict) /index.doc_norms[doc_id]
        return dict_8


    def __repr__(self):
        return 'Cosine'
