import java.util.Set;
import java.util.ArrayList;
import java.util.Random;


public class TheTraveler implements Jogo{
	
	public BobAnt ant;
	public Random gerador = new Random();
	public int record = 0;
	public ScoreNumber scorenumber;
	
	public int game_state = 0; //[0->Start Screen] [1->Get Ready] [2->Game] [3->Game Over]
	
	public double scenario_offset = 0;
	public double ground_offset = 0;
	public ArrayList<Tree> trees = new ArrayList<Tree>();
	public Timer treeTimer;
	public Hitbox groundbox;
	
	public Timer auxtimer;

	
	private Acao addEnemies(){
		return new Acao(){
			public void executa(){
				trees.add(new Tree(getWidth(),gerador.nextInt(getHeight()-112- Tree.HOLESIZE)));
			}
		};
	}
	
	private Acao proxCena(){
		return new Acao(){
			public void executa(){
				game_state += 1;
				game_state = game_state%4;
			}
		};
	}
	
	
	
	public TheTraveler(){

		ant = new BobAnt(50,getHeight()/4); //position
		treeTimer = new Timer(2,true,addEnemies());
		scorenumber = new ScoreNumber(0);
		groundbox = new Hitbox(0, getHeight()-112, getWidth(), getHeight());
		
		
	}

	public String getTitle(){
		return "The Travaler";
	}
	public String getAuthor(){
		return "Filipe/Ronan/Shan";
	}
	public int getWidth(){
		return 384;
	}
	public int getHeight(){
		return 512;
	}
	
	public void gameOver(){
		trees = new ArrayList<Tree>();
		ant = new BobAnt(50,getHeight()/4);
		proxCena().executa();
	}
	
	public void tique(Set<String> keys, double dt){

		scenario_offset += dt*25;
		scenario_offset = scenario_offset % 288;
		ground_offset += dt*100;
		ground_offset = ground_offset%308;
		
		switch(game_state){
		case 0: //Main Screen
			break;
		case 1: //Get Ready
			auxtimer.tique(dt);
			//ant.updateSprite(dt);
			break;
		case 2: //Game Screen
			treeTimer.tique(dt);
			ant.update(dt);

			if(groundbox.intersecao(ant.box)!=0){
				gameOver();
				return;
			}
			if(ant.y<-5){
				gameOver();
				return;
			}
			for(Tree tree : trees){
				tree.tique(dt);
				if(tree.boxUp.intersecao(ant.box)!=0 || tree.boxDown.intersecao(ant.box)!=0){
					if(scorenumber.getScore()>ScoreNumber.record){
						ScoreNumber.record = scorenumber.getScore();
					}
					gameOver();
					return;
				}
				if(!tree.counted && tree.x < ant.x){
					tree.counted = true;
					scorenumber.modifyScore(1);
				}
			}
			if(trees.size() > 0 && trees.get(0).x < -70){
				trees.remove(0);
			}
			
			break;
		case 3: //Game Over Screen
			break;
		}
	}
	public void tecla(String c){
		switch(game_state){
		case 0:
			if(c.equals(" ")){
				auxtimer = new Timer(1.6, false, proxCena());
				proxCena().executa();
			}
			break;
		case 1:
			break;
		case 2:
			if(c.equals(" ")){
				ant.flap();
			}
			break;
		case 3:
			if(c.equals(" ")){
				scorenumber.setScore(0);
				proxCena().executa();
			}
			break;
		}
	}

	public void desenhar(Scene t){
		//Draw background no matter what
		t.image("art.png", 0, 0, 288, 512, 0,(int) -scenario_offset, 0);
		t.image("art.png", 0, 0, 288, 512, 0, (int) (288 - scenario_offset), 0);
		t.image("art.png", 0, 0, 288, 512, 0, (int) ((288*2) - scenario_offset), 0);
		
		for(Tree tree : trees){
			tree.drawItself(t);
		}
		
		//draw ground
		t.image("art.png", 292, 0, 308, 112, 0, -ground_offset, getHeight()-112);
		t.image("art.png", 292, 0, 308, 112, 0, 308 -ground_offset, getHeight()-112);
		t.image("art.png", 292, 0, 308, 112, 0, (308*2) - ground_offset, getHeight()-112);
		
		switch(game_state){
			//mudar aqui a tela inicial do jogo
		case 0:
			//GAME TITLE
			t.image("art.png", 292, 310, 192, 85, 0, 90, 60);

			//AIRPLANE
			t.image("art.png", 328, 235, 90, 80, 0, getWidth()/2 - 70/2, 150);


			t.texto("            Press Space", 60, 235, 25, Colour.rgb(38,104,211));
			break;
		case 1:
			ant.drawItself(t);
			t.image("art.png",292,442,174,44, 0, getWidth()/2 - 174/2, getHeight()/3); //xa=292 larg 174 alt 44
			scorenumber.drawScore(t, 5, 5);
			break;
		case 2:
			scorenumber.drawScore(t, 5, 5);
			ant.drawItself(t);
			break;
		case 3:
			t.image("art.png", 292, 398, 188, 38, 0, getWidth()/2 - 188/2, 100);
			t.image("art.png", 292, 116, 226, 116, 0, getWidth()/2 - 226/2, getHeight()/2 - 116/2);
			scorenumber.drawScore(t, getWidth()/2 + 50, getHeight()/2-25);
			scorenumber.drawRecord(t, getWidth()/2 + 55, getHeight()/2 + 16);
			break;
		}		
	}
	public static void main(String[] args) {
        roda();
    }
    
    private static void roda() {
    	new Motor(new TheTraveler());
    }
	
}
