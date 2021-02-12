import java.util.logging.Handler;

public class Update implements Runnable {
    private Gui gui;
    private Handler handler;

    public Update(Gui g) {
        this.gui = g;

    }

    @Override
    public void run() {
        gui.update(null);

        handler.toString();


    }
}