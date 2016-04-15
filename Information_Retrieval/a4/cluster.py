"""
Assignment 5: K-Means. See the instructions to complete the methods below.
"""

from collections import Counter
from collections import defaultdict
import gzip
import math

#import numpy as np


class KMeans(object):

    def __init__(self, k=2):
        """ Initialize a k-means clusterer. Should not have to change this."""
        self.k = k

    def cluster(self, documents, iters=10):
        """
        Cluster a list of unlabeled documents, using iters iterations of k-means.
        Initialize the k mean vectors to be the first k documents provided.
        After each iteration, print:
        - the number of documents in each cluster
        - the error rate (the total Euclidean distance between each document and its assigned mean vector), rounded to 2 decimal places.
        See Log.txt for expected output.
        The order of operations is:
        1) initialize means
        2) Loop
          2a) compute_clusters
          2b) compute_means
          2c) print sizes and error
        """
        ###TODO
        self.means = documents[0:self.k]
        self.cluster = defaultdict(lambda : int)
        self.docs = documents
        
        for val in range(iters):
            self.norms = []
            for x in self.means:
                self.norms.append(self.sqnorm(x))
                               
            self.compute_clusters(documents)
                    
            self.fin_clust = defaultdict(lambda:[])
            for z in self.cluster:
                self.fin_clust[self.cluster[z]].append(z)
       
            self.means = self.compute_means()
       
            to_print_array = []
            for k in self.fin_clust:
                to_print_array.append(len(self.fin_clust[k]))
            
            print (to_print_array)
            print (self.error(documents))

    def compute_means(self):
        """ Compute the mean vectors for each cluster (results stored in an
        instance variable of your choosing)."""
        ###TODO
        vector_means = []
        for doc in self.fin_clust.values():
            vec = defaultdict(float)
            for d_id in doc:
                doc_keys = self.docs[d_id].keys()
                for key in self.docs[d_id]:
                    vec[key] = vec[key] + self.docs[d_id][key]
            tot = len(doc)
            x = defaultdict(float)
            for k,v in vec.items():
                x[k] = float(v)/tot
            vec = Counter(x)
            vector_means.append(vec)
        return vector_means 

    def compute_clusters(self, documents):
        """ Assign each document to a cluster. (Results stored in an instance
        variable of your choosing). """
        ###TODO
        for d in range(0, len(documents)):
            maxi = 999999999
            for cid in range(0, len(self.means)):
                dist = self.distance(documents[d], self.means[cid], self.norms[cid])
                if dist < maxi:
                    maxi = dist
                    clust = cid    
            self.cluster[d] = clust

    def sqnorm(self, d):
        """ Return the vector length of a dictionary d, defined as the sum of
        the squared values in this dict. """
        ###TODO
        total = 0.0
        for i in d:
            total = total + (d[i] * d[i])
        return total

    def distance(self, doc, mean, mean_norm):
        """ Return the Euclidean distance between a document and a mean vector.
        See here for a more efficient way to compute:
        http://en.wikipedia.org/wiki/Cosine_similarity#Properties"""
        ###TODO
        AB = 0.0
        for i in doc.keys():
            if i in mean:
                AB = AB + (doc[i] * mean[i])
        return float(math.sqrt(self.sqnorm(doc)  + mean_norm - (AB * 2.0) ))

    def error(self, documents):
        """ Return the error of the current clustering, defined as the total
        Euclidean distance between each document and its assigned mean vector."""
        ###TODO
        sum_1 = 0.0
        for c_id,clust in self.fin_clust.items():
            n = self.sqnorm(self.means[c_id])              
            sum_1 = sum_1 + sum([self.distance(self.docs[dc],self.means[c_id],n) for dc in clust])                        
        return round(sum_1,2)

    def print_top_docs(self, n=10):
        """ Print the top n documents from each cluster. These are the
        documents that are the closest to the mean vector of each cluster.
        Since we store each document as a Counter object, just print the keys
        for each Counter (sorted alphabetically).
        Note: To make the output more interesting, only print documents with more than 3 distinct terms.
        See Log.txt for an example."""
        ###TODO
        for c_id, clust in self.fin_clust.items():
            dict_1 = defaultdict(float)
            m = self.means[c_id]
            nor = self.sqnorm(m)
            for dc in clust:
                if len(set(self.docs[dc].keys())) >= 4:
                    dict_1[dc] = self.distance(self.docs[dc],m,nor)
            sorted_items = [x[0] for x in sorted(dict_1.items(), key=lambda x:x[1])]
            sorted_items = sorted_items[0:n]
            print ('CLUSTER ', c_id)
            for d_id in sorted_items: 
                string = ''
                for word in self.docs[d_id].keys():
                    string += word + ' '
                print (string)


def prune_terms(docs, min_df=3):
    """ Remove terms that don't occur in at least min_df different
    documents. Return a list of Counters. Omit documents that are empty after
    pruning words.
    >>> prune_terms([{'a': 1, 'b': 10}, {'a': 1}, {'c': 1}], min_df=2)
    [Counter({'a': 1}), Counter({'a': 1})]
    """
    ###TODO
    final_list = []
    items_dict = defaultdict(lambda:0.0)
    for i in docs:
        for j in i:
            items_dict[j] = items_dict[j] + 1
    
    for i in docs:
        for j in list(i):
            if items_dict[j] < min_df:
                del i[j]
        if len(i) != 0:
            final_list.append(Counter(i))
    return final_list

def read_profiles(filename):
    """ Read profiles into a list of Counter objects.
    DO NOT MODIFY"""
    profiles = []
    with gzip.open(filename, mode='rt', encoding='utf8') as infile:
        for line in infile:
            profiles.append(Counter(line.split()))
    return profiles


def main():
    profiles = read_profiles('profiles.txt.gz')
    print('read', len(profiles), 'profiles.')
    profiles = prune_terms(profiles, min_df=2)
    km = KMeans(k=10)
    km.cluster(profiles, iters=20)
    km.print_top_docs()

if __name__ == '__main__':
    main()
