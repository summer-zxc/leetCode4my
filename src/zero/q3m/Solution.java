package zero.q3m;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 * 
 * @author liufanwen
 * @2017年7月31日
 */
public class Solution {

	/**
	 * 暴力求解 复杂度n^3
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (allUnique(s, i, j))
					result = Math.max(result, j - i);
			}
		}
		return result;
	}

	public boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<Character>();
		for (int i = start; i < end; i++) {
			char ch = s.charAt(i);
			if (set.contains(ch)) {
				return false;
			}
			set.add(ch);
		}
		return true;
	}

	/**
	 * 滑动窗口法 复杂度O(n). 2n 对穷举法的优化，当出现第一个重复字母时，就放弃对后面的循环。
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring2(String s) {
		int n = s.length();
		int result = 0;
		int i = 0, j = 0;
		Set<Character> set = new HashSet<Character>();
		while (i < n && j < n) {
			char ch = s.charAt(j);
			if (!set.contains(ch)) {
				set.add(ch);
				j++;
				result = Math.max(result, j - i);
			} else {
				set.remove(s.charAt(i));
				i++;
			}
		}
		return result;
	}

	/**
	 * 滑动窗口法优化 复杂度O(n). n 对穷举法的优化，当出现第一个重复字母时，就放弃对后面的循环。
	 * 引入了hashmap增加了空间复杂度，减少了时间复杂度
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring3(String s) {
		int n = s.length();
		int result = 0;
		int i = 0, j = 0;
		Map<Character, Integer> charindex = new HashMap<Character, Integer>();
		for (; j < n; j++) {
			char ch = s.charAt(j);
			// charindex.put(ch, j);
			if (charindex.containsKey(ch)) {
				i = Math.max(charindex.get(ch), i);
			}
			charindex.put(ch, j+1);
			result = Math.max(result, j - i + 1);
		}
		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String s1 = "qweqweqweqerewrwsdfghyukukhmvhjmkuiououygczxvhb";
		System.out.println(s.lengthOfLongestSubstring(s1));
		System.out.println(s.lengthOfLongestSubstring3(s1));
	}
}
