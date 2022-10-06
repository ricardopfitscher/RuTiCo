import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PlayingPiano {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		 int n = scanner.nextInt();
		 
		 List<Integer> as = new LinkedList<>();
		 int[] as2 = new int[n];
		 
		 for (int i = 0; i < n; i++) {
			 int a = scanner.nextInt();
			 as.add(a);
			 as2[i] = a;
		 }
		 
		 //System.out.println(solve(as));
		 System.out.println(solve2(as2));
		
		scanner.close();
	}

	public static String solve(List<Integer> as) {
		List<Integer> fingers = new LinkedList<>();
		 fingers.add(1);
		 fingers.add(2);
		 fingers.add(3);
		 fingers.add(4);
		 fingers.add(5);
		 
		 List<Integer> solution = assign(as, fingers, fingers);
		 if (solution == null) {
			 return "-1";
		 } else {
			 StringBuilder sb = new StringBuilder();
			 for (int b : solution) {
				 sb.append(b);
				 sb.append(" ");
			 }
			 sb.deleteCharAt(sb.length() - 1);
			 return sb.toString();
		 }
	}

	private static List<Integer> assign(List<Integer> as, List<Integer> fingers, List<Integer> allFingers) {
		// if fingers is empty return null
		if (fingers.isEmpty()) {
			return null;
		}
		
		// if as size is one then return first element in fingers
		if (as.size() == 1) {
			List<Integer> ret = new LinkedList<>();
			ret.add(fingers.get(0));
			return ret;
		}
		
		// get sublist
		List<Integer> subList = as.subList(1, as.size());
		
		for (int i = 0; i < fingers.size(); i++) {
			// recursively call with sublist and limited list of fingers
			List<Integer> subFingers = new LinkedList<>();
			final int j = i;
			if (as.get(0) < as.get(1)) {
				 subFingers = allFingers.stream()
					    .filter(p -> p > fingers.get(j)).collect(Collectors.toList());
			} else if (as.get(0) > as.get(1)) {
				subFingers = allFingers.stream()
					    .filter(p -> p < fingers.get(j)).collect(Collectors.toList());
			} else {
				subFingers = allFingers.stream()
					    .filter(p -> p != fingers.get(j)).collect(Collectors.toList());
			}
			
			List<Integer> ret = assign(subList, subFingers, allFingers);
			if (ret != null) {
				List<Integer> solution = new LinkedList<>();
				solution.add(fingers.get(i));
				solution.addAll(ret);
				return solution;
			}
			
			// if return is null, then return null, else return an array
		}
		return null;
		
	}
	
	public static String solve2(int[] as) {
		int[] ret = new int[as.length];
		
		if (as.length == 1) return "1";
		
		if (as[0] < as[1]) ret[0] = 1;
		else if (as[0] == as[1])	ret[0] = 3;
		else ret[0] = 5;
		
		for (int i = 1; i < as.length - 1; i++) {
			if (as[i-1] < as[i] && ret[i-1] == 5) return "-1";
			if (as[i-1] > as[i] && ret[i-1] == 1) return "-1";
			
			if (as[i-1] < as[i] && as[i] < as[i+1]) {
				ret[i] = ret[i-1] + 1;
			} else if (as[i-1] == as[i] && as[i] < as[i+1]) {
				ret[i] = ret[i-1] == 1 ? 2 : 1;
			} else if (as[i-1] > as[i] && as[i] < as[i+1]) {
				ret[i] = 1;
			} else if (as[i-1] < as[i] && as[i] == as[i+1]) {
				ret[i] = ret[i-1] + 1;
			} else if (as[i-1] == as[i] && as[i] == as[i+1]) {
				ret[i] = ret[i-1] == 4 ? 2 : 4;
			} else if (as[i-1] > as[i] && as[i] == as[i+1]) {
				ret[i] = ret[i-1] == 2 ? 1 : 2;
			} else if (as[i-1] < as[i] && as[i] > as[i+1]) {
				ret[i] = 5;
			} else if (as[i-1] == as[i] && as[i] > as[i+1]) {
				ret[i] = ret[i-1] == 5 ? 4 : 5;
			} else if (as[i-1] > as[i] && as[i] > as[i+1]) {
				ret[i] = ret[i-1] - 1;
			}
		}
		
		if (as.length > 1) {
			if (as[as.length - 1] > as[as.length - 2]) {
				if (ret[as.length - 2] == 5)
					return "-1";
				ret[as.length - 1] = 5;
			} else if (as[as.length - 1] == as[as.length - 2]) {
				ret[as.length - 1] = ret[as.length - 2] == 5 ? 4 : 5;
			} else {
				if (ret[as.length - 2] == 1)
					return "-1";
				ret[as.length - 1] = 1;
			} 
		}
		StringBuilder sb = new StringBuilder();
		 for (int b : ret) {
			 sb.append(b);
			 sb.append(" ");
		 }
		 sb.deleteCharAt(sb.length() - 1);
		 return sb.toString();
	}

}
