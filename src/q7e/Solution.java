package q7e;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * 
 * Example2: x = -123, return -321
 * 
 * @author liufanwen
 * @2017年8月19日
 */
public class Solution {
	public int reverse(int x) {
		if (x > -10 && x < 10) {
			return x;
		}
		char[] oriStr = (x + "").toCharArray();
		StringBuffer buf = new StringBuffer();
		int z = 1;
		for (int i = oriStr.length - 1; i >= 0; i--) {
			if (oriStr[i] != '-') {
				buf.append(oriStr[i]);
			} else {
				z = -1;
			}
		}
		return Long.valueOf(buf.toString())>Integer.MAX_VALUE ?0:z*Integer.valueOf(buf.toString());
	}

	public static void main(String[] args) {
		Solution so = new Solution();

		System.out.println(so.reverse(-123456789));
	}
}
