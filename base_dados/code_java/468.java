
// Java program to find single cycle components 
// in a graph. 
import
java.util.*; 

class
GFG 
{ 

static
int
N = 
100000
; 

// degree of all the vertices 
static
int
degree[] = 
new
int
[N]; 

// to keep track of all the vertices covered 
// till now 
static
boolean
found[] = 
new
boolean
[N]; 

// all the vertices in a particular 
// connected component of the graph 
static
Vector<Integer> curr_graph = 
new
Vector<Integer>(); 

// adjacency list 
static
Vector<Vector<Integer>> adj_list = 
new
Vector<Vector<Integer>>(); 

// depth-first traversal to identify all the 
// nodes in a particular connected graph 
// component 
static
void
DFS(
int
v) 
{ 

found[v] = 
true
; 

curr_graph.add(v); 

for
(
int
it = 
0
;it < adj_list.get(v).size(); it++) 

if
(!found[adj_list.get(v).get(it)]) 

DFS(adj_list.get(v).get(it)); 
} 

// function to add an edge in the graph 
static
void
addEdge( 
int
src,
int
dest) 
{ 

// for index decrement both src and dest. 

src--; dest--; 

adj_list.get(src).add(dest); 

adj_list.get(dest).add(src); 

degree[src]++; 

degree[dest]++; 
} 

static
int
countSingleCycles(
int
n, 
int
m) 
{ 

// count of cycle graph components 

int
count = 
0
; 

for
(
int
i = 
0
; i < n; ++i) 

{ 


if
(!found[i]) 

{ 

curr_graph.clear(); 


DFS(i); 


// traversing the nodes of the 

// current graph component 

int
flag = 
1
; 

for
(
int
v = 
0
; v < curr_graph.size(); v++) 

{ 

if
(degree[curr_graph.get(v)] == 
2
) 

continue
; 

else

{ 

flag = 
0
; 

break
; 

} 

} 

if
(flag == 
1
) 

{ 

count++; 

} 

} 

} 

return
(count); 
} 

// Driver code 
public
static
void
main(String args[]) 
{ 


for
(
int
i = 
0
; i < N + 
1
; i++) 

adj_list.add(
new
Vector<Integer>()); 


// n->number of vertices 

// m->number of edges 

int
n = 
15
, m = 
14
; 

addEdge( 
1
, 
10
); 

addEdge( 
1
, 
5
); 

addEdge( 
5
, 
10
); 

addEdge( 
2
, 
9
); 

addEdge( 
9
, 
15
); 

addEdge( 
2
, 
15
); 

addEdge( 
2
, 
12
); 

addEdge( 
12
, 
15
); 

addEdge( 
13
, 
8
); 

addEdge( 
6
, 
14
); 

addEdge( 
14
, 
3
); 

addEdge( 
3
, 
7
); 

addEdge( 
7
, 
11
); 

addEdge( 
11
, 
6
); 



System.out.println(countSingleCycles(n, m)); 
} 
} 

// This code is contributed by Arnab Kundu 