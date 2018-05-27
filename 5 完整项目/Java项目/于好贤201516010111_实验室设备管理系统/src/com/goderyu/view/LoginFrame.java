package com.goderyu.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

import java.awt.Font;

import javax.swing.JButton;

import com.goderyu.util.DBUpdateProcedure;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* @author 于好贤
* @version 创建时间：2017年11月29日 下午11:01:17
* @description 登录窗体
*/
public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userNameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setResizable(false);
		setTitle("登录-实验室设备管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(295, 244);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userNameLabel = new JLabel("用户名:");
		userNameLabel.setFont(new Font("宋体", Font.BOLD, 12));
		userNameLabel.setBounds(55, 43, 53, 15);
		contentPane.add(userNameLabel);
		
		JLabel passwordLabel = new JLabel("密　码:");
		passwordLabel.setFont(new Font("宋体", Font.BOLD, 12));
		passwordLabel.setBounds(55, 68, 53, 15);
		contentPane.add(passwordLabel);
		
		JLabel idLabel = new JLabel("身　份:");
		idLabel.setFont(new Font("宋体", Font.BOLD, 12));
		idLabel.setBounds(55, 93, 53, 15);
		contentPane.add(idLabel);
		
		userNameField = new JTextField();
		userNameField.setBounds(114, 40, 120, 21);
		contentPane.add(userNameField);
		userNameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(114, 65, 120, 21);
		contentPane.add(passwordField);
		
		JComboBox<String> idComboBox = new JComboBox<>();
		idComboBox.addItem("　　管理员");
		idComboBox.setBounds(114, 90, 120, 21);
		contentPane.add(idComboBox);
		
		JLabel copyrightLabel = new JLabel("@Author 于好贤");
		copyrightLabel.setFont(new Font("微软雅黑", Font.BOLD, 12));
		copyrightLabel.setBounds(100, 194, 95, 21);
		contentPane.add(copyrightLabel);
		
		JButton button = new JButton("登　录");
		button.setFont(new Font("宋体", Font.BOLD, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = "";
				username = userNameField.getText().toString().trim();
				char[] password = passwordField.getPassword();
				String inpassword = new String(String.valueOf(password));
				String outpassword = new DBUpdateProcedure().executeGetAdminOldPassword(username,null);
				int limits = new DBUpdateProcedure().executeGetAdminLimits(username);
				if(inpassword.equals(outpassword)) {
					if(limits == 1) {
						new MainFrame().setVisible(true);
						dispose();
					} else if(limits == 0){
						new OnlySelectMainFrame().setVisible(true);
						dispose();
					}
				} else{
					JOptionPane.showMessageDialog(null, "账户或密码错误，请重试", null,JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button.setBounds(55, 135, 77, 25);
		contentPane.add(button);
		JButton button_2 = new JButton("改　密");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChangePasswordFrame().setVisible(true);
			}
		});
		button_2.setFont(new Font("宋体", Font.BOLD, 12));
		button_2.setBounds(157, 135, 77, 25);
		contentPane.add(button_2);
	}
}
