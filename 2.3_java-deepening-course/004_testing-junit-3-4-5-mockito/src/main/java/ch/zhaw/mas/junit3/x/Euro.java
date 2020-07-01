package ch.zhaw.mas.junit3.x;

public class Euro {
	
	private double amount;

	public Euro(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return this.amount;
	}
	
	public void add (Euro euro) {
		if (euro.getAmount() < 0) throw new IllegalArgumentException(); 
		this.amount += euro.getAmount();
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Euro other = (Euro) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		return true;
	}

	
}
