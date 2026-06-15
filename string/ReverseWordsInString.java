package string;

class Solution {
    public String reverseWords(String s) {

        // trim + split on one or more spaces
        String[] words = s.trim().split("\\s+");

        StringBuilder result = new StringBuilder();

        // walk from last word to first
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);

            if (i != 0) {
                result.append(" "); // space between words, not after last
            }
        }

        return result.toString();
    }
}
