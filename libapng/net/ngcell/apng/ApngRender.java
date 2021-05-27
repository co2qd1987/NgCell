package net.ngcell.apng;

import java.io.File;
import java.io.InputStream;

public interface ApngRender {

    void setAnimate(File imageFile);

    void setAnimate(InputStream imageStream);

    void reset();

    void play();

    void stop();

    void getAllFrame();

    void getFrame(int id);

}
