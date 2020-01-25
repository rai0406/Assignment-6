package mobile.main;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import mobile.config.AppConfig;
import mobile.dao.MobileDAO;
import mobile.pojo.Mobile;
//import mobile.pojo.Person;

public class MobileJDBCMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		MobileDAO mobileDAO = context.getBean(MobileDAO.class);

		System.out.println("List of Mobiles is:");

		for (Mobile p : mobileDAO.getAllMobiles()) {
			System.out.println(p);
		}

		System.out.println("\nGet mobile with ID 2");

		Mobile mobileById = mobileDAO.getMobileById(2);
		System.out.println(mobileById);

		System.out.println("\nCreating mobile: ");
		
		Mobile mob = new Mobile(6, "f", 600, 60, "pqr");
		
		System.out.println(mob);
		
		mobileDAO.createMobile(mob);
		
		System.out.println("\nList of person is:");

		for (Mobile m : mobileDAO.getAllMobiles()) {
			System.out.println(m);
		}

		System.out.println("\nDeleting mobile with ID 2");
		mobileDAO.deleteMobile(mobileById);

		System.out.println("\nUpdate mobile with ID 4");

		Mobile mmobile = mobileDAO.getMobileById(4);
		mmobile.setQuantity(22);
		mobileDAO.updateMobile(mmobile);

		System.out.println("\nList of Mobiles is:");
		for (Mobile mm : mobileDAO.getAllMobiles()) {
			System.out.println(mm);
		}

		context.close();
	}

}
