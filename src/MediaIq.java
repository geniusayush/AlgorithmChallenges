import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/*[2,5] [3,6] [7,10]
        [2,10]


        brute force
        o(n2)
        1 compare with all of they can be merged merew them
// sort them on basis on therir start times
*/
class Interval {
    int start; int end;

    public Interval(Integer start, Integer end) {
    }
}// we can set it ourselves or assume it to be provided

class mediaiq {
    public Interval merge(Interval one, Interval two) {

        if(two.start>one.end)return two;
        else if(one.end>two.end)return one;
        else return new Interval(one.start, two.end);


}

    public Stack<Interval> merge(Interval[] arr) {
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) (((Interval) o1).start)).compareTo((Integer) (((Interval) o2).start));
            }
        });


//array is sorted
        Stack<Interval> stack = new Stack<>();//  we are converting the array to the new Structure

        for (Interval a : arr) {
            if (stack.isEmpty()) {
                stack.push(a);
            } else {
                Interval old = stack.pop();
                Interval newI = merge(old, a);
                if (newI == a) {
                    stack.push(old);
                    stack.push(a);
                } else if (newI == old) {
                    stack.push(old);
                } else stack.push(newI);
            }
        }
// we have all sorted intervcals in stack

// 2 5  3,4

// 2, 5 7 8
// 2 5 3 8  2,8


// to reverse the order use a second stack and pop elements from 1st to second and then pop from second to print the data to get it in soprted order
/*


        ===========================================
        sync lock
        queue obkiect that we are `having can be inside a syncrnus method or a snc\hronous block
        snchnozied add(){
//anytime someone icomes here it acquired a lo0ck onto the queue and the other thread will be put on wait
        while(queue.isFull()){wait();}
        queue.add(data);
        notify();

        }
        snchnozied get(){
//anytime someone icomes here it acquired a lo0ck onto the queue and the other thread will be put on wait
        while(queue.isEmpty()){wait();}
        queue.poll(data);
        notify();
        }
*/
    return stack;
    }}



























