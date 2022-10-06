import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SFly {

	public static void main(String[] args) throws IOException {
		
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		int planet = Integer.parseInt(lector.readLine());
		int ini = Integer.parseInt(lector.readLine());
		double peso = ini;
		int[] desp = new int[planet];
		int[] ater = new int[planet];
		String[] temp = lector.readLine().split(" ");		
		for(int i=0; i<planet; i++) {
			desp[i] = Integer.parseInt(temp[i]);
			if(desp[i] == 1) {
				System.out.println(-1);
				lector.close();
				return;
			}
		}
		temp = lector.readLine().split(" ");		
		for(int i=0; i<planet; i++) {
			ater[i] = Integer.parseInt(temp[i]);
			if(ater[i] == 1) {
				System.out.println(-1);
				lector.close();
				return;
			}
		}
		temp = null;
		int i=planet-1;
		peso = (peso*ater[0])/(ater[0]-1);
		while(i>0) {
			peso = (peso*desp[i])/(desp[i]-1);
			peso = (peso*ater[i])/(ater[i]-1);
			i--;
		}
		peso = (peso*desp[0])/(desp[0]-1);
		peso = peso - ini;
		System.out.println(peso);
		lector.close();
	}
}