package util;

public class BoolYahtzee {
	public static int totala(int[]h){
		return sixes(h)+fives(h)+fours(h)+threes(h)+twos(h)+ones(h);
	}
	public static boolean yahtzee(int[]h){
		return(h[0]==h[4]);
	}
	public static boolean largeStraight(int[]h){
		return((one(h) && two(h) && three(h) && four(h) && five(h)) || (two(h) && three(h) && four(h) && five(h) && six(h)));
	}
	public static boolean smallStraight(int[]h){
		return((one(h) && two(h) && three(h) && four(h)) || (two(h) && three(h) && four(h) && five(h)) || (three(h) && four(h) && five(h) && six(h)));
	}
	public static boolean fullHouse(int[] h){
		return ((h[0] == h[1] && h[2] == h[4]) || (h[0]==h[2] && h[3]==h[4]));
	}
	public static int fourOfKind(int[] h){
		if((h[0]==h[3]) || h[1]==h[4]) {
			return (h[0] + h[1] + h[2] + h[3] + h[4]);
		}else {
		return 0;
		}
	}
	public static int threeOfKind(int[] h){
		if((h[0]==h[2] || h[1]==h[3] || h[2]==h[4] )) {
			return (h[0] + h[1] + h[2] + h[3] + h[4]);
		}else {
		return 0;
		}
	}
	public static int sixes(int[] h){
		int tot = 0;
		for(int i = 0; i < h.length; i++){
			if(h[i]==6){
				tot += 6;
			}
		}
		return tot;
	}
	public static int fives(int[] h){
		int tot = 0;
		for(int i = 0; i < h.length; i++){
			if(h[i]==5){
				tot += 5;
			}
		}
		return tot;
	}
	public static int fours(int[] h){
		int tot = 0;
		for(int i = 0; i < h.length; i++){
			if(h[i]==4){
				tot += 4;
			}
		}
		return tot;
	}
	public static int threes(int[] h){
		int tot = 0;
		for(int i = 0; i < h.length; i++){
			if(h[i]==3){
				tot += 3;
			}
		}
		return tot;
	}
	public static int twos(int[] h){
		int tot = 0;
		for(int i = 0; i < h.length; i++){
			if(h[i]==2){
				tot += 2;
			}
		}
		return tot;
	}
	public static int ones(int[] h){
		int tot = 0;
		for(int i = 0; i < h.length; i++){
			if(h[i]==1){
				tot += 1;
			}
		}
		return tot;
	}
	private static boolean one(int[] h) {
		return(h[0] == 1 || h[1]==1 || h[2]==1 || h[3]==1 || h[4]==1);
	}
	private static boolean two(int[] h) {
		return(h[0] == 2 || h[1]==2 || h[2]==2 || h[3]==2 || h[4]==2);
	}
	private static boolean three(int[] h) {
		return(h[0] == 3 || h[1]==3 || h[2]==3 || h[3]==3 || h[4]==3);
	}
	private static boolean four(int[] h) {
		return(h[0] == 4 || h[1]==4 || h[2]==4 || h[3]==4 || h[4]==4);
	}
	private static boolean five(int[] h) {
		return(h[0] == 5 || h[1]==5 || h[2]==5 || h[3]==5 || h[4]==5);
	}
	private static boolean six(int[] h) {
		return(h[0] == 6 || h[1]==6 || h[2]==6 || h[3]==6 || h[4]==6);
	}
}
