package interfaces;

import logic.Game;

/*
 * IExecuteRandomActions donde se encapsulan como métodos estáticos
 * 
 *  Estos métodos realizan acciones aleatorias sobre objectos del juego
 */

public interface IExecuteRandomActions {
	
	
	/*
	 * * IExecuteRandomActions: mejor multiplicar frecuencias por 100 y usar randInt 
    	+ trabajar con números flotantes se debería evitar cuando sea posible
	 */
	
	/**
	 * Generamos un ovni 
	 * @param game
	 * @return true si creamos el ovni o false si no
	 */
	static boolean canGenerateRandomOvni(Game game){
		return game.getRandom().nextInt(100)  < game.getLevel().getOvniFrequency() * 100;
	}
	
	/**
	 * Generamos una bomba de Alien -> Destoyer
	 * @param game
	 * @return true si creamos una bomba o false si no
	 */
	static boolean canGenerateRandomBomb(Game game){
		return game.getRandom().nextInt(100)  < game.getLevel().getShootFrequency() * 100;
	}
	
	/**
	 * Generamos una NaveExplosiva
	 * @param game
	 * @return true si creamos una bomba o false si no
	 */
	static boolean canGenerateExplodeShip(Game game) {
		return game.getRandom().nextInt(100)  < game.getLevel().getTurnExplodeFrequency() * 100;
	}

}
