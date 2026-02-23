import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    //HashMap and Counting (Optimal) - Time Complexity: O(n * k) - Space Complexity: O(n * k)
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagrams = new HashMap<String, List<String>>();
        

        for(int i=0; i<strs.length;i++){

            int[] count = new int[26];
            for(char c:strs[i].toCharArray()){
                count[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                sb.append('#');
                sb.append(count[j]);
            }
            String key= sb.toString();

            if(!anagrams.containsKey(key)){
                anagrams.put(key,new ArrayList<>());
            }
            anagrams.get(key).add(strs[i]);            
        }

        return new ArrayList<>(anagrams.values());
    }
    //HashMap and Sorting - Time Complexity: O(n * k log k) - Space Complexity: O(n * k)
    public List<List<String>> groupAnagramsWithUsingSort(String[] strs) {
        HashMap<String, List<String>> anagrams = new HashMap<String, List<String>>();

        for(int i=0; i<strs.length;i++){
            char[] chars=strs[i].toCharArray();
            Arrays.sort(chars);
            String key= String.valueOf(chars);

            if(!anagrams.containsKey(key)){
                anagrams.put(key,new ArrayList<>());
            }
            anagrams.get(key).add(strs[i]);            
        }

        return new ArrayList<>(anagrams.values());
    }

    //Test Verisi
    public static void main(String[] args) {
        GroupAnagrams sol = new GroupAnagrams();
        String[] testCase = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println("--- Test Başlatıldı ---");
        System.out.println("Girdi: " + Arrays.toString(testCase));
        
        // Test: Counting Method
        System.out.println("\n[Method: Counting (Optimal)]");
        System.out.println("Sonuç: " + sol.groupAnagrams(testCase));

        // Test: Sorting Method
        System.out.println("\n[Method: Sorting]");
        System.out.println("Sonuç: " + sol.groupAnagramsWithUsingSort(testCase));
        System.out.println("\n--- Test Bitti ---");
    }
    
}
