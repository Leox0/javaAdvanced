package com.sda.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Dog> dogs = dogList();
        System.out.println(dogs);
        firstStream(dogs);
        secoundStream(dogs);

    }

    private static void secoundStream(List<Dog> dogs) {
        String adam = dogs
                .stream()
                .filter(dog -> dog.getName().equals("Adam"))
                .map(Dog::getName)
                .reduce((sum, dogSurname) -> sum + ":" + dogSurname).get();

        System.out.println("wyswietl liste");
        System.out.println(adam);
    }

    private static List<Dog> dogList() {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Adam", "Leja"));
        dogs.add(new Dog("Adam", "Malik"));
        dogs.add(new Dog("Adam", "Malik"));
        dogs.add(new Dog("Adam", "Tada"));
        dogs.add(new Dog("Adam", "Ross"));
        dogs.add(new Dog("Adam", "Ross"));
        dogs.add(new Dog("Adam", "Rada"));
        dogs.add(new Dog("Adam", "Rada"));
        dogs.add(new Dog("Adam", "Rada"));
        dogs.add(new Dog("Adam", "Zab"));
        dogs.add(new Dog("Karol", "Harny"));
        dogs.add(new Dog("Malgosia", "Dud"));
        dogs.add(new Dog("Malgosia", "Park"));
        dogs.add(new Dog("Wiola", "Podrak"));
        dogs.add(new Dog("Ala", "Sat"));
        return dogs;
    }

    private static void firstStream(List<Dog> dogs) {
        //stream
        List<Dog> adamList = dogs
                .stream()
                .filter(dog -> dog.getName().equals("Adam"))
                //.peek(dog-> System.out.println("Po filter" + dog))

                //.distinct() //remove duplicates
                //.skip(3) // skip first 3
                //.limit(2) //only 2 objects
                .collect(Collectors.toList());

        System.out.println("wyswietl liste");
        System.out.println(adamList);
    }


}
