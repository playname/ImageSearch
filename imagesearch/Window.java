package imagesearch;

import java.io.*;
import java.net.*;
import javax.imageio.*;
import javax.swing.*;

public class Window extends JFrame {

    JFrame frame = new JFrame("Imgur image search");
    JLabel label = new JLabel();

    public Window() {
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public void pic(String path) throws IOException {
        frame.remove(label);
        
        try {
            URL url = new URL(path);
            label = new JLabel(new ImageIcon(ImageIO.read(url)));
        } catch (MalformedURLException ex) {}
        
        frame.getContentPane().add(label);
        frame.pack();
    }
}
