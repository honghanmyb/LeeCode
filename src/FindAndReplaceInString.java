import java.util.Arrays;
import java.util.Comparator;

public class FindAndReplaceInString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int offSet = 0;
        Node[] nodes = new Node[indexes.length];
        for(int i = 0; i < nodes.length; i++){
            nodes[i] = new Node(indexes[i], sources[i], targets[i]);
        }
        Arrays.sort(nodes, Comparator.comparingInt(node -> node.index));
        for(Node node : nodes){
            int startIndex = node.index + offSet;
            int endIndex = startIndex + node.source.length();
            String curS = S.substring(startIndex, endIndex);
            if(curS.equals(node.source)){
                S = S.substring(0, startIndex) + node.target + S.substring(endIndex);
                offSet += node.target.length() - node.source.length();
            }
        }
        return S;
    }

    private class Node{
        int index;
        String source;
        String target;

        Node(int index, String source, String target){
            this.index = index;
            this.source = source;
            this.target = target;
        }
    }
}
