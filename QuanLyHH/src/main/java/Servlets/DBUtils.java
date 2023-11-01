package Servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    public static void insertUserAccount(Connection conn, UserAccount user) throws SQLException {
        String sql = "INSERT INTO User_Account (UserName, Gender, Password) VALUES (?, ?, ?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getGender());
            pstmt.setString(3, user.getPassword());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static UserAccount findUser(Connection conn, String userName, String password) {
		String sql = "SELECT * FROM User_Account WHERE UserName = ? AND Password = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String gender = rs.getString("Gender");
                    UserAccount user = new UserAccount();
                    user.setUserName(userName);
                    user.setGender(gender);
                    user.setPassword(password);
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    public static List<Product> queryProduct(Connection conn) throws SQLException {
        String sql = "SELECT a.ID, a.Name, a.Type, a.Price FROM Product a";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<Product> list = new ArrayList<Product>();

        while (rs.next()) {
            String id = rs.getString("ID");
            String name = rs.getString("Name");
            String type = rs.getString("Type");
            int price = rs.getInt("Price");

            Product product = new Product();
            product.setID(id);
            product.setName(name);
            product.setType(type);
            product.setPrice(price);

            list.add(product);
        }

        return list;
    }

	public static void updateProduct(Connection conn, Product pro) {
		// TODO Auto-generated method stub
		
	}

	public static Product insertProduct(Connection conn, Product pro) {
		return null;
		// TODO Auto-generated method stub
		
	}

	public static Product findProduct(Connection conn, String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
