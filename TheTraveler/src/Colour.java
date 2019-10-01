import java.util.HashMap;

/**
 * Cores em RGB
 */
public class Colour
{
    public int r;
    public int g;
    public int b;
    
    private static HashMap<Integer, Colour> cores = new HashMap<Integer, Colour>();
    
    /*
     * Cria uma cor dados os componentes entre 0 e 255
     */
    private Colour(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    /*
     * Cria uma cor dados os componentes entre 0 e 1
     */
    public static Colour rgb(double r, double g, double b) {
        return Colour.rgb((int)(r*255), (int)(g*255), (int)(b*255));
    }
    
    public static Colour rgb(int r, int g, int b) {
        int indice = (r << 16) | (g << 8) | b;
        if(!cores.containsKey(indice)) {
            cores.put(indice, new Colour(r, g, b));
        }
        return cores.get(indice);
    }
    
    public static Colour BRANCO = Colour.rgb(1.0, 1.0, 1.0);
    public static Colour AZUL = Colour.rgb(0.0, 0.0, 1.0);
    public static Colour VERMELHO = Colour.rgb(1.0, 0.0, 0.0);
    public static Colour VERDE = Colour.rgb(0.0, 1.0, 0.0);
}
