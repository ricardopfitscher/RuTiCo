import java.util.Scanner;

public class SashaAndHisTrip {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int v = in.nextInt();
        if (v > N) {
            System.out.println(N-1);
        }
        else {
            int price = v + ((N-v-1) * (2+ N - v))/2;
            int counter = 0;
            System.out.println(price);
        }
    }
}
