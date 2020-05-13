package car.seleya.driver;

import java.sql.SQLException;

import com.seleya.daoimpl.CarDAOImpl;
import com.seleya.daoimpl.CustomerDAOImpl;
import com.seleya.daoimpl.EmployeeDAOImpl;
import com.seleya.util.Menu;

public class Driver {
	
	public static void main(String[] args) {
		try {
			Menu.mainMenu();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
//		CustomerDAOImpl cdi = new CustomerDAOImpl();
//		try {
//			cdi.getCustomerList();
//			System.out.println(cdi.getCustomerList());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//		
//		EmployeeDAOImpl edi = new EmployeeDAOImpl();
//		CarDAOImpl rdi = new CarDAOImpl();
//		
//		try {
////			cdi.insertCustomer(1, "John", "Doe", "testuser", "password");
////			cdi.insertCustomer(2, "Tony", "Stark", "iamironman", "CapIsOverrated");
////			cdi.insertCustomer(3, "Steve", "Perry", "mclargedrink", "ZootSuitRiot");
////			cdi.insertCustomer(4, "Al", "Pacino", "smartguy45", "HooWah");
//			cdi.getCustomerList();
//			System.out.println(cdi.getCustomerList());
////			edi.insertEmployee(1, "Maurie", "Giustini", "maurieg05", "StrongPassword");
////			edi.insertEmployee(2, "Rosanna", "Riffle", "rriffle", "WeakPassword");
//			edi.getEmployeeList();
//			System.out.println(edi.getEmployeeList());
////			rdi.insertCar(1, "Audi", "R8", "2020", "Red", 160000, "No");
////			rdi.insertCar(2, "Chevrolet", "Stingray", "2018", "White", 27000, "No");
////			rdi.insertCar(3, "Ford", "Mustang", "2016", "Light Blue", 15000, "No");
//			rdi.getCarList();
//			System.out.println(rdi.getCarList());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
