import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import layout.TableLayout;


public class Janela extends JFrame implements ActionListener{

	JButton btImprimir;
	JButton btTestar;
	JButton btAplicar;
	JLabel lbl;
	ButtonGroup grupo;
	ButtonGroup grupo1;
	JTextField txtEntrada;
	JComboBox cmbPortas;
	JComboBox velocidadecb;
	JComboBox bitscb;
	JCheckBox controleck;
	JRadioButton par;
	JRadioButton impar;
	JRadioButton um;
	JRadioButton dois;
	
	String[] porta = {"COM1", "COM2", "COM3"};
	String[] velocidade = {"9600", "4800", "2400"};
	String[] databits = {"8", "6", "4"};
	
	public Janela(){
		createJanela();
	}
	
	private void createJanela(){
		setTitle("Configuração Porta Série");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setPreferredSize(new Dimension(500, 360));
	    
	    double size[][] = {{10, 80, 150, 220, 130, 20}, //COLUNAS
	        		{10, 25, 10, 25, 10, 25, 10, 30, 25, 10, 25, 10, 55, 0, 10, 35}}; //LINHAS
	    setLayout(new TableLayout(size));
	    
	    JLabel lbl = new JLabel("Porta:");
	    add(lbl, "1,1");
	    
	    cmbPortas = new JComboBox(porta);
	    cmbPortas.addActionListener(this);
	    cmbPortas.setActionCommand("PORTAS");
	    add(cmbPortas, "2,1");
	    
	    lbl = new JLabel ("Velocidade:");
	    add(lbl, "1,3");
	    
	    velocidadecb = new JComboBox(velocidade);
	    velocidadecb.addActionListener(this);
	    velocidadecb.setActionCommand("VELOCIDADE");
	    add(velocidadecb, "2,3");
	    
	    lbl = new JLabel ("Data bits:");
	    add(lbl, "1,5");
	    
	    bitscb = new JComboBox(databits);
	    bitscb.addActionListener(this);
	    bitscb.setActionCommand("Databits");
	    add(bitscb, "2,5");
	    
	    lbl = new JLabel("Paridade:");
        add(lbl, "1, 7");
        JRadioButton par = new JRadioButton("Par");
        par.setActionCommand("Par");
        par.setSelected(true);
        JRadioButton impar = new JRadioButton("Impar");
        impar.setActionCommand("Impar");
        
        grupo = new ButtonGroup();
        grupo.add(par);
        grupo.add(impar);
        
        JPanel radioPanel = new JPanel();
        radioPanel.add(par);
        radioPanel.add(impar);
        add(radioPanel,"2, 7, l");
        pack();
        setVisible(true);
        
	    lbl = new JLabel("Stop bits:");
        add(lbl, "1, 8");
        JRadioButton um = new JRadioButton("1");
        um.setActionCommand("1");
        um.setSelected(true);
        JRadioButton dois = new JRadioButton("2");
        dois.setActionCommand("2");
        
        grupo1 = new ButtonGroup();
        grupo1.add(um);
        grupo1.add(dois);
        
        JPanel radioPanel1 = new JPanel();
        radioPanel1.add(um);
        radioPanel1.add(dois);
        add(radioPanel1,"2, 8, l");
        
	    lbl = new JLabel("Controle:");
        add(lbl, "1, 10");
        controleck = new JCheckBox();
        
        add(controleck, "2, 10");
        
        txtEntrada = new JTextField();
        
        JPanel entrada = new JPanel(new GridLayout(0,1));
        
        Border loweredetched1 = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);  
        TitledBorder title1 = BorderFactory.createTitledBorder(loweredetched1, "Entrada");  
        title1.setTitleJustification(TitledBorder.LEFT);  
        entrada.setBorder(title1);  
        
        entrada.add(txtEntrada);
        add(entrada, "1,12, 3");
        
        JPanel pnl = new JPanel(new FlowLayout());
        JButton btTestar = new JButton("Testar");
        btTestar.setActionCommand("TESTAR");
        btTestar.addActionListener(this);
        pnl.add(btTestar);
        
        JButton btAplicar = new JButton("Aplicar");
        btAplicar.setActionCommand("Aplicar");
        btAplicar.addActionListener(this);
        pnl.add(btAplicar);
        
        JButton btImprimir = new JButton("Imprimir");
        btImprimir.setActionCommand("IMPRIMIR");
        btImprimir.addActionListener(this);
        pnl.add(btImprimir);
        add(pnl,"2,15,4");
	}

	@Override
	public void actionPerformed(ActionEvent o) {
		// TODO Auto-generated method stub
		String actionCommand = o.getActionCommand();
		  
		  if(actionCommand.matches("TESTAR")){
		   
		   System.out.println("Porta : " + cmbPortas.getSelectedItem());
		            System.out.println("Velocidade : " + velocidadecb.getSelectedItem());
		            System.out.println("Data Bits : " + bitscb.getSelectedItem());
		            System.out.println("Paridade : " + grupo.getSelection().getActionCommand());
		            System.out.println("Stop Bits : " + grupo1.getSelection().getActionCommand());
		            
		            if(controleck.isSelected()){
		                System.out.println("Controle: Sim");                
		            }else{
		                System.out.println("Controle: Não");
		            }
		            
		            System.out.println("Entrada : " + (String)txtEntrada.getText() + "\n");
		            
		  }else if(actionCommand.matches("Aplicar")){
		   JOptionPane.showMessageDialog(null, actionCommand);
		  }else if(actionCommand.matches("IMPRIMIR")){
		   
		   String porta = (String)cmbPortas.getSelectedItem();
		   String velocidade = (String)velocidadecb.getSelectedItem();
		   String dataBit = (String)bitscb.getSelectedItem();
		   String paridade = (String)grupo.getSelection().getActionCommand();
		   String stopBit = (String)grupo1.getSelection().getActionCommand();
		   String controle;
		   String entrada = (String)txtEntrada.getText();
		   
		   if(controleck.isSelected()){
		    controle = "Sim";
		   }else{
		    controle = "Não";
		      }
		                        
		   String dados[] = {"Porta : " + porta, "Velocidade : " + velocidade, 
		               "Data bits : " + dataBit, "Paridade : " + paridade, "Stop bits : " + stopBit,
		               "Controle : " + controle, "Entrada : " + entrada};
		            
		   Imprimir window = new Imprimir(dados);
	}
  }
}