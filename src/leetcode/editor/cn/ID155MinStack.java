package leetcode.editor.cn;

import java.util.Stack;

public class ID155MinStack {
    public static void main(String[] args) {
        MinStack minStack = new ID155MinStack().new MinStack();

        // 执行测试

        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> min_stack;

        public MinStack() {
            stack = new Stack<>();
            min_stack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (min_stack.isEmpty() || val <= min_stack.peek())
                min_stack.push(val);
        }

        public void pop() {
            // if (stack.pop() == min_stack.peek())
            //又是不能用==判断
            if (stack.pop().equals(min_stack.peek()))
                min_stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min_stack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// leetcode submit region end(Prohibit modification and deletion)

}
