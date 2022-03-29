import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class PhoneBillVerify {


    public static void main(String[] args) {
        System.out.println(new PhoneBillVerify().solution("00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:00,400-234-090"));
    }

    public int solution(String s) {
        // write your code in Java SE 8
        if (s.length() == 0) return 0;
        HashMap<String, Costs> map = new HashMap<>();
        String[] lines = s.split("\n");
        AtomicReference<String> mPhone = new AtomicReference<>();
        AtomicLong mTime = new AtomicLong();
        mTime.set(Long.MIN_VALUE);
        Arrays.stream(lines).forEach(entry -> {
            String[] lol = entry.split(",");
            long time = getTime(lol[0]);
            String phone = lol[1];
            long cost = getCost(time);
            Costs costObject = new Costs();
            if (map.containsKey(phone)) {
                costObject = map.get(phone);
            }
            long totTime = costObject.add(time, cost);
            if (totTime > mTime.get() || (totTime == mTime.get() && mPhone.get().compareTo(phone) < 0)) {
                mTime.set(totTime);
                mPhone.set(phone);
            }
            map.put(phone, costObject);
        });
        map.remove(mPhone.get());
        return (int) map.values().stream().mapToLong(ss -> ss.cost).sum();


    }

    private long getCost(long time) {
        if (time < 300)
            return 3 * time;
        else return (long) (150 * Math.ceil((double) time / 60));
    }

    private long getTime(String time) {
        String[] wa = time.split(":");
        return (long) (Integer.parseInt(wa[2]) + 60 * Integer.parseInt(wa[1]) + 3600 * Integer.parseInt(wa[0]));
    }

    private class Costs {
        long cost;
        long totalTime;

        public long add(long time, long cost) {
            this.cost += cost;
            totalTime += time;
            return totalTime;
        }
    }
}
