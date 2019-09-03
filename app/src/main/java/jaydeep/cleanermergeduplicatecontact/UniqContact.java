package jaydeep.cleanermergeduplicatecontact;

import java.util.ArrayList;

public class UniqContact {

    String name;
    ArrayList<String> nos;

    public UniqContact(String name, ArrayList<String> nos) {
        this.name = name;
        this.nos = nos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getNos() {
        return nos;
    }

    public void setNos(ArrayList<String> nos) {
        this.nos = nos;
    }
}
