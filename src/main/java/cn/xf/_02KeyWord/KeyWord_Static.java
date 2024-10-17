package cn.xf._02KeyWord;

public class KeyWord_Static {

    private void func(){

    }

    //private static void staticTest(); /* Missing method body, or declare abstract */

    //private abstract static void func(); /* Illegal combination of modifiers: 'abstract' and 'static' */

    private int age;
    private static String NAME="xxxd";
    public static void staticTest(int param) {
        String name = NAME;
        //int a = age; /* Non-static field 'age' cannot be referenced from a static context */

        //param = this.age; /* cannot be referenced from a static context */
    }

}
