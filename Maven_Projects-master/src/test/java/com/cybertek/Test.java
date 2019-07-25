package com.cybertek;

import com.github.javafaker.Faker;

public class Test {
    public static void main(String[] args) {
        Faker faker = new Faker();

        System.out.println(faker.address().zipCode());
        System.out.println(faker.artist().name());
        System.out.println(faker.book().title());
        System.out.println(faker.funnyName().name());
    }
}
