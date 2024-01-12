package myproject.DATA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.poi.ss.usermodel.Workbook;

public class QGramsBlocking implements BlockingStrategy<Workbook> {

private int q;

public QGramsBlocking() {
super();
}

// Setter for q
public void setQ(int q) {
this.q = q;
}

// Getter for q
public int getQ() {
return this.q;
}

@Override
public Map<String, Workbook> BlockingData(Workbook profile) {
Map<String, Workbook> blocks = new HashMap<>();

// Choose relevant attributes for Q-grams (you may need to customize this based on your Workbook structure)
String blockingKey = calculateBlockingKey(profile.toString(), this.q);

// Add the profile to the block corresponding to its blocking key
blocks.put(blockingKey, profile);

return blocks;
}

// Calculate Q-grams blocking key for an attribute (in this case, we use the toString representation of the Workbook)
private String calculateBlockingKey(String attribute, int q) {
Set<String> qGrams = generateQGrams(attribute, q);
return String.join("-", qGrams); // Concatenate Q-grams with a separator
}

// Generate Q-grams for a string
private Set<String> generateQGrams(String str, int q) {
Set<String> qGrams = new HashSet<>();
for (int i = 0; i <= str.length() - q; i++) {
qGrams.add(str.substring(i, i + q));
}
return qGrams;
}
}