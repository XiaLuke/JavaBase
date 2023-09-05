package CHAPTER_III._7_input_output;

import org.junit.Test;

import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author XF
 * @date 2023/09/05
 * @description input and output
 */

public class Input_Output {
    /**
     * 3.7.1
     * read the value of the input
     * \n
     * read the value when you input on the console
     */
    @Test
    public void readConsole() {
        // 1.read in console
//        Scanner in = new Scanner(System.in);

        // 1.1 read a line
        // it read a line include space
//        String line = in.nextLine();
//        System.out.printf("line = %s\n", line);

        // 1.2 read a word
        // it read a word include space, so need to use loop read
//        while (in.hasNext()) {
//            String word = in.next();
//            System.out.printf("word = %s\n", word);
//            if (word.equals("exit")) {
//                break;
//            }
//        }
//        // 1.3 read a integer
//        int integer = in.nextInt();
//        System.out.printf("integer = %d\n", integer);
//        in.close();

        // beacuse the input value is visible, so it's not safe,
        // But in Java 6, introduced Console class, can hide the value of the input
        // 1.4 read a password
        Console console = System.console();
        String userName = "";
        if (console != null) {
            userName = console.readLine("Input username: ");
            char[] password = console.readPassword("Input password: ");
            // 执行使用用户名和密码的相关操作
            Arrays.fill(password, ' '); // 清除密码的字符数组
            System.out.printf("username = %s\n,password = %s\n", userName, password);
        } else {
            // 处理无法使用 Console 对象的情况
            // 可以使用其他方式读取用户名和密码，如 Scanner 或 BufferedReader
            Scanner scanner = new Scanner(System.in);
            System.out.print("Input username: ");
            userName = scanner.nextLine();
            System.out.print("Input password: ");
            String password = scanner.nextLine();
            // 执行使用用户名和密码的相关操作
            System.out.printf("username = %s\n,password = %s\n", userName, password);
        }
    }

    /**
     * 3.7.2
     * format the output
     * \n
     * like use %s etc, to format the output
     * \n
     * */
    @Test
    public void formatString(){
        System.out.printf("%s\n", "hello");
        System.out.printf("%d\n", 123);
        System.out.printf("%f\n", 123.456);
        System.out.printf("%b\n", true);
        System.out.printf("%x\n", 123);
        System.out.printf("%c\n", 'a');
        System.out.printf("%h\n", "hello");
        System.out.printf("%e\n", 123.456);
        System.out.printf("%g\n", 123.456);
        System.out.printf("%a\n", 123.456);
    }

}
