//Given N activities with their start and finish day given in array start[ ] and end[ ]. Select
//        the maximum number of activities that can be performed by a single person, assuming
//        that a person can only work on a single activity at a given day.
//        Note : Duration of the activity includes both starting and ending day.
//
//        Example 1:Consider the following 6 activities.
//        start[] = {0, 1, 3, 5, 8, 5}
//        end[] = {6, 2, 4, 7, 9, 9}
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Pair{
    int end;
    int start;
    int pos;
    Pair(int end, int start,int pos) {
        this.end = end;
        this.start = start;
        this.pos = pos;
    }
}
class meetingComparator implements Comparator<Pair>{
    @Override
    public int compare(Pair o1, Pair o2){
        if(o1.end < o2.end)
            return -1;
        else if (o1.end > o2.end)
            return 1;
        else if (o1.pos<o2.pos)
            return -1;
        return 1;
    }

}

public class Greedy1 {

    public static int maxMeetings(int[] start, int[] end, int n){
        ArrayList<Pair> meet = new ArrayList<>();
        for(int i=0; i<start.length; i++){
            meet.add(new Pair(end[i],start[i],i));
        }
        meetingComparator mc = new meetingComparator();
        Collections.sort(meet,mc);

        int count=1;

        int pos = meet.get(0).start;
        int limit  = meet.get(0).end;

        for(int i=1; i<start.length; i++){
            if(meet.get(i).start > limit){
                limit=meet.get(i).end;
                count++;
            }
        }
        return count;
    }
    public static void main(String []args) {
        int n = 6;
        int ans=0;
        int[] start = {1,3,0,5,8,5};
        int[] end  = {2,4,5,7,9,9};
        ans=maxMeetings(start,end,n);
        System.out.println(ans);
    }
}


//  start  -> 0 1 3 5 8 5
// end  -> 6 2 4 7 9 9


//pair - end,start
//sorted array -> {2,1  4,3  6,0  7,5  9,5  9,8}