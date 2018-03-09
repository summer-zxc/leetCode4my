package zero.q4h;

/**
 * 4. Median of Two Sorted Arrays
 * 
 * nums1 = [1, 2] nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * @author liufanwen
 * @2017年8月10日
 */
public class Solution {

	/**
	 * 暴力求解
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length == 0 && nums2.length == 0) {
			return 0.0;
		}
		int j = 0;
		int i = 0;
		int temp = 0;
		int[] result = new int[nums1.length + nums2.length];
		for (int x = 0; x < result.length; x++) {
			if (i < nums1.length && j < nums2.length) {
				if (nums1[i] < nums2[j]) {
					temp = nums1[i];
					i++;
				} else {
					temp = nums2[j];
					j++;
				}
			} else {
				if (i < nums1.length) {
					temp = nums1[i];
					i++;
				}
				if (j < nums2.length) {
					temp = nums2[j];
					j++;
				}
			}

			result[x] = temp;
		}
		int num = result.length;
		double result1 = 0.0;
		if (result.length < 2) {
			result1 = result[0];
		} else {
			if (num % 2 == 0) {
				result1 = Double.valueOf(result[num / 2 - 1] + result[num / 2]) / 2;
			} else {
				result1 = result[(num - 1) / 2];
			}
		}
		return result1;
	}

	/**
	 * 二分法求解 没看懂
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
//		int m = nums1.length;
//		int n = nums2.length;

		return 0;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 3 };
		int[] nums2 = { 2 };
		Solution s = new Solution();
		System.out.println(s.findMedianSortedArrays(nums1, nums2));
	}
}
