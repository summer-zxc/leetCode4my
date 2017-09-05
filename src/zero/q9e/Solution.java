package zero.q9e;

/**
 * Determine whether an integer is a palindrome. Do this without extra space..
 * 
 * @author liufanwen
 * @2017年9月5日
 */
public class Solution {
	public boolean isPalindrome(int x) {
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}
		int revertedNumber = 0;
		while (x > revertedNumber) {
			revertedNumber = revertedNumber * 10 + x % 10;
			x /= 10;
		}

		return x == revertedNumber || x == revertedNumber / 10;
	}

	public static void main(String[] args) {
		Solution so = new Solution();
		System.out.println(so.isPalindrome(123421));
	}
}
