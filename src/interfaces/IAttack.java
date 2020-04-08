package interfaces;

import object.GameObject;

/**
 * Todos los objetos del juego tienes la posibilidad de atacar o ser atacados
 * 
 *
 */
public interface IAttack {
	
	/**
	 * Si el objeto hace daño debe implementar este método
	 *  ¿Qúe objetos?
	 *  	-bomba
	 *  	-misil
	 *  	-shockwave
	 * @param other
	 * @return
	 */
	default boolean performAttack(GameObject other) {return false;};
	
	
	
	/**
	 * Recibe ataque de un SuperMissileAttack
	 * 
	 * @param damage
	 * @return
	 */
	default boolean receiveSuperMissileAttack(int damage) {return false;};
	
	
	/**
	 * Recibe daño del misil
	 * 	-Bombas
	 * 	-Aliens (destroyer, regular y ovni)
	 * @param damage
	 * @return
	 */
	default boolean receiveMissileAttack(int damage) {return false;};	
	
	/**
	 * Recibe daño del bomba
	 * 	-UCMship
	 * @param damage
	 * @return
	 */
	default boolean receiveBombAttack(int damage) {return false;};	
	
	
	/**
	 * Recibe daño del super ataque que es shockWave y que quita un
	 * punto de daño a todos los AlienShip
	 * 
	 * 	 -OJO el Ovni no recibe daño
	 * @param damage
	 * @return
	 */
	default boolean receiveShockWaveAttack(int damage) {return false;};	
	
	/**
	 * Implementar
	 * @param damage
	 * @return
	 */
	default boolean receiveExplosionAttack(int damage) {return false;};
}
