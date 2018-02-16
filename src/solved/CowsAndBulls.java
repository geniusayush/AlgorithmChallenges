package solved;

import java.util.HashMap;
import java.util.Map;

public class CowsAndBulls {
    static String[] findNumberOfCowsAndBulls(Map<String, String> userInput) {
        String[] ans = new String[userInput.size()];
        int v = 0;
        for (String s : userInput.keySet()) {
            char[] number = userInput.get(s).toCharArray();
            char ss[] = s.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < 4; i++) {
                map.put(ss[i], i);
            }
            int bulls = 0, cow = 0;
            for (int i = 0; i < 4; i++) {
                if (map.containsKey(number[i])) {
                    if (map.get(number[i]) == i) bulls++;
                    else cow++;
                }
            }
            ans[v] = bulls + "-Bulls," + cow + "-Cows";
            v++;

        }
        return ans;
    }
}
