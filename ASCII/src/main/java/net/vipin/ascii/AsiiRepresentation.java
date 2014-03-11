package net.vipin.ascii;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * 
 * @author Vipin Kumar
 * @created Mar 30, 2013
 * 
 * This class is responsible for generating ascii repesentation of a image 
 *
 */
public class AsiiRepresentation
{

    


    
 public static String location=null;





    public  static void RGBExtract( BufferedImage original )
    {

        int alpha, red, green, blue;
        int newPixelValue;

       
        int[] avgLUT = new int[766];
        for ( int i = 0; i < avgLUT.length; i++ )
            avgLUT[i] = (int) ( i / 3 );

        int[][] storePixles = new int[original.getWidth()][original.getHeight()];

        for ( int i = 0; i < original.getWidth(); i++ ) {
            for ( int j = 0; j < original.getHeight(); j++ ) {


                // Get pixels by R, G, B
                alpha = new Color( original.getRGB( i, j ) ).getAlpha();
                red = new Color( original.getRGB( i, j ) ).getRed();
                green = new Color( original.getRGB( i, j ) ).getGreen();
                blue = new Color( original.getRGB( i, j ) ).getBlue();

                newPixelValue = red + green + blue;
                storePixles[i][j] = newPixelValue;
                newPixelValue = avgLUT[newPixelValue];
              
                newPixelValue = changeToRGB( alpha, newPixelValue, newPixelValue, newPixelValue );

          

            }
        }

        write( storePixles, original.getWidth(), original.getHeight() );
       

    }


    /*converting the R G B alpha into 8 bit format*/
    private static int changeToRGB( int alpha, int red, int green, int blue )
    {

        int newPixel = 0;
        newPixel += alpha;
        newPixel = newPixel << 8;
        newPixel += red;
        newPixel = newPixel << 8;
        newPixel += green;
        newPixel = newPixel << 8;
        newPixel += blue;

        return newPixel;

    }


    /*write the ascii text to text file*/
    public static void write( int[][] wr, int a, int b )
    {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter( new File( getLocation()) );
        } catch ( FileNotFoundException e ) {
           
        }
        for ( int i = 0; i < a; i++ ) {
            for ( int j = 0; j < b; j++ ) {
                pw.print( getchar(wr[i][j]));
            }
            pw.println();
        }
        pw.flush();
        pw.close();
    }
    
    /** This is the character representation of integers according to their weight. 
   
    *  Characters are placed according to the intensity you can place them if you find better intensity difference between characters 
    */
    private static String getchar(int i){
        String ch=null;
        if(i<100){
            ch=".";
        }
        else if(i>=100&&i<200){
            ch="i";
        }
        else if(i>200&&i<=300){
            ch=":";
        }
        else if(i>300&&i<=400){
            ch="L";
        }
        
        else if(i>400&&i<=500){
           ch="P"; 
        }
        else if(i>500&&i<=550){
            ch="G"; 
         }
        
        else if(i>550&&i<=600){
            ch="W"; 
         }
        else if(i>600&&i<=650){
            ch="$"; 
         }
        else if(i>650&&i<=700){
            ch="&"; 
         }
        else if(i>700){
            ch="#"; 
         }
        
        return ch;
    }
    
    public static String getLocation()
{
    return location;
}


public static void setLocation( String location )
{
    AsiiRepresentation.location = location;
}
}
