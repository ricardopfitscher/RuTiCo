
// Java program to find n'th node in linked list 
// using recursion 
class
GFG 
{ 

/* Link list node */
static
class
Node 
{ 

int
data; 

Node next; 

Node(
int
data) 

{ 

this
.data = data; 

} 
} 

/* Given a reference (pointer to pointer) to 

the head of a list and an int, push a 

new node on the front of the list. */
static
Node push( Node head, 
int
new_data) 
{ 

/* allocate node */

Node new_node = 
new
Node(new_data); 


/* put in the data */

new_node.data = new_data; 


new_node.next = head; 


head=new_node; 


return
head; 
} 

/* Takes head pointer of the linked list and index 

as arguments and return data at index*/
static
int
GetNth( Node head, 
int
n) 
{ 

int
count = 
1
; 


//if count equal too n return node.data 

if
(count == n) 

return
head.data; 


//recursively decrease n and increase 

// head to next pointer 

return
GetNth(head.next, n - 
1
); 
} 

/* Driver code*/
public
static
void
main(String args[]) 
{ 

/* Start with the empty list */

Node head = 
null
; 


/* Use push() to con below list 

1.12.1.4.1 */

head=push(head,
1
); 

head=push(head,
4
); 

head=push(head,
1
); 

head=push(head,
12
); 

head=push(head,
1
); 


/* Check the count function */

System.out.printf(
"Element at index 3 is %d"
, 

GetNth(head, 
3
)); 
} 
} 
// This code is contributed by Arnab Kundu 