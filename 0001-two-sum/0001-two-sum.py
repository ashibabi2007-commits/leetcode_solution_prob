class Solution:
    def twoSum(self, nums, target):
        arr = []

        for i in range(len(nums)):
            arr.append([nums[i], i])

        arr.sort()

        l = 0
        r = len(arr) - 1

        while l < r:
            total = arr[l][0] + arr[r][0]

            if total == target:
                return [arr[l][1], arr[r][1]]

            elif total < target:
                l += 1

            else:
                r -= 1

        return [-1, -1]