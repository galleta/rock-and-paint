package super_paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;

/**
 * <p>T�tulo: Pr�ctica de Sistemas Multimedia</p>
 * <p>Descripci�n: Pr�ctica de Sistemas Multimedia</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Empresa: Piratas Sin Fronteras S.A.</p>
 * @author Francisco Jes�s Delgado Almir�n
 * @version 1.0
 */

public class ventana_colores extends JInternalFrame
{
  private Interfaz creador;
  private Color trazo_personalizado, relleno_personalizado, negro, rojo, azul, blanco, amarillo, gris, verde, rosa, marron, naranja, azul_claro, beige, lima, violeta, color_actual_relleno, color_actual_trazo;

  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanelAzulClaroRelleno = new JPanel();
  JPanel jPanelNaranjaRelleno = new JPanel();
  JPanel jPanelRellenoPersonalizado = new JPanel();
  JPanel jPanelBlancoTrazo = new JPanel();
  JPanel jPanelMarronTrazo = new JPanel();
  JPanel jPanelColorRelleno = new JPanel();
  JPanel jPanelTrazoPersonalizado = new JPanel();
  JPanel jPanelAmarilloTrazo = new JPanel();
  GridLayout gridLayout4 = new GridLayout(2,2);
  FlowLayout flowLayout2 = new FlowLayout();
  JPanel jPanelBeigeTrazo = new JPanel();
  JPanel jPanelElegirRellenoPersonalizado = new JPanel();
  JPanel jPanelColor = new JPanel();
  JPanel jPanelAzulTrazo = new JPanel();
  JPanel jPanelAzulClaroTrazo = new JPanel();
  JPanel jPanelVerdeTrazo = new JPanel();
  BorderLayout borderLayout7 = new BorderLayout();
  JPanel jPanelGrisClaroTrazo = new JPanel();
  GridLayout gridLayout3 = new GridLayout(2,2);
  JPanel jPanelNegroTrazo = new JPanel();
  JPanel jPanelMarronRelleno = new JPanel();
  JPanel jPanelRojoTrazo = new JPanel();
  JPanel jPanelBlancoRelleno = new JPanel();
  JPanel jPanelElegirTrazoPersonalizado = new JPanel();
  JPanel jPanel1 = new JPanel();
  JPanel jPanelRojoRelleno = new JPanel();
  JPanel jPanelNegroRelleno = new JPanel();
  JPanel jPanelVerdeRelleno = new JPanel();
  JPanel jPanelRosaRelleno = new JPanel();
  FlowLayout flowLayout4 = new FlowLayout();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JPanel jPanelMostrarColorActualTrazo = new JPanel();
  BorderLayout borderLayout4 = new BorderLayout();
  JPanel jPanelBeigeRelleno = new JPanel();
  JPanel jPanelGrisClaroRelleno = new JPanel();
  JPanel jPanelMostrarColorActualRelleno = new JPanel();
  JPanel jPanelAmarilloRelleno = new JPanel();
  JPanel jPanelVioletaTrazo = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanelRosaTrazo = new JPanel();
  JPanel jPanelElegirColores = new JPanel();
  JPanel jPanelColoresActuales = new JPanel();
  BorderLayout borderLayout3 = new BorderLayout();
  JLabel jLabel7 = new JLabel();
  JPanel jPanelLimaRelleno = new JPanel();
  JPanel jPanelVioletaRelleno = new JPanel();
  JPanel jPanelColorTrazo = new JPanel();
  JPanel jPanelLimaTrazo = new JPanel();
  JPanel jPanelElegirColoresTrazo = new JPanel();
  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanelNaranjaTrazo = new JPanel();
  BorderLayout borderLayout6 = new BorderLayout();
  JPanel jPanelAzulRelleno = new JPanel();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;
  TitledBorder titledBorder3;

  public ventana_colores()
  {

  }

