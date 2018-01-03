package hu.kuncystem.patient.dao.session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import hu.kuncystem.patient.pojo.session.Session;

/**
 * Create a JDBC dao object which defines standard operations on a data source.
 * This data source belong to data of session.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 9.
 * 
 * @version 1.0
 */
@Repository
public class JDBCSessionDao implements SessionDao {

    public static class SessionRowMapper implements RowMapper<Session> {
        /*
         * (non-Javadoc)
         * 
         * @see
         * org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
         * int)
         */
        public Session mapRow(ResultSet rs, int row) throws SQLException {

            Session s = new Session(rs.getLong("user_id"), rs.getString("ip"));
            s.setUserAgent(rs.getString("user_agent"));
            s.setDisabled(rs.getBoolean("disabled"));

            return s;
        }

    }

    private static final String SQL_INSERT = "INSERT INTO session_list (user_id, ip, user_agent, disabled) VALUES (?, ?, ?, ?);";

    private static final String SQL_UPDATE = "UPDATE public.session_list SET user_id = ?, ip = ?, user_agent = ?, disabled = ? WHERE id = ?;";

    private static final String SQL_FIND_BY_ID = "SELECT * FROM session_list WHERE id = ?;";

    @Autowired
    private JdbcOperations jdbc;

    public Session getSession(long sessionId) {
        Session session = null;
        try {
            session = jdbc.queryForObject(SQL_FIND_BY_ID, new SessionRowMapper(), sessionId);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return session;
    }

    public Session saveSession(final Session session) {
        KeyHolder holder = new GeneratedKeyHolder();
        int rows = 0;
        try {
            rows = jdbc.update(new PreparedStatementCreator() {

                public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                    PreparedStatement ps = conn.prepareStatement(SQL_INSERT, new String[] { "id" });

                    ps.setLong(1, session.getUserId());
                    ps.setString(2, session.getIp());
                    ps.setString(3, session.getUserAgent());
                    ps.setBoolean(4, session.isDisabled());

                    return ps;
                }
            }, holder);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        // if the operations was successed
        if (rows == 1) {
            session.setId(holder.getKey().longValue());
            return session;
        }
        return null;
    }

    public boolean updateSession(Session session) {
        try {
            int num = jdbc.update(SQL_UPDATE, session.getUserId(), session.getIp(), session.getUserAgent(),
                    session.isDisabled(), session.getId());
            return (num > 0) ? true : false;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

}
