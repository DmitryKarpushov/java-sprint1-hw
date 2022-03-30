import java.util.Scanner;

public class StepTracker {

    public static int[][] monthToData = new int[12][30];// [месяц][день]
    private int Month;
    private int goalSteps = 10000;
    private int sumSteps;
    private int average;
    private Converter converter = new Converter();
    //Исправление
    private Scanner scanner;
    public StepTracker(Scanner scanner) {
        this.scanner = scanner;
    }


    void setStepTr() {
        System.out.println("Введите цель по количеству шагов за день");
        int numberSteps = scanner.nextInt();
        if (numberSteps >= 0) {
            goalSteps = numberSteps;
            System.out.println("Цель по шагам = " + goalSteps);
        } else {
            System.out.println("Введены неверные данные!");
        }

    }

    void saveDaySteps() {
        System.out.println("Введите месяц(начинаем с нуля) : ");
        Month = scanner.nextInt();
        System.out.println("Введите день(начинаем с нуля) : ");
        int day = scanner.nextInt();
        System.out.println("Введите количество шагов : ");
        int step = scanner.nextInt();
        if ((Month < 12 && Month >= 0) && (day < 30 && day >= 0) && (step > 0)) { //проверка на корректность данных
            monthToData[Month][day] = step;
            System.out.println("Количество шагов за данный день : " + monthToData[Month][day]);
        } else {
            System.out.println("Введены неверные данные!");
        }
    }

    void statisticSteps() {
        System.out.println("Укажите месяц за который хотите увидеть статистику: ");
        Month = scanner.nextInt();

        System.out.println("            Статистика: ");
        System.out.println("Количество пройденных шагов по дням за месяц: " + Month);
        for (int i = 0; i < monthToData[Month].length; i++) {
            if (monthToData[Month][i] != 0) { // если день без шагов не выводим
                System.out.print(i + " день : " + monthToData[Month][i] + ", ");
            }
        }
        System.out.println(" ");
        //------------------------------------------------------------------------------------------------
        for (int i = 0; i < monthToData[Month].length; i++) {
            sumSteps = sumSteps + monthToData[Month][i];
            if (monthToData[Month][i] != 0) {
                average++;
            }
        }
        System.out.println("Общее количество шагов за месяц : " + sumSteps);
        //------------------------------------------------------------------------------------------------
        int maxSteps = monthToData[Month][0];
        for (int i = 0; i < monthToData[Month].length; i++) {
            if (monthToData[Month][i] > maxSteps) {
                maxSteps = monthToData[Month][i];
            }
        }
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps);
        //------------------------------------------------------------------------------------------------
//      String result = String.format("%.2f",(sumSteps / average));
        if (sumSteps != 0 && average != 0) {
            System.out.println("Среднее количество шагов: " + (sumSteps / average));
        } else {
            System.out.println("Среднее количество шагов: 0");
        }
        //------------------------------------------------------------------------------------------------
        System.out.println("Пройденная дистанция (в км): " + converter.convertKM(sumSteps));
        //------------------------------------------------------------------------------------------------
        System.out.println("Количество сожжённых килокалорий: " + converter.convertCL(sumSteps) / 1000);
        //------------------------------------------------------------------------------------------------
        int maxLength = 0;
        int tempLength = 0;
        for (int i = 0; i <= monthToData[Month].length - 1; i++) {
            if ((monthToData[Month][i] >= goalSteps) && (monthToData[Month][i] != 0)) {
                tempLength++;
            } else {
                tempLength = 0;
            }

            if (tempLength > maxLength) {
                maxLength = tempLength;
            }
        }
        System.out.println("Лучшая серия: максимальное количество подряд идущих дней, " +
                "в течение которых количество шагов за день было равно или выше целевого: " + maxLength);
    }

} 