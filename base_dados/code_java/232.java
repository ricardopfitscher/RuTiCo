
# Python3 program to find smallest multiple of 
# a given number made of digits 0 and 9 only 
from
queue 
import
Queue 

# Preprocessing function to generate 
# all possible numbers formed by 0 and 9 
def
generateNumbersUtil(): 

global
vec 


# Create an empty queue of strings 

q 
=
Queue() 


# enque the first number 

q.put(
"9"
) 


# This loops is like BFS of a tree 

# with 9 as root, 0 as left child 

# and 9 as right child and so on 

for
count 
in
range
(MAX_COUNT, 
-
1
, 
-
1
): 

s1 
=
q.queue[
0
] 

q.get() 


# storing the front of queue 

# in the vector 

vec.append(s1) 


s2 
=
s1 


# Append "0" to s1 and enqueue it 

s1 
+
=
"0"

q.put(s1) 


# Append "9" to s2 and enqueue it. Note 

# that s2 contains the previous front 

s2 
+
=
"9"

q.put(s2) 

# function to find smallest number made 
# up of only digits 9’s and 0’s, which 
# is a multiple of n. 
def
findSmallestMultiple(n): 

global
vec 


# traverse the vector to find 

# the smallest multiple of n 

for
i 
in
range
(
len
(vec)): 


# int is used for string to 

# conversion 

if
(
int
(vec[i]) 
%
n 
=
=
0
): 

return
vec[i] 

# Driver Code 

# Maximum number of numbers 
# made of 0 and 9 
MAX_COUNT 
=
10000

# stack to store all numbers that 
# can be formed using digits 0 and 
# 9 and are less than 10^5 
vec 
=
[] 
generateNumbersUtil() 
n 
=
7
print
(findSmallestMultiple(n)) 

# This code is contributed by PranchalK 