package com.goderyu.util;

/**
* @author 于好贤
* @version 创建时间：2018年1月2日 下午6:07:31
* @description 本类封装了设备修理情况的查询存储过程
*/
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class DBQueryProcedureModelThree extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 声明滚动面板
	private JScrollPane spTable;
	// 声明默认表格模式
	private DefaultTableModel model;
	// 声明表格
	private JTable table;

	public DBQueryProcedureModelThree() {
		super("于好贤");

		// 创建默认表格模式
		model = new DefaultTableModel();
		// 创建表格
		table = new JTable(model);
		// 设置表格选择模式为单一选择
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// 创建一个滚动面板，包含表格
		spTable = new JScrollPane(table);
		// 将滚动面板添加到窗体中央
		this.add(spTable, BorderLayout.CENTER);
		// 设定窗口大小
		this.setSize(800, 400);
		// 设定窗口左上角坐标（X轴200像素，Y轴100像素）
		this.setLocationRelativeTo(null);
		// 设定窗口默认关闭方式为退出应用程序
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// 设置窗口可视（显示）
		this.setVisible(true);
	}

	// 调用查询所有设备修理记录的存储过程
	public void executeSelectDeviceRepaired() {

		try {
			Connection conn = DriverManager.getConnection(Config.url, Config.username, Config.password);
			PreparedStatement pstmt = conn.prepareStatement("{call dbo.查询所有设备修理记录}");
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			// 获取列数
			int colCount = rsmd.getColumnCount();
			// 存放列名
			Vector<String> title = new Vector<String>();
			// 列名
			for (int i = 1; i <= colCount; i++) {
				title.add(rsmd.getColumnLabel(i));
			}
			// 表格数据
			Vector<Vector<String>> data = new Vector<Vector<String>>();
			int rowCount = 0;
			// 有结果，返回结果进行测试
			while (rs.next()) {
				rowCount++;
				// 行数据
				Vector<String> rowdata = new Vector<String>();
				for (int i = 1; i <= colCount; i++) {
					rowdata.add(rs.getString(i));
				}
				data.add(rowdata);
			}
			if (rowCount == 0) {
				model.setDataVector(null, title);
			} else {
				model.setDataVector(data, title);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "操作失敗!", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	// 调用按类别查询设备修理记录的存储过程
	public void executeSelectDeviceRepaired4Type(String type) {

		try {
			Connection conn = DriverManager.getConnection(Config.url, Config.username, Config.password);
			PreparedStatement pstmt = conn.prepareStatement("{call dbo.按类别查询设备修理记录(?)}");
			pstmt.setString(1, type);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			// 获取列数
			int colCount = rsmd.getColumnCount();
			// 存放列名
			Vector<String> title = new Vector<String>();
			// 列名
			for (int i = 1; i <= colCount; i++) {
				title.add(rsmd.getColumnLabel(i));
			}
			// 表格数据
			Vector<Vector<String>> data = new Vector<Vector<String>>();
			int rowCount = 0;
			// 有结果，返回结果进行测试
			while (rs.next()) {
				rowCount++;
				// 行数据
				Vector<String> rowdata = new Vector<String>();
				for (int i = 1; i <= colCount; i++) {
					rowdata.add(rs.getString(i));
				}
				data.add(rowdata);
			}
			if (rowCount == 0) {
				model.setDataVector(null, title);
			} else {
				model.setDataVector(data, title);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "操作失敗!", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	// 调用按类别统计设备修理记录的存储过程
	public void executeTongjiDeviceRepaired4Type(String type) {

		try {
			Connection conn = DriverManager.getConnection(Config.url, Config.username, Config.password);
			PreparedStatement pstmt = conn.prepareStatement("{call dbo.按类别统计设备修理记录(?)}");
			pstmt.setString(1, type);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			// 获取列数
			int colCount = rsmd.getColumnCount();
			// 存放列名
			Vector<String> title = new Vector<String>();
			// 列名
			for (int i = 1; i <= colCount; i++) {
				title.add(rsmd.getColumnLabel(i));
			}
			// 表格数据
			Vector<Vector<String>> data = new Vector<Vector<String>>();
			int rowCount = 0;
			// 有结果，返回结果进行测试
			while (rs.next()) {
				rowCount++;
				// 行数据
				Vector<String> rowdata = new Vector<String>();
				for (int i = 1; i <= colCount; i++) {
					rowdata.add(rs.getString(i));
				}
				data.add(rowdata);
			}
			if (rowCount == 0) {
				model.setDataVector(null, title);
			} else {
				model.setDataVector(data, title);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "操作失敗!", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	// 调用按修理日期查询设备修理记录的存储过程
	public void executeSelectDeviceRepaired4Date(String sdate, String edate) {

		try {
			Connection conn = DriverManager.getConnection(Config.url, Config.username, Config.password);
			PreparedStatement pstmt = conn.prepareStatement("{call dbo.按修理日期查询设备修理记录(?,?)}");
			pstmt.setString(1, sdate);
			pstmt.setString(2, edate);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			// 获取列数
			int colCount = rsmd.getColumnCount();
			// 存放列名
			Vector<String> title = new Vector<String>();
			// 列名
			for (int i = 1; i <= colCount; i++) {
				title.add(rsmd.getColumnLabel(i));
			}
			// 表格数据
			Vector<Vector<String>> data = new Vector<Vector<String>>();
			int rowCount = 0;
			// 有结果，返回结果进行测试
			while (rs.next()) {
				rowCount++;
				// 行数据
				Vector<String> rowdata = new Vector<String>();
				for (int i = 1; i <= colCount; i++) {
					rowdata.add(rs.getString(i));
				}
				data.add(rowdata);
			}
			if (rowCount == 0) {
				model.setDataVector(null, title);
			} else {
				model.setDataVector(data, title);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "操作失敗!", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	// 调用按修理日期统计设备修理记录的存储过程
	public void executeTongjiDeviceRepaired4Date(String sdate, String edate) {

		try {
			Connection conn = DriverManager.getConnection(Config.url, Config.username, Config.password);
			PreparedStatement pstmt = conn.prepareStatement("{call dbo.按修理日期统计设备修理记录(?,?)}");
			pstmt.setString(1, sdate);
			pstmt.setString(2, edate);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			// 获取列数
			int colCount = rsmd.getColumnCount();
			// 存放列名
			Vector<String> title = new Vector<String>();
			// 列名
			for (int i = 1; i <= colCount; i++) {
				title.add(rsmd.getColumnLabel(i));
			}
			// 表格数据
			Vector<Vector<String>> data = new Vector<Vector<String>>();
			int rowCount = 0;
			// 有结果，返回结果进行测试
			while (rs.next()) {
				rowCount++;
				// 行数据
				Vector<String> rowdata = new Vector<String>();
				for (int i = 1; i <= colCount; i++) {
					rowdata.add(rs.getString(i));
				}
				data.add(rowdata);
			}
			if (rowCount == 0) {
				model.setDataVector(null, title);
			} else {
				model.setDataVector(data, title);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "操作失敗!", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	// 调用按修理厂家查询设备修理记录的存储过程
	public void executeSelectDeviceRepaired4Garage(String garage) {

		try {
			Connection conn = DriverManager.getConnection(Config.url, Config.username, Config.password);
			PreparedStatement pstmt = conn.prepareStatement("{call dbo.按修理厂家查询设备修理记录(?)}");
			pstmt.setString(1, garage);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			// 获取列数
			int colCount = rsmd.getColumnCount();
			// 存放列名
			Vector<String> title = new Vector<String>();
			// 列名
			for (int i = 1; i <= colCount; i++) {
				title.add(rsmd.getColumnLabel(i));
			}
			// 表格数据
			Vector<Vector<String>> data = new Vector<Vector<String>>();
			int rowCount = 0;
			// 有结果，返回结果进行测试
			while (rs.next()) {
				rowCount++;
				// 行数据
				Vector<String> rowdata = new Vector<String>();
				for (int i = 1; i <= colCount; i++) {
					rowdata.add(rs.getString(i));
				}
				data.add(rowdata);
			}
			if (rowCount == 0) {
				model.setDataVector(null, title);
			} else {
				model.setDataVector(data, title);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "操作失敗!", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	// 调用按修理厂家统计设备修理记录的存储过程
	public void executeTongjiDeviceRepaired4Garage(String garage) {

		try {
			Connection conn = DriverManager.getConnection(Config.url, Config.username, Config.password);
			PreparedStatement pstmt = conn.prepareStatement("{call dbo.按修理厂家统计设备修理记录(?)}");
			pstmt.setString(1, garage);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			// 获取列数
			int colCount = rsmd.getColumnCount();
			// 存放列名
			Vector<String> title = new Vector<String>();
			// 列名
			for (int i = 1; i <= colCount; i++) {
				title.add(rsmd.getColumnLabel(i));
			}
			// 表格数据
			Vector<Vector<String>> data = new Vector<Vector<String>>();
			int rowCount = 0;
			// 有结果，返回结果进行测试
			while (rs.next()) {
				rowCount++;
				// 行数据
				Vector<String> rowdata = new Vector<String>();
				for (int i = 1; i <= colCount; i++) {
					rowdata.add(rs.getString(i));
				}
				data.add(rowdata);
			}
			if (rowCount == 0) {
				model.setDataVector(null, title);
			} else {
				model.setDataVector(data, title);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "操作失敗!", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

}
