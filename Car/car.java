package designpattern;
interface Engine{ //엔진 인터 페이스
	public int getSize();
	public boolean isTurbo();
}
interface GearboxStrategy{ // 기어박스 인터 페이스
	void ensureCorretGear(Engine engine, int speed);
	public String getGear();
}
interface Vehicle{ //Vehicle 인터 페이스
	public enum Colour{
		UNPAINTED,BLUE,BLACK,GREEN,RED,SILVER,WHITE,YELLOW
	};
	public Engine getEngine();
	public Vehicle.Colour getColour();
	public void paint(Vehicle.Colour colour);
}
abstract class AbstractVehicle implements Vehicle{ // Vehicle 인터페이스를 상속 받는 추상클래스
	private Engine engine;
	private Vehicle.Colour colour;
	
	public AbstractVehicle(Engine engine) {
		this.engine = engine; // 매개변수 engine을 this지정자를 사용하여 private engine에 담는다
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
}
abstract class AbstractCar extends AbstractVehicle{ //위 추상클래스를 상속받는 abstractcar클래스
	private GearboxStrategy gearbox; //멤버 변수로 gearbox 객체를 가지고 있음
	public AbstractCar(Engine engine) { //매개변수가 engine만 있을때 수행되는 생성자
		super(engine);
		gearbox = new StandardGearboxStrategy(); //초기 gearbox를 standard로 설정해준다
	}
	public AbstractCar(Engine engine, Vehicle.Colour colour) { // colour가 추가된 생성자
		super(engine, colour);
		gearbox = new StandardGearboxStrategy(); //동일하게 standard로 설정해준다
	}
	public void setGearboxStrategy(GearboxStrategy gs) { //변환된 gearboxgstrategy값을 멤버 변수 gearbox에 넣어서 변환시켜준다.
		gearbox = gs;
	};
	public void getGearboxStrategy() { //현재 gearbox를 출력해 주는 메소드
		System.out.println(gearbox.getGear());
	};
	public void setSpeed(int speed) {
		gearbox.ensureCorretGear(getEngine(), speed);
	};
}
abstract class AbstractEngine implements Engine{ //인터페이스 Engine을 상속받는 추상클래스
	private int size;
	private boolean turbo;
	
	public AbstractEngine(int size, boolean turbo) { //size와 turbo여부를 전달받아 저장한다
		this.size=size; 
		this.turbo=turbo;  
	}
	@Override
	public int getSize() { //size를 리턴해줌
		return size;
	}
	@Override
	public boolean isTurbo() { //turbo여부를 리턴해줌
		return turbo;
	}
}
class StandardGearboxStrategy implements GearboxStrategy{ //standardgearbox 클래스
	private String gs = "STANDARD";						  
	@Override
	public void ensureCorretGear(Engine engine, int speed) {//standard상태일때 호출된다.
			System.out.println("Working out correct gear at " + speed + "mph for a STANDARD gearbox");
	}
	@Override
	public String getGear() { //상태를 리턴해줌
		return gs;
	}
}
class SportGearboxStrategy implements GearboxStrategy{ //Sportgearbox 클래스
	private String gs = "SPORT";
	@Override
	public void ensureCorretGear(Engine engine, int speed) {// Sport상태일때 호출된다.
			System.out.println("Working out correct gear at " + speed + "mph for a Sport gearbox");
	}
	@Override
	public String getGear() {
		return gs;
	}
}
class Sport extends AbstractCar{
	public Sport(Engine engine) { //engine만 전달되었을 때 호출되는 생성자
		super(engine);
	}
	public Sport(Engine engine, Vehicle.Colour colour) { //engine과 colour값이 전달될때 호출되는 생성자
		super(engine, colour);
	}
}
class StandardEngine extends AbstractEngine{ //standardengine 클래스
	public StandardEngine(int size) {//size값을 전달하고, turbo를 false로 설정해서 전달함
		super(size,false);
	}
}
class TurboEngine extends AbstractEngine{ // Turboengine 클래스
	public TurboEngine(int size) { // size값을 전달하고, turbo를 true로 전달한다.
		super(size, true);
	}
}
public class car {
	public static void main(String []args) {
		AbstractCar myCar = new Sport(new TurboEngine(3000), Vehicle.Colour.valueOf("UNPAINTED"));
		Engine engine = myCar.getEngine(); //engine을 받아옴
		
		System.out.println("Car Engine size : "+engine.getSize()); //size값 출력
		System.out.println("Is Turbo : "+engine.isTurbo());//turbo여부 출력
		System.out.println("Car Colour : "+myCar.getColour());//colour 출력
		System.out.print("Gearbox setting : ");myCar.getGearboxStrategy(); // gearbox 출력
		
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
