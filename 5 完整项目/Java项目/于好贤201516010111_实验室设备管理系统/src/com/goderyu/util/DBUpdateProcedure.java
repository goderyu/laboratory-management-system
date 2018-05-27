package com.goderyu.util;
/**
* @author 于好贤
* @version 创建时间：2017年11月30日 上午12:16:44
* @description 本类集中了事务更新（增删改）的调用存储过程的方法
*/
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DBUpdateProcedure{
	//a.调用实现向设备入库记录表插入数据的存储过程
	public static void executeInsertDeviceInfo(Connection con
		,String repertoryNO,String sort,String dename,String type
		,String spec,double price,int amount,String date,String providerNO,String purchaser){
		try{
			CallableStatement cstmt = con.prepareCall(
					"{call dbo.新增设备入库记录(?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1,repertoryNO);
			cstmt.setString(2,sort);
			cstmt.setString(3,dename);
			cstmt.setString(4,type);
			cstmt.setString(5,spec);
			cstmt.setDouble(6,price);
			cstmt.setInt(7,amount);
			cstmt.setString(8,date);
			cstmt.setString(9,providerNO);
			cstmt.setString(10,purchaser);
			/* 这里使用execute()方法，
			 此方法和executeUpdate()方法的区别在于
			 前者没有返回值，后者有INT返回值，表示受影响的行数
			 */
			cstmt.execute();
			int count = cstmt.getUpdateCount();
			cstmt.close();
			if(count>0){
				JOptionPane.showMessageDialog(null, "插入成功!");
			} else{
				JOptionPane.showMessageDialog(null, "插入失敗!", null,JOptionPane.ERROR_MESSAGE);
			}
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, "操作失敗!", null,JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	//b.调用实现向设备入库记录表更新数据的存储过程
	public static void executeUpdateDeviceInfo(Connection con
		,String repertoryNO,String sort,String dename,String type
		,String spec,double price,int amount,String date,String providerNO,String purchaser){
		try{
			CallableStatement cstmt = con.prepareCall(
					"{call dbo.更新设备入库记录(?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1,repertoryNO);
			cstmt.setString(2,sort);
			cstmt.setString(3,dename);
			cstmt.setString(4,type);
			cstmt.setString(5,spec);
			cstmt.setDouble(6,price);
			cstmt.setInt(7,amount);
			cstmt.setString(8,date);
			cstmt.setString(9,providerNO);
			cstmt.setString(10,purchaser);
			/* 这里使用execute()方法，
			 此方法和executeUpdate()方法的区别在于
			 前者没有返回值，后者有INT返回值，表示受影响的行数
			 */
			cstmt.execute();
			int count = cstmt.getUpdateCount();
			cstmt.close();
			if(count>0){
				JOptionPane.showMessageDialog(null, "修改成功!");
			} else{
				JOptionPane.showMessageDialog(null, "修改失敗!", null,JOptionPane.ERROR_MESSAGE);
			}
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, "操作失敗!", null,JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	//c.调用实现向设备入库记录表删除数据的存储过程
	public static void executeDeleteDeviceInfo(Connection con
		,String repertoryNO){
		try{
			CallableStatement cstmt = con.prepareCall(
					"{call dbo.删除设备入库记录(?)}");
			cstmt.setString(1,repertoryNO);
			/* 这里使用execute()方法，
			 此方法和executeUpdate()方法的区别在于
			 前者没有返回值，后者有INT返回值，表示受影响的行数
			 */
			cstmt.execute();
			int count = cstmt.getUpdateCount();
			cstmt.close();
			if(count>=0){
				JOptionPane.showMessageDialog(null, "删除成功!");
			} else{
				JOptionPane.showMessageDialog(null, "删除失敗!", null,JOptionPane.ERROR_MESSAGE);
			}
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, "操作失敗!", null,JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	//d.调用实现向供应商表更新数据的存储过程
	public static void executeUpdate(Connection con
		,String providerNO,String providerName,String phone){
		try{
			CallableStatement cstmt = con.prepareCall(
					"{call dbo.更新供应商信息(?,?,?)}");
			cstmt.setString(1,providerNO);
			cstmt.setString(2,providerName);
			cstmt.setString(3,phone);
			// 这里使用executeUpdate()方法
			int count = cstmt.executeUpdate();
			cstmt.close();
			if(count>0){
				JOptionPane.showMessageDialog(null, "更新成功!");
			} else{
				JOptionPane.showMessageDialog(null, "更新失敗!", null,JOptionPane.ERROR_MESSAGE);
			}
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, "操作失敗!", null,JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	//e.调用实现删除修理工表数据的存储过程
	public static void executeDelete(Connection con
		,String repairNO){
		try{
			CallableStatement cstmt = con.prepareCall(
					"{call dbo.删除修理工信息(?)}");
			cstmt.setString(1,repairNO);
			// 这里使用executeUpdate()方法
			int count = cstmt.executeUpdate();
			cstmt.close();
			if(count>0){
				JOptionPane.showMessageDialog(null, "删除成功!");
			} else{
				JOptionPane.showMessageDialog(null, "删除失敗!", null,JOptionPane.ERROR_MESSAGE);
			}
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, "操作失敗!", null,JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	//f. 调用获取密码的存储过程
	public String executeGetAdminOldPassword(String usernum,String oldpassword){

		try{
			Connection conn = DriverManager.getConnection(Config.url,Config.username,Config.password);
			CallableStatement cstmt = conn.prepareCall("{call dbo.获取原密码(?,?)}");

			cstmt.setString(1,usernum);
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			// 这里使用executeUpdate()方法
			cstmt.executeUpdate();
			oldpassword = cstmt.getString(2);
			cstmt.close();
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, "操作失敗!", null,JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return oldpassword;
	}
	
	//g. 调用更改密码的存储过程
	public void executeSetAdminNewPassword(String usernum,String newpassword){

		try{
			Connection conn = DriverManager.getConnection(Config.url,Config.username,Config.password);
			CallableStatement cstmt = conn.prepareCall("{call dbo.更改密码(?,?)}");
			cstmt.setString(1,usernum);
			cstmt.setString(2,newpassword);
			// 这里使用executeUpdate()方法
			int count = cstmt.executeUpdate();
			cstmt.close();
			if(count>0){
				JOptionPane.showMessageDialog(null, "密码修改成功!");
			} else{
				JOptionPane.showMessageDialog(null, "密码修改失敗!", null,JOptionPane.ERROR_MESSAGE);
			}
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, "操作失敗!", null,JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	//h. 调用获取管理员权限的存储过程
	public int executeGetAdminLimits(String usernum){
		int limits = 0;
		try{
			Connection conn = DriverManager.getConnection(Config.url,Config.username,Config.password);
			CallableStatement cstmt = conn.prepareCall("{call dbo.获取权限(?,?)}");

			cstmt.setString(1,usernum);
			cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
			// 这里使用executeUpdate()方法
			cstmt.executeUpdate();
			limits = cstmt.getInt(2);
			cstmt.close();
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, "操作失敗!", null,JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return limits;
	}
}