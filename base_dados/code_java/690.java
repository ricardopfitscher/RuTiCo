import java.util.*;

public class G {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, m;
        n = in.nextInt();
        m = in.nextInt();
        int[] a = new int[m];

        for (int i = 0; i < m; i++) {
            a[i] = in.nextInt();
        }

        Arrays.sort(a);
        HashMap<Integer, Integer> map = new HashMap<>(200);
        for (int i : a) {
            Integer t = map.get(i);
            if (t == null) {
                map.put(i, 1);
            } else {
                map.put(i, t + 1);
            }
        }

        ArrayList<Food> list = new ArrayList<>(100);
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> en = it.next();
            list.add(new Food(en.getKey(), en.getValue()));
        }

        list.sort(Comparator.comparingInt(o -> o.num));
        int min, max;
        min = 1;
        max = list.get(list.size() - 1).num;
        int res = 0;
        for (int i = min; i <= max; i++) {
            int t = 0;
            for (Food food : list) {
                int gaven = food.num / i;
                if (gaven >= 1) {
                    t += gaven;
                    if (t >= n) {
                        res = Math.max(res, i);
                        break;
                    }
                }
            }
        }
        System.out.println(res);
//        System.out.println(Arrays.toString(list.toArray()));
//        if (list.size() < n) {
//            System.out.println(0);
//        } else {
//            System.out.println(list.get(n - 1).num);
//        }
    }
}

class Food {
    int id;
    int num;

    public Food(int id, int num) {
        this.id = id;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", num=" + num +
                '}';
    }
}
