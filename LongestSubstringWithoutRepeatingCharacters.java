import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {

    // The most optimal solution - l jumps directly to the next index
    // Time Complexity=O(n) Space Complexity=O(1) 
    public int lengthOfLongestSubstringWithIntegerArray(String s) {
        int l = 0, r = 0, longestSubstring = 0;
        int[] chars = new int[128];
        Arrays.fill(chars, -1);

        while (r < s.length()) {
            int lastSeen = chars[s.charAt(r)];

            if (lastSeen >= l) {
                l = lastSeen + 1;
            }
            chars[s.charAt(r)] = r;
            if ((r - l + 1) > longestSubstring) {
                longestSubstring = r - l + 1;
            }
            r++;
        }
        return longestSubstring;
    }
    // Space Complexity is worse - l jumps directly to the next index
    // Time Complexity=O(n) Space Complexity=O(Min(n,m)) 
    public int lengthOfLongestSubstringHashMap(String s) {
        int l=0, r=0, longestSubstring=0;
        HashMap<Character, Integer> chars=new HashMap<Character, Integer>();

        while(r<s.length()){
            Integer lastSeen= chars.put(s.charAt(r), r);

            if(lastSeen!=null && lastSeen>=l){
                l=lastSeen+1;                
            }
            if ((r - l + 1) > longestSubstring) {
                longestSubstring = r - l + 1;
            }
            r++;
        }
        return longestSubstring; 
    }
    // Space Complexity is worse - It changes the index of 'l' one by one
    // Time Complexity=O(n) Space Complexity=O(Min(n,m))
    public int lengthOfLongestSubstringWithHashSet(String s) {
        int l=0, r=0, longestSubstring=0;
        HashSet<Character> chars=new HashSet<Character>();

        while(r<s.length()){
            if(!chars.add(s.charAt(r))){
                while(l<r && s.charAt(l)!=s.charAt(r)){
                    chars.remove(s.charAt(l));
                    l++;
                }
                l++;         
            }
            if ((r - l + 1) > longestSubstring) {
                longestSubstring = r - l + 1;
            }
            r++;
        }
        return longestSubstring; 
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solver = new LongestSubstringWithoutRepeatingCharacters();

        String[] testStrings = {
            "abcabcbb",
            "bbbbb",
            "pwwkew",
            "",
            "abcdefg",
            "abba",
            "tmmzuxt"
        };

        System.out.println("=== Test Results ===\n");

        for (String test : testStrings) {
            System.out.println("Input: \"" + test + "\"");
            
            System.out.println("  -> Array Result  : " + solver.lengthOfLongestSubstringWithIntegerArray(test));
            System.out.println("  -> HashMap Result: " + solver.lengthOfLongestSubstringHashMap(test));
            System.out.println("  -> HashSet Result: " + solver.lengthOfLongestSubstringWithHashSet(test));
            System.out.println("---------------------------------------------------------");
        }
    }


}
