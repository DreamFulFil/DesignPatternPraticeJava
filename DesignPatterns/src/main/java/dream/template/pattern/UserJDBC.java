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
				sql.append("INSERT INTO USER VALUES(?,?,?)");
			case UPDATE:
				sql.append("UPDATE USER SET NAME = ?, AGE = ? WHERE UUID = ?");
			case DELETE:
				sql.append("DELETE FROM USER WHERE UUID = ? ");
			case SELECT:
				sql.append("SELECT * FROM USER WHERE 1 = 1");
		}
		
		return sql.toString();
	}
	
	private void setCreateValue(PreparedStatement pstmt, UserDataModel udm){}
	private void setUpdateValue(PreparedStatement pstmt, UserDataModel udm){}
	private void setDeleteValue(PreparedStatement pstmt, UserDataModel udm){}

	@Override
	protected void setUpdateSqlValue(OPERATION_TYPE type, PreparedStatement pstmt, UserDataModel udm) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setQuerySqlValue(PreparedStatement pstmt, UserDataModel udm) {
		// TODO Auto-generated method stub
		
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
