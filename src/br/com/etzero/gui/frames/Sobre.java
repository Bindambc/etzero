package br.com.etzero.gui.frames;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollPane;

public class Sobre extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Sobre() {
		setTitle("Sobre o ETzero");
		setFrameIcon(new ImageIcon(Sobre.class.getResource("/resources/dialog-information.png")));
		setClosable(true);
		setBounds(100, 100, 638, 300);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Sobre.class.getResource("/resources/projetoETO200x200.png")));
		lblNewLabel.setBounds(10, 48, 200, 212);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(209, 11, 405, 245);
		getContentPane().add(scrollPane);

		JTextArea txtrVersoData = new JTextArea();
		scrollPane.setViewportView(txtrVersoData);
		txtrVersoData.setText("Vers\u00E3o: 1.0\r\nData da Vers\u00E3o: 04/2016\r\nDesenvolvedores: \n\nLicen\u00E7a:\n\n\nThe MIT License (MIT)\n\nCopyright (c) 2016 Mauricio Binda da Costa - mauriciobc.mbc@hotmail.com\n\nPermission is hereby granted, free of charge, to any person obtaining a copy of\nthis software and associated documentation files (the \"Software\"), to deal in\nthe Software without restriction, including without limitation the rights to\nuse, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of\nthe Software, and to permit persons to whom the Software is furnished to do so,\nsubject to the following conditions:\n\nThe above copyright notice and this permission notice shall be included in all\ncopies or substantial portions of the Software.\n\nTHE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR\nIMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS\nFOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR\nCOPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER\nIN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN\nCONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.\n\n        \n          ");
		txtrVersoData.setEditable(false);
		txtrVersoData.setBackground(new Color(230, 230, 250));

	}
}
