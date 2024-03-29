//PAQUETE QUE LO CONTIENE
package object;
import interfaces.IExecuteRandomActions;
import logic.FileContentsVerifier;
import logic.Game;


/**
 * Cambio un RegularShip a un ExplodeShip
 */
public  class RegularAlien extends AlienShip{

	//-----------------CONTRUCTOR---------------
	private boolean changeToExplode; 
	
	public RegularAlien(Game game, int posX, int posY) {
		super(game, posX, posY, 2, 5,"R");
		this.changeToExplode = false;
		// TODO Auto-generated constructor stub
	}
	public RegularAlien(Game game, int posX, int posY, int live,String sentido) {
		super(game, posX, posY, live, 5,"R");
		this.changeToExplode = false;
		if(sentido.equals("<-")) AlienShip.sentido = -1;
		else if(sentido.equals("->")) AlienShip.sentido = 1;
		// TODO Auto-generated constructor stub
	}
	
	//--------------METHODS IMPLEMENTS IAttack-----------
	

	//--------------ABSTRACT METHODS------------
	
	public RegularAlien() {
		// TODO Auto-generated constructor stub
	}

	public void computerAction() {
		// TODO Auto-generated method stub
		super.computerAction();	
		
		//la logica que nec
		if(IExecuteRandomActions.canGenerateExplodeShip(game)) {
			game.changeRegularToExplode(this.posX,this.posY,this.live);
			this.live = 0; this.points = 0;
			this.changeToExplode = true;
		}
	}
	
	@Override
	public void onDelete() {

		if(!this.isAlive()) {
			if(!this.changeToExplode) {
				game.receivePoints(5);	
			}
			AlienShip.contadorAlien--;
		}
	}

	
		//--------------OBJECT FORMAT OUTPUT-----------

	@Override
	public String toString() {
		return "R[" + this.live + "]";
	}
	


	@Override
	protected GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) {
		if(stringFromFile.split(";")[0].equalsIgnoreCase("R")) {
			int live  =Integer.parseInt(stringFromFile.split(";")[2]);
			if(!verifier.verifyAlienShipString(stringFromFile, game,2)) return null;

			String coordenadas = stringFromFile.split(";")[1]; // recoge las coordenadas
			
			return new RegularAlien(game,Integer.parseInt(coordenadas.split(",")[0]),
					Integer.parseInt(coordenadas.split(",")[1]),live,stringFromFile.split(";")[3]);
		}
		return null;
	}

}
