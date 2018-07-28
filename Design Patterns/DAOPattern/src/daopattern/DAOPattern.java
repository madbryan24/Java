/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daopattern;

import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class DAOPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EmployeeDao empDao = new EmployeeDaoImpl();

      //Hiển thị tất cả
      for (Employee e : empDao.getAllEmployees()) {
         System.out.println("Nhan vien: [ID : " + e.getId() + ", Ten : " + e.getName() + "]");
      }

      //Cập nhật
      Employee e = empDao.getAllEmployees().get(0);
      e.setName("Nguyễn Văn Xuân");
      empDao.updateEmployee(e);

      //Hiển thị
      e = empDao.getEmployee(0);
      System.out.println("Nhan vien: [ID : " + e.getId() + ", Ten : " + e.getName() + "]");
    }
    
}

class Employee {
   private int id;
   private String name;

   Employee(int id, String name){
      this.id= id;
      this.name = name;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}

interface EmployeeDao {
   public ArrayList<Employee> getAllEmployees();
   public Employee getEmployee(int id);
   public void updateEmployee(Employee emp);
   public void deleteEmployee(Employee emp);
}

class EmployeeDaoImpl implements EmployeeDao {
	
   ArrayList<Employee> alEmp;

   public EmployeeDaoImpl(){
      alEmp = new ArrayList<Employee>();
      Employee e1 = new Employee(1, "Xuân");
      Employee e2 = new Employee(2, "Hạ");
      alEmp.add(e1);
      alEmp.add(e2);		
   }

   @Override
   public void deleteEmployee(Employee e) {
      alEmp.remove(e.getId());
      System.out.println("Nhan vien co ID " + e.getId() + "da bi xoa");
   }

   @Override
   public ArrayList<Employee> getAllEmployees() {
      return alEmp;
   }

   @Override
   public Employee getEmployee(int id) {
      return alEmp.get(id);
   }

   @Override
   public void updateEmployee(Employee e) {
      alEmp.get(e.getId()).setName(e.getName());
      System.out.println("Nhan vien co ID " + e.getId() + " da duoc cap nhat");
   }
}