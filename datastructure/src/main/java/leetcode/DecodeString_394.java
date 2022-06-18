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

    private int now;

    public String decodeString(String s) {
        return decode(0, s).toString();
    }

    // 基本处理单元是字符串 + 编码内容 + 字符串
    StringBuilder decode(int left, String s) {
        StringBuilder stringBuilder = new StringBuilder();
        while (now < s.length() && s.charAt(now) != ']') {
            if (Character.isLetter(s.charAt(now))) {
                now++;
                continue;
            }
            String before = s.substring(left, now);
            stringBuilder.append(before);

            int number = 0;
            while (Character.isDigit(s.charAt(now))) {
                number = number * 10 + s.charAt(now) - '0';
                now++;
            }
            now++;
            StringBuilder innerString = decode(now, s);
            String tmp = innerString.toString();
            for (int i = 1; i < number; i++) {
                innerString.append(tmp);
            }
            stringBuilder.append(innerString.toString());
            now++;
            left = now;
        }
        String after = s.substring(left, now);
        stringBuilder.append(after);
        return stringBuilder;
    }

    public static void main(String[] args) {
        DecodeString_394 test = new DecodeString_394();
        String s = "2[abc]3[cd]ef";
        String answer = test.decodeString(s);
    }

}
