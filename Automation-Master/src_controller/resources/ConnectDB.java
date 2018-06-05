package resources;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
	
public class ConnectDB {

	private static Connection connection = null;
    private static Session session = null;
    public static ArrayList list = new ArrayList();  
    
      public static Object getfromDatabaseBrands_brandsItem(String query, String database) {
          Connection con = null;
          Statement stmt = null;
          ResultSet rs = null;
          Object output = null;
          try {
              Class.forName("com.mysql.jdbc.Driver");
              
              switch (database) {
                case "prod":
                     con = (Connection) DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");
                     break;
                 case "staging":
                	 con = (Connection) DriverManager.getConnection("jdbc:mysql://54.169.68.90/staging_fdbr_salon", "serverteam", "DDKW31Kr31");
                     break;
                  default:
                      throw new Exception("No Database with that name");
              }

              stmt = (Statement) con.createStatement();
              rs = stmt.executeQuery(query);
              if (rs.next()) {
              	output = rs.getObject("brands_item");
             }
              
          } catch (Exception e) {
              return "Error:" + e.getMessage();
          } finally {
          	try {
  				rs.close();
  				stmt.close();
  	            con.close();
  			} catch (SQLException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
          }
          
          return output;
      }     
      
      public static Object getfromDatabaseBrands_productType(String query, String database) {
          Connection con = null;
          Statement stmt = null;
          ResultSet rs = null;
          Object output = null;
          try {
              Class.forName("com.mysql.jdbc.Driver");
              
              switch (database) {
                case "prod":
                     con = (Connection) DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");
                     break;
                 case "staging":
                	 con = (Connection) DriverManager.getConnection("jdbc:mysql://54.169.68.90/staging_fdbr_salon", "serverteam", "DDKW31Kr31");
                     break;
                  default:
                      throw new Exception("No Database with that name");
              }

              stmt = (Statement) con.createStatement();
              rs = stmt.executeQuery(query);
              if (rs.next()) {
              	output = rs.getObject("prod_item");
             }
              
          } catch (Exception e) {
              return "Error:" + e.getMessage();
          } finally {
          	try {
  				rs.close();
  				stmt.close();
  	            con.close();
  			} catch (SQLException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
          }
          
          return output;
      }
      
      public static String getDataAsArray(String query, String database) {
          Connection con = null;
          Statement stmt = null;
          ResultSet rs = null;
          Object output = null;
          String prnt = "kosong";
          ArrayList<prodItem> docters = new ArrayList<prodItem>();
          try {
              Class.forName("com.mysql.jdbc.Driver");
              
              switch (database) {
                case "prod":
                     con = (Connection) DriverManager.getConnection("jdbc:mysql://103.58.100.148/utstag2015", "qaeng", "7y@#ER7654#$%7ytf~!@#$%^87y");
                     break;
                 case "staging":
                	 con = (Connection) DriverManager.getConnection("jdbc:mysql://54.169.68.90/staging_fdbr_salon", "serverteam", "DDKW31Kr31");
                     break;
                  default:
                      throw new Exception("No Database with that name");
              }

              stmt = (Statement) con.createStatement();
              rs = stmt.executeQuery(query);
              
              
              while (rs.next()) {
              	output = rs.getObject("brands_item");
              	prodItem pr = new prodItem(output.toString());
              	docters.add(pr);
              }
              
          } catch (Exception e) {
              return "Error:" + e.getMessage();
          } finally {
          	try {
  				rs.close();
  				stmt.close();
  	            con.close();
  			} catch (SQLException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
          }
          
          prnt = docters.get(2).getProdId();
//          prnt = output.toString();
          
          return prnt;
      }
}