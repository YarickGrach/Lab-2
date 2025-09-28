/**
 * Created by student on 22.09.2025.
 */
package Num1;

public class Butto{
    int click_count = 0;

    public void click(){
        click_count += 1;
        System.out.println("Now " + click_count + " clicks");
    }

    public Butto(){};
}
