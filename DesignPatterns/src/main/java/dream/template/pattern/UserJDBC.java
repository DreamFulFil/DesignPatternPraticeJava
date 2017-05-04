package dream.template.pattern;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserJDBC extends JDBCTemplate<UserDataModel>{

	@Override
	protected String getMainSql(int type) {
		StringBuilder sql = new StringBuilder();
		
		switch(type){
			case TYPE_CREATE:
				sql.append("INSERT INTO USER VALUES(?,?,?)");
			case TYPE_UPDATE:
				sql.append("UPDATE USER SET NAME = ?, AGE = ? WHERE UUID = ?");
			case TYPE_DELETE:
				sql.append("DELETE FROM USER WHERE UUID = ? ");
			case TYPE_CONDITION:
				sql.append("SELECT * FROM USER WHERE 1 = 1");
		}
		
		return sql.toString();
	}
	
	private void setCreateValue(PreparedStatement pstmt, UserDataModel udm){}
	private void setUpdateValue(PreparedStatement pstmt, UserDataModel udm){}
	private void setDeleteValue(PreparedStatement pstmt, UserDataModel udm){}

	@Override
	protected void setUpdateSqlValue(int type, PreparedStatement pstmt, UserDataModel udm) {
		switch(type){
			case TYPE_CREATE:
				this.setCreateValue(pstmt, udm);
				break;
			case TYPE_UPDATE:
				this.setUpdateValue(pstmt, udm);
				break;
			case TYPE_DELETE:
				this.setDeleteValue(pstmt, udm);
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
