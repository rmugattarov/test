package rmugattarov.yndx.y2021;

import java.util.*;

public class InterestingTrip {
    public static void main(String[] args) {
        Scanner s = new Scanner("4\n" +
                "0 0\n" +
                "2 0\n" +
                "0 2\n" +
                "2 2\n" +
                "1\n" +
                "1 4");
        int numberOfCities = s.nextInt();
        List<City> cities = new ArrayList<>(numberOfCities);
        for (int i=1; i<=numberOfCities; i++) {
            cities.add(new City(i, s.nextInt(), s.nextInt()));
        }
        int limit = s.nextInt();
        int from = s.nextInt();
        int to = s.nextInt();

        City fromCity = cities.get(from - 1);
        City toCity = cities.get(to - 1);

        Set<City> visited = new HashSet<>();
        visited.add(fromCity);

        HashSet<City> allCities = new HashSet<>(cities);
        System.out.println(visit(toCity, visited, findAccessible(fromCity, visited, allCities, limit), allCities, limit, 1));
    }

    private static int visit(City to, Set<City> visited, Set<City> toVisit, Set<City> allCities, int limit, int iterations) {
        Set<City> nextToVisit = new HashSet<>();
        for (City city: toVisit) {
            if (city == to) return iterations;
            visited.add(city);
            nextToVisit.addAll(findAccessible(city, visited, allCities, limit));
        }
        return nextToVisit.isEmpty() ? -1 : visit(to, visited, nextToVisit, allCities, limit, iterations + 1);
    }

    private static Set<City> findAccessible(City from, Set<City> visited, Set<City> allCities, int limit) {
        Set<City> accessible = new HashSet<>();
        for (City city: allCities) {
            if (visited.contains(city)) continue;
            if (isAccessible(from, city, limit)) {
                accessible.add(city);
            }
        }
        return accessible;
    }

    private static boolean isAccessible(City c1, City c2, int limit) {
        int dist = Math.abs(c1.x - c2.x) + Math.abs(c1.y - c2.y);
        return dist <= limit;
    }

    private static class City {
        int number;
        int x;
        int y;
        public City(int number, int x, int y) {
            this.number = number;
            this.x = x;
            this.y = y;
        }
    }
}
