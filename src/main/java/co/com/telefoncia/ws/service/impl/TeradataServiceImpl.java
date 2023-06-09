package co.com.telefoncia.ws.service.impl;

import co.com.telefoncia.ws.dto.RequestDTO;
import co.com.telefoncia.ws.service.TeradataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;

@Slf4j
@Service
public class TeradataServiceImpl implements TeradataService {

    @Value("${teradata.db.url}")
    private String DB_URL;

    @Value("${teradata.db.user}")
    private String USER;

    @Value("${teradata.db.pass}")
    private String PASS;

    @Override
    public Object getCustomQueryByRequestParam(String query) {
        return queryExecute(query);
    }

    @Override
    public Object getCustomQueryByRequestBody(RequestDTO requestDTO) {
        return queryExecute(requestDTO.getQuery());
    }

    private Object queryExecute(String query) {

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
                log.info(String.valueOf(rs));
                return String.format("source_ini: %s, source_end: %s", rs.getString(3), rs.getString(4));
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
