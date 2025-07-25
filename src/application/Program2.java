package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("== Teste 1: Department findById ==");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n== Teste 2: Department findAll ==");
		List<Department> list = departmentDao.findAll();
		for (Department department : list) {
			System.out.println(department);
		}
		
		System.out.println("\n== Teste 3: Department insert ==");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted. New id: " + newDepartment.getId());
		
		System.out.println("\n== Teste 4: Department update ==");
		Department dep2 = departmentDao.findById(10);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Update complete");
		
		System.out.println("\n=== TEST 5: delete =======");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
