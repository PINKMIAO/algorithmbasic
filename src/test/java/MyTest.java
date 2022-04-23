import org.junit.Test;

public class MyTest {

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 4, 5, 8, 7, 9, 0, 5, 4, 3, 1};
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

    // for test
    @Test
    public void test01() {
        int[] ints = generateRandomArray(50, 10);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    // for test

    /**
     * 自动生成随机数组，目的便于测试
     *
     * @param maxSize
     * @param maxValue
     * @return
     */
    public int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }


    @Test
    public void test03() {
        int temp = 0;
        // 打入条件断点
        for (int i = 0; i < 100; i++) {
            temp++;
        }
        System.out.println(temp);
    }

}
