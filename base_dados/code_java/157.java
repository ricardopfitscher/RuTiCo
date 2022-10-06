
// method can be used to avoid 
// Global variable 'frequency' 

/* Counts the no. of occurences of a node 
(search_for) in a linked list (head)*/
int
count(Node head, 
int
key) 
{ 

if
(head == 
null
) 

return
0
; 

if
(head.data == key) 

return
1
+ count(head.next, key); 

return
count(head.next, key); 
} 

// This code is contributed by rachana soma 