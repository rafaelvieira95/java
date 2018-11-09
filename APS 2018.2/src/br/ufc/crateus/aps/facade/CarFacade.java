package br.ufc.crateus.aps.facade;

public class CarFacade {

	
	private Engine engine;
	private Wheel whell;
	private Bench bench;
	
	public CarFacade(Engine engine,Wheel whell,Bench bench) {
		this.bench = bench;
		this.engine = engine;
		this.whell = whell;
	}
	
	
	public void buildCar() {
		
		System.out.println("Model: "+ SetupCar.MODEL_CAR);
		System.out.println("Year: "+SetupCar.YEAR_CAR);
		System.out.println("Engine: " +engine.setEngine(SetupCar.ENGINE_CAR));
		System.out.println("Wheel: "+whell.setWheel(SetupCar.WHEEL_CAR));
		bench.colorBench(SetupCar.COLOR_CAR);
		
	}
	
}
