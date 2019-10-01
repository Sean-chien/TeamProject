

public class BobAnt {

    public double x, y, vy;
    public static double gravity = 600; //valor da gravidade
    public static double FLY = -200;  // velocidade quando aperta a barra de espaco
    public Hitbox box;


    public BobAnt(double x, double y) {
        this.x = x;
        this.y = y;
        this.vy = 0;
        this.box = new Hitbox(x, y, x + 34, y + 24); // 34 e a altura e 24 e a largura

    }

    public void update(double dt) {
        vy += gravity * dt;
        y += vy * dt;
        this.box.mover(0, vy * dt);
    }


    public void flap() {
        this.vy = FLY;
    }

    public void drawItself(Scene t) {
        t.image("art.png", 435, 240, 53, 33, Math.atan(vy / 600), x, y);

        //------------------------------------------------------------------------------------------------------
        //t.imagem:
        // arquivo = local da imagem,                                'xa' = onde a img comeca em x na figura ,
        // 'ya' = onde a img comeca em Y na figura                  'larg' = largura da imagem na fig ,
        // 'alt'= altura da figura na imagem                        'dir' = rotacao da figura
        //'x' = posicao na tela do JOGO em X						'y' = posicao na tela do JOGO  em Y
        //------------------------------------------------------------------------------------------------------

    }



}
