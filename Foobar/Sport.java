package Foobar;

public class Sport extends AbstractCar {
	public Sport(Engine engine) { //engine만 전달되었을 때 호출되는 생성자
		super(engine);
	}
	public Sport(Engine engine, Vehicle.Colour colour) { //engine과 colour값이 전달될때 호출되는 생성자
		super(engine, colour);
	}
	@Override
	public int getPrice() {
		return 8000;
	}
}
