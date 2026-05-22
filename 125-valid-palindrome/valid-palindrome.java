class Solution {
    public boolean isPalindrome(String s) {
        int p1 =0, p2 = s.length()-1;
        s= s.toLowerCase();
        while (p1 < p2){
            char c1 = s.charAt(p1);
            char c2 = s.charAt(p2);

            if(!(c1 >= 'a' && c1 <= 'z' || c1 >='0' && c1 <= '9')){
                p1++;
                continue;
            }
            if(!(c2 >= 'a' && c2 <= 'z' || c2 >='0' && c2 <= '9')){
                p2--;
                continue;
            }

            if (c1 != c2){
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}