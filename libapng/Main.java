import net.ngcell.apng.Apng;
import net.ngcell.apng.ApngException;
import net.ngcell.apng.ApngImpl;
import net.ngcell.apng.ApngRender;
import net.ngcell.apng.j2se.J2SEImage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Main {

    public static void main(String[] args){
        BufferedImage paramImage = new BufferedImage(320,240,BufferedImage.TYPE_INT_ARGB);
        Graphics2D paramImageG2D = (Graphics2D) paramImage.getGraphics();
        paramImageG2D.setColor(Color.RED);
        paramImageG2D.fillRect(0,0,320,240);
        paramImageG2D.setColor(Color.BLACK);
        paramImageG2D.setFont(new Font("Consolas",Font.PLAIN,20));
        paramImageG2D.drawString("This",80,100);

        BufferedImage paramBuff = new BufferedImage(320,240,BufferedImage.TYPE_INT_ARGB);
        Graphics2D paramG2D = (Graphics2D) paramBuff.getGraphics();
        paramG2D.setColor(Color.GREEN);
        paramG2D.fillRect(0,0,320,240);
        paramG2D.setColor(Color.BLACK);
        paramG2D.setFont(new Font("Consolas",Font.PLAIN,20));
        paramG2D.drawString("is",100,100);

        BufferedImage paramBuff1 = new BufferedImage(320,240,BufferedImage.TYPE_INT_ARGB);
        Graphics2D paramG2D1 = (Graphics2D) paramBuff1.getGraphics();
        paramG2D1.setColor(Color.BLUE);
        paramG2D1.fillRect(0,0,320,240);
        paramG2D1.setColor(Color.BLACK);
        paramG2D1.setFont(new Font("Consolas",Font.PLAIN,20));
        paramG2D1.drawString("example",120,100);

        Apng apng = new ApngImpl();
        
        ApngRender render = new MainRender();
        try{
            apng.addFrame(new J2SEImage(paramImage),500);
            apng.addFrame(new J2SEImage(paramBuff),500);
            apng.addFrame(new J2SEImage(paramBuff1),500);
            apng.create(new File(Main.class.getResource("").getPath() + "example.png"));

            render.setAnimate(new File(Main.class.getResource("").getPath() + "example.png"));
            render.play();
        } catch (ApngException e){
            e.printStackTrace();
        }
    }
}
