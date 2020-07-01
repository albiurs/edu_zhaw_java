package u1.serialize;

import java.io.Serializable;

public class Motor implements Serializable {

	private static final long serialVersionUID = 4780002103589310496L;

	private int hubraum;

	public Motor(int hubraum) {
		this.hubraum = hubraum;
	}

	public int getHubraum() {
		return hubraum;
	}
}
