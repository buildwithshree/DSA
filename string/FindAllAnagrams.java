package string;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) return result; // can't fit window

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // build initial counts: pCount for p, sCount for first window in s
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        // check first window
        if (matches(pCount, sCount)) {
            result.add(0);
        }

        // slide the window across rest of s
        for (int i = p.length(); i < s.length(); i++) {

            // add new character entering window (rightmost)
            sCount[s.charAt(i) - 'a']++;

            // remove character leaving window (leftmost)
            sCount[s.charAt(i - p.length()) - 'a']--;

            // check if current window matches
            if (matches(pCount, sCount)) {
                result.add(i - p.length() + 1); // window start index
            }
        }

        return result;
    }

    // helper: compares two count arrays
    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
