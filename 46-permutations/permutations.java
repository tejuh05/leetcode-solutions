import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> temp, boolean[] used, List<List<Integer>> result) {
        // If one permutation is complete
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // Try every unused number
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            temp.add(nums[i]);

            backtrack(nums, temp, used, result);

            // Backtrack
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}