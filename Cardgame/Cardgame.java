package designpattern;
import java.util.Scanner;
public class Cardgame {
	public static void restart() { //������ ��������� ���� ���θ� ���� �޼ҵ�
		Scanner scan = new Scanner(System.in);
		for(;;) {
			System.out.print("More game?[y/n]");
			char c = scan.next().charAt(0);
			try {					// try catch ���� ���� ����ó���� ���ش�.
				if(c=='y'||c=='Y') { 
					cardstart();
				}
				else if(c=='n'||c=='N') {
					break;
				}
				else throw new Exception();	//���ܸ� ������ catch���� ������, y,Y,n,N ���� �ٸ� ���ڰ� �Էõ� ���
			}
			catch(Exception e) { //try������ ���� exception�� �޾� ó���ϴ� �κ�
				System.out.println("Please Enter the Correct Word.");
				
			}
		}
			System.out.println("Done."); 
		return; //����ڰ� n/N�� �������� �޼ҵ带 ������ ���� ��ȯ main���� ��ȯ ��Ų��.
	}
	public static void card(int i) { //������ �����ϴ� �޼ҵ�
		Scanner scan = new Scanner(System.in);
		int UserNum = 0;
		if(i==1) { // for���� ���� ī����� ����
			System.out.println("Hidden number is created. Try it");
			int rand = (int)(Math.random()*100); //0~99������ ������ ���� �����Ѵ�. 
			for(;;) { // for���� ���ѹݺ������� ���� ��Ų��.
				try { // try���� �̿���  ����ó��
					UserNum = scan.nextInt();
				}
				catch(Exception e) { //���ܰ� �߻������� ����Ǵ� catch�κ�
					System.out.println(e);
					break;
				}
				if(UserNum>rand) { // ����ڰ� �Է��� ���� ������ ���� Ŭ ��� Lower�� ��� 
					System.out.println("Lower");
				}
				else if(UserNum<rand) {
					System.out.println("Higher"); //�ݴ�
				}
				else break; // ������ �� ����
			}
		}
		else if(i==2) { //while���� ���� ī�����
			System.out.println("Hidden number is created. Try it");
			int rand = (int)(Math.random()*100);
			while(true) {
				try {
					UserNum = scan.nextInt();
				}
				catch(Exception e) {
					System.out.println(e);
					break;
				}
				if(UserNum>rand) {
					System.out.println("Lower"); // for���� ����
				}
				else if(UserNum<rand) {
					System.out.println("Higher");
				}
				else break;
			}
		}
		else if(i==3) {
			System.out.println("Hidden number is created. Try it");
			int rand = (int)(Math.random()*100);
			do { // do while���� ���� ī����� ������
				try {
					UserNum = scan.nextInt();
				}
				catch(Exception e) {
					System.out.println(e);
					break;
				}
				if(UserNum>rand) {
					System.out.println("Lower"); 
				}
				else if(UserNum<rand){
					System.out.println("Higher");
				}
				else break;
			}while(true); // do while, while, for�� ��� ������ ����. 
						  // ���������� do while�� ��� ���� 1ȸ�� ������ ����ȴٴ� Ư¡�� �ִ�.(������ ���� ���� ���x)
		}
		restart(); // ���� ����� restart�޼ҵ� ȣ��
	}
	public static void cardstart() { //�������� �ݺ����� �����ϴ� �޼ҵ�
		System.out.println("1. for 2. while 3. do while");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		card(a); // �Էµ� �� �� card �޼ҵ忡 ���� �� �ش�.
	}
	public static void main(String[] args) { //���α׷��� main �޼ҵ�
		cardstart(); // cardstart �޼ҵ带 ȣ���ϹǷν� ���α׷��� ���۽�Ű�� ������ �Ѵ�.
		System.out.print("Bye Bye");
	}
}
