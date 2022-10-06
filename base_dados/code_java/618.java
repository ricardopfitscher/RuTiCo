import java.util.*;
public class kingrace {public static void main(String[] args) 
{ 
    Scanner input=new Scanner(System.in);
    long a = input.nextLong();
   input.nextLine();
    String [] coo = input.nextLine().split(" ");
    long xcoin = Long.parseLong(coo[0]);
    long ycoin = Long.parseLong(coo[1]);
    coordinates first = new coordinates(1,1,a);
    coordinates second = new coordinates(a,a,a);
    double x = (double)Math.sqrt(Math.abs((xcoin-1)*(xcoin-1)+(ycoin-1)*(ycoin-1)));
    double y = (double)Math.sqrt(Math.abs((xcoin-a)*(xcoin-a)+(ycoin-a)*(ycoin-a)));
   long c = 0;
   long d = 0;
    if (x>y)
    {
    	System.out.println("Black");
    }
    else if(x<y)
    {
    	System.out.println("White");
    }
    else {
    c = first.Distance(new coordinates(xcoin,ycoin,a));
    d = second.Distance(new coordinates(xcoin,ycoin,a));
    }
    if(d!=0&&c!=0)
    if (d<c)
    {
    	System.out.println("Black");
    	
    }
    else 
    {
    	System.out.println("White");
    }
  //System.out.prlongln(c +" "+d);
  input.close();
} 

}
class coordinates{
	private long xcoord;
	private long ycoord;
	private long dim; 
	public coordinates(long x, long y, long dimensions)
	{
		xcoord = x;
		ycoord = y;
		dim = dimensions;
		
	}
	public void setCoordinates(long x, long y)
	{
		xcoord = x;
		ycoord = y;
		
	}
	public long Distance(coordinates num)
	{
		long distance = 0; 
		
		
		while ((this.xcoord!=num.xcoord||this.ycoord!=num.ycoord))
		{
		
			if (num.xcoord-this.xcoord==1 &&num.ycoord==this.ycoord)
			{
		
			distance ++; this.setCoordinates(this.xcoord+1, this.ycoord);
			}
			else if (num.xcoord-this.xcoord==-1 &&num.ycoord==this.ycoord)
			{
			
				distance ++; this.setCoordinates(this.xcoord-1, this.ycoord);
			}
			else if (num.xcoord-this.xcoord==0 &&num.ycoord-this.ycoord==1)
			{distance ++; this.setCoordinates(this.xcoord, this.ycoord+1);}
			else if (num.xcoord-this.xcoord==0 &&num.ycoord-this.ycoord==-1) {
				distance ++; this.setCoordinates(this.xcoord, this.ycoord-1);
			}
			
			else if (num.xcoord-this.xcoord>=0 &&num.ycoord-this.ycoord<=0)
			{
			
				distance ++; this.setCoordinates(this.xcoord+1, this.ycoord-1); 
			}
			else if (num.xcoord-this.xcoord>=0 &&num.ycoord-this.ycoord>=0)
			{
				distance ++; this.setCoordinates(this.xcoord+1, this.ycoord+1);
			}
			else if (num.xcoord-this.xcoord<=0 &&num.ycoord-this.ycoord<=0)
			
			{
				distance ++; this.setCoordinates(this.xcoord-1, this.ycoord-1);
			}
			else if (num.xcoord-this.xcoord<=0 &&num.ycoord-this.ycoord>=0)
					{distance ++; this.setCoordinates(this.xcoord-1, this.ycoord+1);
					}
				
		}
		
		return distance;
	}
	
	
}
