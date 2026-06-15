package string;

class Solution {
    public String longestCommonPrefix(String[] strs) {

        String reference = strs[0]; // take first string as base

        for (int i = 0; i < reference.length(); i++) {
            char c = reference.charAt(i);

            // check this character against every other string
            for (int j = 1; j < strs.length; j++) {

                // if this string is too short OR char doesn't match
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return reference.substring(0, i); // return prefix so far
                }
            }
        }

        return reference; // entire first string is the common prefix
    }
}
