public class Search {

    public static boolean find2(int[] array, int begin, int end, int element) {
        if (begin <= end) {
            int medium = begin + (end - begin) / 2;
            if (array[medium] == element)
                return true;
            else if (medium > begin && array[medium - 1] == element) return true;
            else if (medium < end && array[medium + 1] == element) return true;

            if (array[medium] > element) return find2(array, 0, medium - 2, element);
            return find2(array, medium + 2, end, element);
        }
        return false;
    }
    
    public static int find(int[] array, int begin, int end, int element) {
        if (begin < end) {
            int medium = begin + (end - begin) / 2;
            if (array[medium] == element)
                return medium;
            else if (medium > begin && array[medium - 1] == element) return medium - 1;
            else if (medium < end && array[medium + 1] == element) return medium + 1;

            if (array[medium] > element) return find(array, 0, medium - 2, element);
            return find(array, medium + 2, end, element);


        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {12,13, 21, 36, 3, 43, 65, 76, 88, 91, 100};
        System.out.println(find2(array, 0, array.length-1, 13));
    }


}