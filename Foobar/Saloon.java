package Foobar;

public class Saloon extends AbstractCar { // AbstractCar를 상속받는 Saloon 클래스
	public Saloon(Engine engine) { //engine만 전달되었을 때 호출되는 생성자
		super(engine);
	}
	public Saloon(Engine engine, Vehicle.Colour colour) { //engine과 colour값이 전달될때 호출되는 생성자
		super(engine, colour);
	}
	@Override
	public int getPrice() { // 가격 리턴
		return 6000;
	}
}
