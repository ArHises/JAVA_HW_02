
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TaskTwo {
    public static void main(String[] args) throws IOException {
//        2)
//        Реализуйте алгоритм сортировки пузырьком числового массива,
//        результат после каждой итерации запишите в лог-файл.

        int[] arr = {5, 4, 3, 2, 1};
        Logger log = Createlogger();
        bubbleSortTolog(arr, log);
    }
    public static Logger Createlogger() throws IOException {
        Logger log = Logger.getLogger(TaskTwo.class.getName());
        try {
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("/logFile.txt");
            File file = new File(pathFile);
            if (file.createNewFile()) {
                System.out.println("file.created");
            }
            else {
                System.out.println("file.existed");
            }
        } catch (Exception e) {
            System.out.println("Some ERROR");
        } finally {
            FileHandler fh = new FileHandler("logFile.txt");
            SimpleFormatter sf = new SimpleFormatter();
            fh.setFormatter(sf);
            log.addHandler(fh);
        }
        return log;
    }
    public static void bubbleSortTolog(int[] arr,Logger log) {
        int temp;
        log.info(ArrayToString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    log.info(arr[j] + " changed with " + arr[j+1]);
                }
            }
        }
        log.info(ArrayToString(arr));
    }
    public static String ArrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num + " ");
        }
        return sb.toString();
    }
}
