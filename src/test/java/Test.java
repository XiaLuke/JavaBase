package java;

import java.util.TreeSet;

public class Test extends Thread {
    public void run() {
        System.out.println("In run");
        yield();
        System.out.println("Leaving run");
    }
    public static void main(String []argv) {
        (new Test()).start();
    }
}
