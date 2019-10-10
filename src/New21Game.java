import java.util.Arrays;

public class New21Game {
    public double new21Game(int N, int K, int W) {
        if(N < K){
            return 0.00;
        }
        if(N >= K + W - 1) {
            return 1.0;
        }
        if(K == 0){
            return 1.0;
        }
        double[] elementP = new double[N + 1];
        elementP[0] = 1;
        double total = 1;
        double p = 0;
        for(int i = 1; i < elementP.length; i++){
            elementP[i] = total / W;
            if(i >= W){
                total -= elementP[i - W];
            }
            if(i < K){
                total += elementP[i];
            }else {
                p += elementP[i];
            }
        }

        return Math.min(p, 1);
    }
}
