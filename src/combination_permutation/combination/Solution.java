package combination_permutation.combination;
/**
 * @author  Robin
 * @date 2016年9月1日 下午4:08:31 
 * @version 1.0 
 */

 

import java.util.ArrayList;
import java.util.List;

/**
 * @author Robin
 * @date 2016年4月13日 下午3:59:20
 * @version 1.0
 */

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list=combine(4,2);
	}

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = i + 1;
		combination(0, k, arr, new ArrayList(), list);
		return list;
	}
	private static void combination(int start, int num, int[] source,
			//选 or 不选，DFS 问题！！！
			List<Integer> dest, List<List<Integer>> list) {
		if (num == 0) {
			List<Integer> copy = new ArrayList<Integer>();
			copy.addAll(dest);
			list.add(copy);
			return;
		}
		if (start == source.length)
			return;
		dest.add(source[start]);
		combination(start + 1, num - 1, source, dest, list);//选
		dest.remove(dest.size() - 1);//消除影响！！！
		combination(start + 1, num, source, dest, list);//不选
	}
}
