package com.edubridge.washingmachine;

import java.util.List;
import java.util.Scanner;

import com.edubridge.washingmachine.dao.WashingMachineDao;
import com.edubridge.washingmachine.dao.WashingMachineDaoImpl;
import com.edubridge.washingmachine.model1.WashingMachine;

public class App {
	public static void main(String[] args) {
		WashingMachineDao dao = new WashingMachineDaoImpl();
		Scanner in= new Scanner(System.in);
		while (true) {
			System.out.println("All WashingMachine Brands");
			System.out.println("--------------");
			System.out.println("1.ADD BRAND");
			System.out.println("2. SHOW ALL BRANDS");
			System.out.println("3. SEARCH BRAND");
			System.out.println("4. UPDATE BRAND");
			System.out.println("5.DELETE BRAND");
			System.out.println("6.DELETE ALL BRANDS");
			System.out.println("0. EXIT");
			System.out.println("PLEASE CHOOSE OPTION:");

			int option = in.nextInt();
			switch (option) {
			case 1:
				System.out.println("Please enter modelno:");
				int modelno = in.nextInt();

				System.out.println("Please enter  brand:");
				String brand = in.next();

				System.out.println("Please enter  price:");
				float price = in.nextFloat();

				System.out.println("Please enter  rating:");
				float rating = in.nextFloat();

				System.out.println("Please enter  warenty:");
				String warenty = in.next();

				WashingMachine newWashingMachine = new WashingMachine();
				newWashingMachine.setModelno(modelno);
				newWashingMachine.setBrand(brand);
				newWashingMachine.setPrice(price);
				newWashingMachine.setRating(rating);
				newWashingMachine.setWarrenty(warenty);

				int status = dao.addWashingMachine(newWashingMachine);
				if (status >= 1) {
					System.out.println("New Modelno added!!");
				} else {
					System.out.println("Something is wrong!!!");
				}
				break;

			case 2:
				List<WashingMachine> W = dao.getAllWashingMachine();
				if (W.size() != 0) {
					for (WashingMachine w : W) {
						System.out.println(w.getModelno() + "\t" + w.getBrand() + "\t" + w.getPrice() + "\t"
								+ w.getRating() + "\t" + w.getWarrenty());
					}
				} else {
					System.out.println("no brands found");
				}

				break;
			case 3:
				System.out.println("Please enter brand name to search:");
				String searchBrand = in.next();
				WashingMachine searchedWashingMachine = dao.getWashingMachine(searchBrand);
				if (searchedWashingMachine != null) {
					System.out.println(searchedWashingMachine.getModelno() + "\t" + searchedWashingMachine.getBrand()
							+ "\t" + searchedWashingMachine.getPrice() + "\t" + searchedWashingMachine.getRating());
				} else {
					System.out.println("models not found");
				}
				break;
			case 4:
				System.out.println("Please enter the Modelno of the Brand to update:");
				int Modelno1 = in.nextInt();

				if (!dao.checkModelExists(Modelno1)) {
					System.out.println("There is no existing details!!!");
				} else {

					System.out.println("Please enter new  Brand:");
					String newBrand = in.next();

					System.out.println("Please enter new  Price:");
					float newPrice = in.nextFloat();

					System.out.println("Please enter new Rating:");
					float newRating = in.nextFloat();

					System.out.println("Please enter new Warranty:");
					String newwarranty = in.next();

					WashingMachine wash1 = new WashingMachine();
					wash1.setModelno(Modelno1);
					wash1.setBrand(newBrand);
					wash1.setPrice(newPrice);
					wash1.setRating(newRating);
					wash1.setWarrenty(newwarranty);

					int Status = dao.updateWashingMachine(wash1);
					if (Status >= 1) {
						System.out.println("AC Details are Updated!!!");
						System.out.println("-------------------------");
						System.out.println(wash1.getModelno() + "\t" + wash1.getBrand() + "\t" + wash1.getPrice() + "\t"
								+ wash1.getRating() + "\t" + wash1.getWarrenty());
					} else {

						System.out.println("Failed to update the details!!!");
					}
				}
				break;
			case 5:
				System.out.println("Please enter brand name to delete:");
				String deleteWashingMachine = in.next();
				int status2 = dao.deleteWashingMachine(deleteWashingMachine);
				if (status2 >= 1) {
					System.out.println("Brand deleted successfully");
				} else {
					System.out.println("Delete failed");
				}
				break;
			case 6:
				dao.deleteAllWashingMachine();
				System.out.println("All Brands deleted");
				break;
			case 0:
				System.out.println("Byee!!!");
				System.exit(0);

			default:
				System.out.println("Invalide Option!!!!");
				break;
			}
		}
	}
}
