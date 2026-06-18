import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {

        if (s.isEmpty() || t.isEmpty()) return "";

        // frequency map for t
        HashMap<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        // frequency map for current window
        HashMap<Character, Integer> windowCount = new HashMap<>();

        int need = tCount.size(); // unique chars in t we need to satisfy
        int have = 0;             // unique chars currently satisfied

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0; // start of best window found

        for (int right = 0; right < s.length(); right++) {

            // add right character to window
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            // check if this char's requirement is now satisfied
            if (tCount.containsKey(c) && windowCount.get(c).equals(tCount.get(c))) {
                have++;
            }

            // shrink from left while window is valid
            while (have == need) {

                // update minimum window
                int windowLen = right - left + 1;
                if (windowLen < minLen) {
                    minLen = windowLen;
                    minLeft = left;
                }

                // remove leftmost character
                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);

                // check if removing it breaks the requirement
                if (tCount.containsKey(leftChar) && windowCount.get(leftChar) < tCount.get(leftChar)) {
                    have--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}