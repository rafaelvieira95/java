package br.ufc.crateus.aps.times;

public class Teams {

	private String name;
	private int points;

	public Teams(String name, int points) {
		this.name = name;
		this.points = points;
	}

	public Teams() {

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getPoints() {
		return this.points;
	}

	@Override
	public String toString() {
		return this.name + "  " + this.points;
	}

}