package Foobar;

public class Pickup extends AbstractVan { //AbstractVan을 상속받는 Pickup 클래스
	public Pickup(Engine engine) { //engine만 전달되었을 때 호출되는 생성자
		super(engine);
	}
	public Pickup(Engine engine, Vehicle.Colour colour) { //engine과 colour값이 전달될때 호출되는 생성자
		super(engine, colour);
	}
	@Override
	public int getPrice() { // 가격 리턴
		return 9000;
	}
}
