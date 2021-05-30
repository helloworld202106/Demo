package com.learning;

public class JavaJvmApplication {

    public static void main(String[] args) throws InterruptedException {
        int i = 2;
        int j = 3;
        int k = i + j;

        Thread.sleep(6000);

        System.out.println("hello");
    }

}
