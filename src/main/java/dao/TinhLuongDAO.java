package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TinhLuong;

public class TinhLuongDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/quanlynhansu1?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";
    
    // SQL queries
    private static final String INSERT_LUONG_SQL = "INSERT INTO TinhLuong "+" (maNV, thangNam, tongSoGioLam, heSoLuong, luongTheoGio, phuCap) VALUES"+" (?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_LUONG_SQL = "update tinhluong set maNV=?, thangNam=?,tongSoGioLam=?,heSoLuong=?,luongTheoGio=?,phuCap=? where maBangLuong=?";
    private static final String SELECT_ALL_LUONG = "SELECT * FROM TinhLuong";
    public static final String SELECT_LUONG_BY_MABANGLUONG = "select maNV,thangNam,tongSoGioLam,heSoLuong,luongTheoGio,phuCap,tongLuong from tinhluong where maBangLuong=?";
    private static final String DELETE_LUONG_SQL = "DELETE FROM TinhLuong WHERE maBangLuong=?";
    
    public TinhLuongDAO() { }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Insert a new salary record
    public void insertLuong(TinhLuong tinhluong) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LUONG_SQL)) {
            preparedStatement.setString(1,tinhluong.getMaNV());
            preparedStatement.setString(2, tinhluong.getThangNam());
            preparedStatement.setBigDecimal(3, tinhluong.getTongSoGioLam());
            preparedStatement.setBigDecimal(4, tinhluong.getHeSoLuong());
            preparedStatement.setBigDecimal(5, tinhluong.getLuongTheoGio());
            preparedStatement.setBigDecimal(6, tinhluong.getPhuCap());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //update salary
    public boolean updateLuong(TinhLuong tinhluong) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_LUONG_SQL)) {
        	statement.setString(1,tinhluong.getMaNV());
            statement.setString(2, tinhluong.getThangNam());
            statement.setBigDecimal(3, tinhluong.getTongSoGioLam());
            statement.setBigDecimal(4, tinhluong.getHeSoLuong());
            statement.setBigDecimal(5, tinhluong.getLuongTheoGio());
            statement.setBigDecimal(6, tinhluong.getPhuCap());
            
            statement.setInt(7, tinhluong.getMaBangLuong());
            rowUpdated = statement.executeUpdate()>0;
        }
        return rowUpdated;
    }

    // Retrieve all salary records
    public List<TinhLuong> selectAllLuong() {
        List<TinhLuong> luongs = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LUONG)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int maBangLuong = rs.getInt("maBangLuong");
                String maNV = rs.getString("maNV");
                String thangNam = rs.getString("thangNam");
                BigDecimal tongSoGioLam = rs.getBigDecimal("tongSoGioLam");
                BigDecimal heSoLuong = rs.getBigDecimal("heSoLuong");
                BigDecimal luongTheoGio = rs.getBigDecimal("luongTheoGio");
                BigDecimal phuCap = rs.getBigDecimal("phuCap");
                BigDecimal tongLuong = rs.getBigDecimal("tongLuong");

               luongs.add(new TinhLuong(maBangLuong, maNV, thangNam, tongSoGioLam, heSoLuong, luongTheoGio, phuCap, tongLuong));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return luongs;
    }

    // Delete a salary record
    public boolean deleteLuong(int maBangLuong) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_LUONG_SQL)) {
            statement.setInt(1, maBangLuong);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    //select by maBangLuong salary
    public TinhLuong selectTinhLuong(int maBangLuong) {
    	TinhLuong tinhLuong=null;
    	try (Connection connection=getConnection();
    			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_LUONG_BY_MABANGLUONG);){
    				preparedStatement.setInt(1,maBangLuong);
    				System.out.println(preparedStatement);
    				ResultSet rs=preparedStatement.executeQuery();
    				if(rs.next()) {
    					    String maNV = rs.getString("maNV");
    		                String thangNam = rs.getString("thangNam");
    		                BigDecimal tongSoGioLam = rs.getBigDecimal("tongSoGioLam");
    		                BigDecimal heSoLuong = rs.getBigDecimal("heSoLuong");
    		                BigDecimal luongTheoGio = rs.getBigDecimal("luongTheoGio");
    		                BigDecimal phuCap = rs.getBigDecimal("phuCap");
    		                tinhLuong =new TinhLuong(maBangLuong,maNV,thangNam,tongSoGioLam,heSoLuong,luongTheoGio,phuCap);
    				}
    			}catch (SQLException e) {
    				e.printStackTrace();
					// TODO: handle exception
				}
    	return tinhLuong;
    }
    private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
   
}
