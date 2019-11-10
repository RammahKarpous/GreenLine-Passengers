package dbManager;

public abstract class DBCommand
{
    protected final String dbUsername;
    protected final String dbPassword;
    protected final String dbURL;

    public DBCommand()
    { 
        dbUsername = "admin1";
        dbPassword = "admin1";
        dbURL = "jdbc:derby://localhost:1527/Database";
    }
    
    public abstract Object execute();
}
