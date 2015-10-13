import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.*;

import javax.sound.sampled.AudioInputStream;
import javax.swing.*;


public class GUI {

	private JFrame ventana,agregar,sacar;
	private JPanel cabecera, cuerpo, cuerpo1,cuerpo2,cuerpo3, pie;
	private JPanel estacionamiento,espera,aux;
	private JLabel titulo1,esta,espe,au,dinero,cantidad;
	private JLabel pat,pat1,mod,DD;
	private JButton bot,bot1;
	private TextField patente,patente1, modelo;
	private TextField din,cant;
	private JButton boton1,boton2,boton3;
	private ImageIcon Titulo;
	private ImageIcon desv;
	private Garage gara;
	private JPanel[][] estacionamientoImgs = new JPanel[1][15];

	public GUI(){
		gara=new Garage();
		ventana=new JFrame("Estacionamiento");
		ventana.setBounds(250, 50, 1000, 700);
		ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
		ventana.getContentPane().setBackground(new Color(0, 162, 232));

		ventana.setLayout(null);

		cabecera=new JPanel();
		cabecera.setLayout(new FlowLayout());
		cabecera.setBackground(new Color(0,162,232));
		Titulo=new ImageIcon(getClass().getResource("Imagenes/titulo.png"));
		titulo1=new JLabel();
		titulo1.setIcon(Titulo);
		cabecera.add(titulo1);
		cabecera.setBounds(0,0,1000,200);


		cuerpo=new JPanel();
		cuerpo.setLayout(null);
		cuerpo.setBackground(new Color(0,162,232));
		cuerpo.setBounds(0,200,985,365);

		/*cuerpo1=new JPanel();
		cuerpo1.setLayout(new GridLayout(2,1));
		cuerpo1.setBackground(new Color(0,162,232));*/

		esta=new JLabel("Estacionamiento",SwingConstants.CENTER);
		esta.setBounds(440, 0, 100, 50);
		estacionamiento=new JPanel();
		estacionamiento.setLayout(new GridLayout(1,15));
		estacionamiento.setBorder(BorderFactory.createMatteBorder(
                4, 4, 4, 4, Color.green));;
		estacionamiento.setBackground(new Color(0,162,232));

		estacionamiento.setBounds(0, 50, 985, 70);
		/*cuerpo.add(esta);
		cuerpo.add(estacionamiento);*/



		for(int n = 0; n < 15; n++) {
			estacionamientoImgs[0][n] = new JPanel();
			estacionamiento.add(estacionamientoImgs[0][n]);
		}

		for(int i=0; i<15;i++) {
			/*ImagePanel autito = new ImagePanel();
			Image im;
			try {
				im = ImageIO.read(new File("C:\\Users\\BB185046\\Desktop\\cochesitos\\1.png"));
			} catch (IOException iox) {
				System.out.println("Error de IO: " + iox.getMessage());
				im = null;
			}
			autito.setBackground(im);
			estacionamiento.add(autito);*/
			ImageIcon autito=new ImageIcon(getClass().getResource("Imagenes/cochesitos/1.png"));
			JLabel autitoLbl=new JLabel();
			autitoLbl.setIcon(autito);
			//estacionamiento.add(autitoLbl);
			this.addEstAutos(i,autitoLbl);
		}

		cuerpo.add(esta);
		cuerpo.add(estacionamiento);
		//cuerpo1.add(esta);
		//cuerpo1.add(estacionamiento);

		/*cuerpo2=new JPanel();
		cuerpo2.setLayout(new GridLayout(2,1));
		cuerpo2.setBackground(new Color(0,162,232));*/

		espe=new JLabel("Espera",SwingConstants.CENTER);
		espe.setBounds(440, 120, 100, 50);

		espera=new JPanel();
		espera.setLayout(new GridLayout(1,5));
		espera.setBorder(BorderFactory.createMatteBorder(
                4, 4, 4, 4, Color.yellow));
		espera.setBackground(new Color(0,162,232));

		espera.setBounds(310, 170, 350, 70);

		cuerpo.add(espe);
		cuerpo.add(espera);

		//cuerpo2.add(espe);
		//cuerpo2.add(espera);


		/*cuerpo3=new JPanel();
		cuerpo3.setLayout(new GridLayout(2,1));
		cuerpo3.setBackground(new Color(0,162,232));*/

		au=new JLabel("Auxiliar",SwingConstants.CENTER);
		au.setBounds(440, 240, 100, 50);

		aux=new JPanel();
		aux.setLayout(new GridLayout(1,15));
		aux.setBorder(BorderFactory.createMatteBorder(
                4, 4, 4, 4, Color.red));
		aux.setBackground(new Color(0,162,232));

		aux.setBounds(0, 290, 985, 70);

		cuerpo.add(au);
		cuerpo.add(aux);
		//cuerpo3.add(au);
		//cuerpo3.add(aux);

		//cuerpo.add(cuerpo1);
		//cuerpo.add(cuerpo2);
		//cuerpo.add(cuerpo3);

		pie=new JPanel();
		pie.setLayout(null);
		pie.setBackground(new Color(0,162,232));
		pie.setBounds(0,565,985,134);

		boton1=new JButton("Agregar Auto");
		boton1.setBounds(300, 15, 110, 30);
		boton1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				agregar=new JFrame("Agregar");
				agregar.setBounds(500, 300, 500, 200);
				agregar.getContentPane().setBackground(new Color(0,162,232));

				agregar.setLayout(null);

				desv=new ImageIcon(getClass().getResource("Imagenes/DD.png"));
				DD=new JLabel();
				DD.setIcon(desv);
				DD.setBounds(0,-15, 100, 100);

				mod= new JLabel ("Modelo:",SwingConstants.CENTER);
				mod.setBounds(65,15,100,50);

				modelo=new TextField(10);
				modelo.setBounds(165, 25, 200, 30);

				pat= new JLabel ("Patente:",SwingConstants.CENTER);
				pat.setBounds(65,70,100,50);

				patente=new TextField(10);
				patente.setBounds(165, 80, 200, 30);

				bot=new JButton("Agregar");
				bot.setBounds(165,120,200,30);
				bot.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						if(patente.getText().compareTo("")!=0 && modelo.getText().compareTo("")!=0){
							gara.ingresarAuto(new Auto(modelo.getText(),patente.getText()));
							din.setText(""+gara.dineroRecaudado());
							cant.setText(""+gara.cantidadAutos());
							agregar.dispose();
						}
						}});


				agregar.add(mod);
				agregar.add(modelo);
				agregar.add(pat);
				agregar.add(patente);
				agregar.add(bot);
				agregar.add(DD);

				agregar.setVisible(true);
				}});

		boton2=new JButton("Sacar Auto");
		boton2.setBounds(570, 15, 110, 30);
		boton2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				sacar=new JFrame("Agregar");
				sacar.setBounds(500, 300, 500, 200);
				sacar.getContentPane().setBackground(new Color(0,162,232));

				sacar.setLayout(null);

				desv=new ImageIcon(getClass().getResource("Imagenes/DD.png"));
				DD=new JLabel();
				DD.setIcon(desv);
				DD.setBounds(0,-15, 100, 100);

				pat1= new JLabel ("Patente:",SwingConstants.CENTER);
				pat1.setBounds(65,40,100,50);

				patente1=new TextField(10);
				patente1.setBounds(165, 50, 200, 30);

				bot1=new JButton("Sacar");
				bot1.setBounds(165,120,200,30);
				bot1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						if(patente1.getText().compareTo("")!=0){
							gara.sacarAuto(patente1.getText());
							cant.setText(""+gara.cantidadAutos());
							sacar.dispose();
						}
						}});

				sacar.add(pat1);
				sacar.add(patente1);
				sacar.add(bot1);
				sacar.add(DD);

				sacar.setVisible(true);
				}});

		dinero=new JLabel("Dinero Recaudado",SwingConstants.CENTER);
		dinero.setBounds(190, 40, 110, 50);

		din=new TextField(10);
		din.setBounds(315, 50,80, 30);
		din.setEditable(false);
		din.setText(""+gara.dineroRecaudado());

		cantidad=new JLabel("Cantidad de Autos",SwingConstants.CENTER);
		cantidad.setBounds(460, 40, 110, 50);

		cant=new TextField(10);
		cant.setBounds(585, 50,80, 30);
		cant.setEditable(false);
		cant.setText(""+gara.cantidadAutos());

		pie.add(boton1);
		pie.add(boton2);
		pie.add(dinero);
		pie.add(din);
		pie.add(cantidad);
		pie.add(cant);

		ventana.add(cabecera);
		ventana.add(cuerpo);
		ventana.add(pie);
		ventana.setVisible(true);
	}
	public void addEstAutos(int idx, JLabel data){
		estacionamientoImgs[0][idx].removeAll();
		estacionamientoImgs[0][idx].add(data);
	}
}
