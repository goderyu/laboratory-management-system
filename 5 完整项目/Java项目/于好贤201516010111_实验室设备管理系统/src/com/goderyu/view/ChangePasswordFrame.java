package com.goderyu.view;

import com.goderyu.util.DBUpdateProcedure;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
* @author 于好贤
* @version 创建时间：2017年11月29日 下午11:01:17
* @description 登录窗体
*/
public class ChangePasswordFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userNameField;
	private JPasswordField passwordField;
	private JPasswordField newpasswordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            try {
                ChangePasswordFrame frame = new ChangePasswordFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
	}

	/**
	 * Create the frame.
	 */
	ChangePasswordFrame() {
		setResizable(false);
		setTitle("改密-实验室设备管理系统");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(295, 244);
		setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userNameLabel = new JLabel("用户名:");
		userNameLabel.setFont(new Font("宋体", Font.BOLD, 12));
		userNameLabel.setBounds(55, 43, 53, 15);
		contentPane.add(userNameLabel);
		
		JLabel passwordLabel = new JLabel("原密码:");
		passwordLabel.setFont(new Font("宋体", Font.BOLD, 12));
		passwordLabel.setBounds(55, 68, 53, 15);
		contentPane.add(passwordLabel);
		
		JLabel idLabel = new JLabel("新密码:");
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
		
		newpasswordField = new JPasswordField();
		newpasswordField.setBounds(114, 90, 120, 21);
		contentPane.add(newpasswordField);
		
		JLabel copyrightLabel = new JLabel("@Author 于好贤");
		copyrightLabel.setFont(new Font("微软雅黑", Font.BOLD, 12));
		copyrightLabel.setBounds(100, 194, 95, 21);
		contentPane.add(copyrightLabel);
		
		JButton button = new JButton("改　密");
		button.setFont(new Font("宋体", Font.BOLD, 12));
		button.addActionListener(e -> {
            String username = userNameField.getText().trim();
            char[] password = passwordField.getPassword();
            char[] newpassword = newpasswordField.getPassword();
            String inpassword = String.valueOf(password);
            String inewpassword = String.valueOf(newpassword);
            String outpassword = new DBUpdateProcedure().executeGetAdminOldPassword(username,null);
            if(inpassword.equals(outpassword)) {
                new DBUpdateProcedure().executeSetAdminNewPassword(username,inewpassword);
            } else{
                JOptionPane.showMessageDialog(null, "账户或密码错误，不能修改密码，请重试", null,JOptionPane.ERROR_MESSAGE);
            }
        });
		button.setBounds(55, 135, 77, 25);
		contentPane.add(button);
		JButton button_2 = new JButton("重　置");
		button_2.addActionListener(e -> {
            userNameField.setText("");
            passwordField.setText("");
            newpasswordField.setText("");
        });
		button_2.setFont(new Font("宋体", Font.BOLD, 12));
		button_2.setBounds(157, 135, 77, 25);
		contentPane.add(button_2);
	}
}
