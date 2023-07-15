package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import dao.ChiTietCVDAO;
import dao.QLCongViec_DAO;
import dao.ThongTinLaoDong_DAO;
import entity.ChiTietCV;
import entity.CongTrinh;
import entity.DiaDiem;
import entity.LaoDong;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JTextArea;

public class TrangChuLaoDong extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelLich;
	private JTable tableLich;
	private ArrayList<CongTrinh> listCT = new ArrayList<CongTrinh>();
	private ArrayList<ChiTietCV> listChiTiet = new ArrayList<ChiTietCV>();
	private ChiTietCVDAO chiTietDAO = new ChiTietCVDAO();
	private JButton btnDMK;
	private JButton btnDX;
	private LaoDong laoDong;

	public TrangChuLaoDong(LaoDong ld) {
		ImageIcon img = new ImageIcon(TrangChuLaoDong.class.getResource("/images/lao_dong.png"));
		setIconImage(img.getImage());
		laoDong = ld;
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		listCT = new ThongTinLaoDong_DAO().getCongTrinh(ld.getMaLaoDong());
		setResizable(false);
		setTitle("Chương trình quản lý lao dộng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1094, 227);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTen = new JLabel(ld.getTenLaoDong());
		lblTen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTen.setHorizontalAlignment(SwingConstants.LEFT);
		lblTen.setBounds(191, 53, 265, 45);
		panel.add(lblTen);

		JLabel lblChucVu1 = new JLabel("Lao dộng");
		lblChucVu1.setHorizontalAlignment(SwingConstants.LEFT);
		lblChucVu1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblChucVu1.setBounds(549, 58, 100, 34);
		panel.add(lblChucVu1);

		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNgaySinh.setBounds(739, 91, 89, 33);
		panel.add(lblNgaySinh);

		JLabel lblGioiTinh = new JLabel("Giới tính\r\n:");
		lblGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblGioiTinh.setBounds(739, 59, 73, 32);
		panel.add(lblGioiTinh);

		JLabel lblCMND = new JLabel("CMND:");
		lblCMND.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblCMND.setBounds(191, 91, 70, 32);
		panel.add(lblCMND);

		JLabel lblSDT = new JLabel("SDT:");
		lblSDT.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSDT.setBounds(466, 91, 73, 32);
		panel.add(lblSDT);

		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDiaChi.setBounds(191, 122, 73, 32);
		panel.add(lblDiaChi);

		JLabel lblNewLabel_3 = new JLabel("Thông tin nhân viên");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(405, 11, 298, 45);
		panel.add(lblNewLabel_3);

		JButton btnNewButton_1 = new JButton("Đăng xuất");
		btnNewButton_1.setBounds(10, 521, 89, 23);
		panel.add(btnNewButton_1);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(127, 521, 89, 23);
		panel.add(btnNewButton);

		JLabel lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblChucVu.setBounds(466, 58, 73, 34);
		panel.add(lblChucVu);

		JLabel lblCMND1 = new JLabel(ld.getCMND());
		lblCMND1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblCMND1.setBounds(271, 91, 185, 32);
		panel.add(lblCMND1);

		JLabel lblNgaySinh1 = new JLabel(df.format(ld.getNgaySinh()));
		lblNgaySinh1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNgaySinh1.setBounds(832, 91, 115, 33);
		panel.add(lblNgaySinh1);

		btnDMK = new JButton("Đổi mật khẩu");
		btnDMK.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDMK.setBounds(848, 141, 115, 34);
		btnDMK.setBackground(new Color(65, 115, 201));
		btnDMK.setForeground(Color.white);
		panel.add(btnDMK);

		btnDX = new JButton("Đăng xuất");
		btnDX.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDX.setBounds(973, 141, 96, 34);
		btnDX.setBackground(new Color(65, 115, 201));
		btnDX.setForeground(Color.white);
		panel.add(btnDX);

		JLabel label = new JLabel("");
//		label.setIcon(new ImageIcon(TrangChuLaoDong.class.getResource("/images/account.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(54, 53, 125, 101);
		panel.add(label);

		JLabel lblGioiTinh1 = new JLabel(ld.isGioiTinh() ? "Nam" : "Nữ");
		lblGioiTinh1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblGioiTinh1.setBounds(832, 59, 115, 32);
		panel.add(lblGioiTinh1);

		JLabel lblSDT1 = new JLabel(ld.getSDT());
		lblSDT1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSDT1.setBounds(549, 91, 100, 32);
		panel.add(lblSDT1);

		JTextArea txtDiaChi = new JTextArea(ld.getDiaChi().toString());
		txtDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtDiaChi.setLineWrap(true);
		txtDiaChi.setWrapStyleWord(true);
		txtDiaChi.setBounds(271, 126, 298, 57);
		txtDiaChi.setEditable(false);
		panel.add(txtDiaChi);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(505, 161, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lịch làm việc");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(439, 176, 232, 40);
		panel.add(lblNewLabel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 228, 1094, 343);
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.getViewport().setBackground(Color.WHITE);

		String[] colHeader = { "Tên công trình", "Công việc", "Ngày thực hiện", "Ngày hoàn thành", "Địa chỉ" };
		modelLich = new DefaultTableModel(colHeader, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		tableLich = new JTable(modelLich);
		tableLich.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		tableLich.setBounds(0, 263, 894, 308);
		JTableHeader h = tableLich.getTableHeader();
		h.setFont(new Font("Arial", Font.BOLD, 13));
		h.setForeground(new Color(255, 255, 255));
		h.setBackground(new Color(146, 200, 240));
		
		tableLich.setRowHeight(tableLich.getRowHeight() + 20);

		tableLich.getColumnModel().getColumn(0).setPreferredWidth(280);
		tableLich.getColumnModel().getColumn(1).setPreferredWidth(40);
		tableLich.getColumnModel().getColumn(2).setPreferredWidth(40);
		tableLich.getColumnModel().getColumn(3).setPreferredWidth(40);
		tableLich.getColumnModel().getColumn(4).setPreferredWidth(300);


		scrollPane.setViewportView(tableLich);

		
		
		for (CongTrinh congTrinh : listCT) {
			String tenCongTrinh = congTrinh.getTenCongTrinh();
			DiaDiem dd = congTrinh.getDiaDiem();
			String Dia_diem = dd.getPhuongXa() + " " + dd.getQuanHuyen() + " " + dd.getTinhTP();
			listChiTiet = chiTietDAO.timDanhSachCongViecDangLam(ld.getMaLaoDong(), congTrinh.getMaCongTrinh());
			for (ChiTietCV chiTiet : listChiTiet) {
				String tenCV = new QLCongViec_DAO().getCongViec(chiTiet.getCongViec().getMaCongViec()).getTenCongViec();
				modelLich.addRow(new Object[] { tenCongTrinh, tenCV,
						df.format(chiTiet.getNgayThucHien()), df.format(chiTiet.getNgayHoanThanh()), Dia_diem });
			}
		}

		setLocationRelativeTo(null);
		btnDMK.addActionListener(this);
		btnDX.addActionListener(this);

	}
	static class WordWrapCellRenderer extends JTextArea implements TableCellRenderer {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		WordWrapCellRenderer() {
	        setLineWrap(true);
	        setWrapStyleWord(true);
	    }

	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        setText(value.toString());
	        setSize(table.getColumnModel().getColumn(column).getWidth(), getPreferredSize().height);
	        setFont(table.getFont());
	        if (table.getRowHeight(row) != getPreferredSize().height) {
	            table.setRowHeight(row, getPreferredSize().height);
	        }
	        return this;
	    }
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o == btnDMK){
			new DoiMatKhau_Jfm(laoDong).setVisible(true);}
		else if(o.equals(btnDX)){
			int t=JOptionPane.showConfirmDialog(null, "Thông báo", "Bạn có muốn đăng xuất", JOptionPane.YES_NO_OPTION);
			if(t==JOptionPane.YES_OPTION) {
				setVisible(false);
				new DangNhap().setVisible(true);
			}
	}

}
}
