/*The MIT License (MIT)

Copyright (c) 2016 Mauricio Binda da Costa - mauriciobc.mbc@hotmail.com

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.*/
package br.com.etzero.gui.frames;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextPane;

public class Sobre extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Sobre() {
		setTitle("Sobre o ETzero");
		setFrameIcon(new ImageIcon(Sobre.class.getResource("/resources/dialog-information.png")));
		setClosable(true);
		setBounds(100, 100, 800, 450);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Sobre.class.getResource("/resources/projetoETO200x200.png")));
		lblNewLabel.setBounds(576, 194, 200, 212);
		getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 570, 407);
		getContentPane().add(scrollPane);

		JTextPane txtpnVersoData = new JTextPane();
		scrollPane.setViewportView(txtpnVersoData);
		txtpnVersoData.setEditable(false);
		txtpnVersoData.setFont(new Font("SansSerif", Font.PLAIN, 12));
		txtpnVersoData.setText("Versão: 1.1 \nData da Versão: 23/06/2016 \nDesenvolvedores:  "
				+ "Mauricio Binda da Costa, Gustavo Haddad Souza Vieira, Thiago Redighieri, Danielle Pereira de Melo, Lucas Miranda Quintela \n\n"
				+ "Licença: The MIT License (MIT)Copyright (c) 2016 Mauricio Binda da Costa - mauriciobc.mbc@hotmail.com\n\n "
				+ "Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation "
				+ "files (the \"Software\"), to deal in the Software without restriction, including without limitation the rights to use, copy, "
				+ "modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software "
				+ "is furnished to do so, subject to the following conditions: The above copyright notice and this permission notice shall be "
				+ "included in all copies or substantial portions of the Software. \n\nTHE SOFTWARE IS PROVIDED \"AS IS\", "
				+ "WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, "
				+ "FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR "
				+ "ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN "
				+ "CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.");

	}
}
