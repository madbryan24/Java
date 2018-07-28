/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filterrowsettest;

import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.FilteredRowSetImpl;
import com.sun.rowset.JoinRowSetImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/**
 *
 * @author asus
 */
public class FilterRowSetTest {

    /**
     * @param args the command line arguments
     */
    
    
    private static String getStringUrl() {
      return "jdbc:sqlserver://localhost:1433;databasename=StudentDB";
    }
    
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        // Tạo đối tượng 
        CachedRowSet cachedRowSet=null;
        try{
            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            cachedRowSet.setUrl(getStringUrl());
            cachedRowSet.setUsername("sa");
            cachedRowSet.setPassword("123456");
            cachedRowSet.setCommand("SELECT * FROM student");
            cachedRowSet.execute();
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }catch(NullPointerException ne){
        }
    
        //Lọc dữ liệu*******************
        RowSetFactory rsf = RowSetProvider.newFactory();
        FilteredRowSet frs = rsf.createFilteredRowSet();
        frs.populate(cachedRowSet);
        String CLASS_ID = "ENG";
        ClassName cr = new ClassName(CLASS_ID);
        frs.setFilter(cr);

        //Duyệt
        while (frs.next()) {
         System.out.print(frs.getString("student_id") +"\t");
         System.out.print(frs.getString("student_name") +"\t" +"\t");
         System.out.print(frs.getString("sex") +"\t");
         System.out.println(frs.getString("class_id"));
         //...
        }
    }
    
}

class ClassName implements Predicate {
        //Danh sách tham số dùng để filter
        private String paramName;

        public ClassName(String para) {
          this.paramName = para;
        }

        @Override
        public boolean evaluate(Object value, int column) throws SQLException {
          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean evaluate(Object value, String columnName) throws SQLException {
          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean evaluate(RowSet rowset) {
            try {
                if(rowset.getString("class_id").equals(paramName))
                    return true;
            } catch (SQLException ex) {
                Logger.getLogger(ClassName.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }