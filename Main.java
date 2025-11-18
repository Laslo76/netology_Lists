import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> toDoList = new ArrayList<>();

        List<String> commandList = new ArrayList<>();
        commandList.add("Выход из программы");
        commandList.add("Добавить дело");
        commandList.add("Показать дела");
        commandList.add("Удалить дело по номеру");
        commandList.add("Удалить дело по названию");
        commandList.add("Удалить дело по ключу");

        String strCommand;
        int numDo;
        while (true) {
            showListCommands(commandList);
            String command = scanner.nextLine();

            int keyCommand = -1;
            try {
                keyCommand = Integer.decode(command);
            } catch (Exception e) {
                System.out.println("Странная команда!");
                continue;
            }

            System.out.println();
            switch (keyCommand) {
                case (0):
                    return;
                case (1):
                    System.out.print("Введите название задачи: ");
                    strCommand = scanner.nextLine();
                    toDoList.add(strCommand);
                    System.out.println("Добавлено!");
                    break;
                case (2):
                    break;
                case (3):
                    System.out.print("Введите номер дела для удаления: ");
                    strCommand = scanner.nextLine();
                    numDo = Integer.decode(strCommand);
                    if ((numDo < 1) || (numDo > toDoList.size())) {
                        System.out.println("Нет дела под таким номером!");
                        break;
                    }
                    numDo--;
                    toDoList.remove(numDo);
                    System.out.println("Удалено!");
                    break;
                case (4):
                    System.out.print("Введите дело для удаления: ");
                    strCommand = scanner.nextLine();
                    numDo = toDoList.indexOf(strCommand);
                    if (numDo < 0) {
                        System.out.println("Дело для удаления не найдено!");
                        break;
                    }
                    toDoList.remove(numDo);
                    System.out.println("Удалено!");
                    break;
                case (5):
                    System.out.print("Введите ключевое слово названия дел для удаления: ");
                    strCommand = scanner.nextLine();
                    List<String> resultSearch = searchAll(toDoList, strCommand);
                    if (resultSearch.isEmpty()) {
                        System.out.println("Подходящих дел не обнаружено!");
                    } else {
                        toDoList.removeAll(resultSearch);
                        System.out.println("Подходящих дела удалены!");
                    }
                    break;
                default:
                    System.out.println("Неизвестная комманда!");
                    break;
            }
            showListToDo(toDoList);
        }
    }

    protected static void showListCommands(List<String> myCommands) {
        System.out.println("Выберите операцию:");
        showList(myCommands, false);
        System.out.print("Ваш выбор: ");
    }

    protected static void showListToDo(List<String> myCommands) {
        System.out.println("Ваш список дел:");
        showList(myCommands, true);
        System.out.println();
    }

    protected static void showList(List<String> showlist, boolean start) {
        int position = (start) ? 1 : 0;
        Iterator<String> iterator = showlist.iterator();
        while (iterator.hasNext()) {
            System.out.printf("%d. %s%n", position, iterator.next());
            position++;
        }
    }

    protected static List<String> searchAll(List<String> showList, String keyWord) {
        List<String> result = new ArrayList<>();
        for (String element : showList) {
            if (element.contains(keyWord)) {
                result.add(element);
            }
        }
        return result;
    }
}