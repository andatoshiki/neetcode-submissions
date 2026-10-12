class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) return nums.length;;
        HashSet<Integer> set = new HashSet<>();
        
        Arrays.sort(nums);
        int max = -1;
        int curr = nums[0];
        set.add(curr);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 == nums[i - 1]) {
                curr = nums[i];
                set.add(curr);
            }
            else {
                // duplicate checking
                if (set.contains(nums[i])) continue;
                // nums[i] + 1 != nums[i + 1]
                else {
                    max = Math.max(max, set.size());
                    set.clear();
                    set.add(nums[i]);
                }
            }
           
        }

        return Math.max(max, set.size());
    }
}
