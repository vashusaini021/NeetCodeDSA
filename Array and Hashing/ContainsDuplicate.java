import java.util.HashMap;

class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i : nums) {
            if (counter.containsKey(i)) {
                return true;
            } else {
                counter.put(i, 1);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        boolean isDuplicate = cd.hasDuplicate(new int[] { 1, 2, 3, 1 });
        System.out.println(isDuplicate); // Output: true
    }
}