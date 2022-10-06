
/* Java implementation to remove duplicates from a 

sorted doubly linked list */
public
class
removeDuplicatesFromSortedList { 


/* function to remove duplicates from a 

sorted doubly linked list */

public
static
void
removeDuplicates(Node head) 

{ 

/* if list is empty */

if
(head== 
null
) 

return
; 


Node current = head; 

while
(current.next != 
null
) 

{ 

/* Compare current node with next node */

if
(current.data == current.next.data) 

/* delete the node pointed to by 

' current->next' */

deleteNode(head, current.next); 


/* else simply move to the next node */

else

current = current.next; 

} 


/* traverse the list till the last node */

while
(current.next != 
null
) 

{ 


/* Compare current node with next node */

if
(current.data == current.next.data) 

/* delete the node pointed to by 

'current->next' */

deleteNode(head, current.next); 


/* else simply move to the next node */

else

current = current.next; 

} 

} 



/* Function to delete a node in a Doubly Linked List. 

head_ref --> pointer to head node pointer. 

del --> pointer to node to be deleted. */

public
static
void
deleteNode(Node head, Node del) 

{ 

/* base case */

if
(head==
null
|| del==
null
) 

{ 

return
; 

} 

/* If node to be deleted is head node */

if
(head==del) 

{ 

head=del.next; 

} 

/* Change next only if node to be deleted 

is NOT the last node */

if
(del.next!=
null
) 

{ 

del.next.prev=del.prev; 

} 

/* Change prev only if node to be deleted 

is NOT the first node */

if
(del.prev != 
null
) 

del.prev.next = del.next; 


} 



/* Function to insert a node at the beginning 

of the Doubly Linked List */

public
static
Node push(Node head, 
int
data) 

{ 

/* allocate node */

Node newNode=
new
Node(data); 

/* since we are adding at the begining, 

prev is always NULL */

newNode.prev=
null
; 

/* link the old list off the new node */

newNode.next =head; 

/* change prev of head node to new node */

if
(head!=
null
) 

{ 

head.prev=newNode; 

} 

head=newNode; 

return
head; 

} 


/* Function to print nodes in a given doubly linked list */

public
static
void
printList(Node head) 

{ 

if
(head == 
null
) 

System.out.println(
"Doubly Linked list empty"
); 


while
(head != 
null
) 

{ 

System.out.print(head.data+
" "
) ; 

head = head.next; 

} 

} 


public
static
void
main(String args[]) { 

Node head=
null
; 

head=push(head, 
12
); 

head=push(head, 
12
); 

head=push(head, 
10
); 

head=push(head, 
8
); 

head=push(head, 
8
); 

head=push(head, 
6
); 

head=push(head, 
4
); 

head=push(head, 
4
); 

head=push(head, 
4
); 

head=push(head, 
4
); 


System.out.println(
"Original Doubly LinkedList"
); 

printList(head); 


/* remove duplicate nodes */

removeDuplicates(head); 

System.out.println(
"\nDoubly linked list after removing duplicates:"
); 

printList(head); 

} 
} 
class
Node 
{ 

int
data; 

Node next,prev; 


Node(
int
data) 

{ 

this
.data=data; 

next=
null
; 

prev=
null
; 

} 
} 
//This code is contributed by Gaurav Tiwari 