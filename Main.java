
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
        String user = "SYSTEM";
        String password = "123456789";

        try (Connection con =
                DriverManager.getConnection(url, user, password)) {

            System.out.println("Connected to Oracle Database!");

            while (true) {
                System.out.println("\n1. Add Student Result");
                System.out.println("2. Display All Results");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                if (choice == 1) {

                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();

                    System.out.print("Enter Student Name: ");
                    String name = sc.next();

                    System.out.print("Enter Subject 1 Marks: ");
                    int m1 = sc.nextInt();

                    System.out.print("Enter Subject 2 Marks: ");
                    int m2 = sc.nextInt();

                    System.out.print("Enter Subject 3 Marks: ");
                    int m3 = sc.nextInt();

                    if (m1 < 0 || m1 > 100 ||
                        m2 < 0 || m2 > 100 ||
                        m3 < 0 || m3 > 100) {

                        System.out.println("Invalid marks!");
                        continue;
                    }

                    int total = m1 + m2 + m3;
                    double percentage = total / 3.0;

                    String result;

                    if (m1 >= 40 && m2 >= 40 && m3 >= 40) {
                        result = "PASS";
                    } else {
                        result = "FAIL";
                    }

                    String sql = "INSERT INTO exam_results " +
                        "(roll_no, name, subject1, subject2, " +
                        "subject3, total, percentage, result) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                    PreparedStatement ps =
                        con.prepareStatement(sql);

                    ps.setInt(1, roll);
                    ps.setString(2, name);
                    ps.setInt(3, m1);
                    ps.setInt(4, m2);
                    ps.setInt(5, m3);
                    ps.setInt(6, total);
                    ps.setDouble(7, percentage);
                    ps.setString(8, result);

                    ps.executeUpdate();
                    ps.close();

                    System.out.println("Result Stored Successfully!");
                    System.out.println("Total: " + total);
                    System.out.printf("Percentage: %.2f%%\n", percentage);
                    System.out.println("Result: " + result);

                } else if (choice == 2) {

                    String sql =
                        "SELECT * FROM exam_results ORDER BY roll_no";

                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(sql);

                    System.out.println("\n--- EXAMINATION REPORT ---");

                    while (rs.next()) {
                        System.out.println("---------------------");
                        System.out.println("Roll No: " +
                            rs.getInt("roll_no"));
                        System.out.println("Name: " +
                            rs.getString("name"));
                        System.out.println("Total: " +
                            rs.getInt("total"));
                        System.out.println("Percentage: " +
                            rs.getDouble("percentage") + "%");
                        System.out.println("Result: " +
                            rs.getString("result"));
                    }

                    rs.close();
                    st.close();

                } else if (choice == 3) {
                    System.out.println("Exiting...");
                    break;

                } else {
                    System.out.println("Invalid Choice!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
