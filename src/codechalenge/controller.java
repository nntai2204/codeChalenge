package codechalenge;

import java.util.Scanner;

import codechalenge.service.SearchService;

public class controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in); //
		SearchService serchService = new SearchService();
		System.out.println("Type 'quit' to exit at any time, Press 'Enter' to continue\n\n\n");
		System.out.println("Select search options:");
		System.out.println("* Press 1 to search");
		System.out.println("* Press 2 to view a list of searchale fields");
		System.out.println("* Press 'quit' to exit");
		String run = "";
		while (!run.equals("quit")) {
			run = myObj.nextLine();

			if (run.equals("1")) {
				System.out.println("Select 1) Users or 2) Tickets or 3) Oganizations");
				int select = myObj.nextInt();
				if (select == 1) {
					serchService.findUser();
				}
				if (select == 2) {
					serchService.findTickets();
				}
				if (select == 3) {
					serchService.findOrganizations();
				}
			}
			if (run.equals("2")) {
				serchService.getuService().searchList();
				serchService.getTicketsSer().searchList();
				serchService.getOrSer().searchList();
			}
		}
		System.out.print("finished");
	}
}
