import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> mergedInterval = new ArrayList<>();
        for(List<Interval> intervals : schedule){
            mergedInterval.addAll(intervals);
        }
        mergedInterval = merge(mergedInterval);
        if(mergedInterval.size() == 1){
            return new ArrayList<>();
        }
        List<Interval> freeTime = new ArrayList<>();
        for(int i = 0; i < mergedInterval.size() - 1; i++){
            freeTime.add(new Interval(mergedInterval.get(i).end, mergedInterval.get(i + 1).start));
        }
        return freeTime;
    }

    private List<Interval> merge(List<Interval> schedule){
        Collections.sort(schedule, (interval1, interval2) -> {
            if(interval1.start != interval2.start) return interval1.start - interval2.start;
            return interval1.end - interval2.end;
        });
        Interval pending = null;
        List<Interval> merged = new ArrayList<>();
        for(Interval interval : schedule){
            if(pending == null){
                pending = interval;
                continue;
            }
            if(pending.end < interval.start){
                merged.add(pending);
                pending = interval;
            }else {
                pending.end = Math.max(pending.end, interval.end);
            }
        }
        merged.add(pending);
        return merged;
    }
    private class Interval{
        int start;
        int end;

        public Interval() {}

        Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }
}
