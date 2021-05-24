import net.ngcell.apng.*;

import java.io.*;
import java.util.List;

public final class MainRender extends ApngRenderImpl {

    @Override
    public void play() {
        ID id = new ID();
        try{

            /*Output PNG byte stream*/
            List<ByteArrayOutputStream> frames = decoder();
            for(ByteArrayOutputStream byteArray : frames) {
                FileOutputStream file = new FileOutputStream(new File(Main.class.getResource("").getPath() + "IMG" + id.getID() + ".png"));
                file.write(byteArray.toByteArray());
                byteArray.close();
                file.close();
            }
            System.out.println("-----" + getName() + "-----");
            System.out.println("Hight: " + getHight() + ",Width: " + getWidth());
            System.out.println(getAnimateControl().toString());
            System.out.println(getFrameControl().get(0).toString() + " isSkipFirstFrame: " + isSkipFirstFrame());
            System.out.println("-----End-----");
        } catch (ApngException e) {
            ApngUtilities.getLog().log(ApngLog.WARNING, "could not play", e);
        } catch (IOException e) {
            ApngUtilities.getLog().log(ApngLog.WARNING, "could not write image file", e);
        }
    }

    public void pause() {

    }
}
