class findMedianTwoArrays
{
  public static double main(
    int[] arr1, int start1, int end1, int[] arr2, int start2, int end2) {
    if ( end1 - start1 == 1 && end2 - start2 == 1 ) {
        return ( Math.max(arr1[start1], arr2[start2]) + Math.min(arr1[end1], arr2[end2]) ) / 2;
    }    
  
  int median1Index = Math.floor((start1 + end1 ) / 2);
  int median2Index = Math.floor((start2 + end2 ) / 2);
  int median1 = arr1[median1Index];
  int median2 = arr2[median2Index];

  if ( median1 == median2 ) {
    return median1;
  }    

  if ( median1 < median2 ) {
    start1 = median1Index;
    if ( end2 - start2 > 1 ) { 
        end2 = median2Index;
    }        
  } else {
    start2 = median2Index;
    if ( end1 - start1 > 1 ) { 
        end1 = median1Index;
    }    
  }            

  return main(arr1, start1, end1, arr2, start2, end2);
  }
}

class test {
  public static void main(String[] args) {
    int[] A = { 1, 2, 3, 4, 4 };
    int[] B = { 6, 9, 10, 11, 15};
    findMedianTwoArrays findMedian = new findMedianTwoArrays();
    System.out.println("Hello Java");
    System.out.println(findMedian.main(A, 0, 4, B, 0, 4));
  }    
} 