import java.util.*;
public class bOX {

    public static void main(String ars[]){

        Scanner  s = new Scanner(System.in);
        int n = s.nextInt();
        int max = 0;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            int x = s.nextInt();
            if(!map.containsKey(x)){
                map.put(x,1);
                max = Math.max(max,1);
            }
            else{
                map.put(x,map.get(x)+1);
                max = Math.max(max,map.get(x));
            }
        }

        System.out.println(max);
    }

}
