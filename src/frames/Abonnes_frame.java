package frames;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SGBD.Trait_Abonnes;
import net.proteanit.sql.DbUtils;

import java.awt.Toolkit;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import Bibliothèque.Abonnes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Abonnes_frame extends JFrame {

	/**
	 * 
	 */
	private static Abonnes_frame frame=new Abonnes_frame();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtMatricule;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtNumerotelephone;
	private JTextField txtSpecialite;

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
	 * @throws ParseException 
	 */
	public static java.sql.Date changeFormat(String oldDate) 
	{
		
		String newDate="";
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d=null;
		try {
			d = sdf.parse(oldDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sdf.applyPattern("dd/MM/yyyy");
		newDate=sdf.format(d);
		
		java.sql.Date sqlDate=java.sql.Date.valueOf(newDate);
		
		
		
		return sqlDate;
	}
	public static void printTable(JTable table,ResultSet resultSet)
	{
		
		table.setModel(DbUtils.resultSetToTableModel(resultSet));
		table.getColumnModel().getColumn(0).setHeaderValue("Matricule");
		table.getColumnModel().getColumn(1).setHeaderValue("Nom");
		table.getColumnModel().getColumn(2).setHeaderValue("Prenom");
		table.getColumnModel().getColumn(3).setHeaderValue("Date Naissance");
		table.getColumnModel().getColumn(4).setHeaderValue("Date enregistrement");
		table.getColumnModel().getColumn(5).setHeaderValue("N°Télephone");
		table.getColumnModel().getColumn(6).setHeaderValue("Date Naissance");
		for(int i=0;i<table.getRowCount();i++)
		{
			table.setValueAt(Trait_Abonnes.convertSqlToString((Date)table.getValueAt(i, 3)), i, 3);
			table.setValueAt(Trait_Abonnes.convertSqlToString((Date)table.getValueAt(i, 4)), i, 4);
			
			
		}
		
		
		//table.setValueAt(Abonnes_frame.changeFormat((java.sql.Date)(table.getValueAt(0, 3))),0,3 );
	}
	public static void infoBox(String infoMessage)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "ERREUR!", JOptionPane.INFORMATION_MESSAGE);
    }
	
	
	public Abonnes_frame() {
		JButton btnModifier = new JButton("Modifier");
		
		JButton btnSupprimer = new JButton("Supprimer");
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Abonnes_frame.class.getResource("/frames/Abonnés.png")));
		setTitle("Gestion Des Abonnés");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, -30, 850, 509);
		panel.setBackground(Color.GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtMatricule = new JTextField();
		txtMatricule.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtMatricule.setBounds(260, 90, 230, 30);
		panel.add(txtMatricule);
		txtMatricule.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtNom.setBounds(260, 150, 230, 30);
		panel.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtPrenom.setBounds(260, 210, 230, 30);
		panel.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		txtNumerotelephone = new JTextField();
		txtNumerotelephone.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtNumerotelephone.setBounds(260, 390, 230, 30);
		panel.add(txtNumerotelephone);
		txtNumerotelephone.setColumns(10);
		
		txtSpecialite = new JTextField();
		txtSpecialite.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtSpecialite.setBounds(260, 450, 230, 30);
		panel.add(txtSpecialite);
		txtSpecialite.setColumns(10);
		
		JLabel lblMatricule = new JLabel("Matricule");
		lblMatricule.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMatricule.setBounds(42, 90, 97, 30);
		panel.add(lblMatricule);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNom.setBounds(42, 150, 97, 30);
		panel.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prénom");
		lblPrenom.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPrenom.setBounds(42, 210, 97, 30);
		panel.add(lblPrenom);
		
		JLabel lblDate_naissance = new JLabel("Date De  Naissance");
		lblDate_naissance.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDate_naissance.setBounds(42, 270, 237, 15);
		panel.add(lblDate_naissance);
		
		JLabel lblDate_enregistrement = new JLabel("Date D'enregistrement");
		lblDate_enregistrement.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDate_enregistrement.setBounds(42, 330, 237, 30);
		panel.add(lblDate_enregistrement);
		
		JLabel lblTelephone = new JLabel("N°Téléphone");
		lblTelephone.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTelephone.setBounds(42, 390, 237, 30);
		panel.add(lblTelephone);
		
		JLabel lblSpecialite = new JLabel("Spécialité");
		lblSpecialite.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSpecialite.setBounds(42, 457, 237, 15);
		panel.add(lblSpecialite);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Main_frame.main(null);
			}
		});
		
		JDateChooser Date_Naissance = new JDateChooser();
		Date_Naissance.getCalendarButton().setBackground(new Color(0, 153, 255));
		JTextFieldDateEditor editor_naissance = (JTextFieldDateEditor) Date_Naissance.getDateEditor();
		Date_Naissance.setBounds(260, 266, 230, 30);
		Date_Naissance.setFont(new Font("Dialog", Font.BOLD, 16));
		panel.add(Date_Naissance);
		
		JDateChooser Date_enregistrement = new JDateChooser();
		Date_enregistrement.getCalendarButton().setBackground(new Color(0, 153, 255));
		Date_enregistrement.getCalendarButton().setForeground(Color.BLACK);
		JTextFieldDateEditor editor_enregistrement = (JTextFieldDateEditor) Date_enregistrement.getDateEditor();
		Date_enregistrement.setBounds(260, 330, 230, 30);
		Date_enregistrement.setFont(new Font("Dialog", Font.BOLD, 16));
		
		
		
		panel.add(Date_enregistrement);
		btnRetour.setIcon(new ImageIcon(Abonnes_frame.class.getResource("/frames/Retour.png")));
		btnRetour.setForeground(Color.BLACK);
		btnRetour.setFont(new Font("Dialog", Font.BOLD, 16));
		btnRetour.setBackground(new Color(0, 153, 255));
		btnRetour.setBounds(22, 36, 131, 42);
		panel.add(btnRetour);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String matricule,nom,prenom,telephone,specialite;
				java.util.Date naissance,enregistrement;
				Abonnes abonne=null;
				Abonnes abonnes2=null;
				
				
				
				
				matricule=txtMatricule.getText().replaceAll(" ", "");
				nom=txtNom.getText().trim();
				prenom=txtPrenom.getText().trim();
				naissance=Date_Naissance.getDate();
				enregistrement=Date_enregistrement.getDate();
				
				telephone=txtNumerotelephone.getText().replaceAll(" ", "");
				specialite=txtSpecialite.getText().trim();
				
				abonnes2=Trait_Abonnes.Recherche(matricule);
				
				
				
			
				

					if(matricule.equals("")== true)
					
						Abonnes_frame.infoBox("Veuillez saisir un Matricule");
					
					
						
					
					else
					{
						if(matricule.equals(abonnes2.getMatricule()))
						
							Abonnes_frame.infoBox("Attention! Ce Matricule existe déja Veuillez saisir un autre ");
						
							else
							{
								if(nom.equals(""))
								
									Abonnes_frame.infoBox("Veuillez saisir un nom");
	
									else
									{
										if(prenom.equals(""))
										
											Abonnes_frame.infoBox("Veuillez saisir un prénom");
										else
										{

											if(naissance==null)
												Abonnes_frame.infoBox("Veuillez saisir une Date de Naissance");
											else
											{
												if(enregistrement==null)
													Abonnes_frame.infoBox("Veuillez saisir une Date d'enregistrement");
												else
												{
													if(naissance.after(enregistrement))
														Abonnes_frame.infoBox("Attention! La Date de naissance est Superieure à la date d'enregistrement");
													else
													{
														if(telephone.equals(""))
															Abonnes_frame.infoBox("Veuillez saisir un Numero de Téléphone");
														else
														{
															if(specialite.equals(""))
																Abonnes_frame.infoBox("Veuillez saisir une Spécialité");
															else
															{

																abonne=new Abonnes(matricule,nom,prenom,naissance,enregistrement,telephone,specialite);
																Trait_Abonnes.add(abonne);
																Abonnes_frame.printTable(table,Trait_Abonnes.affichage());
																txtMatricule.setText("");
																txtNom.setText("");
																txtPrenom.setText("");
																Date_Naissance.setDate(null);
																Date_enregistrement.setDate(null);
																txtNumerotelephone.setText("");
																txtSpecialite.setText("");
																
															}
																
														}
													}
													
													
														
												}
											}
												
											
										}
													
												
						
								
									}
								
							}
							
						}
	
						
					btnSupprimer.setEnabled(false);
					btnModifier.setEnabled(false);
				}
			

		});
		
		
		
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				

				String matricule,nom,prenom,telephone,specialite;
				java.util.Date naissance,enregistrement;
				Abonnes abonne=null;
				Abonnes abonnes2=null;
				
				
				
				
				matricule=txtMatricule.getText().replaceAll(" ", "");
				nom=txtNom.getText().trim();
				prenom=txtPrenom.getText().trim();
				naissance=Date_Naissance.getDate();
				enregistrement=Date_enregistrement.getDate();
				
				telephone=txtNumerotelephone.getText().replaceAll(" ", "");
				specialite=txtSpecialite.getText().trim();
				
				abonnes2=Trait_Abonnes.Recherche(matricule);
				
				
				
			
				

					if(matricule.equals("")== true)
					
						Abonnes_frame.infoBox("Veuillez saisir un Matricule");
					
					
						
					
					else
					{
						if(matricule.equals(abonnes2.getMatricule()) && matricule.equals((String)table.getValueAt(table.getSelectedRow(), 0))==false)
						
							Abonnes_frame.infoBox("Attention! Ce Matricule existe déja Veuillez saisir un autre ");
						
							else
							{
								if(nom.equals(""))
								
									Abonnes_frame.infoBox("Veuillez saisir un nom");
	
									else
									{
										if(prenom.equals(""))
										
											Abonnes_frame.infoBox("Veuillez saisir un prénom");
										else
										{

											if(naissance==null)
												Abonnes_frame.infoBox("Veuillez saisir une Date de Naissance");
											else
											{
												if(enregistrement==null)
													Abonnes_frame.infoBox("Veuillez saisir une Date d'enregistrement");
												else
												{
													if(naissance.after(enregistrement))
														Abonnes_frame.infoBox("Attention! La Date de naissance est Superieure à la date d'enregistrement");
													else
													{
														if(telephone.equals(""))
															Abonnes_frame.infoBox("Veuillez saisir un Numero de Téléphone");
														else
														{
															if(specialite.equals(""))
																Abonnes_frame.infoBox("Veuillez saisir une Spécialité");
															else
															{

																abonne=new Abonnes(matricule,nom,prenom,naissance,enregistrement,telephone,specialite);
																Trait_Abonnes.update(abonne,(String)table.getValueAt(table.getSelectedRow(), 0));
																Abonnes_frame.printTable(table,Trait_Abonnes.affichage());
																txtMatricule.setText("");
																txtNom.setText("");
																txtPrenom.setText("");
																Date_Naissance.setDate(null);
																Date_enregistrement.setDate(null);
																txtNumerotelephone.setText("");
																txtSpecialite.setText("");
																
															}
																
														}
													}
													
													
														
												}
											}
												
											
										}
													
												
						
								
									}
								
							}
							
						}
					
				
						
						
						
					
				
						
						
						
						
					
					
					
						
					
							
						
					btnSupprimer.setEnabled(false);
					btnModifier.setEnabled(false);
				
			}
		});
		btnAjouter.setIcon(new ImageIcon(Abonnes_frame.class.getResource("/frames/Ajouter.png")));
		btnAjouter.setForeground(Color.BLACK);
		btnAjouter.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAjouter.setBackground(new Color(0, 153, 255));
		btnAjouter.setBounds(573, 90, 175, 50);
		panel.add(btnAjouter);
		
		
		btnModifier.setIcon(new ImageIcon(Abonnes_frame.class.getResource("/frames/Modifier.png")));
		btnModifier.setForeground(Color.BLACK);
		btnModifier.setFont(new Font("Dialog", Font.BOLD, 16));
		btnModifier.setEnabled(false);
		btnModifier.setBackground(new Color(0, 153, 255));
		btnModifier.setBounds(573, 178, 175, 50);
		panel.add(btnModifier);
		
		
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String matricule;
			
					matricule=(String)table.getValueAt(table.getSelectedRow(),0);
					
					
					Trait_Abonnes.delete(matricule);
					Abonnes_frame.printTable(table,Trait_Abonnes.affichage());
					
					txtMatricule.setText("");
					txtNom.setText("");
					txtPrenom.setText("");
					Date_Naissance.setDate(null);
					Date_enregistrement.setDate(null);
					txtNumerotelephone.setText("");
					txtSpecialite.setText("");
					
					
				
					btnSupprimer.setEnabled(false);
					btnModifier.setEnabled(false);
				
				
			}
		});
		btnSupprimer.setIcon(new ImageIcon(Abonnes_frame.class.getResource("/frames/Supprimer.png")));
		btnSupprimer.setForeground(Color.BLACK);
		btnSupprimer.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSupprimer.setEnabled(false);
		btnSupprimer.setBackground(new Color(0, 153, 255));
		btnSupprimer.setBounds(573, 259, 175, 50);
		panel.add(btnSupprimer);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Abonnes abonnes=new Abonnes();
				String matricule=JOptionPane.showInputDialog(null, "Entrez un Matricule : ", null);
				
				try {
					
					if(matricule.equals(""))
					Abonnes_frame.infoBox("Veuillez saisir un Matricule");
				
				else
				{
					abonnes=Trait_Abonnes.Recherche(matricule);
					if(matricule.equals(abonnes.getMatricule()))
					{
						
						Abonnes_frame.printTable(table,Trait_Abonnes.RechercheSet(matricule));
						txtMatricule.setText("");
						txtNom.setText("");
						txtPrenom.setText("");
						Date_Naissance.setDate(null);
						Date_enregistrement.setDate(null);
						txtNumerotelephone.setText("");
						txtSpecialite.setText("");
					}
						
					
						
					else
					
					Abonnes_frame.infoBox("Ce matricule n'existe pas.");
						
				
				}
				}
				catch(java.lang.NullPointerException a)
				{}
				
				btnSupprimer.setEnabled(false);
				btnModifier.setEnabled(false);
			}
		});
		btnRechercher.setIcon(new ImageIcon(Abonnes_frame.class.getResource("/frames/Recherche.png")));
		btnRechercher.setForeground(Color.BLACK);
		btnRechercher.setFont(new Font("Dialog", Font.BOLD, 16));
		btnRechercher.setBackground(new Color(0, 153, 255));
		btnRechercher.setBounds(573, 347, 175, 50);
		panel.add(btnRechercher);
		
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Abonnes_frame.printTable(table,Trait_Abonnes.affichage());
				txtMatricule.setText("");
				txtNom.setText("");
				txtPrenom.setText("");
				Date_Naissance.setDate(null);
				Date_enregistrement.setDate(null);
				txtNumerotelephone.setText("");
				txtSpecialite.setText("");
				
				btnSupprimer.setEnabled(false);
				btnModifier.setEnabled(false);
			}
		});
		btnActualiser.setIcon(new ImageIcon(Abonnes_frame.class.getResource("/frames/recharger.png")));
		btnActualiser.setForeground(Color.BLACK);
		btnActualiser.setFont(new Font("Dialog", Font.BOLD, 16));
		btnActualiser.setBackground(new Color(0, 153, 255));
		btnActualiser.setBounds(678, 439, 160, 50);
		panel.add(btnActualiser);
		editor_naissance.setEditable(false);
		editor_enregistrement.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 480, 850, 238);
		contentPane.add(scrollPane);
		
		
		table=new JTable();
		Abonnes_frame.printTable(table,Trait_Abonnes.affichage());
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String matricule,nom,prenom,telephone,specialite;
				java.util.Date date_naissance=null,date_enregistrement=null;
				
				matricule=(String)table.getValueAt(table.getSelectedRow(), 0);
				nom=(String)table.getValueAt(table.getSelectedRow(), 1);
				prenom=(String)table.getValueAt(table.getSelectedRow(), 2);
				try {
					date_naissance=new SimpleDateFormat("dd/MM/yyyy").parse((String)table.getValueAt(table.getSelectedRow(), 3));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					date_enregistrement=new SimpleDateFormat("dd/MM/yyyy").parse((String)table.getValueAt(table.getSelectedRow(), 4));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				telephone=(String)table.getValueAt(table.getSelectedRow(), 5);
				specialite=(String)table.getValueAt(table.getSelectedRow(),6);
				
				
				
				 
				
				txtMatricule.setText(matricule);
				txtNom.setText(nom);
				txtPrenom.setText(prenom);
				Date_Naissance.setDate(date_naissance);
				Date_enregistrement.setDate(date_enregistrement);
				txtNumerotelephone.setText(telephone);
				txtSpecialite.setText(specialite);
				
				
				//date_naissance=(String)table.getValueAt(table.getSelectedRow(), 3);
				
				
				
				
				btnSupprimer.setEnabled(true);
				btnModifier.setEnabled(true);
			}
		});
		
		
		
		table.setRowHeight(35);
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(SystemColor.window);
		table.setFont(new Font("Dialog", Font.PLAIN, 16));
		table.setDefaultEditor(Object.class, null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		
		
	}
}
