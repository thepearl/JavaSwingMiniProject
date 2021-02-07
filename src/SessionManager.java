import java.sql.*;

public class SessionManager {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/resto";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    static Connection conn = null;
    static Statement stmt = null;

    static public History[] getCommande()
    {
        History[] listOfHistory = new History[100];

        try
        {
            History history = new History();
            // create our mysql database connection
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM commandes";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");
                String articles = rs.getString("articles");
                String prix = rs.getString("prix");
                String date = rs.getString("date");

                history.id = id;
                history.article = articles;
                history.date = date;
                history.prix  = prix;

                // print the results
                for (int i=0;i<listOfHistory.length;i++) { // < instead of <=, don't hardcode the length
                    if (listOfHistory[i] == null) {
                        listOfHistory[i] = history;
                        break;                       // once we insert a, stop looping
                    }
                }
            }
            st.close();
            return listOfHistory;
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            return new History[10];
        }
    }

    static public void insertCommande(String article, String prix, String date)
    {
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating Table");
            stmt = conn.createStatement();
            String sql;

            sql = "INSERT INTO commandes " +
                    "VALUES (0, '"+article+"', '"+prix+"', '"+date+"')";
            stmt.executeUpdate(sql);

        } catch(Exception se){
            //Handle errors for JDBC
            se.printStackTrace();
        }//Handle errors for Class.forName
        finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }
}//end JDBCExample


class History
{
    int id;
    String date;
    String prix;
    String article;
    public  History(){}
}