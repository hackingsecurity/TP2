package object;
import logic.FileContentsVerifier;
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
		super();
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
		return "E" + ";" + this.posX+","+this.posY + ";" 
				+ this.live + ";" + game.stringSent(AlienShip.sentido) + "\n";   
	}

	@Override
	protected GameObject parse(String stringFromFile, Game game2, FileContentsVerifier verifier) {
		if(stringFromFile.split(";")[0].equalsIgnoreCase("E")) {
			int armour  =Integer.parseInt(stringFromFile.split(";")[2]);
			if(!verifier.verifyAlienShipString(stringFromFile, game,armour)) return null;

			String coordenadas = stringFromFile.split(";")[1]; // recoge las coordenadas
			
			return new ExplodeShip(game,Integer.parseInt(coordenadas.split(",")[0]),
					Integer.parseInt(coordenadas.split(",")[1]),armour);
		}
		return null;
	}
}
