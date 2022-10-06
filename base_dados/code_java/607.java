import java.util.*;
public class test{
public static void main(String args[])
{
Scanner s=new Scanner(System.in);
int n=s.nextInt();
int m=s.nextInt();
int arr[]=new int[n];
int max = Integer.MIN_VALUE;
        long sum = 0;
        for(int i=0;i<n;i++)
        {
            arr[i] = s.nextInt();
            sum = sum + arr[i];
            max = Math.max(max,arr[i]);
        }
        Arrays.sort(arr);
        int i = 0;
        int count = 0;
        int d = 0;
        for(i=0; i<n; i++)
        {
            if(arr[i] > d)
            {
                count++;
                d++;
            }
            else if(arr[i] == d && arr[i] > 0)
            {
                count++;
            }
        }
        //System.out.println(count + " " + max);
        if(max - d > 0)
        {
            count = count + max - d;
        }
        System.out.println(sum - count);}}