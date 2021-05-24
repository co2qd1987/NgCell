import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public final class AnimateView extends JLabel {
    private PaintThread paint;
    private List<BufferedImage> image = new ArrayList<>();
    private int x_offset = 0;
    private int y_offset = 0;
    private int delay = 40;
    private int num = 0;

    public void paint(Graphics g) {
        g.drawImage(image.get(num),x_offset,y_offset,null);
        num++;
        if(num >= image.size()) {
            num = 0;
        }
    }

    public void addFrame(BufferedImage image) {
        this.image.add(image);
    }

    public void setXOffset(int x) {
        this.x_offset = x;
    }

    public void setYOffset(int y) {
        this.y_offset = y;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void start(){
        paint = new PaintThread();
        paint.setDelay(this.delay);
        paint.start();
    }


    private class PaintThread extends Thread {
        private int time = 40;


        public void run(){
            while(true){
                repaint();
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }

        public void setDelay(int time) {
            this.time = time;
        }

    }
}
