package exceptions;

public class NoShockwaveException extends Exception {
	public NoShockwaveException() {
		super(" Cannot release shockwave: no shockwave available");
	}
}
