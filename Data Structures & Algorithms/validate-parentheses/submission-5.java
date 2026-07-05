class Solution {
    private static final Character L_ROUND = '(';
    private static final Character L_SQUARE = '[';
    private static final Character L_CURLY = '{';

    private static final Character R_ROUND = ')';
    private static final Character R_SQUARE = ']';
    private static final Character R_CURLY = '}';

    private static final Set<Character> OPENING_PARENS = Set.of(L_ROUND, L_SQUARE, L_CURLY);

    private static final Set<Character> CLOSING_PARENS = Set.of(R_ROUND, R_SQUARE, R_CURLY);

    private static final Map<Character, Character> CLOSING_TO_OPENING_PAREN =
        Map.of(R_ROUND, L_ROUND, R_SQUARE, L_SQUARE, R_CURLY, L_CURLY);

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if (OPENING_PARENS.contains(current)) {
                stack.addFirst(current);
            }
            if (CLOSING_PARENS.contains(current)) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (CLOSING_TO_OPENING_PAREN.get(current).equals(stack.getFirst())) {
                    stack.pop();
                }else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
