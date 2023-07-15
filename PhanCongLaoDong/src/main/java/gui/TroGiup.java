//package gui;
//
//import javax.swing.JEditorPane;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.border.EmptyBorder;
//import javax.swing.event.TreeSelectionEvent;
//import javax.swing.event.TreeSelectionListener;
//import javax.swing.JTree;
//import javax.swing.JLabel;
//import java.awt.Font;
//import javax.swing.tree.DefaultMutableTreeNode;
//import javax.swing.tree.TreePath;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//
//public class TroGiup extends JFrame implements TreeSelectionListener {
//
//	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
//	private JTree tree;
//	private JEditorPane edit;
//	private DefaultMutableTreeNode nodeQLLaoDong;
//	private DefaultMutableTreeNode nodeThemLD;
//	private DefaultMutableTreeNode nodeXoaLD;
//	private DefaultMutableTreeNode nodeSuaLD;
//	private DefaultMutableTreeNode nodeQLCongTrinh;
//	private DefaultMutableTreeNode nodeThemCT;
//	private DefaultMutableTreeNode nodeSuaCT;
//	private DefaultMutableTreeNode nodePhanCongLD;
//	private DefaultMutableTreeNode nodeChuyenLD;
//	private DefaultMutableTreeNode nodeQLLichLam;
//	private DefaultMutableTreeNode root;
//	private DefaultMutableTreeNode nodeQLCongViec;
//	private DefaultMutableTreeNode nodeThongKe;
//	private DefaultMutableTreeNode nodeThemCV;
//	private DefaultMutableTreeNode nodeCapNhatCV;
//	private DefaultMutableTreeNode nodeCapNhatTrangThaiCV;
//	private DefaultMutableTreeNode nodeQLPhanCong;
//
//	public TroGiup(int page) {
//		setTitle("Trá»£ giÃºp");
//		setResizable(false);
//		setBounds(100, 100, 1211, 657);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//
//		JPanel panel = new JPanel();
//		panel.setBounds(0, 0, 251, 618);
//		contentPane.add(panel);
//		panel.setLayout(null);
//
//		root = new DefaultMutableTreeNode("Trá»£ giÃºp");
//
//		nodeQLLaoDong = new DefaultMutableTreeNode("Quáº£n lÃ½ lao Ä‘á»™ng");
//		nodeThemLD = new DefaultMutableTreeNode("ThÃªm lao Ä‘á»™ng");
//		nodeXoaLD = new DefaultMutableTreeNode("Nghá»‰ viá»‡c");
//		nodeSuaLD = new DefaultMutableTreeNode("Sá»­a lao Ä‘á»™ng");
//		nodeQLCongTrinh = new DefaultMutableTreeNode("Quáº£n lÃ½ cÃ´ng trÃ¬nh");
//		nodeThemCT = new DefaultMutableTreeNode("ThÃªm cÃ´ng trÃ¬nh");
//		nodeSuaCT = new DefaultMutableTreeNode("Sá»­a cÃ´ng trÃ¬nh");
//		nodePhanCongLD = new DefaultMutableTreeNode("PhÃ¢n cÃ´ng");
//		nodeChuyenLD = new DefaultMutableTreeNode("Chuyá»ƒn lao Ä‘á»™ng");
//		nodeQLLichLam = new DefaultMutableTreeNode("Quáº£n lÃ½ lá»‹ch lÃ m viá»‡c");
//		nodeThongKe = new DefaultMutableTreeNode("Thá»‘ng kÃª");
//		nodeQLCongViec = new DefaultMutableTreeNode("Quáº£n lÃ½ cÃ´ng viá»‡c");
//		nodeThemCV = new DefaultMutableTreeNode("ThÃªm cÃ´ng viá»‡c");
//		nodeCapNhatCV = new DefaultMutableTreeNode("Cáº­p nháº­t thÃ´ng tin cÃ´ng viá»‡c");
//		nodeCapNhatTrangThaiCV = new DefaultMutableTreeNode("Cáº­p nháº­t tráº¡ng thÃ¡i cÃ´ng viá»‡c");
//		nodeQLPhanCong = new DefaultMutableTreeNode("Quáº£n lÃ½ phÃ¢n cÃ´ng");
//		
//		
//		nodeQLLaoDong.add(nodeThemLD);
//		nodeQLLaoDong.add(nodeXoaLD);
//		nodeQLLaoDong.add(nodeSuaLD);
//		root.add(nodeQLLaoDong);
//
//		nodeQLCongTrinh.add(nodeThemCT);
//		nodeQLCongTrinh.add(nodeSuaCT);
//		root.add(nodeQLCongTrinh);
//		
//		nodeQLPhanCong.add(nodePhanCongLD);
//		nodeQLPhanCong.add(nodeChuyenLD);
//		root.add(nodeQLPhanCong);
//		
//		nodeQLCongViec.add(nodeThemCV);
//		nodeQLCongViec.add(nodeCapNhatCV);
//		nodeQLCongViec.add(nodeCapNhatTrangThaiCV);
//		root.add(nodeQLCongViec);
//		
//		root.add(nodeQLLichLam);
//		root.add(nodeThongKe);
//		
//		tree = new JTree(root);
//
//		tree.setBounds(0, 45, 248, 500);
//		panel.add(tree);
//
//		JLabel lblNewLabel = new JLabel("Trá»£ giÃºp");
//		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
//		lblNewLabel.setBounds(0, 0, 248, 43);
//		panel.add(lblNewLabel);
//
//		JPanel panel_1 = new JPanel();
//		panel_1.setBounds(249, 0, 946, 618);
//		contentPane.add(panel_1);
//		panel_1.setLayout(new BorderLayout(0, 0));
//
//		edit = new JEditorPane();
//		edit.setEditable(false);
//
//		JScrollPane sc = new JScrollPane(edit);
//
//		panel_1.add(sc);
//
//		edit.setContentType("text/html");
//		edit.setBackground(Color.white);
//		tree.addTreeSelectionListener(this);
//		if(page==0)
//			tree.setSelectionPath(new TreePath(nodeThemLD.getPath()));
//		else if(page==1)
//			tree.setSelectionPath(new TreePath(nodeThemCT.getPath()));
//		else if(page==2)
//			tree.setSelectionPath(new TreePath(nodePhanCongLD.getPath()));
//		else if(page==3)
//			tree.setSelectionPath(new TreePath(nodeChuyenLD.getPath()));
//		else if(page==4)
//			tree.setSelectionPath(new TreePath(nodeThemCV.getPath()));
//		else if(page==5)
//			tree.setSelectionPath(new TreePath(nodeThongKe.getPath()));
//		else
//			tree.setSelectionPath(new TreePath(nodeQLCongViec.getPath()));
//	}
//
//	@Override
//	public void valueChanged(TreeSelectionEvent e) {
//		String sa = e.getNewLeadSelectionPath().getLastPathComponent().toString();
//		if (sa.equals("ThÃªm lao Ä‘á»™ng")) {
//			edit.setText("<html>\r\n" + 
//					"	<head>\r\n" + 
//					"		<title></title>\r\n" + 
//					"		<style type=\"text/css\">\r\n" + 
//					"			div{\r\n" + 
//					"				margin-left: 20px;\r\n" + 
//					"			}\r\n" + 
//					"			h2{\r\n" + 
//					"				padding: 20px;\r\n" + 
//					"			}\r\n" + 
//					"		</style>\r\n" + 
//					"	</head>\r\n" + 
//					"	<body>\r\n" + 
//					"		<div>\r\n" + 
//					"			<h2>BÆ°á»›c 1: Nháº­p thÃ´ng tin cáº§n thiáº¿t</h2>\r\n" + 
//					"			<img src=\""+TroGiup.class.getResource("/images/themld1.jpg")+"\">\r\n" + 
//					"			<h2>BÆ°á»›c 2: áº¤n nÃºt thÃªm</h2>\r\n" + 
//					"			<img src=\""+TroGiup.class.getResource("/images/themld2.jpg")+"\">\r\n" + 
//					"			<h2>BÆ°á»›c 3: Báº¡n xÃ¡c nháº­n láº¡i</h2>\r\n" + 
//					"			<img src=\""+TroGiup.class.getResource("/images/themld3.jpg")+"\">\r\n" + 
//					"		</div>\r\n" + 
//					"	</body>\r\n" + 
//					"</html>");
//
//		} else if (sa.equals("Nghá»‰ viá»‡c")) {
//			edit.setText("<html>\r\n" + 
//					"	<head>\r\n" + 
//					"		<title></title>\r\n" + 
//					"		<style type=\"text/css\">\r\n" + 
//					"			div{\r\n" + 
//					"				margin-left: 20px;\r\n" + 
//					"			}\r\n" + 
//					"			h2{\r\n" + 
//					"				padding: 10px;\r\n" + 
//					"			}\r\n" + 
//					"		</style>\r\n" + 
//					"	</head>\r\n" + 
//					"	<body>\r\n" + 
//					"		<div>\r\n" + 
//					"			<h2>BÆ°á»›c 1: Chá»�n lao Ä‘á»™ng</h2>\r\n" + 
//					"			<img  src=\""+TroGiup.class.getResource("/images/xoa1.jpg")+"\">\r\n" + 
//					"			<h2>BÆ°á»›c 2: áº¤n nÃºt nghá»‰ viá»‡c</h2>\r\n" + 
//					"			<img  src=\""+TroGiup.class.getResource("/images/xoa2.jpg")+"\">\r\n" + 
//					"			<h2>BÆ°á»›c 3: Báº¡n xÃ¡c nháº­n láº¡i</h2>\r\n" + 
//					"			<img  src=\""+TroGiup.class.getResource("/images/xoa3.jpg")+"\">\r\n" + 
//					"		</div>\r\n" + 
//					"	</body>\r\n" + 
//					"</html>");
//		} else if (sa.equals("Sá»­a lao Ä‘á»™ng")) {
//			edit.setText("<html>\r\n" + 
//					"	<head>\r\n" + 
//					"		<title></title>\r\n" + 
//					"		<style type=\"text/css\">\r\n" + 
//					"			div{\r\n" + 
//					"				margin-left: 20px;\r\n" + 
//					"			}\r\n" + 
//					"			h2{\r\n" + 
//					"				padding: 10px;\r\n" + 
//					"			}\r\n" + 
//					"		</style>\r\n" + 
//					"	</head>\r\n" + 
//					"	<body>\r\n" + 
//					"		<div>\r\n" + 
//					"			<h2>BÆ°á»›c 1: Chá»�n lao Ä‘á»™ng cáº§n sá»­a</h2>\r\n" + 
//					"			<img  src=\""+TroGiup.class.getResource("/images/suald1.jpg")+"\">\r\n" + 
//					"			<h2>BÆ°á»›c 2: Sá»­a thÃ´ng tin cáº§n thiáº¿t mÃ  báº¡n muá»‘n sá»­a</h2>\r\n" + 
//					"			<img  src=\""+TroGiup.class.getResource("/images/suald2.jpg")+"\">\r\n" + 
//					"			<h2>BÆ°á»›c 3: Nháº¥n nÃºt cáº¥p nháº­t</h2>\r\n" + 
//					"			<img  src=\""+TroGiup.class.getResource("/images/suald3.jpg")+"\">\r\n" + 
//					"			<h2>BÆ°á»›c 4: Báº¡n xÃ¡c nháº­n láº¡i</h2>\r\n" + 
//					"			<img width=850 src=\""+TroGiup.class.getResource("/images/suald4.jpg")+"\">\r\n" + 
//					"		</div>\r\n" + 
//					"	</body>\r\n" + 
//					"</html>");
//		} else if (sa.equals("ThÃªm cÃ´ng trÃ¬nh")) {
//			edit.setText("<html>\r\n" + 
//					"	<head>\r\n" + 
//					"		<title></title>\r\n" + 
//					"		<style type=\"text/css\">\r\n" + 
//					"			div{\r\n" + 
//					"				margin-left: 20px;\r\n" + 
//					"			}\r\n" + 
//					"			h2{\r\n" + 
//					"				padding: 10px;\r\n" + 
//					"			}\r\n" + 
//					"		</style>\r\n" + 
//					"	</head>\r\n" + 
//					"	<body>\r\n" + 
//					"		<div>\r\n" + 
//					"			<h2>BÆ°á»›c 1: Nháº­p thÃ´ng tin cáº§n thiáº¿t</h2>\r\n" + 
//					"			<img  src=\""+TroGiup.class.getResource("/images/themct1.jpg")+"\">\r\n" + 
//					"			<h2>BÆ°á»›c 2: Nháº¥n nÃºt thÃªm</h2>\r\n" + 
//					"			<img  src=\""+TroGiup.class.getResource("/images/themct2.jpg")+"\">\r\n" + 
//					"			<h2>BÆ°á»›c 3: Báº¡n xÃ¡c nháº­n láº¡i</h2>\r\n" + 
//					"			<img src=\""+TroGiup.class.getResource("/images/themct3.jpg")+"\">\r\n" + 
//					"		</div>\r\n" + 
//					"	</body>\r\n" + 
//					"</html>");
//
//		} else if (sa.equals("Sá»­a cÃ´ng trÃ¬nh")) {
//			edit.setText("<html>\r\n" + 
//					"	<head>\r\n" + 
//					"		<title></title>\r\n" + 
//					"		<style type=\"text/css\">\r\n" + 
//					"			div{\r\n" + 
//					"				margin-left: 20px;\r\n" + 
//					"			}\r\n" + 
//					"			h2{\r\n" + 
//					"				padding: 10px;\r\n" + 
//					"			}\r\n" + 
//					"		</style>\r\n" + 
//					"	</head>\r\n" + 
//					"	<body>\r\n" + 
//					"		<div>\r\n" + 
//					"			<h2>BÆ°á»›c 1: Báº¡n chá»�n cÃ´ng trÃ¬nh cáº§n sá»­a</h2>\r\n" + 
//					"			<img src=\""+TroGiup.class.getResource("/images/suact1.jpg")+"\">\r\n" + 
//					"			<h2>BÆ°á»›c 2: Nháº­p thÃ´ng tin má»›i cho cÃ´ng trÃ¬nh</h2>\r\n" + 
//					"			<img src=\""+TroGiup.class.getResource("/images/suact2.jpg")+"\">\r\n" + 
//					"			<h2>BÆ°á»›c 3: Nháº¥n nÃºt sá»­a</h2>\r\n" + 
//					"			<img src=\""+TroGiup.class.getResource("/images/suact3.jpg")+"\">\r\n" + 
//					"			<h2>BÆ°á»›c 4: Báº¡n xÃ¡c nháº­n láº¡i</h2>\r\n" + 
//					"			<img src=\""+TroGiup.class.getResource("/images/suact4.jpg")+"\">\r\n" + 
//					"		</div>\r\n" + 
//					"	</body>\r\n" + 
//					"</html>");
//
//		} else if (sa.equals("PhÃ¢n cÃ´ng")) {
//			edit.setText("<html>\r\n" + 
//					"	<head>\r\n" + 
//					"		<title></title>\r\n" + 
//					"		<style type=\"text/css\">\r\n" + 
//					"			div{\r\n" + 
//					"				margin-left: 20px;\r\n" + 
//					"			}\r\n" + 
//					"			h2{\r\n" + 
//					"				padding: 10px;\r\n" + 
//					"			}\r\n" + 
//					"		</style>\r\n" + 
//					"	</head>\r\n" + 
//					"	<body>\r\n" + 
//					"		<div>\r\n" + 
//					"			<h2>BÆ°á»›c 1: Chá»�n cÃ´ng trÃ¬nh cáº§n phÃ¢n cÃ´ng</h2>\r\n" + 
//					"			<img src=\""+TroGiup.class.getResource("/images/phancong1.jpg")+"\">\r\n" + 
//					"			<h2>BÆ°á»›c 2: Chá»�n cÃ´ng viá»‡c, ngÃ y thá»±c hiá»‡n , ngÃ y hoÃ n thÃ nh</h2>\r\n" + 
//					"			<img src=\""+TroGiup.class.getResource("/images/phancong2.jpg")+"\">\r\n" + 
//					"			<h2>BÆ°á»›c 3: Chá»�n lao Ä‘á»™ng mÃ  báº¡n muá»‘n phÃ¢n cÃ´ng</h2>\r\n" + 
//					"			<img src=\""+TroGiup.class.getResource("/images/phancong3.jpg")+"\">\r\n" + 
//					"			<h2>BÆ°á»›c 4: Nháº¥n vÃ o mÅ©i tÃªn Ä‘á»ƒ thÃªm lao Ä‘á»™ng vÃ o danh sÃ¡ch</h2>\r\n" + 
//					"			<img src=\""+TroGiup.class.getResource("/images/phancong4.jpg")+"\">\r\n" + 
//					"			<h2>BÆ°á»›c 5: Nháº¥n nÃºt phÃ¢n cÃ´ng</h2>\r\n" + 
//					"			<img src=\""+TroGiup.class.getResource("/images/phancong5.jpg")+"\">\r\n" + 
//					"			<h2>BÆ°á»›c 6: XÃ¡c nháº­n láº¡i</h2>\r\n" + 
//					"			<img src=\""+TroGiup.class.getResource("/images/phancong6.jpg")+"\">\r\n" +
//					"		</div>\r\n" + 
//					"	</body>\r\n" + 
//					"</html>");
//
//		} else if (sa.equals("Chuyá»ƒn lao Ä‘á»™ng")) {
//			edit.setText("<html>\r\n" + 
//					"	<head>\r\n" + 
//					"		<title></title>\r\n" + 
//					"		<style type=\"text/css\">\r\n" + 
//					"			div{\r\n" + 
//					"				margin-left: 20px;\r\n" + 
//					"			}\r\n" + 
//					"			h2{\r\n" + 
//					"				padding: 10px;\r\n" + 
//					"			}\r\n" + 
//					"		</style>\r\n" + 
//					"	</head>\r\n" + 
//					"	<body>\r\n" + 
//					"		<div>\r\n" + 
//					"			<h2>BÆ°á»›c 1: Chá»�n cÃ´ng trÃ¬nh cÃ³ lao Ä‘á»™ng cáº§n chuyá»ƒn</h2>\r\n" + 
//					"			<img src=\""+TroGiup.class.getResource("/images/chuyenld1.jpg")+"\">\r\n" + 
//					"			<h2>BÆ°á»›c 2: Chá»�n cÃ´ng trÃ¬nh cáº§n nháº­n thÃªm lao Ä‘á»™ng, cÃ´ng viá»‡c, ngÃ y thá»±c hiá»‡n, ngÃ y hoÃ n thÃ nh</h2>\r\n" + 
//					"			<img src=\""+TroGiup.class.getResource("/images/chuyenld2.jpg")+"\">\r\n" + 
//					"			<h2>BÆ°á»›c 3: Chá»�n lao Ä‘á»™ng mÃ  báº¡n muá»‘n chuyá»ƒn</h2>\r\n" + 
//					"			<img src=\""+TroGiup.class.getResource("/images/chuyenld3.jpg")+"\">\r\n" + 
//					"			<h2>BÆ°á»›c 4: Nháº¥n vÃ o mÅ©i tÃªn Ä‘á»ƒ thÃªm lao Ä‘á»™ng vÃ o danh sÃ¡ch</h2>\r\n" + 
//					"			<img src=\""+TroGiup.class.getResource("/images/chuyenld4.jpg")+"\">\r\n" + 
//					"			<h2>BÆ°á»›c 5: Nháº¥n nÃºt chuyá»ƒn</h2>\r\n" + 
//					"			<img src=\""+TroGiup.class.getResource("/images/chuyenld5.jpg")+"\">\r\n" + 
//					"			<h2>BÆ°á»›c 6: XÃ¡c nháº­n láº¡i</h2>\r\n" + 
//					"			<img src=\""+TroGiup.class.getResource("/images/chuyenld6.jpg")+"\">\r\n" + 
//					"		</div>\r\n" + 
//					"	</body>\r\n" + 
//					"</html>");
//
//		} else if (sa.equals("Quáº£n lÃ½ lá»‹ch lÃ m viá»‡c")) {
//			edit.setText("<html>\r\n" + 
//					"<head>\r\n" + 
//					"	<title></title>\r\n" + 
//					"	<style type=\"text/css\">\r\n" + 
//					"		div{\r\n" + 
//					"			margin-left: 20px;\r\n" + 
//					"		}\r\n" + 
//					"		h2{\r\n" + 
//					"			padding: 10px;\r\n" + 
//					"		}\r\n" + 
//					"	</style>\r\n" + 
//					"</head>\r\n" + 
//					"<body>\r\n" + 
//					"	<div>\r\n" + 
//					"		<h2>BÆ°á»›c 1: chá»�n cÃ´ng trÃ¬nh cáº§n sá»­a thá»�i gian lÃ m viá»‡c</h2>\r\n" + 
//					"		<img src=\""+TroGiup.class.getResource("/images/lichlamviec1.jpg")+"\">\r\n" + 
//					"		<h2>BÆ°á»›c 2:</h2>\r\n" + 
//					"		<ul>\r\n" + 
//					"			<li>\r\n" + 
//					"				<h3>Báº¡n cÃ³ thá»ƒ chá»�n sá»­a theo cÃ´ng viá»‡c</h3>\r\n" + 
//					"				<img src=\""+TroGiup.class.getResource("/images/lichlamviec2.jpg")+"\">\r\n" + 
//					"			</li>\r\n" + 
//					"			<li>\r\n" + 
//					"				<h3>Hoáº·c báº¡n cÃ³ thá»ƒ chá»�n sá»­a cho tá»«ng lao Ä‘á»™ng</h3>\r\n" + 
//					"				<img src=\""+TroGiup.class.getResource("/images/lichlamviec3.jpg")+"\">\r\n" + 
//					"			</li>\r\n" + 
//					"		</ul>\r\n" + 
//					"		<h2>BÆ°á»›c 3: Báº¡n chá»�n ngÃ y thá»±c hiá»‡n vÃ  ngÃ y hoÃ n thÃ nh</h2>\r\n" + 
//					"		<img src=\""+TroGiup.class.getResource("/images/lichlamviec4.jpg")+"\">\r\n" + 
//					"		<h2>BÆ°á»›c 4: Nháº¥n nÃºt sá»­a</h2>\r\n" + 
//					"		<img src=\""+TroGiup.class.getResource("/images/lichlamviec5.jpg")+"\">\r\n" + 
//					"		<h2>BÆ°á»›c 5: Chá»�n yes náº¿u Ä‘á»“ng Ã½ sá»­a</h2>\r\n" + 
//					"		<img src=\""+TroGiup.class.getResource("/images/lichlamviec6.jpg")+"\">\r\n" + 
//					"	</div>\r\n" + 
//					"</body>\r\n" + 
//					"</html>");
//		} else if (sa.equals("Thá»‘ng kÃª")) {
//			edit.setText("<html>\r\n" + 
//					"<head>\r\n" + 
//					"	<title></title>\r\n" + 
//					"	<style type=\"text/css\">\r\n" + 
//					"		div{\r\n" + 
//					"			margin-left: 20px;\r\n" + 
//					"		}\r\n" + 
//					"		h2{\r\n" + 
//					"			padding: 10px;\r\n" + 
//					"		}\r\n" + 
//					"	</style>\r\n" + 
//					"</head>\r\n" + 
//					"<body>\r\n" + 
//					"	<div>\r\n" + 
//					"		<h2>BÆ°á»›c 1: Chá»�n cÃ¡c tiÃªu chÃ­ cáº§n thá»‘ng kÃª</h2>\r\n" + 
//					"		<img src=\""+TroGiup.class.getResource("/images/thongke1.jpg")+"\">\r\n" + 
//					"		<h2>BÆ°á»›c 2: Nháº¥n nÃºt xuáº¥t file</h2>\r\n" + 
//					"		<img src=\""+TroGiup.class.getResource("/images/thongke2.jpg")+"\">\r\n" + 
//					"		<h2>BÆ°á»›c 3: chá»�n Ä‘Æ°á»�ng dáº«n file vÃ  nháº­p tÃªn file</h2>\r\n" + 
//					"		<img src=\""+TroGiup.class.getResource("/images/thongke3.jpg")+"\">\r\n" + 
//					"		<h2>BÆ°á»›c 4: Nháº¥n nÃºt save Ä‘á»ƒ lÆ°u</h2>\r\n" + 
//					"		<img src=\""+TroGiup.class.getResource("/images/thongke4.jpg")+"\">\r\n" + 
//					"		<h2>BÆ°á»›c 5: Chá»�n yes Ä‘á»ƒ xÃ¡c nháº­n láº¡i</h2>\r\n" + 
//					"		<img src=\""+TroGiup.class.getResource("/images/thongke5.jpg")+"\">\r\n" + 
//					"	</div>\r\n" + 
//					"</body>\r\n" + 
//					"</html>");
//
//		} else if (sa.equals("ThÃªm cÃ´ng viá»‡c")) {
//			edit.setText("<html>\r\n" + 
//					"<head>\r\n" + 
//					"	<title></title>\r\n" + 
//					"	<style type=\"text/css\">\r\n" + 
//					"		div{\r\n" + 
//					"			margin-left: 20px;\r\n" + 
//					"		}\r\n" + 
//					"		h2{\r\n" + 
//					"			padding: 10px;\r\n" + 
//					"		}\r\n" + 
//					"	</style>\r\n" + 
//					"</head>\r\n" + 
//					"<body>\r\n" + 
//					"	<div>\r\n" + 
//					"		<h2>BÆ°á»›c 1: Nháº­p cÃ¡c thÃ´ng tin cáº§n thiáº¿t</h2>\r\n" + 
//					"		<img src=\""+TroGiup.class.getResource("/images/themcv1.jpg")+"\">\r\n" + 
//					"		<h2>BÆ°á»›c 2: Nháº¥n nÃºt thÃªm</h2>\r\n" + 
//					"		<img src=\""+TroGiup.class.getResource("/images/themcv2.jpg")+"\">\r\n" + 
//					"		<h2>BÆ°á»›c 3: Chá»�n yes Ä‘á»ƒ xÃ¡c nháº­n láº¡i</h2>\r\n" + 
//					"		<img src=\""+TroGiup.class.getResource("/images/themcv3.jpg")+"\">\r\n" + 
//					"	</div>\r\n" + 
//					"</body>\r\n" + 
//					"</html>");
//
//		}else if(sa.equals("Cáº­p nháº­t thÃ´ng tin cÃ´ng viá»‡c")) {
//			edit.setText("<html>\r\n" + 
//					"<head>\r\n" + 
//					"	<title></title>\r\n" + 
//					"	<style type=\"text/css\">\r\n" + 
//					"		div{\r\n" + 
//					"			margin-left: 20px;\r\n" + 
//					"		}\r\n" + 
//					"		h2{\r\n" + 
//					"			padding: 10px;\r\n" + 
//					"		}\r\n" + 
//					"	</style>\r\n" + 
//					"</head>\r\n" + 
//					"<body>\r\n" + 
//					"	<div>\r\n" + 
//					"		<h2>BÆ°á»›c 1: Chá»�n cÃ´ng viá»‡c cáº§n sá»­a</h2>\r\n" + 
//					"		<img src=\""+TroGiup.class.getResource("/images/capnhatcv1.jpg")+"\">\r\n" + 
//					"		<h2>BÆ°á»›c 2: nháº­p thÃ´ng tin má»›i</h2>\r\n" + 
//					"		<img src=\""+TroGiup.class.getResource("/images/capnhatcv2.jpg")+"\">\r\n" + 
//					"		<h2>BÆ°á»›c 3: Nháº¥n nÃºt cáº­p nháº­t</h2>\r\n" + 
//					"		<img src=\""+TroGiup.class.getResource("/images/capnhatcv3.jpg")+"\">\r\n" + 
//					"		<h2>BÆ°á»›c 4: Chá»�n yes Ä‘á»ƒ xÃ¡c nháº­n láº¡i</h2>\r\n" + 
//					"		<img src=\""+TroGiup.class.getResource("/images/capnhatcv4.jpg")+"\">\r\n" + 
//					"	</div>\r\n" + 
//					"</body>\r\n" + 
//					"</html>");
//		}else if(sa.equals("Cáº­p nháº­t tráº¡ng thÃ¡i cÃ´ng viá»‡c")) {
//			edit.setText("<html>\r\n" + 
//					"<head>\r\n" + 
//					"	<title></title>\r\n" + 
//					"	<style type=\"text/css\">\r\n" + 
//					"		div{\r\n" + 
//					"			margin-left: 20px;\r\n" + 
//					"		}\r\n" + 
//					"		h2{\r\n" + 
//					"			padding: 10px;\r\n" + 
//					"		}\r\n" + 
//					"	</style>\r\n" + 
//					"</head>\r\n" + 
//					"<body>\r\n" + 
//					"	<div>\r\n" + 
//					"		<h2>BÆ°á»›c 1: NhÃ¡y Ä‘Ãºp vÃ o cÃ´ng trÃ¬nh cáº§n sá»­a</h2>\r\n" + 
//					"		<img src=\""+TroGiup.class.getResource("/images/capnhatttcv1.jpg")+"\">\r\n" + 
//					"		<h2>BÆ°á»›c 2: Chá»�n vÃ o cÃ´ng viá»‡c cáº§n sá»¯a</h2>\r\n" + 
//					"		<img src=\""+TroGiup.class.getResource("/images/capnhatttcv2.jpg")+"\">\r\n" + 
//					"		<h2>BÆ°á»›c 3: Chá»�n tráº¡ng thÃ¡i cÃ´ng viá»‡c</h2>\r\n" + 
//					"		<img src=\""+TroGiup.class.getResource("/images/capnhatttcv3.jpg")+"\">\r\n" + 
//					"		<h2>BÆ°á»›c 4: Nháº¥n nÃºt cáº­p nháº­t</h2>\r\n" + 
//					"		<img src=\""+TroGiup.class.getResource("/images/capnhatttcv4.jpg")+"\">\r\n" + 
//					"		<h2>BÆ°á»›c 5: Chá»�n yes Ä‘á»ƒ xÃ¡c nháº­n láº¡i</h2>\r\n" + 
//					"		<img src=\""+TroGiup.class.getResource("/images/capnhatttcv5.jpg")+"\">\r\n" + 
//					"	</div>\r\n" + 
//					"</body>\r\n" + 
//					"</html>");
//		}
//	}
//}
