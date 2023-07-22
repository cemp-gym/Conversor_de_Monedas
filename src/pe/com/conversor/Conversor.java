/*
 * Copyright (c) 2023, César Eduardo Martínez Pérez
 */
package pe.com.conversor;

import java.text.DecimalFormat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


/**
 * Challenge ONE: BackEnd - Java
 * Sprint 01: Programa conversor de monedas o divisas.
 * Programa conversor de monedas o divisas.
 * Requisitos:
 * El convertidor de moneda debe:
 * - Convertir de la moneda de tu país a Dólar
 * - Convertir de la moneda de tu país a Euros
 * - Convertir de la moneda de tu país a Libras Esterlinas
 * - Convertir de la moneda de tu país a Yen Japonés
 * - Convertir de la moneda de tu país a Won sul-coreano
 * Recordando que también debe ser posible convertir inversamente, es decir:
 * - Convertir de Dólar a la moneda de tu país
 * - Convertir de Euros a la moneda de tu país
 * - Convertir de Libras Esterlinas a la moneda de tu país
 * - Convertir de Yen Japonés a la moneda de tu país
 * - Convertir de Won sul-coreano a la moneda de tu país
 * Extra:
 * Como desafío extra te animamos a que dejes fluir tu creatividad,
 * si puedo convertir divisas, ¿tal vez pueda añadir a mi programa 
 * otros tipos de conversiones como temperatura por ejemplo?
 * 
 * @version 1.0
 * @author CESAR EDUARDO MARTINEZ PEREZ
 */

public class Conversor extends JFrame implements ActionListener {
	/**
	 * Primera versión terminada del proyecto en un único archivo Java.
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar mBar;
	private JMenu mnOpciones;
	private JMenu mnMonedas, mnTemperatura, mnLongitud, mnMasa, mnVolumen;
	private JMenuItem miSalir;
	private JMenuItem miSolDolar, miSolEuro, miSolLibra, miSolYen, miSolWon;
	private JMenuItem miDolarSol, miEuroSol, miLibraSol, miYenSol, miWonSol;
	private JMenuItem miCenFar, miCenKel, miFarCen, miFarKel, miKelCen, miKelFar;
	private JMenuItem miCenPul, miPulCen, miMetPie, miPieMet, miKilMil, miMilKil;
	private JMenuItem miGraQui, miQuiGra, miGraOnz, miOnzGra, miKilLib, miLibKil;
	private JMenuItem miMilOnz, miOnzMil, miLitGal, miGalLit;
	boolean cancelar = false;
	
	/**
	 * Tipo de Cambio al 21 de julio de 2023
	 * Datos obtenidos de Google
	 */
	private static final double TCDOLAR = 3.58579;
	private static final double TCEURO = 3.98791;
	private static final double TCLIBRA = 4.60756;
	private static final double TCYEN = 0.02531266;
	private static final double TCWON = 0.00278264;
	
