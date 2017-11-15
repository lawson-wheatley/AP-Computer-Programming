package util;
import math.Math;
import java.util.Arrays;
import java.util.Scanner;

import util.BoolYahtzee;
public class fiveDice {
	private static boolean[] Yahtzee;
	private static boolean[][] Bonus;
	private static boolean[] largeStraight;
	private static boolean[] smallStraight;
	private static boolean[] fullHouse;
	private static boolean[] fourOfKind;
	private static boolean[] threeOfKind;
	private static boolean[] ones;
	private static boolean[] twos;
	private static boolean[] threes;
	private static boolean[] fours;
	private static boolean[] fives;
	private static boolean[] sixes;
	private static boolean[] chance;
	private static int[] bonus;
	private static int[] total;
	private static int[] nums;
	private static int[] die = new int[]{0,0,0,0,0};
	private static boolean checka = false;
	private static int check = 0;
	private static Die dicer = new Die();

	private static int counter = 0;
	private static void dice (){
		int[] a = new int[]{0,1,2,3,4};
		roll(a);
		die = Math.sorter(die);
	}
	private static void roll(int[] rolla){
		for(int i = 0; i < rolla.length; i++){
			die[rolla[i]]=dicer.roll();
		}
		die=Math.sorter(die);
		counter++;
	}
	private static boolean areAllTrue(boolean[] aok){
		for(boolean b : aok)
			if(!b) return false;
	    return true;
	}
	public fiveDice(int players){
		players+=1;
		largeStraight=new boolean[players];
		Bonus = new boolean[players][3];
		smallStraight=new boolean[players];
		fullHouse=new boolean[players];
		fourOfKind=new boolean[players];
		threeOfKind=new boolean[players];
		ones=new boolean[players];
		twos=new boolean[players];
		threes=new boolean[players];
		fours=new boolean[players];
		fives=new boolean[players];
		sixes=new boolean[players];
		chance=new boolean[players];
		Yahtzee=new boolean[players];
		nums=new int[players];
		total=new int[players];
		Scanner scn = new Scanner(System.in);
		players-=2;
		int p = 0;
		while(!areAllTrue(new boolean[]{Yahtzee[players],largeStraight[players],smallStraight[players],fullHouse[players],threeOfKind[players],ones[players],twos[players],threes[players],fours[players],fives[players],sixes[players],chance[players]})){
		System.out.println("Current player: Player" + (p) + " Player score: " + total[p]);
		dice();
		System.out.println(die[0] + "," + die[1] + "," +die[2] + "," + die[3] + "," + die[4]);
		boolean mk = true;
		while(check <3){

			System.out.println("Do you want to reroll some dice?(y/n)");
			char rko = scn.nextLine().charAt(0);
			if(rko == 'y'){
				String[] ko = new String[]{"0","0","0","0","0"};
				System.out.println("Enter the ones you want to reroll (from 0 through 4, seperated by commas)");
				String line = scn.nextLine();
				ko = line.split(",");
				int[] ok = new int[]{0,0,0,0,0};
				for(int i = 0; i < ko.length; i++){
					ok[i]=Integer.parseInt(ko[i]);
				}
				roll(ok);
				check++;
				System.out.println(die[0] + "," + die[1] + "," +die[2] + "," + die[3] + "," + die[4]);
			} else if(rko=='n'){check=3;getPoints(players);break;} else{}
			if(check==3){
				break;
			}else{
				System.out.println("The total score is: " + (total[p]));
			}
		}
		if(p<players){
			p++;
		}else{
			p-=players;
		}
		check=0;
		}
		scn.close();
	}
	private static void getPoints(int p){
		System.out.println("Do you want 6's/5's/4's/3's/2's/1's  or do you want to just use chance (0), or yahtzee, or largeStriahgt, or smallStraight, or fullHouse, or fourOfKind, or threeOfKind to be added to your score card?(6/5/4/3/2/1) ");
		Scanner scn = new Scanner(System.in);
		String a = scn.nextLine();
		char mk = a.charAt(0);
		char ook = a.charAt(1);
		if((mk=='y' && ook=='a') &&BoolYahtzee.yahtzee(die) && (Yahtzee[p]==false || Bonus[p][2]==false)){
			if(Yahtzee[p] == true) {
				Yahtzee[p]=true;
				total[p]+=50;
			} else {
				Bonus[p][bonus[p]]=true;
				bonus[p]++;
				total[p]+=100;
			}
		}
		else if((mk=='l' && ook=='a') &&BoolYahtzee.largeStraight(die)&&largeStraight[p]==false){
			largeStraight[p]=true;
			total[p]+=40;
		}
		else if((mk=='s' && ook=='m') &&BoolYahtzee.smallStraight(die)&&smallStraight[p]==false){
			smallStraight[p]=true;
			total[p]+=30;
		} else if((mk=='f' && ook=='u') &&BoolYahtzee.fullHouse(die)&&fullHouse[p]==false){
			fullHouse[p]=false;
			total[p]+=25;
		} else if((mk=='f' && ook=='o') &&BoolYahtzee.fourOfKind(die) !=0 && fourOfKind[p]==false){
			fourOfKind[p]=true;
			total[p]+=BoolYahtzee.fourOfKind(die);
		} else if((mk=='t' && ook=='h') &&BoolYahtzee.threeOfKind(die) != 0 &&threeOfKind[p]==false){
			threeOfKind[p]=true;
			total[p]+=BoolYahtzee.threeOfKind(die);
		} else if(mk == '6' && sixes[p] == false){
				sixes[p]=true;
				nums[p]+=BoolYahtzee.sixes(die);
				total[p]+=BoolYahtzee.sixes(die);
		} else if(mk == '5' && fives[p] == false){
				fives[p]=true;
				nums[p]+= BoolYahtzee.fives(die);
				total[p]+=BoolYahtzee.fives(die);
		} else if(mk == '4' && fours[p] == false){
				fours[p]=true;
				nums[p]+=BoolYahtzee.fours(die);
				total[p]+=BoolYahtzee.fours(die);
		} else if(mk == '3' && threes[p] == false){
				threes[p]=true;
				nums[p]+=BoolYahtzee.threes(die);
				total[p]+=BoolYahtzee.threes(die);
		} else if(mk == '2' && twos[p] == false){
				twos[p]=true;
				nums[p]+=BoolYahtzee.twos(die);
				total[p]+=BoolYahtzee.twos(die);
		} else if(mk == '1' && ones[p] == false){
				ones[p]=true;
				nums[p]+=BoolYahtzee.ones(die);
				total[p]+=BoolYahtzee.ones(die);
		} else if(mk == '0' && chance[p] == false){
				chance[p]=true;
				total[p]+=die[0]+die[1]+die[2]+die[3]+die[4];

		} else{}
	}
}