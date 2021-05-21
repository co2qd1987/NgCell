import net.ngcell.apng.ID;
import net.ngcell.apng.ApngRenderImpl;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
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
        } catch (Exception e) {
            log.log(Level.WARNING, "could not play", e);
        }
    }

    public void pause() {

    }
}
