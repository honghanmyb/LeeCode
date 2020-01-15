import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RobotRoomCleaner {
    private Set<Point> cleaned;

    public void cleanRoom(Robot robot) {
        this.cleaned = new HashSet<>();
        cleanCurrent(new Point(0, 0), robot);
    }

    private void cleanCurrent(Point curPoint, Robot robot) {
        cleaned.add(curPoint);
        robot.clean();
        Point upPoint = new Point(curPoint.x - 1, curPoint.y);
        Point leftPoint = new Point(curPoint.x, curPoint.y - 1);
        Point rightPoint = new Point(curPoint.x, curPoint.y + 1);
        Point downPoint = new Point(curPoint.x + 1, curPoint.y);
        if (!cleaned.contains(upPoint) && moveFront(robot)) {
            cleanCurrent(upPoint, robot);
            moveBack(robot);
        }
        if (!cleaned.contains(rightPoint) && moveRight(robot)) {
            cleanCurrent(rightPoint, robot);
            moveLeft(robot);
        }
        if (!cleaned.contains(downPoint) && moveBack(robot)) {
            cleanCurrent(downPoint, robot);
            moveFront(robot);
        }
        if (!cleaned.contains(leftPoint) && moveLeft(robot)) {
            cleanCurrent(leftPoint, robot);
            moveRight(robot);
        }
    }

    private boolean moveFront(Robot robot) {
        return robot.move();
    }

    private boolean moveLeft(Robot robot) {
        robot.turnLeft();
        boolean canMove = robot.move();
        robot.turnRight();
        return canMove;
    }

    private boolean moveRight(Robot robot) {
        robot.turnRight();
        boolean canMove = robot.move();
        robot.turnLeft();
        return canMove;
    }

    private boolean moveBack(Robot robot) {
        robot.turnLeft();
        robot.turnLeft();
        boolean canMove = robot.move();
        robot.turnLeft();
        robot.turnLeft();
        return canMove;
    }

    private class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Point)) {
                return false;
            }
            Point c = (Point) o;
            return this.x == c.x && this.y == c.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
