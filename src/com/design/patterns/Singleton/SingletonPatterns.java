package com.design.patterns.Singleton;

class Singleton {
    // 1. static instance
    private static Singleton instance;
    // 2. private constructor
    private Singleton() {
        System.out.println("Singleton is Instantiated.");
    }
    // 3. static factory method
    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
    public static void doSomething() {
        System.out.println("Something is Done.");
    }
}

public class SingletonPatterns {
    public static void main(String[] args) {
        Singleton.getInstance().doSomething();
    }
}

