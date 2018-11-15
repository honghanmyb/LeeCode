
public class RotateImg {
	public void rotate(int[][] img) {
		int n = img.length;
		for(int i = 0; i < img.length / 2; i++) {
			for(int j = i; j < img[0].length - 1 -i; j++) {
				int temp = img[i][j];
				
				img[i][j] = img[n - 1 -j][i];
				img[n - 1 -j][i] = img[n - 1 -i][n - 1 - j];
				img[n - 1 -i][n - 1 - j] = img[j][n - 1 - i];
				img[j][n - 1 - i] = temp;
			}
		}
	}
}
