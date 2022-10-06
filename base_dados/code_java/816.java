import java.util.*;
public class D5 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int a = input.nextInt(), v = input.nextInt();
    int l = input.nextInt(), d = input.nextInt(), w = input.nextInt();
    double lo = 0, hi = v;
    for(int iter = 0; iter < 1000; iter++)
    {
        double mid = (lo+hi)/2;
        if(can(mid, a, d, w)) lo = mid;
        else hi = mid;
    }
    //System.out.println(lo);
    double t1 = lo / a;
    double gone = .5 * t1 * t1 * a;
    if(lo > w)
    {
        gone += -a * .5 * (lo - w) / a * (lo - w) / a + lo * (lo - w) / a;
        t1 += (lo - w) / a;
    }
    t1 += (d - gone) / lo;
    //System.out.println(t1);
    double v0 = Math.min(lo, w);
    double togo = l - d;
    double toAdd = (-v0 + Math.sqrt(v0 * v0 + 4 * togo * .5 * a)) / a;
    if(toAdd * a + v0 > v)
    {
        double tt = (v - v0) / a;
        t1 += tt;
        togo -= .5 * a * tt * tt + v0 * tt;
        t1 += togo / v;
    }
    else t1 += toAdd;
    System.out.println(t1);
}
static boolean can(double v, double a, double d, double max)
{
    double t1 = v / a;
    double distGone = .5 * a * t1 * t1;
    if(v > max)
    {
        t1 = (v - max) / a;
        distGone += -.5 * a * t1 * t1 + v * t1;
    }
    return distGone <= d;
}
}
