class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // nums, occurence
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], 1);
            else if (map.containsKey(nums[i])) map.replace(nums[i], map.get(nums[i]) + 1);
       } 

    // convert the hashmap key-value EntrySet pair to a lsit of Map.EntrySet
    List<Map.Entry<Integer, Integer>> list =
    new ArrayList<>(map.entrySet());

    // then explicitly sort the list in reversed by passign the genereic types prior to calling a method of class Map.Entry for findign the largest
    list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());
    
    int res[] = new int[k];

    int count = 0;
    for (Map.Entry<Integer, Integer> entry : list) {
        if (count == k) break;
        res[count] = entry.getKey();
        count++;
    }
       return res;
    }
}
