import java.util.Scanner;
public class Codeforces {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        int n,k;
        n=input.nextInt();
        k=input.nextInt();
        String s=input.next();
        int[] wtArray=new int[n];
        for(int i=0;i<s.length();i++)
            wtArray[i]=s.charAt(i)-96;
        for(int i=1;i<n;i++)
            for(int j=0;j<n-i;j++)
                if(wtArray[j]>wtArray[j+1]){
                    int temp=wtArray[j+1];
                    wtArray[j+1]=wtArray[j];
                    wtArray[j]=temp;
                }

        int sum=wtArray[0];
        k--;
        int temp=sum;
        for(int i=1;k!=0 &&i <n;i++){
            if((wtArray[i]-temp)>1){
                sum+=wtArray[i];
                k--;
                temp=wtArray[i];
            }
        }
        if(k!=0)
            sum=-1;
        System.out.println(sum);
    }

}