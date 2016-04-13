"""
Assignment 3. Implement a Multinomial Naive Bayes classifier for spam filtering.

You'll only have to implement 3 methods below:

train: compute the word probabilities and class priors given a list of documents labeled as spam or ham.
classify: compute the predicted class label for a list of documents
evaluate: compute the accuracy of the predicted class labels.

"""

from collections import defaultdict
import glob
import math
import os



class Document(object):
    """ A Document. Do not modify.
    The instance variables are:

    filename....The path of the file for this document.
    label.......The true class label ('spam' or 'ham'), determined by whether the filename contains the string 'spmsg'
    tokens......A list of token strings.
    """

    def __init__(self, filename=None, label=None, tokens=None):
        """ Initialize a document either from a file, in which case the label
        comes from the file name, or from specified label and tokens, but not
        both.
        """
        if label: # specify from label/tokens, for testing.
            self.label = label
            self.tokens = tokens
        else: # specify from file.
            self.filename = filename
            self.label = 'spam' if 'spmsg' in filename else 'ham'
            self.tokenize()

    def tokenize(self):
        self.tokens = ' '.join(open(self.filename).readlines()).split()


class NaiveBayes(object):

    def get_word_probability(self, label, term):
        """
        Return Pr(term|label). This is only valid after .train has been called.

        Params:
          label: class label.
          term: the term
        Returns:
          A float representing the probability of this term for the specified class.

        >>> docs = [Document(label='spam', tokens=['a', 'b']), Document(label='spam', tokens=['b', 'c']), Document(label='ham', tokens=['c', 'd'])]
        >>> nb = NaiveBayes()
        >>> nb.train(docs)
        >>> nb.get_word_probability('spam', 'a')
        0.25
        >>> nb.get_word_probability('spam', 'b')
        0.375
        """
        ###TODO
        return self.final_dict[term][label]

    def get_top_words(self, label, n):
        """ Return the top n words for the specified class, using the odds ratio.
        The score for term t in class c is: p(t|c) / p(t|c'), where c'!=c.

        Params:
          labels...Class label.
          n........Number of values to return.
        Returns:
          A list of (float, string) tuples, where each float is the odds ratio
          defined above, and the string is the corresponding term.  This list
          should be sorted in descending order of odds ratio.

        >>> docs = [Document(label='spam', tokens=['a', 'b']), Document(label='spam', tokens=['b', 'c']), Document(label='ham', tokens=['c', 'd'])]
        >>> nb = NaiveBayes()
        >>> nb.train(docs)
        >>> nb.get_top_words('spam', 2)
        [(2.25, 'b'), (1.5, 'a')]
        """
        ###TODO
        neglabel = ""
        probs_array = []
        if(label == "spam"):
            neglabel = "ham"
        elif(label == "ham"):
            neglabel = "spam"
        
        for i in self.final_dict:            
            if self.final_dict[i][neglabel] > 0:
                probs_array.append((float(self.final_dict[i][label])/self.final_dict[i][neglabel],i))
                
        return sorted(probs_array, key=lambda x: x[0],reverse=True)[0:n]

    def train(self, documents):
        """
        Given a list of labeled Document objects, compute the class priors and
        word conditional probabilities, following Figure 13.2 of your
        book. Store these as instance variables, to be used by the classify
        method subsequently.
        Params:
          documents...A list of training Documents.
        Returns:
          Nothing.
        """
        ###TODO
        ###############
        token_values_arr = []
        spam_count = 0
        ham_count = 0
        self.prior_probs = {'spam':0.0, 'ham':0.0}
        
        for i in documents:
                if(i.label == "spam"):
                    spam_count = spam_count + 1
                elif(i.label == "ham"):
                    ham_count = ham_count + 1
        
        self.prior_probs['spam'] = spam_count/len(documents)
        self.prior_probs['ham'] = ham_count/len(documents)
        
        ################
        for i in documents:
            for j in i.tokens:
                token_values_arr.append(j)
        token_values_set = set(token_values_arr)
    
        doc_count = 0
        tot_ham_ct = 0
        tot_spam_ct = 0
        table_values = defaultdict(lambda:defaultdict(lambda:0.0))
        spam_token_dict = defaultdict(lambda:0.0)
        ham_token_dict = defaultdict(lambda:0.0)
        for i in documents:
            doc_count = doc_count + 1
            for j in i.tokens:
                if(i.label == "spam"):
                    spam_token_dict[j] = spam_token_dict[j] + 1
                elif(i.label == "ham"):
                    ham_token_dict[j] = ham_token_dict[j] + 1
                table_values[doc_count][j] = table_values[doc_count][j] + 1
            table_values[doc_count]['total'] = sum(table_values[doc_count].values()) 
            table_values[doc_count]['lab'] = i.label
            if(table_values[doc_count]['lab'] == "spam"):
                tot_spam_ct = tot_spam_ct + table_values[doc_count]['total']
            elif(table_values[doc_count]['lab'] == "ham"):
                tot_ham_ct = tot_ham_ct + table_values[doc_count]['total']
        self.final_dict = defaultdict(lambda:defaultdict(lambda:0.0))
        for i in token_values_set:
            self.final_dict[i]['spam'] = float(spam_token_dict[i] + 1.0) / (tot_spam_ct + len(token_values_set) * 1.0) 
            self.final_dict[i]['ham'] = float(ham_token_dict[i] + 1.0) / (tot_ham_ct + len(token_values_set) * 1.0)

    def classify(self, documents):
        """ Return a list of strings, either 'spam' or 'ham', for each document.
        Params:
          documents....A list of Document objects to be classified.
        Returns:
          A list of label strings corresponding to the predictions for each document.
        """
        ###TODO
        final_array = []   
        for i in documents :
            value_of_spam = math.log10(self.prior_probs['spam'])
            value_of_ham = math.log10(self.prior_probs['ham'])
            for j in i.tokens:
                if (self.final_dict[j]['spam'] > 0):
                    value_of_spam = value_of_spam + math.log10(self.final_dict[j]['spam'])
                if (self.final_dict[j]['ham'] > 0):
                    value_of_ham = value_of_ham + math.log10(self.final_dict[j]['ham'])
            if value_of_spam > value_of_ham:
                final_array.append('spam')
            else:
                final_array.append('ham')
        return final_array

