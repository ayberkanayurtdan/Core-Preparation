public class ValidPalindrome {

    public boolean isPalindrome(String s) { //optimal solution  //Time complexity=O(n)  //Space Complexity= O(1)
        int l=0,r=s.length()-1;

        while(l<=r){
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            if(Character.toLowerCase(s.charAt(l))!= Character.toLowerCase(s.charAt(r)))
                return false;

            l++;
            r--;
        }
        return true;
    }

    //Worse solution    Time complexity= O(n) Space Complexity= O(1)
    public boolean isPalindromeWithStringBuilder(String s) {    
        StringBuilder cleanedString = new StringBuilder();

        String originalString;
        String reversedString;

        //if we use this block Space Complexity becomes O(n) due to the extra array 
        //used toCharArray() instead of charAt(i)  
        
        /* 
        for(char c : s.toCharArray()){ 
            if(Character.isLetterOrDigit(c)){ 
                cleanedString.append(Character.toLowerCase(c));
            }
        }
        */

        //I prefer charAt(i) to keep it more memory-efficient where possibly
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);         
            if(Character.isLetterOrDigit(c)){   
                cleanedString.append(Character.toLowerCase(c));
            }
        }
        
        originalString=cleanedString.toString();
        cleanedString.reverse();
        reversedString=cleanedString.toString();

        if(originalString.equals(reversedString)){
            return true;
        }
        return false;
    }
    
    //main method for tests
    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();

        // Test Cases
        String[] testCases = {
            "A man, a plan, a canal: Panama", 
            "race a car",                     
            " ",                              
            "Was it a car or a cat I saw?",   
            "No 'x' in Nixon"                 
        };

        System.out.println("--- Palindrome Results ---");

        for (String test : testCases) {
            System.out.println("\nCase: \"" + test + "\"");
            
            // 1. Optimal Solution
            boolean res1 = vp.isPalindrome(test);
            System.out.println("Optimal (Two Pointers) test: " + res1);

            // 2. StringBuilder Solution
            boolean res2 = vp.isPalindromeWithStringBuilder(test);
            System.out.println("StringBuilder test: " + res2);
            
            System.out.println("---------------------------------");
        }
    }
}
