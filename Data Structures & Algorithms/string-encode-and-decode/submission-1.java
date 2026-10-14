class Solution {

    public String encode(List<String> strs) {
        String res = "";
        for (String s : strs) {
            res = res + (Integer.toString(s.length()) + '#' + s);
        }

        return res;
    }

    public List<String> decode(String str) {
        // handle special case of empty string, if empty string presents
        // then the encoding would be 0#"", hereby length = 2 indicates that
        if (str.length() == 2) return new ArrayList<>(List.of(""));
        List<String> res = new ArrayList<>();
        int i = 0;
        int length = 0;
        while (i < str.length()) {
            // when the character is yet to be #, that simply means the length of a single string is not yet to be calculated
            if (str.charAt(i) != '#') {
                length = length * 10 + (str.charAt(i) - '0');
                // increment to next digit
                i++;
            }
            else if (str.charAt(i) == '#') {
                // here i lands exactly at where the # is, so the valid starting index of the string would be i + 1, and use substring method to extract the string
                // store in the list
                // the ending index of the string would be i + 1 + length as the last index is exclusive
                String decodedWord = str.substring(i + 1, i + 1 + length);
                res.add(decodedWord);

                // after string is added, increment the i to the ending index of decodedString + 1, as that's the new starting, effectively i + 1 + length
                i = i + (1 + length);
                // reset the length
                length = 0;
            }
        }

        return res;
    }
}
