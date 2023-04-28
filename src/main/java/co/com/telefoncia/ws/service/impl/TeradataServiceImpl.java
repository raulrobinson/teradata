package co.com.telefoncia.ws.service.impl;

import co.com.telefoncia.ws.service.TeradataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class TeradataServiceImpl implements TeradataService {

    @Value("${teradata.db.url}")
    private String DB_URL;

    @Value("${teradata.db.user}")
    private String USER;

    @Value("${teradata.db.pass}")
    private String PASS;

    @Override
    public Object GetDataForQuery(String query) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        // Open a connection
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            // Extract data from result set
            while (rs.next()) {
                return String.format("setting: %s, value: %s", rs.getString(1), rs.getString(2));
                //System.out.println(String.format("setting: %s, value: %s", rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) { /* Ignored */}
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) { /* Ignored */}
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) { /* Ignored */}
            }
        }

        return null;

    }
}
