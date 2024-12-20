package hy.eom.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Sql_Test {
    // JDBC URL, 사용자 이름, 비밀번호
    private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "C##GENEJAR";
    private static final String PASSWORD = "GENEJAR";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Oracle JDBC 드라이버를 로드합니다.
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 데이터베이스에 연결합니다.
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            // SQL 쿼리를 실행합니다.
            statement = connection.createStatement();
            String query = "SELECT EMP_NAME, EMP_ID, EMP_PWD FROM EMPLOYEE";
            resultSet = statement.executeQuery(query);

            // 결과를 처리합니다.
            while (resultSet.next()) {
                System.out.println("사원이름 : " + resultSet.getString(1));
                System.out.println("사원 아이디 : " + resultSet.getString(2));
                System.out.println("사원 비밀번호 : " + resultSet.getString(3));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC 드라이버를 찾을 수 없습니다.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결에 실패했습니다.");
            e.printStackTrace();
        } finally {
            // 리소스를 해제합니다.
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}