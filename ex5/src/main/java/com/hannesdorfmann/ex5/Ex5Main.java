package com.hannesdorfmann.ex5;

public class Ex5Main {

    public static void main(String[] args) {
        Backend backend = new Backend();

        // TODO: collaboration
        String salt = backend.getSalt().blockingFirst();

        System.out.println("Salt = "+salt);
    }
}
