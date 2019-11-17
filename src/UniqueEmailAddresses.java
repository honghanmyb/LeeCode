import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmail = new HashSet<>();
        for(String email: emails){
            uniqueEmail.add(convertEmail(email));
        }
        return uniqueEmail.size();
    }
    
    private String convertEmail(String email){
        int middleIndex = email.indexOf("@");
        String domainName = email.substring(middleIndex);
        String localName = email.substring(0, middleIndex);
        int plusIndex = localName.indexOf("+");
        if(plusIndex != -1){
            localName = localName.substring(0, plusIndex);
        }
        localName = localName.replaceAll("\\.", "");
        String convertedName = localName + domainName;
        return localName + domainName;
    }
}
