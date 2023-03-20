from org.jasper.glib.stdlib import stdlib;
import org.jasper.lang.String;

#compiler(10)

#define HELLO_WORLD "Hello World!"

public class self {
  
  public static void main(String[] args) {
    stdlib.printf(HELLO_WORLD);
    return;
  }
}