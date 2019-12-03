public class MostStonesRemovedWithSameRowOrColumn {
    public int removeStones(int[][] stones) {
        Node[] nodes = new Node[stones.length];
        int rootCount = stones.length;
        for(int i = 0; i < stones.length; i++){
            nodes[i] = new Node(stones[i][0], stones[i][1]);
        }
        for(int i = 0; i < nodes.length; i++){
            for(int j = i + 1; j < nodes.length; j++){
                if(nodes[i].x == nodes[j].x || nodes[i].y == nodes[j].y){
                    Node iFather = nodes[i].findFather();
                    Node jFather = nodes[j].findFather();
                    if(iFather != jFather){
                        if(iFather.count > jFather.count){
                            merge(iFather, jFather);
                        }else{
                            merge(jFather, iFather);
                        }
                        rootCount--;
                    }
                }
            }
        }
        return stones.length - rootCount;
    }

    private void merge(Node t, Node s){
        t.count += s.count;
        s.father = t;
        s.count = 0;
    }

    private class Node{
        int x;
        int y;
        Node father;
        int count;

        Node(int x, int y){
            this.x = x;
            this.y = y;
            this.count = 1;
            this.father = null;
        }

        Node findFather(){
            if(this.father == null){
                return this;
            }else{
                this.father = this.father.findFather();
                return this.father;
            }
        }
    }
}
