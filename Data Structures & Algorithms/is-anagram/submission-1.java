class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sChars = getCharacterOccurences(s);
        Map<Character, Integer> tChars = getCharacterOccurences(t);

        Set<Character> sKeys = sChars.keySet();
        Set<Character> tKeys = tChars.keySet();

        if (sKeys.size()!=tKeys.size()){
            return false;
        }

        for (Character key : sKeys) {
            if (!tKeys.contains(key)) {
                return false;
            }

            int occurences = sChars.get(key);
            if (tChars.get(key) != occurences) {
                return false;
            }
        }

        return true;
    }

    private Map<Character, Integer> getCharacterOccurences(String s) {
        Map<Character, Integer> occurences = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (occurences.containsKey(letter)) {
                int currentValue = occurences.get(letter);
                occurences.put(letter, ++currentValue);
            } else {
                occurences.put(letter, 0);
            }
        }
        return occurences;
    }
}
