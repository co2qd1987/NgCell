package net.ngcell.apng;

import java.io.IOException;

public interface ApngImage {

    int getWidth();

    int getHeight();

    ApngImage createBlankImage(int width, int height, ApngImage image);

    byte[] read() throws IOException;

    void write(byte[] source) throws ApngException, IOException;

}