	public Conversor() {
		setLayout(null);
		mBar = new JMenuBar();
		setJMenuBar(mBar);
		mnOpciones = new JMenu("Menú de Opciones de Conversión");
		mBar.add(mnOpciones);
		miSalir = new JMenuItem("Salir");
		mBar.add(miSalir);
		mnMonedas = new JMenu("Conversión de Monedas");
		mnOpciones.add(mnMonedas);
		mnTemperatura = new JMenu("Conversión de Temperatura");
		mnOpciones.add(mnTemperatura);
		mnLongitud = new JMenu("Conversión de Medidas de Longitud");
		mnOpciones.add(mnLongitud);
		mnMasa = new JMenu("Conversión de Medidas de Masa");
		mnOpciones.add(mnMasa);
		mnVolumen = new JMenu("Conversión de Medidas de Volumen");
		mnOpciones.add(mnVolumen);
		miSolDolar = new JMenuItem("Sol(PEN) a Dólar(USD)");
		mnMonedas.add(miSolDolar);
		miSolEuro = new JMenuItem("Sol(PEN) a Euro(EUR)");
		mnMonedas.add(miSolEuro);
		miSolLibra = new JMenuItem("Sol(PEN) a Libra(GBP)");
		mnMonedas.add(miSolLibra);
		miSolYen = new JMenuItem("Sol(PEN) a Yen(JPY)");
		mnMonedas.add(miSolYen);
		miSolWon = new JMenuItem("Sol(PEN) a Won(KRW)");
		mnMonedas.add(miSolWon);
		miDolarSol = new JMenuItem("Dólar(USD) a Sol(PEN)");
		mnMonedas.add(miDolarSol);
		miEuroSol = new JMenuItem("Euro(EUR) a Sol(PEN)");
		mnMonedas.add(miEuroSol);
		miLibraSol = new JMenuItem("Libra(GBP) a Sol(PEN)");
		mnMonedas.add(miLibraSol);
		miYenSol = new JMenuItem("Yen(JPY) a Sol(PEN)");
		mnMonedas.add(miYenSol);
		miWonSol = new JMenuItem("Won(KRW) a Sol(PEN)");
		mnMonedas.add(miWonSol);
		miCenFar = new JMenuItem("Centígrados(ºC) a Farenheit(ºF)");
		mnTemperatura.add(miCenFar);
		miCenKel = new JMenuItem("Centígrados(ºC) a Kelvin(K)");
		mnTemperatura.add(miCenKel);
		miFarCen = new JMenuItem("Farenheit(ºF) a Centígrados(ºC)");
		mnTemperatura.add(miFarCen);
		miFarKel = new JMenuItem("Farenheit(ºF) a Kelvin(K)");
		mnTemperatura.add(miFarKel);
		miKelCen = new JMenuItem("Kelvin(K) a Centígrados(ºC)");
		mnTemperatura.add(miKelCen);
		miKelFar = new JMenuItem("Kelvin(K) a Farenheit(ºF)");
		mnTemperatura.add(miKelFar);
		miCenPul = new JMenuItem("Centímetros(cm) a Pulgadas(in)");
		mnLongitud.add(miCenPul);
		miPulCen = new JMenuItem("Pulgadas(in) a Centímetros(cm)");
		mnLongitud.add(miPulCen);
		miMetPie = new JMenuItem("Metros(m) a Pies(ft)");
		mnLongitud.add(miMetPie);
		miPieMet = new JMenuItem("Pies(ft) a Metros(m)");
		mnLongitud.add(miPieMet);
		miKilMil = new JMenuItem("Kilómetros(km) a Millas(mi)");
		mnLongitud.add(miKilMil);
		miMilKil = new JMenuItem("Millas(mi) a Kilómetros(km)");
		mnLongitud.add(miMilKil);
		miGraQui = new JMenuItem("Gramos(g) a Quilates(ct)");
		mnMasa.add(miGraQui);
		miQuiGra = new JMenuItem("Quilates(ct) a Gramos(g)");
		mnMasa.add(miQuiGra);
		miGraOnz = new JMenuItem("Gramos(g) a Onzas(oz)");
		mnMasa.add(miGraOnz);
		miOnzGra = new JMenuItem("Onzas(oz) a Gramos(g)");
		mnMasa.add(miOnzGra);
		miKilLib = new JMenuItem("Kilogramos(kg) a Libras(lb)");
		mnMasa.add(miKilLib);
		miLibKil = new JMenuItem("Quilates(ct) a Gramos(g)");
		mnMasa.add(miLibKil);
		miMilOnz = new JMenuItem("Mililitros(ml) a Onzas Líquidas(fl oz)");
		mnVolumen.add(miMilOnz);
		miOnzMil = new JMenuItem("Onzas Líquidas(fl oz) a Mililitros(ml)");
		mnVolumen.add(miOnzMil);
		miLitGal = new JMenuItem("Litros(l) a Galones(gal)");
		mnVolumen.add(miLitGal);
		miGalLit = new JMenuItem("Galones(gal) a Litros(l)");
		mnVolumen.add(miGalLit);
		
		miSalir.addActionListener(this);
		miSolDolar.addActionListener(this);
		miSolEuro.addActionListener(this);
		miSolLibra.addActionListener(this);
		miSolYen.addActionListener(this);
		miSolWon.addActionListener(this);
		miDolarSol.addActionListener(this);
		miEuroSol.addActionListener(this);
		miLibraSol.addActionListener(this);
		miYenSol.addActionListener(this);
		miWonSol.addActionListener(this);
		miCenFar.addActionListener(this);
		miCenKel.addActionListener(this);
		miFarCen.addActionListener(this);
		miFarKel.addActionListener(this);
		miKelCen.addActionListener(this);
		miKelFar.addActionListener(this);
		miCenPul.addActionListener(this);
		miPulCen.addActionListener(this);
		miMetPie.addActionListener(this);
		miPieMet.addActionListener(this);
		miKilMil.addActionListener(this);
		miMilKil.addActionListener(this);
		miGraQui.addActionListener(this);
		miQuiGra.addActionListener(this);
		miGraOnz.addActionListener(this);
		miOnzGra.addActionListener(this);
		miKilLib.addActionListener(this);
		miLibKil.addActionListener(this);
		miMilOnz.addActionListener(this);
		miOnzMil.addActionListener(this);
		miLitGal.addActionListener(this);
		miGalLit.addActionListener(this);		
	}
	
