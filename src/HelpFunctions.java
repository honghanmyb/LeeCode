
public class HelpFunctions {
	public static void printATree(TreeNode root) {
		if(root != null) {
			HelpFunctions.printATree(root.left);
			System.out.print(root.val + " ");
			HelpFunctions.printATree(root.right);
			
		}
	}
}
