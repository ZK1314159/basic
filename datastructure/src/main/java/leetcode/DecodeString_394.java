package leetcode;

/**
 * Description：<br>
 * 11:25开始看题
 * 12:44 写完答案
 * 13:30 答案AC
 * CreateDate：2022/6/18 11:26 <br>
 */

//1 <= s.length <= 30
//s 由小写英文字母、数字和方括号 '[]' 组成
//s 保证是一个 有效 的输入。
//s 中所有整数的取值范围为 [1, 300] 

public class DecodeString_394 {

    public String decodeString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        decode(0, s, stringBuilder);
        return stringBuilder.toString();
    }

    // 基本处理单元是字符串 + 编码内容 + 字符串，并且不处于重复环境中
    int decode(int left, String s, StringBuilder stringBuilder) {
        int count = 0;
        int right = left;
        while (right < s.length() && s.charAt(right) != ']') {
            if (s.charAt(right) >= 'a' && s.charAt(right) <= 'z') {
                right++;
                continue;
            }
            String before = s.substring(left, right);
            stringBuilder.append(before);
            count += right - left;

            left = right;
            int number = 0;
            while (s.charAt(right) >= '0' && s.charAt(right) <= '9') {
                number = number * 10 + s.charAt(right) - '0';
                right++;
            }
            count += right - left;
            count += 2;
            right++;
            StringBuilder innerString = new StringBuilder();
            int innerCount = decode(right, s, innerString);
            String tmp = innerString.toString();
            for (int i = 1; i < number; i++) {
                innerString.append(tmp);
            }
            stringBuilder.append(innerString.toString());
            left = right + innerCount;
            left++;
            right = left;
            count += innerCount;
        }
        String after = s.substring(left, right);
        stringBuilder.append(after);
        count += right - left;
        return count;
    }

    public static void main(String[] args) {
        DecodeString_394 test = new DecodeString_394();
        String s = "2[abc]3[cd]ef";
        String answer = test.decodeString(s);
    }

}
