/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4.pkg2.cashedrowsettest;


import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

/**
 *
 * @author asus
 */
public class CashedRowSetTest {

    /**
     * @param args the command line arguments
     */
    private static String getStringUrl() {
      return "jdbc:sqlserver://localhost:1433;databasename=StudentDB";
    }
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            cachedRowSet.setUrl(getStringUrl());
            cachedRowSet.setUsername("sa");
            cachedRowSet.setPassword("123456");
            cachedRowSet.setCommand("SELECT * FROM Class");
            cachedRowSet.execute();
            
            System.out.printf("%-8s%-10s\n","ID","Subject");
            while(cachedRowSet.next()){
                System.out.printf("%-8s%-10s\n",cachedRowSet.getString("Class_ID"),cachedRowSet.getString("Class_Name"));
            }
            
        
            //move the cursor into the start
            cachedRowSet.absolute(-1);
            //search to update
            while(cachedRowSet.next()){
                String s = cachedRowSet.getString("Class_id");
                System.out.println("Finding Math: "+ s);
                if(s.equals("MTH")){
                    System.out.println("Found !!!");
                    break;
                }
            }
        //update
            cachedRowSet.updateString("Class_name","Math");
            cachedRowSet.updateRow();
            cachedRowSet.acceptChanges();
            //check
            cachedRowSet.absolute(-1);
            System.out.printf("%-8s%-10s\n","ID","Subject");
            while(cachedRowSet.next()){
                System.out.printf("%-8s%-10s\n",cachedRowSet.getString("Class_ID"),cachedRowSet.getString("Class_Name"));
            }
        //insert  
            cachedRowSet.moveToInsertRow();
            cachedRowSet.updateString("class_id","ILL");
            cachedRowSet.updateString("class_name","Intelligence Linear Liquid");
            cachedRowSet.insertRow();
            cachedRowSet.moveToCurrentRow();
            cachedRowSet.acceptChanges();
            //check
            cachedRowSet.absolute(-1);
            System.out.printf("%-8s%-10s\n","ID","Subject");
            while(cachedRowSet.next()){
                System.out.printf("%-8s%-10s\n",cachedRowSet.getString("Class_ID"),cachedRowSet.getString("Class_Name"));
            }
        //delete
            cachedRowSet.absolute(-1);
            //search to delete
            while(cachedRowSet.next()){
                String s = cachedRowSet.getString("Class_id");
                System.out.println("Finding Math: "+ s);
                if(s.equals("PHE")){
                    System.out.println("Found !!!");
                    break;
                }
            }
            //delete
            cachedRowSet.deleteRow();
            cachedRowSet.acceptChanges();
            //check
            cachedRowSet.absolute(-1);
            System.out.printf("%-8s%-10s\n","ID","Subject");
            while(cachedRowSet.next()){
                System.out.printf("%-8s%-10s\n",cachedRowSet.getString("Class_ID"),cachedRowSet.getString("Class_Name"));
            }

        }catch (SQLException ex) {
            ex.printStackTrace();
        }catch(NullPointerException ne){
        }
    }
    
}
