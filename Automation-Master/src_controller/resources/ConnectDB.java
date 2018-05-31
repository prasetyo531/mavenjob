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
import java.sql.Connection;

	//172.12.2.71	 mysql host lama

	
public class ConnectDB {

	private static Connection connection = null;
    private static Session session = null;
    

    public static void connectToServer(String dataBaseName) throws SQLException {
        connectSSH();
        connectToDataBase(dataBaseName);
    }

    public static void connectSSH() throws SQLException {
        String sshHost = "52.76.160.99";//"52.76.160.99"
        String sshuser = "root";
        String dbuserName = "serverteam";
        String dbpassword = "DDKW31Kr31";
        String SshKeyFilepath = "/Users/mac/.ssh/id_rsa";

        int localPort = 8740; // any free port can be used
//        String remoteHost = "172.12.2.71";
        String remoteHost = "52.76.160.99";
        int remotePort = 3306;
//        String localSSHUrl = "52.76.160.99";
        String localSSHUrl = "127.0.0.1";
        /***************/
        String driverName = "com.mysql.jdbc.Driver";

        try {
            java.util.Properties config = new java.util.Properties();
            JSch jsch = new JSch();
            session = jsch.getSession(sshuser, sshHost, 22);
            jsch.addIdentity(SshKeyFilepath);
            config.put("StrictHostKeyChecking", "no");
            config.put("ConnectionAttempts", "3");
            session.setConfig(config);
            session.connect();

            System.out.println("SSH Connected");

            Class.forName(driverName).newInstance();

            int assinged_port = session.setPortForwardingL(localPort, remoteHost, remotePort);

            System.out.println(localSSHUrl + ":" + assinged_port + " -> " + remoteHost + ":" + remotePort);
            System.out.println("Port Forwarded");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void connectToDataBase(String dataBaseName) throws SQLException {
        String dbuserName = "serverteam";
        String dbpassword = "DDKW31Kr31";
        int localPort = 8740; // any free port can be used
//        String localSSHUrl = "52.76.160.99";
        String localSSHUrl = "172.12.2.71";
        try {

            //mysql database connectivity
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setServerName(localSSHUrl);
            //dataSource.setPortNumber(localPort);
            dataSource.setUser(dbuserName);
            dataSource.setAllowMultiQueries(true);

            dataSource.setPassword(dbpassword);
            dataSource.setDatabaseName(dataBaseName);

            connection = dataSource.getConnection();

            System.out.print("Connection to server successful!:" + connection + "\n\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void closeConnections() {
        CloseDataBaseConnection();
        CloseSSHConnection();
    }

    public static void CloseDataBaseConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Closing Database Connection");
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void CloseSSHConnection() {
        if (session != null && session.isConnected()) {
            System.out.println("Closing SSH Connection");
            session.disconnect();
        }
    }


    // works ONLY FOR  single query (one SELECT or one DELETE etc)
    public static ResultSet executeMyQuery(String query, String dataBaseName) {
        ResultSet resultSet = null;

        try {
            connectToServer(dataBaseName);
            Statement stmt = (Statement) connection.createStatement();
            resultSet = stmt.executeQuery(query);
            System.out.println("Database connection success");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public static void DeleteOrganisationReferencesFromDB(String organisationsLike) {
        try {
            connectToServer("ServerName");
            Statement stmt = (Statement) connection.createStatement();

            ResultSet resultSet = stmt.executeQuery("select * from DB1");

            String organisationsToDelete = "";
            List<String> organisationsIds = new ArrayList<String>();

            // create string with id`s values to delete organisations references
            while (resultSet.next()) {
                String actualValue = resultSet.getString("id");
                organisationsIds.add(actualValue);
            }

            for (int i = 0; i < organisationsIds.size(); i++) {
                organisationsToDelete = " " + organisationsToDelete + organisationsIds.get(i);
                if (i != organisationsIds.size() - 1) {
                    organisationsToDelete = organisationsToDelete + ", ";
                }
            }

            stmt.executeUpdate(" DELETE FROM `DB1`.`table1` WHERE `DB1`.`table1`.`organisation_id` in ( " + organisationsToDelete + " );");


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
    }

    public static List<String> getOrganisationsDBNamesBySubdomain(String organisationsLike) {
        List<String> organisationDbNames = new ArrayList<String>();
        ResultSet resultSet = executeMyQuery("select `DB`.organisation.dbname from `DB1`.organisation where subdomain like '" + organisationsLike + "%'", "DB1");
        try {
            while (resultSet.next()) {
                String actualValue = resultSet.getString("dbname");
                organisationDbNames.add(actualValue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
        return organisationDbNames;
    }

     public static List<String> getAllDBNames() {
        // get all live db names incentral DB
        List<String> organisationDbNames = new ArrayList<String>();
        ResultSet resultSet = executeMyQuery("show databases", "DB1");
        try {
            while (resultSet.next()) {
                String actualValue = resultSet.getString("Database");
                organisationDbNames.add(actualValue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
        return organisationDbNames;
    }

      public static void deleteDataBasesByName(List<String> DataBasesNamesList) {
        try {
            connectSSH();
            int dataBasesAmount = DataBasesNamesList.size();
            for (int i = 0; i < dataBasesAmount; i++) {
                connectToDataBase(DataBasesNamesList.get(i));

                Statement stmt = (Statement) connection.createStatement();
                stmt.executeUpdate("DROP database `" + DataBasesNamesList.get(i) + "`");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseDataBaseConnection();
            closeConnections();
        }
    }
      
      public static Object getfromDatabaseBrands_totalProduct(String query, String database) {
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
      
      public static Object getfromDatabaseBrands_totalReview(String query, String database) {
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
              	output = rs.getObject("brands_total_review_num");
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
}