import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class RaceCar {
    public int racecar(int target) {
        Queue<Node> queue = new LinkedList<>();
        Node firstNode = new Node(0, 1);
        Node flag = new Node(0, 0);
        int stepCount = 0;
        Set<Node> set = new HashSet<>();
        int exp = 1;
        while(exp < target){
            exp *= 2;
        }
        queue.add(firstNode);
        queue.add(flag);

        while(true){
            Node curNode = queue.poll();
            // System.out.println(curNode.pos + ", " + curNode.speed);
            if(curNode == flag){
                ++stepCount;
                queue.add(flag);
                continue;
            }
            if(curNode.pos == target){
                break;
            }
            if(set.contains(curNode)){
                continue;
            }
            set.add(curNode);
            Node nextNode = new Node(curNode.pos + curNode.speed, curNode.speed * 2);
            Node reverseNode = new Node(curNode.pos, curNode.speed > 0 ? -1 : 1);
            addNodeToQueue(nextNode, queue, set, exp);
            addNodeToQueue(reverseNode, queue, set, exp);
        }
        return stepCount;
    }

    private void addNodeToQueue(Node node, Queue<Node> queue, Set<Node> set, int target){
        if(Math.abs(node.pos) <= target && !set.contains(node)){
            queue.add(node);
        }
    }

    private class Node{
        int pos;
        int speed;

        Node(int pos, int speed){
            this.pos = pos;
            this.speed = speed;
        }
        @Override
        public boolean equals(Object o){
            if(o == this){
                return true;
            }
            if(! (o instanceof Node)){
                return false;
            }
            Node c = (Node) o;
            return this.pos == c.pos && this.speed == c.speed;
        }

        @Override
        public int hashCode(){
            return Objects.hash(this.pos, this.speed);
        }
    }
}
