/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vpssmsserver;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Royal
 */
public class DerbyConnection {
    public String createDB() {
        Connection conn = null;
        String created = new String("false");
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String strUrl = "jdbc:derby:VPS;create=true;user=vps;password=vps";
            conn = DriverManager.getConnection(strUrl);
            if (conn != null) {
                created = new String("true");
            }

        } catch (Exception e) {
            created = new String("already Exists");
        }
        return created;
    }
    /*End of connecting to the databases*/

    public Connection connectToDB() {
        Connection conn = null;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String strUrl = "jdbc:derby:VPS;user=vps;password=vps";
            conn = DriverManager.getConnection(strUrl);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
}
