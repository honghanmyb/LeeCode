import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AutocompleteSystem {
    private Node head;
    private Node curNode;
    private String curSentence;

    public AutocompleteSystem(String[] sentences, int[] times) {
        this.head = new Node('$', "");
        this.curNode = head;
        this.curSentence = "";
        for (int i = 0; i < times.length; i++) {
            insert(sentences[i], times[i], head, 0);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            curNode.time++;
            curNode = head;
            return new ArrayList<>();
        }
        if (!curNode.map.containsKey(c)) {
            curNode.map.put(c, new Node(c, curNode.sentence + c));
        }
        curNode = curNode.map.get(c);
        PriorityQueue<Node> pq = new PriorityQueue<>(3, (node1, node2) -> {
            if (node1.time != node2.time) {
                return node1.time - node2.time;
            }
            return node2.sentence.compareTo(node1.sentence);
        });
        searchCurNode(curNode, pq);
        if (pq.size() == 0) {
            return new ArrayList<>();
        }
        String[] sentences = new String[pq.size()];
        for (int i = sentences.length - 1; i >= 0; i--) {
            sentences[i] = pq.poll().sentence;
        }
        return Arrays.asList(sentences);
    }

    private void insert(String sentence, int time, Node curNode, int nextChIndex) {
        if (nextChIndex == sentence.length()) {
            curNode.time = time;
            return;
        }
        char nextCh = sentence.charAt(nextChIndex);
        if (!curNode.map.containsKey(nextCh)) {
            curNode.map.put(nextCh, new Node(nextCh, curNode.sentence + nextCh));
        }
        insert(sentence, time, curNode.map.get(nextCh), nextChIndex + 1);
    }

    private void searchCurNode(Node curNode, PriorityQueue<Node> pq) {
        if (curNode.time > 0) {
            addToPq(curNode, pq);
        }
        for (Map.Entry<Character, Node> entry : curNode.map.entrySet()) {
            searchCurNode(entry.getValue(), pq);
        }
    }

    private void addToPq(Node curNode, PriorityQueue<Node> pq) {
        if (pq.size() < 3) {
            pq.add(curNode);
            return;
        }
        Node headNode = pq.peek();
        if (curNode.time > headNode.time || curNode.time == headNode.time && curNode.sentence.compareTo(headNode.sentence) <= 0) {
            pq.poll();
            pq.add(curNode);
        }
    }

    private class Node {
        char ch;
        String sentence;
        int time;
        Map<Character, Node> map;

        Node(char ch, String sentence) {
            this.ch = ch;
            this.sentence = sentence;
            this.time = 0;
            this.map = new HashMap<>();
        }
    }
}
