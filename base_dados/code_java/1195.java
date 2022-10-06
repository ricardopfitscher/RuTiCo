    import java.util.Scanner;

    public class Sasha1113A {

        static int solution(int n, int v){
            int count;
            if(v>=n)
                return n-1;
            else{
                count = (v-1) + ((n-v)*(n-v+1))/2;
            }
            return count;
        }

        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            int v = scan.nextInt();

            System.out.print(solution(n, v));
        }
    }
