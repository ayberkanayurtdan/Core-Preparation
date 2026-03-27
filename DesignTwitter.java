import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DesignTwitter {
    class Twitter {
    private int timestamp=0;
    private Map<Integer,Set<Integer>> followMap=new HashMap<>();
    private Map<Integer,List<int[]>> userTweets=new HashMap<>();

    public Twitter() {

    }
    // HashMap Append (Optimal) - Time Complexity: O(1) - Space Complexity: O(1)
    public void postTweet(int userId, int tweetId) {
        userTweets.computeIfAbsent(userId,k-> new ArrayList<>()).add(new int[]{tweetId,timestamp++});
    }
    // PriorityQueue and Merge K Sorted Lists (Optimal) - Time Complexity: O(K log K) - Space Complexity: O(K)
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> b[1]-a[1]);
        if(userTweets.containsKey(userId)){
            List<int[]> ownTweets=userTweets.get(userId);
            int lastIndex=ownTweets.size()-1;
            int[] tw=ownTweets.get(lastIndex);
            pq.offer(new int[]{tw[0],tw[1],userId,lastIndex});
        }
        Set<Integer> followed=followMap.getOrDefault(userId,new HashSet<>());
        for(int fId:followed){
            if(userTweets.containsKey(fId)){
                List<int[]> fTweets=userTweets.get(fId);
                int lastIndex=fTweets.size()-1;
                int[] tw=fTweets.get(lastIndex);
                pq.offer(new int[]{tw[0],tw[1],fId,lastIndex});
            }
        }
        List<Integer> res=new ArrayList<>();
        while(!pq.isEmpty()&&res.size()<10){
            int[] curr=pq.poll();
            res.add(curr[0]);

            int uId=curr[2];
            int index=curr[3]-1;
            if(index>=0){
                int[] nextTw=userTweets.get(uId).get(index);
                pq.offer(new int[]{nextTw[0],nextTw[1],uId,index});
            }
        }
        return res;
    }
    // HashSet Insertion (Optimal) - Time Complexity: O(1) - Space Complexity: O(1)
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId) return;
        followMap.computeIfAbsent(followerId,k-> new HashSet<>()).add(followeeId);
    }
    // HashSet Removal (Optimal) - Time Complexity: O(1) - Space Complexity: O(1)
    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId) return;
        if(followMap.containsKey(followerId)) followMap.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
}
