
// Java program to find maximum number to be removed 
// to convert a tree into forest containg trees of 
// even number of nodes 
import
java.util.*; 

class
GFG 
{ 

static
int
N = 
12
,ans; 


static
Vector<Vector<Integer>> tree=
new
Vector<Vector<Integer>>(); 


// Return the number of nodes of subtree having 

// node as a root. 

static
int
dfs( 
int
visit[], 
int
node) 

{ 

int
num = 
0
, temp = 
0
; 


// Mark node as visited. 

visit[node] = 
1
; 


// Traverse the adjacency list to find non- 

// visited node. 

for
(
int
i = 
0
; i < tree.get(node).size(); i++) 

{ 

if
(visit[tree.get(node).get(i)] == 
0
) 

{ 

// Finding number of nodes of the subtree 

// of a subtree. 

temp = dfs( visit, tree.get(node).get(i)); 


// If nodes are even, increment number of 

// edges to removed. 

// Else leave the node as child of subtree. 

if
(temp%
2
!=
0
) 

num += temp; 

else

ans++; 

} 

} 


return
num+
1
; 

} 


// Return the maxium number of edge to remove 

// to make forest. 

static
int
minEdge( 
int
n) 

{ 

int
visit[] = 
new
int
[n+
2
]; 

ans = 
0
; 


dfs( visit, 
1
); 


return
ans; 

} 


// Driven Program 

public
static
void
main(String args[]) 

{ 

int
n = 
10
; 


//set the size of vector 

for
(
int
i = 
0
; i < n + 
2
;i++) 

tree.add(
new
Vector<Integer>()); 


tree.get(
1
).add(
3
); 

tree.get(
3
).add(
1
); 


tree.get(
1
).add(
6
); 

tree.get(
6
).add(
1
); 


tree.get(
1
).add(
2
); 

tree.get(
2
).add(
1
); 


tree.get(
3
).add(
4
); 

tree.get(
4
).add(
3
); 


tree.get(
6
).add(
8
); 

tree.get(
8
).add(
6
); 


tree.get(
2
).add(
7
); 

tree.get(
7
).add(
2
); 


tree.get(
2
).add(
5
); 

tree.get(
5
).add(
2
); 


tree.get(
4
).add(
9
); 

tree.get(
9
).add(
4
); 


tree.get(
4
).add(
10
); 

tree.get(
10
).add(
4
); 


System.out.println( minEdge( n)); 

} 
} 

// This code is contributed by Arnab Kundu 