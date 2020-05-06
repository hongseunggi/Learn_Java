package Foobar;

public abstract class AbstractEngine implements Engine {
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
