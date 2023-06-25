import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Homework1 {
    public static void main(String[] args) {
        /*
        Первый семинар.
1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

Пункты реализовать в методе main
*Пункты реализовать в разных методах

int i = new Random().nextInt(k); //это кидалка случайных чисел!)
        */
        int i = Homework1.rndInt();
        int n = Homework1.maxBit(i);
        List<Integer> m1 = Homework1.multiplesArrBit(n);
        List<Integer> m2 = Homework1.notMultiplesArrBit(i,n);
        System.out.println(m1);
        System.out.println(m2);
    }
    static int rndInt() {
//      Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
        return new Random().nextInt(0, 2000);
    }
    static int maxBit(int rndInt){
        // считаем самую большую степень двойки меньше исходного числа
        int result = 0;
        for (int i = 0,j = 1;j<=rndInt;j*=2,i++){
          result = i;
        }
        return result;
    }
    static List<Integer> multiplesArrBit(int n){
        // Добавляем числа, которые делятся без остатка на n
        List<Integer> result = new ArrayList<>();
        for(int i =0;i<Short.MAX_VALUE;i++){
            if(i%n==0){
                result.add(i);
            }
        }
        return result;
    }
    static List<Integer> notMultiplesArrBit(int i, int n){
        // Сохраняем в массив числа которые делятся с остатком на число n в диапазоне до MIN_VALUE до i
        List<Integer> result = new ArrayList<>();
        for (int j = Short.MIN_VALUE; j < i; j++) {
            if(j%n!=0){
                result.add(j);
            }
        }
        return result;
    }
}
