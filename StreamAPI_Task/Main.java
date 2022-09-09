import java.util.*;

public class Main {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };


    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();



        List<Person> people = Arrays.stream(RAW_DATA).
                distinct().
                sorted(Comparator.comparing(Person::getName).thenComparing(Person::getId)).
                filter(Objects::nonNull).
                toList();

        String buffer = people.get(0).getName();
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        int counter = 0;
        for (Person person : people) {
            if(buffer.equals(person.getName())) {
                counter++;
            } else {
                result.put(buffer, counter);
                buffer = person.getName();
                counter = 1;
                result.putIfAbsent(buffer, counter);
            }
        }

        result.forEach((s, i) -> System.out.println("Key:" + s + "\nValue:" + i));

        testTask2();

        testFuzzySearch();

    }

    static int[] task2(int[] array, int sumValue){

        if(array == null){
            return new int[]{-1, -1};
        }

        for(int i = 0; i < array.length; i++){
            for(int j = i + 1; j < array.length; j++){
                if(array[i] + array[j] == sumValue) return new int[]{array[i], array[j]};
            }
        }
        return new int[]{-1, -1}; // incorrect value case
    }

    static void testTask2(){
        System.out.println("Test 1 : array : [3, 4, 2, 7], summary value is 10");
        System.out.println("result is : " + Arrays.toString(task2(new int[]{3, 4, 2, 7}, 10)));

        System.out.println("Test 2 : array : [1, 3, 6, 22, 25, 98, 14, 22, 0], summary value is 14");
        System.out.println("result is : " + Arrays.toString(task2(new int[]{1, 3, 6, 22, 25, 98, 14, 22, 0}, 14)));

        System.out.println("Test 3 : array : [1], summary value is 8");
        System.out.println("result is : " + Arrays.toString(task2(new int[]{1}, 14)));

        System.out.println("Test 4 : array : null, summary value is 0");
        System.out.println("result is : " + Arrays.toString(task2(null, 0)));
    }

    static boolean fuzzySearch(String string, String mustContain){
        if(string == null || mustContain == null){
            return false;
        }
        char[] charsString = string.toCharArray();
        char[] charsMust = mustContain.toCharArray();
        for(int i = 0, flag = 0; i < mustContain.length(); i++){
            if(charsString[flag] == charsMust[i]) flag++;
            if(flag == string.length()) return true;
        }
        return false;
    }

    static void testFuzzySearch(){
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel")); // true
        System.out.println(fuzzySearch("cwhl", "cartwheel")); // true
        System.out.println(fuzzySearch("cwhee", "cartwheel")); // true
        System.out.println(fuzzySearch("cartwheel", "cartwheel")); // true
        System.out.println(fuzzySearch("cwheeel", "cartwheel")); // false
        System.out.println(fuzzySearch("lw", "cartwheel")); // false
        System.out.println(fuzzySearch(null, "cartwheel")); // false (null check)
    }




}
