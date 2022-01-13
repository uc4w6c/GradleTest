package comparator;

import java.util.Comparator;
import java.util.List;

public class SpecifiedOrderList {
    public static void main(String[] args) {
        record Person(String name, String hobby) {}

        var people = List.of(
            new Person("一郎", "サッカー"),
            new Person("二郎", "バイオリン"),
            new Person("三郎", "音楽鑑賞"),
            new Person("四郎", "ドラマ鑑賞"),
            new Person("五郎", "ソフトボール"));

        var specifyOrder = List.of("四郎", "五郎", "一郎", "三郎", "二郎");

        // Comparator<Person> specifyOrderComparator = (c1, c2) -> specifyOrder.indexOf(c1.name) - (specifyOrder.indexOf(c2.name));
        people.stream()
                // .sorted((c1, c2) -> specifyOrder.indexOf(c1.name) - specifyOrder.indexOf(c2.name))
                .sorted((c1, c2) -> Integer.compare(specifyOrder.indexOf(c1.name), specifyOrder.indexOf(c2.name)))
                .forEach(System.out::println);
    }

    // public static record Person(String name, String hobby) {}
}
