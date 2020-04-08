package object;
import logic.Game;



/**
 * Creo una nave Explosiva
 * 	-Un RegularAlien se convierte en explosiva
 *
 */
public class ExplodeShip extends AlienShip {

	//-----------------CONTRUCTOR---------------
	
	public  ExplodeShip(Game game,int posX,int posY, int vida){
		super(game, posX,  posY, vida, 5);
	}
	
	//--------------METHODS IMPLEMENTS IAttack-----------
	
	public ExplodeShip() {
		// TODO Auto-generated constructor stub
	}

	public boolean receiveMissileAttack(int damage) {
		boolean hit = false;
		if(this.isAlive()) {
			this.receiveDamageFromOtherObject(damage);
			hit = true;
		}
			return hit;
	};
		
	public boolean receiveSuperMissileAttack(int damage) {
		boolean hit= false;
		if(this.isAlive()) {
			this.receiveDamageFromOtherObject(damage);
			hit = true;
		}
		return hit;
		}
	
	//--------------ABSTRACT METHODS------------
	
	@Override
	public void onDelete() {
		if(!this.isAlive()) {
			game.receivePoints(5);
			game.explode(this.posX,this.posY);
			AlienShip.contadorAlien--;
		}
	}
	
		//--------------OBJECT FORMAT OUTPUT-----------
	
	public String toString(){
		 return "E[" + this.getLive()+ "]" ;
	}
	
	public String stringifed() {
		return "Explosive: "+"E" + ";" + this.posX+","+this.posY + ";" 
				+ this.live + ";" + game.stringSent(AlienShip.sentido) + "\n";   
	}
}
