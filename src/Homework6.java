import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Homework6 {
    /* Задание сымитировать работу HashSet используя другие коллекции, которая будет хранить в себе Integer
    реализовать методы:
    добавления элемента
    удаления элемента
    поиска значения по индексу
    переопределение toString
    */
    public static void main(String[] args) {
        SimulationHashSet<Integer> sSet = new SimulationHashSet<>();
        System.out.println(sSet.add(123));
        System.out.println(sSet.add(124));
        System.out.println(sSet.add(125));
        System.out.println(sSet.add(126));
        System.out.println(sSet.remove(123));
        System.out.println(sSet.add(123));

        System.out.println(sSet.valueOf(1));

        System.out.println(sSet);

        Iterator<Integer> iterator = sSet.iterator();
        while(iterator.hasNext()){
           System.out.print( iterator.next() + " ");
        }


    }
    static class SimulationHashSet<T>{
        private HashMap<T,Object> mySet = new HashMap<>();
        private static final Object CONSTANT = new Object();

        public boolean add(T value){
            return mySet.put(value,CONSTANT)==null;
        }
        public boolean remove(T value){
            return mySet.remove(value)!=null;
        }
        public String toString(){
            return mySet.keySet().toString();
        }
        public Iterator<T> iterator(){
            return mySet.keySet().iterator();
        }
        public T valueOf(int index){
            ArrayList<T> arrayList = new ArrayList<>(mySet.keySet());
            return arrayList.get(index);
        }
    }
}