  public ventana_colores(Interfaz i) {
    try {
      creador = i;
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception
  {
    ImageIcon icono_frame = new ImageIcon("iconos/imagen.gif");
    this.setFrameIcon(icono_frame);
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(156, 156, 158)),"Color del trazo:");
    titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(156, 156, 158)),"Colores actuales:");
    titledBorder3 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(156, 156, 158)),"Color del relleno:");
    this.setTitle("Colores");
    this.setClosable(true);

    // ***** Le doy su valor a los colores *****
    negro = Color.black;
    rojo = Color.red;
    azul = Color.blue;
    blanco = Color.white;
    amarillo = Color.yellow;
    gris = Color.gray;
    verde = Color.green;
    rosa = Color.pink;
    marron = new Color(165,42,42);
    naranja = Color.orange;
    azul_claro = new Color(176,224,230);
    beige = new Color(245,245,220);
    lima = new Color(32,205,32);
    violeta = new Color(221,160,221);
    color_actual_trazo = negro;
    color_actual_relleno = blanco;
    // ******************************************

    // ***** Pongo los colores en sus respectivos paneles *****
    jPanelNegroRelleno.setBackground(negro);
    jPanelNegroTrazo.setBackground(negro);
    jPanelGrisClaroRelleno.setBackground(gris);
    jPanelGrisClaroTrazo.setBackground(gris);
    jPanelBlancoRelleno.setBackground(blanco);
    jPanelBlancoTrazo.setBackground(blanco);
    jPanelRojoRelleno.setBackground(rojo);
    jPanelRojoTrazo.setBackground(rojo);
    jPanelAmarilloRelleno.setBackground(amarillo);
    jPanelAmarilloTrazo.setBackground(amarillo);
    jPanelVerdeRelleno.setBackground(verde);
    jPanelVerdeTrazo.setBackground(verde);
    jPanelAzulRelleno.setBackground(azul);
    jPanelAzulTrazo.setBackground(azul);
    jPanelRosaRelleno.setBackground(rosa);
    jPanelRosaTrazo.setBackground(rosa);
    jPanelNaranjaRelleno.setBackground(naranja);
    jPanelNaranjaTrazo.setBackground(naranja);
    jPanelMarronRelleno.setBackground(marron);
    jPanelMarronTrazo.setBackground(marron);
    jPanelAzulClaroRelleno.setBackground(azul_claro);
    jPanelAzulClaroTrazo.setBackground(azul_claro);
    jPanelBeigeRelleno.setBackground(beige);
    jPanelBeigeTrazo.setBackground(beige);
    jPanelLimaRelleno.setBackground(lima);
    jPanelLimaTrazo.setBackground(lima);
    jPanelVioletaRelleno.setBackground(violeta);
    jPanelVioletaTrazo.setBackground(violeta);
    jPanelMostrarColorActualRelleno.setBackground(color_actual_relleno);
    jPanelMostrarColorActualRelleno.setToolTipText("Color actual de relleno");
    jPanelMostrarColorActualTrazo.setBackground(color_actual_trazo);
    jPanelMostrarColorActualTrazo.setToolTipText("Color actual de trazo");
    // ***********************************************************

    jPanelRellenoPersonalizado.setLayout(borderLayout6);
    jPanelNaranjaRelleno.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelNaranjaRelleno.setRequestFocusEnabled(true);
    jPanelNaranjaRelleno.setToolTipText("Naranja");
    jPanelNaranjaRelleno.addMouseListener(new ventana_colores_jPanelNaranjaRelleno_mouseAdapter(this));
    jPanelAzulClaroRelleno.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelAzulClaroRelleno.setToolTipText("Azul claro");
    jPanelAzulClaroRelleno.addMouseListener(new ventana_colores_jPanelAzulClaroRelleno_mouseAdapter(this));
    this.getContentPane().setLayout(borderLayout1);
    jPanelBlancoTrazo.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelBlancoTrazo.setToolTipText("Blanco");
    jPanelBlancoTrazo.addMouseListener(new ventana_colores_jPanelBlancoTrazo_mouseAdapter(this));
    jPanelMarronTrazo.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelMarronTrazo.setToolTipText("Marr�n");
    jPanelMarronTrazo.addMouseListener(new ventana_colores_jPanelMarronTrazo_mouseAdapter(this));
    jPanelColorRelleno.setLayout(borderLayout3);
    jPanelTrazoPersonalizado.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelTrazoPersonalizado.addMouseListener(new ventana_colores_jPanelTrazoPersonalizado_mouseAdapter(this));
    jPanelTrazoPersonalizado.setLayout(flowLayout4);
    jPanelAmarilloTrazo.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelAmarilloTrazo.setToolTipText("Amarillo");
    jPanelAmarilloTrazo.addMouseListener(new ventana_colores_jPanelAmarilloTrazo_mouseAdapter(this));
    jPanelBeigeTrazo.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelBeigeTrazo.setToolTipText("Beige");
    jPanelBeigeTrazo.addMouseListener(new ventana_colores_jPanelBeigeTrazo_mouseAdapter(this));
    jPanelElegirRellenoPersonalizado.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelElegirRellenoPersonalizado.addMouseListener(new ventana_colores_jPanelElegirRellenoPersonalizado_mouseAdapter(this));
    jPanelColor.setBorder(BorderFactory.createLoweredBevelBorder());
    jPanelColor.setLayout(borderLayout7);
    jPanelAzulTrazo.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelAzulTrazo.setToolTipText("Azul");
    jPanelAzulTrazo.addMouseListener(new ventana_colores_jPanelAzulTrazo_mouseAdapter(this));
    jPanelAzulClaroTrazo.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelAzulClaroTrazo.setToolTipText("Azul claro");
    jPanelAzulClaroTrazo.addMouseListener(new ventana_colores_jPanelAzulClaroTrazo_mouseAdapter(this));
    jPanelVerdeTrazo.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelVerdeTrazo.setToolTipText("Verde");
    jPanelVerdeTrazo.addMouseListener(new ventana_colores_jPanelVerdeTrazo_mouseAdapter(this));
    jPanelGrisClaroTrazo.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelGrisClaroTrazo.setToolTipText("Gris");
    jPanelGrisClaroTrazo.addMouseListener(new ventana_colores_jPanelGrisClaroTrazo_mouseAdapter(this));
    jPanelNegroTrazo.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelNegroTrazo.setToolTipText("Negro");
    jPanelNegroTrazo.addMouseListener(new ventana_colores_jPanelNegroTrazo_mouseAdapter(this));
    jPanelMarronRelleno.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelMarronRelleno.setToolTipText("Marr�n");
    jPanelMarronRelleno.addMouseListener(new ventana_colores_jPanelMarronRelleno_mouseAdapter(this));
    jPanelRojoTrazo.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelRojoTrazo.setToolTipText("Rojo");
    jPanelRojoTrazo.addMouseListener(new ventana_colores_jPanelRojoTrazo_mouseAdapter(this));
    jPanelRojoTrazo.setForeground(Color.black);
    jPanelBlancoRelleno.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelBlancoRelleno.setToolTipText("Blanco");
    jPanelBlancoRelleno.addMouseListener(new ventana_colores_jPanelBlancoRelleno_mouseAdapter(this));
    jPanelElegirTrazoPersonalizado.setLayout(borderLayout5);
    jPanel1.setLayout(flowLayout2);
    jPanelRojoRelleno.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelRojoRelleno.setToolTipText("Rojo");
    jPanelRojoRelleno.addMouseListener(new ventana_colores_jPanelRojoRelleno_mouseAdapter(this));
    jPanelNegroRelleno.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelNegroRelleno.setToolTipText("Negro");
    jPanelNegroRelleno.addMouseListener(new ventana_colores_jPanelNegroRelleno_mouseAdapter(this));
    jPanelVerdeRelleno.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelVerdeRelleno.setToolTipText("Verde");
    jPanelVerdeRelleno.addMouseListener(new ventana_colores_jPanelVerdeRelleno_mouseAdapter(this));
    jPanelRosaRelleno.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelRosaRelleno.setToolTipText("Rosa");
    jPanelRosaRelleno.addMouseListener(new ventana_colores_jPanelRosaRelleno_mouseAdapter(this));
    jLabel5.setText("Trazo:");
    jLabel8.setText("Personalizar relleno");
    jLabel4.setText("Relleno:");
    jPanelMostrarColorActualTrazo.setToolTipText("Color actual de trazo");
    jPanelMostrarColorActualTrazo.setBorder(BorderFactory.createLineBorder(Color.black));
    jPanelBeigeRelleno.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelBeigeRelleno.setToolTipText("Beige");
    jPanelBeigeRelleno.addMouseListener(new ventana_colores_jPanelBeigeRelleno_mouseAdapter(this));
    jPanelGrisClaroRelleno.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelGrisClaroRelleno.setToolTipText("Gris");
    jPanelGrisClaroRelleno.addMouseListener(new ventana_colores_jPanelGrisClaroRelleno_mouseAdapter(this));
    jPanelMostrarColorActualRelleno.setToolTipText("Color actual de relleno");
    jPanelMostrarColorActualRelleno.setBorder(BorderFactory.createLineBorder(Color.black));
    jPanelAmarilloRelleno.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelAmarilloRelleno.setToolTipText("Amarillo");
    jPanelAmarilloRelleno.addMouseListener(new ventana_colores_jPanelAmarilloRelleno_mouseAdapter(this));
    jPanelVioletaTrazo.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelVioletaTrazo.setToolTipText("Violeta");
    jPanelVioletaTrazo.addMouseListener(new ventana_colores_jPanelVioletaTrazo_mouseAdapter(this));
    jPanelRosaTrazo.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelRosaTrazo.setDebugGraphicsOptions(0);
    jPanelRosaTrazo.setToolTipText("Rosa");
    jPanelRosaTrazo.addMouseListener(new ventana_colores_jPanelRosaTrazo_mouseAdapter(this));
    jPanelElegirColores.setLayout(gridLayout3);
    jPanelColoresActuales.setLayout(borderLayout4);
    jLabel7.setText("Personalizar trazo");
    jPanelLimaRelleno.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelLimaRelleno.setToolTipText("Lima");
    jPanelLimaRelleno.addMouseListener(new ventana_colores_jPanelLimaRelleno_mouseAdapter(this));
    jPanelVioletaRelleno.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelVioletaRelleno.setToolTipText("Violeta");
    jPanelVioletaRelleno.addMouseListener(new ventana_colores_jPanelVioletaRelleno_mouseAdapter(this));
    jPanelColorTrazo.setLayout(borderLayout2);
    jPanelLimaTrazo.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelLimaTrazo.setToolTipText("Lima");
    jPanelLimaTrazo.addMouseListener(new ventana_colores_jPanelLimaTrazo_mouseAdapter(this));
    jPanelElegirColoresTrazo.setLayout(gridLayout4);
    jPanelNaranjaTrazo.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelNaranjaTrazo.setToolTipText("Naranja");
    jPanelNaranjaTrazo.addMouseListener(new ventana_colores_jPanelNaranjaTrazo_mouseAdapter(this));
    jPanelAzulRelleno.setBorder(BorderFactory.createRaisedBevelBorder());
    jPanelAzulRelleno.setDebugGraphicsOptions(0);
    jPanelAzulRelleno.setToolTipText("Azul");
    jPanelAzulRelleno.addMouseListener(new ventana_colores_jPanelAzulRelleno_mouseAdapter(this));
    this.setMinimumSize(new Dimension(106, 39));
    this.setPreferredSize(new Dimension(110, 139));
    this.addInternalFrameListener(new ventana_colores_this_internalFrameAdapter(this));
    jPanelElegirColoresTrazo.setBorder(titledBorder1);
    jPanelColoresActuales.setBorder(titledBorder2);
    jPanelColorRelleno.setBorder(titledBorder3);
    jPanel1.add(jLabel4, null);
    jPanel1.add(jPanelMostrarColorActualRelleno, null);
    jPanel1.add(jLabel5, null);
    jPanel1.add(jPanelMostrarColorActualTrazo, null);
    jPanelColor.add(jPanelColorTrazo, BorderLayout.NORTH);
    jPanelColoresActuales.add(jPanel1, BorderLayout.CENTER);
    jPanelColor.add(jPanelColoresActuales, BorderLayout.SOUTH);
    jPanelColorTrazo.add(jPanelElegirColoresTrazo, BorderLayout.CENTER);
    jPanelElegirColoresTrazo.add(jPanelNegroTrazo, null);
    jPanelElegirColoresTrazo.add(jPanelGrisClaroTrazo, null);
    jPanelElegirColoresTrazo.add(jPanelBeigeTrazo, null);
    jPanelElegirColoresTrazo.add(jPanelLimaTrazo, null);
    jPanelElegirColoresTrazo.add(jPanelAzulClaroTrazo, null);
    jPanelElegirColoresTrazo.add(jPanelVioletaTrazo, null);
    jPanelElegirColoresTrazo.add(jPanelMarronTrazo, null);
    jPanelElegirColoresTrazo.add(jPanelBlancoTrazo, null);
    jPanelElegirColoresTrazo.add(jPanelRojoTrazo, null);
    jPanelElegirColoresTrazo.add(jPanelAmarilloTrazo, null);
    jPanelElegirColoresTrazo.add(jPanelVerdeTrazo, null);
    jPanelElegirColoresTrazo.add(jPanelAzulTrazo, null);
    jPanelElegirColoresTrazo.add(jPanelRosaTrazo, null);
    jPanelElegirColoresTrazo.add(jPanelNaranjaTrazo, null);
    jPanelColorTrazo.add(jPanelElegirTrazoPersonalizado, BorderLayout.SOUTH);
    jPanelElegirTrazoPersonalizado.add(jPanelTrazoPersonalizado, BorderLayout.EAST);
    jPanelElegirTrazoPersonalizado.add(jLabel7, BorderLayout.WEST);
    jPanelColor.add(jPanelColorRelleno, BorderLayout.CENTER);
    jPanelRellenoPersonalizado.add(jPanelElegirRellenoPersonalizado, BorderLayout.EAST);
    jPanelRellenoPersonalizado.add(jLabel8, BorderLayout.CENTER);
    jPanelColorRelleno.add(jPanelElegirColores, BorderLayout.CENTER);
    jPanelColorRelleno.add(jPanelRellenoPersonalizado, BorderLayout.SOUTH);
    jPanelElegirColores.add(jPanelNegroRelleno, null);
    jPanelElegirColores.add(jPanelGrisClaroRelleno, null);
    jPanelElegirColores.add(jPanelBeigeRelleno, null);
    jPanelElegirColores.add(jPanelLimaRelleno, null);
    jPanelElegirColores.add(jPanelAzulClaroRelleno, null);
    jPanelElegirColores.add(jPanelVioletaRelleno, null);
    jPanelElegirColores.add(jPanelMarronRelleno, null);
    jPanelElegirColores.add(jPanelBlancoRelleno, null);
    jPanelElegirColores.add(jPanelRojoRelleno, null);
    jPanelElegirColores.add(jPanelAmarilloRelleno, null);
    jPanelElegirColores.add(jPanelVerdeRelleno, null);
    jPanelElegirColores.add(jPanelAzulRelleno, null);
    jPanelElegirColores.add(jPanelRosaRelleno, null);
    jPanelElegirColores.add(jPanelNaranjaRelleno, null);
    this.getContentPane().add(jPanelColor, BorderLayout.NORTH);
  }

  void jPanelNegroTrazo_mouseClicked(MouseEvent e)
  {
    jPanelMostrarColorActualTrazo.setBackground(negro);
    color_actual_trazo = negro;
    creador.setColorTrazo(color_actual_trazo);
  }

  void jPanelGrisClaroTrazo_mouseClicked(MouseEvent e)
  {
    jPanelMostrarColorActualTrazo.setBackground(gris);
    color_actual_trazo = gris;
    creador.setColorTrazo(color_actual_trazo);
  }

  void jPanelBeigeTrazo_mouseClicked(MouseEvent e) {
    jPanelMostrarColorActualTrazo.setBackground(beige);
    color_actual_trazo = beige;
    creador.setColorTrazo(color_actual_trazo);
  }

  void jPanelLimaTrazo_mouseClicked(MouseEvent e) {
    jPanelMostrarColorActualTrazo.setBackground(lima);
    color_actual_trazo = lima;
    creador.setColorTrazo(color_actual_trazo);
  }

  void jPanelAzulClaroTrazo_mouseClicked(MouseEvent e)
  {
    jPanelMostrarColorActualTrazo.setBackground(azul_claro);
    color_actual_trazo = azul_claro;
    creador.setColorTrazo(color_actual_trazo);
  }

  void jPanelVioletaTrazo_mouseClicked(MouseEvent e) {
    jPanelMostrarColorActualTrazo.setBackground(violeta);
    color_actual_trazo = violeta;
    creador.setColorTrazo(color_actual_trazo);
  }

  void jPanelMarronTrazo_mouseClicked(MouseEvent e) {
    jPanelMostrarColorActualTrazo.setBackground(marron);
    color_actual_trazo = marron;
    creador.setColorTrazo(color_actual_trazo);
  }

  void jPanelBlancoTrazo_mouseClicked(MouseEvent e) {
    jPanelMostrarColorActualTrazo.setBackground(blanco);
    color_actual_trazo = blanco;
    creador.setColorTrazo(color_actual_trazo);
  }

  void jPanelRojoTrazo_mouseClicked(MouseEvent e) {
    jPanelMostrarColorActualTrazo.setBackground(rojo);
    color_actual_trazo = rojo;
    creador.setColorTrazo(color_actual_trazo);
  }

  void jPanelAmarilloTrazo_mouseClicked(MouseEvent e) {
    jPanelMostrarColorActualTrazo.setBackground(amarillo);
    color_actual_trazo = amarillo;
    creador.setColorTrazo(color_actual_trazo);
  }

  void jPanelVerdeTrazo_mouseClicked(MouseEvent e) {
    jPanelMostrarColorActualTrazo.setBackground(verde);
    color_actual_trazo = verde;
    creador.setColorTrazo(color_actual_trazo);
  }

  void jPanelAzulTrazo_mouseClicked(MouseEvent e) {
    jPanelMostrarColorActualTrazo.setBackground(azul);
    color_actual_trazo = azul;
    creador.setColorTrazo(color_actual_trazo);
  }

  void jPanelRosaTrazo_mouseClicked(MouseEvent e) {
    jPanelMostrarColorActualTrazo.setBackground(rosa);
    color_actual_trazo = rosa;
    creador.setColorTrazo(color_actual_trazo);
  }

  void jPanelNaranjaTrazo_mouseClicked(MouseEvent e) {
    jPanelMostrarColorActualTrazo.setBackground(naranja);
    color_actual_trazo = naranja;
    creador.setColorTrazo(color_actual_trazo);
  }

  void jPanelNegroRelleno_mouseClicked(MouseEvent e) {
    if( creador.getTipoRelleno() == 0 || creador.getTipoRelleno() == 1 )
        {
          jPanelMostrarColorActualRelleno.setBackground(negro);
          color_actual_relleno = negro;
          creador.setColorRelleno(negro);
        }
        else
        {
            if( creador.getDefinirDegradado1() )
            {
              creador.setDegradado1(negro);
              creador.setDefinirDegradado1(false);
              creador.setDefinirDegradado2(true);
            }
            else
            {
              if (creador.getDefinirDegradado2())
              {
                creador.setDegradado2(negro);
                creador.setDefinirDegradado2(false);
                creador.setDefinirDegradado1(true);
              }
            }
        }
  }

  void jPanelGrisClaroRelleno_mouseClicked(MouseEvent e) {
    if( creador.getTipoRelleno() == 0 || creador.getTipoRelleno() == 1 )
        {
          jPanelMostrarColorActualRelleno.setBackground(gris);
          color_actual_relleno = gris;
          creador.setColorRelleno(gris);
        }
        else
        {
            if( creador.getDefinirDegradado1() )
            {
              creador.setDegradado1(gris);
              creador.setDefinirDegradado1(false);
              creador.setDefinirDegradado2(true);
            }
            else
            {
              if (creador.getDefinirDegradado2())
              {
                creador.setDegradado2(gris);
                creador.setDefinirDegradado2(false);
                creador.setDefinirDegradado1(true);
              }
            }
        }
  }

  void jPanelBeigeRelleno_mouseClicked(MouseEvent e) {
    if( creador.getTipoRelleno() == 0 || creador.getTipoRelleno() == 1 )
        {
          jPanelMostrarColorActualRelleno.setBackground(beige);
          color_actual_relleno = beige;
          creador.setColorRelleno(beige);
        }
        else
        {
            if( creador.getDefinirDegradado1() )
            {
              creador.setDegradado1(beige);
              creador.setDefinirDegradado1(false);
              creador.setDefinirDegradado2(true);
            }
            else
            {
              if (creador.getDefinirDegradado2())
              {
                creador.setDegradado2(beige);
                creador.setDefinirDegradado2(false);
                creador.setDefinirDegradado1(true);
              }
            }
        }
  }

  void jPanelLimaRelleno_mouseClicked(MouseEvent e) {
    if( creador.getTipoRelleno() == 0 || creador.getTipoRelleno() == 1 )
        {
          jPanelMostrarColorActualRelleno.setBackground(lima);
          color_actual_relleno = lima;
          creador.setColorRelleno(lima);
        }
        else
        {
            if( creador.getDefinirDegradado1() )
            {
              creador.setDegradado1(lima);
              creador.setDefinirDegradado1(false);
              creador.setDefinirDegradado2(true);
            }
            else
            {
              if (creador.getDefinirDegradado2())
              {
                creador.setDegradado2(lima);
                creador.setDefinirDegradado2(false);
                creador.setDefinirDegradado1(true);
              }
            }
        }
  }

  void jPanelAzulClaroRelleno_mouseClicked(MouseEvent e) {
    if( creador.getTipoRelleno() == 0 || creador.getTipoRelleno() == 1 )
        {
          jPanelMostrarColorActualRelleno.setBackground(azul_claro);
          color_actual_relleno = azul_claro;
          creador.setColorRelleno(azul_claro);
        }
        else
        {
            if( creador.getDefinirDegradado1() )
            {
              creador.setDegradado1(azul_claro);
              creador.setDefinirDegradado1(false);
              creador.setDefinirDegradado2(true);
            }
            else
            {
              if (creador.getDefinirDegradado2())
              {
                creador.setDegradado2(azul_claro);
                creador.setDefinirDegradado2(false);
                creador.setDefinirDegradado1(true);
              }
            }
        }
  }

  void jPanelVioletaRelleno_mouseClicked(MouseEvent e) {
    if( creador.getTipoRelleno() == 0 || creador.getTipoRelleno() == 1 )
        {
          jPanelMostrarColorActualRelleno.setBackground(violeta);
          color_actual_relleno = violeta;
          creador.setColorRelleno(violeta);
        }
        else
        {
            if( creador.getDefinirDegradado1() )
            {
              creador.setDegradado1(violeta);
              creador.setDefinirDegradado1(false);
              creador.setDefinirDegradado2(true);
            }
            else
            {
              if (creador.getDefinirDegradado2())
              {
                creador.setDegradado2(violeta);
                creador.setDefinirDegradado2(false);
                creador.setDefinirDegradado1(true);
              }
            }
        }
  }

  void jPanelMarronRelleno_mouseClicked(MouseEvent e) {
    if( creador.getTipoRelleno() == 0 || creador.getTipoRelleno() == 1 )
        {
          jPanelMostrarColorActualRelleno.setBackground(marron);
          color_actual_relleno = marron;
          creador.setColorRelleno(marron);
        }
        else
        {
            if( creador.getDefinirDegradado1() )
            {
              creador.setDegradado1(marron);
              creador.setDefinirDegradado1(false);
              creador.setDefinirDegradado2(true);
            }
            else
            {
              if (creador.getDefinirDegradado2())
              {
                creador.setDegradado2(marron);
                creador.setDefinirDegradado2(false);
                creador.setDefinirDegradado1(true);
              }
            }
        }
  }

  void jPanelBlancoRelleno_mouseClicked(MouseEvent e) {
    if( creador.getTipoRelleno() == 0 || creador.getTipoRelleno() == 1 )
        {
          jPanelMostrarColorActualRelleno.setBackground(blanco);
          color_actual_relleno = blanco;
          creador.setColorRelleno(blanco);
        }
        else
        {
            if( creador.getDefinirDegradado1() )
            {
              creador.setDegradado1(blanco);
              creador.setDefinirDegradado1(false);
              creador.setDefinirDegradado2(true);
            }
            else
            {
              if (creador.getDefinirDegradado2())
              {
                creador.setDegradado2(blanco);
                creador.setDefinirDegradado2(false);
                creador.setDefinirDegradado1(true);
              }
            }
        }
  }

  void jPanelRojoRelleno_mouseClicked(MouseEvent e) {
    if( creador.getTipoRelleno() == 0 || creador.getTipoRelleno() == 1 )
        {
          jPanelMostrarColorActualRelleno.setBackground(rojo);
          color_actual_relleno = rojo;
          creador.setColorRelleno(rojo);
        }
        else
        {
            if( creador.getDefinirDegradado1() )
            {
              creador.setDegradado1(rojo);
              creador.setDefinirDegradado1(false);
              creador.setDefinirDegradado2(true);
            }
            else
            {
              if (creador.getDefinirDegradado2())
              {
                creador.setDegradado2(rojo);
                creador.setDefinirDegradado2(false);
                creador.setDefinirDegradado1(true);
              }
            }
        }
  }

  void jPanelAmarilloRelleno_mouseClicked(MouseEvent e) {
    if( creador.getTipoRelleno() == 0 || creador.getTipoRelleno() == 1 )
        {
          jPanelMostrarColorActualRelleno.setBackground(amarillo);
          color_actual_relleno = amarillo;
          creador.setColorRelleno(amarillo);
        }
        else
        {
            if( creador.getDefinirDegradado1() )
            {
              creador.setDegradado1(amarillo);
              creador.setDefinirDegradado1(false);
              creador.setDefinirDegradado2(true);
            }
            else
            {
              if (creador.getDefinirDegradado2())
              {
                creador.setDegradado2(amarillo);
                creador.setDefinirDegradado2(false);
                creador.setDefinirDegradado1(true);
              }
            }
        }
  }

  void jPanelVerdeRelleno_mouseClicked(MouseEvent e) {
    if( creador.getTipoRelleno() == 0 || creador.getTipoRelleno() == 1 )
        {
          jPanelMostrarColorActualRelleno.setBackground(verde);
          color_actual_relleno = verde;
          creador.setColorRelleno(verde);
        }
        else
        {
            if( creador.getDefinirDegradado1() )
            {
              creador.setDegradado1(verde);
              creador.setDefinirDegradado1(false);
              creador.setDefinirDegradado2(true);
            }
            else
            {
              if (creador.getDefinirDegradado2())
              {
                creador.setDegradado2(verde);
                creador.setDefinirDegradado2(false);
                creador.setDefinirDegradado1(true);
              }
            }
        }
  }

  void jPanelAzulRelleno_mouseClicked(MouseEvent e) {
    if( creador.getTipoRelleno() == 0 || creador.getTipoRelleno() == 1 )
        {
          jPanelMostrarColorActualRelleno.setBackground(azul);
          color_actual_relleno = azul;
          creador.setColorRelleno(azul);
        }
        else
        {
            if( creador.getDefinirDegradado1() )
            {
              creador.setDegradado1(azul);
              creador.setDefinirDegradado1(false);
              creador.setDefinirDegradado2(true);
            }
            else
            {
              if (creador.getDefinirDegradado2())
              {
                creador.setDegradado2(azul);
                creador.setDefinirDegradado2(false);
                creador.setDefinirDegradado1(true);
              }
            }
        }
  }


  void jPanelNaranjaRelleno_mouseClicked(MouseEvent e) {
    if( creador.getTipoRelleno() == 0 || creador.getTipoRelleno() == 1 )
        {
          jPanelMostrarColorActualRelleno.setBackground(naranja);
          color_actual_relleno = naranja;
          creador.setColorRelleno(naranja);
        }
        else
        {
            if( creador.getDefinirDegradado1() )
            {
              creador.setDegradado1(naranja);
              creador.setDefinirDegradado1(false);
              creador.setDefinirDegradado2(true);
            }
            else
            {
              if (creador.getDefinirDegradado2())
              {
                creador.setDegradado2(naranja);
                creador.setDefinirDegradado2(false);
                creador.setDefinirDegradado1(true);
              }
            }
        }
  }

  void jPanelTrazoPersonalizado_mouseClicked(MouseEvent e) {
// Personalizar el color del trazo es una parte optativa
    try
    {
      JColorChooser trazoPersonalizado = new JColorChooser();
      trazoPersonalizado.setVisible(true);
      trazo_personalizado = trazoPersonalizado.showDialog(null,"Seleccione el color del trazo", trazo_personalizado);
      if( trazo_personalizado != null )
      {
        jPanelMostrarColorActualTrazo.setBackground(trazo_personalizado);
        color_actual_trazo = trazo_personalizado;
        creador.setColorTrazo(color_actual_trazo);
        jPanelTrazoPersonalizado.setBackground(color_actual_trazo);
      }
    }
    catch(Exception exp)
    {
      JOptionPane.showMessageDialog(this, "Error al leer el color.", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
  }

  void jPanelElegirRellenoPersonalizado_mouseClicked(MouseEvent e) {
  // Personalizar el color del relleno es una parte optativa
    try
    {
      JColorChooser colorPersonalizado = new JColorChooser();
      colorPersonalizado.setVisible(true);
      relleno_personalizado = colorPersonalizado.showDialog(null,"Seleccione el color del relleno", relleno_personalizado);
      if( relleno_personalizado != null )
      {
        jPanelMostrarColorActualRelleno.setBackground(relleno_personalizado);
        color_actual_relleno = relleno_personalizado;
        creador.setColorRelleno(color_actual_relleno);
        jPanelElegirRellenoPersonalizado.setBackground(color_actual_relleno);
      }
    }
    catch(Exception exp)
    {
      JOptionPane.showMessageDialog(this, "Error al leer el color.", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
  }

  void this_internalFrameActivated(InternalFrameEvent e) {
    creador.jMenuGuardar.setEnabled(false);
    creador.jMenuImprimir.setEnabled(false);
    creador.jMenuHistograma.setEnabled(false);
    creador.jMenuDeshacer.setEnabled(false);
    creador.jMenuRehacer.setEnabled(false);
    creador.setUltimaVentanaImagenSeleccionada(null);
  }

  void jPanelRosaRelleno_mouseClicked(MouseEvent e) {
    if( creador.getTipoRelleno() == 0 || creador.getTipoRelleno() == 1 )
       {
         jPanelMostrarColorActualRelleno.setBackground(rosa);
         color_actual_relleno = rosa;
         creador.setColorRelleno(rosa);
       }
       else
       {
           if( creador.getDefinirDegradado1() )
           {
             creador.setDegradado1(rosa);
             creador.setDefinirDegradado1(false);
             creador.setDefinirDegradado2(true);
           }
           else
           {
             if (creador.getDefinirDegradado2())
             {
               creador.setDegradado2(rosa);
               creador.setDefinirDegradado2(false);
               creador.setDefinirDegradado1(true);
             }
           }
       }
  }

}

class ventana_colores_jPanelNegroTrazo_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelNegroTrazo_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelNegroTrazo_mouseClicked(e);
  }
}

class ventana_colores_jPanelGrisClaroTrazo_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelGrisClaroTrazo_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelGrisClaroTrazo_mouseClicked(e);
  }
}

