package Foobar;

public class Coupe extends AbstractCar { //AbstractCar를 상속받는 Coupe 클래스
	public Coupe(Engine engine) { //engine만 전달되었을 때 호출되는 생성자
		super(engine);
	}
	public Coupe(Engine engine, Vehicle.Colour colour) { //engine과 colour값이 전달될때 호출되는 생성자
		super(engine, colour);
	}
	@Override
	public int getPrice() { //Coupe 가격 리턴
		return 7000;
	}
}
