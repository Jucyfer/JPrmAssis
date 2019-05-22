package cib.ccc.other;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import cib.ccc.main.AssisMain;

import java.awt.Window.Type;
import java.awt.FlowLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@SuppressWarnings("unused")
public class Configs extends JDialog {
	private static final long serialVersionUID = 5248685591732076333L;
	private JPanel panel_south, panel_east, panel_west, panel_center,
			panel_north, panel_2, panel_3, panel, panel_1, panel_4;
	private JLabel lblPrompt, label, label_1, label_2, label_3, label_4,
			label_5;
	private JButton btnOk, btnCancel;
	private JTextField txtCalledX, txtCalledY, txtMemoX, txtMemoY, txtDailX,
			txtDailY, txtRemindX, txtRemindY, txtAwaitTime, txtStepTime,
			txtPhoneNUM;
	private Component rigidArea;
	private Container container;
	private AssisMain mainWindow;
	private boolean isInterrupted = false;

	public Configs(final AssisMain owner) {
		super(owner, true);
		this.mainWindow=owner;
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		setLocationRelativeTo(owner);
		setSize(340, 265);
		container = getContentPane();
		container.setFocusable(false);
		BorderLayout borderLayout = (BorderLayout) container.getLayout();
		borderLayout.setVgap(10);
		borderLayout.setHgap(30);

		panel_north = new JPanel();
		panel_north.setFocusable(false);
		container.add(panel_north, BorderLayout.NORTH);
		panel_north.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblPrompt = new JLabel("鼠标坐标：");
		lblPrompt.setFocusable(false);
		panel_north.add(lblPrompt);

		panel_center = new JPanel();
		panel_center.setFocusable(false);
		container.add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new BorderLayout(30, 40));

