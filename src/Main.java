import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu(); //для вывода один раз (так же идея выводить меню по выбору пользолателя)
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            //printMenu(); //для вывода меню после каждого действия
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    stepTracker.saveDaySteps();
                    break;
                case 2:
                    stepTracker.statisticSteps();
                    break;
                case 3:
                    stepTracker.setStepTr();
                    break;
                case 4:
                    System.out.println("Выход из приложения!");
                    scanner.close();
                    return;
                case 5:
                    printMenu();
                    break;
                default:
                    System.out.println("Введена неверная команда!");
                    printMenu();
                    break;
            }
        }
    }
    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
        System.out.println("5 - Вывести меню");
    }
}