	public boolean ValidarNumeros(String datos, boolean noNegativo) throws Exception {
		try {
			double numero = Double.parseDouble(datos);
			if (noNegativo && (numero <= 0)) {
				JOptionPane.showMessageDialog(null, "¡Valor no válido o no se ingresó valor!", "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "¡Valor no válido o no se ingresó valor!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public double CuadrodeDialogo(String mensaje, boolean noNegativo) throws Exception {
		boolean correcto = false;
		this.cancelar = false;
		double valor = 0;
		while (!correcto) {
			String datos = JOptionPane.showInputDialog(null, mensaje);
			if (datos != null) {
				correcto = ValidarNumeros(datos, noNegativo);
				if (correcto) {
					valor = Double.parseDouble(datos);
				}
			} else {
				correcto = true;
				this.cancelar = true;
			}
		}
		return valor;
	}
	
	private double SolesaMoneda(double soles, double tc) {
		return (soles / tc);
	}
	
	private double MonedaaSoles(double moneda, double tc) {
		return (moneda * tc);
	}
	
	private String NumDosDec(double cantidad) {
		DecimalFormat formatDosDec = new DecimalFormat("###,###.00");
		String textoDosDec = formatDosDec.format(cantidad);
		return textoDosDec;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/**
		 * Salir de la aplicación
		 */
		if (e.getSource()==miSalir) {
			int opSalir = JOptionPane.showConfirmDialog(null, "¿Está seguro de salir?", "¡Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (opSalir == JOptionPane.YES_OPTION) { 
				System.exit(0);
			}
		}
		
		/**
		 * Inicio de conversión de monedas
		 */
		
		if (e.getSource()==miSolDolar) {
			double soles = 0;
			double dolares = 0;
			try {
				soles = CuadrodeDialogo("Ingrese un monto en S/ (mayor que cero)", true);
				if (soles > 0) {
					dolares = SolesaMoneda(soles, TCDOLAR);
					String mensaje = "Tienes USD $ " + NumDosDec(dolares);
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miSolEuro) {
			double soles = 0;
			double euros = 0;
			try {
				soles = CuadrodeDialogo("Ingrese un monto en S/ (mayor que cero)", true);
				if (soles > 0) {
					euros = SolesaMoneda(soles, TCEURO);
					String mensaje = "Tienes EUR € " + NumDosDec(euros);
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miSolLibra) {
			double soles = 0;
			double libras = 0;
			try {
				soles = CuadrodeDialogo("Ingrese un monto en S/ (mayor que cero)", true);
				if (soles > 0) {
					libras = SolesaMoneda(soles, TCLIBRA);
					String mensaje = "Tienes GBP £ " + NumDosDec(libras);
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miSolYen) {
			double soles = 0;
			double yen = 0;
			try {
				soles = CuadrodeDialogo("Ingrese un monto en S/ (mayor que cero)", true);
				if (soles > 0) {
					yen = SolesaMoneda(soles, TCYEN);
					String mensaje = "Tienes JPY ¥ " + NumDosDec(yen);
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miSolWon) {
			double soles = 0;
			double won = 0;
			try {
				soles = CuadrodeDialogo("Ingrese un monto en S/ (mayor que cero)", true);
				if (soles > 0) {
					won = SolesaMoneda(soles, TCWON);
					String mensaje = "Tienes KRW ₩ " + NumDosDec(won);
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miDolarSol) {
			double soles = 0;
			double dolares = 0;
			try {
				dolares = CuadrodeDialogo("Ingrese un monto en $ (mayor que cero)", true);
				if (dolares > 0) {
					soles = MonedaaSoles(dolares, TCDOLAR);
					String mensaje = "Tienes PEN S/ " + NumDosDec(soles);
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miEuroSol) {
			double soles = 0;
			double euros = 0;
			try {
				euros = CuadrodeDialogo("Ingrese un monto en € (mayor que cero)", true);
				if (euros > 0) {
					soles = MonedaaSoles(euros, TCEURO);
					String mensaje = "Tienes PEN S/ " + NumDosDec(soles);
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miLibraSol) {
			double soles = 0;
			double libras = 0;
			try {
				libras = CuadrodeDialogo("Ingrese un monto en £ (mayor que cero)", true);
				if (libras > 0) {
					soles = MonedaaSoles(libras, TCLIBRA);
					String mensaje = "Tienes PEN S/ " + NumDosDec(soles);
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miYenSol) {
			double soles = 0;
			double yen = 0;
			try {
				yen = CuadrodeDialogo("Ingrese un monto en ¥ (mayor que cero)", true);
				if (yen > 0) {
					soles = MonedaaSoles(yen, TCYEN);
					String mensaje = "Tienes PEN S/ " + NumDosDec(soles);
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miWonSol) {
			double soles = 0;
			double won = 0;
			try {
				won = CuadrodeDialogo("Ingrese un monto en ₩ (mayor que cero)", true);
				if (won > 0) {
					soles = MonedaaSoles(won, TCWON);
					String mensaje = "Tienes PEN S/ " + NumDosDec(soles);
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		/**
		 * Inicio de conversión de temperaturas
		 */
		
		if (e.getSource()==miCenFar) {
			double cen = 0;
			double far = 0;
			try {
				cen = CuadrodeDialogo("Ingrese temperatura en ºC", false);
				if (!this.cancelar) {
					far = 32 + cen * 9 / 5;
					String mensaje = "Temperatura en Farenheit " + NumDosDec(far) + "ºF";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miCenKel) {
			double cen = 0;
			double kel = 0;
			try {
				cen = CuadrodeDialogo("Ingrese temperatura en ºC", false);
				if (!this.cancelar) {
					kel = 273.15 + cen;
					String mensaje = "Temperatura en Kelvin " + NumDosDec(kel) + "K";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miFarCen) {
			double cen = 0;
			double far = 0;
			try {
				far = CuadrodeDialogo("Ingrese temperatura en ºF", false);
				if (!this.cancelar) {
					cen = (far - 32) * 5 / 9;
					String mensaje = "Temperatura en Centígrados " + NumDosDec(cen) + "ºC";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
				
		if (e.getSource()==miFarKel) {
			double far = 0;
			double kel = 0;
			try {
				far = CuadrodeDialogo("Ingrese temperatura en ºF", false);
				if (!this.cancelar) {
					kel = 273.15 + (far - 32) * 5 / 9;
					String mensaje = "Temperatura en Kelvin " + NumDosDec(kel) + "K";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miKelCen) {
			double cen = 0;
			double kel = 0;
			try {
				kel = CuadrodeDialogo("Ingrese temperatura en K", false);
				if (!this.cancelar) {
					cen = kel - 273.15;
					String mensaje = "Temperatura en Centígrados " + NumDosDec(cen) + "ºC";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miKelFar) {
			double far = 0;
			double kel = 0;
			try {
				kel = CuadrodeDialogo("Ingrese temperatura en K", false);
				if (!this.cancelar) {
					far = (kel - 273.15) * 9 / 5 + 32;
					String mensaje = "Temperatura en Farenheit " + NumDosDec(far) + "ºF";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		/**
		 * Inicio de conversión de medidas de longitud
		 */
		
		if (e.getSource()==miCenPul) {
			double cen = 0;
			double pul = 0;
			try {
				cen = CuadrodeDialogo("Ingrese longitud en cm (mayor que cero)", true);
				if (!this.cancelar) {
					pul = cen / 2.54;
					String mensaje = "Longitud en pulgadas " + NumDosDec(pul) + "in";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miPulCen) {
			double cen = 0;
			double pul = 0;
			try {
				pul = CuadrodeDialogo("Ingrese longitud en in (mayor que cero)", true);
				if (!this.cancelar) {
					cen = pul * 2.54;
					String mensaje = "Longitud en centímetros " + NumDosDec(cen) + "cm";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miMetPie) {
			double met = 0;
			double pie = 0;
			try {
				met = CuadrodeDialogo("Ingrese longitud en m (mayor que cero)", true);
				if (!this.cancelar) {
					pie = met / 2.54 / 12;
					String mensaje = "Longitud en pies " + NumDosDec(pie) + "ft";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miPieMet) {
			double met = 0;
			double pie = 0;
			try {
				pie = CuadrodeDialogo("Ingrese longitud en ft (mayor que cero)", true);
				if (!this.cancelar) {
					met = pie * 2.54 * 12;
					String mensaje = "Longitud en metros " + NumDosDec(met) + "m";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miKilMil) {
			double kil = 0;
			double mil = 0;
			try {
				kil = CuadrodeDialogo("Ingrese longitud en km (mayor que cero)", true);
				if (!this.cancelar) {
					mil = kil / 1.609344;
					String mensaje = "Longitud en millas " + NumDosDec(mil) + "mi";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miMilKil) {
			double kil = 0;
			double mil = 0;
			try {
				mil = CuadrodeDialogo("Ingrese longitud en mi (mayor que cero)", true);
				if (!this.cancelar) {
					kil = mil * 1.609344;
					String mensaje = "Longitud en kilómetros " + NumDosDec(kil) + "km";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		/**
		 * Inicio de conversión de medidas de masa
		 */
		
		if (e.getSource()==miGraQui) {
			double gra = 0;
			double qui = 0;
			try {
				gra = CuadrodeDialogo("Ingrese masa en g (mayor que cero)", true);
				if (!this.cancelar) {
					qui = gra * 5;
					String mensaje = "Masa en quilates " + NumDosDec(qui) + "ct";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miQuiGra) {
			double gra = 0;
			double qui = 0;
			try {
				qui = CuadrodeDialogo("Ingrese masa en ct (mayor que cero)", true);
				if (!this.cancelar) {
					gra = qui / 5;
					String mensaje = "Masa en gramos " + NumDosDec(gra) + "g";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miGraOnz) {
			double gra = 0;
			double onz = 0;
			try {
				gra = CuadrodeDialogo("Ingrese masa en g (mayor que cero)", true);
				if (!this.cancelar) {
					onz = gra / 28.349523125;
					String mensaje = "Masa en onzas " + NumDosDec(onz) + "oz";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miOnzGra) {
			double gra = 0;
			double onz = 0;
			try {
				onz = CuadrodeDialogo("Ingrese masa en oz (mayor que cero)", true);
				if (!this.cancelar) {
					gra = onz * 28.349523125;
					String mensaje = "Masa en gramos " + NumDosDec(gra) + "g";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miKilLib) {
			double kil = 0;
			double lib = 0;
			try {
				kil = CuadrodeDialogo("Ingrese masa en kg (mayor que cero)", true);
				if (!this.cancelar) {
					lib = kil / 0.45359237;
					String mensaje = "Masa en libras " + NumDosDec(lib) + "lb";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miKilLib) {
			double kil = 0;
			double lib = 0;
			try {
				lib = CuadrodeDialogo("Ingrese masa en lb (mayor que cero)", true);
				if (!this.cancelar) {
					kil = lib * 0.45359237;
					String mensaje = "Masa en kilogramos " + NumDosDec(kil) + "kg";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		/**
		 * Inicio de conversión de medidas de volumen
		 */
		
		if (e.getSource()==miMilOnz) {
			double mil = 0;
			double ozl = 0;
			try {
				mil = CuadrodeDialogo("Ingrese volumen en ml (mayor que cero)", true);
				if (!this.cancelar) {
					ozl = mil / 29.5735295625;
					String mensaje = "Volumen en onzas líquidas " + NumDosDec(ozl) + "fl oz";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miOnzMil) {
			double mil = 0;
			double ozl = 0;
			try {
				ozl = CuadrodeDialogo("Ingrese volumen en fl oz (mayor que cero)", true);
				if (!this.cancelar) {
					mil = ozl * 29.5735295625;
					String mensaje = "Volumen en mililitros " + NumDosDec(mil) + "ml";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}

		if (e.getSource()==miLitGal) {
			double lit = 0;
			double gal = 0;
			try {
				lit = CuadrodeDialogo("Ingrese volumen en l (mayor que cero)", true);
				if (!this.cancelar) {
					gal = lit / 3.785411784;
					String mensaje = "Volumen en galones " + NumDosDec(gal) + "gal";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
		
		if (e.getSource()==miGalLit) {
			double lit = 0;
			double gal = 0;
			try {
				gal = CuadrodeDialogo("Ingrese volumen en gal (mayor que cero)", true);
				if (!this.cancelar) {
					lit = gal * 3.785411784;
					String mensaje = "Volumen en litros " + NumDosDec(lit) + "l";
					JOptionPane.showMessageDialog(null, mensaje);
				}
			} catch (Exception e1) {
				// e1.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Conversor form1 = new Conversor();
		form1.setTitle("Challenge ONE BackEnd Java");
		form1.setBounds(0, 0, 560, 300);
		form1.setLocationRelativeTo(null);
		form1.setVisible(true);
		form1.setResizable(false);
		form1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}