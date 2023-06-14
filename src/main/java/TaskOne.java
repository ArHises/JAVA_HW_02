public class TaskOne {
    public static void main(String[] args) {
//        1)
//        Дана строка sql-запроса "select * from students where ".
//        Сформируйте часть WHERE этого запроса, используя StringBuilder.
//        Данные для фильтрации приведены ниже в виде json-строки.
//        Если значение null, то параметр не должен попадать в запрос.
//        Параметры для фильтрации:
//        {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

        String sqlRequest = "select * from students where ";
        String jsonData = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\", \"gender\":\"male\"}";
        System.out.println(sqlRequest + whereFunction(jsonData));
    }
    static public String whereFunction(String jsonData){
        StringBuilder newData = new StringBuilder();

        jsonData = jsonData.trim();
        jsonData = jsonData.substring(1,jsonData.length()-1);
        jsonData = jsonData.replaceAll("\"","\'");
        jsonData = jsonData.replaceAll(":","=");
        jsonData = jsonData.replaceAll(",","");
        String[] jsonArr = jsonData.split(" ");

        for (String item: jsonArr) {
            if(!item.substring(item.indexOf('=') + 2, item.length() - 1).equals("null")){
                newData.append(item.substring(1, item.indexOf('=') - 1));
                newData.append(item.substring(item.indexOf('=')));
                newData.append(' ');
            }
//            System.out.println(newData.toString());
        }
        return newData.toString();
    }

}
