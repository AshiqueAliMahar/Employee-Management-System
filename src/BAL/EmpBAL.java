package BAL;

import java.io.ByteArrayInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.EmployeeBean;
import DBConnect.DBConnect;

public class EmpBAL {

	public static ArrayList<EmployeeBean> getEmployees() throws SQLException {
		ArrayList<EmployeeBean> arrayList = new ArrayList<>();
		String sql = " SELECT emp_id,name,email,phone,pic FROM employee order by emp_id ";
		PreparedStatement preparedStatement = DBConnect.getCon().prepareStatement(sql);
		ResultSet rSet = preparedStatement.executeQuery();
		while (rSet.next()) {
			EmployeeBean employeeBean = new EmployeeBean(rSet.getInt(1), rSet.getString(2), rSet.getString(3),
					rSet.getString(4),rSet.getBytes(5));
			arrayList.add(employeeBean);
		}
		return arrayList;
	}
	public static EmployeeBean getEmployees(int id) throws SQLException {
		EmployeeBean employeeBean=null;
		String sql = " SELECT emp_id, name,email, phone,pic	FROM employee where emp_id="+id+" ";
		PreparedStatement preparedStatement = DBConnect.getCon().prepareStatement(sql);
		ResultSet rSet = preparedStatement.executeQuery();
		while (rSet.next()) {
			employeeBean = new EmployeeBean(rSet.getInt(1), rSet.getString(2), rSet.getString(3),
					rSet.getString(4),rSet.getBytes(5));
		}
		return employeeBean;
	}
	public static boolean delete(int id) {
		boolean isDeleted = false;
		String sql = " DELETE FROM employee\n" + "WHERE emp_id ="+id+" ";
		try {
			int check=DBConnect.getCon().createStatement().executeUpdate(sql);
			isDeleted=isChecked(check) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isDeleted;
	}
	public static boolean update(EmployeeBean employeeBean) {
		boolean isUpdated = false;
		String sql = " UPDATE employee SET name='"+employeeBean.getName()+"',EMAIL='"+employeeBean.getEmail()+"',PHONE='"+employeeBean.getPhone()+"' WHERE emp_id ="+employeeBean.getEmpId()+" ";
		try {
			int check=DBConnect.getCon().createStatement().executeUpdate(sql);
			isUpdated=isChecked(check) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
	}
	public static boolean isChecked(int check) {
		if(check>0) {
			return true;
		}else {
			return false;
		}	
	}
	public static boolean add(EmployeeBean employeeBean) throws SQLException {
		boolean isAdded=false;
		String sql=" INSERT INTO employee (name,email,phone,pic) VALUES (?,?,?,?) ";
		PreparedStatement preparedStatement=DBConnect.getCon().prepareStatement(sql);
		
		
		preparedStatement.setString(1, employeeBean.getName());
		preparedStatement.setString(2, employeeBean.getEmail());
		preparedStatement.setString(3, employeeBean.getPhone());
		preparedStatement.setBlob(4, new ByteArrayInputStream(employeeBean.getPic()));
		
		int check=preparedStatement.executeUpdate();
		isAdded=isChecked(check);
		return isAdded;
	}
}