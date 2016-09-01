package combination_permutation.permutation;
 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Robin
 * @date 2016年4月11日 上午10:56:15
 * @version 1.0
 */

public class Solution {
	public static void main(String[] args) {
		//int[] arr = new int[] { 1, 2, 3 };
		//nextPermutation(arr);
		//permutation("abc");
	}

	//
/*	 public List<List<Integer>> permute99(int[] output) {
		    List<List<Integer>> list=new ArrayList<List<Integer>>();
			if (output == null)
				return list;
			
			int point = 0;
			
			List<Integer> l = new ArrayList<Integer>();
			for (int i = 0; i < output.length; i++)
				l.add(output[i]);
			
			list.add(l);
			int temp1 = output[point];
			output[point] = output[++point];
			output[point] = temp1;
			while (!String.valueOf(output).equals(str)) {
				List<Integer> li = new ArrayList<Integer>();
				for (int i = 0; i < output.length; i++)
					l.add(output[i]);
				list.add(li);
				if (point == output.length - 1) {
					int temp = output[point];
					output[point] = output[0];
					output[0] = temp;
					point = 0;
				} else {
					int temp = output[point];
					output[point] = output[++point];
					output[point] = temp;
				}
			}

		}

*/

	
 
	
	
	// 非递归实现排列
	public static void nextPermutation(int[] nums) {
		if (nums.length <= 2) {
			reverse(nums, 0, nums.length - 1);
			return;
		}
		// 至少三个
		int expointer = nums.length - 2;
		while (expointer >= 0 && nums[expointer] >= nums[expointer + 1])
			expointer--;
		if (expointer == -1) {// 已经是最后一个排列
			reverse(nums, 0, nums.length - 1);
			return;
		}
		int q = nums.length - 1;
		while (nums[q] <= nums[expointer])
			q--;
		swap(nums, q, expointer);
		reverse(nums, expointer + 1, nums.length - 1);

	}

	private static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
	}

	// 交换排列
	public List<List<Integer>> permute1(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		permu1(nums, 0, nums.length - 1, list);
		return list;

	}

	private void permu1(int[] nums, int start, int end, List<List<Integer>> list) {
		if (start == end) {
			List<Integer> l = new ArrayList<Integer>();
			for (int i = 0; i < nums.length; i++)
				l.add(nums[i]);
			list.add(l);
		} else {
			for (int i = start; i <= end; i++) {
				swap(nums, i, start);
				permu1(nums, start + 1, end, list);
				swap(nums, i, start);
			}

		}

	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// 选择排列
	public static List<List<Integer>> permute2(int[] nums) {
		List<Integer> source = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++)
			source.add(nums[i]);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		permu2(new ArrayList<Integer>(), source, list);
		return list;
	}

	private static void permu2(List<Integer> dest, List<Integer> source,
			List<List<Integer>> list) {
		if (source.isEmpty())
			list.add(dest);
		else {
			for (int i = 0; i < source.size(); i++) {
				int tmp = source.remove(i);
				dest.add(tmp);
				permu2(dest, source, list);
				source.add(tmp);
			}
		}
	}

	// 1，无返回的递归，容易
	// 思路：在source中任选一个（遍历各种可能）添加到dest的末尾，
	// 排列问题应该是n层循环，但是用了n层递归就行
	private static void arrange(String dest, String source) {
		if (source.isEmpty())
			System.out.println("---" + dest);
		else {
			for (int i = 0; i < source.length(); i++) {
				arrange(dest + source.charAt(i), source.substring(0, i)
						+ source.substring(i + 1, source.length()));
			}
		}
	}

	// 2，有返回的递归,容器放在形参中
	private static void arrange1(String dest, String source, List<String> list) {
		if (source.isEmpty())
			list.add(dest);
		else {
			for (int i = 0; i < source.length(); i++) {
				arrange1(dest + source.charAt(i), source.substring(0, i)
						+ source.substring(i + 1, source.length()), list);
			}
		}
	}
}
