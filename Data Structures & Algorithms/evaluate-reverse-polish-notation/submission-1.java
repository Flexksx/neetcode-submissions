class Solution {
    private static final String ADDITION = "+";
    private static final String MULTIPLICATION = "*";
    private static final String SUBTRACTION = "-";
    private static final String DIVISION = "/";
    private static final Set<String> OPERATIONS =
        Set.of(ADDITION, MULTIPLICATION, SUBTRACTION, DIVISION);

    private final Deque<Integer> operands = new ArrayDeque<>();

    public int evalRPN(String[] tokens) {
        for (String token : tokens) {
            if (OPERATIONS.contains(token)) {
                int second = operands.pop();
                int first = operands.pop();
                int valueToAdd = 0;
                switch (token) {
                    case ADDITION -> valueToAdd = first + second;
                    case MULTIPLICATION -> valueToAdd = first * second;
                    case SUBTRACTION -> valueToAdd = first - second;
                    case DIVISION -> valueToAdd = first / second;
                }
                operands.push(valueToAdd);
            }else{
                operands.push(Integer.parseInt(token));
            }
        }

        return operands.pop();
    }
}
