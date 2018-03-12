package one.q14e;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings
 * 
 * @author liufanwen
 * @2018年3月9日
 */
public class Solution {

	/**
	 * 最普通的方法 遍历每一个字符串得到相同的字符串
	 * 
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix1(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String head = strs[0];
		for (int i = 1; i < strs.length; i++) {
			head = getCommonPrefix(strs[i], head);
		}
		return head;
	}

	private String getCommonPrefix(String str, String prefix) {
		String result = "";
		for (int i = 0; i < str.length() && i < prefix.length(); i++) {
			if (str.charAt(i) == prefix.charAt(i)) {
				result += str.charAt(i);
			} else {
				break;
			}
		}
		return result;
	}

	/**
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix2(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String head = strs[0];
		for (int i = 1; i < strs.length; i++) {
			head = getCommonPrefix2(strs[i], head);
		}
		return head;
	}

	private String getCommonPrefix2(String str, String prefix) {
		String result = "";
		for (int i = 0; i < str.length() && i < prefix.length(); i++) {
			if (str.charAt(i) == prefix.charAt(i)) {
				result += str.charAt(i);
			} else {
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution so = new Solution();
		String[] strs = { "1234", "12345", "1112345", "12345", "12345",
				"12345", "12345" };
		System.out.println(so.longestCommonPrefix1(strs));
	}
}
