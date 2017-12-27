package hu.kuncystem.patient.triggers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.h2.api.Trigger;

/**
 * This class follow the change of appointment table. If we change or delete
 * from the appointment then this class save these changes into the
 * mod_appointment table.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. dec. 27.
 * 
 * @version 1.0
 */
public class ModAppointment implements Trigger {

    private String triggerType = "";

    /*
     * (non-Javadoc)
     * 
     * @see org.h2.api.Trigger#close()
     */
    public void close() throws SQLException {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.h2.api.Trigger#fire(java.sql.Connection, java.lang.Object[],
     * java.lang.Object[])
     */
    public void fire(Connection conn, Object[] oldRow, Object[] newRow) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(
                    "INSERT INTO mod_appointment_table (appointment_id,doctor_id,patient_id,appointment,description,sid,mod_type,mod_sid) "
                            + "VALUES (?,?,?,?,?,?,?,?);");

            int i = 1;
            // old data that we will save
            for (Object o : oldRow) {
                stmt.setObject(i, o);
                i++;
            }
            // trigger type
            stmt.setString(7, triggerType);
            stmt.setObject(8, oldRow[5]);

            stmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.h2.api.Trigger#init(java.sql.Connection, java.lang.String,
     * java.lang.String, java.lang.String, boolean, int)
     */
    public void init(Connection conn, String schemaName, String triggerName, String tableName, boolean before, int type)
            throws SQLException {
        switch (type) {
            case Trigger.DELETE: {
                triggerType = "D";
                break;
            }
            case Trigger.INSERT: {
                triggerType = "I";
                break;
            }
            case Trigger.UPDATE: {
                triggerType = "U";
                break;
            }
            default: {
                triggerType = "S";
            }
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.h2.api.Trigger#remove()
     */
    public void remove() throws SQLException {
        // TODO Auto-generated method stub

    }
}
