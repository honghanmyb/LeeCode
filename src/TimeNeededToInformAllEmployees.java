import java.util.ArrayList;
import java.util.List;

public class TimeNeededToInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Employee[] employees = new Employee[n];
        for(int i = 0; i < n; i++){
            employees[i] = new Employee(i);
        }
        for(int i = 0; i < n; i++){
            if(i == headID) continue;
            employees[manager[i]].subordinates.add(i);
        }
        return informTime(headID, employees, informTime);
    }

    private int informTime(int headId, Employee[] employees, int[] informTime){
        Employee curHead = employees[headId];
        if(informTime[curHead.id] == 0){
            return 0;
        }
        int maxSubordinateTime = -1;
        for(int subordinateId : curHead.subordinates){
            maxSubordinateTime = Math.max(maxSubordinateTime, informTime(subordinateId, employees, informTime));
        }
        return maxSubordinateTime + informTime[headId];
    }

    private class Employee{
        int id;
        List<Integer> subordinates;

        Employee(int id){
            this.id = id;
            this.subordinates = new ArrayList<>();
        }
    }
}
