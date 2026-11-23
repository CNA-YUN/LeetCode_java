import java.util.ArrayList;
import java.util.List;

public class Solution1352 {
    List<Integer> list;

    public Solution1352() {

        list = new ArrayList<>();
        list.add(1);
    }

    public void add(int num) {
        if (num != 0) {
            list.add(list.getLast() * num);
        } else {
            list.clear();
            list.add(1);
        }
    }

    public int getProduct(int k) {
        if (list.size() <= k) {
            return 0;
        }
        return list.getLast() / list.get(list.size() - k - 1);
    }
}
