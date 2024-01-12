package matching;

import java.util.List;

public class StrategyDistance extends MatchingStrategy{
	
	SimilariteChaine similariteChaine;
	
    public StrategyDistance(SimilariteChaine similariteChaine) {
    	this.similariteChaine = similariteChaine;
    }
	@Override
	public Boolean Stratgie_choisi(List<String> liste1, List<String> liste2) {
		return false;
		
	}

}
