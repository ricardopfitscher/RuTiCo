
//Java implementation to check whether decimal representation 
//of given binary number is divisible by 5 or not 

class
GFG 
{ 

// Method to return equivalent base 4 number 

// of the given binary number 

static
int
equivalentBase4(String bin) 

{ 

if
(bin.compareTo(
"00"
) == 
0
) 

return
0
; 

if
(bin.compareTo(
"01"
) == 
0
) 

return
1
; 

if
(bin.compareTo(
"10"
) == 
0
) 

return
2
; 

return
3
; 

} 


// Method to check whether the given binary 

// number is divisible by 5 or not 

static
String isDivisibleBy5(String bin) 

{ 

int
l = bin.length(); 


if
(l % 
2
!= 
0
) 

// add '0' in the beginning to make 

// length an even number 

bin = 
'0'
+ bin; 


// to store sum of digits at odd and 

// even places respectively 

int
odd_sum=
0
, even_sum = 
0
; 


// variable check for odd place and 

// even place digit 

int
isOddDigit = 
1
; 

for
(
int
i = 
0
; i<bin.length(); i+= 
2
) 

{ 

// if digit of base 4 is at odd place, then 

// add it to odd_sum 

if
(isOddDigit != 
0
) 

odd_sum += equivalentBase4(bin.substring(i, i+
2
)); 

// else digit of base 4 is at even place, 

// add it to even_sum 

else

even_sum += equivalentBase4(bin.substring(i, i+
2
)); 


isOddDigit ^= 
1
; 

} 


// if this diff is divisible by 11(which is 5 in decimal) 

// then, the binary number is divisible by 5 

if
(Math.abs(odd_sum - even_sum) % 
5
== 
0
) 

return
"Yes"
; 


// else not divisible by 5 

return
"No"
; 


} 


public
static
void
main (String[] args) 

{ 

String bin = 
"10000101001"
; 

System.out.println(isDivisibleBy5(bin)); 

} 
} 