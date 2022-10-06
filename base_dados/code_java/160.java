
/* Java program to check if linked list is palindrome recursively */

class
LinkedList { 

Node head; 
// head of list 

Node left; 


/* Linked list Node*/

class
Node { 

char
data; 

Node next; 


Node(
char
d) 

{ 

data = d; 

next = 
null
; 

} 

} 


// Initial parameters to this function are &head and head 

boolean
isPalindromeUtil(Node right) 

{ 

left = head; 


/* stop recursion when right becomes NULL */

if
(right == 
null
) 

return
true
; 


/* If sub-list is not palindrome then no need to 

check for current left and right, return false */

boolean
isp = isPalindromeUtil(right.next); 

if
(isp == 
false
) 

return
false
; 


/* Check values at current left and right */

boolean
isp1 = (right.data == (left).data); 


/* Move left to next node */

left = left.next; 


return
isp1; 

} 


// A wrapper over isPalindromeUtil() 

boolean
isPalindrome(Node head) 

{ 

boolean
result = isPalindromeUtil(head); 

return
result; 

} 


/* Push a node to linked list. Note that this function 

changes the head */

public
void
push(
char
new_data) 

{ 

/* Allocate the Node & 

Put in the data */

Node new_node = 
new
Node(new_data); 


/* link the old list off the new one */

new_node.next = head; 


/* Move the head to point to new Node */

head = new_node; 

} 


// A utility function to print a given linked list 

void
printList(Node ptr) 

{ 

while
(ptr != 
null
) { 

System.out.print(ptr.data + 
"->"
); 

ptr = ptr.next; 

} 

System.out.println(
"NULL"
); 

} 


/* Driver program to test the above functions */

public
static
void
main(String[] args) 

{ 

/* Start with the empty list */

LinkedList llist = 
new
LinkedList(); 


char
str[] = { 
'a'
, 
'b'
, 
'a'
, 
'c'
, 
'a'
, 
'b'
, 
'a'
}; 

String string = 
new
String(str); 

for
(
int
i = 
0
; i < 
7
; i++) { 

llist.push(str[i]); 

llist.printList(llist.head); 

if
(llist.isPalindrome(llist.head) != 
false
) { 

System.out.println(
"Is Palindrome"
); 

System.out.println(
""
); 

} 

else
{ 

System.out.println(
"Not Palindrome"
); 

System.out.println(
""
); 

} 

} 

} 
} 

// This code has been contributed by Mayank Jaiswal(mayank_24) 