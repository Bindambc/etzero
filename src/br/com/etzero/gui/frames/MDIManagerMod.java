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

import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 * 
 * @author Binda
 * @since 02/12/2013
 * @version 1.0 Beta
 */
public class MDIManagerMod {

	private static MDIManagerMod INSTANCE;
	private JDesktopPane dPane;
	// ///////////////
	private int x;
	private int y;

	// //////////////
	private int maxX;
	private int maxY;
	private int minX;
	private int minY;
	private int distanceXY;
	// ///////////////
	private boolean reply;
	private boolean autoManager = false;

	// ///////////////

	/**
	 * M�todo construtor<br>
	 * Use esse construtor para criar manualmente todas as configura��es.
	 * 
	 * @param dPane
	 *            JDesktopPane a ser gerenciado
	 * 
	 * @param maxX
	 *            int : define o limite maximo, at� onde as novas janelas
	 *            poder�o abrir. Representa a borda lateral direita do
	 *            DesktopPane
	 * @param maxY
	 *            int : define o limite inferior maximo, at� onde as novas
	 *            janelas poder�o abrir. Representa a borda inferior do
	 *            DesktopPane.
	 * @param minX
	 *            int : define o ponto X, onde a primeira janela deve ser
	 *            aberta.
	 * @param minY
	 *            int : define o ponto Y, onde a primeira janela deve ser
	 *            aberta.
	 * @param distanceXY
	 *            int : define a distancia XY entre os frames, formando o efeito
	 *            cascata.
	 * @param reply
	 *            boolean : define se devem ser abertas janelas repetidas. Use
	 *            true para permitir que sejam abertas janelas iguais ou false
	 *            para n�o permitir.
	 */

	public void configurar(JDesktopPane dPane, int maxX, int maxY, int minX, int minY, int distanceXY, boolean reply) {
		this.dPane = dPane;
		this.maxX = maxX;
		this.maxY = maxY;
		this.minX = minX;
		this.minY = minY;
		this.distanceXY = distanceXY;
		this.reply = reply;
	}

	public static synchronized MDIManagerMod getInstance() {
		if (INSTANCE == null)
			INSTANCE = new MDIManagerMod();
		return INSTANCE;
	}

	/**
	 * M�todo Construtor. <br>
	 * <b>IMPORTANTE: </b>Usando este construtor, as dist�ncias minX, minY, maxX
	 * e maxY s�o definidas automaticamente, baseadas no tamanho do DesktopPane
	 * e dos JInternalframes. Este m�todo � recomendado se voc� quiser que as
	 * janelas possam abrir at� encontrar as bordas do DesktopPane. <br>
	 * <b>Aten��o: </b>Se Preferir setar as distancias maximas e minimas xy
	 * depois, ter� que alterar o valor de autoManager para false
	 * (setAutoManager(false))
	 * 
	 * @param dPane
	 *            : DesktopPanel que se deseja gerenciar;
	 * @param distanceXY
	 *            : Distancia XY entre as janelas, que forma o efeito cascata.
	 * @param reply
	 *            : define se devem ser abertas janelas repetidas. Use true para
	 *            permitir que sejam abertas janelas iguais ou false para n�o
	 *            permitir.
	 */
	public void configurar(JDesktopPane dPane, int distanceXY, boolean reply) {
		this.dPane = dPane;
		this.distanceXY = distanceXY;
		this.reply = reply;
		this.autoManager = true;
	}

	/**
	 * M�todo Construtor
	 */
	private MDIManagerMod() {
	}

	/**
	 * Gerenciador de JInternalFrames
	 * 
	 * @param jIFrame
	 *            JInternalFrame : InternalFrame que se deseja gerenciar
	 */
	public void manager(JInternalFrame jIFrame) {

		boolean isActive = false;
		JInternalFrame[] frames = dPane.getAllFrames();

		for (JInternalFrame jif : frames) {

			if (!reply) {
				if (jif.getClass().equals(jIFrame.getClass())) {
					isActive = true;
					jif.moveToFront();
					try {
						jif.setMaximum(true);
						jif.setMaximum(false);
					} catch (PropertyVetoException e) {
						e.printStackTrace();
					}

				}
			}
		}
		if (!isActive) {
			if (frames.length > 0) {
				cascata(jIFrame, frames[0]);
				jIFrame.setLocation(x, y);
			} else {
				jIFrame.setLocation(minX, minY);
			}

			dPane.add(jIFrame);
			jIFrame.setVisible(true);
		}
	}

