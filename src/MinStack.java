import java.util.Deque;
import java.util.LinkedList;

class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> mnstack;

    public MinStack() {
        stack = new LinkedList<>();
        mnstack = new LinkedList<>();
    }

    public void push(int value) {
        stack.add(value);
        if (mnstack.isEmpty()) {
            mnstack.add(value);
        } else {
            mnstack.add(mnstack.getLast() > value ? value : mnstack.getLast());
        }
    }

    public void pop() {
        stack.removeLast();
        mnstack.removeLast();
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return mnstack.getLast();
    }
}

/*
  Your MinStack object will be instantiated and called as such:
  MinStack obj = new MinStack();
  obj.push(value);
  obj.pop();
  int param_3 = obj.top();
  int param_4 = obj.getMin();
 */