package Foobar;

public abstract class AbstractVehicle implements Vehicle {
	private Engine engine;
	private Vehicle.Colour colour;
	
	public AbstractVehicle(Engine engine) {
		this.engine = engine;
	}
	public AbstractVehicle(Engine engine, Vehicle.Colour colour) { //colour가 추가된 생성자
		this.engine = engine;
		this.colour = colour;
	}
	@Override
	public Engine getEngine() { //engine 값을 돌려준다
		return engine;
	}
	@Override
	public Vehicle.Colour getColour(){ //colour값을 돌려준다
		return colour;
	}
	@Override
	public void paint(Vehicle.Colour colour) { //입력된 colour를 this colour에 담는다.
		this.colour = colour;
	}
	public String toString() {
		return getClass().getSimpleName()+"("+engine.getClass().getSimpleName()+" ("+engine.getSize()+")"+", "+colour+", price "+getPrice()+")";
	}
}
