public class CheckSortedExample {

    public static boolean isSorted(int[] arr, int index) {
        if (arr == null || arr.length <= 1 || index >= arr.length - 1) {
            return true;
        }
        if (arr[index] > arr[index + 1]) {
            return false;
        }
        return isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4, 5};
        int[] test2 = {1, 2, 5, 3, 6};
        int[] test3 = {10};
        int[] test4 = {};
        int[] test5 = {1, 1, 2, 2, 3};

        System.out.println("Test 1: " + isSorted(test1, 0));
        System.out.println("Test 2: " + isSorted(test2, 0));
        System.out.println("Test 3: " + isSorted(test3, 0));
        System.out.println("Test 4: " + isSorted(test4, 0));
        System.out.println("Test 5: " + isSorted(test5, 0)); 
    }
}
