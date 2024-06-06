
package com.edubridge.mini_project.main;

import java.util.List;
import java.util.Scanner;
import com.edubridge.mini_project.model.refrigerator;
import com.edubridge.mini_project.service.refrigeratorService;
import com.edubridge.mini_project.service.refrigeratorServiceImpl;

public class refrigeratorMainApp {
	public static void main(String[] args) {
		refrigeratorService service = new refrigeratorServiceImpl();
		refrigerator r = null;
		Scanner in = new Scanner(System.in);
		int option;
		do {
			System.out.println("Welcome to refrigerator App");
			System.out.println("**********************");
			System.out.println("1. Add refrigerator");
			System.out.println("2. View refrigerators");
			System.out.println("3. Search refrigerator");
			System.out.println("4. Update refrigerator");
			System.out.println("5. Delete refrigerator");
			System.out.println("6. Delete All refrigerators");
			System.out.println("0. Exit");
			option = in.nextInt();
			

			String searchBrand;
			refrigerator searchrefrigerator;
			switch (option) {
			case 1:
				System.out.println("ADD NEW REFRIGERATOR");
				System.out.println("---------------");
				System.out.println("please enter Brand: ");
				String Brand = in.next();
				System.out.println("Please enter Price: ");
				int Price = in.nextInt();
				System.out.println("Please enter Colour: ");
				String Colour = in.next();
				System.out.println("Please enter Star_rating: ");
				String Star_rating = in.next();
				
				r = new refrigerator();
				r.setBrand(Brand);
				r.setPrice(Price);
				r.setColour(Colour);
				r.setStar_rating(Star_rating);
				int status = service.addrefrigerator(r);
				if(status == 1) {
					System.out.println("new refrigerator added!!!");
				}else {
					System.out.println("Something went Wrong!!!");
				}
				
				break;
			
			case 2:
				System.out.println("View All refrigerator");
				List<refrigerator> refrigerators = service.findrefrigerators();
				System.out.println("BRAND \t PRICE \t COLOUR \t STAR_RATING");
				System.out.println("-----     \t------  \t-------  \t-----  \t");
				for(refrigerator refrigerator : refrigerators) {
					System.out.println(refrigerator.getBrand()+"\t"+refrigerator.getPrice()+"\t"+refrigerator.getColour()+"\t"+refrigerator.getStar_rating());
					
				}
				
				break;
				
			case 3:
				System.out.println("Enter the refrigerator Brand: ");
				searchBrand = in.next();
				searchrefrigerator = service.findrefrigeratorByName(searchBrand);
				if(searchrefrigerator != null) {
					System.out.println("Id: "+searchrefrigerator.getId());
					System.out.println("Brand: "+searchrefrigerator.getBrand());
					System.out.println("Price: "+searchrefrigerator.getPrice());
					System.out.println("Colour: "+searchrefrigerator.getColour());
					System.out.println("Star_rating: "+searchrefrigerator.getStar_rating());
				}else {
					System.out.println("No refrigerator found!!!");
				}
				
				break;
			case 4:
				System.out.println("Update refrigerator");
				System.out.println("Please enter refrigerator Brand:");
				searchBrand = in.next();
				searchrefrigerator = service.findrefrigeratorByName(searchBrand);
				if(searchrefrigerator != null) {
					System.out.println("Id:" +searchrefrigerator.getId());
					System.out.println("Brand:" +searchrefrigerator.getBrand());
					System.out.println("Price:" +searchrefrigerator.getPrice());
					System.out.println("Colour:" +searchrefrigerator.getColour());
					System.out.println("Star_rating:" +searchrefrigerator.getStar_rating());
					//Reading refrigerator update info
					System.out.println("Please enter updated Brand:");
					Brand = in.next();
					System.out.println("Please enter updated Price:");
					Price = in.nextInt();
					System.out.println("Please enter updated Colour:");
					Colour = in.next();
					
					System.out.println("Please enter updated star_rating:");
					Star_rating = in.next();
					refrigerator updaterefrigerator = new refrigerator();
					
					updaterefrigerator.setBrand(Brand);
					updaterefrigerator.setPrice(Price);
					updaterefrigerator.setColour(Colour);
					updaterefrigerator.setStar_rating(Star_rating);
					updaterefrigerator.setId(searchrefrigerator.getId());
					
					int updateStatus = service.updaterefrigerator(updaterefrigerator);
					
					if(updateStatus == 1) {
						System.out.println("refrigerator updated successfully");
					}
					else{
						System.out.println("Something is wrong");
					}
				}
				else {
					System.out.println("No refrigerator found with name");
				}
				break;
				
			case 5:
				System.out.println("Delete refrigerators");
				System.out.println("Please enter refrigerator Brand:");
				
				searchBrand = in.next();
				searchrefrigerator = service.findrefrigeratorByName(searchBrand);
				if(searchrefrigerator != null) {
					int deleteStatus = service.deleterefrigeratorByName(searchBrand);
					if(deleteStatus == 1) {
						System.out.println("refrigerator Deleted Successfully");
					}
					else {
						System.out.println("Something is wrong");
					}
				}else {
					System.out.println("No refrigerator found");
				}
				break;
				
			case 6:
				System.out.println("ARE YOU SURE Delete All refrigerator?[y/n]");
				String deleteConfirmStatus = in.next();
				if(deleteConfirmStatus.equalsIgnoreCase("y")) {
					service.deleteallrefrigerator();
					System.out.println("All refrigerators Deleted!");
				}
				
				
				
				break;
			case 0:
				System.out.println("Bye!!!");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid option!!!");
				break;
			}
		} while(option != 0);
		
	}
}