public class dbcredential {

    private String ost="jdbc:mysql://cs451dbremote.db.10419053.hostedresource.com/";
    private String dbname= "cs451dbremote";
    private String dbpass= "S4aw6WRA4u!";
    private String dbdriver = "com.mysql.jdbc.Driver";

    protected String getDbpass() {
        return dbpass;
    }

    protected String getDbname() {
        return dbname;
    }

    protected String getOst() {
        return ost;
    }

    protected String getDbdriver(){
        return dbdriver;
    }


}
