
public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        boolean[] startPoint = new boolean[tree.length];
        startPoint[0] = true;
        int count = 1;
        for(int i = 1; i < tree.length; i++){
            if(tree[i] != tree[i - 1]){
                startPoint[i] = true;
                count++;
            }
        }
        int[][] table = new int[count][2];
        
        int max = 0;
        for(int i = 0; i < tree.length; i++){
            if(!startPoint[i]){
                continue;
            }
            int current = 0;
            int type1 = tree[i];
            int type2 = -1;
            for(int j = i; j < tree.length; j++){
                if(tree[j] == type1){
                    current++;
                }else if(type2 == -1){
                    type2 = tree[j];
                    current++;
                }else if(tree[j] == type2){
                    current++;
                }else{
                    break;
                }
            }
            max = Integer.max(max, current);
        }
        
        return max;
    }
}
