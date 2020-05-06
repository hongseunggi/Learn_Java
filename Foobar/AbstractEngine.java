package Foobar;

public abstract class AbstractEngine implements Engine {
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
