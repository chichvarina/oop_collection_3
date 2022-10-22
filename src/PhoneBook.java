import java.util.HashMap;
import java.util.Map;
public class PhoneBook {

    private final Map<String, String> phoneMap;

    public PhoneBook(Map<String, String> phoneMap) {
        if(phoneMap==null) {
            this.phoneMap = new HashMap<>();
        }else {
            this.phoneMap = phoneMap;
        }
    }

    public Map<String, String> getPhoneMap() {
        return phoneMap;
    }

    @Override
    public String toString() {
        String s = "";
        for (Map.Entry<String, String> entry : phoneMap.entrySet()) {
            String key = entry.getKey();//ФИО
            String value = entry.getValue(); //телефон
            s= s + key+", телефон "+value+"\n";
        }
        return s;
    }
}
