package com.sda.stream;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
//        1) Sprawdź czy podany String jest isogramem (nie ma powtarzających się liter)
//        2) W tablicy intów zwróc element o najmneijszej wartości powtarzający się nieparzystą ilość razy.
//        3) Znajdź najmniejszą wartość w tabicy longów
//        4) uzyskaj iloczyn wszystkich elementów tablicy Intigerów
//        5) Wyświetl listę imion w odwrotnym porzadku numerów telefonów (numer telefonu potraktuj jako liczbe nie Stringa!)
    public static void main(String[] args) {
        List<Dog> dogs = dogList();
        System.out.println(dogs);
        firstStream(dogs);
        secoundStream(dogs);


        System.out.println("isogram: "+ isIsogram("asdf"));
    }

    private static boolean isIsogram(String string) {
        return string
                .toLowerCase()
                .chars()
                .mapToObj(i -> (char) i)
                .distinct()
                .map(Object::toString)
                .collect(Collectors.joining())
                .length() == string.length();
    }

    private static int findOddInt(int[] a) throws Exception {
        Map<Integer, Long> oddNumberOccurrences = (Arrays.stream(a)
                .boxed()
                .collect(Collectors.toList()))
                .stream()
               .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return oddNumberOccurrences.entrySet()
                .stream()
                .filter(e -> e.getValue() % 2 == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new Exception("Nie ma elementu powarzającego się nieparzystą ilość razy"));
    }

    private static long findSmallestLong(long[] longs) throws Exception {
        return Arrays.stream(longs).min().orElseThrow(() -> new Exception("Nie można znaleść elementu o minimalnej wartości"));
    }

    private static int productOfInts(int[] ints) {
        return Arrays.stream(ints).reduce(0, (a, b) -> a * b);
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
