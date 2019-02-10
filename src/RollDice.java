
public class RollDice {
	public int solution(int[] A) {
		if(A.length == 1) return 0;
		int[] countArray = new int[6];
		for(int i = 0; i < countArray.length; i++) {
			
			for(int j = 0; j < A.length; j++) {
				if(A[j] != i + 1) {
					countArray[i] += 1;
				}
				switch(i) {
					case 0:{//1
						if(A[j] == 6) {
							countArray[i] += 1;
						}
						continue;
					}
						
					case 1:{//2
						if(A[j] == 5) {
							countArray[i] += 1;
						}
						continue;
					}
						
					case 2:{//3
						if(A[j] == 4) {
							countArray[i] += 1;
						}
						continue;
					}
						
					case 3:{//4
						if(A[j] == 3) {
							countArray[i] += 1;
						}
						continue;
					}
						
					case 4:{//5
						if(A[j] == 2) {
							countArray[i] += 1;
						}
						continue;
					}
						
					default:{//6
						if(A[j] == 1) {
							countArray[i] += 1;
						}
						continue;
					}
				}
						
			}
		}
		
		int min = countArray[0];
		for(int i = 0; i < countArray.length; i++) {
			if(countArray[i] < min) min = countArray[i];
		}
		
		return min;
	}
}
