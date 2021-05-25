import net.ngcell.apng.*;
import net.ngcell.apng.chunk.FrameControl;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

public final class MainRender extends ApngRenderImpl {
    private class MainWindows {
        private JFrame frame;
        private AnimateView view;

        public MainWindows(int width,int height) {
            this.frame = new JFrame();
            frame.setPreferredSize(new Dimension(width,height));
            frame.setMaximumSize(new Dimension(width,height ));
            view = new AnimateView();
            view.setMaximumSize(new Dimension(width, height));
            view.setPreferredSize(new Dimension(width,height));
            frame.add(view);
            frame.setContentPane(view);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
        }

        public void setFrameXOffset(int x) {
            view.setXOffset(x);
        }

        public void setFrameYOffset(int y) {
            view.setYOffset(y);
        }

        public void setFrameDelay(int time) {
            view.setDelay(time);
        }

        public void addFrame(BufferedImage image) {
            view.addFrame(image);
        }

        public void start() {
            frame.setVisible(true);
            frame.setResizable(false);
            view.start();
        }
    }



    @Override
    public void play() {
        ID id = new ID();
        try{
            MainWindows windows = new MainWindows(getWidth(),getHight());
            List<OutputStream> frames = decoder();

            for(OutputStream byteArray : frames) {
                FileOutputStream file = new FileOutputStream(new File(Main.class.getResource("").getPath() + "IMG" + id.getID() + ".png"));
                file.write(((ByteArrayOutputStream)byteArray).toByteArray());
                byteArray.close();
                file.close();
            }
            List<FrameControl> fCtrl = getFrameControl();
            //MainWindows windows = new MainWindows(getWidth(),getHight());
            if(isSkipFirstFrame()) {
                for(int i = 1;i < fCtrl.size();i++) {
                    windows.setFrameXOffset(fCtrl.get(i).getXOffset());
                    windows.setFrameYOffset(fCtrl.get(i).getYOffset());
                    windows.setFrameDelay(fCtrl.get(i).getDelay() / 2);
                    ByteArrayInputStream stream = new ByteArrayInputStream(((ByteArrayOutputStream)frames.get(i)).toByteArray());
                    windows.addFrame(ImageIO.read(stream));
                }
            } else {
                for(int i = 0;i < fCtrl.size();i++) {
                    windows.setFrameXOffset(fCtrl.get(i).getXOffset());
                    windows.setFrameYOffset(fCtrl.get(i).getYOffset());
                    windows.setFrameDelay(fCtrl.get(i).getDelay() / 2);
                    ByteArrayInputStream stream = new ByteArrayInputStream(((ByteArrayOutputStream)frames.get(i)).toByteArray());
                    windows.addFrame(ImageIO.read(stream));
                }
            }
            windows.start();
            System.out.println("-----" + getName() + "-----");
            System.out.println("Hight: " + getHight() + ",Width: " + getWidth());
            System.out.println(getAnimateControl().toString());
            System.out.println(getFrameControl().get(0).toString() + " isSkipFirstFrame: " + isSkipFirstFrame() + ",FrameControlSize: " + getFrameControl().size());
            System.out.println("-----End-----");
        } catch (ApngException e) {
            ApngUtilities.getLog().log(ApngLog.WARNING, "could not play", e);
        } catch (IOException e) {
            ApngUtilities.getLog().log(ApngLog.WARNING, "could not write image file", e);
        }
    }

    public void pause() {

    }

    public void stop() {

    }
}
