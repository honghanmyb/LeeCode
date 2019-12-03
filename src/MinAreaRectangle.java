import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinAreaRectangle {
    public int minAreaRect(int[][] points) {
        if(points.length < 4){
            return 0;
        }
        int minArea = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> rows = new HashMap<>();
        Map<Integer, List<Integer>> columns = new HashMap<>();
        Arrays.sort(points, (point1, point2) -> {
            return point1[0] == point2[0]? point1[1] - point2[1] : point1[0] - point2[0];
        });
        for(int[] point: points){
            if(rows.containsKey(point[0])){
                rows.get(point[0]).add(point[1]);
            }else{
                List<Integer> columnPos = new ArrayList<>();
                columnPos.add(point[1]);
                rows.put(point[0], columnPos);
            }

            if(columns.containsKey(point[1])){
                columns.get(point[1]).add(point[0]);
            }else{
                List<Integer> rowPos = new ArrayList<>();
                rowPos.add(point[0]);
                columns.put(point[1], rowPos);
            }
        }
        for(int[] point: points){
            List<Integer> pointSameRow = rows.get(point[0]);
            if(pointSameRow.size() < 2){
                continue;
            }
            List<Integer> pointSameColumn = columns.get(point[1]);
            if(pointSameColumn.size() < 2){
                continue;
            }
            for(int y: pointSameRow){
                if(y <= point[1]){
                    continue;
                }
                Set<Integer> set = new HashSet<>();
                set.addAll(columns.get(y));
                for(int x: pointSameColumn){
                    if(x <= point[0]){
                        continue;
                    }
                    int possibleArea = Math.abs(y - point[1]) * Math.abs(x - point[0]);
                    if(possibleArea >= minArea){
                        continue;
                    }
                    if(set.contains(x)){
                        minArea = possibleArea;
                    }
                }
            }
        }

        return minArea == Integer.MAX_VALUE? 0: minArea;
    }
}
