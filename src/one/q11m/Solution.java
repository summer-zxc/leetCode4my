package one.q11m;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * @author liufanwen
 * @2017年9月6日
 */
public class Solution {

	/**
	 * 双指针的方法
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int max = 0;
		while (left < right) {
			max = Math.max(max, Math.min(height[left], height[right])
					* (right - left));
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return max;

	}

	public static void main(String[] args) {
		int[] height = { 1, 1, 2, 2, 5, 6, 5, 4, 8, 2, 1, 5, 8, 7, 5, 5, 4, 7,
				7, 5 };
		Solution so = new Solution();
		System.out.println(so.maxArea(height));
	}
}
