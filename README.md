# Word Break Problem

[![Build Status](https://travis-ci.org/MasterOfTheU/word-break-problem.svg?branch=master)](https://travis-ci.org/MasterOfTheU/word-break-problem)
[![codecov](https://codecov.io/gh/MasterOfTheU/word-break-problem/branch/master/graph/badge.svg)](https://codecov.io/gh/MasterOfTheU/word-break-problem)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/2af4c0e58cc74efc8b307899932ebadc)](https://www.codacy.com/app/MasterOfTheU/word-break-problem?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=MasterOfTheU/word-break-problem&amp;utm_campaign=Badge_Grade)
[![Codacy Badge](https://api.codacy.com/project/badge/Coverage/2af4c0e58cc74efc8b307899932ebadc)](https://www.codacy.com/app/MasterOfTheU/word-break-problem?utm_source=github.com&utm_medium=referral&utm_content=MasterOfTheU/word-break-problem&utm_campaign=Badge_Coverage)

The words.txt file contains a sorted list of approximately 173,000 words. The words are listed one word per line, do not contain spaces, and are all lowercase.

### What we have to find
- the longest concatenated word (that is, the longest word that is comprised entirely of
shorter words in the file)
- the 2nd longest concatenated word
- the total count of all the concatenated words in the file

### HashSet as perfect data structure or <em>Why Am I Not Using Tries</em>
In this project I used HashSet as a data structure to contain a list of words 
because according to Big O complexity table 
- It has O(1) lookup time while trees have O(m) where <strong>m</strong> depends on the length of the string we are looking up;
- In some cases tries require much more space than hashset because memory can be allocated for each string character
while in hashset it is a single chunk of memory for the whole string entry;
- Imagine that the alphabet is not 26 english characters but 136,690 Unicode symbols. That means
that each node of tree will represent 136,690 symbols. Here we are moving to the conclusion that
complexity grows from O(m) to O(alphabet_size x key_length x N) where <strong>N</strong> is number of keys in Trie.
Sounds not that nice, uh? Tries just can't work fast on big input alphabets.

### Gathered metrics & results
![snap1](https://user-images.githubusercontent.com/15348166/32571707-1153af76-c4d1-11e7-9642-3c614d260682.PNG)
