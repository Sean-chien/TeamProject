import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.HashMap;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.geom.AffineTransform;

/**
 * Scene para desenho.
 * 
 */
public class Scene
{
    Graphics2D g;
    
    public static HashMap<String, BufferedImage> sprites = new HashMap<>();
    
    public Scene(Graphics2D g) {
        this.g = g;
        g.setColor(Color.white);
    }

    public void texto(String texto, int x, int y, int tamanho, Colour colour) {

        g.setColor(new Color(colour.r, colour.g, colour.b));
        g.setFont(new Font("Calibri", Font.BOLD, tamanho));
        g.drawString(texto, x, y);

    }
    
    public void texto(String texto, double x, double y, int tamanho, Colour colour) {
        texto(texto, (int)Math.round(x), (int)Math.round(y), tamanho, colour);
    }

    
    public void image(String file, int xInArt, int yInArt, int imageWidth, int imageHeight, double dir, double xInGameWindow, double yInGameWindow) {
        if(!sprites.containsKey(file)) {
            try {
                sprites.put(file, ImageIO.read(new File(file)));
            } catch(java.io.IOException ioex) {
                throw new RuntimeException(ioex);
            }
        }
        AffineTransform trans = g.getTransform();
        g.rotate(dir, xInGameWindow + imageWidth/2, yInGameWindow + imageHeight/2);
        g.drawImage(sprites.get(file), (int)Math.round(xInGameWindow), (int)Math.round(yInGameWindow), (int)Math.round(xInGameWindow) + imageWidth, (int)Math.round(yInGameWindow) + imageHeight, xInArt, yInArt, xInArt + imageWidth, yInArt + imageHeight, null);
        g.setTransform(trans);
    }
}
