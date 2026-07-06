class Solution {
    public boolean isPalindrome(String s) {
        s = prepareString(s);
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            Character leftChar = s.charAt(left);
            Character rightChar = s.charAt(right);
            if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private String prepareString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        return sb.toString();
    }
}
