class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) return nums.length;;
        HashSet<Integer> set = new HashSet<>();
        
        Arrays.sort(nums);
        int max = -1;
        set.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 == nums[i - 1]) {
                set.add(nums[i]);
            }
            else {
                // duplicate checking
                if (set.contains(nums[i])) continue;
                // nums[i] + 1 != nums[i + 1]
                // a new sequence is encountered -> compute the current sequence length from previous LCS
                else {
                    // compute the curret max lcs between set size and max
                    max = Math.max(max, set.size());
                    // clear the set
                    set.clear();
                    // add the first element of the new lcs
                    set.add(nums[i]);
                }
            }
           
        }

        // when there exist no break of lcs in one pass, compute max between -1 & one-pass result
        // or the lcs is in trailing array, and the previous max was recorded, the new lcs was never recorded into max, so compute the max between previous and new.
        return Math.max(max, set.size());
    }
}
