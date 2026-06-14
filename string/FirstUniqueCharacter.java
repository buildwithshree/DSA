package string;

class Solution {
    public int firstUniqChar(String s) {

        int[] count = new int[26]; // for lowercase a-z

        // pass 1: count frequency
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // pass 2: find first char with count 1
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i; // found first unique char
            }
        }

        return -1; // no unique character
    }
}
