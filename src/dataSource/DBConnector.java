package dataSource;

import java.sql.Connection;
import java.sql.DriverManager;

//Encapsulates code to connect to DB
//hau
//default visibility - not visible outside package - tm
class DBConnector {

    private static String id = "tm";						//Insert ORACLE id and password
    private static String pw = "tm";

    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:dat", id, pw);

        } catch (Exception e) {
            System.out.println("\n*** Remember to insert your Oracle ID and PW in the DBConnector class! ***\n");
            System.out.println("eror in DBConnector.getConnection()");
            System.out.println(e);
        }

        return con;
    }

    public void releaseConnection(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
