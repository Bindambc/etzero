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
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.SwingWorker;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JDesktopPane;
import javax.swing.JProgressBar;

public class Start {

	private JFrame frmETzero;
	private Font fonteMenu = new Font("SansSerif", Font.BOLD, 14);
	private Font fonteMenuItem = new Font("SansSerif", Font.PLAIN, 14);
	private MDIManagerMod mdi = MDIManagerMod.getInstance();
	private JDesktopPane desktopPane;
	private JLabel lblCarregando;
	private JProgressBar progressBar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoClassDefFoundError e) {
					e.printStackTrace();
				}
				try {
					Start window = new Start();
					window.frmETzero.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	/**
	 * Create the application.
	 */
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {

		System.out.println("IrrIfes started ... ");
		frmETzero = new JFrame();
		frmETzero.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if ((Mensagens.pergunta("Deseja realmente sair?")) == 0) {
					System.out.print("IrrIfes stoped ... ");
					frmETzero.dispose();
				}
			}
		});
		frmETzero.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmETzero.setIconImage(
				Toolkit.getDefaultToolkit().getImage(Start.class.getResource("/resources/projetoETO200x200.png")));
		frmETzero.setTitle("ETzero");

		// cria uma janela maximizada
		// frame.setResizable(false);

		frmETzero.setBounds(100, 100, 850, 550);
		frmETzero.setMinimumSize(new Dimension(850, 550));
		frmETzero.setExtendedState(Frame.MAXIMIZED_BOTH);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(fonteMenu);
		frmETzero.setJMenuBar(menuBar);

		JMenu mnInicio = new JMenu("In\u00EDcio");
		mnInicio.setIcon(new ImageIcon(Start.class.getResource("/resources/go-home.png")));
		mnInicio.setFont(fonteMenu);
		menuBar.add(mnInicio);

		JSeparator separator = new JSeparator();
		mnInicio.add(separator);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((Mensagens.pergunta("Deseja realmente sair?")) == 0) {
					System.out.print("IrrIfes stoped ... ");
					frmETzero.dispose();
				}
			}
		});
		mntmSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mntmSair.setIcon(new ImageIcon(Start.class.getResource("/resources/system-log-out.png")));
		mnInicio.add(mntmSair);

		JMenu mnCadastrar = new JMenu("Cadastrar");
		mnCadastrar.setIcon(new ImageIcon(Start.class.getResource("/resources/document-new.png")));
		mnCadastrar.setFont(fonteMenu);
		menuBar.add(mnCadastrar);

		JMenuItem mntmEstacao = new JMenuItem("Esta\u00E7\u00E3o");
		mntmEstacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// mdi.manager(new cadEstacao());

				progressBar.setVisible(true);
				progressBar.setIndeterminate(true);
				lblCarregando.setVisible(true);

				SwingWorker worker = new SwingWorker() {
					@Override
					protected Object doInBackground() throws Exception {
						mdi.manager(new cadEstacao());
						progressBar.setVisible(false);
						progressBar.setIndeterminate(false);
						lblCarregando.setVisible(false);
						return null;
					}
				};
				worker.execute();

			}
		});
		mntmEstacao.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK));
		mntmEstacao.setIcon(new ImageIcon(Start.class.getResource("/resources/document-new16.png")));
		mntmEstacao.setFont(fonteMenuItem);
		mnCadastrar.add(mntmEstacao);

		JMenu mnDados = new JMenu("Dados");
		mnDados.setIcon(new ImageIcon(Start.class.getResource("/resources/x-office-spreadsheet.png")));
		mnDados.setFont(new Font("SansSerif", Font.BOLD, 14));
		menuBar.add(mnDados);

		JMenu mnEt = new JMenu("ET0");
		mnEt.setIcon(new ImageIcon(Start.class.getResource("/resources/x-office-spreadsheet22.png")));
		mnEt.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mnDados.add(mnEt);

		JMenuItem mntmPenmanmonteit = new JMenuItem("Penman-Monteith");
		mntmPenmanmonteit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				progressBar.setVisible(true);
				progressBar.setIndeterminate(true);
				lblCarregando.setVisible(true);
				SwingWorker worker = new SwingWorker() {
					@Override
					protected Object doInBackground() throws Exception {
						mdi.manager(new CadETO());
						progressBar.setVisible(false);
						progressBar.setIndeterminate(false);
						lblCarregando.setVisible(false);
						return null;
					}
				};
				worker.execute();
			}
		});
		mntmPenmanmonteit.setIcon(new ImageIcon(Start.class.getResource("/resources/x-office-spreadsheet22.png")));
		mntmPenmanmonteit.setFont(new Font("SansSerif", Font.PLAIN, 14));
		mnEt.add(mntmPenmanmonteit);

		JMenu mnJanelas = new JMenu("Janelas");
		mnJanelas.setIcon(new ImageIcon(Start.class.getResource("/resources/preferences-system-windows.png")));
		mnJanelas.setFont(fonteMenu);
		menuBar.add(mnJanelas);

		JMenuItem mntmFecharTodas = new JMenuItem("Fechar todas");
		mntmFecharTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mdi.closeAll();
			}
		});
		mntmFecharTodas
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mntmFecharTodas.setIcon(new ImageIcon(Start.class.getResource("/resources/edit-clear.png")));
		mntmFecharTodas.setFont(fonteMenuItem);
		mnJanelas.add(mntmFecharTodas);

		JMenuItem mntmOrganizar = new JMenuItem("Organizar");
		mntmOrganizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mdi.reOrganize();
			}
		});
		mntmOrganizar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mntmOrganizar.setIcon(new ImageIcon(Start.class.getResource("/resources/view-fullscreen.png")));
		mntmOrganizar.setFont(fonteMenuItem);
		mnJanelas.add(mntmOrganizar);

		JMenu mnAjuda = new JMenu("Ajuda");
		mnAjuda.setIcon(new ImageIcon(Start.class.getResource("/resources/help-browser.png")));
		mnAjuda.setFont(fonteMenu);
		menuBar.add(mnAjuda);

		JMenuItem mntmSite = new JMenuItem("Ajuda na Internet");
		mntmSite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					java.awt.Desktop.getDesktop().browse(new URI("http://www.etzero.net.br"));
				} catch (IOException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		mntmSite.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mntmSite.setIcon(new ImageIcon(Start.class.getResource("/resources/text-x-generic-template.png")));
		mntmSite.setFont(fonteMenuItem);
		mnAjuda.add(mntmSite);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mdi.manager(new Sobre());
			}
		});
		mntmSobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0));
		mntmSobre.setIcon(new ImageIcon(Start.class.getResource("/resources/dialog-information.png")));
		mntmSobre.setFont(fonteMenuItem);
		mnAjuda.add(mntmSobre);

		lblCarregando = new JLabel("Carregando...");
		lblCarregando.setVisible(false);
		menuBar.add(lblCarregando);
		progressBar = new JProgressBar();
		menuBar.add(progressBar);
		progressBar.setVisible(false);

		frmETzero.getContentPane()
				.setLayout(new MigLayout("insets 0 0 0 0", "[grow]", "[grow][][35px:35px:35px,grow,shrink 0,fill]"));

		desktopPane = new DecoratedDesktopPane();
		desktopPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frmETzero.getContentPane().add(desktopPane, "cell 0 0 1 3,grow");
		// StatusBar statusBar = new StatusBar();
		// frmIrrifes.getContentPane().add(statusBar,
		// java.awt.BorderLayout.SOUTH);
		// frmIrrifes.getContentPane().add(new JPanel(),
		// java.awt.BorderLayout.SOUTH);
		mdi.configurar(desktopPane, 25, true);

	}
}
