package git;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParkingSystem implements IParking,IParams{
	Integer big,medium,small;
	ParkingSystem(Integer big,Integer medium,Integer small){
		this.big=big;
		this.medium=medium;
		this.small=small;
	}
	public boolean addCar(Integer carType) {
		if(carType==1&&big>0) {
			big--;
			return true;
		}
		if(carType==2&&medium>0) {
			medium--;
			return true;
		}
		if(carType==3&&small>0) {
			small--;
			return true;
		}
		return false;
	}
	public  String[] parse(String s)throws Exception{
		String regex1="\\[[1|2|3]\\]";
		Pattern p1=Pattern.compile(regex1);
		Matcher m1=p1.matcher(s);
		ArrayList<String> a=new ArrayList<String>();
		while(m1.find()) {
			String str=m1.group();
			String regex2="[1|2|3]";
			Pattern p2=Pattern.compile(regex2);
			Matcher m2=p2.matcher(str);
			while(m2.find()) {
				a.add(m2.group());
			}
		}	
		String f[]=new String[a.size()];
		for(int i=0;i<a.size();i++) {
			f[i]=a.get(i);
		}
		return f;
	};
	public int getBig() {
		return this.big;
	}
	public int getMedium() {
		return this.medium;
	}
	public int getSmall() {
		return this.small;
	}
	public ArrayList<Integer> getPlanPaking(String s[]){
		ArrayList<Integer> a=new ArrayList<Integer>();		
		for(int j=0;j<s.length;j++) {
			int n=Integer.parseInt(s[j]);
			a.add(n);
		}		
		return a;
	}
	public void print(ArrayList<Integer> plan) {
		for(int i=0;i<plan.size();i++) {
			System.out.print(i==plan.size()-1?addCar(plan.get(i)):addCar(plan.get(i))+",");
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner input=new Scanner(System.in);
		String s=input.nextLine();
		ParkingSystem ps=new ParkingSystem(1,1,0);
		String []st=ps.parse(s);
		ArrayList<Integer> plan=ps.getPlanPaking(st);
		ps.print(plan);
	}
}
