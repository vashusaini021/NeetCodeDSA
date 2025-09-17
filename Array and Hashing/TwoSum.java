import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {


        HashMap<Integer, Integer> indecesValues = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indecesValues.put(nums[i], i);
        }

        System.out.println(indecesValues);
        
        for (int i = 0; i < nums.length; i++) {
            if (indecesValues.containsKey(target - nums[i]) && indecesValues.get(target - nums[i]) != i) {
                int[] c = new int[] { i, indecesValues.get(target - nums[i]) };
                
                System.out.printf("%d %d%n", c[0], c[1]);
                return c;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        TwoSum tSum = new TwoSum();
        tSum.twoSum(new int[] { 1, 3, 4, 2}, 6);
    }
}
