package exceptions;

public class MissileInFlightException extends Exception {
	
	
	public MissileInFlightException (){
		super("Cannot fire missile: missile already exists on board");
	}
	
	

}


