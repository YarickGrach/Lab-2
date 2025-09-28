package Num3;

/**
 * Created by student on 22.09.2025.
 */
public class Bell {
    boolean sound_order = true;

    public  void sound(){
        if (sound_order) {
            System.out.println("ding");
            sound_order = !sound_order;
        }
        else{
            System.out.println("dong");
            sound_order = !sound_order;
        }
    }

    public Bell(){};
}
