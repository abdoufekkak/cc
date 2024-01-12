package matching;

import java.util.List;

public class Naive implements FunctionMatching{
	List<List<String>> data;	
	MatchingStrategy matchingStrategy;
	public Naive(MatchingStrategy matchingStrategy,List<List<String>> data){
		this.matchingStrategy = matchingStrategy;
		this.data=data;
	}

	
	public List<List<String>> getData() {
		return data;
	}


	public void setData(List<List<String>> data) {
		this.data = data;
	}


	public MatchingStrategy getMatchingStrategy() {
		return matchingStrategy;
	}


	public void setMatchingStrategy(MatchingStrategy matchingStrategy) {
		this.matchingStrategy = matchingStrategy;
	}


	@Override
	public void matchung() {
		// TODO Auto-generated method stub
		for(int i=0;i<this.data.size();i++) {
			for(int j=i+1;j<this.data.size();j++) {
			Boolean x = this.matchingStrategy.Stratgie_choisi(this.data.get(i),this.data.get(j));
				if(x==true)
				{
					this.data.remove(j);
				}
			}
		}
	}

}
