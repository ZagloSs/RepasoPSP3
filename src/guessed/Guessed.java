package guessed;

public class Guessed {
	private boolean guessed;

	public Guessed(boolean guessed) {
		super();
		this.guessed = guessed;
	}

	public synchronized boolean isGuessed() {
		return guessed;
	}

	public synchronized void setGuessed(boolean guessed) {
		this.guessed = guessed;
	}
	
	
}
