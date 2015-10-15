import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.*;

import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
	private ImageIcon Pesos;
	private ImageIcon desv;
	private Garage gara;
	private JPanel[] estacionamientoImgs = new JPanel[6];
	private JPanel[] esperaImgs = new JPanel[2];
	private JPanel[] auxImgs = new JPanel[5];
	private GUI context;

	public GUI(){
		gara=new Garage();
		ventana=new JFrame("Estacionamiento");
		ventana.setBounds(250, 50, 1000, 700);
		ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
		ventana.getContentPane().setBackground(new Color(0, 162, 232));
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Imagenes/DD2.png"));
		ventana.setIconImage(icon);

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
		cuerpo.setBackground(new Color(0, 162, 232));
		cuerpo.setBounds(0,200,985,365);

		/*cuerpo1=new JPanel();
		cuerpo1.setLayout(new GridLayout(2,1));
		cuerpo1.setBackground(new Color(0,162,232));*/

		esta=new JLabel("Estacionamiento",SwingConstants.CENTER);
		esta.setBounds(440, 0, 100, 50);
		estacionamiento=new JPanel();
		estacionamiento.setLayout(new GridLayout(1, 6));
		estacionamiento.setBorder(BorderFactory.createMatteBorder(
				4, 4, 4, 4, Color.green));
		estacionamiento.setBackground(new Color(53,53,53));

		estacionamiento.setBounds(0, 50, 985, 70);
		/*cuerpo.add(esta);
		cuerpo.add(estacionamiento);*/


		for(int n = 0; n < 6; n++) {
			estacionamientoImgs[n] = new JPanel();
			estacionamientoImgs[n].setBackground(new Color(53, 53, 53));
			estacionamiento.add(estacionamientoImgs[n]);
		}

		/*for(int i=0; i<6;i++) {
			try {
				this.addEstAutos(i, i);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}*/

		cuerpo.add(esta);
		cuerpo.add(estacionamiento);

		espe=new JLabel("Espera",SwingConstants.CENTER);
		espe.setBounds(440, 120, 100, 50);

		espera=new JPanel();
		espera.setLayout(new GridLayout(1,2));
		espera.setBorder(BorderFactory.createMatteBorder(
                4, 4, 4, 4, Color.yellow));
		espera.setBackground(new Color(53,53,53));

		for(int n = 0; n < 2; n++) {
			esperaImgs[n] = new JPanel();
			esperaImgs[n].setBackground(new Color(53, 53, 53));
			espera.add(esperaImgs[n]);
		}


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
		aux.setLayout(new GridLayout(1,5));
		aux.setBorder(BorderFactory.createMatteBorder(
                4, 4, 4, 4, Color.red));
		aux.setBackground(new Color(53,53,53));

		aux.setBounds(0, 290, 985, 70);

		for(int n = 0; n < 5; n++) {
			auxImgs[n] = new JPanel();
			auxImgs[n].setBackground(new Color(53, 53, 53));
			aux.add(auxImgs[n]);
		}

		cuerpo.add(au);
		cuerpo.add(aux);
		//cuerpo3.add(au);
		//cuerpo3.add(aux);

		//cuerpo.add(cuerpo1);
		//cuerpo.add(cuerpo2);
		//cuerpo.add(cuerpo3);

		pie=new JPanel();
		pie.setLayout(null);
		pie.setBackground(new Color(0, 162, 232));
		pie.setBounds(0, 565, 985, 134);

		boton1=new JButton("Agregar Auto");
		boton1.setBounds(300, 15, 110, 30);
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregar = new JFrame("Agregar");
				agregar.setBounds(500, 300, 500, 200);
				agregar.getContentPane().setBackground(new Color(0, 162, 232));

				agregar.setLayout(null);

				desv = new ImageIcon(getClass().getResource("Imagenes/DD.png"));
				DD = new JLabel();
				DD.setIcon(desv);
				DD.setBounds(0, -15, 100, 100);

				mod = new JLabel("Modelo:", SwingConstants.CENTER);
				mod.setBounds(65, 15, 100, 50);

				modelo = new TextField(10);
				modelo.setBounds(165, 25, 200, 30);

				pat = new JLabel("Patente:", SwingConstants.CENTER);
				pat.setBounds(65, 70, 100, 50);

				patente = new TextField(10);
				patente.setBounds(165, 80, 200, 30);

				bot = new JButton("Agregar");
				bot.setBounds(165, 120, 200, 30);
				bot.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (patente.getText().compareTo("") != 0 && modelo.getText().compareTo("") != 0) {
							Random rnd = new Random();
							int color = rnd.nextInt(5) + 1;
							gara.ingresarAuto(new Auto(modelo.getText(), patente.getText(), color), context);
							din.setText("" + gara.dineroRecaudado());
							cant.setText("" + gara.cantidadAutos());
							
							
							try{sonido2();
							}
							catch(Exception es){}
							
							
							agregar.dispose();
						}
					}
				});


				agregar.add(mod);
				agregar.add(modelo);
				agregar.add(pat);
				agregar.add(patente);
				agregar.add(bot);
				agregar.add(DD);

				agregar.setVisible(true);
			}
		});

		boton2=new JButton("Sacar Auto");
		boton2.setBounds(570, 15, 110, 30);
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sacar = new JFrame("Sacar");
				sacar.setBounds(500, 300, 500, 200);
				sacar.getContentPane().setBackground(new Color(0, 162, 232));

				sacar.setLayout(null);

				desv = new ImageIcon(getClass().getResource("Imagenes/DD.png"));
				DD = new JLabel();
				DD.setIcon(desv);
				DD.setBounds(0, -15, 100, 100);

				pat1 = new JLabel("Patente:", SwingConstants.CENTER);
				pat1.setBounds(65, 40, 100, 50);

				patente1 = new TextField(10);
				patente1.setBounds(165, 50, 200, 30);

				bot1 = new JButton("Sacar");
				bot1.setBounds(165, 120, 200, 30);
				bot1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (patente1.getText().compareTo("") != 0) {
							gara.sacarAuto(patente1.getText(), context);
							cant.setText("" + gara.cantidadAutos());
							
							
							try{sonido();
							}
							catch(Exception es){}
							
							sacar.dispose();
						}
					}
				});

				sacar.add(pat1);
				sacar.add(patente1);
				sacar.add(bot1);
				sacar.add(DD);

				sacar.setVisible(true);
			}
		});

		dinero=new JLabel("Dinero Recaudado",SwingConstants.CENTER);
		Pesos=new ImageIcon(getClass().getResource("Imagenes/pesos.png"));
		dinero.setIcon(Pesos);
		dinero.setBounds(130, 40, 180, 50);



		din=new TextField(10);
		din.setBounds(315, 50,80, 30);
		din.setEditable(false);
		din.setText("" + gara.dineroRecaudado());

		cantidad=new JLabel("Cantidad de Autos",SwingConstants.CENTER);
		cantidad.setBounds(460, 40, 110, 50);

		cant=new TextField(10);
		cant.setBounds(585, 50,80, 30);
		cant.setEditable(false);
		cant.setText("" + gara.cantidadAutos());

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

		context = this;
	}
	public void addEstAutos(int idx, int auto){
		estacionamientoImgs[idx].removeAll();
		JLabel autitoLbl;
		if(auto!=-1) {
			ImageIcon autito = new ImageIcon(getClass().getResource("Imagenes/cochesitos/" + auto + ".png"));
			autitoLbl = new JLabel();
			autitoLbl.setBackground(new Color(53, 53, 53));
			autitoLbl.setIcon(autito);
		}
		else {
			autitoLbl = new JLabel();
		}
		estacionamientoImgs[idx].add(autitoLbl);
		estacionamiento.revalidate();
		estacionamiento.repaint();
	}
	public void addAux(int idx, int auto){
		auxImgs[idx].removeAll();
		JLabel autitoLbl;
		if(auto!=-1) {
			ImageIcon autito = new ImageIcon(getClass().getResource("Imagenes/cochesitos/" + auto + ".png"));
			autitoLbl = new JLabel();
			autitoLbl.setBackground(new Color(53, 53, 53));
			autitoLbl.setIcon(autito);
		}
		else {
			autitoLbl = new JLabel();
		}
		auxImgs[idx].add(autitoLbl);
		aux.revalidate();
		aux.repaint();
	}
	public void addEspera(int idx, int auto){
		esperaImgs[idx].removeAll();
		JLabel autitoLbl;
		if(auto!=-1) {
			ImageIcon autito = new ImageIcon(getClass().getResource("Imagenes/cochesitos/" + auto + ".png"));
			autitoLbl = new JLabel();
			autitoLbl.setBackground(new Color(53, 53, 53));
			autitoLbl.setIcon(autito);
		}
		else {
			autitoLbl = new JLabel();
		}
		esperaImgs[idx].add(autitoLbl);
		espera.revalidate();
		espera.repaint();
	}
	
	
	public void sonido() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		Clip sonido=AudioSystem.getClip();
		sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("Sonido/Claxon.wav")));
		sonido.start();
	}
	public void sonido2() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		Clip sonido=AudioSystem.getClip();
		sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("Sonido/Caja.wav")));
		sonido.start();
	}
}
