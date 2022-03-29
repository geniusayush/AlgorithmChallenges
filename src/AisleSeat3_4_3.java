import java.util.*;

public class AisleSeat3_4_3 {
    public static void main(String[] args) {
        System.out.println(new AisleSeat3_4_3().solution(1, "1A 1B 1E 1J "));
    }

    public int solution(int N, String S) {
        int result = 0;

        Map<Integer, List<Character>> allSeatMap = new HashMap<>();
        String[] splitted = null;
        if (S.trim().length() > 0) {
            splitted = S.split(" ");
            Arrays.stream(splitted).forEach(s -> addToMap(s, allSeatMap));
        }
        for (int i = 1; i <= N; i++) {
            List<Character> row = allSeatMap.get(i);
            if(row==null)row= new ArrayList<>();
            if (!row.contains('B') && !row.contains('C') && !row.contains('D') && !row.contains('E')) {
                result++;
                row.addAll(Arrays.asList('B', 'C', 'D', 'E'));
            }
            if (!row.contains('F') && !row.contains('G') && !row.contains('D') && !row.contains('E')) {
                result++;
                row.addAll(Arrays.asList('F', 'G', 'D', 'E'));
            }
            if (!row.contains('F') && !row.contains('G') && !row.contains('H') && !row.contains('J')) {
                result++;
                row.addAll(Arrays.asList('F', 'G', 'H', 'J'));
            }
        }
        return result;
    }

    private void addToMap(String s, Map<Integer, List<Character>> allSeatMap) {
        int row = Integer.parseInt(String.valueOf(s.charAt(0)));
        Character col = s.charAt(1);
        List<Character> rowL = new ArrayList<Character>();
        if (allSeatMap.containsKey(row)) {
            rowL = allSeatMap.get(row);
        }
        rowL.add(col);
        allSeatMap.put(row,rowL);
    }
}
