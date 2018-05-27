package com.goderyu.view;

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

import com.goderyu.util.Config;

/**
* @author 于好贤
* @version 创建时间：2017年12月29日 下午8:48:00
* @description 构造器构造表格窗体，其余方法均是调用存储过程的JAVA方法
*/
public class ShowDataTable extends JFrame  {
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

	public ShowDataTable() {
		super("于好贤201516010111");

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
		//this.setSize(700, 700);
		// 设定窗口左上角坐标（X轴200像素，Y轴100像素）
		this.setLocation(200, 100);
		// 设定窗口默认关闭方式为退出应用程序
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// 设置窗口可视（显示）
		this.setVisible(true);
		this.pack();
	}

	// 新增设备入库记录存储过程
	/**
	 * 
	 * @param repertoryNO 入库编号
	 * @param sort 类别
	 * @param dename 设备名
	 * @param type 型号
	 * @param spec 规格
	 * @param price 单价
	 * @param amount 数量
	 * @param date 购置日期
	 * @param providerNO 供应商编号
	 * @param purchaser 购买人
	 */
	public void executeInsertDeviceInfo(String repertoryNO,String sort,String dename,String type
			,String spec,double price,int amount,String date,String providerNO,String purchaser){

		try{
			Connection conn = DriverManager.getConnection(Config.url,Config.username,Config.password);
			PreparedStatement pstmt = conn.prepareStatement(
					"{call dbo.新增设备入库记录(?,?,?,?,?,?,?,?,?,?)}");	
			pstmt.setString(1,repertoryNO);
			pstmt.setString(2,sort);
			pstmt.setString(3,dename);
			pstmt.setString(4,type);
			pstmt.setString(5,spec);
			pstmt.setDouble(6,price);
			pstmt.setInt(7,amount);
			pstmt.setString(8,date);
			pstmt.setString(9,providerNO);
			pstmt.setString(10,purchaser);
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
			Vector< Vector<String>> data = new Vector< Vector<String>>();
			int rowCount = 0;
			// 有结果，返回结果进行测试
			while(rs.next()){
				rowCount++;
				// 行数据
				Vector<String> rowdata = new Vector<String>();
				for(int i =1; i <= colCount; i++) {
					rowdata.add(rs.getString(i));
				}
				data.add(rowdata);
			}
			if(rowCount == 0) {
				model.setDataVector(null,title);
			} else {
				model.setDataVector(data,title);
			}
			rs.close();
			pstmt.close();
            conn.close();
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, "操作失敗!", null,JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}