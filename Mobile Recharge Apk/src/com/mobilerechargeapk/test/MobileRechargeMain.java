package com.mobilerechargeapk.test;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.mobilerechargeapk.dao.AdminDao;
import com.mobilerechargeapk.dao.AirtelDao;
import com.mobilerechargeapk.dao.BsnlDao;
import com.mobilerechargeapk.dao.HistorydetailsDao;
import com.mobilerechargeapk.dao.JioDao;
import com.mobilerechargeapk.dao.OperatorDao;
import com.mobilerechargeapk.dao.UserDao;
import com.mobilerechargeapk.dao.VodafoneDao;
import com.mobilerechargeapk.model.Admin;
import com.mobilerechargeapk.model.AirtelUser;
import com.mobilerechargeapk.model.BsnlUser;
import com.mobilerechargeapk.model.HistoryDetails;
import com.mobilerechargeapk.model.JioUser;
import com.mobilerechargeapk.model.Operator;
import com.mobilerechargeapk.model.User;
import com.mobilerechargeapk.model.VodafoneUser;

public class MobileRechargeMain {

	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Mobile recharge app");
		System.out.println("\n1.Admin_login \n2.User_Login");
		int val = Integer.parseInt(scan.nextLine());
		switch (val) {
		case 1:

			boolean result = false;
			System.out.println("Enter your  Network \n1.Admin Login \n2.jio \n3.Airtel \n4.Vodafone \n5.Bsnl");
			int choice1 = Integer.parseInt(scan.nextLine());
			switch (choice1) {
			case 1:
				do {
					String adminName = null;
					do {
						System.out.println("enter the Admin name");
						adminName = scan.nextLine();
						if (!adminName.matches("[a-zA-Z]+{20}")) {
							System.out.println("name Should be below 20 char");
						}
						if (adminName.isEmpty()) {
							System.out.println("invalid name");
						}
					} while (!adminName.matches("[a-zA-Z]+{20}") || adminName.isEmpty());

					String password = null;
					do {
						System.out.println("enter the password");
						password = scan.nextLine();
						if (!password.matches("[0-9a-zA-Z@#*]+{8}")) {
							System.out.println("invalid password");
						}
						if (password.isEmpty()) {
							System.out.println("password invalid");
						}
					} while (!password.matches("[0-9a-zA-Z@#*]+{8}") && password.isEmpty());
					AdminDao adminDao = new AdminDao();

					result = adminDao.validateAdmin(adminName, password);
					if (result == false) {
						System.out.println("invalid ");
					} else {
						System.out.println("valid successfully");
					}
				} while (result != true);
//				break;

			case 2:
				System.out.println("Modify Jio NetWork");
				System.out.println("\n1.insert jio_plan \n2.updated jio_plan \n3.delete jio_plan \n4.show jio_plan");
				int jiochoice = Integer.parseInt(scan.nextLine());

				String planName = null;
				Double price = null;
				String validity = null;
				String benefits = null;
				JioDao jiodao = null;
				switch (jiochoice) {

				case 1:
					char stop = 0;
					do {
						boolean b = false;
						jiodao = new JioDao();
						System.out.println("Add the Jioplan");
						planName = scan.nextLine();
						System.out.println("Enter plan price ");
						price = Double.parseDouble(scan.nextLine());
						System.out.println("Enter the validity");
						validity = scan.nextLine();
						System.out.println("Enter the benefits");
						benefits = scan.nextLine();
						System.out.println("Enter operator name");
						String operatorName = scan.nextLine();
						Operator operator = OperatorDao.findOperator(operatorName);
						JioUser jiouser = new JioUser(planName, price, validity, benefits, operator);
						jiodao = new JioDao();
						b = jiodao.insertJionet(jiouser);
						if (b == true) {
							System.out.println("inserted successfully");
						} else {
							System.out.println("error");
						}
						System.out.println("Do you want continue insert Jio_plan y/n");
						stop = scan.nextLine().charAt(0);
					} while (stop == 'Y' || stop == 'y');

				case 2:

					do {

						boolean b1 = false;

						jiodao = new JioDao();
						System.out.println("Update the planName");
						String planName1 = scan.nextLine();
						System.out.println("update the price");
						Double price1 = Double.parseDouble(scan.nextLine());
						System.out.println("update the plan validity");
						String validity1 = scan.nextLine();
						System.out.println("update the plan benefits");
						String benefits1 = scan.nextLine();
						System.out.println("Enter the Jioplan_id");
						int jioplanId = Integer.parseInt(scan.nextLine());

						b1 = jiodao.updateJio(planName1, price1, validity1, benefits1, jioplanId);
						if (b1 == true) {
							System.out.println("updated sucessfully");
						} else {
							System.out.println("updated Not properly");
						}

						System.out.println("Do you want continue Update Jio_plan y/n");
						stop = scan.nextLine().charAt(0);
					} while (stop == 'Y' || stop == 'y');

				case 3:

					do {

						boolean b2 = false;
						System.out.println("Delete the jio _plan");
						int jioplanId1 = Integer.parseInt(scan.nextLine());
						jiodao = new JioDao();
						b2 = jiodao.deleteJio(jioplanId1);
						if (b2 == true) {
							System.out.println("deleted succesfully");
						} else {
							System.out.println("not deleted");
						}
						System.out.println("Do you want continue Delete Jio_plan y/n");
						stop = scan.nextLine().charAt(0);
					} while (stop == 'Y' || stop == 'y');
				case 4:
					do {
						jiodao = new JioDao();
						System.out.println("List of jio_Plans");
						List<JioUser> jioList = jiodao.showJioplan();
						for (int i = 0; i < jioList.size(); i++) {
							System.out.println(jioList.get(i));
						}
						System.out.println("Do you want continue show Jio_plan y/n");
						stop = scan.nextLine().charAt(0);
					} while (stop == 'Y' || stop == 'y');
////				System.out.println("Enter plan_name which jioplan_id find");
////				planName = scan.nextLine();
////				System.out.println("Enter Amount which jioplan_id find");
////				Double Price = Double.parseDouble(scan.nextLine());
////				jiodao = new JioDao();
//				    int jioplanId1 = jiodao.findjioId(planName, Price);

				}
			case 3:
				System.out.println(
						"Modify Airtel network \n1.insert Airtel_plan \n2.updated Airtel_plan \n3.delete Airtel_plan \n4.show Airtel_plan");
				int airtelchoice = Integer.parseInt(scan.nextLine());
				char stop = 0;
				boolean a = false;
				AirtelDao airteldao = null;

				switch (airtelchoice) {

				case 1:
					do {
						System.out.println("Add the Airtel Plan");
						planName = scan.nextLine();
						System.out.println("Add the plan price");
						price = Double.parseDouble(scan.nextLine());
						System.out.println("Add the plan validity");
						validity = scan.nextLine();
						System.out.println("Add the plan benfits");
						benefits = scan.nextLine();
						System.out.println("Add the operator name");
						String operatorname = scan.nextLine();
						Operator operator = OperatorDao.findOperator(operatorname);
						AirtelUser airteluser = new AirtelUser(planName, price, validity, benefits, operator);
						airteldao = new AirtelDao();
						a = airteldao.insertAirtelnet(airteluser);
						if (a == true) {
							System.out.println("inserted successfully");
						} else {
							System.out.println("error");
						}
						System.out.println("Do you want continue add Airtel plan yes or no");
						stop = scan.nextLine().charAt(0);
					} while (stop == 'Y' || stop == 'y');
//					break;
				case 2:
					do {
						System.out.println("Updated Airtel plan_name");
						planName = scan.nextLine();
						System.out.println("updated Airtel plan Amount");
						price = Double.parseDouble(scan.nextLine());
						System.out.println("updated Airtel plan validity");
						validity = scan.nextLine();
						System.out.println("updated Airtel plan benfits");
						benefits = scan.nextLine();
						System.out.println("Enter the Airtel plan_id");
						int airtelplanId = Integer.parseInt(scan.nextLine());

						airteldao = new AirtelDao();
						a = airteldao.updateAirtel(planName, price, validity, benefits, airtelplanId);

						if (a == true) {
							System.out.println("Airtel plan updated");
						} else {
							System.out.println("not updated");
						}
						System.out.println("Do you want continue Updated Airtel plan yes or no");
						stop = scan.nextLine().charAt(0);
					} while (stop == 'Y' || stop == 'y');
//					break;
				case 3:
					do {
						System.out.println("Delete the Airtel_plan");
						int airtelplanId1 = Integer.parseInt(scan.nextLine());
						airteldao = new AirtelDao();
						a = airteldao.deleteAirtel(airtelplanId1);
						if (a == true) {
							System.out.println(" Airtel_plan succesfully deleted ");
						} else {
							System.out.println("Not deleted");
						}
						System.out.println("Do you want continue Delete Airtel plan yes or no");
						stop = scan.nextLine().charAt(0);
					} while (stop == 'Y' || stop == 'y');
//					break;
				case 4:
					do {
						airteldao = new AirtelDao();
						System.out.println("List of airtel_Plans");
						List<AirtelUser> airtelList = airteldao.showAirtelplan();
						for (int i = 0; i < airtelList.size(); i++) {
							System.out.println(airtelList.get(i));
						}

						System.out.println("Do you want continue yes or no");
						stop = scan.nextLine().charAt(0);
					} while (stop == 'Y' || stop == 'y');
				}
//				break;

//				System.out.println("Enter plan_name which airtelplan_id find");
//				planname = scan.nextLine();
//				System.out.println("Enter Amount which airtelplan_id find");
//				Double Price = Double.parseDouble(scan.nextLine());
//				airteldao = new AirtelDao();
//				int airtelPlanid = airteldao.findairtelId(planname, Price);

			case 4:
				System.out.println(" \n1.show Vodafone_plan \n2.insert Vodafone_plan \n3.updated Vodafone_plan"
						+ " \n4.delete Vodafone_plan ");
				int vodafonechoice = Integer.parseInt(scan.nextLine());
				VodafoneDao vdao = new VodafoneDao();
				VodafoneUser vodafone = new VodafoneUser();
				boolean v = false;
				switch (vodafonechoice) {
				case 1:
//				System.out.println("Enter plan_name which vodafoneplan_id find");
//				planname = scan.nextLine();
//				System.out.println("Enter Amount which vodafoneplan_id find");
//				Double Price = Double.parseDouble(scan.nextLine());
//				vdao = new VodafoneDao();
//				int vodafoneplanId = vdao.findvodafoneId(planname, Price);
					do {
						vdao = new VodafoneDao();
						System.out.println("List of Vodafone_Plans");
						List<VodafoneUser> vodafone1 = vdao.showViplan();
						for (int i = 0; i < vodafone1.size(); i++) {
							System.out.println(vodafone1.get(i));
						}

						System.out.println("Do you want continue yes or no");
						stop = scan.nextLine().charAt(0);
					} while (stop == 'Y' || stop == 'y');
//					break;
				case 2:
					do {
						System.out.println("Add the Vodafone_Plan");
						planName = scan.nextLine();
						System.out.println("Add the VI plan_Amount");
						price = Double.parseDouble(scan.nextLine());
						System.out.println("Add the VI plan validity");
						validity = scan.nextLine();
						System.out.println("Add the VI plan benfits");
						benefits = scan.nextLine();
						System.out.println("Add the operator name");
						String operatorname = scan.nextLine();
						Operator operator = OperatorDao.findOperator(operatorname);
						vodafone = new VodafoneUser(planName, price, validity, benefits, operator);
						vdao = new VodafoneDao();
						v = vdao.vodafoneNetwork(vodafone);
						if (v == true) {
							System.out.println("inserted successfully");
						} else {
							System.out.println("error");
						}
						System.out.println("Do you want insert plan continue yes or no");
						stop = scan.nextLine().charAt(0);
					} while (stop == 'Y' || stop == 'y');

//					break;
				case 3:
					do {
						System.out.println("Updated VI plan_name");
						planName = scan.nextLine();
						System.out.println("updated VI plan Amount");
						price = Double.parseDouble(scan.nextLine());
						System.out.println("updated VI plan validity");
						validity = scan.nextLine();
						System.out.println("updated VI plan benfits");
						benefits = scan.nextLine();
						System.out.println("Enter the VI plan_id");
						int airtelplanId = Integer.parseInt(scan.nextLine());
						vdao = new VodafoneDao();
						v = vdao.updateVodafone(planName, price, validity, benefits, airtelplanId);
						if (v == true) {
							System.out.println("Vodafone plan _updated");
						} else {
							System.out.println("not updated");
						}
						System.out.println("Do you updated VI PLAN continue yes or no");
						stop = scan.nextLine().charAt(0);
					} while (stop == 'Y' || stop == 'y');
//					break;
				case 4:
					do {
						System.out.println("Delete the VI_plan");
						int airtelplanId1 = Integer.parseInt(scan.nextLine());
						vdao = new VodafoneDao();
						v = vdao.deleteVodafone(airtelplanId1);
						if (v == true) {
							System.out.println(" Airtel_plan succesfully deleted ");
						} else {
							System.out.println("Not deleted");
						}
						System.out.println("Do you want Delete plan continue yes or no");
						stop = scan.nextLine().charAt(0);
					} while (stop == 'Y' || stop == 'y');
//					break;
				}
			case 5:
				System.out.println("\n1.Show_bsnlplan \n2.Insert_bsnl \n3.Update_bsnl \n4.Deleted_bsnl");
				int bsnlchoice = Integer.parseInt(scan.nextLine());
				BsnlDao bdao = new BsnlDao();
				BsnlUser bsnl = new BsnlUser();
				Boolean n = false;

				switch (bsnlchoice) {
				case 1:
//				System.out.println("Enter plan_name which vodafoneplan_id find");
//			     planname = scan.nextLine();
//				System.out.println("Enter Amount which vodafoneplan_id find");
//				Double Price = Double.parseDouble(scan.nextLine());
//				bdao=new BsnlDao();
//				int bsnlplanId = bdao.findbsnlId(planname, Price);
do {
					bdao = new BsnlDao();
					System.out.println("List of Bsnl_plans");
					List<BsnlUser> bsnl1 = bdao.showBsnlplan();
					for (int i = 0; i < bsnl1.size(); i++) {
						System.out.println(bsnl1.get(i));
					}
					System.out.println("Do you want Show plan continue y/n");
					stop = scan.nextLine().charAt(0);
				} while (stop == 'Y' || stop == 'y');

				case 2:
					do {
					System.out.println("Add the Bsnl_plan");
					planName = scan.nextLine();
					System.out.println("Add the Bsnl plan_Amount");
					price = Double.parseDouble(scan.nextLine());
					System.out.println("Add the Bsnl plan validity");
					validity = scan.nextLine();
					System.out.println("Add the Bsnl plan benfits");
					benefits = scan.nextLine();
					System.out.println("Add the operator name");
					String operatorname = scan.nextLine();
					Operator operator = OperatorDao.findOperator(operatorname);
					bsnl = new BsnlUser(planName, price, validity, benefits, operator);
					bdao = new BsnlDao();
					n = bdao.insertBsnlnetwork(bsnl);
					if (n == true) {
						System.out.println("inserted successfully");
					} else {
						System.out.println("error");
					}
					System.out.println("Do you want insert plan continue y/n");
					stop = scan.nextLine().charAt(0);
				} while (stop == 'Y' || stop == 'y');
//					break;
				case 3:
                 do {
					System.out.println("Updated Bsnl plan_name");
					planName = scan.nextLine();
					System.out.println("updated Bsnl plan Amount");
					price = Double.parseDouble(scan.nextLine());
					System.out.println("updated Bsnl plan validity");
					validity = scan.nextLine();
					System.out.println("updated Bsnl plan benfits");
					benefits = scan.nextLine();
					System.out.println("Enter the Bsnl plan_id");
					int bsnlplanId1 = Integer.parseInt(scan.nextLine());
					bdao = new BsnlDao();
					n = bdao.updateBsnl(planName, price, validity, benefits, bsnlplanId1);
					if (n == true) {
						System.out.println("Bsnl_plan updated");
					} else {
						System.out.println("not updated");
					}
					System.out.println("Do you want Updated plan continue y/n");
					stop = scan.nextLine().charAt(0);
				} while (stop == 'Y' || stop == 'y');

//					break;
				case 4:
					
					System.out.println("Delete the Bsnl_plan");
					int bsnlId = Integer.parseInt(scan.nextLine());
					vdao = new VodafoneDao();
					n = bdao.deleteBsnl(bsnlId);
					if (n == true) {
						System.out.println(" Airtel_plan succesfully deleted ");
					} else {
						System.out.println("Not deleted");
					}
					break;
					
				}

			}
		case 2:

			System.out.println("\n1.Register\n2.login  \n Enter your choice");
			int choice = Integer.parseInt(scan.nextLine());

			boolean m = false;
			UserDao userdao = null;
			User currentUser = null;
			switch (choice) {
			case 1:
				String name = null;
				long number = 0;
				Double wallet = 0.;
				do {
					System.out.println("Enter User Name:");
					name = scan.nextLine();
					if (!name.matches("[a-zA-z0-9]+{3,}")) {
						System.out.println("Enter name maximum 3 character");
					}
					if (name.isEmpty()) {
						System.out.println("name can not be empty");
					}
				} while (!name.matches("[a-zA-z0-9]+{3,}") || name.isEmpty());

				String mail = null;
				do {
					System.out.println("Enter Email_id:");
					mail = scan.nextLine();
					if (!mail.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]+")) {
						System.out.println("Enter valid mail address");
					}
					if (mail.isEmpty()) {
						System.out.println("Mail cannot be empty");
					}
				} while (!mail.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]+") || mail.isEmpty());

				String tempnum = null;
				do {
					System.out.println("Enter Mobile number:");
					tempnum = scan.nextLine();
					if (!tempnum.matches("[0-9]{10}")) {
						System.out.println("enter valid 10 digit mobile number");
					}
					if (tempnum.isEmpty()) {
						System.out.println("mobile number do not empty");
					}
				} while (!tempnum.matches("[0-9]{10}") || tempnum.isEmpty());
				number = Long.parseLong(tempnum);

				String pwd = null;
				do {
					System.out.println("Enter your password");
					pwd = scan.nextLine();
					if (!pwd.matches("[0-9a-zA-Z@#$*]{8,16}")) {
						System.out.println("Enter the valid password");
					}
					if (pwd.isEmpty()) {
						System.out.println("Empty password cannot be valid");
					}
				} while (!pwd.matches("[0-9a-zA_Z@#$*]{8,16}") || pwd.isEmpty());

				String tempwallet = null;
				do {
					System.out.println("Enter your wallet");
					tempwallet = (scan.nextLine());
					if (!tempwallet.matches("[0-9]+{0,}")) {
						System.out.println("payment wallet amount insufficient balance");
					}
					if (tempwallet.isEmpty()) {
						System.out.println("payment wallet is empty");
					}
				} while (!tempwallet.matches("[0-9]{0,}") || tempwallet.isEmpty());
				wallet = Double.parseDouble(tempwallet);

				System.out.println("Enter Operator Name");
				String operatorName = scan.nextLine();
				Operator operator = OperatorDao.findOperator(operatorName);
				User user = new User(name, mail, number, pwd, wallet, operator);
				userdao = new UserDao();
				m = userdao.insertUser(user);
				if (m == true) {
					System.out.println("Inserted successfully");
				} else {
					System.out.println("error");
				}

			case 2:
				// user=new User();
				String Emailid = null;
				userdao = new UserDao();
				System.out.println("User Login");
				do {
					System.out.println("Enter the  Emailid");
					Emailid = scan.nextLine();
					if (!Emailid.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]+")) {
						System.out.println("valid email id");
					}

					if (Emailid.isEmpty()) {
						System.out.println("invalid mailid");
					}
				} while (!Emailid.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]+") || Emailid.isEmpty());
				String password = null;
				do {
					System.out.println("enter the password");
					password = scan.nextLine();
					if (!password.matches("[0-9a-zA-Z@#$*]{8,16}")) {
						System.out.println("invalid password");
					}
					if (password.isEmpty()) {
						System.out.println("password should be filled");
					}
				} while (!password.matches("[0-9a-zA-Z@#$*]{8,16}") || password.isEmpty());

