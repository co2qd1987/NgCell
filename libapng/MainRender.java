import net.ngcell.apng.*;
import net.ngcell.apng.chunk.FrameControl;
import net.ngcell.apng.j2se.J2SEView;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.io.*;
import java.util.List;

public final class MainRender extends ApngRenderImpl {
    private JFrame view = null;
    private J2SEView render = null;
    private List<OutputStream> frames = null;
    private List<FrameControl> frameCtrl = null;
    private int width = 0;
    private int height = 0;


    public MainRender(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public MainRender() {

    }

    public void init() {
        try{
            if(this.frames == null) {
                this.frames = decoder();
            }
            this.frameCtrl = getFrameControl();
            this.render = new J2SEView();
            this.view = new JFrame();
            int tmpWidth = getWidth();
            if(tmpWidth <= 0) {
                tmpWidth = 512;
            }
            int tmpHeight = getHight();
            if(tmpHeight <= 0) {
                tmpHeight = 512;
            }

            if(this.width <= 0 || height <= 0) {
                render.setMaximumSize(new Dimension(tmpWidth, tmpHeight));
                render.setPreferredSize(new Dimension(tmpWidth, tmpHeight));
                view.setPreferredSize(new Dimension(tmpWidth, tmpHeight));
                view.setMaximumSize(new Dimension(tmpWidth, tmpHeight));
            } else {
                view.setPreferredSize(new Dimension(width,height));
                view.setMaximumSize(new Dimension(width,height ));
                render.setMaximumSize(new Dimension(width, height));
                render.setPreferredSize(new Dimension(width,height));
            }
            view.setContentPane(render);
            view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            view.pack();
            view.setVisible(false);
            view.setResizable(false);
        } catch (ApngException e) {
            ApngUtility.getLog().log(ApngLog.WARNING, "ApngRender: Could not init", e);
        } catch (IOException e) {
            ApngUtility.getLog().log(ApngLog.WARNING, "ApngRender: Could not read image stream", e);
        }
    }


    @Override
    public void play() {
        init();
        int sequence = 0;
        if(isSkipFirstFrame()) {
            sequence = 1;
        }
        for(int i = sequence;i < frameCtrl.size();i++) {
            render.addXOffset(frameCtrl.get(i).getXOffset());
            render.addYOffset(frameCtrl.get(i).getYOffset());
            render.addDelay(frameCtrl.get(i).getDelay());
            render.addFrame(new ByteArrayInputStream(((ByteArrayOutputStream)frames.get(i)).toByteArray()));
        }
        render.start();
        view.setVisible(true);
        debug();
    }

    public void stop() {
        render.stop();
        view.setVisible(false);
        view.dispose();

    }

    public void getAllFrame() {
        try {
            ID id = new ID();
            if(this.frames == null) {
                this.frames = decoder();
            }
            for(OutputStream byteArray : frames) {
                FileOutputStream file = new FileOutputStream(new File(Main.class.getResource("").getPath() + "IMG" + id.getID() + ".png"));
                file.write(((ByteArrayOutputStream)byteArray).toByteArray());
                byteArray.close();
                file.close();
            }
            debug();
        } catch (ApngException e) {
            ApngUtility.getLog().log(ApngLog.WARNING, "ApngRender: Could not read image for stream",e);
        } catch (IOException e) {
            ApngUtility.getLog().log(ApngLog.WARNING,"ApngRender: Could not read stream", e);
        }
    }

    public void getFrame(int id) {
        try {
            this.frames = decoder();
            if(id < 0) {
                id = 0;
            }
            ByteArrayOutputStream byteSource = (ByteArrayOutputStream) frames.get(id);
            FileOutputStream file = new FileOutputStream(new File(Main.class.getResource("").getPath() + "IMG" + id + ".png"));
            file.write(byteSource.toByteArray());
            byteSource.close();
            file.close();
            debug();
        } catch (ApngException e) {
            ApngUtility.getLog().log(ApngLog.WARNING, "ApngRender: Could not read image for stream",e);
        } catch (IOException e) {
            ApngUtility.getLog().log(ApngLog.WARNING,"ApngRender: Could not read stream", e);
        }
    }

    public void debug() {
        System.out.println("-----" + getName() + "-----");
        System.out.println("Hight: " + getHight() + ",Width: " + getWidth());
        System.out.println(getAnimateControl().toString());
        System.out.println("SkipFirstFrame: " + isSkipFirstFrame());
        System.out.println("FrameControlSize: " + getFrameControl().size() + ",FristFrameControl: " +getFrameControl().get(0).toString());
        System.out.println("-----End-----");
    }
}
