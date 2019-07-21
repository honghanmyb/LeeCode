
public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int xA = A, yA = B, xB = C, yB = D, xC = E, yC = F, xD = G, yD = H;
		int areaA = (xB - xA) * (yB - yA);
		int areaB = (xD - xC) * (yD - yC);
		int overlay;
		if(xC >= xB || xA >= xD || yA >= yD || yC >= yB) {
			overlay = 0;
		}else {
		int xOverlay = Math.min(xD, xB) - Math.max(xA, xC);
		int yOverlay = Math.min(yB, yD) - Math.max(yA, yC);
		overlay = xOverlay * yOverlay;
		}
		
		return areaA + areaB - overlay;
	}
}
