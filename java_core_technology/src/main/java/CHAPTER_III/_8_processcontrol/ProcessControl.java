package CHAPTER_III._8_processcontrol;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author XF
 * @date 2023/09/05
 * @description process control
 * In this section, conditional statements are introduced,
 * then loop statements are discussed,
 * and finally switch statements are introduced.
 */

public class ProcessControl {
    /**
     * 3.8.1
     * block scope
     */
    @Test
    public void blockScope() {
        // 1. what is block
        // A block is a statement that consists of several Java residences.
        // And use braces to enclose the block
        // Blocks determine the scope of variables,
        // and one block can be nested within another block.
        // A class is also a block, each method is also a block
        // But in nested blocks, variables with the same name cannot be declared
        int a = 12;
        if (a == 12) {
//            int a = 23; // error，can't redefine a in inner block
        }
    }

    /**
     * 3.8.2
     * conditional statement
     * \n
     * in Java, the conditional statement is of the form
     * if(condition) statement
     * like：if(age>= 12) { other code }
     * \n
     * when use if statement, the process is
     * <p>
     * ------------------            ------------------------
     * |  age > target  |----YES---->|  you are older than  |-------->
     * ------------------            ------------------------    ↑
     * ↓                                                 ↑
     * ------------------------NO-------------------------
     * \n
     * if use if-else statement, the process is
     * ------------------          ------------------------
     * |  class = "old"  |-------->|  you are older than  |--------↓
     * -------------------         ------------------------        ↓
     * ↑                                                    ↓
     * YES                                                   ↓
     * ↑                                                    ↓
     * ------------------                                          ↓
     * |  age > target  |                                          ---->
     * ------------------                                          ↑
     * ↓                                                    ↑
     * NO                                                   ↑
     * ↓                                                    ↑
     * --------------------         --------------------------     ↑
     * | class = "young"  |-------->|  you are younger than  |-----↑
     * --------------------         --------------------------
     */
    @Test
    public void conditionalStatement() {
        // 1. if statement
        int age = 13;
        int target = 12;
        if (age >= target) {
            System.out.println("you are older than " + target);
        }

        // 2. if-else statement
        String className = "";
        if (age >= target) {
            className = "old";
        } else {
            className = "young";
        }
        System.out.println("class = " + className);

        // 3. if-else-if statement
        if (age >= 18) {
            className = "adult";
        } else if (age >= 12) {
            className = "teenager";
        } else {
            className = "child";
        }
        System.out.println("class = " + className);

        // 4. nested if statement
        if (age >= 12) {
            if (age >= 18) {
                className = "adult";
            } else {
                className = "teenager";
            }
        } else {
            className = "child";
        }
        System.out.println("class = " + className);

        // 5. if statement can be used to replace the ternary operator
        // ternary operator: condition ? expression1 : expression2
        // if statement: if(condition) expression1 else expression2
        // the ternary operator is more concise, but the if statement is more readable
        String className2 = age >= 12 ? "teenager" : "child";
        System.out.println("class = " + className2);
    }

    /**
     * 3.8.3
     * loop statement
     * \n
     * When the condition is true, the while loop executes a statement
     * while(condition) statement
     * if false, the loop will not execute
     */
    @Test
    public void loopStatement() {
        int age = 0;
        int height = 50;
        while (age < 18) {
            ++age;
            height += 5;
        }
        System.out.printf("age = %d, height = %d\n", age, height);
    }

    /**
     * 3.8.4
     * for loop
     * \n
     * The for loop statement is a general structure that supports iteration,
     * with a counter or similar variable controlling the number of iterations,
     * which is updated with each iteration.
     */
    @Test
    public void forLoop() {
        // 1. for loop
        // for(initialization; condition; update) statement
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }
    }

    /**
     * 3.8.5
     * multi select：switch
     * \n
     * When dealing with multiple options, the use of if/else constructs is redundant
     * \n
     * Switch will execute from the first matching case until break or the end of switch statement is encountered.
     * If there is no matching case, the default statement will be executed.
     * \n
     * Switch may start multiple case branches. If there is no break statement at the end of the case sentence,
     * it will continue to execute the next case branch until it encounters the break statement or the end of the switch statement.
     * \n
     * the label for a case can be：byte、short、char、int、enum、String
     */
    @Test
    public void multiSelect() {
        Scanner in = new Scanner(System.in);
        System.out.printf("Input a integer:");
        int input = in.nextInt();
        switch (input) {
            case 1:
                System.out.println("Hello World");
                break;
            case 2:
                System.out.println("Welcome to School");
                break;
            case 3:
                System.out.println("Welcome to College");
                break;
            case 4:
                System.out.println("Welcome to University");
                break;
            case 5:
                System.out.println("Welcome to Company");
                break;
            default:
                System.out.println("Input error");
                break;
        }
    }

    /**
     * 3.8.6
     * break and continue
     * \n
     */
    @Test
    public void breakAndContinue() {
        // 1. with out break
        int year = 1;
        int balance = 1000;
        while (year < 100) {
            balance += 100;
            double interest = balance * 0.1;
            balance += interest;
            if (balance >= 2000) {
                break;
            }
            ++year;
        }

        // 2. also can for loop with out break
        // 但是这里检测两次balance < 2000,为了避免重复，可以使用break
        while (year < 100 && balance < 2000) {
            balance += 100;
            double interest = balance * 0.1;
            balance += interest;
            if (balance < 2000) {
                ++year;
            }
        }
    }

}
