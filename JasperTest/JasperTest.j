from org.jasper.lang.System import System;
import org.jasper.lang.String;

#compiler(10.0)

#define HELLO_WORLD ", Hello World!"

public class self{

  public static void main(String[] args) {
    var adr char w = "Tony"
    if(w.length != 0 && w.address != 0) {
      System.out.printf(%S,w,HELLO_WORLD);
    }
    return;
  }
}