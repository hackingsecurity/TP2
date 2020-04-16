package object;


import logic.FileContentsVerifier;
import logic.Game;

public class Bomb extends Weapon{
	
	//-----------------VARIABLES----------------
	private int ownerRef;
	private DestroyerAlien destroyer;
	
	
	//-----------------CONTRUCTOR---------------
	
	public Bomb(Game game, int posX, int posY, DestroyerAlien bombOwner) {
		super(game, posX, posY, 1,1,"B");
		
		this.destroyer =bombOwner;
	}
	
	//--------------METHODS IMPLEMENTS IAttack-----------
	public Bomb(Game game, int posX, int posY, DestroyerAlien bombOwner, int label) {
		super(game, posX, posY, 1,1,"B");
		this.destroyer =bombOwner;
		this.label = label;
	}
	
	public Bomb(Game game, int posX, int posY) {
		super(game, posX, posY, 1,1,"B");
	}
	public Bomb() {
		super();
	}



	public boolean performAttack(GameObject other) {

		boolean performAttack = false;
		if(this.isAlive()) {
			if(other.isOnPosition(this.posX, this.posY)) {
				if(other.receiveBombAttack(damage)) {
					this.live = 0;
					performAttack = true;
				}
			}
		}
		return performAttack;
	}
	
	public boolean  receiveMissileAttack(int damage) {
		boolean hit = false;
		
		if(this.isAlive()) {	
			this.receiveDamageFromOtherObject(damage);
			hit = true;
		}	
		return hit;	
	}
	
	public boolean receiveSuperMissileAttack(int damage) {
		boolean hit = false;
		
		if(this.isAlive()) {	
			this.receiveDamageFromOtherObject(damage);
			this.destroyer.setBomb(false);
			hit = true;
		}	
		return hit;	
	}
	
	
	//--------------ABSTRACT METHODS------------
	
	@Override
	public void computerAction() {}
	
	public void onDelete() {
		if(!this.isAlive()) {
			if(!(this.destroyer == null)) {
				this.destroyer.setBomb(false);
			}
		}
	}
	
	public void move() {
		posX += 1;
		if(this.isOut()) {
			this.live = 0;
		}
	}
	
	
		//--------------OBJECT FORMAT OUTPUT-----------
	
	@Override
	public String toString(){
		
		 return ".";
	}
	
	@Override
	public String stringifed() {
		return  super.stringifed() + (destroyer.isAlive() ? 
				generateSerialRef(): "");  //añadir el destroyer
	}

	
	

	@Override
	protected GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) {
		
		//game.getBombOwner(ownerRef)
		String[] own = stringFromFile.split(labelRefSeparator);
		
		String s = stringFromFile.split(labelRefSeparator)[0];
		if(stringFromFile.split(";")[0].equalsIgnoreCase("B")) {
			if(!verifier.verifyWeaponString(s, game)) return null;
				if(own.length == 2) {
					if( ! verifier.verifyRefString(stringFromFile)) return null;
				}
			String coordenadas = stringFromFile.split(";")[1]; // recoge las coordenadas
			if(own.length == 1)  return new Bomb(game,Integer.parseInt(coordenadas.split(",")[0]),
					Integer.parseInt(coordenadas.split(",")[1]));
			 coordenadas = s.split(";")[1];
			return new Bomb(game, Integer.parseInt(coordenadas.split(",")[0]),
					Integer.parseInt(coordenadas.split(",")[1]), game.getBombOwner(Integer.parseInt(own[1])));
		}
		return null;
	}
	public String generateSerialRef() {
		return labelRefSeparator + this.destroyer.getLabel();
	}
	
}
