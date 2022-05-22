package leetcode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/5/22 17:29 <br>
 */
public class KMP_28 {

    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] fix = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = fix[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            fix[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = fix[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "ll";
        KMP_28 kmp_28 = new KMP_28();
        int result = kmp_28.strStr(s1, s2);
    }

}
