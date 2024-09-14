package leetcode.editor.cn;

import java.util.LinkedHashMap;
import java.util.Map;

public class ID146LruCache {
    // leetcode submit region begin(Prohibit modification and deletion)
    // 利用LinkHashMap实现
    class LRUCache {
        private int capacity = 0;
        private Map<Integer, Integer> LRU = new LinkedHashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            // remove-返回与 key 关联的上一个值，如果没有 key 的映射，则为 null
            Integer val = LRU.remove(key);
            if (val == null)
                return -1;
            else {
                LRU.put(key, val);
                return val;
            }
        }

        public void put(int key, int value) {
            if (LRU.remove(key) != null) {
                LRU.put(key, value);
                return;
            } else {
                if (LRU.size() == this.capacity) {
                    // 使用 iterator() 方法获取迭代器，并通过 next() 方法获取第一个键，即最久未使用的键。
                    Integer firstKey = LRU.keySet().iterator().next();
                    LRU.remove(firstKey);
                }
            }
            LRU.put(key, value);
            return;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
