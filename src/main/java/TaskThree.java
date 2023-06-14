import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TaskThree {
    public static void main(String[] args) throws IOException {
//            3)
//            Дана json-строка (можно сохранить в файл и читать из файла)
//                    [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
//                    {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
//                    {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//            Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//            Пример вывода:
//              Студент Иванов получил 5 по предмету Математика.
//              Студент Петрова получил 4 по предмету Информатика.
//              Студент Краснов получил 5 по предмету Физика.

        File file = CreateFile();
        StringBuilder data = new StringBuilder();
        System.out.println(parseJson(data, file.getName()));

    }
    public static String parseJson(StringBuilder sb, String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        String sData = sb.toString();

        sData = sData.replace("\"", "");
        sData = sData.replace("{", "");
        sData = sData.replace("}", "");

        String[] jsonArr = sData.split(String.valueOf(sb.charAt(sb.indexOf(","))));
        sb.delete(0,sb.length());

        for (String line : jsonArr ) {
            if(!isNull(line.substring(line.indexOf(":") + 1)) && line.substring(0, line.indexOf(":")).equals("фамилия")){
                sb.append("Student ").append(line.substring(line.indexOf(":") + 1)).append(" ");
            }
            else if(!isNull(line.substring(line.indexOf(":") + 1)) && line.substring(0, line.indexOf(":")).equals("оценка")){
                sb.append("got grate ").append(line.substring(line.indexOf(":") + 1)).append(" ");
            }
            else if(!isNull(line.substring(line.indexOf(":") + 1)) && line.substring(0, line.indexOf(":")).equals("предмет")){
                sb.append("in subject ").append(line.substring(line.indexOf(":") + 1)).append(".");
            }

        }
        ArrayToString(jsonArr);

        return sb.toString();
    }
    public static boolean isNull(String str) {
        return str == null || str.equals("null");
    }
    public static File CreateFile() throws IOException {

        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat("/students.txt");
        File file = new File(pathFile);

        if (file.createNewFile()) {
            System.out.println("file.created");
        }
        else {
            System.out.println("file.existed");
        }
        return file;
    }
    public static String ArrayToString(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (String line : arr) {
            sb.append(line + " ");
        }
        return sb.toString();
    }
}
