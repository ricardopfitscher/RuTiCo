// http://www.geeksforgeeks.org/count-1s-sorted-binary-array/
class CountOne {

  public static void main(String[] args) {
    int[] arr={0, 0, 0, 0, 0, 0, 0};
    //int[] arr={1, 1, 1, 1, 1, 1, 1};
    //int[] arr = {1, 1, 1, 0, 0, 0, 0};  
    countOne(arr);
  }

  public static void countOne(int[] a)
  {
       int l = 0;
       int h = a.length-1;
       int mid = -1;
      
       while(l<=h)
       {
         mid = (l+h)/2;
         
         if( (mid == h || a[mid+1] == 0) && a[mid] == 1)
         {
             System.out.println("Count " + (mid + 1));
             return;
         }
           
         if( a[mid] < 1)
         {
             h = mid - 1;
         } else {
             l = mid + 1;
         } 
       }
       System.out.println(" No one's found ");
       return;
  }
}