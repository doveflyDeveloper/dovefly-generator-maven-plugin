package cn.dovefly.maven.plugin.vo;

public class JdbcConnection {
    private String driverClass;
    private String connectionURL;
    private String userId;
    private String password;

    public JdbcConnection(String driverClass, String connectionURL, String userId, String password) {
        this.driverClass = driverClass;
        this.connectionURL = connectionURL;
        this.userId = userId;
        this.password = password;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getConnectionURL() {
        return connectionURL;
    }

    public void setConnectionURL(String connectionURL) {
        this.connectionURL = connectionURL;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}