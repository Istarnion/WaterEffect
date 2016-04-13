import java.awt.event.*;

public class Input implements KeyListener {

    private boolean[] keysPressed;

    public Input() {
        keysPressed = new boolean[1024];
    }

    public boolean isKeyPressed(int keyCode) {
        return keysPressed[keyCode];
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        keysPressed[ke.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        keysPressed[ke.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent ke) {}
    
}

