import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    
    private Graphics2D renderer;
    private Input input;

    BufferedImage bg;
    
    public final int WIDTH, HEIGHT;

    private float t;
    private Raster bgPixelRaster;
    private int[] pixels, pixelsCopy;

    double periodeMod = 1;
    double freq = 1;
    double amplitude = 1;

    public Game(Main main) {
        WIDTH = main.window.WIDTH;
        HEIGHT = main.window.HEIGHT;

        this.renderer = main.gfx;

        input = main.input;

        bg = main.assetLoader.getImage("bg");
        bgPixelRaster = bg.copyData(null);
        pixels = new int[bg.getWidth() * bg.getHeight() * 4];
        pixelsCopy = new int[pixels.length];
    }

    public void update(float delta) {
        t += delta;

        bgPixelRaster.getPixels(0, 0, bg.getWidth(), bg.getHeight(), pixels);

        for (int i=0; i<pixelsCopy.length; i++) {
            pixelsCopy[i] = pixels[i];
        }

        if(input.isKeyPressed(KeyEvent.VK_W)) {
            amplitude += delta;
        }
        else if(input.isKeyPressed(KeyEvent.VK_S)) {
            amplitude -= delta;
        }
        if(input.isKeyPressed(KeyEvent.VK_E)) {
            freq += delta;
        }
        else if(input.isKeyPressed(KeyEvent.VK_Q)) {
            freq -= delta;
        }
        if(input.isKeyPressed(KeyEvent.VK_UP)) {
            periodeMod += delta;
        }
        else if(input.isKeyPressed(KeyEvent.VK_DOWN)) {
            periodeMod -= delta;
        }

        for (int row=0; row<bg.getHeight(); row++) {
            int xOffset = (int)(amplitude*Math.sin((row+t*freq)/periodeMod));
            for (int col=0; col<bg.getWidth()*4; col++) {
                int i = row*bg.getWidth()*4+col;
                int src = wrap(col+xOffset*4, bg.getWidth()*4);
                pixels[i] = pixelsCopy[row*bg.getWidth()*4+src];

                if(i%4 == 2) {
                    pixels[i] = Math.min(pixels[i]+(int)(10*Math.sin(t)+50), 255);
                }
            }
        }

        bg.getRaster().setPixels(0, 0, bg.getWidth(), bg.getHeight(), pixels);

        renderer.drawImage(bg, 0, 0, WIDTH, HEIGHT, null);

        renderer.setColor(Color.RED);
        renderer.drawString("Delta: "+delta, 5, 10);
        renderer.drawString("pMod: "+periodeMod, 5, 20);
        renderer.drawString("freq: "+freq, 5, 30);
        renderer.drawString("ampl: "+amplitude, 5, 40);
        
    }

    private int wrap(int i, int max) {
        if( i< 0 ) {
            return i + (Math.abs(i)/max+1)*max;
        }
        return i - (i/max)*max;
    }
}

