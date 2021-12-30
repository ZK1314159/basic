package aioproject;

public interface Protocol {
    // 定义协议字符串的长度

    int PROTOCOL_LEN = 2;

    // 下面是一些协议字符串，服务器和客户端交换的信息都应该在前、后添加这种特殊字符串。

    String USER_NAME = "∏∑";
    String USER_IMAGE = "●▼";
    String CHAT_PRIVATE = "○□";
    String CHAT_PUBLIC = "■◇";

    String LOGIN_SUCCESS = "1";
    String NAME_REP = "-1";
    String USER_LIST = "▲◆";

    String SPLIT_SIGN = "※";
    String SPLIT_SIGN2 = "◇";
}
