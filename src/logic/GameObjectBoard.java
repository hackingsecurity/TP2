package logic;
import object.AlienShip;
import object.GameObject;


/**
 * -Gestiona nuestro array de objectos (todos mezclados)
 * 	-Missile
 *  -Bomb
 *  -ShockWave
 *  -Aliens
 * 
 * -Encapsulan el comportamiento de la lista de objectos
 * 	-Poca lógica
 * 		-Se delega toda la funcionalidad a los objetos
 */
public class GameObjectBoard {

	//-----------------VARIABLES----------------

	private GameObject[] objects;
	private int currentObjects;  //objectos actuales
	
	//-----------------CONTRUCTOR---------------
	
	public GameObjectBoard (int width, int height) {
		
		objects = new GameObject[width * height];
		this.currentObjects = 0;
		
	}

	//--------------GETTER AND SETTER-----------
	
	private int getCurrentObjects () { return this.currentObjects;}
	private void setCurrentObjects(int currentObject) {this.currentObjects += 1;}
	
	//---------------OWNER METHODS--------------
	
	/**
	 * Añadimos un nuevo objecto
	 * @param object
	 */
	public void add (GameObject object) {
	  this.objects[getCurrentObjects()] = object;
	  setCurrentObjects(this.currentObjects);
	}
	
	/**
	 * Devuelvo un objeto dada un posición
	 * 
	 *  -Hacemos una busqueda en nuestro array de objetos
	 * 
	 *  @param posX
	 *  @param posY
	 *  @return Object
	 */
	private GameObject getObjectInPosition ( int posX, int posY ) {
	
		int index = getIndex(posX, posY);
		
		if (index == -1) {
			return null;
		}
		return this.objects[index];
	}
	
	/**
	 * Devuelve el indice que corresponde a las coordenadas dadas
	 * 
	 * @param posX
	 * @param posY
	 * @return devuelve un entero
	 */
	private int getIndex(int posX, int posY) {
		boolean find = false;
		int cont = 0;
		
		while( cont < this.currentObjects && !find) {
			if(this.objects[cont].isOnPosition(posX, posY)) find = true;
			else cont++;
		}
		
		if(cont == this.currentObjects) {
			cont = -1;
		}
		
		return cont ; 
	}
	
	/**
	 * Dado un objecto buscamos con sus coordenadas
	 * el indice que correponde en el object
	 * 
	 * @param object
	 */
	private void remove (int index) {
		
		for(int i = index ; i < this.currentObjects ; i++){
			if((i + 1) < this.currentObjects){
				this.objects[i] = this.objects[i+1];				
			}else {
				this.objects[i] = null;
			}
		}	
		currentObjects--;
	}
	
	
	/**
	 * Recorremo todos los objetos
	 * 	-los movemos 
	 * 	-comprobamos si nuestro objecto ataca
	 */
	public void update() {
		
		for(int i = this.currentObjects - 1 ; i >= 0 ; i--){
			this.objects[i].move();
			checkAttacks(this.objects[i]);	
		}
		
		if(AlienShip.getBajar()) {	
			AlienShip.setBajarShips(false);
		}
		
		removeDead();
	}
	
	
	
	/**
	 * Logica:
	 * 	1) dado un objeto
	 * 		-cogemos sus coordenadas y recorremos nuestro array de objectos
	 * 
	 * 	2) Debemos comprobar si existe un objecto que al mover
	 * 	en el update, coincida con las coordenadas de este objecto
	 * 	
	 *  3) Si es así llamamos al performAttack
	 * 
	 */
	
	
	private void checkAttacks(GameObject object) {
		
		for(int i = this.currentObjects - 1 ; i >= 0 ; i--) {
			object.performAttack(objects[i]);
			
			
		}
	}
	
	/*
	private void checkAttacks(GameObject object, int index) {
		
		int aux = currentObjects;
		
		for(int i = index + 1; i <= aux; i++) {	
			
			if(i + 1 >= currentObjects) {
				i = 0;
				if(currentObjects - 1 == index) {
					aux = index - 2;
				}
				aux = index - 1;
			}
			
			if(objects[i].isOnPosition(object.getPosX(), object.getPosY())) {

				object.performAttack(objects[i]);
			}	
		}
			
	}
	*/
	
	/*	//Con esto no nos atacamos a nosotros mismo.
			if(! (object.equals(objects[cont]))) {
				if(this.objects[cont].isOnPosition(object.getPosX(), object.getPosY())){
					object.performAttack(objects[cont]);
					find = true;
				}
			}
		*/	
	
	/**
	 * 
	 */
	public void computerAction() {
		for(int i = this.currentObjects - 1 ; i >= 0 ; i--){
			this.objects[i].computerAction();
			checkAttacks(objects[i]);		
		}
		
		removeDead();
	}
	
	
	/**
	 * 
	 */
	private void removeDead() {
		for(int i = 0; i < this.currentObjects; i++) {
			if(!objects[i].isAlive()) {
				objects[i].onDelete();
				remove(i);
				i--;
			}
		}
	}
	
	/**
	 * Lo usa UCMShip para hacer daño a los objectos
	 * 
	 */
	public void shootSchockWate() {
		for(int i = 0; i < this.getCurrentObjects(); i++) {
			this.objects[i].receiveShockWaveAttack(1);
		}
		removeDead();
	}
	
	/**
	 * 
	 * PENSANDO COMO HACERLO CHUNGO CHUNGO
	 * 
	 * Comprobamos si existe un objecto en el board
	 * @param posX
	 * @param posY
	 * @return
	 */
	public void explode(int posX, int posY) {
		for(int a = 0; a <= 2; a++) {
			for(int b = 0; b <= 2; b++){
				if(this.getObjectInPosition((posX - 1 + a), (posY - 1 + b)) != null) {
					getObjectInPosition((posX - 1 + a), (posY - 1 + b)).receiveMissileAttack(1);
				}
			}
		}
	}
	
	//--------------OBJECT FORMAT OUTPUT-----------
	
	/**
	 * Dado unas coordenadas obtenemos el objecto que
	 * está en ellas. sino existe (el indice es -1)  
	 * 
	 * @param posX
	 * @param posY
	 * @return
	 */
	public String toString(int posX, int posY) {
		
		int index = getIndex(posX, posY);
		
		if(index == -1) {
			return null;
		}
		
		return objects[index].toString();
	}

	public String stringifier() {
		String stringfier ="";
		
		for (int i = 0; i < this.currentObjects; i++) {
			String st = this.objects[i].stringifed();
			if(!st.equals(""))
				stringfier += this.objects[i].stringifed() + "\n"  ; 
		}	
		return stringfier;
	}

	public GameObject getLabelOwnwer(int ownerRef) {
		
		for (int i =0; i<currentObjects; i++) {
			if (objects[i].isOwner(ownerRef))
				return objects[i];
		}
		return null;
	}
//limpiar tablero para cuando haces el load
	public void cleanBoard() {
		for (int i = 0; i < currentObjects; i++) {
			remove(i);
			i--;
		}
		
	}

	
}
	