		panel = new JPanel();
		panel.setFocusable(false);
		panel_center.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(6, 1, 0, 10));

		label = new JLabel("\u81F4\u7535\u5907\u6CE8");
		label.setFocusable(false);
		panel.add(label);

		label_1 = new JLabel("\u4E00\u822C\u5907\u6CE8");
		label_1.setFocusable(false);
		panel.add(label_1);

		label_2 = new JLabel("\u5916\u62E8\u6309\u94AE");
		label_2.setFocusable(false);
		panel.add(label_2);

		label_3 = new JLabel("\u63D0\u9192\u6309\u94AE");
		label_3.setFocusable(false);
		panel.add(label_3);

		label_5 = new JLabel("\u5EF6\u8FDF\u95F4\u9694");
		label_5.setFocusable(false);
		panel.add(label_5);

		label_4 = new JLabel("\u5206\u673A\u53F7\u7801");
		label_4.setFocusable(false);
		panel.add(label_4);

		panel_1 = new JPanel();
		panel_1.setFocusable(false);
		panel_center.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(6, 2, 5, 10));

		txtCalledX = new JTextField();
		txtCalledX.setText(Integer.toString(owner.getCalledX()));
		txtCalledX.addFocusListener(new FocusSelector());
		panel_1.add(txtCalledX);
		txtCalledX.setColumns(10);

		txtCalledY = new JTextField();
		txtCalledY.setText(Integer.toString(owner.getCalledY()));
		txtCalledY.addFocusListener(new FocusSelector());
		panel_1.add(txtCalledY);
		txtCalledY.setColumns(10);

		txtMemoX = new JTextField();
		txtMemoX.setText(Integer.toString(owner.getMemoX()));
		txtMemoX.addFocusListener(new FocusSelector());
		panel_1.add(txtMemoX);
		txtMemoX.setColumns(10);

		txtMemoY = new JTextField();
		txtMemoY.setText(Integer.toString(owner.getMemoY()));
		txtMemoY.addFocusListener(new FocusSelector());
		panel_1.add(txtMemoY);
		txtMemoY.setColumns(10);

		txtDailX = new JTextField();
		txtDailX.setText(Integer.toString(owner.getDailX()));
		txtDailX.addFocusListener(new FocusSelector());
		panel_1.add(txtDailX);
		txtDailX.setColumns(10);

		txtDailY = new JTextField();
		txtDailY.setText(Integer.toString(owner.getDailY()));
		txtDailY.addFocusListener(new FocusSelector());
		panel_1.add(txtDailY);
		txtDailY.setColumns(10);

		txtRemindX = new JTextField();
		txtRemindX.setText(Integer.toString(owner.getRemindX()));
		txtRemindX.addFocusListener(new FocusSelector());
		panel_1.add(txtRemindX);
		txtRemindX.setColumns(10);

		txtRemindY = new JTextField();
		txtRemindY.setText(Integer.toString(owner.getRemindY()));
		txtRemindY.addFocusListener(new FocusSelector());
		panel_1.add(txtRemindY);
		txtRemindY.setColumns(10);

		txtAwaitTime = new JTextField();
		txtAwaitTime.setText(Integer.toString(owner.getAwaitTime()));
		txtAwaitTime.addFocusListener(new FocusSelector());
		panel_1.add(txtAwaitTime);
		txtAwaitTime.setColumns(10);

		txtStepTime = new JTextField();
		txtStepTime.setText(Integer.toString(owner.getStepTime()));
		txtStepTime.addFocusListener(new FocusSelector());
		panel_1.add(txtStepTime);
		txtStepTime.setColumns(10);

		txtPhoneNUM = new JTextField();
		txtPhoneNUM.setText(owner.getPhoneNUM());
		txtPhoneNUM.addFocusListener(new FocusSelector());
		panel_1.add(txtPhoneNUM);
		txtPhoneNUM.setColumns(10);

		panel_4 = new JPanel();
		panel_4.setFocusable(false);
		panel_1.add(panel_4);

		rigidArea = Box.createRigidArea(new Dimension(10, 20));
		rigidArea.setFocusable(false);
		panel_center.add(rigidArea, BorderLayout.EAST);

		panel_west = new JPanel();
		panel_west.setFocusable(false);
		container.add(panel_west, BorderLayout.WEST);

		panel_east = new JPanel();
		panel_east.setFocusable(false);
		container.add(panel_east, BorderLayout.EAST);

		panel_south = new JPanel();
		panel_south.setFocusable(false);
		container.add(panel_south, BorderLayout.SOUTH);
		panel_south.setLayout(new GridLayout(0, 4, 10, 0));

		panel_2 = new JPanel();
		panel_2.setFocusable(false);
		panel_south.add(panel_2);

		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainWindow.setDailX(txtDailX.getText());
				mainWindow.setDailY(txtDailY.getText());
				mainWindow.setCalledX(txtCalledX.getText());
				mainWindow.setCalledY(txtCalledY.getText());
				mainWindow.setMemoX(txtMemoX.getText());
				mainWindow.setMemoY(txtMemoY.getText());
				mainWindow.setPhoneNUM(txtPhoneNUM.getText());
				mainWindow.setRemindX(txtRemindX.getText());
				mainWindow.setRemindY(txtRemindY.getText());
				mainWindow.setAwaitTime(txtAwaitTime.getText());
				mainWindow.setStepTime(txtStepTime.getText());
//				mainWindow.reload();
				dispose();

			}
		});
		btnOk.setFocusable(false);
		panel_south.add(btnOk);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFocusable(false);
		panel_south.add(btnCancel);

		panel_3 = new JPanel();
		panel_3.setFocusable(false);
		panel_south.add(panel_3);
		setType(Type.UTILITY);
		setResizable(false);
		setAlwaysOnTop(true);
		new MouseTracker().start();
		setVisible(true);
	}

	public void dispose() {
		isInterrupted = true;
		super.dispose();
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
				lblPrompt.setText("鼠标坐标：" + p.x + "," + p.y);
			}
		}
	}

	private class FocusSelector extends FocusAdapter {
		public void focusGained(FocusEvent e) {
			((JTextField) e.getSource()).selectAll();
		}

	}
}
