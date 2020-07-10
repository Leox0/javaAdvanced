package com.sda.personList;

import jdk.internal.net.http.common.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonApp {
    public static void main(String[] args) {
        getGmailUser();
        getGirlsNumber();
        getCountPerson();
        getListGroupingByDomain();
        sortedListByPhoneNumber();
    }
    

    private static void sortedListByPhoneNumber() {
        List<Person> sortedByPhoneNumber = generateUsers()
                .stream()
                .sorted((e1,e2) -> Integer.parseInt(String.valueOf(e2.getPhoneNumber().compareTo(e1.getPhoneNumber()))))
                .collect(Collectors.toList());
        System.out.println(sortedByPhoneNumber);
    }

    private static void getListGroupingByDomain() {
        Map<String, List<Person>> domain = generateUsers()
                .stream()
                .collect(Collectors.groupingBy(person -> person.getEmail().substring(person.getEmail().indexOf('@'))));
        System.out.println(domain);
    }

    private static void getCountPerson() {
        long count = generateUsers()
                .stream()
                .filter(p -> p.getEmail().contains("@wp.com") || p.getEmail().contains("o2.com"))
                .count();
        System.out.println("liczba: " + count);
    }

    private static void getGirlsNumber() {
        List<String> girlsNumber = generateUsers()
                .stream()
                .filter(g -> g.getName().endsWith("a"))
                .filter(g -> !g.getName().equalsIgnoreCase("Kuba"))
                .map(Person::getPhoneNumber)
                .collect(Collectors.toList());
        System.out.println(girlsNumber);
    }

    private static void getGmailUser() {
        List<Person> gmailUsers = generateUsers()
                .stream()
                .filter(g -> g.getEmail().contains("@gmail.com"))
                .collect(Collectors.toList());
        System.out.println(gmailUsers);
    }

    private static List<Person> generateUsers() {
        List<Person> users = new ArrayList<>();
        users.add(new Person("Adam", "Adamowicz", "505939534", "adam.adamowicz@gmail.com"));
        users.add(new Person("Zuzanna", "zuzowska", "865634234", "zuzanna.zuzowska123@wp.com"));
        users.add(new Person("Kuba", "Kubowski", "505939534", "kuba.kubowski@gmail.com"));
        users.add(new Person("Ola", "Olawska", "545788556", "ola.olawska@gmail.com"));
        users.add(new Person("Michał", "Michawski", "353756345", "michal.michawski@o2.com"));
        users.add(new Person("Piotr", "Piotrowicz", "234423656", "piotr.piotrowicz@wp.com"));
        return users;
    }
}
