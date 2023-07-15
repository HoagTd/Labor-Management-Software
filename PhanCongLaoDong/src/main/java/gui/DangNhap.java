package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;

import javax.swing.SwingConstants;

import dao.DangNhap_DAO;
import dao.QuanLyLaoDong_DAO;
import entity.LaoDong;
import entity.QuanLy;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class DangNhap extends JFrame implements ActionListener, KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTK;
	private JPasswordField txtMK;
	private JButton btnDN;
	public static void main(String[] args) {
			new DangNhap().setVisible(true);
	}
	
	public DangNhap() {
		ImageIcon img = new ImageIcon(DangNhap.class.getResource("/images/lao_dong.png"));
		setIconImage(img.getImage());
		setTitle("Đăng nhập");
		setSize(1000, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 0, 0, 150));
		panel.setBounds(273, 97, 481, 360);
		getContentPane().add(panel);
		
		JLabel lblTitleDN = new JLabel("Đăng nhập");
		lblTitleDN.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleDN.setForeground(Color.WHITE);
		lblTitleDN.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitleDN.setBounds(149, 35, 171, 43);
		panel.add(lblTitleDN);
		
		txtTK = new JTextField();
		txtTK.setForeground(Color.WHITE);
		txtTK.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		txtTK.setColumns(20);
		txtTK.setBackground(new Color(20, 20, 20));
		txtTK.setBounds(68, 133, 333, 34);
		panel.add(txtTK);
		
		txtMK = new JPasswordField();
		txtMK.setForeground(Color.WHITE);
		txtMK.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		txtMK.setColumns(20);
		txtMK.setBackground(new Color(20, 20, 20));
		txtMK.setBounds(68, 216, 333, 34);
		txtMK.setEchoChar('*');
		txtMK.addKeyListener(this);
		txtMK.setText("12345678");
		panel.add(txtMK);
		
		btnDN = new JButton("Đăng nhập");
		btnDN.setForeground(Color.WHITE);
		btnDN.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnDN.setBackground(new Color(23, 162, 184));
		btnDN.setBounds(176, 279, 132, 34);
		panel.add(btnDN);
		
		JLabel lblTK = new JLabel("Tài khoản");
		lblTK.setForeground(Color.WHITE);
		lblTK.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblTK.setBounds(68, 100, 79, 22);
		panel.add(lblTK);
		
		JLabel lblMK = new JLabel("Mật khẩu");
		lblMK.setForeground(Color.WHITE);
		lblMK.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblMK.setBounds(68, 178, 79, 27);
		panel.add(lblMK);
		
		JLabel lblbg = new JLabel("");
		lblbg.setBounds(0, 0, 994, 571);
		lblbg.setIcon(new ImageIcon(DangNhap.class.getResource("/images/hinh.jpg")));
		getContentPane().add(lblbg);
		
		btnDN.addActionListener(this);
		txtTK.addKeyListener(this);

		txtTK.setText("QL000000");

		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Object o = e.getSource();
		String ma = txtTK.getText();
		String matKhau = new String(txtMK.getPassword());
		DangNhap_DAO dangNhap = new DangNhap_DAO();
		if (o.equals(txtTK)) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				txtMK.requestFocus();
			}
		}
		if (o.equals(txtMK)) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				if (valid()) {
					if (dangNhap.ktLaoDong(ma, matKhau)) {
						QuanLyLaoDong_DAO lDao = new QuanLyLaoDong_DAO();
						String maML = txtTK.getText();
						LaoDong laoDong = lDao.getLaoDong(maML);
						String ten = laoDong.getTenLaoDong();
						Date ngaySinh = laoDong.getNgaySinh();
						Boolean gioiTinh = laoDong.isGioiTinh();
						String CMND = laoDong.getCMND();
						String sdt = laoDong.getSDT();
						setVisible(false);
						new TrangChuLaoDong(new LaoDong(laoDong.getMaLaoDong(), ten, ngaySinh, gioiTinh, CMND,
								laoDong.getDiaChi(), laoDong.getTrinhDo(), sdt, laoDong.getMatKhau())).setVisible(true);

					} else if (dangNhap.ktQuanLy(ma, matKhau)) {
						setVisible(false);
						new QuanLy_GUI(new QuanLy(ma)).setVisible(true);
					} else
						JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu của bạn chưa chính xác ");
				}
			}
		}
		
	}

	private boolean valid() {
		String taiKhoan = txtTK.getText().trim();
		if (taiKhoan.equals("")) {
			JOptionPane.showMessageDialog(this, "Tài khoản không được để trống");
			return false;
		} else if (new String(txtMK.getPassword()).equals("")) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập mật khẩu");
			return false;
		}
		return true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		String ma = txtTK.getText();
		String matKhau = new String(txtMK.getPassword());
		DangNhap_DAO dangNhap = new DangNhap_DAO();
		if (o.equals(btnDN)) {
			new Thread(()-> {
				if (dangNhap.ktLaoDong(ma, matKhau)) {
					QuanLyLaoDong_DAO lDao = new QuanLyLaoDong_DAO();
					String maML = txtTK.getText();
					LaoDong laoDong = lDao.getLaoDong(maML);
					String ten = laoDong.getTenLaoDong();
					Date ngaySinh = laoDong.getNgaySinh();
					Boolean gioiTinh = laoDong.isGioiTinh();
					String CMND = laoDong.getCMND();

					String sdt = laoDong.getSDT();
					setVisible(false);
					new TrangChuLaoDong(new LaoDong(laoDong.getMaLaoDong(), ten, ngaySinh, gioiTinh, CMND,
							laoDong.getDiaChi(), laoDong.getTrinhDo(), sdt, laoDong.getMatKhau())).setVisible(true);

				} else if (dangNhap.ktQuanLy(ma, matKhau)) {
					setVisible(false);
					new QuanLy_GUI(new QuanLy(ma)).setVisible(true);
				} else
					JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu của bạn chưa chính xác");
			}).start();
			
		}
		
	}
}
