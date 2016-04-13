import java.awt.*;

class Main {

    public  Window window;
    public final Input input;
    public Graphics2D gfx;
    public AssetLoader assetLoader;

    public Main() {
        window = new Window("SphereShooter", 800, 600);
        input = new Input();
        window.registerKeyListener(input);
        gfx = window.getGraphics();

        assetLoader = new AssetLoader();

        Game game = new Game(this);

        long beforeTime = System.nanoTime();
        
        while(true) {

            long nowTime = System.nanoTime();
            game.update((nowTime-beforeTime)/1000000000.0f);
            beforeTime = nowTime;

            window.render();
            
            /*
            try {
                Thread.sleep(30);
            }
            catch(InterruptedException e) {
                // Ignore..
            }
            */
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}

