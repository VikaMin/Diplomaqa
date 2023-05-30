package ru.netology.data;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import java.sql.Connection;
import java.sql.DriverManager;


public class SqlHelper {

    @SneakyThrows
    public static Connection getConn() {
        var url = System.getProperty("url","jdbc:mysql://localhost:3306/app");
        var username = System.getProperty("username");
        var password = System.getProperty("password");
        return DriverManager.getConnection(url, username, password);

    }

    @SneakyThrows
    public static void cleanDataBase() {
        var deleteCreditRequest = "DELETE FROM credit_request_entity";
        var deleteOrderEntity = "DELETE FROM order_entity";
        var deletePaymentEntity = "DELETE FROM payment_entity";
        var runner = new QueryRunner();
        var conn = getConn();

        runner.update(conn, deleteCreditRequest);
        runner.update(conn, deleteOrderEntity);
        runner.update(conn, deletePaymentEntity);

    }

    @SneakyThrows
    public static String getPaymentStatus() {
        var conn = getConn();
        var countStmt = conn.createStatement();
        var paymentStatus = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1;";
        var resultSet = countStmt.executeQuery(paymentStatus);
        return resultSet.getString("status");

    }

    @SneakyThrows
    public static String getCreditStatus() {
        var conn = getConn();
        var countStmt = conn.createStatement();
        var creditStatus = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1;";
        var resultSet = countStmt.executeQuery(creditStatus);
        return resultSet.getString("status");

    }
}
