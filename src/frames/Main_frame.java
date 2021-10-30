package frames;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;

public class Main_frame extends JFrame{

	/**
	 * 
	 */
	static Main_frame window = new Main_frame();
	private static final long serialVersionUID = 1L;
	JFrame frmGestionBibliothque;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					window.frmGestionBibliothque.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionBibliothque = new JFrame();
		frmGestionBibliothque.setIconImage(Toolkit.getDefaultToolkit().getImage(Main_frame.class.getResource("/frames/Bibliothèque.png")));
		frmGestionBibliothque.setBackground(Color.WHITE);
		frmGestionBibliothque.setTitle("Gestion Bibliothèque");
		frmGestionBibliothque.setLocationRelativeTo(null);
		frmGestionBibliothque.setResizable(false);
		frmGestionBibliothque.setBounds(100, 100, 849, 750);
		frmGestionBibliothque.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionBibliothque.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 150, 850, 568);
		frmGestionBibliothque.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton Géstion_abonnes = new JButton("Géstion Abonnés");
		Géstion_abonnes.setForeground(Color.BLACK);
		Géstion_abonnes.setBackground(new Color(0, 153, 255));
		
		Géstion_abonnes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmGestionBibliothque.dispose();
				Abonnes_frame.main(null);
				
				
			}
		});
		Géstion_abonnes.setFont(new Font("Dialog", Font.BOLD, 16));
		Géstion_abonnes.setIcon(new ImageIcon(Main_frame.class.getResource("/frames/Abonnés.png")));
		Géstion_abonnes.setBounds(88, 121, 280, 120);
		panel.add(Géstion_abonnes);
		
		JButton quitter = new JButton("Quitter");
		quitter.setFont(new Font("Dialog", Font.BOLD, 16));
		quitter.setBackground(new Color(0, 153, 255));
		quitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		quitter.setIcon(new ImageIcon(Main_frame.class.getResource("/frames/Close.png")));
		quitter.setBounds(247, 331, 349, 90);
		panel.add(quitter);
		
		JButton Géstion_livres = new JButton("Géstion Livres");
		Géstion_livres.setBackground(new Color(0, 153, 255));
		Géstion_livres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmGestionBibliothque.dispose();
				Livres_frame.main(null);
				
			}
		});
		Géstion_livres.setFont(new Font("Dialog", Font.BOLD, 16));
		Géstion_livres.setIcon(new ImageIcon(Main_frame.class.getResource("/frames/Livres.png")));
		Géstion_livres.setBounds(463, 121, 280, 120);
		panel.add(Géstion_livres);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, -13, 850, 165);
		frmGestionBibliothque.getContentPane().add(panel_1);
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(12, 0, 161, 173);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Main_frame.class.getResource("/frames/Bibliotèque_Format_Grand1.png")));
		
	
		
		JLabel lblGestionBibliothque = new JLabel("Gestion Bibliothèque");
		lblGestionBibliothque.setFont(new Font("Dialog", Font.BOLD, 48));
		lblGestionBibliothque.setBounds(185, 32, 622, 103);
		panel_1.add(lblGestionBibliothque);
	}
}
