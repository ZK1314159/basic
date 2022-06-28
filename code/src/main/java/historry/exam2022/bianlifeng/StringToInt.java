package historry.exam2022.bianlifeng;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/30 15:17 <br>
 */
public class StringToInt {

    public int valueof(String a){
        if (a == null || a.length() == 0) {
            throw new RuntimeException();
        }
        int answer = -1;
        int last = Integer.MAX_VALUE - Integer.MAX_VALUE / 10;
        boolean minus = false;
        for (int i = 0; i < a.length(); i++) {
            char tmp = a.charAt(i);
            if (tmp >= '0' && tmp <= '9') {
                if (answer > -1) {
                    if (answer > 0) {
                        if (answer <= Integer.MAX_VALUE / 10) {
                            int value = tmp - '0';
                            if (value <= last) {
                                answer = answer * 10 + tmp - '0';
                            } else {
                                throw new RuntimeException();
                            }
                        } else {
                            throw new RuntimeException();
                        }
                    } else {
                        answer = tmp - '0';
                    }
                } else {
                    answer = tmp - '0';
                }
            } else {
                if (answer > -1) {
                    throw new RuntimeException();
                } else {
                    if (! minus) {
                        if (tmp == '-') {
                            minus = true;
                        } else {
                            throw new RuntimeException();
                        }
                    } else {
                        throw new RuntimeException();
                    }
                }
            }
        }
        if (minus) {
            return -answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        StringToInt test = new StringToInt();
        String s = "-573857";
        int answer = test.valueof(s);
    }

}
