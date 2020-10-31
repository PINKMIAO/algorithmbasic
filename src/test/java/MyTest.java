import org.junit.Test;

public class MyTest {

    @Test
    public void test(){
        int[] arr = {1, 2, 3, 4,4,5,8,7,9,0,5,4,3,1};
        StringBuilder ans = new StringBuilder();

        int sum = 9;
        while (-1 < sum) {
            int len = 0;
            while (len < arr.length) {
                if (arr[len] == sum) {
                    ans.append(arr[len]);
                }
                len++;
            }
            sum--;
        }
        System.out.println(ans.toString());
    }

    /**
     * mergeSort test 归并练习
     */
    @Test
    public void test02(){
        int[] nums = {0,2,3,6,1,3,7,5,2};

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
    public void processingPass(int[] nums, int l, int r){
        if (l == r) {
            return;
        }

        int m = l + ((r - l) >> 1);
        processingPass(nums, l, m);
        processingPass(nums, m + 1, r);
        //mergePass(nums, l, m, r);
    }
    public void mergePass(int[] nums, int L, int m, int r){
        int[] helper = new int[r - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            helper[i++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= m) {
            helper[i++] = nums[p1++];
        }
        while (p2 <= r) {
            helper[i++] = nums[p2++];
        }
        for (i = 0; i < helper.length; i++) {
            nums[L + i] = helper[i];
        }
    }



    /**
     * quickSort test 快排练习
     * All three version
     */
    @Test // for test
    public void test03(){
        int[] nums = {0,2,3,6,1,3,7,5,2}; // 0 1 2 2 3 3 5 6 7

        quickSort3(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // version 1.0
    public void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        process1(arr, 0, arr.length - 1);
    }
    public void process1(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = partition(arr, l, r);
        process1(arr, l, m - 1);
        process1(arr, m + 1, r);
    }
    public int partition(int[]arr, int l, int r) {
        if (l > r) {
            return -1;
        }
        if (l == r) {
            return l;
        }

        int less = l - 1;
        int index = l;
        while (index < r) {
            if (arr[index] <= arr[r]) {
                swap(arr, index, ++less);
            }
            index++;
        }
        swap(arr, ++less, r);
        return less;
    }

    // version 2.0
    public void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }
    public void process2(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] M = netherlandsFlag(arr, L, R);
        process2(arr, L, M[0] - 1);
        process2(arr, M[1] + 1, R);
    }
    // return middle address
    public int[] netherlandsFlag(int[] arr, int L , int R) {
        if (L > R) {
            return new int[] {-1, -1};
        }
        if (L == R) {
            return new int[] {L, R};
        }

        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more);
            }
        }
        swap(arr, more, R);

        return new int[] {less + 1, more};
    }

    // version 3.0
    public void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr, 0, arr.length - 1);
    }
    public void process3(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        // 这里随机获取一个地址与最后一个数的地址交换，之后就与 version 2.0 相同。
        // 但这样的复杂度却是 O(N * logN)
        swap(arr, L + (int)(Math.random() * (R - L + 1)), R);
        int[] M = netherlandsFlag(arr, L, R);
        process3(arr, L, M[0] - 1);
        process3(arr, M[1] + 1, R);
    }






}
