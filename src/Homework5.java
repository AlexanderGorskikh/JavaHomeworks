import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Homework5 {
    //    Реализуйте структуру телефонной книги с помощью HashMap.
//    Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными
//    телефонами, их необходимо считать, как одного человека с разными телефонами. Вывод должен быть
//    отсортирован по убыванию числа телефонов.
    public static void main(String[] args) {
        //
        String[] names = new String[]{
                "Белов Роман Артёмович", "Белов Роман Артёмович", "Родионов Иван Давидович",
                "Баженова Татьяна Олеговна", "Демидов Артём Владимирович", "Панфилов Иван Максимович",
                "Молчанов Гордей Георгиевич", "Пастухов Артемий Михайлович", "Романов Дмитрий Артемьевич",
                "Давыдова Марьям Мироновна"};
        Integer[] numbers = new Integer[]{
                11111111, 22222222, 33333333, 44444444, 55555555,
                66666666, 77777777, 88888888, 99999999, 11111112};
        // переопределяем метод toString для красивого вывода
        Map<String, ArrayList<Integer>> phoneBook = new HashMap<>() {
            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                forEach((key, value) -> sb.append(String.format("%30s ",key)).append(" ").append(value).append("\n"));
                return sb.toString();
            }
        };
        // заполяем с учетом разных номеров у человека
        for (int i = 0; i < names.length; i++) {
            ArrayList<Integer> tmp = new ArrayList<>(1);
            if (phoneBook.containsKey(names[i])) {
                phoneBook.get(names[i]).add(numbers[i]);
            }else{
                tmp.add(numbers[i]);
                phoneBook.put(names[i],tmp);
            }
        }
        System.out.println(phoneBook);
        System.out.println("=".repeat(120));
        // Сортируем по значению и выводим в потоке
        StringBuilder sb = new StringBuilder();
        phoneBook.entrySet().stream().sorted(Map.Entry.comparingByValue((o1, o2) -> o2.size() - o1.size())).forEach(System.out::println);
    }
}
