import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ladder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int problems = sc.nextInt();
        for (int i = 0; i < problems; i++) {
            int numPlanks = sc.nextInt();
            solve(numPlanks, sc);
        }





    }
    public static void solve(int numPlanks, Scanner sc) {
        int answer;
        ArrayList<Integer> planks  = new ArrayList<>();
        for (int i = 0; i < numPlanks; i++) {
            planks.add(sc.nextInt());
        }

        Collections.sort(planks);

        planks.remove(numPlanks - 1);
        planks.add(planks.get(numPlanks - 2));
        int base = planks.get(numPlanks - 1) - 1;
        if ((numPlanks - 2) > base) {
            answer = base;
        }
        else {
            answer = numPlanks - 2;
        }
        if (base == 0) {
            answer = 0;
        }
        System.out.println(answer);
    }
}
