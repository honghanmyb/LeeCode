import java.util.TreeSet;

public class MyCalendar {
    private TreeSet<int[]> set;
    public MyCalendar() {
        this.set = new TreeSet<>((interval1, interval2) -> interval1[0] - interval2[0]);
        set.add(new int[]{0, 1000000000});
    }

    public boolean book(int start, int end) {
        int[] curInterval = new int[]{start, end};
        int[] floor = set.floor(curInterval);
        if(floor != null && floor[0] <= curInterval[0] && floor[1] >= curInterval[1]){
            set.remove(floor);
            if(floor[0] < curInterval[0]){
                set.add(new int[]{floor[0], curInterval[0]});
            }
            if(floor[1] > curInterval[1]){
                set.add(new int[]{curInterval[1], floor[1]});
            }
            return true;
        }
        return false;
    }
}
