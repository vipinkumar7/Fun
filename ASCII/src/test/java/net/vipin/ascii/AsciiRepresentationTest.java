package net.vipin.ascii;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import net.vipin.ascii.AsiiRepresentation;
import javax.imageio.ImageIO;

import org.junit.Test;

public class AsciiRepresentationTest
{

    @Test
    public void testAsciiArt(){
        /*do not change this path this thakes file from resources folder*/
        String filepath = "/files/45.jpg";
        try {
            InputStream inputStream = getClass().getResourceAsStream( filepath );
            assertNotNull( inputStream );
            
            BufferedImage original = ImageIO.read( inputStream );;
         
            /* please set your output path here*/
            AsiiRepresentation.setLocation( "F:\\face.txt"  );
            
            
            AsiiRepresentation.RGBExtract( original );
            
            
           
    }catch ( IOException e ) {
        
        
    }
    
}
}
