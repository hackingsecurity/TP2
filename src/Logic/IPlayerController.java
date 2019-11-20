package Logic;

/*Vemos que hay dos tipos de métodos:
	Las acciones que puede hacer el jugador. Estas llamadas le llegan a través de los
	comandos del controlador.
	Los callbacks que son las acciones de retorno. Por ejemplo cuando se habilita el
	shockWave, después de matar al Ovni. Callback es un término muy común para
	denotar este tipo de funciones, que se llaman al final de unas determinadas acciones.
	
	
	El Game debe implementar estos métodos del interfaz, aunque recuerda que no debe
	hacer nada más que delegar al objeto que le corresponda.
 * 
 */


public interface IPlayerController {
	
	// Player actions
	public boolean move (int numCells);
	public boolean shootMissile();
	public boolean shockWave();
	// Callbacks
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();

}
