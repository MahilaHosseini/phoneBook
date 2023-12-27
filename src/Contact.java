import java.util.ArrayList;
import java.util.List;

public class Contact {

    private String name;
    private List<String> numbers = new ArrayList<>();

    public Contact() {
    }

    public Contact(String name, List<String> numbers) {
        this.name = name;
        this.numbers = numbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public void addNumber(String number){
        this.numbers.add(number);
    }
}
