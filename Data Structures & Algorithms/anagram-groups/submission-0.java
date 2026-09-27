class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        // Store sorted versions of each string
        ArrayList<char[]> arr = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            arr.add(charArr);
        }

        // Remember which strings have already been grouped
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < arr.size(); i++) {

            // Already belongs to a previous group
            if (visited.contains(i)) {
                continue;
            }

            List<String> group = new ArrayList<>();

            // i is the base string
            group.add(strs[i]);
            visited.add(i);

            // Find all later strings matching i
            for (int j = i + 1; j < arr.size(); j++) {
                if (Arrays.equals(arr.get(i), arr.get(j))) {
                    group.add(strs[j]);
                    visited.add(j);
                }
            }

            // Finished building this group
            res.add(group);
        }

        return res;
    }
}