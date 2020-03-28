import java.util.ArrayList;
import java.util.Scanner;

public class main
{
        public static void main(String[] args)
        {
            ArrayList<String> todoList = new ArrayList<>();
            System.out.println("Для получения информации о возможных командах введите HELP.");

            for (;;)
            {
                System.out.println("Введите команду: ");
                Scanner scanner = new Scanner(System.in);
                String string = scanner.nextLine().trim();
                String command =((string.length() - string.replaceAll("\\s", "").length() == 0) ? string : string.substring(0, string.indexOf(' ')));
                String value;

                if (command.equals("ADD")) {
                    value = string.substring(string.indexOf(' ')).trim();
                    if (Character.isDigit(value.charAt(0)))
                    {
                        int count = Integer.parseInt(value.substring(0, value.indexOf(' ')).trim()) - 1;
                        value = value.substring(value.indexOf(' ')).trim();
                        if (count < todoList.size()){
                            todoList.add(count, value);
                        }
                        else {todoList.add(value);}
                    }
                    else {
                        todoList.add(value);
                    }
                    System.out.println("Дело добавлено!");
                } else if (command.equals("LIST")) {
                    for (int i = 0; i < todoList.size(); i++){
                        System.out.println(i + 1 + " - " + todoList.get(i));
                    }

                } else if (command.equals("EDIT")) {
                    value = string.substring(string.indexOf(' ')).trim();
                    int count = Integer.parseInt(value.substring(0, value.indexOf(' ')).trim()) - 1;
                    value = value.substring(value.indexOf(' ')).trim();
                    if (count < todoList.size()){
                        todoList.remove(count);
                        todoList.add(count, value);
                        System.out.println("Дело изменено!");
                    }
                    else {
                        System.out.println("Вы ввели неправильную команду!");
                    }

                } else if (command.equals("DELETE")) {
                    value = string.substring(string.indexOf(' ')).trim();
                    int count = Integer.parseInt(value) - 1;
                    if (count < todoList.size()) {
                        todoList.remove(count);
                        System.out.println("Дело удалено!");
                    } else {
                        System.out.println("Вы ввели неправильную команду!");
                    }
                }
                    else if (command.equals("HELP"))
                    {
                        System.out.println("LIST - выводит дела с их порядковыми номерами. ADD - добавляет дело в конец списка или дело на определённое место, если указать номер. EDIT - заменяет дело с указанным номером. DELETE - удаляет дело.");

                }
                    else {
                    System.out.println("Вы ввели неправильную команду!");
                }
            }
        }


}
