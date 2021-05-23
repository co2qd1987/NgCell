import net.ngcell.apng.ApngException;
import net.ngcell.apng.ID;
import net.ngcell.apng.ApngRenderImpl;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

public final class MainRender extends ApngRenderImpl {

    @Override
    public void play() {
        ID id = new ID();
        try{

            List<BufferedImage> frames = decoder();
            for(BufferedImage image : frames) {
                ImageIO.write(image,"PNG",new File(Main.class.getResource("").getPath() + "IMG" + id.getID() + ".png"));
            }
            System.out.println("-----" + getName() + "-----");
            System.out.println("Hight: " + getHight() + ",Width: " + getWidth());
            System.out.println(getAnimateControl().toString());
            System.out.println(getFrameControl().get(0).toString() + " isSkipFirstFrame: " + isSkipFirstFrame());
            System.out.println("-----End-----");
        } catch (ApngException e) {
            log.log(Level.WARNING, "could not play", e);
        } catch (IOException e) {
            log.log(Level.WARNING, "could not write image file", e);
        }
    }

    public void pause() {

    }
}
