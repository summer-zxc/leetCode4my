package q5m;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Input: "babad"
 * 
 * Output: "bab"
 * 
 * Note: "aba" is also a valid answer
 * 
 * @author liufanwen
 * @2017年8月17日
 */
public class Solution {
	/**
	 * 暴力求解
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		char[] str = s.toCharArray();
		String zhe = "";
		String result = "";
		int num = 0;
		String paling = "";
		for (int z = 0; z < str.length; z++) {
			zhe = "";
			for (int i = z; i < str.length; i++) {
				zhe += str[i];
				paling = "";
				int x = z;
				for (int j = i; j >= z; j--) {
					if (str[x] == str[j]) {
						x++;
						paling += str[j];
					} else {
						break;
					}

				}
				if (zhe.equals(paling)) {
					if (zhe.length() > num) {
						result = zhe;
						num = zhe.length();
					}

				}
			}
		}
		return result;

	}

	/**
	 * 求回文数就是从中间开始往两边推算。
	 * 
	 * @param s
	 * @return
	 */
	int start = 0;
	int maxLen = 0;

	public String longestPalindrome2(String s) {

		if (s.length() < 3) {
			return s;
		}
		int start1 = s.length() / 2;
		for (int i = start1; i < s.length() - 1; i++) {
			if (maxLen > (s.length() - i) * 2) {
				break;
			} else {
				deal(s, i, i);
				deal(s, i, i + 1);
			}
		}
		for (int i = start1 - 1; i >= 0; i--) {
			if (maxLen > (i + 1) * 2) {
				break;
			} else {
				deal(s, i, i);
				deal(s, i, i + 1);
			}
		}
		return s.substring(start, start + maxLen);
	}

	private void deal(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			start = j + 1;
			maxLen = k - j - 1;
		}
	}

	public static void main(String[] args) {
		Solution su = new Solution();
		System.out.println(System.currentTimeMillis());
		Long start = System.currentTimeMillis();
		String s = "123456789";
		System.out.println(su.longestPalindrome2(s));
		System.out.println((System.currentTimeMillis() - start));
	}
}