	private void cascata(JInternalFrame jIFrame, JInternalFrame jIFrameAnt) {

		if (dPane.getAllFrames().length > 0) {
			if (autoManager) {
				maxX = dPane.getWidth() - jIFrame.getWidth();
				maxY = dPane.getHeight() - jIFrame.getHeight();
				minX = 0;
				minY = 0;
			}
			if (jIFrameAnt.getY() < maxY) {
				y = jIFrameAnt.getY() + distanceXY;
			} else {
				y = minY;
			}
			if (jIFrameAnt.getX() < maxX) {

				x = jIFrameAnt.getX() + distanceXY;

			} else {
				x = minX;
				y = minY;
			}
		} else {
			x = minX;
			y = minY;
		}
	}

	/**
	 * Chame este m�todo para reoganizar todas as janelas abertas em cascata
	 * novamente, caso estejam espalhadas desordenadamente. Os frames s�o
	 * reorganizados com com base no que est� ativo.
	 */
	public void reOrganize() {
		JInternalFrame[] frames = dPane.getAllFrames();
		frames[frames.length - 1].setLocation(minX, minY);
		for (int index = frames.length - 2; index >= 0; index--) {
			cascata(frames[index], frames[index + 1]);
			frames[index].setLocation(x, y);
		}
	}

	/**
	 * Fecha todas as Janelas abertas
	 */
	public void closeAll() {
		JInternalFrame[] frames = dPane.getAllFrames();
		for (JInternalFrame f : frames) {
			f.dispose();

		}
	}

	public JDesktopPane getdPane() {
		return dPane;
	}

	/**
	 * 
	 * @param dPane
	 *            DesktopPanel : desktopPanel que ser� gerenciado
	 */
	public void setdPane(JDesktopPane dPane) {
		this.dPane = dPane;
	}

	// public int getX() {
	// return x;
	// }
	//
	// public void setX(int x) {
	// this.x = x;
	// }
	//
	// public int getY() {
	// return y;
	// }
	//
	// public void setY(int y) {
	// this.y = y;
	// }

	public int getMaxX() {
		return maxX;
	}

	/**
	 * 
	 * @param maxX
	 *            ponto m�ximo que delimita at� onde as janelas podem ser
	 *            abertas
	 */
	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	/**
	 * 
	 * @param maxY
	 *            ponto m�ximo que delimita at� onde as janelas podem ser
	 *            abertas
	 */
	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public int getMinX() {
		return minX;
	}

	/**
	 * 
	 * @param minX
	 *            ponto X minimo onde a primeira janela dever� ser aberta
	 */
	public void setMinX(int minX) {
		this.minX = minX;
	}

	public int getMinY() {
		return minY;
	}

	/**
	 * 
	 * @param minY
	 *            ponto Y minimo onde a primeira janela dever� ser aberta
	 */
	public void setMinY(int minY) {
		this.minY = minY;
	}

	public int getDistanceXY() {
		return distanceXY;
	}

	/**
	 * 
	 * @param distanceXY
	 *            define a distancia xy que forma o efeito cascata entre as
	 *            janelas abertas.
	 */
	public void setDistanceXY(int distanceXY) {
		this.distanceXY = distanceXY;
	}

	public boolean isReply() {
		return reply;
	}

	/**
	 * 
	 * @param reply
	 *            define se podem ser abertas janelas repetidas
	 */
	public void setReply(boolean reply) {
		this.reply = reply;
	}

	/**
	 * 
	 * @return estado de automanager
	 */
	public boolean isAutoManager() {
		return autoManager;
	}

	/**
	 * 
	 * @param auto
	 *            boolean: define se a abertura de telas deve ser gerenciada
	 *            manualmente ou n�o. Use true para gerenciar automaticamente ou
	 *            false para gerenciar de forma manual. Se definido como true as
	 *            janelas ser�o de forma automatizada at� as bordas do
	 *            desktopPane
	 */
	public void setAutoManager(boolean auto) {
		this.autoManager = auto;
	}
}
