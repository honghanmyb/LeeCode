import java.util.LinkedList;

public class SnakeGame {

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    private int screenWidth;
    private int screenHeight;
    private LinkedList<int[]> snake;
    private int curFoodPosIndex;
    private int[][] food;
    private boolean[][] taken;
    public SnakeGame(int width, int height, int[][] food) {
        int[] head = new int[]{0, 0};
        snake = new LinkedList<>();
        snake.addFirst(head);
        curFoodPosIndex = 0;
        this.food = food;
        this.taken = new boolean[height][width];
        this.taken[0][0] = true;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] head = snake.getFirst();
        int newHeadRow = head[0];
        int newHeadColumn = head[1];
        switch(direction.charAt(0)){
            case 'U' :{
                --newHeadRow;
                break;
            }
            case 'D' :{
                ++newHeadRow;
                break;
            }
            case 'L' :{
                --newHeadColumn;
                break;
            }
            default :{
                ++newHeadColumn;
                break;
            }
        }

        if(newHeadRow < 0 || newHeadColumn < 0 || newHeadRow >= this.taken.length || newHeadColumn >= this.taken[0].length){
            return -1;
        }
        int[] newCell = new int[]{newHeadRow, newHeadColumn};
        int foodRow = -1;
        int foodColumn = -1;
        if(curFoodPosIndex < food.length){
            foodRow = food[curFoodPosIndex][0];
            foodColumn = food[curFoodPosIndex][1];
        }
        if(newHeadRow == foodRow && newHeadColumn == foodColumn){
            curFoodPosIndex++;
        }else{
            int[] last = snake.removeLast();
            this.taken[last[0]][last[1]] = false;
        }
        if(this.taken[newCell[0]][newCell[1]]){
            return -1;
        }
        this.taken[newCell[0]][newCell[1]] = true;
        snake.addFirst(newCell);
        return snake.size() - 1;
    }
}
