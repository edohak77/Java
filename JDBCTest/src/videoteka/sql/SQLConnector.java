package videoteka.sql;

import java.sql.*;

public class SQLConnector {
    private Connection connection = null;
    private String connectionUrl = "jdbc:mysql://localhost:3306/Videoteka";
    private String password = "1111";
    private String user = "root";


    public SQLConnector(String connectionUrl, String password, String user) {
        this.connectionUrl = connectionUrl;
        this.password = password;
        this.user = user;

    }

    public SQLConnector() {}

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void connectDb() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(connectionUrl,user,password);
        System.out.println("We coneccted!!!");
    }

    public Statement getStatmen() throws SQLException {
        if (connection != null){
            Statement statement = connection.createStatement();
            if (statement != null) return statement;
        }
        throw new  SQLException("coonnecttion or statment is null!");
    }

    public void closeStatement(Statement statement){
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public PreparedStatement getPrepareStatment(String sql) throws SQLException {
        if (connection != null){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeQuery();
            if (statement != null) return statement;
        }
        throw new  SQLException("coonnecttion or statment is null!");
    }
}
