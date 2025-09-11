import java.util.*;
public class Activity_Selection {

    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};
        int count = 1 ;

        int [][] activities = new int[end.length][3];
        for(int i = 0 ; i < end.length ; i++){
            activities[i][0] = i; //activity number
            activities[i][1] = start[i]; //start time
            activities[i][2] = end[i]; //end time
        }

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(activities[0][0]);

        int endtime = activities[0][2];
        for(int i = 1 ; i < end.length ; i++){
            if( activities[i][1] >= endtime){
                count++;
                ans.add(activities[i][0]);
                endtime = activities[i][2];
            }
        }
        System.out.println("Maximum activities that can be performed: " + count);
        System.out.println("Activities selected at index: " + ans);


    }
}