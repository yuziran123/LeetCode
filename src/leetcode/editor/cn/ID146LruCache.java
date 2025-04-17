package leetcode.editor.cn;

import java.util.LinkedHashMap;
import java.util.Map;

public class ID146LruCache {
    // leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        private int capacity = 0;
        private Map<Integer, Integer> LRU;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.LRU = new LinkedHashMap<>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size() > LRUCache.this.capacity;
                }
            };
        }

        public int get(int key) {
            return LRU.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            LRU.put(key, value); // 利用 LinkedHashMap 的自动淘汰机制
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
