package src;

public class IsThisABinarySearchTree {
	public static void main(String args[]) {
		
	}
	
	private static boolean checkBSTHelper(BSTNode root, int min, int max) {
		if(root == null)
			return true;
		if(root.data < min || root.data > max)
			return false;
		return checkBSTHelper(root.left, min, root.data - 1) && checkBSTHelper(root.right, root.data + 1, max);		
	}
	
	public static boolean checkBST(BSTNode root) {
		return checkBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
}


class BSTNode {
	int data;
	BSTNode left;
	BSTNode right;
}
