//https://www.geeksforgeeks.org/select-a-random-number-from-stream-with-o1-space/
//O(n)
import numpy as np

# initializing list
stream = [1, 4, 5, 2, 7]

# using random.choice() to
# get a random number
random_num = np.random.choice(stream)

# printing random number
print("random number is ",random_num)
