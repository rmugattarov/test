package rmugattarov.persongenes;

import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class MostCommnonGene {
    public static void main(String[] args) {
        int[] stats = new int[256];
        List<Person> people = createPeople();

        //people.stream()
        //        .map(Person::getGenes)
        //        .map(String::chars)
        //.flatMapToInt(Function.identity())
        //.forEach(c -> stats[c] = stats[c] + 1);
        //Arrays.sort(stats);
        //System.out.println(Arrays.toString(stats));

        //String mostCommonGene = people.stream()
        //        .map(Person::getGenes)
        //        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        //        .entrySet()
        //        .stream()
        //        .max(Comparator.comparingLong(Map.Entry::getValue))
        //        .get()
        //        .getKey();
        //
        //System.out.println("Most common gene: " + mostCommonGene);
    }

    private static List<Person> createPeople() {
        List<Person> people = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            Person person = new Person(RandomStringUtils.random(4, "ABCD"));
            people.add(person);
        }
        return people;
    }

    private static class Person {
        private String genes;

        private Person(String genes) {
            this.genes = genes;
        }

        public String getGenes() {
            return this.genes;
        }
    }
}