class ventana_colores_jPanelBeigeTrazo_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelBeigeTrazo_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelBeigeTrazo_mouseClicked(e);
  }
}

class ventana_colores_jPanelLimaTrazo_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelLimaTrazo_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelLimaTrazo_mouseClicked(e);
  }
}

class ventana_colores_jPanelAzulClaroTrazo_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelAzulClaroTrazo_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelAzulClaroTrazo_mouseClicked(e);
  }
}

class ventana_colores_jPanelVioletaTrazo_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelVioletaTrazo_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelVioletaTrazo_mouseClicked(e);
  }
}

class ventana_colores_jPanelMarronTrazo_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelMarronTrazo_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelMarronTrazo_mouseClicked(e);
  }
}

class ventana_colores_jPanelBlancoTrazo_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelBlancoTrazo_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelBlancoTrazo_mouseClicked(e);
  }
}

class ventana_colores_jPanelRojoTrazo_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelRojoTrazo_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelRojoTrazo_mouseClicked(e);
  }
}

class ventana_colores_jPanelAmarilloTrazo_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelAmarilloTrazo_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelAmarilloTrazo_mouseClicked(e);
  }
}

class ventana_colores_jPanelVerdeTrazo_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelVerdeTrazo_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelVerdeTrazo_mouseClicked(e);
  }
}

