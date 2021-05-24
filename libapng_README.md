interface that needs to be overridden:
	interface ApngImage {         //J2SEImage as ApngImage
		int getWidth();
   	int getHeight();
    ApngImage createBlankImage(int width, int height, ApngImage image);
    byte[] read() throws IOException;	//Output png bytearray
    void write(byte[] source) throws ApngException, IOException;		//Input png bytearray
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
		List<ByteArrayOutputStream> decoder();	//Output png bytestream
		void reset();
		String getName();  //toString
		InputStream getInputStream();	//Apng inputstream
		File getFile();		//Apng file
		int getHight();
		int getWidth();
		AnimationControl getAnimateControl();
		boolean isSkipFirstFrame();
		List<FrameControl> getFrameControl();
	}

	final class ApngUtilities {
		static ApngLog getLog();
		static void setLog(ApngLog loger);
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