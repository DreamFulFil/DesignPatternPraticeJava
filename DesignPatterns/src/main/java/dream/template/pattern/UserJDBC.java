package dream.template.pattern;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserJDBC extends JDBCTemplate<UserDataModel>{

	@Override
	protected String getMainSql(OPERATION_TYPE type) {
		StringBuilder sql = new StringBuilder();
		
		switch(type){
			case CREATE:
				sql.append("INSERT INTO [USER](UUID, NAME, AGE) VALUES(?,?,?)");
				break;
			case UPDATE:
				sql.append("UPDATE [USER] SET NAME = ?, AGE = ? WHERE UUID = ?");
				break;
			case DELETE:
				sql.append("DELETE FROM [USER] WHERE UUID = ? ");
				break;
			case SELECT:
				sql.append("SELECT * FROM [USER] WHERE 1 = 1");
				break;
		}
		
		return sql.toString();
	}
	
	private void setCreateValue(PreparedStatement pstmt, UserDataModel udm) throws SQLException{
		pstmt.setString(1,udm.getUuid());
		pstmt.setString(2, udm.getName());
		pstmt.setInt(3,udm.getAge());
	}
	
	private void setUpdateValue(PreparedStatement pstmt, UserDataModel udm) throws SQLException{
		pstmt.setString(1,udm.getUuid());
		pstmt.setString(2, udm.getName());
		pstmt.setInt(3,udm.getAge());
	}
	
	private void setDeleteValue(PreparedStatement pstmt, UserDataModel udm) throws SQLException{
		pstmt.setString(1,udm.getUuid());
	}

	@Override
	protected void setUpdateSqlValue(OPERATION_TYPE type, PreparedStatement pstmt, UserDataModel udm) throws SQLException {
		switch(type){
			case CREATE:
				this.setCreateValue(pstmt, udm);
				break;
			case UPDATE:
				this.setUpdateValue(pstmt, udm);
				break;
			case DELETE:
				this.setDeleteValue(pstmt, udm);
				break;
			default:
				break;
		}
	}

	@Override
	protected String prepareQuerySql(String sql, UserDataModel udm) {
		StringBuilder builder = new StringBuilder();
		builder.append(sql);
		
		if(udm.getUuid() != null && udm.getUuid().length() !=0)
			builder.append(" AND UUID = ?");
		
		if(udm.getName() != null && udm.getName().length() !=0)
			builder.append(" AND NAME LIKE ?");
		
		if(udm.getAge() != 0)
			builder.append(" AND AGE = ?");
		
		return builder.toString();
	}

	@Override
	protected void setQuerySqlValue(PreparedStatement pstmt, UserDataModel udm) throws SQLException{
		int count = 1;
		if(udm.getUuid() != null && udm.getUuid().length() !=0){
			pstmt.setString(count, udm.getUuid());
			count++;
		}
		
		if(udm.getName() != null && udm.getName().length() !=0){
			pstmt.setString(count,  udm.getName());
			count++;
		}
		
		if(udm.getAge()!=0){
			pstmt.setInt(count, udm.getAge());
			count++;
		}
	}

	@Override
	protected UserDataModel rsToObj(ResultSet rs) throws SQLException {
		UserDataModel udm = new UserDataModel();
		udm.setUuid(rs.getString("UUID"));
		udm.setName(rs.getString("NAME"));
		udm.setAge(rs.getInt("AGE"));
		
		return udm;
	}
}
