import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Window {

    private JFrame frame;
    private Canvas canvas;

    private BufferStrategy bs;
    private Graphics2D gfx;

    private BufferedImage img;

    public final int WIDTH, HEIGHT;

    public Window(String title, int width, int height) {
        WIDTH = width;
        HEIGHT = height;

        frame = new JFrame(title);
        frame.setIgnoreRepaint(false);

        canvas = new Canvas();
        canvas.setIgnoreRepaint(false);
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setBackground(Color.BLACK);

        frame.add(canvas);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public Graphics2D getGraphics() {
        if (gfx == null) {
            img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
            gfx = img.createGraphics();
        }

        return gfx;
    }

    public void render() {
        bs = canvas.getBufferStrategy();
        if (bs == null) {
            canvas.createBufferStrategy(2);
            return;
        }

        Graphics2D g = (Graphics2D)bs.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        g.drawImage(img, 0, 0, null);

        g.dispose();

        bs.show();

        Toolkit.getDefaultToolkit().sync();
    }

    public void registerKeyListener(KeyListener kl) {
        frame.addKeyListener(kl);
        canvas.addKeyListener(kl);
    }
}

