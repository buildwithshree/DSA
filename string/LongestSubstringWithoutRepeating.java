package string;

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            // shrink window from left until duplicate is removed
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            // now safe to add current character
            set.add(c);

            // update max length found so far
            int windowSize = right - left + 1;
            maxLen = Math.max(maxLen, windowSize);
        }

        return maxLen;
    }
}
