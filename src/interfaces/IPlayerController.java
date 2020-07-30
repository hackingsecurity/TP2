package interfaces;

import exceptions.CommandExecuteException;
import exceptions.OffWorldException;

/**
 * 
 * Vemos que hay dos tipos de métodos:
 *	
 *	
 * 	Jugador -> Accedemos a ellos por los Comandos que se ejecutan en el controlador
 *	
 *  Callbacks ->  Son las acciones de retorno
 *
 *  Todos estos metodos los implementamos en el game
 */
public interface IPlayerController  {
	
	// Player actions
	public boolean move (int numCells) throws  CommandExecuteException;
	public boolean shootMissile();
	public boolean shockWave();
	public boolean shootSuperMissile();
	
	// Callbacks
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();
	public void enableSuperMissile();

}
