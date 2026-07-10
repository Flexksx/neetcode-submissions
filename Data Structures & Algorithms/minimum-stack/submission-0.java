class MinStack {
    private final Deque<Integer> stack;
    private final Deque<Integer> minPrefixesStack;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minPrefixesStack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);

        if (minPrefixesStack.isEmpty()) {
            minPrefixesStack.push(val);
        } else {
            int currentMinPrefix = minPrefixesStack.getFirst();
            int minPrefixToAdd = currentMinPrefix > val ? val : currentMinPrefix;
            minPrefixesStack.push(minPrefixToAdd);
        }
    }

    public void pop() {
        stack.pop();
        minPrefixesStack.pop();
    }

    public int top() {
        return stack.getFirst();
    }

    public int getMin() {
        return minPrefixesStack.getFirst();
    }
}
