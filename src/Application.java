import ui.FontSelector;

import java.awt.EventQueue;

/**
 * @author Jacob
 * @since 11/5/2016
 */
public class Application {

    public static void main(String... args) {
        EventQueue.invokeLater(() -> System.out.println(new FontSelector().showDialog()));
    }
}
