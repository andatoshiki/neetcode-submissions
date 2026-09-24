class Solution {
    public int[] twoSum(int[] nums, int target) {
        // num : index
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (map.containsKey(comp) && map.get(comp) != i) {
                int[] res = new int[2];
                res[0] = i;
                res[1] = map.get(comp);
                Arrays.sort(res);
                return res;
                // return new int[]{i, map.get(comp)};
            }
        }

        return new int[]{};
    }
}
