import java.io.*;

public class GennadyAndACardGame {
	public static void main(String[] args) throws IOException {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line =null;
		String[] n={};
		String s="NO";
		while((line=bufr.readLine())!=null)    {
			if("over".equals(line))
				break;
			n=bufr.readLine().split(" ");
			for(int i=0;i<n.length;i++){
				if(n[i].contains(line.substring(0,1)) || n[i].contains(line.substring(1))){
					s="YES";
				}
			}
			System.out.println(s);
			s="NO";
			bufw.flush();
		}
		bufw.close();                          //关闭
	}
}
