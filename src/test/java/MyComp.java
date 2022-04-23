import java.util.Comparator;

/**
 * @author Baven
 * @date 2022/4/8 10:27
 */
public class MyComp implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}
