package matching;

import java.util.List;

public abstract class MatchingStrategy {
	double sueile;
	abstract     Boolean Stratgie_choisi(List<String> liste1, List<String> liste2);
	public double getSueile() {
		return sueile;
	}
	public void setSueile(double sueile) {
		this.sueile = sueile;
	}
	
}