def evaluate(predictions, documents):
    """ Evaluate the accuracy of a set of predictions.
    Return a tuple of three values (X, Y, Z) where
    X = percent of documents classified correctly
    Y = number of ham documents incorrectly classified as spam
    X = number of spam documents incorrectly classified as ham

    Params:
      predictions....list of document labels predicted by a classifier.
      documents......list of Document objects, with known labels.
    Returns:
      Tuple of three floats, defined above.
    """
    ###TODO
    X = 0.0
    Y = 0.0
    Z = 0.0
    
    doc_len = len(documents)
    for i in range(doc_len):
        if documents[i].label == 'ham' and predictions[i] == 'spam':
            Y = Y + 1
        elif documents[i].label ==  'spam' and predictions[i] == 'ham':
            Z = Z + 1

    temp = doc_len - (Y+Z)
    X = float(temp)/doc_len
    
    return (X,Y,Z)
    

def main():
    """ Do not modify. """
    if not os.path.exists('train'):  # download data
       from urllib.request import urlretrieve
       import tarfile
       urlretrieve('http://cs.iit.edu/~culotta/cs429/lingspam.tgz', 'lingspam.tgz')
       tar = tarfile.open('lingspam.tgz')
       tar.extractall()
       tar.close()
    train_docs = [Document(filename=f) for f in glob.glob("train/*.txt")]
    print('read', len(train_docs), 'training documents.')
    nb = NaiveBayes()
    nb.train(train_docs)
    test_docs = [Document(filename=f) for f in glob.glob("test/*.txt")]
    print('read', len(test_docs), 'testing documents.')
    predictions = nb.classify(test_docs)
    results = evaluate(predictions, test_docs)
    print('accuracy=%.3f, %d false spam, %d missed spam' % (results[0], results[1], results[2]))
    print('top ham terms: %s' % ' '.join('%.2f/%s' % (v,t) for v, t in nb.get_top_words('ham', 10)))
    print('top spam terms: %s' % ' '.join('%.2f/%s' % (v,t) for v, t in nb.get_top_words('spam', 10)))

if __name__ == '__main__':
    main()
