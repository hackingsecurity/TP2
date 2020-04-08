//PAQUETE QUE LO CONTIENE
package object;
import interfaces.IExecuteRandomActions;
import logic.Game;


/**
 * Cambio un RegularShip a un ExplodeShip
 */
public  class RegularAlien extends AlienShip{

	//-----------------CONTRUCTOR---------------
	private boolean changeToExplode; 
	
	public RegularAlien(Game game, int posX, int posY) {
		super(game, posX, posY, 2, 5);
		this.changeToExplode = false;
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
	public String stringifed() {
		return "Regular:"+" " +"R" + ";" + this.posX +","+ this.posY + ";" 
				+ this.live + ";" + game.stringSent(AlienShip.sentido)+ "\n" ;   
	}

}
