package codechalenge;

import java.util.Scanner;

import codechalenge.service.SearchService;

public class controller {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner myObj = new Scanner(System.in); //
		SearchService serchService = new SearchService();
		// System.out.println(serchService.findUser().get_id());
		System.out.println("Type 'quit' to exit at any time, Press 'Enter' to continue\n\n\n");
		System.out.println("Select search options:");
		System.out.println("* Press 1 to search");
		System.out.println("* Press 2 to view a list of searchale fields");
		System.out.println("* Press 'quit' to exit");
		String run = myObj.nextLine();
		while (!run.equals("quit")) {
			run = myObj.nextLine();

			if (run.equals("1")) {
				System.out.println("Select 1) Users or 2) Tickets or 3) Oganizations");
				int select = myObj.nextInt();
				if (select == 1) {
					serchService.findUser();
				}
				if (select == 1) {
					serchService.findTickets();
				}
				if (select == 1) {
					serchService.findOrganizations();
				}
				// serchService.findUser().get_id();
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
