import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<>();
        }
        int[] counts = new int[nums.length];
        counts[counts.length - 1] = 0;
        Node root = new Node(nums[nums.length - 1], 0, 0);
        for(int i = nums.length - 2; i >= 0; i--){
            insertNode(nums[i], root, 0, counts, i);
        }
        List<Integer> countList = new ArrayList<>();
        for(int count: counts){
            countList.add(count);
        }
        return countList;
    }
    
    private void insertNode(int val, Node node, int leftChildCount, int[] counts, int index){
        node.previousLeftChildCount = leftChildCount;
        if(node.val == val){
            counts[index] = node.previousLeftChildCount + node.directLeftChildCount + node.turnRightCount;
            node.duplicate += 1;
            return;
        }
        if(node.val < val){
            int totalLeftCount = node.previousLeftChildCount + node.directLeftChildCount + node.duplicate;
            if(node.right == null){
                node.right = new Node(val, totalLeftCount, node.turnRightCount + 1);
                counts[index] = totalLeftCount + node.turnRightCount + 1;
            }else{
                insertNode(val, node.right, totalLeftCount, counts, index);
            }
            return;
        }
        if(node.val > val){
            node.directLeftChildCount += 1;
            if(node.left == null){
                Node leftNode = new Node(val, node.previousLeftChildCount, node.turnRightCount);
                node.left = leftNode;
                counts[index] = leftNode.previousLeftChildCount + node.turnRightCount;
            }else {
                insertNode(val, node.left, node.previousLeftChildCount, counts, index);
            }
        }
    }
    
    private class Node{
        int val;
        int previousLeftChildCount;
        int directLeftChildCount;
        int turnRightCount;
        int duplicate;
        Node left;
        Node right;
        
        public Node(int val, int previousLeftChildCount, int turnRightCount){
            this.val = val;
            this.previousLeftChildCount = previousLeftChildCount;
            this.turnRightCount = turnRightCount;
            this.directLeftChildCount = 0;
            this.duplicate = 0;
        }
    }
}
