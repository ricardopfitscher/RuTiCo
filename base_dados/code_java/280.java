
// Java program to Find longest subsequence where 
// every character appears at-least k times 

class
GFG { 


static
final
int
MAX_CHARS = 
26
; 


static
void
longestSubseqWithK(String str, 
int
k) { 

int
n = str.length(); 


// Count frequencies of all characters 

int
freq[] = 
new
int
[MAX_CHARS]; 

for
(
int
i = 
0
; i < n; i++) { 

freq[str.charAt(i) - 
'a'
]++; 

} 


// Traverse given string again and print 

// all those characters whose frequency 

// is more than or equal to k. 

for
(
int
i = 
0
; i < n; i++) { 

if
(freq[str.charAt(i) - 
'a'
] >= k) { 

System.out.print(str.charAt(i)); 

} 

} 

} 

// Driver code 

static
public
void
main(String[] args) { 

String str = 
"geeksforgeeks"
; 

int
k = 
2
; 

longestSubseqWithK(str, k); 


} 
} 

// This code is contributed by Rajput-Ji 