package one.q12m;

/**
 * Given an integer, convert it to a roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author liufanwen
 * @2018年3月9日
 */
public class Solution {

	public String intToRoman(int num) {
		String romanStr = "";
		// 罗马数字
		String symbol[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
		// 对应的数字
		int value[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		for (int i = 0; num != 0; ++i) {
			while (num >= value[i]) {
				num -= value[i];
				romanStr += symbol[i];
			}
		}
		return romanStr;

	}

	public static void main(String[] args) {

		Solution so = new Solution();
		System.out.println(so.intToRoman(2));
	}
}
