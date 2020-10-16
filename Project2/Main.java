package Project2;

public class Main {

	public static void main(String args[]) {
		//Object called report calls the functions in the report class
		//Originally called report
		Report report = new Report();
		report.loadData();
		report.printHighestScore();

		//report.printSortedSkaterList();
		report.printHighestSP();
		report.printHighestLP();
		report.printHighestEP();
		report.printHighestPC();


		report.printUSA();

		// obj.printSortedSkaterList();
		// obj.printHighestSP()
		// ....
		
	}
	
}
