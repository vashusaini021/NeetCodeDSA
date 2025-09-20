import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> values = new HashMap<>();
        for (int itemKey : nums) {
            if (values.containsKey(itemKey)) {
                int newCount = values.get(itemKey) + 1;
                values.put(itemKey, newCount);
            } else {
                values.put(itemKey, 1);
            }
            //values.merge(itemKey, 1, Integer::sum);
        }

        @SuppressWarnings("unchecked")
        List<Integer>[] bLists = new List[nums.length + 1];

        for (int itm : values.keySet()) {
            int index = values.get(itm);
            if (bLists[index] == null) {
                bLists[index] = new ArrayList<>();
            }
            bLists[index].add(itm);
        }

        int[] finalList = new int[k];
        int finalCounter = 0;
        for (int i = bLists.length-1; i > 0; i--) {
            if (bLists[i] != null) {
                for (int item : bLists[i]) {
                    finalList[finalCounter++] = item;

                    if (finalCounter == k) {
                        return finalList;
                    }
                }
            }
        }
        return finalList;
    }
    
    public static void main(String[] args) {
        TopKFrequentElements tKFe = new TopKFrequentElements();
        int[] v = tKFe.topKFrequent(new int[] { 1, 2, 2, 3, 3, 3}, 2);

        for (int cc : v) {
        System.out.println(cc);
        }

    }
} 