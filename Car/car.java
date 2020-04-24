package designpattern;
interface Engine{ //���� ���� ���̽�
	public int getSize();
	public boolean isTurbo();
}
interface GearboxStrategy{ // ���ڽ� ���� ���̽�
	void ensureCorretGear(Engine engine, int speed);
	public String getGear();
}
interface Vehicle{ //Vehicle ���� ���̽�
	public enum Colour{
		UNPAINTED,BLUE,BLACK,GREEN,RED,SILVER,WHITE,YELLOW
	};
	public Engine getEngine();
	public Vehicle.Colour getColour();
	public void paint(Vehicle.Colour colour);
}
abstract class AbstractVehicle implements Vehicle{ // Vehicle �������̽��� ��� �޴� �߻�Ŭ����
	private Engine engine;
	private Vehicle.Colour colour;
	
	public AbstractVehicle(Engine engine) {
		this.engine = engine; // �Ű����� engine�� this�����ڸ� ����Ͽ� private engine�� ��´�
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
}
abstract class AbstractCar extends AbstractVehicle{ //�� �߻�Ŭ������ ��ӹ޴� abstractcarŬ����
	private GearboxStrategy gearbox; //��� ������ gearbox ��ü�� ������ ����
	public AbstractCar(Engine engine) { //�Ű������� engine�� ������ ����Ǵ� ������
		super(engine);
		gearbox = new StandardGearboxStrategy(); //�ʱ� gearbox�� standard�� �������ش�
	}
	public AbstractCar(Engine engine, Vehicle.Colour colour) { // colour�� �߰��� ������
		super(engine, colour);
		gearbox = new StandardGearboxStrategy(); //�����ϰ� standard�� �������ش�
	}
	public void setGearboxStrategy(GearboxStrategy gs) { //��ȯ�� gearboxgstrategy���� ��� ���� gearbox�� �־ ��ȯ�����ش�.
		gearbox = gs;
	};
	public void getGearboxStrategy() { //���� gearbox�� ����� �ִ� �޼ҵ�
		System.out.println(gearbox.getGear());
	};
	public void setSpeed(int speed) {
		gearbox.ensureCorretGear(getEngine(), speed);
	};
}
abstract class AbstractEngine implements Engine{ //�������̽� Engine�� ��ӹ޴� �߻�Ŭ����
	private int size;
	private boolean turbo;
	
	public AbstractEngine(int size, boolean turbo) { //size�� turbo���θ� ���޹޾� �����Ѵ�
		this.size=size; 
		this.turbo=turbo;  
	}
	@Override
	public int getSize() { //size�� ��������
		return size;
	}
	@Override
	public boolean isTurbo() { //turbo���θ� ��������
		return turbo;
	}
}
class StandardGearboxStrategy implements GearboxStrategy{ //standardgearbox Ŭ����
	private String gs = "STANDARD";						  
	@Override
	public void ensureCorretGear(Engine engine, int speed) {//standard�����϶� ȣ��ȴ�.
			System.out.println("Working out correct gear at " + speed + "mph for a STANDARD gearbox");
	}
	@Override
	public String getGear() { //���¸� ��������
		return gs;
	}
}
class SportGearboxStrategy implements GearboxStrategy{ //Sportgearbox Ŭ����
	private String gs = "SPORT";
	@Override
	public void ensureCorretGear(Engine engine, int speed) {// Sport�����϶� ȣ��ȴ�.
			System.out.println("Working out correct gear at " + speed + "mph for a Sport gearbox");
	}
	@Override
	public String getGear() {
		return gs;
	}
}
class Sport extends AbstractCar{
	public Sport(Engine engine) { //engine�� ���޵Ǿ��� �� ȣ��Ǵ� ������
		super(engine);
	}
	public Sport(Engine engine, Vehicle.Colour colour) { //engine�� colour���� ���޵ɶ� ȣ��Ǵ� ������
		super(engine, colour);
	}
}
class StandardEngine extends AbstractEngine{ //standardengine Ŭ����
	public StandardEngine(int size) {//size���� �����ϰ�, turbo�� false�� �����ؼ� ������
		super(size,false);
	}
}
class TurboEngine extends AbstractEngine{ // Turboengine Ŭ����
	public TurboEngine(int size) { // size���� �����ϰ�, turbo�� true�� �����Ѵ�.
		super(size, true);
	}
}
public class car {
	public static void main(String []args) {
		AbstractCar myCar = new Sport(new TurboEngine(3000), Vehicle.Colour.valueOf("UNPAINTED"));
		Engine engine = myCar.getEngine(); //engine�� �޾ƿ�
		
		System.out.println("Car Engine size : "+engine.getSize()); //size�� ���
		System.out.println("Is Turbo : "+engine.isTurbo());//turbo���� ���
		System.out.println("Car Colour : "+myCar.getColour());//colour ���
		System.out.print("Gearbox setting : ");myCar.getGearboxStrategy(); // gearbox ���
		
		myCar.setSpeed(20);
		myCar.setSpeed(40);
		
		System.out.println("Switching on sports mode gearbox...");
		myCar.setGearboxStrategy(new SportGearboxStrategy());

		System.out.println("Changing colour...");
		myCar.paint(Vehicle.Colour.valueOf("RED"));
		System.out.println("Car Colour : "+myCar.getColour());
		System.out.print("Gearbox setting : ");myCar.getGearboxStrategy();
		
		myCar.setSpeed(20);
		myCar.setSpeed(40);

	}
}
