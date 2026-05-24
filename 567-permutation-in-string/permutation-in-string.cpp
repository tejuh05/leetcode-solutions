class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) {
            return false;
        }

        vector<int> count1(26, 0);
        vector<int> count2(26, 0);

        // Frequency count for s1 and first window of s2
        for (int i = 0; i < n1; i++) {
            count1[s1[i] - 'a']++;
            count2[s2[i] - 'a']++;
        }

        // Check first window
        if (count1 == count2) {
            return true;
        }

        // Sliding window
        for (int i = n1; i < n2; i++) {
            // Add new character
            count2[s2[i] - 'a']++;

            // Remove old character
            count2[s2[i - n1] - 'a']--;

            // Compare frequencies
            if (count1 == count2) {
                return true;
            }
        }

        return false;
    }
};