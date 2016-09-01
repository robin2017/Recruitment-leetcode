package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by robin on 16/8/31.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public static void main(String[] args){
        new Solution().invertTree(null);
    }

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    public void invert(TreeNode r){
        if(r==null)
            return;
        TreeNode tmp=r.left;
        r.left=r.right;
        r.right=tmp;
        invert(r.left);
        invert(r.right);
    }

    public int maxDepth(TreeNode root) {
        //初始条件
        if(root==null)
            return 0;
        //递归条件
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)
            return true;
        if(p==null||q==null)
            return false;
        return (p.val==q.val)&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        helper(root,list);
        return list;
    }
    public void helper(TreeNode root,List<Integer> list){
        if(root==null)
            return;
        list.add(root.val);
        helper(root.left,list);
        helper(root.right,list);
    }


    List<Integer> list=new ArrayList<Integer>();
    public List<Integer> preorderTraversal2(TreeNode root) {
        if(root!=null){
            list.add(root.val);
            preorderTraversal2(root.left);
            preorderTraversal2(root.right);
        }
        return list;
    }


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList<String>();
        if(root==null)
            return list;
        //考虑第一个情况
        if(root.left==null&&root.right==null){
            list.add(""+root.val);
            return list;
        }
        String path=""+root.val;
        helper(root.left,list,path);
        helper(root.right,list,path);
        return list;
    }

    public void helper(TreeNode root,List<String> list,String path){
        if(root==null)
            return ;
        path+="->"+root.val;
        if(root.left==null&&root.right==null){//叶子节点
            list.add(path);
        }
        helper(root.left,list,path);
        helper(root.right,list,path);
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val<q.val)
            return lowestCommon(root,p,q);
        else
            return lowestCommon(root,q,p);
    }
    public TreeNode lowestCommon(TreeNode root, TreeNode p, TreeNode q) {//左边小于右边
        if(root.val>=p.val&&root.val<=q.val)
            return root;
        if(root.val<p.val)
            return lowestCommon(root.right,p,q);
        else
            return lowestCommon(root.left,p,q);
    }


    public int result=0;
    public int cnt;
    public int kthSmallest(TreeNode root, int k) {
        cnt=k;
        helper(root);
        return result;
    }
    public void helper(TreeNode root){
        if(root==null)
            return ;
        helper(root.left);
        if(--cnt==0){
            result=root.val;
            return ;
        }
        helper(root.right);
    }


    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> rights = new Stack<TreeNode>();
        //stack不用初始化
        while(root != null) {
            list.add(root.val);

            //注意这里是right节点
            if (root.right != null) {
                rights.push(root.right);
            }
            root = root.left;
            if (root == null && !rights.isEmpty()) {
                root = rights.pop();
            }
        }
        return list;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        Stack<TreeNode> sta=new Stack<TreeNode>();
        //stack不用初始化
        //两个条件为或关系
        while(!sta.empty() || root!=null){
            if(root!= null){//非空
                list.add(root.val);
                sta.push(root);
                root=root.left;
            }else{
                root=sta.pop();
                root=root.right;
            }
        }
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        //此处声明必须linkedlist，因为list没有addfirst方法
        LinkedList<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> sta = new Stack<TreeNode>();
        //stack不用初始化
        //两个条件为或关系
        while (!sta.empty() || root != null) {
            if (root != null) {//非空
                list.addFirst(root.val);
                sta.push(root);
                root = root.right;
            } else {
                root = sta.pop();
                root = root.left;
            }
        }
        return list;
    }
}