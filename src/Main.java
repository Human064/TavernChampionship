import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<String> personsList = new ArrayList<>();
    private static Taverns taverns = new Taverns();
    private static Map<Integer, Boolean> tavernsChoose = new HashMap<>();

    static {
        for (int i = 1; i <= 7; i++) {
            tavernsChoose.put(i, false);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        PreparePersons(reader);

        DecksSelection(reader);
    }

    private static void DecksSelection(BufferedReader reader) throws IOException {
        System.out.println("Количество игроков числом:");
        int countPeople = Integer.parseInt(reader.readLine()), i = 0;

        while (i < countPeople) i = getChange(reader, i);
    }

    private static void PreparePersons(BufferedReader reader) throws IOException {
        System.out.println("Введите номера таверн в одну строку через пробел!");
        int numTavern;
        String[] input = reader.readLine().split(" ");

        for (String num : input) {
            numTavern = Integer.parseInt(num);
            if (numTavern > 7 || numTavern < 1) {
                System.out.println("Таверны под номером " + numTavern + " нет!");
                continue;
            }

            tavernsChoose.put(numTavern, true);
        }
        SetPersonsList();
    }

    private static void SetPersonsList() {
        for (Map.Entry<Integer, Boolean> entry : tavernsChoose.entrySet()) {
            if (!entry.getValue()) continue;
            switch (entry.getKey()) {
                case 1:
                    taverns.addPersons(new String[]{"Волшебник Зот", "Жрица Дейдре", "Герки Ловкач", "Фиона Вспыльчивая"});
                    break;
                case 2:
                    taverns.addPersons(new String[]{"Иллюзионистка Ева", "Бард Флэк", "Дворф Димли", "Полуогр Гог"});
                    break;
                case 3:
                    taverns.addPersons(new String[]{"Инженер Визгиль", "Тролль Френк", "Пикси Кейлин", "Паладинша Серена"});
                    break;
                case 4:
                    taverns.addPersons(new String[]{"Капитан Уайтхоук", "Старпом Реми", "Боцман Брин", "Штурман Тара"});
                    break;
//                case 5:
//                    taverns.addPersons(new String[]{"Волшебник Зот", "Жрица Дейдре", "Герки Ловкач", "Фиона Вспыльчивая"});
//                    break;
//                case 6:
//                    taverns.addPersons(new String[]{"Волшебник Зот", "Жрица Дейдре", "Герки Ловкач", "Фиона Вспыльчивая"});
//                    break;
                case 7:
                    taverns.addPersons(new String[]{"Варторн Рыжебров", "Вышибала Джаспер", "Конюх Молли", "Девка Оливия"});
                    break;
            }
        }
    }

    private static int getChange(BufferedReader reader, int counter) throws IOException {
        String first = taverns.getPerson(), second = taverns.getPerson();

        while (personsList.contains(first)) first = taverns.getPerson();
        while (personsList.contains(second) || second.equals(first)) second = taverns.getPerson();

        System.out.println(first + " или " + second);

        System.out.println("Кого выбрали?");
        System.out.println("1 - " + first);
        System.out.println("2 - " + second);
        System.out.println("0 - Ре рол");

        switch (Integer.parseInt(reader.readLine())) {
            case 1:
                personsList.add(first);
                break;
            case 2:
                personsList.add(second);
                break;
            case 0:
                return counter;

        }

        return counter + 1;

    }
}