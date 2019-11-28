package database.active_record;

import databaseB.ConnectionManager;
import databaseB.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserHandler
{

    private static final String FIND_USER_BY_ID = "SELECT * FROM Users WHERE UserId=?";
    private static final String FIND_USER_BY_EMAIL = "SELECT * FROM Users WHERE Email=?";

    private User prepareUser(ResultSet rs)
    {
        User sp = null;

        try
        {
            if (rs.next())
            {
                sp = new User(rs.getInt("UserId"),
                        rs.getString("Email"),
                        rs.getString("Password"));
            }
        }
        catch (SQLException sqle)
        {
        }

        return sp;
    }

    private ArrayList<User> prepareUsers(ResultSet rs)
    {
        ArrayList<User> list = new ArrayList();

        try
        {
            while (rs.next())
            {
                list.add(new User(rs.getInt("UserId"),
                        rs.getString("Email"),
                        rs.getString("Password")));
            }
        }
        catch (SQLException sqle)
        {
        }

        return list;
    }

    public User findUserByEmail(String email)
    {
        User sp = null;

        DatabaseConnection con = ConnectionManager.getInstance().getConnection();
        con.prepareStatement(FIND_USER_BY_EMAIL);
        con.setStatementParameter(1, email);
        if (con.executePreparedStatement())
        {
            sp = prepareUser(con.getResultSet());
        }
        con.close();

        return sp;
    }
    public User findUserById(int userId)
    {
        User sp = null;

        DatabaseConnection con = ConnectionManager.getInstance().getConnection();
        con.prepareStatement(FIND_USER_BY_ID);
        con.setStatementParameter(1, userId);
        if (con.executePreparedStatement())
        {
            sp = prepareUser(con.getResultSet());
        }
        con.close();

        return sp;
    }
}

