
// Java code to find a pair with given sum 
// in a Balanced BST 
import
java.util.ArrayList; 

// A binary tree node 
class
Node { 


int
data; 

Node left, right; 


Node(
int
d) 

{ 

data = d; 

left = right = 
null
; 

} 
} 

class
BinarySearchTree { 


// Root of BST 

Node root; 


// Constructor 

BinarySearchTree() 

{ 

root = 
null
; 

} 


// Inorder traversal of the tree 

void
inorder() 

{ 

inorderUtil(
this
.root); 

} 


// Utility function for inorder traversal of the tree 

void
inorderUtil(Node node) 

{ 

if
(node == 
null
) 

return
; 


inorderUtil(node.left); 

System.out.print(node.data + 
" "
); 

inorderUtil(node.right); 

} 


// This method mainly calls insertRec() 

void
insert(
int
key) 

{ 

root = insertRec(root, key); 

} 


/* A recursive function to insert a new key in BST */

Node insertRec(Node root, 
int
data) 

{ 


/* If the tree is empty, return a new node */

if
(root == 
null
) { 

root = 
new
Node(data); 

return
root; 

} 


/* Otherwise, recur down the tree */

if
(data < root.data) 

root.left = insertRec(root.left, data); 

else
if
(data > root.data) 

root.right = insertRec(root.right, data); 


return
root; 

} 


// Method that adds values of given BST into ArrayList 

// and hence returns the ArrayList 

ArrayList<Integer> treeToList(Node node, ArrayList<Integer> 

list) 

{ 

// Base Case 

if
(node == 
null
) 

return
list; 


treeToList(node.left, list); 

list.add(node.data); 

treeToList(node.right, list); 


return
list; 

} 


// method that checks if there is a pair present 

boolean
isPairPresent(Node node, 
int
target) 

{ 

// This list a1 is passed as an argument 

// in treeToList method 

// which is later on filled by the values of BST 

ArrayList<Integer> a1 = 
new
ArrayList<>(); 


// a2 list contains all the values of BST 

// returned by treeToList method 

ArrayList<Integer> a2 = treeToList(node, a1); 


int
start = 
0
; 
// Starting index of a2 


int
end = a2.size() - 
1
; 
// Ending index of a2 


while
(start < end) { 


if
(a2.get(start) + a2.get(end) == target) 
// Target Found! 

{ 

System.out.println(
"Pair Found: "
+ a2.get(start) + 
" + "
+ a2.get(end) + 
" "

+ 
"= "
+ target); 

return
true
; 

} 


if
(a2.get(start) + a2.get(end) > target) 
// decrements end 

{ 

end--; 

} 


if
(a2.get(start) + a2.get(end) < target) 
// increments start 

{ 

start++; 

} 

} 


System.out.println(
"No such values are found!"
); 

return
false
; 

} 


// Driver function 

public
static
void
main(String[] args) 

{ 

BinarySearchTree tree = 
new
BinarySearchTree(); 

/* 

15 

/ \ 

10 20 

/ \ / \ 

8 12 16 25 */

tree.insert(
15
); 

tree.insert(
10
); 

tree.insert(
20
); 

tree.insert(
8
); 

tree.insert(
12
); 

tree.insert(
16
); 

tree.insert(
25
); 


tree.isPairPresent(tree.root, 
33
); 

} 
} 

// This code is contributed by Kamal Rawal 