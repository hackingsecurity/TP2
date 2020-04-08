package interfaces;

import logic.Game;

/*
 * IExecuteRandomActions donde se encapsulan como métodos estáticos
 * 
 *  Estos métodos realizan acciones aleatorias sobre objectos del juego
 */

public interface IExecuteRandomActions {
	
	/**
	 * Generamos un ovni 
	 * @param game
	 * @return true si creamos el ovni o false si no
	 */
	static boolean canGenerateRandomOvni(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getOvniFrequency();
	}
	
	/**
	 * Generamos una bomba de Alien -> Destoyer
	 * @param game
	 * @return true si creamos una bomba o false si no
	 */
	static boolean canGenerateRandomBomb(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getShootFrequency();
	}
	
	/**
	 * Generamos una NaveExplosiva
	 * @param game
	 * @return true si creamos una bomba o false si no
	 */
	static boolean canGenerateExplodeShip(Game game) {
		return game.getRandom().nextDouble() < game.getLevel().getTurnExplodeFrequency();
	}

}
