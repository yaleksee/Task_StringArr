import java.util.*;
import java.util.stream.Collectors;


public class Task {
    private final static String[] STRINGS = {"abc", "bac", "abc", "d", "et", "d", "et", "zzz"};
    private static LinkedHashMap<String, ArrayList<Integer>> orderMapFromArray = new LinkedHashMap<>();

    public static void main(String[] args) {
        Task task = new Task();
        orderMapFromArray = task.toConvert(STRINGS);
        task.print(orderMapFromArray);
    }

    public LinkedHashMap<String, ArrayList<Integer>> toConvert(String[] data) {

        LinkedHashMap<String, ArrayList<Integer>> dataList = new LinkedHashMap<>();

        if(data.length!=0) {
            for (int i = 0; i < data.length; i++) {

                String sortedString = getSortedCharsFromString(data[i]);

                if (dataList.containsKey(sortedString)) {
                    dataList.get(sortedString).add(i);
                } else {
                    dataList.put(sortedString, new ArrayList<Integer>(Arrays.asList(i)));
                }
            }
        }
        return dataList;
    }

    private String getSortedCharsFromString(String string) {

        char[] chars = string.toCharArray();;
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    private String format(List<Integer> integers) {

        String result = "";
        for (int i = 0; i < integers.size(); i++) {
            if (!result.isEmpty()) {
                result = result + ",";
            }
            result = result + integers.get(i);
        }
        return result;
    }

    private void print(LinkedHashMap<String, ArrayList<Integer>> dataList) {
        dataList.entrySet().stream()
                .filter(p ->  p.getValue().size()>1)
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()))
                .forEach((key, value) -> System.out.println(key + " число совпадений = " + format(value)));
    }
}