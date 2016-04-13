""" Assignment 2
"""
import abc

import numpy as np


class EvaluatorFunction:
    """
    An Abstract Base Class for evaluating search results.
    """
    __metaclass__ = abc.ABCMeta

    @abc.abstractmethod
    def evaluate(self, hits, relevant):
        """
        Do not modify.
        Params:
          hits...A list of document ids returned by the search engine, sorted
                 in descending order of relevance.
          relevant...A list of document ids that are known to be
                     relevant. Order is insignificant.
        Returns:
          A float indicating the quality of the search results, higher is better.
        """
        return


class Precision(EvaluatorFunction):

    def evaluate(self, hits, relevant):
        """
        Compute precision.

        >>> Precision().evaluate([1, 2, 3, 4], [2, 4])
        0.5
        """
        ###TODO
        return float((len(set(hits) & set(relevant)))) / (len(set(hits) & set(relevant)) + len(set(hits) - set(relevant)))

    def __repr__(self):
        return 'Precision'


class Recall(EvaluatorFunction):

    def evaluate(self, hits, relevant):
        """
        Compute recall.

        >>> Recall().evaluate([1, 2, 3, 4], [2, 5])
        0.5
        """
        ###TODO
        return float((len(set(hits) & set(relevant)))) / (len(set(hits) & set(relevant)) + len(set(relevant) - set(hits)))

    def __repr__(self):
        return 'Recall'


class F1(EvaluatorFunction):
    def evaluate(self, hits, relevant):
        """
        Compute F1.

        >>> F1().evaluate([1, 2, 3, 4], [2, 5])  # doctest:+ELLIPSIS
        0.333...
        """
        ###TODO
        prec = Precision().evaluate(hits, relevant)
        recall = Recall().evaluate(hits, relevant)

        if prec == 0 and recall == 0:
            x = 0
        else:
            x = (float( (2.0 * float(Precision().evaluate(hits, relevant) * Recall().evaluate(hits, relevant))) / (Precision().evaluate(hits, relevant) + Recall().evaluate(hits, relevant)) ))
        return x

    def __repr__(self):
        return 'F1'


class MAP(EvaluatorFunction):
    def evaluate(self, hits, relevant):
        """
        Compute Mean Average Precision.

        >>> MAP().evaluate([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], [1, 4, 6, 11, 12, 13, 14, 15, 16, 17])
        0.2
        """
        ###TODO
        tot = 0.0
        for eachhits in hits:
            if eachhits in relevant:
                tot = tot + Precision.evaluate(self, hits[:(hits.index(eachhits)+1)], relevant)
        return float(tot)/len(relevant)

    def __repr__(self):
        return 'MAP'

