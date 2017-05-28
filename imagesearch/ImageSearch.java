package imagesearch;

import java.io.IOException;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class ImageSearch {

    public static void main(String[] args) {
        ArrayList<String> imgUrl = new ArrayList<>();
        String query = JOptionPane.showInputDialog("Image search:").replace(" ", "+");
        System.out.println("Search query: " + query);

        if (query != null) {
            try {
                URL url = new URL("https://imgur.com/search?q=" + query);
                Scanner s = new Scanner(url.openStream());

                while (s.hasNext()) {
                    String line = s.next();

                    if (line.contains("img")) {
                        String[] strings = line.split(" ");

                        for (String string : strings) {
                            if (string.split("=")[0].equals("src") && !string.contains(".js") && !string.contains(".html") && !string.contains(".php") && !string.contains(".gif")) {
                                imgUrl.add(string.split("src=")[1].replaceAll("\"", ""));
                            }
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("java.lang.IOException - Error finding or reading file.");
            }
        } else {
            System.exit(0);
        }

        if (imgUrl.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Could not find any pictures.");
            System.exit(0);
        } else {
            for (int i = 0; i < imgUrl.size(); i++) {
                String path = "https:" + imgUrl.get(i);
                Window w = new Window(path);
                System.out.println(path);
                try {Thread.sleep(1000);} catch (InterruptedException ex) {}
            }
        }
    }
}
