package myproject.DATA;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;

public class HashBlocking implements BlockingStrategy<Workbook>{


public HashBlocking() {
super();

}

@Override
public Map<String, Workbook> BlockingData(Workbook data) {
System.out.print("HashBlocking");
return null;
}

}