				currentUser = userdao.validiateUser(Emailid, password);
				if (currentUser != null) {
					System.out.println("Login Succesfully" + " " + currentUser.getUsername());
				} else {
					System.out.println("invalid entry");
				}
			case 3:
				System.out.println("Enter your choice \n1.SELECT_PLAN \n2.RECHARGE \n3.WALLET");
				int selectchoice = Integer.parseInt(scan.nextLine());
				switch (selectchoice) {
				case 1:
					System.out.println("Select your NetWork \n1.Jio \n2.Airtel \n3.Vodafone \n4.BSNL ");
					int planchoice = Integer.parseInt(scan.nextLine());
					switch (planchoice) {

					case 1:
						JioDao jiodao = new JioDao();
						System.out.println("List of jio_Plans");
						List<JioUser> jio = jiodao.showJioplan();
						for (int i = 0; i < jio.size(); i++) {
							System.out.println(jio.get(i));
						}
						break;
					case 2:
						AirtelDao airteldao = new AirtelDao();
						System.out.println("List of airtel_Plans");
						List<AirtelUser> airtel = airteldao.showAirtelplan();
						for (int i = 0; i < airtel.size(); i++) {
							System.out.println(airtel.get(i));
						}
						break;
					case 3:

						VodafoneDao vdao = new VodafoneDao();
						System.out.println("List of Vodafone_Plans");
						List<VodafoneUser> vodafone1 = vdao.showViplan();
						for (int i = 0; i < vodafone1.size(); i++) {
							System.out.println(vodafone1.get(i));
						}
						break;
					case 4:
						BsnlDao bdao = new BsnlDao();
						System.out.println("List of Bsnl_plans");
						List<BsnlUser> bsnl1 = bdao.showBsnlplan();
						for (int i = 0; i < bsnl1.size(); i++) {
							System.out.println(bsnl1.get(i));
						}
						break;

					}
				case 2:
					boolean h = false;
					System.out.println("------RECHARGE-------");
					System.out.println("Enter your Operator");
					operatorName = scan.nextLine();
					System.out.println("Enter the plan_name");
					String planName = scan.nextLine();
					System.out.println("Enter the amount");
					double amount = Double.parseDouble(scan.nextLine());
					System.out.println("Enter mobile Number");
					Long mobileNum = Long.parseLong(scan.nextLine());

					JioDao jioDao = new JioDao();
					int planId = 0;
					int userId = userdao.findUserId(currentUser);
					int operatorId = currentUser.getOperator().getOperatorId();
					// System.out.println(currentUser.getOperator().getOperatorname());
					if (operatorName.equals("jio")) {
						planId = JioDao.findjioId(planName, amount);
						// System.out.println(planId);
					} else if (operatorName.equals("Airtel")) {
						planId = AirtelDao.findairtelId(planName, amount);
					} else if (operatorName.equals("Vodafone")) {
						planId = VodafoneDao.findvodafoneId(planName, amount);
					} else {
						planId = BsnlDao.findbsnlId(planName, amount);
					}
					Date rechargeDate = new Date();
					HistoryDetails historyDetails = new HistoryDetails(userId, operatorId, mobileNum, planId,
							rechargeDate, amount);
					HistorydetailsDao historyDao = new HistorydetailsDao();
					h = historyDao.insertDetails(historyDetails);
					if (h == true) {
//						System.out.println("Recharge has been successfully");
//						System.out.println("Recharge history details");
						System.out.println(historyDetails);
						
						userdao.rechargeWalletupdate(amount, currentUser);
						 System.out.println("Recharges has been Successfully");
					} else {
						System.out.println("invalid");
					}

				case 3:
					System.out.println("Recharge here wallet");
					System.out.println("Enter amount");
					amount = Double.parseDouble(scan.nextLine());
					System.out.println("Enter card number");
					long cardNo = Long.parseLong(scan.nextLine());
					System.out.println("Enter cvv");
					int cvv = Integer.parseInt(scan.nextLine());
					currentUser.setWallet(amount);
					userdao.updateuserWallet(currentUser);
				}
			}

		}

	}

}
