package Efficiency.Pages;

import Efficiency.CommonFunctions;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PressCenterPage extends CommonFunctions {

    public List<Map<String, Object>> getNewsInformationById(long contentItemId) throws SQLException {
        String query = "SELECT * FROM public.content_630 WHERE content_item_id = ?";
        List<Map<String, Object>> itemList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setLong(1, contentItemId);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Map<String, Object> row = new HashMap<>();
                    row.put("content_item_id", rs.getLong("content_item_id"));
                    row.put("title", rs.getString("title"));
                    row.put("description", rs.getString("description"));
                    row.put("image", rs.getString("image"));

                    itemList.add(row);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemList;
    }


}
