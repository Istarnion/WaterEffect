import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class AssetLoader {

    private HashMap<String, BufferedImage> images;

    public AssetLoader() {
        images = new HashMap<String, BufferedImage>();
        loadImage("bg", "resources/ground.png");
    }

    private void loadImage(String name, String file) {
        try {
            BufferedImage img = ImageIO.read(new File(file));

            BufferedImage imgARGB = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = imgARGB.createGraphics();
            g.drawImage(img, 0, 0, null);

            images.put(name, imgARGB);
        }
        catch(IOException e) {
            System.err.println("Failed to load image "+file);
        }
    }

    public BufferedImage getImage(String name) {
        return images.get(name);
    }
}

