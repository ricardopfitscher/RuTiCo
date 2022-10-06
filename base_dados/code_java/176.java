
// Java implementation to insert value in sorted way 
// in a sorted doubly linked list 
import
java.io.*; 
import
java.util.*; 

// Node of a doubly linked list 
class
Node 
{ 

int
data; 

Node next, prev; 
} 

class
GFG 
{ 


// function to create and return a new node 

// of a doubly linked list 

static
Node getNode(
int
data) 

{ 

// allocate node 

Node newNode = 
new
Node(); 


// put in the data 

newNode.data = data; 

newNode.prev = newNode.next = 
null
; 

return
newNode; 


} 


// function to insert a new node in sorted way in 

// a sorted doubly linked list 

static
Node sortedInsert(Node head, Node newNode) 

{ 

Node current; 


// if list is empty 

if
(head == 
null
) 

head = newNode; 


// if the node is to be inserted at the beginning 

// of the doubly linked list 

else
if
(head.data >= newNode.data) 

{ 

newNode.next = head; 

newNode.next.prev = newNode; 

head = newNode; 

} 


else

{ 

current = head; 


// locate the node after which the new node 

// is to be inserted 

while
(current.next != 
null
&& 

current.next.data < newNode.data) 

current = current.next; 


/* Make the appropriate links */

newNode.next = current.next; 


// if the new node is not inserted 

// at the end of the list 

if
(current.next != 
null
) 

newNode.next.prev = newNode; 


current.next = newNode; 

newNode.prev = current; 


} 

return
head; 

} 


// function to print the doubly linked list 

static
void
printList(Node head) 

{ 

while
(head != 
null
) 

{ 

System.out.print(head.data + 
" "
); 

head = head.next; 

} 


} 


// Driver code 

public
static
void
main(String args[]) 

{ 

/* start with the empty doubly linked list */

Node head = 
null
; 


// insert the following nodes in sorted way 

Node new_node = getNode(
8
); 

head = sortedInsert(head, new_node); 

new_node = getNode(
5
); 

head = sortedInsert(head, new_node); 

new_node = getNode(
3
); 

head = sortedInsert(head, new_node); 

new_node = getNode(
10
); 

head = sortedInsert(head, new_node); 

new_node = getNode(
12
); 

head = sortedInsert(head, new_node); 

new_node = getNode(
9
); 

head = sortedInsert(head, new_node); 


System.out.println(
"Created Doubly Linked List"
); 

printList(head); 

} 
} 

// This code is contributed by rachana soma 