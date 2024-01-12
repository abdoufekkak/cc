package myproject.DATA;

import java.util.List;
import java.util.Map;


public interface BlockingStrategy<T> {
public Map<String, T> BlockingData(T data);
}