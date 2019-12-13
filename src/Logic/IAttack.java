package Logic;
import  Objects.GameObject;



/*
 * Por defecto performAttack devuelve false lo que quiere decir que el objeto de juego no
	hace daño (sólo hacen daño el misil, las bombas y el shockwave). Los destroyers no hace
	daño, lo que hacen es lanzar bombas que son las que realmente hacen daño. Si un objeto
	de juego puede atacar, tendrá que sobreescribir el método e implementar la lógica de su
	ataque.
	
	De igual manera todos los objetos pueden recibir daño de otro objeto. Por defecto no lo
	reciben. Pero, por ejemplo, los aliens y las bombas sí reciben daño del misil, o el UCMShip
	y el misil sí reciben ataques de la bomba.
 */

public interface IAttack {
	
	default boolean performAttack(GameObject other) {return false;};
	default boolean receiveMissileAttack(int damage) {return false;};
	default boolean receiveBombAttack(int damage) {return false;};
	default boolean receiveShockWaveAttack(int damage) {return false;};
	default boolean receiveSuperMissileAttack(int damage) {return false;}
}
