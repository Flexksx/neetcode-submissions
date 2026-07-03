class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> occurencesToStrings = new HashMap<>();

        for (String str : strs) {
            Map<Character, Integer> currentOccurences = getCharacterOccurences(str);
            occurencesToStrings.computeIfAbsent(currentOccurences, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(occurencesToStrings.values());
    }

    private Map<Character, Integer> getCharacterOccurences(String s) {
        Map<Character, Integer> occurences = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            occurences.put(c, occurences.getOrDefault(c, 0) + 1);
        }
        return occurences;
    }
}
