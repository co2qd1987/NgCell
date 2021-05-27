package net.ngcell.apng;

import java.io.IOException;

public interface ApngImage {
    int IMAGE_BYTE_BGR = 5;
    int IMAGE_BYTE_ABGR = 6;
    int IMAGE_BYTE_ABGR_PRE = 7;
    int IMAGE_BYTE_BINARY = 12;
    int IMAGE_BYTE_GREY = 10;
    int IMAGE_BYTE_INDEX = 13;
    int IMAGE_CUSTOM = 0;
    int IMAGE_INT_ARGB = 2;
    int IMAGE_INT_ARGB_PRE = 3;
    int IMAGE_INT_BGR = 4;
    int IMAGE_INT_RGB = 1;
    int IMAGE_US_555_RGB = 9;
    int IMAGE_US_565_RGB = 8;
    int IMAGE_US_GREY = 11;
    int IMAGE_US_4444_ARGB = 14;

    int getWidth();

    int getHeight();

    ApngImage getBlankImage(int width, int height, ApngImage image) throws ApngException;

    byte[] read() throws ApngException, IOException;

    void write(byte[] source) throws ApngException, IOException;

}
