package Project2;

public class Report {
	//Calls the FileInput class and creates with the "path"
	String path = ("fsdata.txt");
	private FileInput inFile = new FileInput(path);

	//Creates a list for all the skater, by creating an object that calls to the
	//Skater class
	private Skater skaterList[] = new Skater[50];
	//Number of skaters
	private int nSkaters=0;

	//Prints all the skaters
	private void printSkaterList() {

		//For loop that runs through all 50
		for (int i=0; i< nSkaters; i++ ) {
			//calls the
			System.out.println(skaterList[i].getName() +"\t" +
		                       skaterList[i].getClub() +"\t" +
							   skaterList[i].getShortProgram()+"\t" +
							   skaterList[i].getLongProgram() +"\t" +
							   skaterList[i].getExecuteElement() +"\t" +
							   skaterList[i].getProgramComponent()+"\t" +
							   skaterList[i].getTotal()+"\t"

								);

		}
	}
	
	//Loads all the data
	public void loadData() {
		String buffer = inFile.readFromFile();
		int i=0;
		while (buffer != null) {
			String name, club;
			//sp:ShortProgram, lp:Long Program, ex:Execute Element(Athletic), pc:Program Component(Artistic)
			double sp, lp, ex, pc;
			//The length of the columns inside the text file
			 name = buffer.substring(0,21);
			 club = buffer.substring(21,47);
			//trimming because it's a text file not a csv
			 sp   = Double.parseDouble(buffer.substring(47,54).trim());
			 lp  = Double.parseDouble(buffer.substring(54,62).trim()); // need to change similar to sp
			 ex  = Double.parseDouble(buffer.substring(69,74).trim()); // need to change similar to sp
			 pc  = Double.parseDouble(buffer.substring(62,69).trim()); // need to change similar to sp
			skaterList[i] = new Skater(name, club, sp, lp, ex,pc);
			i++;
			buffer = inFile.readFromFile();
		}
		nSkaters = i;
		printSkaterList();
	}

	public void printSortedSkaterList(){
	}
	double highestScore=0;
	String highestScoreName;
	public void printHighestScore() {
		for (int a = 0; a < nSkaters; a++) {
			if (highestScore < skaterList[a].getTotal())
			{
				highestScore = skaterList[a].getTotal();
				highestScoreName= skaterList[a].getName();
			}
		}
		System.out.printf("The Winner is: %s with %.2f Points! \n",highestScoreName.trim(), highestScore);
	}

	double highestSP=0;
	String highestSPName;
	public void printHighestSP() {
		for (int a = 0; a < nSkaters; a++) {
			if (highestSP < skaterList[a].getShortProgram())
			{
				highestSP = skaterList[a].getShortProgram();
				highestSPName=skaterList[a].getName();
			}
		}
			System.out.printf("Winner of the Short Program is: %s with %.2f Points! \n",highestSPName.trim(), highestSP);
		}

	double highestLP=0;
	String highestLPName;
	public void printHighestLP(){
		for (int a = 0; a < nSkaters; a++) {
			if (highestLP < skaterList[a].getLongProgram()) {
				highestLP = skaterList[a].getLongProgram();
				highestLPName=skaterList[a].getName();
			}
		}
		System.out.printf("Winner of the Long Program is: %s with %.2f Points! \n",highestLPName.trim(), highestLP);
	}
	double highestEP=0;
	String highestEPName;
	public void printHighestEP(){
		for (int a = 0; a < nSkaters; a++) {
			if (highestEP < skaterList[a].getExecuteElement()) {
				highestEP = skaterList[a].getExecuteElement();
				highestEPName=skaterList[a].getName();
			}
		}
		System.out.printf("The most Artistic Skater is: %s with %.2f Points! \n",highestEPName.trim(), highestEP);
	}
	double highestPC=0;
	String highestPCName;
	public void printHighestPC(){
		for (int a = 0; a < nSkaters; a++) {
			if (highestPC < skaterList[a].getProgramComponent()) {
				highestPC = skaterList[a].getProgramComponent();
				highestPCName = skaterList[a].getName();
			}
		}
		System.out.printf("The most Athletic Skater is: %s with %.2f Points! \n",highestPCName.trim(), highestPC);
	}

	double first, second, third, fourth;
	String firstName;
	String secondName;
	String thirdName;
	String fourthName;

	public void printUSA() {
		int i;
		int INT_MIN = 0;

		fourth = third = first = second = INT_MIN;
		for (i = 0; i < nSkaters; i++) {
			/* If current element is greater than first*/
			if (skaterList[i].getTotal() > first)
			{
				fourth = third;
				third = second;
				second = first;
				first = skaterList[i].getTotal();
				firstName=skaterList[i].getName();
			}

			/* If arr[i] is in between first and second then update second  */
			else if (skaterList[i].getTotal() > second)
			{
				fourth = third;
				third = second;
				second = skaterList[i].getTotal();
				secondName=skaterList[i].getName();
			}
			else if (skaterList[i].getTotal() > third)
			{
				fourth = third;
				third = skaterList[i].getTotal();
				thirdName=skaterList[i].getName();
			}
			else if (skaterList[i].getTotal() > fourth)
			{
				fourth = skaterList[i].getTotal();
				fourthName=skaterList[i].getName();
			}


		}
		System.out.printf("And the 2020 USA Men Figure Skating team are \n%s \n%s \n%s\n %s", firstName, secondName, thirdName, fourthName);

	}

	// Write a method to sort skaterList by total points
}
