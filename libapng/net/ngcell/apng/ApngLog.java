package net.ngcell.apng;

public interface ApngLog {
    int ALL = 0;
    int FINE = 3;
    int FINER = 2;
    int FINEST = 1;
    int INFO = 5;
    int SEVERE = 7;
    int WARNING = 6;

    void log(int level,String message,Throwable e);

    void log(int level,String message,Object parames);

    void fine(String message);

    void warning(String message);

    void info(String message);
}
