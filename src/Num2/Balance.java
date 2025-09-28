/**
 * Created by student on 22.09.2025.
 */
package Num2;

public class Balance {
    int right_weight = 0;
    int left_weight = 0;

    public void addRight(int weight){right_weight += weight;}

    public void addLeft(int weight){left_weight += weight;}

    public void result()
    {
        if (right_weight > left_weight) System.out.println("R");
        else if (right_weight < left_weight) System.out.println("L");
        else System.out.println("=");
    }

    public Balance(){};
}
