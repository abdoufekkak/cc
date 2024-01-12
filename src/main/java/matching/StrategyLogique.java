package matching;

import java.util.ArrayList;
import java.util.List;

public class StrategyLogique extends MatchingStrategy{
	
    SimilariteChaine similariteChaine;
	List<Boolean>l;
	
	@Override
	public Boolean Stratgie_choisi(List<String> liste1, List<String> liste2) {
		// TODO Auto-generated method stub
		for(int i=0;i<l.size();i++) {
			if(l.get(i)==true) {
			double d=	similariteChaine.distance(liste1.get(i), liste2.get(i));
			System.out.println(d);
			if(d<sueile) {
				return false;
			}
			}
		}
		return true;
	}
    public StrategyLogique(SimilariteChaine similariteChaine,List<Boolean> l,Double sueile) {
    	this.similariteChaine = similariteChaine;
    	this.l=l;
    	this.sueile=sueile;
    }
     
    

	public double getSueile() {
		return sueile;
	}
	public void setSueile(double sueile) {
		this.sueile = sueile;
	}
	public SimilariteChaine getSimilariteChaine() {
		return similariteChaine;
	}



	public void setSimilariteChaine(SimilariteChaine similariteChaine) {
		this.similariteChaine = similariteChaine;
	}



	public List<Boolean> getL() {
		return l;
	}



	public void setL(List<Boolean> l) {
		this.l = l;
	}



	

}
