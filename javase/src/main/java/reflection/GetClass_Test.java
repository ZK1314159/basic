package reflection;

public class GetClass_Test {

    public void info(String str) {
        System.out.println("执行有参数的info方法" + "，其str参数值：" + str);
    }

    public static void main(String[] args) //throws Exception
    {
        Class<GetClass_Test> clazz = GetClass_Test.class;
        //Method m = clazz.getMethod("info" , String.class);
    }
}

