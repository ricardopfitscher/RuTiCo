import java.util.*;


public class Main {
    static int n=5;
    static int[] arr=new int[5];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for (int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for (int i=0;i<n;i++)
        {
            if (arr[i]>=0)
            {
                arr[i]=-arr[i]-1;
            }
        }
        if (n%2!=0)
        {
            int min=0;
            for (int i=1;i<n;i++)
            {
                if (arr[i]<arr[min])
                    min=i;
            }
            arr[min]=-arr[min]-1;
        }
        for (int x:arr)
        {
            System.out.print(x + " ");
        }

    }
}