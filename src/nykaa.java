public class nykaa {
    Hi Ayush
    hi

    your rle within the team,
    thge challenges that you face, and the next set of goals
    stream of integers find median
    take 2 heap.

    my email is geniusayush@gmail.com

1 7 3 5 2 4

    getMedian(int number,HEap h1,Heap h2,int currM){
        if(h1.sie==h2.size){
            if(number<median)// let treel
            {
                h1.insert(number);
                m=h1.getTop();
            }
            else{
                // add it to the second heap in same way
            }
        }
        else if(h1.sie>h2.size){
            if(number<median)// let treel // go to the 1st heap
            {
                h2.insert(h1.removeTTop());
                h1.insert(number);

            }
            else{
                h2.insert(number);
            }
            m=Average(h1.top,h2.top);
        }
        else{
            if(number>median)// let treel // go to the 1st heap
            {
                h1.insert(h2.removeTTop());
                h2.insert(number);

            }
            else{
                h1.insert(number);
            }
            m=Average(h1.top,h2.top);
        }

    }
