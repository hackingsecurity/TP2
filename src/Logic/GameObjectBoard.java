package Logic;

public class GameObjectBoard {
	
	/*
	 * que será la encargada
	   de gestionar la lista de elementos de tipo GameObject.
	   
	   
	   La clase Game solo tendrá un
		atributo de tipo GameObjectBoard y otro de tipo UCMShip. Con estos dos atributos se
		gestionarán todos los elementos del juego, incluidos el Ovni, los disparos del jugador y las
		bombas lanzadas por las naves enemigas.
		
		
		se encapsula el comportamiento de la
		lista de objetos de juego. Deberás rellenar esos métodos, al igual que en el Game esos
		métodos tienen muy poca lógica, toda la funcionalidad se delega a los objetos de juego.
	 */

	private GameObject[] objects;
	private int currentObjects;
	
	public GameObjectBoard (int width, int height) {
	// TODO implement
	}
	
	private int getCurrentObjects () {
	// TODO implement
	}
	
	public void add (GameObject object) {
	// TODO implement
	}
	
	private GameObject getObjectInPosition ( /∗ coordinadas ∗/ ) {
	// TODO implement
	}
	
	private int getIndex( /∗ coordinadas ∗/ ) {
	// TODO implement
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
	
	public String toString( /∗ coordinadas ∗/ ) {
	// TODO implement
	}
	
}
