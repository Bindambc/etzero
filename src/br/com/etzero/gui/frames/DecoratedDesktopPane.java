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
			img = javax.imageio.ImageIO.read(DecoratedDesktopPane.class.getResource("/resources/projetoETO200x200.png"));

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