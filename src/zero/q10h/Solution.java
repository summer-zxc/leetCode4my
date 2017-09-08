package zero.q10h;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character.
 * 
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * @author liufanwen
 * @2017年9月6日
 */
public class Solution {
	public boolean isMatch(String s, String p) {
		if (p.isEmpty()) {
	        return s.isEmpty();
	    }

	    if (p.length() == 1 || p.charAt(1) != '*') {
	        if (s.isEmpty() || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))) {
	            return false;
	        } else {
	            return isMatch(s.substring(1), p.substring(1));
	        }
	    }
	    
	    //P.length() >=2
	    while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {  
	        if (isMatch(s, p.substring(2))) { 
	            return true;                     
	        }                                    
	        s = s.substring(1);
	    }

	    return isMatch(s, p.substring(2));
	}

	public boolean isMatch2(String s, String p) {

		if (s == null || p == null) {
			return false;
		}
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*' && dp[0][i - 1]) {
				dp[0][i + 1] = true;
			}
		}
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < p.length(); j++) {
				if (p.charAt(j) == '.') {
					dp[i + 1][j + 1] = dp[i][j];
				}
				if (p.charAt(j) == s.charAt(i)) {
					dp[i + 1][j + 1] = dp[i][j];
				}
				if (p.charAt(j) == '*') {
					if (p.charAt(j - 1) != s.charAt(i)
							&& p.charAt(j - 1) != '.') {
						dp[i + 1][j + 1] = dp[i + 1][j - 1];
					} else {
						dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
					}
				}
			}
		}
		return dp[s.length()][p.length()];
	}

	public static void main(String[] args) {
		Solution so = new Solution();
		System.out.println(so.isMatch("caabc", "c*aac*bc"));

	}
}
