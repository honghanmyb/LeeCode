import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSystem {
    private Node origin;

    public FileSystem() {
        this.origin = new Node("#", false);
    }

    public List<String> ls(String path) {
        Node node = path.equals("/") ? origin : getToPath(path);
        if (node.isFile) {
            return Collections.singletonList(node.name);
        }
        List<String> names = new ArrayList<>(node.directory.size());
        names.addAll(node.directory.keySet());
        Collections.sort(names);
        return names;
    }

    public void mkdir(String path) {
        if (path.equals("/")) {
            return;
        }
        getToPath(path);
    }

    public void addContentToFile(String filePath, String content) {
        Node node = getToPath(filePath);
        node.isFile = true;
        node.content += content;
    }

    public String readContentFromFile(String filePath) {
        int lastSlash = filePath.lastIndexOf('/');
        String path = filePath.substring(0, lastSlash);
        String fileName = filePath.substring(lastSlash + 1);
        Node node = getToPath(filePath);
        return node.content;
    }

    private Node getToPath(String path) {
        if (path.isEmpty() || path.equals("/")) {
            return origin;
        }
        Node curNode = origin;
        path = path.charAt(0) == '/' ? path.substring(1) : path;
        String[] paths = path.split("/");
        for (String pathElement : paths) {
            if (curNode.directory.containsKey(pathElement)) {
                curNode = curNode.directory.get(pathElement);
            } else {
                Node nextNode = new Node(pathElement, false);
                curNode.directory.put(pathElement, nextNode);
                curNode = nextNode;
            }
        }
        return curNode;
    }

    private class Node {
        String name;
        Map<String, Node> directory;
        boolean isFile;
        String content = "";

        Node(String name, boolean isFile) {
            this.name = name;
            this.directory = new HashMap<>();
            this.isFile = isFile;
        }
    }
}