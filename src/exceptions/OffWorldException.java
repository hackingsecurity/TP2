package exceptions;

public class OffWorldException extends Exception {
	public OffWorldException() {
		super("Cannot perform move: ship too near border");
	}
	
}
