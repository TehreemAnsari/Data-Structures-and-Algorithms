package chap4;

import java.util.*;

public class Question_4_9 {
	//https://www.careercup.com/question?id=5152424742354944
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(6);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(7);
		TreeNode node7 = new TreeNode(2);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node4.right = node7;
		node3.left = node5;
		node3.right = node6;

		Question_4_9 p = new Question_4_9();
		List<List<Integer>> result = p.getTreeList(node1);
		for (List l : result) {
			System.out.println(l);
		}
	}

	private List<List<Integer>> getTreeList(TreeNode node) {
		if (node.left == null && node.right == null) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(node.data);
			result.add(temp);
			return result;
		}

		List<List<Integer>> left = null;
		List<List<Integer>> right = null;
		if (node.left != null) {
			left = getTreeList(node.left);
		}

		if (node.right != null) {
			right = getTreeList(node.right);
		}

		if (left != null && right != null) {
			return getList(node, left, right);
		}

		return getList(node, left != null ? left : right);
	}

	private List<List<Integer>> getList(TreeNode root, List<List<Integer>> left, List<List<Integer>> right) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (List<Integer> l : left) {
			for (List<Integer> r : right) {
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(root.data);
				temp.addAll(l);
				temp.addAll(r);

				result.add(temp);
			}
		}

		for (List<Integer> r : right) {
			for (List<Integer> l : left) {
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(root.data);
				temp.addAll(r);
				temp.addAll(l);

				result.add(temp);
			}
		}

		return result;
	}

	private List<List<Integer>> getList(TreeNode root, List<List<Integer>> list) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (List<Integer> l : list) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(root.data);
			temp.addAll(l);

			result.add(temp);

		}
		return result;
	}

}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
	}
}
