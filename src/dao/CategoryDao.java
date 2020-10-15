package dao;
import commons.DBUtil;
import java.util.ArrayList;
import vo.Category;
import java.sql.*;

public class CategoryDao { // ī�װ� ��� 
	public ArrayList<Category> selectCategoryList() throws Exception {
		ArrayList<Category> list = new ArrayList<Category>();
		
		DBUtil dbUtil = new DBUtil();
		Connection conn = dbUtil.getConnection();		
		
		String sql = "select category_id, category_name from category";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
		
			Category category = new Category();
	
			category.setCategoryId(rs.getInt("category_id"));
			category.setCategoryName(rs.getString("category_name"));
		
			list.add(category);
		}
		
		conn.close();
		return list;
	}
	
	public ArrayList<Category> selectCategoryCkList() throws Exception { // ī�װ� ��õ ����Ʈ 
		ArrayList<Category> list = new ArrayList<Category>();
		
		DBUtil dbUtil = new DBUtil();
		Connection conn = dbUtil.getConnection();		
		
		String sql = "select category_id, category_pic from category where category_ck = 'Y' limit 0, 4";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
		
			Category category = new Category();
			
			category.setCategoryId(rs.getInt("category_id"));
			category.setCategoryPic(rs.getString("category_pic"));
			
			list.add(category);
		}
		
		conn.close();
		return list;
	}
}
