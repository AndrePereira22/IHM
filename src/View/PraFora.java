package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PraFora extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JButton btnOk;
	
	
	public PraFora(javax.swing.JFrame janela, boolean vf) {

		super(janela, vf);

		setBounds(0, 100, 215, 200);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		contentPanel.setBounds(0, 0, 341, 224);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(getClass().getResource("/bolafora.png")));
		fundo.setBounds(0, 0, 240, 167);
		

		btnOk = new JButton();
		btnOk.setBounds(60, 100, 65, 58);
		btnOk.setIcon(new ImageIcon(getClass().getResource("/ok.png")));
		btnOk.setContentAreaFilled(false);
		btnOk.setBorder(null);
		contentPanel.add(btnOk);
		contentPanel.add(fundo);
		
		setLocationRelativeTo(janela);

		setVisible(false);
		
	}


	public JButton getBtnOk() {
		return btnOk;
	}
	
	
}
