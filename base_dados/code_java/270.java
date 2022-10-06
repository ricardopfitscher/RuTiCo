
// Java implementation of alternate vowel and 
// consonant string 
import
java.util.*; 

class
GFG 
{ 

// 'ch' is vowel or not 
static
boolean
isVowel(
char
ch) 
{ 

if
(ch == 
'a'
|| ch == 
'e'
|| ch == 
'i'
|| 

ch == 
'o'
|| ch ==
'u'
) 

return
true
; 

return
false
; 
} 

// create alternate vowel and consonant string 
// str1[0...l1-1] and str2[start...l2-1] 
static
String createAltStr(String str1, String str2, 

int
start, 
int
l) 
{ 

String finalStr = 
""
; 


// first adding character of vowel/consonant 

// then adding character of consonant/vowel 

for
(
int
i = 
0
, j = start; j < l; i++, j++) 

finalStr = (finalStr + str1.charAt(i)) + 

str2.charAt(j); 

return
finalStr; 
} 

// function to find the required 
// alternate vowel and consonant string 
static
String findAltStr(String str) 
{ 

int
nv = 
0
, nc = 
0
; 

String vstr = 
""
, cstr = 
""
; 

int
l = str.length(); 

for
(
int
i = 
0
; i < l; i++) 

{ 

char
ch = str.charAt(i); 


// count vowels and updaye vowel string 

if
(isVowel(ch)) 

{ 

nv++; 

vstr = vstr + ch; 

} 


// count consonants and update consonant 

// string 

else

{ 

nc++; 

cstr = cstr + ch; 

} 

} 


// no such string can be formed 

if
(Math.abs(nv - nc) >= 
2
) 

return
"no such string"
; 


// remove first character of vowel string 

// then create alternate string with 

// cstr[0...nc-1] and vstr[1...nv-1] 

if
(nv > nc) 

return
(vstr.charAt(
0
) + createAltStr(cstr, vstr, 
1
, nv)); 


// remove first character of consonant string 

// then create alternate string with 

// vstr[0...nv-1] and cstr[1...nc-1] 

if
(nc > nv) 

return
(cstr.charAt(
0
) + createAltStr(vstr, cstr, 
1
, nc)); 


// if both vowel and consonant 

// strings are of equal length 

// start creating string with consonant 

if
(cstr.charAt(
0
) < vstr.charAt(
0
)) 

return
createAltStr(cstr, vstr, 
0
, nv); 


// start creating string with vowel 

return
createAltStr(vstr, cstr, 
0
, nc); 
} 

// Driver code 
public
static
void
main(String args[]) 
{ 

String str = 
"geeks"
; 

System.out.println(findAltStr(str)); 
} 
} 

// This code is contributed by 
// Shashank_Sharma 