import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SnakeGame {

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    private int curRow;
    private int curColumn;
    private int maxRow;
    private int maxColumn;
    private LinkedList<Integer> snake;
    private int curFoodPosIndex;
    private int[][] food;
    private Set<Integer> taken;
    public SnakeGame(int width, int height, int[][] food) {
        snake = new LinkedList<>();
        snake.addFirst(0);
        curRow = 0;
        curColumn = 0;
        curFoodPosIndex = 0;
        this.food = food;
        taken = new HashSet<>();
        taken.add(0);
        maxRow = height - 1;
        maxColumn = width - 1;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        switch(direction.charAt(0)){
            case 'U' :{
                --curRow;
                break;
            }
            case 'D' :{
                ++curRow;
                break;
            }
            case 'L' :{
                --curColumn;
                break;
            }
            default :{
                ++curColumn;
                break;
            }
        }

        if(curRow < 0 || curColumn < 0 || curRow > maxRow || curColumn > maxColumn){
            return -1;
        }
        int newCell = curRow * (maxColumn + 1) + curColumn;
        int foodRow = -1;
        int foodColumn = -1;
        if(curFoodPosIndex < food.length){
            foodRow = food[curFoodPosIndex][0];
            foodColumn = food[curFoodPosIndex][1];
        }
        if(curRow == foodRow && curColumn == foodColumn){
            curFoodPosIndex++;
        }else{
            int last = snake.removeLast();
            taken.remove(last);
        }
        if(taken.contains(newCell)){
            return -1;
        }
        taken.add(newCell);
        snake.addFirst(newCell);
        return snake.size() - 1;
    }
}
