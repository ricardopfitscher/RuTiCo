import java.util.*;

import java.io.*;
public class Solution
{
    public static void main(String [] args) throws IOException
    {
        PrintWriter pw=new PrintWriter(System.out);//use pw.println() not pw.write();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        /*
        inputCopy
5 3
xyabd
outputCopy
29
inputCopy
7 4
problem
outputCopy
34
inputCopy
2 2
ab
outputCopy
-1
inputCopy
12 1
abaabbaaabbb
outputCopy
1
        */
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        String str=st.nextToken();
        char [] arr=str.toCharArray();
        Arrays.sort(arr);
        int weight=arr[0]-96;
        char a=arr[0];
        int included=1;
        for(int i=1;i<arr.length;++i)
        {
            if(included==k)
                break;
            char c=arr[i];
            if(c-a<2)
                continue;
           
            weight+=arr[i]-96;
            ++included;
            a=arr[i];
            
        }
        if(included==k)
            pw.println(weight);
        else
            pw.println(-1);
        pw.close();//Do not forget to write it after every program return statement !!
    }
}
/*
→Judgement Protocol
Test: #1, time: 77 ms., memory: 0 KB, exit code: 0, checker exit code: 0, verdict: OK
Input
5 3
xyabd
Output
29
Answer
29
Checker Log
ok 1 number(s): "29"
Test: #2, time: 78 ms., memory: 0 KB, exit code: 0, checker exit code: 0, verdict: OK
Input
7 4
problem
Output
34
Answer
34
Checker Log
ok 1 number(s): "34"
Test: #3, time: 139 ms., memory: 0 KB, exit code: 0, checker exit code: 0, verdict: OK
Input
2 2
ab
Output
-1
Answer
-1
Checker Log
ok 1 number(s): "-1"
Test: #4, time: 124 ms., memory: 0 KB, exit code: 0, checker exit code: 0, verdict: OK
Input
12 1
abaabbaaabbb
Output
1
Answer
1
Checker Log
ok 1 number(s): "1"
Test: #5, time: 124 ms., memory: 0 KB, exit code: 0, checker exit code: 0, verdict: OK
Input
50 13
qwertyuiopasdfghjklzxcvbnmaaaaaaaaaaaaaaaaaaaaaaaa
Output
169
Answer
169
Checker Log
ok 1 number(s): "169"
Test: #6, time: 108 ms., memory: 0 KB, exit code: 0, checker exit code: 0, verdict: OK
Input
50 14
qwertyuiopasdfghjklzxcvbnmaaaaaaaaaaaaaaaaaaaaaaaa
Output
-1
Answer
-1
Checker Log
ok 1 number(s): "-1"
Test: #7, time: 93 ms., memory: 0 KB, exit code: 0, checker exit code: 0, verdict: OK
Input
1 1
a
Output
1
Answer
1
Checker Log
ok 1 number(s): "1"
Test: #8, time: 108 ms., memory: 0 KB, exit code: 0, checker exit code: 0, verdict: OK
Input
50 1
aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
Output
1
Answer
1
Checker Log
ok 1 number(s): "1"
Test: #9, time: 77 ms., memory: 0 KB, exit code: 0, checker exit code: 0, verdict: OK
Input
50 2
aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
Output
-1
Answer
-1
Checker Log
ok 1 number(s): "-1"
Test: #10, time: 92 ms., memory: 0 KB, exit code: 0, checker exit code: 0, verdict: OK
Input
13 13
uwgmkyqeiaocs
Output
169
Answer
169
Checker Log
ok 1 number(s): "169"
Test: #11, time: 124 ms., memory: 0 KB, exit code: 0, checker exit code: 0, verdict: OK
Input
13 13
hzdxpbfvrltnj
Output
182
Answer
182
Checker Log
ok 1 number(s): "182"
Test: #12, time: 93 ms., memory: 0 KB, exit code: 0, checker exit code: 0, verdict: OK
Input
1 1
n
Output
14
Answer
14
Checker Log
ok 1 number(s): "14"
Test: #13, time: 92 ms., memory: 0 KB, exit code: 0, checker exit code: 0, verdict: OK
Input
10 8
smzeblyjqw
Output
113
Answer
113
Checker Log
ok 1 number(s): "113"
Test: #14, time: 78 ms., memory: 0 KB, exit code: 0, checker exit code: 0, verdict: OK
Input
20 20
tzmvhskkyugkuuxpvtbh
Output
-1
Answer
-1
Checker Log
ok 1 number(s): "-1"
Test: #15, time: 109 ms., memory: 0 KB, exit code: 0, checker exit code: 0, verdict: OK
Input
30 15
wjzolzzkfulwgioksfxmcxmnnjtoav
Output
-1
Answer
-1
Checker Log
ok 1 number(s): "-1"
Test: #16, time: 93 ms., memory: 0 KB, exit code: 0, checker exit code: 0, verdict: OK
Input
40 30
xumfrflllrrgswehqtsskefixhcxjrxbjmrpsshv
Output
-1
Answer
-1
Checker Log
ok 1 number(s): "-1"
Test: #17, time: 124 ms., memory: 0 KB, exit code: 0, checker exit code: 0, verdict: OK
Input
50 31
ahbyyoxltryqdmvenemaqnbakglgqolxnaifnqtoclnnqiabpz
Output
-1
Answer
-1
Checker Log
ok 1 number(s): "-1"
Test: #18, time: 124 ms., memory: 0 KB, exit code: 0, checker exit code: 0, verdict: OK
Input
10 7
iuiukrxcml
Output
99
Answer
99
Checker Log
ok 1 number(s): "99"
Test: #19, time: 109 ms., memory: 0 KB, exit code: 0, checker exit code: 0, verdict: OK
Input
38 2
vjzarfykmrsrvwbwfwldsulhxtykmjbnwmdufa
Output
5
Answer
5
Checker Log
ok 1 number(s): "5"
Test: #20, time: 77 ms., memory: 0 KB, exit code: 0, checker exit code: 0, verdict: OK
Input
12 6
fwseyrarkwcd
Output
61
Answer
61
Checker Log
ok 1 number(s): "61"
Test: #21, time: 109 ms., memory: 0 KB, exit code: 0, checker exit code: 0, verdict: OK
Input
2 2
ac
Output
4
Answer
4
Checker Log
ok 1 number(s): "4"
Test: #22, time: 108 ms., memory: 0 KB, exit code: 0, checker exit code: 0, verdict: OK
Input
1 1
c
Output
3
Answer
3
Checker Log
ok 1 number(s): "3"
Test: #23, time: 124 ms., memory: 0 KB, exit code: 0, checker exit code: 0, verdict: OK
Input
2 2
ad
Output
5
Answer
5
Checker Log
ok 1 number(s): "5"
Test: #24, time: 77 ms., memory: 0 KB, exit code: 0, checker exit code: 1, verdict: WRONG_ANSWER
Input
2 1
ac
Output
-1
Answer
1
Checker Log
wrong answer 1st number
*/