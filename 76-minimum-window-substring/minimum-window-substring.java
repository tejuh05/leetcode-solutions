class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();

        // store frequency of t
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int count = t.length();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        // expand window
        for(int right = 0; right < s.length(); right++){

            char ch = s.charAt(right);

            // needed character found
            if(map.getOrDefault(ch, 0) > 0){
                count--;
            }

            map.put(ch, map.getOrDefault(ch, 0) - 1);

            // valid window
            while(count == 0){

                // update minimum window
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                // remove left character
                map.put(leftChar, map.getOrDefault(leftChar, 0) + 1);

                // character needed again
                if(map.get(leftChar) > 0){
                    count++;
                }

                left++;
            }
        }

        if(minLen == Integer.MAX_VALUE){
            return "";
        }

        return s.substring(start, start + minLen);
    }
}