public class Tree {
	
	public double x,y;
	
	public static int xspeed = -150; //-100
	public static int HOLESIZE = 94; //50 pixels
	public boolean counted = false;
	
	public Hitbox boxUp;
	public Hitbox boxDown;


	public Tree(double x, double y){
		this.x = x;
		this.y = y;
		// 'y1' = posicao do hitbox em Y (quanto mais Negativo, mais para cima a hitbox se encontra)
		this.boxUp = new Hitbox(x, y - 490 ,x+52 ,y +10); // y1 = y - 20
		this.boxDown = new Hitbox(x, y+HOLESIZE, x+52, y+HOLESIZE+442);
	}
	
	public void tique(double dt){
		x += xspeed*dt;
		boxUp.mover(xspeed*dt, 0);
		boxDown.mover(xspeed*dt, 0);
	}
	public void drawItself(Scene t){								  //242
		//------------------------------------------------------------------------------------------------------
		//t.imagem:
		// arquivo = local da imagem,                                'xa' = onde a img comeca em x na figura ,
		// 'ya' = onde a img comeca em Y na figura                  'larg' = largura da imagem na fig ,
		// 'alt'= altura da figura na imagem                        'dir' = rotacao da figura
		//'x' = posicao na tela do JOGO em X						'y' = posicao na tela do JOGO  em Y
		//------------------------------------------------------------------------------------------------------
		t.image("art.png", 604, 0, 60, 295, 0, x, y - 270); //birds

		t.image("art.png", 665, 370, 100, 320, 0, x, y + HOLESIZE); //arvore
		


	}
}
