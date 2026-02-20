//import java.util.HashMap;

public class ValidAnagram {
    
    public boolean isAnagram(String s, String t){

        if(s.length()!=t.length()){return false;}

        int[] charCounts = new int[26];
        for(int i=0;i<s.length();i++){
            charCounts[s.charAt(i)-'a']++;
            charCounts[t.charAt(i) -'a']--;
        }

        for(int count:charCounts){
            if(count!=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ValidAnagram solver = new ValidAnagram();

        // Test Case 1: Anagram olanlar
        String s1 = "anagram", t1 = "nagaram";
        System.out.println("Case 1: " + solver.isAnagram(s1, t1));

        // Test Case 2: Farklı karakterler
        String s2 = "rat", t2 = "car";
        System.out.println("Case 2: " + solver.isAnagram(s2, t2));

        // Test Case 3: Farklı uzunluklar
        String s3 = "a", t3 = "ab";
        System.out.println("Case 3: " + solver.isAnagram(s3, t3));
    }
    
    
    
    //Eğer charsetimiz sadece ingizizce karakterler için değilse bunu kullanabiliriz
    /*public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> countS= new HashMap<>();
        HashMap<Character,Integer> countT= new HashMap<>();
        if(s.length()==t.length()){
            for(int i=0;i<s.length();i++){
                if(countS.containsKey(s.charAt(i))){
                    countS.put(s.charAt(i), countS.get(s.charAt(i))+1);
                }else{
                    countS.put(s.charAt(i),1);
                }
                if(countT.containsKey(t.charAt(i))){
                    countT.put(t.charAt(i), countT.get(t.charAt(i))+1);
                }else{
                    countT.put(t.charAt(i),1);
                }
            }

            if(countS.equals(countT))
                return true;
        }
        return false;
        
    }*/
}
    

