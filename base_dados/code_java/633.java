
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class A1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        long size = scan.nextLong();
        int numberOfSpecial = scan.nextInt();
        long pageSize = scan.nextLong();

        long[] specialItemsArray = new long[numberOfSpecial];
        for (int i = 0; i < numberOfSpecial; i++) {
            specialItemsArray[i] = scan.nextLong();
        }

        int totalRemoved = 0;
        int step = 0;

        long currentPageIndex = BigDecimal.valueOf(specialItemsArray[0]).divide(BigDecimal.valueOf(pageSize),2, RoundingMode.UP).setScale(0, RoundingMode.CEILING).longValue();
        int specialItemArrayIndex = 1;

        while (specialItemArrayIndex < numberOfSpecial) {
            long pageIndex = BigDecimal.valueOf(specialItemsArray[specialItemArrayIndex] - totalRemoved).divide(BigDecimal.valueOf(pageSize),2,RoundingMode.UP).setScale(0, RoundingMode.CEILING).longValue();
            if (currentPageIndex != pageIndex) {
                step++;
                totalRemoved = specialItemArrayIndex;
                currentPageIndex =  BigDecimal.valueOf(specialItemsArray[specialItemArrayIndex] - totalRemoved).divide(BigDecimal.valueOf(pageSize),2,RoundingMode.UP).setScale(0, RoundingMode.CEILING).longValue();
            }
            specialItemArrayIndex++;
        }


        System.out.println(step + 1);

    }

}
