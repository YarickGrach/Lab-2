package Num4;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 22.09.2025.
 */
public class OddEvenSeparator {
    ArrayList<Integer> odd_numbers;
    ArrayList<Integer> even_numbers;

    public void addNumber(int number){
        if (number % 2 == 0) even_numbers.add(number);
        else odd_numbers.add(number);
    }

    public void even(){
        System.out.println(even_numbers);
    }

    public void odd(){
        System.out.println(odd_numbers);
    }

    public OddEvenSeparator(){
        odd_numbers = new ArrayList<Integer>();
        even_numbers = new ArrayList<Integer>();
    };
}
