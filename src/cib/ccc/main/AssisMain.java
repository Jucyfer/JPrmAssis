package cib.ccc.main;

import java.awt.AWTException;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

//import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
//import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
//import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import cib.ccc.other.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings({ "unused", "serial" })
public class AssisMain extends JFrame {
	private int ckokCount = 0;
	private static String configPath = System.getProperty("java.class.path").substring(0,
			System.getProperty("java.class.path").lastIndexOf("\\")) + "\\JPrmAssis.config";
//	private final static String[] themes = {
//			"javax.swing.plaf.metal.MetalLookAndFeel",
//			"javax.swing.plaf.nimbus.NimbusLookAndFeel",
//			"com.sun.java.swing.plaf.motif.MotifLookAndFeel",
//			"com.sun.java.swing.plaf.windows.WindowsLookAndFeel",
//			"com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel" };
	private static int themeNum = 0;
	private static Point locationPoint;
	private Container container;
	private Button btnCkcl, btnQita, btnButong, btnLaiti, btnGuanji, btnJujie, btnTonghua, btnWuren, btnCkok, btnDial,
			btnMemo, btnTixing;
	private JSeparator separator;
	private Choice choiceDial;
	private JMenuItem menuTingji, menuKonghao, menuCuohao, menuOptions, menuExit, menuChgTheme;
	private JPanel panelYoujian;
	private JPopupMenu popupQita, popupMain;
	private JLabel lblMouseX, lblMouseY;
	private Robot robot;
	private int calledX, calledY, dailX, dailY, memoX, memoY, remindX, remindY, awaitTime, stepTime;
	private String phoneNUM;
	private String tingji, konghao, cuohao, wuren, tonghua, jujie, ckok, ckcl, cankong, jiecan, guanji, laiti, butong;
	private boolean isInterrupted = false;
	private static final Properties props = new Properties() {
		{
			setProperty("calledX", "110");
			setProperty("calledY", "972");
			setProperty("dailX", "110");
			setProperty("dailY", "972");
			setProperty("memoX", "110");
			setProperty("memoY", "972");
			setProperty("remindX", "110");
			setProperty("remindY", "972");
			setProperty("awaitTime", "500");
			setProperty("stepTime", "17");
			setProperty("phoneNUM", "110972");
			setProperty("locationPointX", "0");
			setProperty("locationPointY", "0");
			setProperty("tingji", "mͣ��[CHLP---δ������]");
			setProperty("konghao", "m�պ�[CNE---�պŻ��޴���]");
			setProperty("cuohao", "m���[CNE---�պŻ��޴���]");
			setProperty("wuren", "m���˽���[CHLP---δ������]");
			setProperty("tonghua", "m����ͨ��[CHLP---δ������]");
			setProperty("jujie", "m�ܽ�[CHLP---δ������]");
			setProperty("ckok", "m[CKOK---ȷ������]");
			setProperty("ckcl", "[CKCL---��ע����]���");
			setProperty("cankong", "[01---��ر�ע]�ο�");
			setProperty("jiecan", "[01---��ر�ע]���");
			setProperty("guanji", "m�ػ�[CHLP---δ������]");
			setProperty("laiti", "m��������[CHLP---δ������]");
			setProperty("butong", "m�޷���ͨ[CHLP---δ������]");
		}
	};

	private static final HashMap<String, Integer> keyMap = new HashMap<String, Integer>() {
		{
			put("A", 0x41);
			put("B", 0x42);
			put("C", 0x43);
			put("D", 0x44);
			put("E", 0x45);
			put("F", 0x46);
			put("G", 0x47);
			put("H", 0x48);
			put("I", 0x49);
			put("J", 0x4A);
			put("K", 0x4B);
			put("L", 0x4C);
			put("M", 0x4D);
			put("N", 0x4E);
			put("O", 0x4F);
			put("P", 0x50);
			put("Q", 0x51);
			put("R", 0x52);
			put("S", 0x53);
			put("T", 0x54);
			put("U", 0x55);
			put("V", 0x56);
			put("W", 0x57);
			put("X", 0x58);
			put("Y", 0x59);
			put("Z", 0x5A);
			put("0", 0x30);
			put("1", 0x31);
			put("2", 0x32);
			put("3", 0x33);
			put("4", 0x34);
			put("5", 0x35);
			put("6", 0x36);
			put("7", 0x37);
			put("8", 0x38);
			put("9", 0x39);
			put("ENTER", (int) '\n');
			put("BACK_SPACE", (int) '\b');
			put("TAB", (int) '\t');
			put("CANCEL", 0x03);
			put("CLEAR", 0x0C);
			put("SHIFT", 0x10);
			put("CONTROL", 0x11);
			put("ALT", 0x12);
			put("PAUSE", 0x13);
			put("CAPS_LOCK", 0x14);
			put("ESCAPE", 0x1B);
			put("SPACE", 0x20);
			put("PAGE_UP", 0x21);
			put("PAGE_DOWN", 0x22);
			put("END", 0x23);
			put("HOME", 0x24);

		}

	};
	private JPopupMenu popupCkokCount;
	private JMenuItem mntmCkokcount;

