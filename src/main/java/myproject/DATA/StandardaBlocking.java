package myproject.DATA;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;

public class StandardaBlocking implements BlockingStrategy<Workbook>{

public StandardaBlocking() {
super();
}

@Override
public Map<String,Workbook> BlockingData(Workbook data) {
// TODO Auto-generated method stub
return null;
}
}

