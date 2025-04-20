package YeYintZin;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    /**
     * Finds the union between two sets
     * @param set1 First set
     * @param set2 Second set
     * @return The union
     */
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        if (set1 == null || set2 == null) {
            return null;
        }
        Set<Integer> results = new LinkedHashSet<>(set1);
        results.addAll(set2);
        return results;
    }

    /**
     * Finds the intersection between two sets
     * @param set1 The first set
     * @param set2 The second set
     * @return The intersection
     */
    public static List<Integer> intersect(Set<Integer> set1, Set<Integer> set2) {
        if (set1 == null || set2 == null) {
            return null;
        }
        return set1.stream().filter(set2::contains).toList();
    }

    /**
     * Finds the difference between two sets
     * @param set1 The first set
     * @param set2 The second set
     * @return The difference
     */
    public static List<Integer> differ(Set<Integer> set1, Set<Integer> set2) {
        if (set1 == null || set2 == null) {
            return null;
        }
        return set1.stream().filter(i -> !set2.contains(i)).toList();
    }

    /**
     * Groups strings based on their first character
     * @param strs List of strings
     * @return A map with the key being the character and the value being the strings
     */
    public static Map<Character, List<String>> groupWords(String[] strs) {
        if (strs == null) {
            return null;
        }
        Map<Character, List<String>> results = new LinkedHashMap<>();
        for (String str : strs) {
            if (str == null) {
                results.put(null, new ArrayList<>());
                results.get(null).add(null);
                continue;
            }
            if (str.isEmpty()) {
                continue;
            }
            results.putIfAbsent(str.charAt(0), new ArrayList<>());
            results.get(str.charAt(0)).add(str);
        }
        return results;
    }

    /**
     * Groups item by category
     * @param items List of items
     * @return A map with the key being the category, and the value being a list of items belonging to said category.
     */
    public static Map<String, List<Item>> groupItemsByCategory(List<Item> items) {
        if (items == null) {
            return null;
        }
        Map<String, List<Item>> results = new LinkedHashMap<>();
        for (Item i : items) {
            if (i == null) {
                results.put(null, new ArrayList<>());
                results.get(null).add(null);
                continue;
            }
            String category = i.category;
            results.putIfAbsent(category, new ArrayList<>());
            results.get(category).add(i);
        }
        return results;
    }

    /**
     * Calculates the average price from each category
     * @param group map being the grouping from groupItemsByCategory()
     * @return A map where the key is the category and the value is the average price
     */
    public static Map<String, Double> calcAveragePrice(Map<String, List<Item>> group) {
        // Check if the inputted map is null
        if (group == null) {
            return null;
        }
        Map<String, Double> results = new LinkedHashMap<>();
        for (String category : group.keySet()) {
            double totalPrice = 0;
            for (Item i : group.get(category)) {
                // Checks if the item is null
                if (i == null) {
                    results.put(null, null);
                    continue;
                }
                totalPrice += i.price;
            }
            totalPrice /= group.get(category).size();
            results.put(category, totalPrice);
        }
        return results;
    }

    /**
     * Puts to title case each string in a list of string
     * @param str The list of strings
     * @return The list of strings to title case
     */
    public static List<String> toTitleCase(List<String> str) {
        if (str == null) {
            return null;
        }
        return str.stream().filter(Objects::nonNull).map(s -> {
            s = s.substring(0, 1).toUpperCase() + s.substring(1, s.indexOf(' ')).toLowerCase()
            + s.substring((s.indexOf(' ') + 1), s.indexOf(' ') + 2).toUpperCase()
            + s.substring((s.indexOf(' ') + 2)).toLowerCase();
            return s;
        }).toList();
    }


    /**
     * Finds all username in a specific domain
     * @param emails All users (emails)
     * @param domainKeyword The domain we look for
     * @return A list containing the users of all users of the domain
     */
    public static List<String> findUserNameForSpecificDomain (List<String> emails, String domainKeyword) {
        if (emails == null || domainKeyword == null) {
            return null;
        }
        return emails.stream().filter(Objects::nonNull).map(email -> {
                    if (email.contains(domainKeyword)) {
                        email = email.substring(0, email.indexOf(domainKeyword) - 1);
                        return email;
                    }
                    else {
                        email = "";
                    }
                    return email;
                }).filter(s -> !s.equals("")).toList();
    }

    public static class Item {
        private String name;
        private String category;
        private double price;

        public Item(String name, String category, double price) {
            this.name = name;
            this.category = category;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", category='" + category + '\'' +
                    ", price=" + price +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

    }
}
