package callstack;

/**
 * Example form Script file:
 * 2.3_programmiersprachen_vertiefung_java/004.2_exceptions.pdf > Page 12 and 13
 */
public class Main {

	public static void main(String[] args) {
		new Main();

	}
	
	public Main(){
		try{
			int x=2;	// change value of x to throw different exceptions
			new A(x);
		} catch (Exc1 e){
			System.out.print("Main");
			e.printStackTrace();
		}
	}

}
