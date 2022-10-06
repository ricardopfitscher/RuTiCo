
/* Java implementation to delete a doubly Linked List node 

at the given position */

// A node of the doubly linked list 
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

// Function to delete a node in a Doubly Linked List. 

// head_ref --> pointer to head node pointer. 

// del --> pointer to node to be deleted. 

static
Node deleteNode(Node head, Node del) 

{ 

// base case 

if
(head == 
null
|| del == 
null
) 

return
null
; 


// If node to be deleted is head node 

if
(head == del) 

head = del.next; 


// Change next only if node to be 

// deleted is NOT the last node 

if
(del.next != 
null
) 

del.next.prev = del.prev; 


// Change prev only if node to be 

// deleted is NOT the first node 

if
(del.prev != 
null
) 

del.prev.next = del.next; 


del = 
null
; 


return
head; 

} 


// Function to delete the node at the 

// given position in the doubly linked list 

static
void
deleteNodeAtGivenPos(Node head, 
int
n) 

{ 

/* if list in NULL or invalid position is given */

if
(head == 
null
|| n <= 
0
) 

return
; 


Node current = head; 

int
i; 


/* 

* traverse up to the node at position 'n' from the beginning 

*/

for
(i = 
1
; current != 
null
&& i < n; i++) 

{ 

current = current.next; 

} 


// if 'n' is greater than the number of nodes 

// in the doubly linked list 

if
(current == 
null
) 

return
; 


// delete the node pointed to by 'current' 

deleteNode(head, current); 

} 


// Function to insert a node 

// at the beginning of the Doubly Linked List 

static
Node push(Node head, 
int
new_data) 

{ 

// allocate node 

Node new_node = 
new
Node(); 


// put in the data 

new_node.data = new_data; 


// since we are adding at the beginning, 

// prev is always NULL 


new_node.prev = 
null
; 


// link the old list off the new node 

new_node.next = head; 


// change prev of head node to new node 

if
(head != 
null
) 

head.prev = new_node; 


// move the head to point to the new node 

head = new_node; 


return
head; 

} 


// Function to print nodes in a 

// given doubly linked list 

static
void
printList(Node temp) 

{ 

if
(temp == 
null
) 

System.out.print(
"Doubly Linked list empty"
); 


while
(temp != 
null
) 

{ 

System.out.print(temp.data + 
" "
); 

temp = temp.next; 

} 

System.out.println(); 

} 


// Driver code 

public
static
void
main(String[] args) 

{ 

// Start with the empty list 

Node head = 
null
; 


// Create the doubly linked list: 

// 2<->2<->10<->8<->4<->2<->5<->2 


head = push(head, 
2
); 

head = push(head, 
5
); 

head = push(head, 
4
); 

head = push(head, 
8
); 

head = push(head, 
10
); 


System.out.println(
"Doubly linked list before deletion:"
); 

printList(head); 


int
n = 
2
; 


// delete node at the given position 'n' 

deleteNodeAtGivenPos(head, n); 

System.out.println(
"Doubly linked list after deletion:"
); 

printList(head); 

} 
} 

// Thia code is contributed by Vivekkumar Singh 