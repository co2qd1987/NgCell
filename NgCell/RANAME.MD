libapng used document:
used interface:
    ApngImage {
        /*Image Type*/
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
        /*Get Image Width*/
        int getWidth();
        /*Get Image Height*/
        int getHeight();
        /*Use width、 height and source image created blank frame*/
        ApngImage createBlankImage(int width, int height, ApngImage image);
        /*Import png hex data*/
        void write(byte[] source) throws ApngException, IOException; 
    }
    ApngLog {
        /*Log level*/
        int ALL = 0;
        int FINE = 3;
        int FINER = 2;
        int FINEST = 1;
        int INFO = 5;
        int SEVERE = 7;
        int WARNING = 6;
        /*Print log、warning、info*/
        void log(int level,String message,Throwable e);
        void warning(String message);
        void info(String message);
    }
used abstract class：
    ApngRenderImpl {
        /*Player control*/
        abstract void play();
        abstract void pause();
        abstract void stop();
        /*Get frame to png by ID*/
        abstract void getFrame(int id);
    }
used class and method:
    ApngImpl {
        /*Reset frame array*/
        void reset();
        /*Config play count*/
        void setPlayCount(int playCount);
        /*Config skip first frame on playing*/
        void setSkipFirstFrame(boolean skipFirstFrame);
        /*Import png and image to frame array*/
        void addFrame(File imageFile, int displayMillis);
        void addFrame(File imageFile, int displayMillis, DisposeOp disposeOp, BlendOp blendOp);
        void addFrame(File imageFile, int displayMillis, DisposeOp disposeOp, BlendOp blendOp, int x_offset, int y_offset);
        void addFrame(InputStream imageStream, int displayMillis); 
        void addFrame(InputStream imageStream, int displayMillis, DisposeOp disposeOp, BlendOp blendOp);   
        void addFrame(InputStream imageStream, int displayMillis, DisposeOp disposeOp, BlendOp blendOp, int x_offset, int y_offset);
        void addFrame(ApngImage image, int displayMillis);
        void addFrame(ApngImage image, int displayMillis, DisposeOp disposeOp, BlendOp blendOp);
        void addFrame(ApngImage image, int displayMillis, DisposeOp disposeOp, BlendOp blendOp, int x_offset, int y_offset);
        /*export png*/
        void create(File outputFile);
        void create(OutputStream outputStream);
    }
    ApngRenderImpl {
        /*Import apng*/
        void setAnimate(File imageFile);
        void setAnimate(InputStream imageStream);
        /*Output image array*/
        List<ByteArrayOutputStream> decoder();
        /*Reset image array*/
        void reset();
        /*Get render name*/
        String getName();
        /*Get height*/
        int getHight();
        /*Get width*/
        int getWidth();
        /*Get isSkipFirstFrame*/
        boolean isSkipFirstFrame();
        /*Get AnimationControl*/
        AnimationControl getAnimateControl();
        /*Get FrameControl*/
        List<FrameControl> getFrameControl();
    }
    ApngUtilities {
        /*Get default log printer*/
        static ApngLog getLog();
        static void setLog(ApngLog loger);
        /*Created default image object*/
        static ApngImage getImage();
        static void setImage(ApngImage image);
    }
    ID {
        /*Get ID*/
        int getID();
    }
    AnimationControl {
        int getTotalFrameSize();
        int getPlayCount();
    }
    FrameControl {
        int getID();
        int getXOffset();
        int getYOffset();
        int getToltalTime();
        int getDelay();
        DisposeOp getDisposeOp();
        BlendOp getBlendOp();
    }
    /*Apng option*/
    enum::BlendOp {
        SOURCE;
        OVER;
    }
    enum::DisposeOp {
        NONE;
        BACKGROUND;
        PREVIOUS
    }

        

