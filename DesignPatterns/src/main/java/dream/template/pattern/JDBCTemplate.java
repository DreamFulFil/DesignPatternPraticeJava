package dream.template.pattern;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public abstract class JDBCTemplate<T> {
	
	protected final static int TYPE_CREATE = 1;
	protected final static int TYPE_UPDATE = 2;
	protected final static int TYPE_DELETE = 3;
	protected final static int TYPE_CONDITION = 4;
	
	private static final String JDBC_URL = "jdbc:sqlserver://172.16.4.64";
	private static final String JDBC_USER = "sa";
	private static final String JDBC_PASS = "P@ssw0rd";
	private static final String JDBC_DB_NAME = "GCRDB";
	
	/**
	 * Template method for insert
	 * @param obj
	 */
	public final void create(T obj){
		String sql = this.getMainSql(TYPE_CREATE);
		this.executeUpdate(sql, TYPE_CREATE, obj);
	}
	
	/**
	 * Template method for update
	 * @param obj
	 */
	public final void update(T obj){
		String sql = this.getMainSql(TYPE_UPDATE);
		this.executeUpdate(sql, TYPE_UPDATE, obj);
	}
	
	/**
	 * Template method for delete
	 * @param obj
	 */
	public final void delete(T obj){
		String sql = this.getMainSql(TYPE_DELETE);
		this.executeUpdate(sql, TYPE_DELETE, obj);
	}
	
	/**
	 * Template method for select
	 * @param queryModel
	 * @return
	 */
	public final Collection<T> findByCondition(T queryModel){
		String sql = this.getMainSql(TYPE_CONDITION);
		return this.getByCondition(sql, queryModel);
	}
	
	/**
	 * Primitive methods
	 * @param type
	 * @return
	 */
	protected abstract String getMainSql(int type);
	protected abstract void setUpdateSqlValue(int type, PreparedStatement pstmt, T obj);
	protected abstract String prepareQuerySql(String sql, T queryModel);
	protected abstract void setQuerySqlValue(PreparedStatement pstmt, T queryModel);
	protected abstract T rsToObj(ResultSet rs) throws SQLException;
	
	/**
	 * Get Connection using SQLServerDataSource
	 */
	protected Connection getConnection()throws SQLException{
		SQLServerDataSource ds = new SQLServerDataSource();
		ds.setURL(JDBC_URL);
		ds.setUser(JDBC_USER);
		ds.setPassword(JDBC_PASS);
		ds.setDatabaseName(JDBC_DB_NAME);
		
		return ds.getConnection();
	}
	
	/**
	 * Execute Select
	 * @param sql The SELECT statement with "?"
	 * @param queryModel
	 * @return
	 */
	protected Collection<T> getByCondition(String sql, T queryModel){
		Collection<T> col = new ArrayList<T>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = this.getConnection();
			sql = this.prepareQuerySql(sql, queryModel);
			pstmt = conn.prepareStatement(sql);
			this.setQuerySqlValue(pstmt, queryModel);
			rs = pstmt.executeQuery();
			while(rs.next()){
				col.add(this.rsToObj(rs));
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		finally{
			try{
				rs.close();
				pstmt.close();	
				conn.close();
			}
			catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		return col;
	}
	
	/**
	 * Execute Update/Insert/Delete
	 * @param sql
	 * @param type
	 * @param obj
	 * @return
	 */
	protected int executeUpdate(String sql, int type, T obj){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			this.setUpdateSqlValue(type, pstmt, obj);
			int updatedRows = pstmt.executeUpdate();
			return updatedRows;
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		finally{
			try{
				pstmt.close();	
				conn.close();
			}
			catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		return 0;
	}
}
