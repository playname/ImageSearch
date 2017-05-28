package imagesearch;

import java.io.*;
import java.net.*;
import javax.imageio.*;
import javax.swing.*;

public class Window extends JFrame {

    JFrame frame = new JFrame("Imgur image search");

    public Window(String path) {
        try {
            URL url = new URL(path);

            frame.getContentPane().add(new JLabel(new ImageIcon(ImageIO.read(url))));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (IOException e) {
        }
    }
}
