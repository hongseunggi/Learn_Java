package Foobar;

public abstract class AbstractVehicle implements Vehicle {
	private Engine engine;
	private Vehicle.Colour colour;
	
	public AbstractVehicle(Engine engine) {
		this.engine = engine;
	}
	public AbstractVehicle(Engine engine, Vehicle.Colour colour) { //colour�� �߰��� ������
		this.engine = engine;
		this.colour = colour;
	}
	@Override
	public Engine getEngine() { //engine ���� �����ش�
		return engine;
	}
	@Override
	public Vehicle.Colour getColour(){ //colour���� �����ش�
		return colour;
	}
	@Override
	public void paint(Vehicle.Colour colour) { //�Էµ� colour�� this colour�� ��´�.
		this.colour = colour;
	}
	public String toString() {
		return getClass().getSimpleName()+"("+engine.getClass().getSimpleName()+" ("+engine.getSize()+")"+", "+colour+", price "+getPrice()+")";
	}
}
