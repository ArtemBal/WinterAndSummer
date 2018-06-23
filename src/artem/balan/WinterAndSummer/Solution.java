package artem.balan.WinterAndSummer;

public class Solution {

    private int solution(int[] T, int endOfWinter){

        int [] arrWinter = new int[endOfWinter];
        int [] arrSummer = new int[T.length - endOfWinter];

        System.arraycopy(T, 0, arrWinter, 0, endOfWinter);
        System.arraycopy(T, endOfWinter, arrSummer, 0, T.length - endOfWinter);

        int minSummer = arrSummer[0];
        int maxWinter = arrWinter[0];
        int possibleEndOfWinter = arrWinter.length + 1;

        for(int i = 0; i < arrWinter.length; i++ ) {
            if(arrWinter[i] > maxWinter) {
                maxWinter = arrWinter[i];
            }
        }
        for(int i = 0; i < arrSummer.length; i++ ) {
            if(arrSummer[i] < minSummer) {
                minSummer = arrSummer[i];
                possibleEndOfWinter = i + endOfWinter + arrWinter.length;
            }
        }

        if(maxWinter < minSummer) return arrWinter.length;
            return solution(T, possibleEndOfWinter);

    }

    public static void main (String[] args)
    {
        int [] arr = {5, -2, 3, 8, 6};
        Solution sol = new Solution();
        System.out.println(sol.solution(arr, 1));
    }
}
