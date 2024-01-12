package myproject.DATA;

import java.util.List;
import java.util.Map;

public class DataFilter<T> {
BlockingStrategy<T> bs;

public DataFilter() {

}
public BlockingStrategy<T> getBs() {
return bs;
}
public void setBs(BlockingStrategy<T> bs) {
this.bs = bs;
}
public Map<String, T> applyBlockingStrategy(T data) {
return bs.BlockingData(data);
}
}
