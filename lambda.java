import java.util.*;

public class LambdaExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 1, 3, 2, 4);

       
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("Sorted list using anonymous Comparator: " + numbers);

   
        numbers = Arrays.asList(5, 1, 3, 2, 4); 

        Collections.sort(numbers, (Integer o1, Integer o2) -> o1.compareTo(o2));
        System.out.println("Sorted list using Lambda Expression: " + numbers);
    }
}
