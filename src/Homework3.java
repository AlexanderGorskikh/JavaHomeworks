import java.util.*;

public class Homework3 {
    //    Пусть дан произвольный список целых чисел.
//
//  1) Нужно удалить из него чётные числа
//  2) Найти минимальное значение
//  3) Найти максимальное значение
//  4) Найти среднее значение
    public static void main(String[] args) {
        new Homework3().taskHW();
    }
    void taskHW() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            result.add(new Random().nextInt(1,50));
        }
        System.out.println("Изначальный список: \n" + result);
        for (int i = 0;i<result.size();i++){
            if(result.get(i)%2==0){
                result.remove(i);
                i--;
            }
        }
        System.out.println("Список после удаления четных чисел: \n" + result);
        System.out.println("Максимальное число: " + Collections.max(result));
        System.out.println("Минимальное число: " + Collections.min(result));
        double average = 0;
        for (Integer integer : result) {
            average += integer;
        }
        average /= result.size();
        System.out.printf("Среднее число: %.2f",average);
    }
}
