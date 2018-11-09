package br.ufc.crateus.aps.facade;

public class App {

	public static void main(String[] args) {
		
		CarFacade car = new CarFacade(new Engine(), new Wheel(), new Bench());
	    car.buildCar();	

	}

}
