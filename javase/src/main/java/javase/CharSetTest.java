package javase;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/29 18:11 <br>
 */
public class CharSetTest {

    public static void main(String[] args) {
        String s = "\u4E00";
        byte[] bytes = s.getBytes();
        String[] strings = new String[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            strings[i] = Integer.toBinaryString(bytes[i]).substring(24);
        }
        // 𪜀
        // U+2A700
        String s1 = "\uD835\uDD46";
        byte[] bytes1 = s1.getBytes();
        String[] strings2 = new String[bytes1.length];
        for (int i = 0; i < bytes1.length; i++) {
            strings2[i] = Integer.toBinaryString(bytes1[i]).substring(24);
        }
    }

}
