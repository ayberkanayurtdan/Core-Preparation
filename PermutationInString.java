import java.util.Arrays;

public class PermutationInString {
    //Fixed Sliding Window (Highly Optimal) - Time Complexity= O(n) - Space Complexity= O(1)
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int[] chars = new int[26];
        int[] window = new int[26];
        int l=0,matches = 0;

        for(int i=0;i<s1.length();i++){
            chars[s1.charAt(i)-'a']+=1;
            window[s2.charAt(i)-'a']+=1;
        }

        for (int i = 0; i < 26; i++) {
        if (chars[i] == window[i]) matches++;
        }

        for(int r=s1.length();r<s2.length();r++){
            if (matches == 26) return true;

            if(window[s2.charAt(r)-'a']==chars[s2.charAt(r)-'a']) matches--;
            window[s2.charAt(r)-'a']+=1;
            if (window[s2.charAt(r)-'a']==chars[s2.charAt(r)-'a']) matches++;

            if(window[s2.charAt(l)-'a']==chars[s2.charAt(l)-'a']) matches--;
            window[s2.charAt(l)-'a']-=1;
            if(window[s2.charAt(l)-'a']==chars[s2.charAt(l)-'a']) matches++;

            l++  ;
        }
        return matches==26;    
    }
    //Fixed Sliding Window using Arrays library(Optimal) - Time Complexity= O(n * 26)=~O(n) - Space Complexity= O(1)
    public boolean checkInclusionWithArraysEquals(String s1, String s2) {

        if (s1.length() > s2.length()) return false;
        
        int[] chars = new int[26];
        int[] window = new int[26];
        int l=0;

        for(int i=0;i<s1.length();i++){
            chars[s1.charAt(i)-'a']+=1;
            window[s2.charAt(i)-'a']+=1;
        }
        if(Arrays.equals(chars,window)) return true;

        for(int r=s1.length();r<s2.length();r++){
            window[s2.charAt(r)-'a']+=1;
            window[s2.charAt(l)-'a']-=1;
            if(Arrays.equals(chars,window)){
                return true;
            }
            l++;
        }

        return false;
    }
}
