import java.util.HashMap;

class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> charsCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character sKey = s.charAt(i);
            if (charsCount.containsKey(sKey)) {
                charsCount.put(sKey, charsCount.get(sKey) + 1);
            } else {
                charsCount.put(sKey, 1);
            }

            Character tKey = t.charAt(i);
            if (charsCount.containsKey(tKey)) {
                charsCount.put(tKey, charsCount.get(tKey) - 1);
            } else {
                charsCount.put(tKey, -1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            Character key = t.charAt(i);
            if (charsCount.get(key) != 0){
                return false;
            } 
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        boolean isDuplicate = va.isAnagram("valid", "dilav");
        System.out.println(isDuplicate); // Output: true
    }

}