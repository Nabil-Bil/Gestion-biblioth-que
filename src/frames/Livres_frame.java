package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Bibliothèque.Livres;
import SGBD.Trait_Livres;
//import net.proteanit.sql.DbUtils;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;



public class Livres_frame extends JFrame {

	/**
	 * 
	 */
	static Livres_frame frame=new Livres_frame();;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JTextField textFieldCode;
	private JTextField textFieldTitre;
	private JTextField textFieldAuteur;
	private JTextField textFieldType;
	private JTable table=new JTable();;
	JButton btnModifier = new JButton("Modifier");
	JButton btnSupprimer = new JButton("Supprimer");
	JButton btnAjouter = new JButton("Ajouter");
	JButton btnRetour = new JButton("Retour");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				
				try {

					 
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
	public static void infoBox(String infoMessage)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "ERREUR!", JOptionPane.INFORMATION_MESSAGE);
    }
	
	public static void printTable(JTable table,ResultSet resultSet)
	{
		
		table.setModel(DbUtils.resultSetToTableModel(resultSet));
		table.getColumnModel().getColumn(0).setHeaderValue("Code Livre");
		table.getColumnModel().getColumn(1).setHeaderValue("Titre");
		table.getColumnModel().getColumn(2).setHeaderValue("Auteur");
		table.getColumnModel().getColumn(3).setHeaderValue("Type");
		
		//table.setValueAt(Abonnes_frame.changeFormat((java.sql.Date)(table.getValueAt(0, 3))),0,3 );
	}
	public Livres_frame() {
			
		
		
		
		
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String code_livre,titre,auteur,type;
				Livres livre=null;
				code_livre=textFieldCode.getText().replaceAll(" ", "");
				titre=textFieldTitre.getText().trim();
				auteur=textFieldAuteur.getText().trim();
				type=textFieldType.getText().trim();
				
				Livres l2=Trait_Livres.Recherche(code_livre);
				

				if(code_livre.equals("")== true)
				{
					Livres_frame.infoBox("Veuillez saisir un Code de Livre");
				}
				else
				{
					if(code_livre.equals(l2.getCode_livre()) && code_livre.equals((String)table.getValueAt(table.getSelectedRow(), 0))==false)
					{
						Livres_frame.infoBox("Attention! Ce code de livre existe déja Veuillez saisir un autre ");
						
					}
					else
					{
						
					
					
					if(titre.equals(""))
						Livres_frame.infoBox("Veuillez saisir Titre de Livre");
				
					else
					{
						if(auteur.equals(""))
							Livres_frame.infoBox("Veuillez saisir un Nom d'Auteur");
							else
							{
								if(type.equals(""))
									Livres_frame.infoBox("Veuillez saisir un Type de Livre");
								else
								{
									livre=new Livres(code_livre,titre,auteur,type);
									
									Trait_Livres.update(livre, (String)table.getValueAt(table.getSelectedRow(), 0));
									Livres_frame.printTable(table,Trait_Livres.affichage());
									
									btnSupprimer.setEnabled(false);
									btnModifier.setEnabled(false);
									textFieldCode.setText("");
									textFieldTitre.setText("");
									textFieldAuteur.setText("");
									textFieldType.setText("");
									
									
								}
								
							}
						}
					}
				
			}
				
				
				
				
				
			
				
				btnSupprimer.setEnabled(false);
				btnModifier.setEnabled(false);
			}
		});
		btnModifier.setFont(new Font("Dialog", Font.BOLD, 16));
		btnModifier.setIcon(new ImageIcon(Livres_frame.class.getResource("/frames/Modifier.png")));
		btnModifier.setForeground(new Color(0, 0, 0));
		btnModifier.setBackground(new Color(0, 153, 255));
		
		btnAjouter.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAjouter.setIcon(new ImageIcon(Livres_frame.class.getResource("/frames/plus-ConvertImage.png")));
		btnAjouter.setForeground(new Color(0, 0, 0));
		btnAjouter.setBackground(new Color(0, 153, 255));
		
		btnSupprimer.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSupprimer.setForeground(new Color(0, 0, 0));
		btnSupprimer.setIcon(new ImageIcon(Livres_frame.class.getResource("/frames/Supprimer.png")));
		btnSupprimer.setBackground(new Color(0, 153, 255));
		
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Livres_frame.class.getResource("/frames/Livres.png")));
		setTitle("Gestion Des Livres");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 359, 850, 359);
		contentPane.add(scrollPane);
		
		
		
		
		
		
		table=new JTable();
		
		Livres_frame.printTable(table,Trait_Livres.affichage());
		table.setRowHeight(35);
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(SystemColor.window);
		table.setFont(new Font("Dialog", Font.PLAIN, 16));
		table.setDefaultEditor(Object.class, null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, -36, 850, 402);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textFieldCode = new JTextField();
		textFieldCode.addMouseListener(new MouseAdapter() {
			
		
			}
		);
		textFieldCode.setBounds(193, 142, 284, 29);
		panel.add(textFieldCode);
		textFieldCode.setColumns(10);
		
		JLabel lblCodeLivre = new JLabel("Code Livre");
		lblCodeLivre.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCodeLivre.setBounds(69, 141, 120, 29);
		panel.add(lblCodeLivre);
		
		JLabel lblTitre = new JLabel("Titre");
		lblTitre.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTitre.setBounds(69, 200, 107, 29);
		panel.add(lblTitre);
		
		JLabel lblAuteur = new JLabel("Auteur");
		lblAuteur.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAuteur.setBounds(69, 253, 107, 29);
		panel.add(lblAuteur);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Dialog", Font.BOLD, 16));
		lblType.setBounds(69, 316, 87, 29);
		panel.add(lblType);
		
		textFieldTitre = new JTextField();
		textFieldTitre.setBounds(193, 201, 284, 29);
		panel.add(textFieldTitre);
		textFieldTitre.setColumns(10);
		
		textFieldAuteur = new JTextField();
		textFieldAuteur.setBounds(193, 254, 284, 29);
		panel.add(textFieldAuteur);
		textFieldAuteur.setColumns(10);
		
		textFieldType = new JTextField();
		textFieldType.setBounds(190, 317, 287, 29);
		panel.add(textFieldType);
		textFieldType.setColumns(10);
		
		
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code_livre,titre,auteur,type;
				Livres livre=null;
				code_livre=textFieldCode.getText().replaceAll(" ", "");
				titre=textFieldTitre.getText().trim();
				auteur=textFieldAuteur.getText().trim();
				type=textFieldType.getText().trim();
				
				Livres l2=Trait_Livres.Recherche(code_livre);
				
				
				
			
				

					if(code_livre.equals("")== true)
					{
						Livres_frame.infoBox("Veuillez saisir un Code de Livre");
					}
					else
					{
						if(code_livre.equals(l2.getCode_livre()))
						{
							Livres_frame.infoBox("Attention! Ce code de livre existe déja Veuillez saisir un autre ");
							
						}
						else
						{
							
						
						
						if(titre.equals(""))
							Livres_frame.infoBox("Veuillez saisir Titre de Livre");
					
						else
						{
							if(auteur.equals(""))
								Livres_frame.infoBox("Veuillez saisir un Nom d'Auteur");
								else
								{
									if(type.equals(""))
										Livres_frame.infoBox("Veuillez saisir un Type de Livre");
									else
									{
										livre=new Livres(code_livre,titre,auteur,type);
										
										Trait_Livres.add(livre);
										Livres_frame.printTable(table,Trait_Livres.affichage());
										btnSupprimer.setEnabled(false);
										btnModifier.setEnabled(false);
										textFieldCode.setText("");
										textFieldTitre.setText("");
										textFieldAuteur.setText("");
										textFieldType.setText("");
										
										
									}
									
								}
							}
						}
					
				}
					
				
				
				
				
				
				
				
				
			}
		});
		btnAjouter.setBounds(559, 71, 175, 50);
		panel.add(btnAjouter);
		
		
		btnModifier.setEnabled(false);
		btnModifier.setBounds(559, 141, 175, 50);
		panel.add(btnModifier);
		
		
		btnSupprimer.setEnabled(false);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String code_livre;
			
					code_livre=(String)table.getValueAt(table.getSelectedRow(),0);
					
					
					Trait_Livres.delete(code_livre);
					Livres_frame.printTable(table,Trait_Livres.affichage());
					
					textFieldCode.setText("");
					textFieldTitre.setText("");
					textFieldAuteur.setText("");
					textFieldType.setText("");
					
				
				btnSupprimer.setEnabled(false);
				btnModifier.setEnabled(false);
				
				
				
				
				
			}
		});
		
		btnSupprimer.setBounds(559, 205, 175, 50);
		panel.add(btnSupprimer);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.setFont(new Font("Dialog", Font.BOLD, 16));
		btnRechercher.setForeground(new Color(0, 0, 0));
		btnRechercher.setIcon(new ImageIcon(Livres_frame.class.getResource("/frames/Recherche.png")));
		btnRechercher.setBackground(new Color(0, 153, 255));
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Livres l=new Livres();
				
				String code_livre=JOptionPane.showInputDialog(null, "Entrez un Code livre : ", null);
				
				try {
					if(code_livre.equals(""))
					Livres_frame.infoBox("Veuillez saisir un code de Livre");
				
				else
				{
					l=Trait_Livres.Recherche(code_livre);
					if(code_livre.equals(l.getCode_livre()))
					{
						Livres_frame.printTable(table,Trait_Livres.Recherche_result(code_livre));
					textFieldCode.setText("");
					textFieldTitre.setText("");
					textFieldAuteur.setText("");
					textFieldType.setText("");
					}
						
					else
				
						Livres_frame.infoBox("Le code de Livre n'existe pas");
					
			
				
				}
				}
				catch(java.lang.NullPointerException a)
				{}
				
				btnSupprimer.setEnabled(false);
				btnModifier.setEnabled(false);
					
				
					
				
				
		
				
				
			}
		});
		btnRechercher.setBounds(559, 268, 175, 50);
		panel.add(btnRechercher);
		
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.setForeground(Color.BLACK);
		btnActualiser.setFont(new Font("Dialog", Font.BOLD, 16));
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Livres_frame.printTable(table,Trait_Livres.affichage());
				
				btnSupprimer.setEnabled(false);
				btnModifier.setEnabled(false);
				textFieldCode.setText("");
				textFieldTitre.setText("");
				textFieldAuteur.setText("");
				textFieldType.setText("");
				
			}
		});
		btnActualiser.setIcon(new ImageIcon(Livres_frame.class.getResource("/frames/recharger.png")));
		btnActualiser.setBackground(new Color(0, 153, 255));
		btnActualiser.setBounds(664, 330, 160, 50);
		panel.add(btnActualiser);
		
		
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldCode.setText("");
				textFieldTitre.setText("");
				textFieldAuteur.setText("");
				textFieldType.setText("");
				
				
				frame.dispose();
				Main_frame.main(null);
				
				
				
			}
		});
		btnRetour.setFont(new Font("Dialog", Font.BOLD, 16));
		btnRetour.setIcon(new ImageIcon(Livres_frame.class.getResource("/frames/Retour.png")));
		btnRetour.setBackground(new Color(0, 153, 255));
		btnRetour.setForeground(Color.BLACK);
		btnRetour.setBounds(33, 52, 131, 42);
		panel.add(btnRetour);
		
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String code_livre,titre,auteur,type;
				
				code_livre=(String)table.getValueAt(table.getSelectedRow(), 0);
				titre=(String)table.getValueAt(table.getSelectedRow(), 1);
				auteur=(String)table.getValueAt(table.getSelectedRow(), 2);
				type=(String)table.getValueAt(table.getSelectedRow(), 3);
				
				textFieldCode.setText(code_livre);
				textFieldTitre.setText(titre);
				textFieldAuteur.setText(auteur);
				textFieldType.setText(type);
				
				
				
				
				
				
				
				btnSupprimer.setEnabled(true);
				btnModifier.setEnabled(true);
				
				
				
				
				
			}
		});
		
		
	}
}


