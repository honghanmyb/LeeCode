import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

public class RepeatedDNASequence {
	public List<String> findRepeatedDnaSequence(String s){
		HashSet<String> repeatedTable = new HashSet<>();
		HashSet<String> resultTable = new HashSet<>();
		int beginIndex = 0;
		int endIndex = 10;
		while(endIndex < s.length()) {
			String key = s.substring(beginIndex++, endIndex++);
			if(!repeatedTable.add(key)) {
				resultTable.add(key);
				continue;
			}
			
			repeatedTable.add(key);
		}
		List<String> repeatedDnaSequence = new ArrayList<>();
		repeatedDnaSequence.addAll(resultTable);

		return repeatedDnaSequence;
	}
}
