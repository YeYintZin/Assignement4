import YeYintZin.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MainTest {

    @Test
    public void unionTest() {
        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();
        for (int i = 1; i < 5; i++) {
            set1.add(i);
        }
        for (int i = 3; i < 7; i++) {
            set2.add(i);
        }
        Set<Integer> result = Main.union(set1,set2);
        Set<Integer> expected = new LinkedHashSet<>();
        for (int i = 1; i < 7; i++) {
            expected.add(i);
        }
        Assertions.assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void unionNullTest() {
        Set<Integer> set1 = new LinkedHashSet<>();
        for (int i = 1; i < 5; i++) {
            set1.add(i);
        }
        Set<Integer> result = Main.union(set1,null);
        Assertions.assertNull(result);
    }

    @Test
    public void unionBothNullTest() {
        Set<Integer> set1 = null;
        Set<Integer> set2 = null;
        Set<Integer> result = Main.union(set1,set2);
        Assertions.assertNull(result);
    }

    @Test
    public void unionContainNullTest() {
        Set<Integer> set1 = new LinkedHashSet<>();
        for (int i = 1; i < 5; i++) {
            set1.add(i);
        }
        Set<Integer> set2 = new LinkedHashSet<>();
        for (int i = 3; i < 6; i++) {
            set2.add(i);
        }
        set2.add(null);
        Set<Integer> expected = new LinkedHashSet<>();
        for (int i = 1; i < 6; i++) {
            expected.add(i);
        }
        expected.add(null);
        Set<Integer> result = Main.union(set1,set2);
        Assertions.assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void intersectTest() {
        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();
        for (int i = 1; i < 5; i++) {
            set1.add(i);
        }
        for (int i = 3; i < 7; i++) {
            set2.add(i);
        }
        List<Integer> result = Main.intersect(set1,set2);
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(4);
        Assertions.assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void intersectNullTest() {
        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = null;
        List<Integer> result = Main.intersect(set1, set2);
        Assertions.assertNull(result);
    }
    @Test
    public void intersectBothNullTest() {
        Set<Integer> set1 = null;
        Set<Integer> set2 = null;
        List<Integer> result = Main.intersect(set1, set2);
        Assertions.assertNull(result);
    }

    @Test
    public void intersectContainNullTest() {
        Set<Integer> set1 = new LinkedHashSet<>();
        for (int i = 1; i < 5; i++) {
            set1.add(i);
        }
        set1.add(null);
        Set<Integer> set2 = new LinkedHashSet<>();
        for (int i = 3; i < 7; i++) {
            set2.add(i);
        }
        set2.add(null);
        List<Integer> result = Main.intersect(set1,set2);
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(4);
        expected.add(null);
        Assertions.assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void differTest() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 1; i < 5; i++) {
            set1.add(i);
        }
        for (int i = 3; i < 7; i++) {
            set2.add(i);
        }
        List<Integer> result = Main.differ(set1,set2);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        Assertions.assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void differNullTest() {
        Set<Integer> set1 = null;
        Set<Integer> set2 = new LinkedHashSet<>();
        List<Integer> result = Main.differ(set1, set2);
        Assertions.assertNull(result);
    }

    @Test
    public void differBothNullTest() {
        Set<Integer> set1 = null;
        Set<Integer> set2 = null;
        List<Integer> result = Main.differ(set1, set2);
        Assertions.assertNull(result);
    }

    @Test
    public void differContainNullTest() {
        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();
        for (int i = 1; i < 5; i++) {
            set1.add(i);
        }
        set1.add(null);
        for (int i = 3; i < 7; i++) {
            set2.add(i);
        }
        List<Integer> result = Main.differ(set1,set2);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(null);
        Assertions.assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void groupWordsTest() {
        String[] input = {"hi", "how", "are", "you", "apple", "banana"};
        Map<Character, List<String>> expected = new HashMap<>();
        expected.put('a', Arrays.asList("are", "apple"));
        expected.put('b', List.of("banana"));
        expected.put('h', List.of("hi", "how"));
        expected.put('y', List.of("you"));
        Map<Character, List<String>> results = Main.groupWords(input);
        Assertions.assertEquals(expected, results);
    }

    @Test
    public void groupWordsNullTest() {
        String[] input = null;
        Map<Character, List<String>> results = Main.groupWords(input);
        Assertions.assertNull(results);
    }

    @Test
    public void groupWordsContainNullTest() {
        String[] input = {"potato", null};
        Map<Character, List<String>> expected = new HashMap<>();
        expected.put('p', List.of("potato"));
        List<String> nulls = new ArrayList<>();
        nulls.add(null);
        expected.put(null, nulls);
        Map<Character, List<String>> results = Main.groupWords(input);
        Assertions.assertEquals(expected, results);
    }

    @Test
    public void groupItemsByCategoryTest() {
        Map<String, List<Main.Item>> expected = new HashMap<>();
        List<Main.Item> items = new ArrayList<>();
        items.add(new Main.Item("chicken", "animal", 40));
        items.add(new Main.Item("cow", "animal", 4000));
        items.add(new Main.Item("pants", "clothes", 40));
        items.add(new Main.Item("david", "human", -5));

        expected.put("animal", Arrays.asList(items.get(0), items.get(1)));
        expected.put("clothes", Arrays.asList(items.get(2)));
        expected.put("human", Arrays.asList(items.get(3)));
        Map<String, List<Main.Item>> results = Main.groupItemsByCategory(items);
        Assertions.assertEquals(expected, results);
    }

    @Test
    public void groupItemsByCategoryNullParameterTest() {
        Map<String, List<Main.Item>> results = Main.groupItemsByCategory(null);
        Assertions.assertNull(results);
    }


    @Test
    public void groupItemsByCategoryItemNullTest() {
        Map<String, List<Main.Item>> expected = new HashMap<>();
        List<Main.Item> items = new ArrayList<>();
        items.add(new Main.Item("chicken", "animal", 40));
        items.add(new Main.Item("cow", "animal", 4000));
        items.add(new Main.Item("pants", "clothes", 40));
        items.add(null);
        expected.put("animal", Arrays.asList(items.get(0), items.get(1)));
        expected.put("clothes", Arrays.asList(items.get(2)));
        expected.put(null, Arrays.asList(items.get(3)));
        Map<String, List<Main.Item>> results = Main.groupItemsByCategory(items);
        Assertions.assertEquals(expected, results);
    }

    @Test
    public void calcAveragePriceTest() {
        Map<String, Double> expected = new HashMap<>();
        expected.put("animal", 2020.0);
        expected.put("clothes", 40.0);
        expected.put("human", -5.0);
        List<Main.Item> items = new ArrayList<>();
        items.add(new Main.Item("chicken", "animal", 40));
        items.add(new Main.Item("cow", "animal", 4000));
        items.add(new Main.Item("pants", "clothes", 40));
        items.add(new Main.Item("david", "human", -5));
        Map<String, List<Main.Item>> test = Main.groupItemsByCategory(items);
        Map<String, Double> results = Main.calcAveragePrice(test);
        Assertions.assertEquals(expected, results);
    }

    @Test
    public void calcAveragePriceNullParameterTest() {
        Map<String, Double> results = Main.calcAveragePrice(null);
        Assertions.assertNull(results);
    }

    @Test
    public void calcAveragePriceContainNullKeyTest() {
        Map<String, Double> expected = new HashMap<>();
        expected.put("animal", 2020.0);
        expected.put("clothes", 40.0);
        expected.put(null, 0.0);
        List<Main.Item> items = new ArrayList<>();
        items.add(new Main.Item("chicken", "animal", 40));
        items.add(new Main.Item("cow", "animal", 4000));
        items.add(new Main.Item("pants", "clothes", 40));
        items.add(null);
        Map<String, Double> results = Main.calcAveragePrice(Main.groupItemsByCategory(items));
        Assertions.assertEquals(expected, results);
    }

    @Test
    public void calcAveragePriceNullItemTest() {
        Map<String, Double> expected = new HashMap<>();
        expected.put("animal", 2020.0);
        expected.put("clothes", 40.0);
        expected.put(null, 0.0);
        List<Main.Item> items = new ArrayList<>();
        items.add(new Main.Item("chicken", "animal", 40));
        items.add(new Main.Item("cow", "animal", 4000));
        items.add(new Main.Item("pants", "clothes", 40));
        items.add(null);
        Map<String, Double> results = Main.calcAveragePrice(Main.groupItemsByCategory(items));
        Assertions.assertEquals(expected, results);
    }

    @Test
    public void toTitleCaseTest() {
        List<String> expected = new ArrayList<>();
        expected.add("HelloWorld");
        expected.add("YouSmell");
        List<String> str = new ArrayList<>();
        str.add("hello world");
        str.add("YOU SMELL");
        List<String> results = Main.toTitleCase(str);
        Assertions.assertEquals(expected, results);
    }

    @Test
    public void toTitleCaseNullParameterTest() {
        List<String> results = Main.toTitleCase(null);
        Assertions.assertNull(results);
    }

    @Test
    public void toTitleCaseContainNullTest() {
        List<String> expected = new ArrayList<>();
        expected.add("HelloWorld");
        expected.add("YouSmell");
        List<String> str = new ArrayList<>();
        str.add("hello world");
        str.add("YOU SMELL");
        str.add(null);
        List<String> results = Main.toTitleCase(str);
        Assertions.assertEquals(expected, results);
    }

    @Test
    public void findUserforSpecificDomainTest() {
        List<String> expected = new ArrayList<>();
        expected.add("a");
        expected.add("b");
        List<String> emails = new ArrayList<>();
        emails.add("a@gmail.com");
        emails.add("b@gmail.com");
        emails.add("c@vaniercollege.com");
        emails.add("d@hotmail.com");
        List<String> result = Main.findUserNameForSpecificDomain(emails, "gmail");
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void findUserforSpecificDomainNullParameterTest1() {
        List<String> results = Main.findUserNameForSpecificDomain(null, "gmail");
        Assertions.assertNull(results);
    }

    @Test
    public void findUserforSpecificDomainNullParameterTest2() {
        List<String> results = Main.findUserNameForSpecificDomain(new ArrayList<>(), null);
        Assertions.assertNull(results);
    }

    @Test
    public void FindUserforSpecificDomainNullParameterTest3() {
        List<String> results = Main.findUserNameForSpecificDomain(null, null);
        Assertions.assertNull(results);
    }

    @Test
    public void findUserforSpecificDomainContainNull() {
        List<String> expected = new ArrayList<>();
        expected.add("a");
        expected.add("b");
        List<String> emails = new ArrayList<>();
        emails.add("a@gmail.com");
        emails.add("b@gmail.com");
        emails.add("c@vaniercollege.com");
        emails.add(null);
        List<String> result = Main.findUserNameForSpecificDomain(emails, "gmail");
        Assertions.assertEquals(expected, result);
    }
}
