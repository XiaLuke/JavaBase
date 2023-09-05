package CHAPTER_III._6_string;

import org.junit.Test;

public class _String {
    /**
     * Each string enclosed in double quotes is an instance of the String class
     */
    @Test
    public void bases() {
        String str = "Java\u2122";
        System.out.printf("str = %s\n", str);
    }

    /**
     * 3.6.1 substring
     * String provides substring methods for extracting substrings.
     * substring has two forms
     * the first form returns a substring that begins
     * the second form Indicates to the position, but does not contain the character at that position.
     * \n
     * can be understood as left closed right open
     */
    @Test
    public void getSubstring() {
        String greeting = "Hello";
        String s = greeting.substring(0, 3);
        System.out.printf("s = %s\n", s);
    }

    /**
     * 3.6.2
     * Concatenating Strings
     * When a string is concatenated with a non-string value, the latter is converted to a string
     * Adding two strings creates a new string object that will create a new reference in the stack,
     * pointing to the new string object in the heap
     */
    @Test
    public void concatString() {
        // 1. String + String
        String expletive = "Expletive";
        String PG13 = "deleted";
        String message = expletive + PG13;

        // 2. String + non-String
        int age = 13;
        String rating = "PG" + age;

        // 3. java 11 provides a new method, repeat, which repeats a string a given number of times
        String repeated = "Java".repeat(3);

        // 4.memory distribution
        String defaultStr = "default"; // string constant pool
        String subStr = "defaul"; // string constant pool
        String addStr = "t"; // string constant pool
        String combineStr = subStr + addStr; // heap
        String defaultStr2 = "default"; // string constant pool
        // defaultStr == defaultStr2
        // defaultStr != combineStr
    }

    /**
     * 3.6.3
     * Immutability of Strings
     * \n
     * Once a string object is created, its value cannot be changed.
     * Any modification to a string actually creates a new string object and points the variable reference to the new object,
     * rather than modifying the original object.
     * \n
     * because the string is immutable, it is safe to share it between multiple threads.
     * And multiple string variables can refer to the same string constant.
     * Also and prevent malicious modification
     */
    @Test
    public void immutability() {
        // changing the string can only be re assigned
        String str = "Hello";
        str = str.substring(0, 3) + "p!";
        System.out.printf("str = %s\n", str);
    }

    /**
     * 3.6.4
     * Testing Strings for Equality
     * \n
     * To check whether two strings are equal, you can use equals method
     * \n
     * please not use == to check whether two strings are equal,
     * == just check whether two references point to the same object
     * \n
     * if you want use == to compare two strings, you can use compareTo method
     * (str1.compareTo(str2)) == 0
     * but still recommend to use equals method, because it is more readable
     */
    @Test
    public void equality() {
        // 1. equals
        String str1 = "Hello";
        String str2 = "Hel";
        String str3 = "Hell" + "o";
        System.out.printf("str1 equals str2: %b\n", (str1.substring(0, 3)).equals(str2));
        System.out.printf("str1 equals str3: %b\n", str1.equals(str3));

        // 2. ==
        System.out.printf("str1 == str2: %b\n", (str1.substring(0, 3)) == str2);
        System.out.printf("str1 == str3: %b\n", str1 == str3);
    }

    /**
     * 3.6.5
     * Empty and Null Strings
     * \n
     * Empty string expresses as "", it's length is 0
     * you can use isEmpty method to check whether a string is empty
     * if(str.length() == 0) or if(str.equals(""))
     * */
    @Test
    public void emptyAndNull() {
        // 1. string is empty
        String str = "";
        System.out.printf("str is empty type 1: %b\n", str.length() == 0);
        System.out.printf("str is empty type 2: %b\n", str.equals(""));

        // 2. string is not null and not empty
        String str2 = " ";
        System.out.printf("str2 is empty type 1: %b\n",
                str2.length() == 0 && str2.equals(""));
    }

    /**
     * 3.6.6
     * Code Points and Code Units
     * */
    @Test
    public void codePointsAndCodeUnits() {
        // 1. code point
        String str = "Hello";
        int codePoint = str.codePointAt(1);
        System.out.printf("code point: %d\n", codePoint);

        // 2. code unit
        int codeUnit = str.charAt(1);
        System.out.printf("code unit: %d\n", codeUnit);

        char a = 101;
        System.out.println(a);
    }

    /**
     * 3.6.7
     * String API
     * \n
     * String API is very rich, you can use it to do many things
     * here i don't show of them ,you can read the book to learn more
     * */

    /**
     * 3.6.9
     * StringBuilder
     * \n
     * we will build a string use short string in some cases
     * if use string, it will create a new string when you splice a string every time
     * it inefficient and wasted space
     */
    @Test
    public void stringBulild(){
        // 1. use string
        long stringStart = System.currentTimeMillis();
        String str = "";
        for(int i = 0; i < 10; i++){
            str += i;
        }
        long stringEnd = System.currentTimeMillis();
        System.out.printf("string cost time: %d\n", stringEnd - stringStart);
        System.out.printf("str = %s\n", str);

        // 2. use StringBuilder
        long builderStart = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < 10; i++){
            builder.append(i);
        }
        long builderEnd = System.currentTimeMillis();
        System.out.printf("builder cost time: %d\n", builderEnd - builderStart);
        System.out.printf("builder = %s\n", builder.toString());
    }
}
