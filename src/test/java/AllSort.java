/**
 * for test
 */
public class AllSort {

    public static void main(String[] args) {
        String[] ans = createRandomStrArr(10, 5);
        for (String an : ans) {
            System.out.print(an + " ");
        }
    }

    /**
     * Utils
     * @param strLen
     * @return
     */
    // Create String or StringArray
    public static String createRandomStr(int strLen){
        char[] ans = new char[strLen];
        for (int i = 0; i < ans.length; i++) {
            int value = (int) (Math.random() * 10);
            ans[i] = (char)(97 + value);
        }
        return String.valueOf(ans);
    }
    public static String[] createRandomStrArr(int strSize, int strValue) {
        String[] ans = new String[strSize];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = createRandomStr(strValue);
        }
        return ans;
    }
    // Create Array
    public static int[] createRandomArr(int maxSize, int maxValue) {
        int[] arr = new int[maxSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        return arr;
    }
    // Swap
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // Print Array
    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
