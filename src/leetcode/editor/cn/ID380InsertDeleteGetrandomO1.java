package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Random;

public class ID380InsertDeleteGetrandomO1 {
    public static void main(String[] args) {
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedSet {
        private HashSet<Integer> set;
        private Random random;
        public RandomizedSet() {
            set = new HashSet<>();
            random = new Random();
        }

        public boolean insert(int val) {
            return set.add(val);
        }

        public boolean remove(int val) {
           return set.remove(val);
        }

        public int getRandom() {
            int index = random.nextInt(set.size());
            return (Integer) set.toArray()[index];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
