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

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JDesktopPane;

class DecoratedDesktopPane extends JDesktopPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image img;

	public DecoratedDesktopPane() {
		try {
			img = javax.imageio.ImageIO
					.read(DecoratedDesktopPane.class.getResource("/resources/projetoETO200x200.png"));

		} catch (Exception ex) {
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (img != null) {
			Dimension dimension = this.getSize();
			int x = (int) (dimension.getWidth() - img.getWidth(this));
			int y = (int) (dimension.getHeight() - img.getHeight(this));

			g.drawImage(img, x, y, img.getWidth(this), img.getHeight(this), this);
		} else {
			g.drawString("Imagem nao encontrada", 50, 50);
		}
	}
}