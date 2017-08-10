package q4h;

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
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int j = 0;
		int[] result =new int[nums1.length+nums2.length];
		for (int i = 0; i < nums1.length; ) {
			//in
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2 };
		int[] nums2 = { 3, 4 };
		Solution s = new Solution();
		System.out.println(s.findMedianSortedArrays(nums1, nums2));
	}
}
