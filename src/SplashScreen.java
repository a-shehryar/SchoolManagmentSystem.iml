import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JFrame implements Runnable {

    Thread t;

    SplashScreen() {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("download.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        t = new Thread(this);
        t.start();

        setVisible(true);

        int x = 1;
        for (int i = 2; i <= 600; i += 7, x += 1) {
            setLocation(550 - ((i + x) / 3), 350 - (i / 2));
            setSize(i + 1 * x/2, i + x / 4);

            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
    }

    public void run() {
        try {
            Thread.sleep(7000);
            setVisible(false);

            // Next Frame
            new LoginPage();
        } catch (Exception e) {

        }
    }
}