class ventana_colores_jPanelAzulTrazo_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelAzulTrazo_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelAzulTrazo_mouseClicked(e);
  }
}

class ventana_colores_jPanelRosaTrazo_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelRosaTrazo_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelRosaTrazo_mouseClicked(e);
  }
}

class ventana_colores_jPanelNaranjaTrazo_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelNaranjaTrazo_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelNaranjaTrazo_mouseClicked(e);
  }
}

class ventana_colores_jPanelNegroRelleno_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelNegroRelleno_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelNegroRelleno_mouseClicked(e);
  }
}

class ventana_colores_jPanelGrisClaroRelleno_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelGrisClaroRelleno_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelGrisClaroRelleno_mouseClicked(e);
  }
}

class ventana_colores_jPanelBeigeRelleno_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelBeigeRelleno_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelBeigeRelleno_mouseClicked(e);
  }
}

class ventana_colores_jPanelLimaRelleno_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelLimaRelleno_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelLimaRelleno_mouseClicked(e);
  }
}

class ventana_colores_jPanelAzulClaroRelleno_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelAzulClaroRelleno_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelAzulClaroRelleno_mouseClicked(e);
  }
}

class ventana_colores_jPanelVioletaRelleno_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelVioletaRelleno_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelVioletaRelleno_mouseClicked(e);
  }
}

