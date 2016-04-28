import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class TreeNode{
	TreeNode left;
	int data;
	TreeNode right;
	
	TreeNode(int data){
		this.data=data;
	}
}


public class Tree {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node=new TreeNode(1);
		
		node.left=new TreeNode(2);
		node.right=new TreeNode(3);
		
		node.left.left=new TreeNode(4);
		node.left.right=new TreeNode(5);
		node.right.left=new TreeNode(6);
		node.right.right=new TreeNode(7);
		
		//node.left.left.left=new TreeNode(8);
		
		//printUpperView(node);
	printAncestors(node, 7);

	}
	static boolean printAncestors(TreeNode node, int target) {
        
        /* base cases */
       if (node == null) {
           return false;
       }

       if (node.data == target) {
           return true;
       }

       /* If target is present in either left or right subtree of this node,
        then print this node */
       if (printAncestors(node.left, target)
               || printAncestors(node.right, target)) {
           System.out.print(node.data + " ");
           return true;
       }

       /* Else return false */
       return false;
   }
	
	static void	printLevelAt(TreeNode node,int level){
		if(node==null)
			return;
		if(level==0)
			System.out.print(node.data);
		printLevelAt(node.left, level-1);
		printLevelAt(node.right, level-1);
			
		}


	
	static int height(TreeNode node){
		if(node==null)
			return 0;
		int leftHt=height(node.left);
		int rightHt=height(node.right);
		return leftHt>rightHt?(leftHt+1):(rightHt+1);
		
	}
	static int htDiff(TreeNode node){
		if(node==null)
			return 0;
		int l=height(node.left);
		int r=height(node.right);
		return l-r;
		
	}
	
	
	static boolean areLeavesAtSameLevel(TreeNode root){
		if(root==null)
			return true;
			
		TreeNode tmp;
		int currentLevel=0,leaveLevel=0;
		Queue<TreeNode>q=new LinkedList<>();
		q.offer(root);
		q.offer(null);
		while(!q.contains(null)){
			tmp=q.poll();
			if(tmp!=null){
				//System.out.print(tmp.data+" ");
				
				if(tmp.left!=null)
					q.offer(tmp.left);
				if(tmp.right!=null)
					q.offer(tmp.right);
				if(tmp.left==null&&tmp.right==null)
				{
					if(leaveLevel==0)
						leaveLevel=currentLevel;
					else if(currentLevel!=leaveLevel)
						return false;	
				}
			}
			else
			{   
				//System.out.println();
				q.offer(null);
				currentLevel++;
			}
			
		}
		return true;
	
		
	}
	
	static boolean isStrictBinaryTree(TreeNode root){
		if(root==null)
			return true;
		TreeNode tmp=null;
		Queue<TreeNode>q=new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()){
			tmp=q.poll();
				if(tmp.left!=null&&tmp.right!=null){
					q.offer(tmp.left);
					q.offer(tmp.right);
				}
				else if(tmp.left==null&&tmp.right==null){
					
				}
				else
					return false;
					
			}
		
		return true;
		
		
	}
	static boolean isCompleteBinaryTree(TreeNode node){
		if(node==null)
			return true;
		
		return (areLeavesAtSameLevel(node)&&isStrictBinaryTree(node));
	}
	static int size(TreeNode root){
		if(root==null)
			return 0;
		return (size(root.left)+size(root.right)+1);
	}
	static void printUpperView(TreeNode root){
		if (root==null)
			return;
		TreeNode tmp;
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		Map<Integer,TreeNode>map=new LinkedHashMap<>();
		int index=0;
		int lIndex=0,rIndex=0;
		q.offer(root);
		map.put(index,root);
		while(!q.isEmpty()){
			tmp=q.poll();
			if(tmp.left!=null){
				q.offer(tmp.left);
				lIndex=index-1;
				if(map.get(lIndex)==null)
					map.put(lIndex,tmp.left);
					
			}
			if(tmp.right!=null){
				q.offer(tmp.right);
				rIndex=index+1;
				if(map.get(rIndex)==null)
					map.put(rIndex,tmp.right);
					
			}
		}
		for (Map.Entry<Integer,TreeNode> entry : map.entrySet()) {
			  //int key = entry.getKey();
			  TreeNode tmp1 = entry.getValue();
			  System.out.println(tmp1.data);
			  // do stuff
			}
		}
	static void printLowerView(TreeNode root){
		
	}
	

}