	public AssisMain() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				throw new RuntimeException("������ֱ�Ӳ����");
			}
		});
		locationPoint = new Point();
		try {
			props.load(new FileInputStream(configPath));
		} catch (Exception e) {
			calledX = 110;
			calledY = 972;
			dailX = 110;
			dailY = 972;
			memoX = 110;
			memoY = 972;
			remindX = 110;
			remindY = 972;
			awaitTime = 500;
			stepTime = 17;
			phoneNUM = "110972";
			locationPoint.x = 0;
			locationPoint.y = 0;
			tingji = "mͣ��[CHLP---δ������]";
			konghao = "m�պ�[CNE---�պŻ��޴���]";
			cuohao = "m���[CNE---�պŻ��޴���]";
			wuren = "m���˽���[CHLP---δ������]";
			tonghua = "m����ͨ��[CHLP---δ������]";
			jujie = "m�ܽ�[CHLP---δ������]";
			ckok = "m[CKOK---ȷ������]";
			ckcl = "[CKCL---��ע����]���";
			cankong = "[01---��ر�ע]�ο�";
			jiecan = "[01---��ر�ע]���";
			guanji = "m�ػ�[CHLP---δ������]";
			laiti = "m��������[CHLP---δ������]";
			butong = "m�޷���ͨ[CHLP---δ������]";
		}
		try {
//			UIManager.setLookAndFeel(themes[themeNum]);
			robot = new Robot();
		} catch (Exception e) {
			e.printStackTrace();
		}

		calledX = Integer.parseInt(props.getProperty("calledX", "110"));
		calledY = Integer.parseInt(props.getProperty("calledY", "972"));
		dailX = Integer.parseInt(props.getProperty("dailX", "110"));
		dailY = Integer.parseInt(props.getProperty("dailY", "972"));
		memoX = Integer.parseInt(props.getProperty("memoX", "110"));
		memoY = Integer.parseInt(props.getProperty("memoY", "972"));
		remindX = Integer.parseInt(props.getProperty("remindX", "110"));
		remindY = Integer.parseInt(props.getProperty("remindY", "972"));
		awaitTime = Integer.parseInt(props.getProperty("awaitTime", "500"));
		stepTime = Integer.parseInt(props.getProperty("stepTime", "17"));
		phoneNUM = props.getProperty("phoneNUM", "110972");
		tingji = props.getProperty("tingji", "mͣ��[CHLP---δ������]");
		konghao = props.getProperty("konghao", "m�պ�[CNE---�պŻ��޴���]");
		cuohao = props.getProperty("cuohao", "m���[CNE---�պŻ��޴���]");
		wuren = props.getProperty("wuren", "m���˽���[CHLP---δ������]");
		tonghua = props.getProperty("tonghua", "m����ͨ��[CHLP---δ������]");
		jujie = props.getProperty("jujie", "m�ܽ�[CHLP---δ������]");
		ckok = props.getProperty("ckok", "m[CKOK---ȷ������]");
		ckcl = props.getProperty("ckcl", "[CKCL---��ע����]���");
		cankong = props.getProperty("cankong", "[01---��ر�ע]�ο�");
		jiecan = props.getProperty("jiecan", "[01---��ر�ע]���");
		guanji = props.getProperty("guanji", "m�ػ�[CHLP---δ������]");
		laiti = props.getProperty("laiti", "m��������[CHLP---δ������]");
		butong = props.getProperty("butong", "m�޷���ͨ[CHLP---δ������]");
		locationPoint.x = Integer.parseInt(props.getProperty("locationPointX", "0"));
		locationPoint.y = Integer.parseInt(props.getProperty("locationPointY", "0"));
		robot.setAutoDelay(stepTime);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setResizable(false);
		setTitle("PRM Assistant(JavaSE7 Version by JYF)");
		setType(Type.UTILITY);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(734, 58);
		setLocation(locationPoint);
		container = getContentPane();
		container.setLayout(null);

		btnCkcl = new Button("CKCL");
		btnCkcl.addActionListener(new CalledPlayer(ckcl));
		btnCkcl.setBackground(new Color(218, 112, 214));
		btnCkcl.setFocusable(false);
		btnCkcl.setFont(new Font("����", Font.PLAIN, 12));
		btnCkcl.setBounds(0, 0, 59, 34);
		container.add(btnCkcl);

		btnQita = new Button("����");
		btnQita.setFocusable(false);
		btnQita.setFont(new Font("����", Font.PLAIN, 12));
		btnQita.setBounds(57, 0, 59, 34);
		container.add(btnQita);

		popupQita = new JPopupMenu();
		btnQita.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				popupQita.setVisible(true);
			}
		});
		addPopup(btnQita, popupQita);

		menuTingji = new JMenuItem("ͣ��");
		menuTingji.addActionListener(new CalledPlayer(tingji));
		popupQita.add(menuTingji);

		menuKonghao = new JMenuItem("�պ�");
		menuKonghao.addActionListener(new CalledPlayer(konghao));
		popupQita.add(menuKonghao);

		menuCuohao = new JMenuItem("���");
		menuCuohao.addActionListener(new CalledPlayer(cuohao));
		popupQita.add(menuCuohao);

		btnButong = new Button("��ͨ");
		btnButong.addActionListener(new CalledPlayer(butong));
		btnButong.setFocusable(false);
		btnButong.setFont(new Font("����", Font.PLAIN, 12));
		btnButong.setBounds(114, 0, 59, 34);
		container.add(btnButong);

		btnLaiti = new Button("����");
		btnLaiti.addActionListener(new CalledPlayer(laiti));
		btnLaiti.setFocusable(false);
		btnLaiti.setFont(new Font("����", Font.PLAIN, 12));
		btnLaiti.setBounds(171, 0, 59, 34);
		container.add(btnLaiti);

		btnGuanji = new Button("�ػ�");
		btnGuanji.addActionListener(new CalledPlayer(guanji));
		btnGuanji.setFocusable(false);
		btnGuanji.setFont(new Font("����", Font.PLAIN, 12));
		btnGuanji.setBounds(228, 0, 59, 34);
		container.add(btnGuanji);

		btnJujie = new Button("�ܽ�");
		btnJujie.addActionListener(new CalledPlayer(jujie));
		btnJujie.setFocusable(false);
		btnJujie.setFont(new Font("����", Font.PLAIN, 12));
		btnJujie.setBounds(285, 0, 59, 34);
		container.add(btnJujie);

		btnTonghua = new Button("ͨ��");
		btnTonghua.addActionListener(new CalledPlayer(tonghua));
		btnTonghua.setFocusable(false);
		btnTonghua.setFont(new Font("����", Font.PLAIN, 12));
		btnTonghua.setBounds(342, 0, 59, 34);
		container.add(btnTonghua);

		btnWuren = new Button("����");
		btnWuren.addActionListener(new CalledPlayer(wuren));
		btnWuren.setFocusable(false);
		btnWuren.setFont(new Font("����", Font.PLAIN, 12));
		btnWuren.setBounds(399, 0, 59, 34);
		container.add(btnWuren);

		btnCkok = new Button("CKOK");
		btnCkok.addActionListener(new CalledPlayer(ckok));
		btnCkok.setFocusable(false);
		btnCkok.setForeground(new Color(255, 0, 0));
		btnCkok.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCkok.setFont(new Font("����", Font.PLAIN, 12));
		btnCkok.setBounds(456, 0, 59, 34);
		container.add(btnCkok);

		popupCkokCount = new JPopupMenu();
		addPopup(btnCkok, popupCkokCount);

		mntmCkokcount = new JMenuItem("ckok: " + Integer.toString(ckokCount));
		popupCkokCount.add(mntmCkokcount);

		btnDial = new Button("Dial");
		btnDial.addActionListener(new DailPlayer(0));
		btnDial.setFocusable(false);
		btnDial.setForeground(new Color(153, 0, 255));
		btnDial.setFont(new Font("����", Font.PLAIN, 12));
		btnDial.setBounds(527, 0, 59, 34);
		container.add(btnDial);

		btnMemo = new Button("����");
		btnMemo.addActionListener(new MemoPlayer(cankong));
		btnMemo.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					new Thread(new MemoPlayer(jiecan)).start();
				}
			}
		});
		btnMemo.setFocusable(false);
		btnMemo.setForeground(Color.BLACK);
		btnMemo.setFont(new Font("����", Font.PLAIN, 12));
		btnMemo.setBounds(671, 0, 59, 34);
		container.add(btnMemo);

		choiceDial = new Choice();
		choiceDial.setEnabled(false);
		choiceDial.setFocusable(false);
		choiceDial.add("�ֻ�");
		choiceDial.add("����");
		choiceDial.add("�ҵ�");
		choiceDial.add("��ϵ��");
		choiceDial.setFont(new Font("����", Font.PLAIN, 12));
		choiceDial.setBounds(590, 0, 74, 20);
		container.add(choiceDial);

		separator = new JSeparator();
		separator.setForeground(new Color(255, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(520, 0, 2, 34);
		container.add(separator);

		btnTixing = new Button("����");
		btnTixing.setFocusable(false);
		btnTixing.setFont(new Font("����", Font.PLAIN, 12));
		btnTixing.setBounds(740, 0, 59, 34);
		container.add(btnTixing);

		panelYoujian = new JPanel();
		panelYoujian.setBounds(513, 0, 17, 34);
		container.add(panelYoujian);

		popupMain = new JPopupMenu();
		addPopup(panelYoujian, popupMain);

		menuOptions = new JMenuItem("��������...");
		menuOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Configs(AssisMain.this);
			}
		});
		popupMain.add(menuOptions);

		menuChgTheme = new JMenuItem("�л�����");
