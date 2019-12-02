package Logic;
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
		
		GameObject obj = null;
		
		int cont = 0;
		while(( cont < getCurrentObjects()) && !false) {
			
			if(posX == (this.objects[cont].getPosX()) &&
				posY == this.objects[cont].getPosY()) {
		
					obj = this.objects[cont];
			}
			else {
				cont++;
			}
		}	
		return obj ;
	}
	
	private int getIndex( /* coordinadas */ ) {
	// TODO implement
		return 0;
	}
	
	private void remove (GameObject object) {
	// TODO implement
	}
	
	public void update() {
	// TODO implement
	}
	
	private void checkAttacks(GameObject object) {
	// TODO implement
	}
	
	public void computerAction() {
	// TODO implement
	}
	
	private void removeDead() {
	// TODO implement
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

	
	public void activeShockwave() {
	
		boolean activeshock = false;
		int cont = 0;
		while (cont < this.currentObjects && !activeshock) {
			
			if(this.objects[cont] instanceof Ovni) {
	
			}
			else {
				cont++;
			}
		}
		
	}
}
