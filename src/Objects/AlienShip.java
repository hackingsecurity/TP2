//PAQUETE QUE LO CONTIENE
package Objects;

import Logic.Game;

public  abstract class AlienShip extends EnemyShip {
	private static int contadorAlien = 0;
	private static int sentido;
	private static boolean bajar;
	private static boolean haveLanded;
	
	public AlienShip(Game game, int posX, int posY, int live) {
		super(game, posX, posY, live);
		contadorAlien += 1;
		sentido = -1;
		bajar = false;
		haveLanded = false;
	}
	
	
	public void computerAction() {
		if((game.getCurrentCycle()%game.getLevel().getNumCyclesToMoveOneCell()) == 0 && game.getCurrentCycle()!=0) {
			if((posY == 0 && sentido == -1 && bajar == false)||(posY == 8 && sentido == 1 && bajar == false)) {
				setBajar(true);
				setSentido();
			}
			if(bajar == true && posX == 6) {
				setHaveLanded(true);
			}
		}
		
	}
	
	//otra funcion 
	
	
	//desplazamiento lateral 
	public void move(){
		if((game.getCurrentCycle()%game.getLevel().getNumCyclesToMoveOneCell()) == 0 && game.getCurrentCycle()!=0){
			if(bajar){
				this.posX += 1;
			}
			else {
				this.posY += sentido;
			}
			
	
		}
			//cuando me voy a mover :
		// cuando ciclo %  Level
	}
	public boolean receiveMissileAttack(int damage) {
		boolean hit = false;
		if(this.isAlive()) {
			this.live -= damage;
			hit = true;
		}
			return hit;
		};
	public boolean receiveShockWaveAttack(int damage) {
		boolean hit = false;
		if(this.isAlive()) {
			this.live -= damage;
			hit = true;
			}
		return hit;
	};

	public static void setSentido() {
		sentido *= -1;
	}
	public static int getSentido() {
		return sentido;
	}
	public static void setBajar(boolean down) {
		bajar = down;
	}
	public static boolean getBajar() {
		return bajar;
	}
	public static int getContadorAlien() {
		return contadorAlien;
	}
	public static void setContador() {
		contadorAlien--;
	}
	public static boolean AllDeads() {
		boolean yes= false;
		if(contadorAlien == 0) {
			 yes = true;
		}
		return yes;
	}
	public static void setHaveLanded(boolean yes) {
		haveLanded = yes;
	}
	public static boolean HaveLanded() {
		return haveLanded;
	}
	
}
