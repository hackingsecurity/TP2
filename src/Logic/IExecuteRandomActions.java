package Logic;

/*
 * IExecuteRandomActions donde se encapsulan como métodos estáticos
	los métodos para saber si ejecuta o no la acción. Este código también te lo damos para
	que lo uses donde sea necesario.
	Uno de los objetos que implementa IExecuteRandomActions es el Ovni. La información
	sobre si existe o no en el tablero un ovni podría almacenarse en un atributo estático de la
	propia clase Ovni.
 */

public interface IExecuteRandomActions {
	
	static boolean canGenerateRandomOvni(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getOvniFrequency();
	}
	
	static boolean canGenerateRandomBomb(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getShootFrequency();
	}

}
