package com.goderyu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.goderyu.util.DBQueryProcedureModelFour;
import com.goderyu.util.DBQueryProcedureModelOne;
import com.goderyu.util.DBQueryProcedureModelThree;
import com.goderyu.util.DBQueryProcedureModelTwo;

/**
* @author 于好贤
* @version 创建时间：2017年11月29日 下午11:11:07
* @description 实验室设备管理系统主窗体
*/
public class OnlySelectMainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField itypeField;
	private JTextField selectRunningDevice4LabField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OnlySelectMainFrame frame = new OnlySelectMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OnlySelectMainFrame() {
		setTitle("于好贤201516010111_实验室设备管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(458, 541);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_1.add(tabbedPane, BorderLayout.CENTER);

		JPanel insertSchoolsPanel = new JPanel();
		tabbedPane.addTab("1. 设备入库记录管理", null, insertSchoolsPanel, null);
		insertSchoolsPanel.setLayout(null);

		JLabel irepertoryNOLabel = new JLabel("　入库编号 ：");
		irepertoryNOLabel.setBounds(47, 143, 102, 15);
		insertSchoolsPanel.add(irepertoryNOLabel);

		JLabel itypeLabel = new JLabel("　　　型号 ：");
		itypeLabel.setBounds(47, 416, 102, 15);
		insertSchoolsPanel.add(itypeLabel);

		itypeField = new JTextField();
		itypeField.setBounds(132, 413, 166, 21);
		insertSchoolsPanel.add(itypeField);
		itypeField.setColumns(10);

		JLabel idateLabel = new JLabel("　起始日期 ：");
		idateLabel.setBounds(61, 236, 102, 15);
		insertSchoolsPanel.add(idateLabel);

		JComboBox<String> yearComboBox = new JComboBox<String>();
		yearComboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "2014", "2015", "2016", "2017" }));
		yearComboBox.setBounds(156, 233, 62, 21);
		insertSchoolsPanel.add(yearComboBox);

		JComboBox<String> monthComboBox = new JComboBox<String>();
		monthComboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		monthComboBox.setBounds(236, 233, 46, 21);
		insertSchoolsPanel.add(monthComboBox);

		JComboBox<String> dayComboBox = new JComboBox<String>();
		dayComboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		dayComboBox.setBounds(307, 233, 46, 21);
		insertSchoolsPanel.add(dayComboBox);

		JLabel label_1 = new JLabel("年");
		label_1.setBounds(220, 236, 17, 15);
		insertSchoolsPanel.add(label_1);

		JLabel label_2 = new JLabel("月");
		label_2.setBounds(285, 236, 17, 15);
		insertSchoolsPanel.add(label_2);

		JLabel label_3 = new JLabel("日");
		label_3.setBounds(355, 236, 17, 15);
		insertSchoolsPanel.add(label_3);

		JLabel label_12 = new JLabel(
				"--------------------------------------❀好贤专属分割线❀-------------------------------------");
		label_12.setBounds(10, 350, 416, 15);
		insertSchoolsPanel.add(label_12);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(132, 140, 166, 21);
		insertSchoolsPanel.add(textField);

		JButton button_3 = new JButton("查　询");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String repertoryNO = textField.getText().toString().trim();
				new DBQueryProcedureModelOne().executeSelectDeviceInfo(repertoryNO);
			}
		});
		button_3.setBounds(312, 139, 93, 23);
		insertSchoolsPanel.add(button_3);
		
		JButton button_5 = new JButton("查询所有设备入库记录");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DBQueryProcedureModelOne().executeSelectDeviceInfo("all");
			}
		});
		button_5.setBounds(140, 46, 187, 23);
		insertSchoolsPanel.add(button_5);
		
		JLabel label_15 = new JLabel("1. 查询所有的设备入库记录：");
		label_15.setBounds(47, 21, 220, 15);
		insertSchoolsPanel.add(label_15);
		
		JLabel label_13 = new JLabel("--------------------------------------❀好贤专属分割线❀-------------------------------------");
		label_13.setBounds(10, 79, 416, 15);
		insertSchoolsPanel.add(label_13);
		
		JLabel label_37 = new JLabel("2. 按入库编号查询设备入库记录：");
		label_37.setBounds(47, 104, 220, 15);
		insertSchoolsPanel.add(label_37);
		
		JLabel label_38 = new JLabel("--------------------------------------❀好贤专属分割线❀-------------------------------------");
		label_38.setBounds(10, 172, 416, 15);
		insertSchoolsPanel.add(label_38);
		
		JLabel label_39 = new JLabel("3. 按日期查询设备入库记录：");
		label_39.setBounds(47, 197, 220, 15);
		insertSchoolsPanel.add(label_39);
		
		JLabel label_40 = new JLabel("　结束日期 ：");
		label_40.setBounds(61, 277, 102, 15);
		insertSchoolsPanel.add(label_40);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "2014", "2015", "2016", "2017" }));
		comboBox.setBounds(156, 274, 62, 21);
		insertSchoolsPanel.add(comboBox);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		comboBox_1.setBounds(236, 274, 46, 21);
		insertSchoolsPanel.add(comboBox_1);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setModel(new DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		comboBox_2.setBounds(307, 274, 46, 21);
		insertSchoolsPanel.add(comboBox_2);
		
		JLabel label_41 = new JLabel("年");
		label_41.setBounds(220, 277, 17, 15);
		insertSchoolsPanel.add(label_41);
		
		JLabel label_42 = new JLabel("月");
		label_42.setBounds(285, 277, 17, 15);
		insertSchoolsPanel.add(label_42);
		
		JLabel label_43 = new JLabel("日");
		label_43.setBounds(355, 277, 17, 15);
		insertSchoolsPanel.add(label_43);
		
		JButton button_6 = new JButton("查　询");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String syear = yearComboBox.getSelectedItem().toString();
				String smonth = monthComboBox.getSelectedItem().toString();
				String sday = dayComboBox.getSelectedItem().toString();
				String sdate = syear + "-" + smonth + "-" + sday;
				String eyear = comboBox.getSelectedItem().toString();
				String emonth = comboBox_1.getSelectedItem().toString();
				String eday = comboBox_2.getSelectedItem().toString();
				String edate = eyear + "-" + emonth + "-" + eday;
				new DBQueryProcedureModelOne().executeSelectDeviceInfo4Date(sdate, edate);
			}
		});
		button_6.setBounds(171, 317, 93, 23);
		insertSchoolsPanel.add(button_6);
		
		JLabel label = new JLabel("4. 按型号查询设备入库记录：");
		label.setBounds(47, 375, 220, 15);
		insertSchoolsPanel.add(label);
		
		JButton button_7 = new JButton("查　询");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = itypeField.getText().toString().trim();
				new DBQueryProcedureModelOne().executeSelectDeviceInfo4Type(type);
			}
		});
		button_7.setBounds(312, 412, 93, 23);
		insertSchoolsPanel.add(button_7);

		JPanel selectSchoolsPanel = new JPanel();
		tabbedPane.addTab("2. 设备运行状况模块", null, selectSchoolsPanel, null);
		selectSchoolsPanel.setLayout(null);

		JLabel selectRunningDevice4LabLabel = new JLabel("　实验室编号：");
		selectRunningDevice4LabLabel.setBounds(85, 298, 101, 15);
		selectSchoolsPanel.add(selectRunningDevice4LabLabel);

		selectRunningDevice4LabField = new JTextField();
		selectRunningDevice4LabField.setColumns(10);
		selectRunningDevice4LabField.setBounds(176, 295, 178, 21);
		selectSchoolsPanel.add(selectRunningDevice4LabField);

		JButton selectRunningDevice4LabButton = new JButton("　查　询　");
		selectRunningDevice4LabButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String labNO = selectRunningDevice4LabField.getText().toString().trim();
				new DBQueryProcedureModelTwo().executeSelectDeviceRunning4Lab(labNO);
			}
		});
		selectRunningDevice4LabButton.setBounds(117, 350, 101, 23);
		selectSchoolsPanel.add(selectRunningDevice4LabButton);

		JButton selectAllRunningDeviceButton = new JButton("查询所有设备运行状况");
		selectAllRunningDeviceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DBQueryProcedureModelTwo().executeSelectDeviceRunning();
			}
		});
		selectAllRunningDeviceButton.setBounds(135, 86, 187, 23);
		selectSchoolsPanel.add(selectAllRunningDeviceButton);

		JButton statisticsRunningDevice4LabButton = new JButton("　统　计　");
		statisticsRunningDevice4LabButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String labNO = selectRunningDevice4LabField.getText().toString().trim();
				new DBQueryProcedureModelTwo().executeStatisticsDeviceRunning4Lab(labNO);
			}
		});
		statisticsRunningDevice4LabButton.setBounds(239, 350, 101, 23);
		selectSchoolsPanel.add(statisticsRunningDevice4LabButton);

		JLabel label_4 = new JLabel("1. 查询所有设备的运行状况：");
		label_4.setBounds(43, 41, 220, 15);
		selectSchoolsPanel.add(label_4);

		JLabel label_5 = new JLabel("2. 按实验室查询设备的运行状况：");
		label_5.setBounds(43, 240, 220, 15);
		selectSchoolsPanel.add(label_5);

		JLabel label_16 = new JLabel(
				"--------------------------------------❀好贤专属分割线❀-------------------------------------");
		label_16.setBounds(10, 154, 416, 15);
		selectSchoolsPanel.add(label_16);

		JPanel updateSchoolsPanel = new JPanel();
		tabbedPane.addTab("3. 保修设备管理模块", null, updateSchoolsPanel, null);
		updateSchoolsPanel.setLayout(null);

		JLabel deviceRepaired4TypeLabel = new JLabel("　类　别：");
		deviceRepaired4TypeLabel.setBounds(138, 132, 115, 15);
		updateSchoolsPanel.add(deviceRepaired4TypeLabel);

		JComboBox<String> deviceRepaired4TypeComboBox = new JComboBox<String>();
		deviceRepaired4TypeComboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "硬件", "软件" }));
		deviceRepaired4TypeComboBox.setBounds(210, 129, 105, 21);
		updateSchoolsPanel.add(deviceRepaired4TypeComboBox);

		JButton deviceRepaired4TypeButton = new JButton("　查　询　");
		deviceRepaired4TypeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = deviceRepaired4TypeComboBox.getSelectedItem().toString();
				new DBQueryProcedureModelThree().executeSelectDeviceRepaired4Type(type);
			}
		});
		deviceRepaired4TypeButton.setBounds(111, 160, 101, 23);
		updateSchoolsPanel.add(deviceRepaired4TypeButton);

		JButton button_1 = new JButton("查询设备所有修理情况");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DBQueryProcedureModelThree().executeSelectDeviceRepaired();
			}
		});
		button_1.setBounds(128, 46, 187, 23);
		updateSchoolsPanel.add(button_1);

		JButton tjdeviceRepaired4TypeButton = new JButton("　统　计　");
		tjdeviceRepaired4TypeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = deviceRepaired4TypeComboBox.getSelectedItem().toString();
				new DBQueryProcedureModelThree().executeTongjiDeviceRepaired4Type(type);
			}
		});
		tjdeviceRepaired4TypeButton.setBounds(228, 160, 101, 23);
		updateSchoolsPanel.add(tjdeviceRepaired4TypeButton);

		JLabel label_7 = new JLabel("1. 查询设备所有修理情况：");
		label_7.setBounds(36, 21, 220, 15);
		updateSchoolsPanel.add(label_7);

		JLabel label_8 = new JLabel("2. 按类别查询设备的修理情况：");
		label_8.setBounds(36, 104, 220, 15);
		updateSchoolsPanel.add(label_8);

		JLabel label_6 = new JLabel("　起始日期：");
		label_6.setBounds(73, 243, 101, 15);
		updateSchoolsPanel.add(label_6);

		JComboBox<String> syearComboBox = new JComboBox<String>();
		syearComboBox
				.setModel(new DefaultComboBoxModel<String>(new String[] { "2014", "2015", "2016", "2017", "2018" }));
		syearComboBox.setBounds(148, 240, 62, 21);
		updateSchoolsPanel.add(syearComboBox);

		JComboBox<String> smonthComboBox = new JComboBox<String>();
		smonthComboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		smonthComboBox.setBounds(228, 240, 46, 21);
		updateSchoolsPanel.add(smonthComboBox);

		JComboBox<String> sdayComboBox = new JComboBox<String>();
		sdayComboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		sdayComboBox.setBounds(299, 240, 46, 21);
		updateSchoolsPanel.add(sdayComboBox);

		JLabel label_11 = new JLabel("年");
		label_11.setBounds(212, 243, 17, 15);
		updateSchoolsPanel.add(label_11);

		JLabel label_19 = new JLabel("月");
		label_19.setBounds(277, 243, 17, 15);
		updateSchoolsPanel.add(label_19);

		JLabel label_20 = new JLabel("日");
		label_20.setBounds(347, 243, 17, 15);
		updateSchoolsPanel.add(label_20);

		JComboBox<String> eyearComboBox = new JComboBox<String>();
		eyearComboBox
				.setModel(new DefaultComboBoxModel<String>(new String[] { "2014", "2015", "2016", "2017", "2018" }));
		eyearComboBox.setBounds(148, 265, 62, 21);
		updateSchoolsPanel.add(eyearComboBox);

		JComboBox<String> emonthComboBox = new JComboBox<String>();
		emonthComboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		emonthComboBox.setBounds(228, 265, 46, 21);
		updateSchoolsPanel.add(emonthComboBox);

		JComboBox<String> edayComboBox = new JComboBox<String>();
		edayComboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		edayComboBox.setBounds(299, 265, 46, 21);
		updateSchoolsPanel.add(edayComboBox);

		JLabel label_21 = new JLabel("年");
		label_21.setBounds(212, 268, 17, 15);
		updateSchoolsPanel.add(label_21);

		JLabel label_22 = new JLabel("月");
		label_22.setBounds(277, 268, 17, 15);
		updateSchoolsPanel.add(label_22);

		JLabel label_23 = new JLabel("日");
		label_23.setBounds(347, 268, 17, 15);
		updateSchoolsPanel.add(label_23);

		JButton button = new JButton("　查　询　");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String syear = syearComboBox.getSelectedItem().toString();
				String smonth = smonthComboBox.getSelectedItem().toString();
				String sday = sdayComboBox.getSelectedItem().toString();
				String sdate = syear + "-" + smonth + "-" + sday;
				String eyear = eyearComboBox.getSelectedItem().toString();
				String emonth = emonthComboBox.getSelectedItem().toString();
				String eday = edayComboBox.getSelectedItem().toString();
				String edate = eyear + "-" + emonth + "-" + eday;
				new DBQueryProcedureModelThree().executeSelectDeviceRepaired4Date(sdate, edate);
			}
		});
		button.setBounds(111, 297, 101, 23);
		updateSchoolsPanel.add(button);

		JButton button_2 = new JButton("　统　计　");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String syear = syearComboBox.getSelectedItem().toString();
				String smonth = smonthComboBox.getSelectedItem().toString();
				String sday = sdayComboBox.getSelectedItem().toString();
				String sdate = syear + "-" + smonth + "-" + sday;
				String eyear = eyearComboBox.getSelectedItem().toString();
				String emonth = emonthComboBox.getSelectedItem().toString();
				String eday = edayComboBox.getSelectedItem().toString();
				String edate = eyear + "-" + emonth + "-" + eday;
				new DBQueryProcedureModelThree().executeTongjiDeviceRepaired4Date(sdate, edate);
			}
		});
		button_2.setBounds(228, 297, 101, 23);
		updateSchoolsPanel.add(button_2);

		JLabel label_9 = new JLabel("3. 按修理日期查询设备的修理情况：");
		label_9.setBounds(36, 218, 220, 15);
		updateSchoolsPanel.add(label_9);

		JLabel label_10 = new JLabel("　结束日期：");
		label_10.setBounds(73, 268, 101, 15);
		updateSchoolsPanel.add(label_10);

		JLabel deviceRepaired4VenderLabel = new JLabel("　修理厂家：");
		deviceRepaired4VenderLabel.setBounds(132, 383, 101, 15);
		updateSchoolsPanel.add(deviceRepaired4VenderLabel);

		JComboBox<String> deviceRepaired4VenderComboBox = new JComboBox<String>();
		deviceRepaired4VenderComboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "10001", "10002", "10003", "10004", "10005", "10006" }));
		deviceRepaired4VenderComboBox.setBounds(210, 380, 105, 21);
		updateSchoolsPanel.add(deviceRepaired4VenderComboBox);

		JButton deviceRepaired4VenderButton = new JButton("　查　询　");
		deviceRepaired4VenderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vender = deviceRepaired4VenderComboBox.getSelectedItem().toString();
				new DBQueryProcedureModelThree().executeSelectDeviceRepaired4Garage(vender);
			}
		});
		deviceRepaired4VenderButton.setBounds(111, 411, 101, 23);
		updateSchoolsPanel.add(deviceRepaired4VenderButton);

		JButton tjdeviceRepaired4VenderButton = new JButton("　统　计　");
		tjdeviceRepaired4VenderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vender = deviceRepaired4VenderComboBox.getSelectedItem().toString();
				new DBQueryProcedureModelThree().executeTongjiDeviceRepaired4Garage(vender);
			}
		});
		tjdeviceRepaired4VenderButton.setBounds(228, 411, 101, 23);
		updateSchoolsPanel.add(tjdeviceRepaired4VenderButton);

		JLabel label_25 = new JLabel("4. 按修理厂家查询设备的修理情况：");
		label_25.setBounds(36, 355, 220, 15);
		updateSchoolsPanel.add(label_25);

		JLabel label_17 = new JLabel(
				"--------------------------------------❀好贤专属分割线❀-------------------------------------");
		label_17.setBounds(10, 79, 416, 15);
		updateSchoolsPanel.add(label_17);

		JLabel label_18 = new JLabel(
				"--------------------------------------❀好贤专属分割线❀-------------------------------------");
		label_18.setBounds(10, 193, 416, 15);
		updateSchoolsPanel.add(label_18);

		JLabel label_24 = new JLabel(
				"--------------------------------------❀好贤专属分割线❀-------------------------------------");
		label_24.setBounds(10, 330, 416, 15);
		updateSchoolsPanel.add(label_24);

		JPanel aPanel = new JPanel();
		tabbedPane.addTab("4. 报废设备管理模块", null, aPanel, null);
		aPanel.setLayout(null);

		JButton button_4 = new JButton("查询设备所有报废情况");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DBQueryProcedureModelFour().executeSelectDeviceJunked();
			}
		});
		button_4.setBounds(133, 78, 187, 23);
		aPanel.add(button_4);

		JLabel label_26 = new JLabel("1. 查询设备所有报废情况：");
		label_26.setBounds(41, 53, 220, 15);
		aPanel.add(label_26);

		JLabel label_28 = new JLabel("　起始日期：");
		label_28.setBounds(78, 259, 101, 15);
		aPanel.add(label_28);

		JComboBox<String> comboBox_7 = new JComboBox<String>();
		comboBox_7.setModel(new DefaultComboBoxModel<String>(new String[] { "2014", "2015", "2016", "2017", "2018" }));
		comboBox_7.setBounds(153, 256, 62, 21);
		aPanel.add(comboBox_7);

		JComboBox<String> comboBox_8 = new JComboBox<String>();
		comboBox_8.setModel(new DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		comboBox_8.setBounds(233, 256, 46, 21);
		aPanel.add(comboBox_8);

		JComboBox<String> comboBox_9 = new JComboBox<String>();
		comboBox_9.setModel(new DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		comboBox_9.setBounds(304, 256, 46, 21);
		aPanel.add(comboBox_9);

		JLabel label_29 = new JLabel("年");
		label_29.setBounds(217, 259, 17, 15);
		aPanel.add(label_29);

		JLabel label_30 = new JLabel("月");
		label_30.setBounds(282, 259, 17, 15);
		aPanel.add(label_30);

		JLabel label_31 = new JLabel("日");
		label_31.setBounds(352, 259, 17, 15);
		aPanel.add(label_31);

		JComboBox<String> comboBox_10 = new JComboBox<String>();
		comboBox_10.setModel(new DefaultComboBoxModel<String>(new String[] { "2014", "2015", "2016", "2017", "2018" }));
		comboBox_10.setBounds(153, 299, 62, 21);
		aPanel.add(comboBox_10);

		JComboBox<String> comboBox_11 = new JComboBox<String>();
		comboBox_11.setModel(new DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		comboBox_11.setBounds(233, 299, 46, 21);
		aPanel.add(comboBox_11);

		JComboBox<String> comboBox_12 = new JComboBox<String>();
		comboBox_12.setModel(new DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		comboBox_12.setBounds(304, 299, 46, 21);
		aPanel.add(comboBox_12);

		JLabel label_32 = new JLabel("年");
		label_32.setBounds(217, 302, 17, 15);
		aPanel.add(label_32);

		JLabel label_33 = new JLabel("月");
		label_33.setBounds(282, 302, 17, 15);
		aPanel.add(label_33);

		JLabel label_34 = new JLabel("日");
		label_34.setBounds(352, 302, 17, 15);
		aPanel.add(label_34);

		JButton button_11 = new JButton("　查　询　");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String syear = comboBox_7.getSelectedItem().toString();
				String smonth = comboBox_8.getSelectedItem().toString();
				String sday = comboBox_9.getSelectedItem().toString();
				String sdate = syear + "-" + smonth + "-" + sday;
				String eyear = comboBox_10.getSelectedItem().toString();
				String emonth = comboBox_11.getSelectedItem().toString();
				String eday = comboBox_12.getSelectedItem().toString();
				String edate = eyear + "-" + emonth + "-" + eday;
				new DBQueryProcedureModelFour().executeSelectDeviceJunked4Date(sdate, edate);
			}
		});
		button_11.setBounds(118, 346, 101, 23);
		aPanel.add(button_11);

		JButton button_12 = new JButton("　统　计　");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String syear = comboBox_7.getSelectedItem().toString();
				String smonth = comboBox_8.getSelectedItem().toString();
				String sday = comboBox_9.getSelectedItem().toString();
				String sdate = syear + "-" + smonth + "-" + sday;
				String eyear = comboBox_10.getSelectedItem().toString();
				String emonth = comboBox_11.getSelectedItem().toString();
				String eday = comboBox_12.getSelectedItem().toString();
				String edate = eyear + "-" + emonth + "-" + eday;
				new DBQueryProcedureModelFour().executeTongjiDeviceJunked4Date(sdate, edate);
			}
		});
		button_12.setBounds(235, 346, 101, 23);
		aPanel.add(button_12);

		JLabel label_35 = new JLabel("2. 按修理日期查询统计设备的报废情况：");
		label_35.setBounds(41, 217, 309, 15);
		aPanel.add(label_35);

		JLabel label_36 = new JLabel("　结束日期：");
		label_36.setBounds(78, 302, 101, 15);
		aPanel.add(label_36);

		JLabel label_27 = new JLabel(
				"--------------------------------------❀好贤专属分割线❀-------------------------------------");
		label_27.setBounds(10, 148, 416, 15);
		aPanel.add(label_27);
	}
}
