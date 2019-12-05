package Logic;
import Objects.AlienShip;
import Objects.GameObject;
import Objects.Ovni;
import Objects.Shockwave;

/*
 * -GESTIONA A LISTA DE ELEMENTOS GAMEOBJECTS.
 * 	-OVNI, MISILES, BOMBAS, SHOCKWAVE, NAVES ENEMIGAS
 * 
 * -ENCAPSULAN EL COMPORATAMIENTO DE LA LISTA DE OBJETOS DEL JUEGO
 * 	-POCO LOGICA
 * 		-SE DELEGA TODA LA FUNCIONALIDAD A LOS OBJETOS
 */
public class GameObjectBoard {
	
	private GameObject[] objects;
	private int currentObjects;
	public GameObjectBoard (int width, int height) {
		
		this.currentObjects = 0;
		
		//PREGUNTAR A SIMON EL TAMAÑO DEL ARRAY OBJECTS
		objects = new GameObject[width * height];
		
	}
	
	//CONTADOR DE NUESTRA LISTA GAMEOBJECTS
	private int getCurrentObjects () {
		return this.currentObjects;
	}
	
	//INCREMENTO EL CONTADOR DE LA LISTA DE OBJETOS
	private void setCurrentObjects(int currentObject) {
		this.currentObjects += 1;
	}
	
	//AÑADIMOS UN NUEVO OBJETO A NUESTRA LISTA 
	// E INCREMENTAMOS EL CONTADOR
	public void add (GameObject object) {
	  this.objects[getCurrentObjects()] = object;
	  setCurrentObjects(this.currentObjects);
	}
	

	//DEVUELVO UN OBJETO DADO UNAS COORDENADAS
	private GameObject getObjectInPosition ( int posX, int posY ) {
		
		/*
		 *	1) Hacemos una busqueda en nuestro array de objetos
		 *	2) Mientras no hayamos encontrado nuestro objecto
		 *		-encontrado = falso
		 *	3) Mientras nuestro contador no llegue a ser igual
		 *		al contador de nuestro array seguimos buscando
		 *	4) Para cada objeto comparamos las coordenadas paradas
		 *
		 */
		boolean find = false;
		GameObject obj = null;
		
		int cont = 0;
		while(( cont < getCurrentObjects()) || !find) {
			
			if(posX == (this.objects[cont].getPosX()) &&
				posY == this.objects[cont].getPosY()) {
		
					obj = this.objects[cont];
					find = true;
			}
			else {
				cont++;
			}
		}	
		return obj ;
	}
	
	private int getIndex(int x, int y) {
		int index = 0;
		boolean encontrado = false;
		while(index < this.currentObjects && !encontrado){
			if(objects[index].getPosX()==x && objects[index].getPosY() == y ){
				encontrado = true;
			}
			else {
				index++;
			}
		}
		return index;
	}
	
	private void remove (GameObject object) {
		int x = object.getPosX();
		int y = object.getPosY();
		int index = getIndex(x,y);
		for(int i = index; i <this.currentObjects-1; i++){
			this.objects[i] = this.objects[i+1];
		}
		this.objects[this.currentObjects-1]= null;
		this.currentObjects--;
	}
	public void update() {
	// TODO implement
		
		removeDead();
		for(int i = 0; i < this.currentObjects; i++){
			this.objects[i].move();
			
		}
		
		AlienShip.setBajar(false);
	}
	
	
	
	/*
	 * Logica:
	 * 	-> dado un objeto
	 * 		->llamamos al metodo para ver si hayun objeto en la posicion siguiente (arriba, y abajo)
	 * 		->
	 */									//misile
	private void checkAttacks(GameObject object) {
	
		for(int i = 0; i < this.currentObjects; i++) {
			                        //ovni
			if(object.performAttack(objects[i])) {
				if(objects[i].receiveBombAttack(object.getDamage())) {
					
				}
				else if(objects[i].receiveMissileAttack(object.getDamage())) {
					
				}
				else if(objects[i].receiveShockWaveAttack(object.getDamage())) {
					
				}
			}
		}
	
	}
	
	public void computerAction() {
		
		for(int i = 0 ; i < this.currentObjects; i++){
			this.objects[i].computerAction();
			checkAttacks(objects[i]);
			
		}
	}
	
	private void removeDead() {
	// TODO implement
		for(int i = 0; i < this.currentObjects; i++) {
			if(!objects[i].isAlive()) {
				objects[i].onDelete();
				remove(objects[i]);
				i--;
			}
		}
	}
	
	public String stringObjectInPos(int posX, int posY) {
		
		String stringObject = null;
		boolean encontrado = false;
		int cont = 0;
		while (cont < this.currentObjects && !encontrado) {
			
			if(this.objects[cont].getPosX() == posX) {
				if(this.objects[cont].getPosY() == posY) {
					encontrado = true;
					stringObject = this.objects[cont].toString();
					
				}
			}
			
			cont++;
		}
		
		return stringObject;
	}
	//comprobamos si cambian el sentido y tambien si 

	public boolean existOnBoard(int posX, int posY) {
		int cont = 0;
		boolean encontrado = false;
		
		while (cont < this.currentObjects && !encontrado) {
			
			if(this.objects[cont].getPosX() == posX) {
				if(this.objects[cont].getPosY() == posY){
					encontrado = true;
				}
			}
		}
		return encontrado;
	}
	
	
	/*
	 * VEMOS SI EXISTE UN OBJECTO SHOOKWAVE
	 */
	public boolean existShowaveOnBoard() {
		
		boolean shock = false;
		int cont = 0;
		
		while (cont < this.currentObjects && !shock) {
			
			if(this.objects[cont] instanceof Shockwave) {
				shock = true;
			}
			
			cont++;
		}
		
		return shock;
	}

	
		
	}
	
