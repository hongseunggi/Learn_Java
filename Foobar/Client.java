package Foobar;

public class Client {
	public static void main(String []args) {
		Vehicle myCar = new Saloon(new StandardEngine(1200));
		myCar.paint(Vehicle.Colour.BLUE);
		System.out.println(myCar);
		myCar = new AirConditionedVehicle(myCar);
		System.out.println(myCar);
		myCar = new AlloyWheeledVehicle(myCar);
		System.out.println(myCar);
		myCar = new LeatherSeatedVehicle(myCar);
		System.out.println(myCar);
		myCar = new MetallicPaintedVehicle(myCar);
		System.out.println(myCar);
		myCar = new SatNavVehicle(myCar);
		System.out.println(myCar);

	}
}
