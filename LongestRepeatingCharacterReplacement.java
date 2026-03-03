import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int[] frequencyArr= new int[26];
        int l=0,r=0, maxFreq=0, maxLength=0;
        while(r<s.length()){
            frequencyArr[s.charAt(r)-'A']+=1;
            maxFreq=Math.max(maxFreq, frequencyArr[s.charAt(r)-'A']);

            if(r-l+1-maxFreq<=k){
                maxLength=Math.max(r-l+1,maxLength);
            }else{
                frequencyArr[s.charAt(l)-'A']-=1;
                l++;
            }
            r++;

        }
        return maxLength;

    }

    public int characterReplacementWithHashMap(String s, int k) {
        HashMap<Character,Integer> frequencyMap = new HashMap<>(26);
        int l=0,r=0, maxFreq=0, maxLength=0;
        while(r<s.length()){
            frequencyMap.put(s.charAt(r),frequencyMap.getOrDefault(s.charAt(r),0)+1);
            maxFreq=Math.max(maxFreq, frequencyMap.get(s.charAt(r)));

            if(r-l+1-maxFreq<=k){
                maxLength=Math.max(r-l+1,maxLength);
            }else{
                frequencyMap.put(s.charAt(l),frequencyMap.get(s.charAt(l))-1);
                l++;
            }
            r++;

        }
        return maxLength;

    }
    
}
