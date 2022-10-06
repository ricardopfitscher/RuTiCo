
// Java program to segregate even and odd nodes in a 
// Linked List 
class
LinkedList 
{ 

Node head; 
// head of list 


/* Linked list Node*/

class
Node 

{ 

int
data; 

Node next; 

Node(
int
d) 

{ 

data = d; 

next = 
null
; 

} 

} 


void
segregateEvenOdd() 

{ 

Node end = head; 

Node prev = 
null
; 

Node curr = head; 


/* Get pointer to last Node */

while
(end.next != 
null
) 

end = end.next; 


Node new_end = end; 


// Consider all odd nodes before getting first eve node 

while
(curr.data %
2
!=
0
&& curr != end) 

{ 

new_end.next = curr; 

curr = curr.next; 

new_end.next.next = 
null
; 

new_end = new_end.next; 

} 


// do following steps only if there is an even node 

if
(curr.data %
2
==
0
) 

{ 

head = curr; 


// now curr points to first even node 

while
(curr != end) 

{ 

if
(curr.data % 
2
== 
0
) 

{ 

prev = curr; 

curr = curr.next; 

} 

else

{ 

/* Break the link between prev and curr*/

prev.next = curr.next; 


/* Make next of curr as null */

curr.next = 
null
; 


/*Move curr to end */

new_end.next = curr; 


/*Make curr as new end of list */

new_end = curr; 


/*Update curr pointer */

curr = prev.next; 

} 

} 

} 


/* We have to set prev before executing rest of this code */

else
prev = curr; 


if
(new_end != end && end.data %
2
!= 
0
) 

{ 

prev.next = end.next; 

end.next = 
null
; 

new_end.next = end; 

} 

} 


/* Given a reference (pointer to pointer) to the head 

of a list and an int, push a new node on the front 

of the list. */

void
push(
int
new_data) 

{ 

/* 1 & 2: Allocate the Node & 

Put in the data*/

Node new_node = 
new
Node(new_data); 


/* 3. Make next of new Node as head */

new_node.next = head; 


/* 4. Move the head to point to new Node */

head = new_node; 

} 


// Utility function to print a linked list 

void
printList() 

{ 

Node temp = head; 

while
(temp != 
null
) 

{ 

System.out.print(temp.data+
" "
); 

temp = temp.next; 

} 

System.out.println(); 

} 



/* Drier program to test above functions */

public
static
void
main(String args[]) 

{ 

LinkedList llist = 
new
LinkedList(); 

llist.push(
11
); 

llist.push(
10
); 

llist.push(
8
); 

llist.push(
6
); 

llist.push(
4
); 

llist.push(
2
); 

llist.push(
0
); 

System.out.println(
"Origional Linked List"
); 

llist.printList(); 


llist.segregateEvenOdd(); 


System.out.println(
"Modified Linked List"
); 

llist.printList(); 

} 
} 
/* This code is contributed by Rajat Mishra */