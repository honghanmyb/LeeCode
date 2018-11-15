
public class UniqueBST {
	public int numTrees(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(n == 2) return 2;
		if(n == 3) return 5;
		int[] nums = new int[n + 1];
		boolean[] marks = new boolean[n + 1];
		for(int i = 0; i < n + 1; i++) marks[i] = false;
		nums[0] = 1; nums[1] = 1; nums[2] = 2; nums[3] = 5;
		for(int i = 0; i <= 3; i++) marks[i] = true;
		findNums(n, nums, marks);
		return nums[n];
	}
	
	private int findNums(int n, int[] nums, boolean[] marks) {
		if(marks[n] == true) return nums[n];
		int total = 0;
		for(int i = 0; i < n; i++) {
			int left = findNums(i, nums, marks);
			int right = findNums(n - 1 - i, nums, marks);
			total += (left * right);
		}
		marks[n] = true;
		nums[n] = total;
		return total;
	}

}
