package Foobar;

public class BoxVan extends AbstractVan { //AbstractVan을 상속받는 boxvan 클래스
	public BoxVan(Engine engine) { //engine만 전달되었을 때 호출되는 생성자
		super(engine);
	}
	public BoxVan(Engine engine, Vehicle.Colour colour) { //engine과 colour값이 전달될때 호출되는 생성자
		super(engine, colour);
	}
	@Override
	public int getPrice() { //boxvan의 가격을 리턴 해준다 
		return 10000;
	}
}
