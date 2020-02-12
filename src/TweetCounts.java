import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

class TweetCounts {
    private Map<String, TreeSet<Integer>> map;
    private Map<String, Integer> freqToInt;
    public TweetCounts() {
        this.map = new HashMap<>();
        this.freqToInt = new HashMap<>();
        freqToInt.put("minute", 60);
        freqToInt.put("hour", 3600);
        freqToInt.put("day", 3600 * 24);
    }

    public void recordTweet(String tweetName, int time) {
        if(!map.containsKey(tweetName)){
            map.put(tweetName, new TreeSet<>());
        }
        map.get(tweetName).add(time);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        if(!map.containsKey(tweetName)){
            return new ArrayList<>();
        }
        TreeSet<Integer> curTreeSet =  map.get(tweetName);
        int interval = freqToInt.get(freq);
        Iterator<Integer> iterator = curTreeSet.iterator();
        int length = endTime - startTime + 1;
        Integer[] tweetCounts = new Integer[length % interval == 0 ? length / interval : length / interval + 1];
        Arrays.fill(tweetCounts, 0);
        while(iterator.hasNext()){
            int tweetTime = iterator.next();
            if(tweetTime < startTime){
                continue;
            }
            if(tweetTime > endTime){
                break;
            }
            int curLength = tweetTime - startTime;
            tweetCounts[curLength / interval]++;
        }
        return Arrays.asList(tweetCounts);
    }
}