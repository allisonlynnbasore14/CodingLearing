
import string
import random
import requests

pride_and_prej_full = requests.get('http://www.gutenberg.org/files/1342/1342-0.txt')
print(pride_and_prej_full)

#the function skip_head will take a text as input and process everyline.
#It only breaks out of the loop when the condition of the heading being
#over is reached             
def skip_head(text):
       for line in text:
              if line.startswith(' *** START'):
                     break

def inputline(line, hist):
       #this is the basic function that makes the histogram
       line = line.replace('-',' ')
       line = line.replace('_',' ')
       to_take_off = string.punctuation + string.whitespace
       for word in line.split(): #this divides each word up at the spaces, you can put anything you want to split at, a helpful one would be the \n new line
              word = word.strip(to_take_off)#strip only takes it off the end ig
              word = word.lower() #makes it lower case
              hist[word] = hist.get(word, 0) + 1 #this is a simple way to count the frequencies. get has default to what you se it equal to (this case 0) unless it already has a value. no matter what though, it gets a +1
       #does this really update the hist without returning it?
#This is the one of the main piece of code that is orginally called. It takes the text file
#as an input and outputs the frequency dictiaonry histogram
#This calls two other functions. First it called skip_head which takes out the
#header of the text. Also it calls input line for each line in the text.             
#Intrestingly, the inputline function takes a varibable made in this function
#as an input. it also takes the specific line. I did not know you could just
#call return after you call a function and expect to get the result.

def opening(text, skip_header):
       fin = open(text)
       hist = {}
       if skip_header:
              skip_head(fin)
       for line in fin:
              inputline(line, hist)
       return hist

def commonwords(hist, number = 10):#this makes the second arguemnt optional. It is default to 10
       #takes histogram as input and gives an ordered list of the most commmonly used words
       output = [] # makes a list of tuples which are word and value pairs.
       for word, v in hist.items():
              output.append((v, word)) #Here I am just making a list of all the pairs in the dictioanry, this will keep it so every word is only done once
       output.sort() #this updates the current value of output to be in order
       output.reverse() #this makes it so you get the highest number first
       return output


def total(hist):
       #takes histogram as input and gives the total number of words
       h = hist.values()
       return sum(h)

def unique(his):
       #takes histogram as input and gives the total number unique words
       output = len(his)
       return output
      
def subtracting(his, words):
       output = {}
       for x in his:
              if x not in words:
                     output[x]=None
       return output
       #takes histogram and word list as input and gives the words that are in the words list but not in the histogram list
       #this has to return a dictioanry with the keys as the words and nothing a the values
      
def random_word(hist):
       #this is called 100 times and should use the histogram to use the frequienices to call a random word
       #the correct teminionigies is that the proablity correespondes to its frequency
       the_list = []
       for word, freq in hist.items(): #this is a tuple that calls the values of the histogram dictioanry
              the_list.extend([word]*freq)
       ran = random.choice(the_list)
       return ran
             
def main():
       freq = opening('pride_and_prej_full', skip_header=True) #sends the file to opening function witch processes it and send each line to be processed
       print('Total number of words:' , total(freq)) # prints the total number of words by calling the total function
       print('Number of unique wrods:', unique(freq)) #prints all the unique words by calling the unique function
       t = commonwords(freq)   # this just calls the function commonwords to return the list of most common words in order
       print('The most common words:') # this prints the precurser to the restults
       for num, word in t[0:20]: # since commonwords returns a set of pairs of the word and the respective frequency, this calls a tuble of word and freq and calls the top 20 starting from the beginning 
              print(word, '\t', num) # this just prints the word and number tuple and formats it with a tab
       words_to_compare = opening('words.txt', skip_header=False) #this just opens the word txt for comparrison but we know there is no header so no need to call that function
       diff = subtracting(freq, words_to_compare) #calls the fucntion sub to find all the words that are in the words.txt file but not in the histogram list
       print('These are the words not used in the book:')
       for w in diff.keys(): #calls the word list from the subtracting fucntion
              print(w, end='  ') # formats the words from the sub traction function with spaces on the end of each word
       print('\n\nRandon words:') #formats with two new lines and
       for i in range(100): #calls the random function 100 times
              print(random_word(freq), end='  ') #calls the function and then formats the end
main()
#All of the functions below are from old code before I consulted the book
s = 'Allison.. Basore... ??'
s = s.strip()
s = s.lower()
"""First open text and makes it lower case and cleans it up"""
def testsplit(a):
       r = a.split(' ')
       return r
def countingcode(tobe):
       word = 'olin'
       if word in tobe:
              c = c + 1
              print (c)
             
def takeoutpun(te):
       for r in string.punctuation:
              te = te.replace(r,'')
       return te
def testsplit(a):
       r = a.split(' ')
       print(r)
##                     for x in li.split(' '):
##                     punc_gone = takeoutpun(li)
##                     print (punc_gone)
##