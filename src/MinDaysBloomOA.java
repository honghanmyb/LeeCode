
public class MinDaysBloomOA {
	public int minDaysBloom(int[] roses, int k, int n) {
		if(roses.length < k) {
			return -1;
		}
		int head = roses[0], tail = roses[0];
		for(int rose: roses) {
			head = Integer.min(head, rose);
			tail = Integer.max(tail, rose);
		}
		if(canGetBouquet(roses, head, k, n)) {
			return head;
		}
		if(!canGetBouquet(roses, tail, k, n)) {
			return -1;
		}
		while(head <= tail) {
			int mid = head + (tail - head) / 2;
			if(canGetBouquet(roses, mid, k, n)) {
				tail = mid - 1;
			}else {
				head = mid + 1;
			}
		}
		return head;
	}
	
	private boolean canGetBouquet(int[] roses, int currentDay, int k, int n) {
		int bouquetCount = 0;
		int roseCount = 0;
		for(int rose: roses) {
			if(rose > currentDay) {
				roseCount = 0;
			}else {
				roseCount++;
				if(roseCount == k) {
					roseCount = 0;
					bouquetCount++;
				}
			}
		}
		return bouquetCount >= n;
	}
}
