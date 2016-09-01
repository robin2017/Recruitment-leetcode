package Array;

import java.util.*;

/**
 * Created by robin on 16/8/31.
 */
public class Solution {
    public static void main(String[] args){
        System.out.println("dddd");
        int[] arr=new int[]{3,2,4};
       new Solution().combine(5,3);
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();//此处要下标，不能用foreach语句
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i]))
                return new int[]{hm.get(nums[i]),i};
            else{
                hm.put(target-nums[i],i);
            }
        }
        return new int[]{0,0};
    }


    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        DFS(list, new ArrayList<Integer>(), 0, nums, target);
        for(List<Integer> dd:list){
            for(int a:dd){
                System.out.print(" "+a);
            }
            System.out.println();
        }
        return list;
    }
    private  void DFS(List<List<Integer>> list,ArrayList<Integer> l,int start,int[] nums,int targ){
        if(targ==0)
            list.add((ArrayList<Integer>) l.clone());//不能为原来的，否者会变化，要用复制版本
        else if(targ<0)
            return;
        else{//targ>0
            for(int i=start;i<nums.length;i++){
                l.add(nums[i]);
                DFS(list,l,i,nums,targ-nums[i]);  //这里的第三个参数不是start，否者结果会有重复
                l.remove(l.size()-1);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(n<=0 || n<k)
            return res;
        helper(n,k,1,new ArrayList<Integer>(), res);
        for(List<Integer> dd:res){
            for(int a:dd){
                System.out.print(" "+a);
            }
            System.out.println();
        }
        return res;
    }
    private void helper(int n, int k, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res)
    {
        if(item.size()==k)
        {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i=start;i<=n;i++)
        {
            item.add(i);
            helper(n,k,i+1,item,res);
            item.remove(item.size()-1);
        }
    }
}
