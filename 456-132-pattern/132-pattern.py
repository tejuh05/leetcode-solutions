class Solution(object):
    def find132pattern(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """

        stack = []
        third = float('-inf')

        for i in range(len(nums) - 1, -1, -1):

            if nums[i] < third:
                return True

            while stack and nums[i] > stack[-1]:
                third = stack.pop()

            stack.append(nums[i])

        return False