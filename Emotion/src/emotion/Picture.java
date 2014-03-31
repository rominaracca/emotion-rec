package emotion;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Romina Racca
 */
public class Picture extends JPanel{
    
    private BufferedImage originalPicture;
    private float xScaleFactor = 1;     //factor de escala en que se disminuye la imagen en X
    private float yScaleFactor = 1;     //factor de escala en que se disminuye la imagen en X
    
    public Picture(String pathToPicture) {
        originalPicture = toBufferedImage(createImage(pathToPicture).getImage());
        setSize(originalPicture.getWidth(), originalPicture.getHeight());  //Tamaño del panel de la imagen igual al tamaño de la imagen
    }
    
    
    /**
     *  Crea un ImageIcon a partir del path del archivo
     * @param path
     * @return ImageIcon si el path exite, sino retorna null
     */
    private ImageIcon createImage(String path){
        if(path != null){    
            return new ImageIcon(path);
        }else{
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    

    /**
     * Crea un BufferedImage a partir de una Image.
     * @param image
     * @return BufferedImage
     */
    private BufferedImage toBufferedImage(Image image){
        if(image instanceof BufferedImage){
            return (BufferedImage) image;
        }
 
        image = new ImageIcon(image).getImage();
        boolean hasAlpha = hasAlpha(image);
        BufferedImage bimage = null;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        
        try{
            int transparency = Transparency.OPAQUE;
            if(hasAlpha){
                transparency = Transparency.BITMASK;
            }
            GraphicsDevice gs = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gs.getDefaultConfiguration();
            bimage = gc.createCompatibleImage(image.getWidth(null), image.getHeight(null), transparency);
        }catch(HeadlessException e){ 
            // El sistema no tiene screen
            System.err.println("The system does not have a screen "+e.toString());
        }
 
        if(bimage == null){
            int type = BufferedImage.TYPE_INT_RGB;
            if(hasAlpha){
                type = BufferedImage.TYPE_INT_ARGB;
            }
            bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
        }
 
        Graphics g = bimage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
 
        return bimage;
    }

    /**
     * Devuelve true si la imagen tiene pixeles transparentes.
     * @param image a probar
     * @return true si la imagen tiene pixeles transparentes.
     */
    private boolean hasAlpha(Image image){
        if(image instanceof BufferedImage){
            BufferedImage bimage = (BufferedImage) image;
            return bimage.getColorModel().hasAlpha();
        }
 
        PixelGrabber pg = new PixelGrabber(image, 0, 0, 1, 1, false);
        try{
            pg.grabPixels();
        }catch(InterruptedException e){
            System.err.println("Interrupcion en Alpha "+e.toString());
        }
 
        ColorModel cm = pg.getColorModel();
        return cm.hasAlpha();
    }
    
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
       
        int newW = (int) (originalPicture.getWidth() * xScaleFactor);
        int newH = (int) (originalPicture.getHeight() * yScaleFactor);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.clearRect(0, 0, getWidth(), getHeight());
        g2.drawImage(originalPicture, 0, 0, newW, newH, null);

        if(newW>650 || newH>615){
            decreasePicture(); 
        }
        setSize(newW,newH);
    }

    /**
     * Disminuye el tamaño de la imagen origina en paintComponente en base a un determinado factor de escala
     * y luego repinta.
     */
    private void decreasePicture() {
        xScaleFactor-= 0.1;
        yScaleFactor-= 0.1;   
        repaint();
    }
 
    /**
     * 
     * @param file 
     */
   public void setImagenFromFile(File file){
       this.originalPicture = toBufferedImage(createImage(file.getPath()).getImage());
       this.repaint();
    }

}
