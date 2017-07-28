package q1e;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if (target == nums[i] + nums[j]) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> num = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			num.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int key = target - nums[i];
			if (num.containsKey(key) && i != num.get(key)) {
				return new int[] { i, num.get(key) };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public int[] twoSum3(int[] nums, int target) {
		Map<Integer, Integer> num = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int key = target - nums[i];
			if (num.containsKey(key) && i != num.get(key)) {
				return new int[] { num.get(key), i };
			}
			num.put(nums[i], i);
		}

		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args) {
		Solution su = new Solution();
		int[] nums = { 3, 2, 4,5 };

		int[] result = su.twoSum2(nums, 6);
		System.out.println(Arrays.asList(result).toString());

	}
}
