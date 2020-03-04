import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> mergedInterval = schedule.get(0);
        for(int i = 1; i < schedule.size(); i++){
            mergedInterval = merge(mergedInterval, schedule.get(i));
        }
        if(mergedInterval.size() == 1){
            return new ArrayList<>();
        }
        List<Interval> freeTime = new ArrayList<>();
        for(int i = 0; i < mergedInterval.size() - 1; i++){
            freeTime.add(new Interval(mergedInterval.get(i).end, mergedInterval.get(i + 1).start));
        }
        return freeTime;
    }

    private List<Interval> merge(List<Interval> schedule1, List<Interval> schedule2){
        schedule1.addAll(schedule2);
        Collections.sort(schedule1, (interval1, interval2) -> {
            if(interval1.start != interval2.start) return interval1.start - interval2.start;
            return interval1.end - interval2.end;
        });
        Interval pending = null;
        List<Interval> merged = new ArrayList<>();
        for(Interval interval : schedule1){
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
