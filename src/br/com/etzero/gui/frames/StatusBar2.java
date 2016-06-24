package br.com.etzero.gui.frames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class StatusBar2 extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatusBar2 frame = new StatusBar2();
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
	public StatusBar2() {
		setBounds(100, 100, 450, 300);

	}

}
