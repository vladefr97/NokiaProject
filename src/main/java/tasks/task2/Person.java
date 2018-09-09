package tasks.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Person implements Comparable<Person> {

    private int age;
    private boolean gender; //true - male, false - female
    private String name;
    static private String[] manNames = {"Vladimir", "Donald", "Petr", "Alexander", "Aleksey"};
    static private String[] womanNames = {"Elizabeth", "Angela", "Hillary", "Ksenia"};

    public Person() {

    }


    public Person(int age) {
        this.age = age;
    }

    public Person(int age, boolean gender, String name) {
        this.age = age;
        this.gender = gender;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public static Person getRandomPerson() {

        Random random = new Random();
        int age = 1 + random.nextInt(99);
        boolean sex = random.nextBoolean();

        String name;
        if (sex)
            name = manNames[random.nextInt(manNames.length)];
        else
            name = womanNames[random.nextInt(womanNames.length)];

        return new Person(age, sex, name);


    }

    public static List<Person> getRandomPersonsList(int personsCount) {

        List<Person> list = new ArrayList<>(personsCount);
        for (int i = 0; i < personsCount; i++)
            list.add(getRandomPerson());

        return list;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person person) {
        if (this.age != person.age)
            return this.age > person.age ? 1 : -1;
        if (this.gender != person.gender) {
            return this.gender == true ? 1 : -1;
        }
        return this.name.compareTo(person.name);

    }
}

