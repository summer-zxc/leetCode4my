package zero.q8m;

/**
 * Implement atoi to convert a string to an integer.
 * 
 * @author liufanwen
 * @2017年8月19日
 */
public class Solution {
	public int myAtoi(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		str = str.trim();
		int sign = 1;
		int postion = 0;
		if (str.charAt(postion) == '-') {
			sign = -1;
			postion++;
		} else if (str.charAt(postion) == '+') {
			sign = 1;
			postion++;
		}
		long result = 0l;
		for (int i = postion; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				result = result * 10 + str.charAt(i) - '0';
			} else {
				return (int) result * sign;
			}
			if (result > Integer.MAX_VALUE) {
				if (sign == 1) {
					return Integer.MAX_VALUE;
				} else {
					return Integer.MIN_VALUE;
				}
			}
		}
		return (int) result * sign;
	}

	public static void main(String[] args) {
		Solution so = new Solution();
		System.out.println(so.myAtoi("-12312sad"));
	}
}
