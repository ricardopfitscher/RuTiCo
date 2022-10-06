import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Comp c1 = getComp(scanner);
		Comp c2 = getComp(scanner);
		c1.sortByPrice();
		c2.sortByPrice();	
		int i = 0;
		int j = 0;
		while(i < c1.num || j < c2.num) {
			Elem xi = (i < c1.num) ? c1.elems.get(i) : null;
			Elem yj = (j < c2.num) ? c2.elems.get(j) : null;
			if(xi != null && yj != null) {
				if(xi.price >= yj.price) {
					if(!c2.resultSet.contains(xi)) {
						c1.resultSet.add(xi);
					}
					i++;
				} else {
					if(!c1.resultSet.contains(yj)) {
						c2.resultSet.add(yj);
					}
					j++;
				}
			} else
			if(xi != null) {
				if(!c2.resultSet.contains(xi)) {
					c1.resultSet.add(xi);
				}
				i++;
			} else {
				if(!c1.resultSet.contains(yj)) {
					c2.resultSet.add(yj);
				}
				j++;
			}				
		}
		
		long result = c1.getResultPrice() + c2.getResultPrice();
		System.out.println(result);
   }
   
   private static Comp getComp(Scanner scanner) {
	   Comp c = new Comp();
	   c.num = scanner.nextInt();
	   for(int i = 0; i < c.num; i++) {
		   c.addElem(scanner.nextLong(), scanner.nextLong());
	   }
	   return c;
   }
}

class Comp {
	int num;
	List<Elem> elems = new ArrayList<>();
	Set<Elem> resultSet = new HashSet<>();
	
	void addElem(long el, long pr) {
		Elem elem = new Elem(el, pr);
		elems.add(elem);
	}
	
	void sortByPrice() {
		Collections.sort(elems);
	}
	
	long getResultPrice() {
		long sumPrice = 0;
		for(Elem elem : resultSet) {
			sumPrice += elem.price;
		}
		
		return sumPrice;
	}
}

class Elem implements Comparable<Elem> {
	long elem;
	long price;
	
	public Elem(long el, long pr) {
		this.elem = el;
		this.price = pr;
	}
	
	public int compareTo(Elem other) {
		return (int) (other.price - price);
	}
	
	public boolean equals(Object o) {
		if(!(o instanceof Elem)) {
			return false;
		}
		
		Elem other = (Elem) o;
		return (other.elem == elem);
	}
	
	public int hashCode() {
		return (int) elem;
	}
	
	public String toString() {
		return "(" + elem + ", " + price + ")";
	}
}
