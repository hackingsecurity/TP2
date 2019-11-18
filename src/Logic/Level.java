package tp.p1;

public enum Level {

	EASY ("EASY", 4, 2, 0.9, 3, 0.5),
	HARD ("HARD", 8, 2, 0.3, 2, 0.2),
	INSANE ("INSANE", 8, 4, 0.5, 1, 0.1);
	
	String level;
	int nRegShip, nDesShip, speed;
	double frecShoot, probaOvni;
	
	private Level (String level, int nRegShip, int nDesShip, double frecShoot, int speed, double probaOvni) {
		
		this.level = level;
		this.nRegShip = nRegShip;
		this.nDesShip = nDesShip;
		this.speed = speed;
		this.frecShoot  = frecShoot;
		this.probaOvni = probaOvni;
	}

	public String getLevel() {
		return level;
	}

	public int getnRegShip() {
		return nRegShip;
	}

	public int getnDesShip() {
		return nDesShip;
	}

	public int getSpeed() {
		return speed;
	}

	public double getFrecShoot() {
		return frecShoot;
	}

	public double getProbaOvni() {
		return probaOvni;
	}
	
	
	public static Level  stringTolevel(String parametro) {
		for (Level nivel : Level.values()) {
			if (nivel.level.equals(parametro))
				return nivel;
		}
		return null;
	}

}
