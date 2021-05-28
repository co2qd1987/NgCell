interface that needs to be overridden:
    interface ApngImage {         //J2SEImage as ApngImage
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
      ApngImage createBlankImage(int width, int height, ApngImage image);
      byte[] read() throws IOException;    //Output png bytearray
      void write(byte[] source) throws ApngException, IOException;        //Input png bytearray
    }

    interface ApngLog {
      int ALL = 0;    //Log level
      int FINE = 3;
      int FINER = 2;
      int FINEST = 1;
      int INFO = 5;
      int SEVERE = 7;
      int WARNING = 6;

      void log(int level,String message,Throwable e);
      void log(int level,String message,Object parame);
      void fine(String message);
      void warning(String message);
      void info(String message);
    }

    abstract class ApngRenderImpl {
        abstract void play();
        abstract void pause();
        abstract void stop();
        abstract void getAllFrame();
        abstract void getFrame(int id);
    }


exposed methods:
    final class ApngImpl {
        void reset();
        void setPlayCount(int playCount);
        void setSkipFirstFrame(boolean skipFirstFrame);
        void addFrame(File imageFile, int displayMillis);     //Input png file
        void addFrame(File imageFile, int displayMillis, DisposeOp disposeOp, BlendOp blendOp);   //Input png file
        void addFrame(File imageFile, int displayMillis, DisposeOp disposeOp, BlendOp blendOp, int x_offset, int y_offset);   //Input png file
        void addFrame(InputStream imageStream, int displayMillis);    //Input png stream
        void addFrame(InputStream imageStream, int displayMillis, DisposeOp disposeOp, BlendOp blendOp);    //Input png stream
        void addFrame(InputStream imageStream, int displayMillis, DisposeOp disposeOp, BlendOp blendOp, int x_offset, int y_offset);    //Input png stream
        void addFrame(ApngImage image, int displayMillis);    //Input image
        void addFrame(ApngImage image, int displayMillis, DisposeOp disposeOp, BlendOp blendOp);  //Input image
        void addFrame(ApngImage image, int displayMillis, DisposeOp disposeOp, BlendOp blendOp, int x_offset, int y_offset);    //Input image
        void create(File outputFile);  //Output apng file
        void create(OutputStream outputStream);   //Output apng bytestream
    }

    abstract class ApngRenderImpl {
        void setAnimate(File imageFile);        //Input apng file
        void setAnimate(InputStream imageStream);   //Input apng bytestream
        List<ByteArrayOutputStream> decoder();    //Output png bytestream
        void reset();
        String getName();  //toString
        InputStream getInputStream();    //Apng inputstream
        File getFile();        //Apng file
        int getHight();
        int getWidth();
        AnimationControl getAnimateControl();
        boolean isSkipFirstFrame();
        List<FrameControl> getFrameControl();
    }

    final class ApngUtilities {
        static ApngLog getLog();    //Default: J2SELog
        static void setLog(ApngLog loger);
        static ApngImage getImage();  //Default: J2SEImage
        static void setImage(ApngImage image);
    }

    enum BlendOp {
    SOURCE,OVER
    }

    enum DisposeOp {
    NONE,BACKGROUND,PREVIOUS
    }

    final class ID {
        int getID();
    }

    final class AnimationControl {
        byte[] getData();
        int getTotalFrameSize();
        int getPlayCount();

    }

    final class FrameControl {
        byte[] getData();
        int getID();
        int getXOffset();
        int getYOffset();
        int getToltalTime();
        int getDelay();
        DisposeOp getDisposeOp();
        BlendOp getBlendOp();
    }