//		menuChgTheme.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				AssisMain.locationPoint = AssisMain.this.getLocation();
//				try {
//					themeNum = ++themeNum > 4 ? 0 : themeNum;
//					System.out.println("Switch theme Class<?> to: "
//							+ themes[themeNum]);
//					AssisMain.this.dispose();
//					System.gc();
//
//					new AssisMain().setVisible(true);
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
//		});
		popupMain.add(menuChgTheme);

		menuExit = new JMenuItem("�˳�");
		menuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		popupMain.add(menuExit);

		lblMouseX = new JLabel("0000");
		lblMouseX.setFont(new Font("����", Font.PLAIN, 11));
		lblMouseX.setBounds(593, 19, 32, 15);
		container.add(lblMouseX);

		lblMouseY = new JLabel("0000");
		lblMouseY.setFont(new Font("����", Font.PLAIN, 11));
		lblMouseY.setBounds(627, 19, 32, 15);
		container.add(lblMouseY);
		new MouseTracker().start();
	}

	public int getCalledX() {
		return calledX;
	}

	public int getCalledY() {
		return calledY;
	}

	public int getDailX() {
		return dailX;
	}

	public int getDailY() {
		return dailY;
	}

	public int getMemoX() {
		return memoX;
	}

	public int getMemoY() {
		return memoY;
	}

	public int getRemindX() {
		return remindX;
	}

	public int getRemindY() {
		return remindY;
	}

	public int getAwaitTime() {
		return awaitTime;
	}

	public int getStepTime() {
		return stepTime;
	}

	public String getPhoneNUM() {
		return phoneNUM;
	}

	public void setPhoneNUM(String phoneNUM) {
		this.phoneNUM = phoneNUM;
		props.setProperty("phoneNUM", phoneNUM);

	}

	public void setCalledX(String calledX) {
		this.calledX = Integer.parseInt(calledX);
		props.setProperty("calledX", calledX);
	}

	public void setCalledY(String calledY) {
		this.calledY = Integer.parseInt(calledY);
		props.setProperty("calledY", calledY);
	}

	public void setDailX(String dailX) {
		this.dailX = Integer.parseInt(dailX);
		props.setProperty("dailX", dailX);
	}

	public void setDailY(String dailY) {
		this.dailY = Integer.parseInt(dailY);
		props.setProperty("dailY", dailY);
	}

	public void setMemoX(String memoX) {
		this.memoX = Integer.parseInt(memoX);
		props.setProperty("memoX", memoX);
	}

	public void setMemoY(String menoY) {
		this.memoY = Integer.parseInt(menoY);
		props.setProperty("memoY", menoY);
	}

	public void setRemindX(String remindX) {
		this.remindX = Integer.parseInt(remindX);
		props.setProperty("remindX", remindX);
	}

	public void setRemindY(String remindY) {
		this.remindY = Integer.parseInt(remindY);
		props.setProperty("remindY", remindY);
	}

	public void setAwaitTime(String awaitTime) {
		this.awaitTime = Integer.parseInt(awaitTime);
		props.setProperty("awaitTime", awaitTime);
	}

	public void setStepTime(String stepTime) {
		this.stepTime = Integer.parseInt(stepTime);
		props.setProperty("stepTime", stepTime);
	}

	public void setClipBoard(String content) {
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(content), null);
	}

	public int getKeyCode(String k) {
		return keyMap.get(k.toUpperCase());
	}

	public void sendSingleKey(String k) {
		sendSingleKey(getKeyCode(k.toUpperCase()));
	}

	public void sendSingleKey(int k) {
		robot.keyPress(k);
		robot.keyRelease(k);
	}

	public void sendKeyString(String s) {
		for (char c : s.toUpperCase().toCharArray()) {
			sendSingleKey(String.valueOf(c));
		}
	}

	public void sendCombineKeys(int... keys) {
		for (int key : keys) {
			robot.keyPress(key);
		}
		for (int i = keys.length - 1; i >= 0; i--) {
			robot.keyRelease(keys[i]);
		}
	}

	public void mouseClick(int x, int y) {
		mouseMove(x, y);
		mouseClick();
	}

	public void mouseClick() {
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}

	public void mouseMove(int x, int y) {
		robot.mouseMove(x, y);
	}

	private abstract class AbstractPlayer implements ActionListener, Runnable {
		@Override
		public void actionPerformed(ActionEvent e) {
			new Thread(this).start();
		}
	}

	private abstract class AbstractPastePlayer extends AbstractPlayer {
		protected String content;

		public AbstractPastePlayer(String content) {
			this.content = content;
		}
	}

	private class CalledPlayer extends AbstractPastePlayer {
		public CalledPlayer(String content) {
			super(content);
		}

		@Override
		public void run() {
			setClipBoard(content);
			mouseClick(calledX, calledY);
			try {
				Thread.sleep(awaitTime);
			} catch (InterruptedException ite) {
				ite.printStackTrace();
			}
			sendCombineKeys(getKeyCode("control"), getKeyCode("v"));
			sendCombineKeys(getKeyCode("control"), getKeyCode("enter"));
			switch (content) {
			case "m[CKOK---ȷ������]":
				ckokCount++;
				mntmCkokcount.setText("ckok: " + Integer.toString(ckokCount));
				break;
			case "[CKCL---��ע����]���":
				ckokCount = ckokCount <= 0 ? 0 : ckokCount - 1;
				break;
			default:
				break;
			}
		}

	}

	private class MemoPlayer extends AbstractPastePlayer {
		public MemoPlayer(String content) {
			super(content);
		}

		@Override
		public void run() {
			setClipBoard(content);
			mouseClick(memoX, memoY);
			try {
				Thread.sleep(awaitTime);
			} catch (InterruptedException ite) {
				ite.printStackTrace();
			}
			sendCombineKeys(getKeyCode("control"), getKeyCode("v"));
			sendCombineKeys(getKeyCode("control"), getKeyCode("enter"));
		}

	}

	private class DailPlayer extends AbstractPlayer {
		private int dailIndex;

		public DailPlayer(int dailIndex) {
			this.dailIndex = dailIndex;
		}

		public void run() {
			setClipBoard(phoneNUM);
			mouseClick(dailX, dailY);
			try {
				Thread.sleep(awaitTime);
			} catch (InterruptedException ite) {
				ite.printStackTrace();
			}
			sendSingleKey("tab");
			sendSingleKey("tab");
			sendCombineKeys(getKeyCode("control"), getKeyCode("v"));
			sendSingleKey("tab");
			sendSingleKey("tab");
			sendSingleKey("tab");
			sendSingleKey("tab");
			sendSingleKey("tab");
			sendSingleKey("space");

		}

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public void reload() {
		AssisMain.this.dispose();
		System.gc();
		new AssisMain().setVisible(true);
	}

	public void dispose() {
		try {
			isInterrupted = true;
			props.setProperty("locationPointX", Integer.toString(getLocation().x));
			props.setProperty("locationPointY", Integer.toString(getLocation().y));
			props.store(new FileOutputStream(configPath),
					"This is the config file of JPrmAssistant. Written by Jucyfer,110972");
		} catch (IOException e) {
		} finally {
			super.dispose();
		}
	}

	private class MouseTracker extends Thread {
		private Point p;

		public void run() {
			while (!isInterrupted) {
				try {
					// fps=18
					Thread.sleep(1000 / 18);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				p = MouseInfo.getPointerInfo().getLocation();
				lblMouseX.setText(Integer.toString(p.x));
				lblMouseY.setText(Integer.toString(p.y));

			}
		}
	}

	public static void main(String[] args) {
		try {
			new AssisMain().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
