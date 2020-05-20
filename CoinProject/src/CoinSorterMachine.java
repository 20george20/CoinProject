/**
 * @author 20george
 * @version 1/31/19
 * this class is a client class of the other classes
 * it uses the methods in the other classes to sort 
 * through the data in a text file and tell the user
 * how many of each coin is in it, how much total money
 * the coins add up to, and how much money they have in 
 * each coin. 
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;
public class CoinSorterMachine {
	private ArrayList<Coin> coins;
	private ArrayList<Coin> coinMap;
	private ArrayList<Double> num;
/**
 * constructor for the class initializes coins, coinMap, and num ArrayLists
 */
	public CoinSorterMachine() {
		coins = new ArrayList<Coin>();
		coinMap = new ArrayList<Coin>();
		num = new ArrayList<Double>();
		coinMap.add(new Penny());
		coinMap.add(new Nickel());
		coinMap.add(new Dime());
		coinMap.add(new Quarter());
		coinMap.add(new HalfDollar());		
		coinMap.add(new Dollar());
		num.add(.01);
		num.add(.05);
		num.add(.10);
		num.add(.25);
		num.add(.50);
		num.add(1.00);
		
	}
/**
 * uses a scanner object to prompt the user for the text file name and imports
 * the data from the filename and puts it into the ArrayList coins
 */
	public void depositCoins() {
		Scanner in = new Scanner(System.in);
		String filename;
		System.out.print("Enter the name of the data file for coin deposit: ");
		filename = in.nextLine();
		try {
			in = new Scanner(new File(filename));
			while(in.hasNext()) {
				coins.add(makeCoin(in.nextInt()/100.));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
/**
 * prints deposit summary using a DecimalFormat object
 */
	public void printDepositSummary() {
		double total = 0.0;
		DecimalFormat money = new DecimalFormat("$0.00");
		System.out.println("Depositing coins...");
		System.out.println("Summary of deposit: ");
		for(int i = 0; i < num.size(); i++) {
			if(numOfCoins(num.get(i)) != 1)
				System.out.print("\t" + numOfCoins(num.get(i)) + " " + coinMap.get(i).getPluralName() + " ");
			else
				System.out.print("\t" + numOfCoins(num.get(i)) + coinMap.get(i).getName() + " ");
			System.out.println(money.format(numOfCoins(num.get(i)) * num.get(i)));
			total += (numOfCoins(num.get(i))) * (num.get(i));
			}
		System.out.print("TOTAL DEPOSIT: " + money.format(total));
	}
/**
 * @return a double of the total amount of money stored in coins
 */
	public double getTotalValue() {
		double sum = 0;
		for(Coin c : coins) {
			sum += (Double)c.getValue();
		}
		return sum;
	} 
/**
 * main method for the class
 * @param args
 */
	public static void main(String[] args){
		CoinSorterMachine app = new CoinSorterMachine(); 
		app.depositCoins();
		app.printDepositSummary();
	}
	private Coin makeCoin(double value) {
		Double v = value;
		for(Coin c : coinMap) {
			if(v.equals((Double)(c.getValue()))){
				return c;
			}
		}
		return null;
	}
	private int numOfCoins(double value) {
		int count = 0;
		Double v = value;
		for(Coin c : coins) {
			if(v.equals((Double)(c.getValue()))){
				count++;
			}
		}
		return count;
	}
}
//end of class CoinSorterMachine
