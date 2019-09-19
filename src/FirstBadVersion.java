
public class FirstBadVersion {
	public int firstBadVersion(int n) {
        if(isBadVersion(1)){
            return 1;
        }
        boolean findBadVersion = false;
        int head = 1, tail = n;
        while(!findBadVersion){
            int headMod = head % 2;
            int tailMod = tail % 2;
            int mid = head /2 + tail / 2 + (headMod + tailMod) / 2;
            if(isBadVersion(mid)){
                tail = mid;
                if(head == mid - 1){
                    return mid;
                }
            }else{
                head = mid;
                if(tail == mid + 1){
                    return tail;
                }
            }
            
        }
        return head + 1;
	}
	
	/**
	 * This is an API provided by Leecode, so this method cannot run properly locally.
	 */
	private boolean isBadVersion(int n) {
		return false;
	}
}