class ventana_colores_jPanelMarronRelleno_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelMarronRelleno_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelMarronRelleno_mouseClicked(e);
  }
}

class ventana_colores_jPanelBlancoRelleno_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelBlancoRelleno_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelBlancoRelleno_mouseClicked(e);
  }
}

class ventana_colores_jPanelRojoRelleno_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelRojoRelleno_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelRojoRelleno_mouseClicked(e);
  }
}

class ventana_colores_jPanelAmarilloRelleno_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelAmarilloRelleno_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelAmarilloRelleno_mouseClicked(e);
  }
}

class ventana_colores_jPanelVerdeRelleno_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelVerdeRelleno_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelVerdeRelleno_mouseClicked(e);
  }
}

class ventana_colores_jPanelAzulRelleno_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelAzulRelleno_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelAzulRelleno_mouseClicked(e);
  }
}

class ventana_colores_jPanelNaranjaRelleno_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelNaranjaRelleno_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelNaranjaRelleno_mouseClicked(e);
  }
}

class ventana_colores_jPanelTrazoPersonalizado_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelTrazoPersonalizado_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelTrazoPersonalizado_mouseClicked(e);
  }
}

class ventana_colores_jPanelElegirRellenoPersonalizado_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelElegirRellenoPersonalizado_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelElegirRellenoPersonalizado_mouseClicked(e);
  }
}

class ventana_colores_this_internalFrameAdapter extends javax.swing.event.InternalFrameAdapter {
  ventana_colores adaptee;

  ventana_colores_this_internalFrameAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void internalFrameActivated(InternalFrameEvent e) {
    adaptee.this_internalFrameActivated(e);
  }
}

class ventana_colores_jPanelRosaRelleno_mouseAdapter extends java.awt.event.MouseAdapter {
  ventana_colores adaptee;

  ventana_colores_jPanelRosaRelleno_mouseAdapter(ventana_colores adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jPanelRosaRelleno_mouseClicked(e);
  }
}
