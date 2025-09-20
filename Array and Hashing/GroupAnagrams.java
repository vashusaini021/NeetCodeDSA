import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Input: strs = ["act","pots","tops","cat","stop","hat"]
// Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> finalRelatabledata = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            int[] charValues = new int[26];
            for (Character ch : strs[i].toCharArray()) {
                charValues[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int alphabetPosition : charValues) {
                sb.append(alphabetPosition + '#');
            }


            finalRelatabledata
                    .computeIfAbsent(sb.toString(), k -> new ArrayList<>())
                    .add(strs[i]);

        }

        return new ArrayList<>(finalRelatabledata.values());
    }

}
