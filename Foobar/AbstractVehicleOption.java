package Foobar;

public abstract class AbstractVehicleOption extends AbstractVehicle { // AbstractVehicle을 상속받는 AbstractVehicleOption 추상클래스
	public AbstractVehicleOption(Engine engine, Vehicle.Colour colour) {
		super(engine, colour); // 엔진과 컬러를 넘겨준다.
	}
}
