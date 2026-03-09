import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeBasedKeyValueStore {
   public static class TimeMap {
    //Binary Search on Timestamps (Optimal) - Time: O(log n) - Space: O(n)
    private HashMap<String, List<Data>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<Data>());
        }
        map.get(key).add(new Data(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<Data> list=map.get(key);
        
        int left=0;
        int right=list.size()-1;
        String result="";

        while(left<=right){
            int middle = left + (right - left) / 2;
            int midTime = list.get(middle).timestamp;

            if(midTime<=timestamp){
                result=list.get(middle).value;
                left=middle+1;
            }else{
                right=middle-1;
            }
        }
        return result;

    }

    private static class Data{
        String value;
        int timestamp;

        Data(String value, int timestamp){
            this.value=value;
            this.timestamp=timestamp;
        } 
    }
}
}
