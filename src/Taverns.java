import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Taverns {

    private final List<String> persons = new ArrayList<>();

    public String getPerson(){
        Random random = new Random();
        return persons.get(random.nextInt(persons.size()));
    }

    public void addPersons(String[] persons) {
        this.persons.addAll(Arrays.asList(persons));
    }
}
