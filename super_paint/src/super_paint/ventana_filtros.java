package super_paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.awt.image.ShortLookupTable;
import java.awt.image.LookupOp;
import java.awt.image.ColorConvertOp;
import java.awt.color.ColorSpace;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import javax.swing.ButtonGroup;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import javax.swing.table.DefaultTableModel;
import javax.swing.SpinnerNumberModel;
import java.awt.image.BandCombineOp;
import java.awt.image.WritableRaster;


/**
 * <p>Título: Práctica de Sistemas Multimedia</p>
 * <p>Descripción: Práctica de Sistemas Multimedia</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Empresa: Piratas Sin Fronteras S.A.</p>
 * @author Francisco Jesús Delgado Almirón
 * @version 1.0
 */

public class ventana_filtros extends JInternalFrame
{
  Ventana_imagen invocador;

  private LookupOp operacion_negativo;

  private mi_LookupOp filtro_lookup;
  private mi_RescaleOp filtro_brillo;
  private mi_ConvolveOp filtro_convolve;
  private mi_AffineTransformOp filtro_afine;
  private mi_BandCombineOp filtro_bandas;

  private BufferedImage original = null, imgSource, imgdest;
  private short[] invertido = new short[256], identidad = new short[256], funcion_contraste = new short[256];
  private double K3 = 255.0 / (   1.0 / (  1.0  +  Math.pow( 128.0/255.0 , 2.0)));

  ButtonGroup grupo_botones = new ButtonGroup();

  BorderLayout borderLayout1 = new BorderLayout();
  JTabbedPane jTabbedPane1 = new JTabbedPane();
  JPanel jPanelBrillo = new JPanel();
  JPanel jPanelNegativo = new JPanel();
  JPanel jPanelByN = new JPanel();
  JPanel jPanelSuavizado = new JPanel();
  JPanel jPanelBandCombine = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  Lienzo_no_dibujar jLienzoBrillo;
  JPanel jPanel7 = new JPanel();
  JSlider brillo = new JSlider();
  FlowLayout flowLayout1 = new FlowLayout();
  JButton bAceptar = new JButton();
  JButton bCancelar = new JButton();
  JLabel lBrillo = new JLabel();
  BorderLayout borderLayout3 = new BorderLayout();
  Lienzo_no_dibujar jLienzoNegativo;
  JPanel jPanel2 = new JPanel();
  JCheckBox jCheckBox1 = new JCheckBox();
  JCheckBox jCheckBox2 = new JCheckBox();
  JCheckBox jCheckBox3 = new JCheckBox();
  FlowLayout flowLayout2 = new FlowLayout();
  JButton bAceptarNegativo = new JButton();
  JButton bCancelarNegativo = new JButton();
  Lienzo_no_dibujar jLienzoByN;
  BorderLayout borderLayout4 = new BorderLayout();
  JPanel jPanel8 = new JPanel();
  JCheckBox cbByN = new JCheckBox();
  JButton bAceptarByN = new JButton();
  JButton bCancelarByN = new JButton();
  BorderLayout borderLayout5 = new BorderLayout();
  Lienzo_no_dibujar jLienzoSuavizado;
  JPanel jPanel4 = new JPanel();
  BorderLayout borderLayout6 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  Lienzo_no_dibujar jPanelLienzoBandCombine;
  DefaultTableModel modeloTabla = new DefaultTableModel();
  JTable jTable1 = new JTable(modeloTabla);
  JButton bAceptarBandCombine = new JButton();
  JButton bCancelarBandCombine = new JButton();
  BorderLayout borderLayout7 = new BorderLayout();
  JButton bSuavizar = new JButton();
  JButton bAceptarSuavizado = new JButton();
  JButton bCancelarSuavizado = new JButton();
  JPanel jPanelRealce = new JPanel();
  BorderLayout borderLayout8 = new BorderLayout();
  JPanel jPanel5 = new JPanel();
  Lienzo_no_dibujar jPanelLienzoRealce;
  JButton bRealzar = new JButton();
  JButton bAceptarRealce = new JButton();
  JButton bCancelarRealce = new JButton();
  JPanel jPanelFronteras = new JPanel();
  JPanel jPanel9 = new JPanel();
  BorderLayout borderLayout9 = new BorderLayout();
  Lienzo_no_dibujar jPaneLienzoFronteras;
  JCheckBox cbFronteras = new JCheckBox();
  JButton bAceptarFronteras = new JButton();
  JButton bCancelarFronteras = new JButton();
  BorderLayout borderLayout10 = new BorderLayout();

  JPanel jPanel11 = new JPanel();
  JPanel jPanelRotacion = new JPanel();
  BorderLayout borderLayout11 = new BorderLayout();
  Lienzo_no_dibujar jPanelLienzoRotacion;
  JPanel jPanel12 = new JPanel();
  JRadioButton rbGirar90 = new JRadioButton();
  JRadioButton rbGirar180 = new JRadioButton();
  JRadioButton rbGirar270 = new JRadioButton();
  JRadioButton rbGirar360 = new JRadioButton();
  JButton bAceptarRotacion = new JButton();
  JButton bCancelarRotacion = new JButton();
  JPanel jPanelEscalado = new JPanel();
  BorderLayout borderLayout12 = new BorderLayout();
  Lienzo_no_dibujar jPanelLienzoEscalado;
  JPanel jPanel10 = new JPanel();
  /*
   Propiedades para el jspinner:
   Valor actual: 10
   Mínimo: 1
   Máximo: 100
   Incremento: 1
  */
  SpinnerNumberModel modeloSpin = new SpinnerNumberModel(10, 1, 100, 1);
  /*
   Propiedades para el jspinner:
   Valor actual: 0
   Mínimo: 0
   Máximo: 360
   Incremento: 1
  */
  SpinnerNumberModel modelogrados = new SpinnerNumberModel(0, 0, 360, 1);
  JSpinner spinerEscalado = new JSpinner(modeloSpin);
  JLabel lEscalado = new JLabel();
  JButton bAceptarEscalado = new JButton();
  JButton bCancelarEscalado = new JButton();
  JButton jButton3 = new JButton();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JCheckBox cbAplicarBandCombine = new JCheckBox();
  JScrollPane jScrollPane1 = new JScrollPane();
  JPanel jPanelContraste = new JPanel();
  BorderLayout borderLayout13 = new BorderLayout();
  JPanel jPanel3 = new JPanel();
  Lienzo_no_dibujar jPanelLienzoBrilloyContraste;
  JLabel lContraste = new JLabel();
  JSlider sliderContraste = new JSlider();
  JButton bAceptarContraste = new JButton();
  JButton bCancelarContraste = new JButton();
  JPanel jPanelShear = new JPanel();
  JButton bAceptarShear = new JButton();
  JPanel jPanel13 = new JPanel();
  JSlider sliderShear = new JSlider();
  JButton bCancelarShear = new JButton();
  BorderLayout borderLayout14 = new BorderLayout();
  Lienzo_no_dibujar jPanelLienzoShear;
  JLabel jLabel3 = new JLabel();
  JSpinner sGrados = new JSpinner(modelogrados);

  public ventana_filtros(Ventana_imagen v_im) {
    try {
      invocador = v_im;
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {

    ImageIcon i = new ImageIcon("iconos/imagen.gif");
    this.setFrameIcon(i);

    rbGirar90.addActionListener(new ventana_filtros_rbGirar90_actionAdapter(this));
    rbGirar180.addActionListener(new ventana_filtros_rbGirar180_actionAdapter(this));
    rbGirar270.addActionListener(new ventana_filtros_rbGirar270_actionAdapter(this));
    rbGirar360.addActionListener(new ventana_filtros_rbGirar360_actionAdapter(this));
    bAceptarRotacion.setText("Aceptar");
    bAceptarRotacion.addActionListener(new ventana_filtros_bAceptarRotacion_actionAdapter(this));
    bCancelarRotacion.setToolTipText("");
    bCancelarRotacion.setText("Cancelar");
    bCancelarRotacion.addActionListener(new ventana_filtros_bCancelarRotacion_actionAdapter(this));
    jPanelEscalado.setLayout(borderLayout12);
    jPanel10.setMaximumSize(new Dimension(100, 100));
    jPanel10.setMinimumSize(new Dimension(100, 100));
    jPanel10.setPreferredSize(new Dimension(100, 100));
    lEscalado.setText("Escalado: 1");
    spinerEscalado.setMaximumSize(new Dimension(40, 30));
    spinerEscalado.setPreferredSize(new Dimension(35, 18));
    spinerEscalado.addChangeListener(new ventana_filtros_spinerEscalado_changeAdapter(this));
    bAceptarEscalado.setText("Aceptar");
    bAceptarEscalado.addActionListener(new ventana_filtros_bAceptarEscalado_actionAdapter(this));
    bCancelarEscalado.setText("Cancelar");
    bCancelarEscalado.addActionListener(new ventana_filtros_bCancelarEscalado_actionAdapter(this));
    jButton3.setText("Cancelar");
    jButton3.addActionListener(new ventana_filtros_jButton3_actionAdapter(this));
    jLabel1.setText("Tabla de");
    jLabel2.setText("combinación");
    cbAplicarBandCombine.setText("Aplicar");
    cbAplicarBandCombine.addActionListener(new ventana_filtros_cbAplicarBandCombine_actionAdapter(this));
    bAceptarBandCombine.addActionListener(new ventana_filtros_bAceptarBandCombine_actionAdapter(this));
    bCancelarBandCombine.addActionListener(new ventana_filtros_bCancelarBandCombine_actionAdapter(this));
    jPanelContraste.setLayout(borderLayout13);
    jPanel3.setMaximumSize(new Dimension(100, 100));
    jPanel3.setMinimumSize(new Dimension(100, 100));
    jPanel3.setPreferredSize(new Dimension(100, 100));
    lContraste.setText("Constraste: 1");
    sliderContraste.setOrientation(JSlider.HORIZONTAL);
    sliderContraste.setMaximum(100);
    sliderContraste.setMinimum(0);
    sliderContraste.setMaximumSize(new Dimension(80, 80));
    sliderContraste.setMinimumSize(new Dimension(80, 80));
    sliderContraste.setPreferredSize(new Dimension(110, 20));
    sliderContraste.setValue(1);
    sliderContraste.addChangeListener(new ventana_filtros_sliderContraste_changeAdapter(this));
    bAceptarContraste.setText("Aceptar");
    bAceptarContraste.addActionListener(new ventana_filtros_bAceptarContraste_actionAdapter(this));
    bCancelarContraste.setText("Cancelar");
    bCancelarContraste.addActionListener(new ventana_filtros_bCancelarContraste_actionAdapter(this));
    bAceptarShear.setText("Aceptar");
    bAceptarShear.addActionListener(new ventana_filtros_bAceptarShear_actionAdapter(this));
    jPanel13.setPreferredSize(new Dimension(100, 100));
    jPanel13.setMinimumSize(new Dimension(100, 100));
    jPanel13.setMaximumSize(new Dimension(100, 100));
    sliderShear.setOrientation(JSlider.HORIZONTAL);
    sliderShear.setMaximum(10);
    sliderShear.setMaximumSize(new Dimension(80, 80));
    sliderShear.setMinimumSize(new Dimension(80, 80));
    sliderShear.setPreferredSize(new Dimension(110, 20));
    sliderShear.setValue(1);
    sliderShear.addChangeListener(new ventana_filtros_sliderShear_changeAdapter(this));
    bCancelarShear.setText("Cancelar");
    bCancelarShear.addActionListener(new ventana_filtros_bCancelarShear_actionAdapter(this));
    jPanelShear.setLayout(borderLayout14);
    jLabel3.setText("Grados:");
    sGrados.addChangeListener(new ventana_filtros_sGrados_changeAdapter(this));
    jPanel10.add(lEscalado, null);
    grupo_botones.add(rbGirar90);
    grupo_botones.add(rbGirar180);
    grupo_botones.add(rbGirar270);
    grupo_botones.add(rbGirar360);

    modeloTabla.addColumn("C1");
    modeloTabla.addColumn("C2");
    modeloTabla.addColumn("C3");
    Object [] fila1 = new Object[3], fila2 = new Object[3], fila3 = new Object[3];
    fila1[0] = "1.0";
    fila1[1] = "0.0";
    fila1[2] = "0.0";
    fila2[0] = "0.0";
    fila2[1] = "1.0";
    fila2[2] = "0.0";
    fila3[0] = "0.0";
    fila3[1] = "0.0";
    fila3[2] = "1.0";
    modeloTabla.addRow( fila1 );
    modeloTabla.addRow( fila2 );
    modeloTabla.addRow( fila3 );

    original = invocador.jPanelDibujar.getImagen();

    // ***** Para el efecto negativo *****
    for (int j = 0; j < 256; j++)
    {
      invertido[j] = (short) (256 - j - 1); // Negativo
      identidad[j] = (short)j; // identidad
    }
    // ***********************************

    jPanelLienzoShear = new Lienzo_no_dibujar(invocador.jPanelDibujar.getImagen());
    jLienzoBrillo = new Lienzo_no_dibujar(invocador.jPanelDibujar.getImagen());
    jLienzoNegativo = new Lienzo_no_dibujar(invocador.jPanelDibujar.getImagen());
    jLienzoByN = new Lienzo_no_dibujar(invocador.jPanelDibujar.getImagen());
    jLienzoSuavizado = new Lienzo_no_dibujar(invocador.jPanelDibujar.getImagen());
    jLienzoSuavizado = new Lienzo_no_dibujar(invocador.jPanelDibujar.getImagen());
    jPanelLienzoRealce = new Lienzo_no_dibujar(invocador.jPanelDibujar.getImagen());
    jPaneLienzoFronteras = new Lienzo_no_dibujar(invocador.jPanelDibujar.getImagen());
    jPanelLienzoRotacion = new Lienzo_no_dibujar(invocador.jPanelDibujar.getImagen());
    jPanelLienzoEscalado = new Lienzo_no_dibujar(invocador.jPanelDibujar.getImagen());
    jPanelLienzoBandCombine = new Lienzo_no_dibujar(invocador.jPanelDibujar.getImagen());
    jPanelLienzoBrilloyContraste = new Lienzo_no_dibujar(invocador.jPanelDibujar.getImagen());

    this.setTitle("Aplicar filtros a: " + invocador.getTitle().substring(0, invocador.getTitle().length()-15));
    this.addInternalFrameListener(new ventana_filtros_this_internalFrameAdapter(this));
    this.setClosable(true);
    this.getContentPane().setLayout(borderLayout1);

    brillo.setValue(0);
    brillo.addMouseMotionListener(new ventana_filtros_brillo_mouseMotionAdapter(this));
    jPanelBrillo.setLayout(borderLayout2);
    jLienzoBrillo.setBorder(BorderFactory.createEtchedBorder());
    jPanel7.setBorder(null);
    jPanel7.setMaximumSize(new Dimension(100, 100));
    jPanel7.setMinimumSize(new Dimension(100, 100));
    jPanel7.setPreferredSize(new Dimension(100, 100));
    jPanel7.setLayout(flowLayout1);
    bAceptar.setText("Aceptar");
    bAceptar.addActionListener(new ventana_filtros_bAceptar_actionAdapter(this));
    bCancelar.setText("Cancelar");
    bCancelar.addActionListener(new ventana_filtros_bCancelar_actionAdapter(this));
    brillo.setMaximum(255);
    brillo.setMinimum(-255);
    brillo.setPaintTrack(true);
    brillo.setMaximumSize(new Dimension(80, 80));
    brillo.setMinimumSize(new Dimension(80, 80));
    brillo.setPreferredSize(new Dimension(110, 20));
    lBrillo.setText("Brillo: 0");
    jPanelNegativo.setLayout(borderLayout3);
    jPanel2.setBorder(null);
    jPanel2.setMaximumSize(new Dimension(100, 100));
    jPanel2.setMinimumSize(new Dimension(100, 100));
    jPanel2.setPreferredSize(new Dimension(100, 100));
    jPanel2.setLayout(flowLayout2);
    jCheckBox1.setText("Inventir Rojo");
    jCheckBox1.addActionListener(new ventana_filtros_jCheckBox1_actionAdapter(this));
    jCheckBox2.setText("Invertir Verde");
    jCheckBox2.addActionListener(new ventana_filtros_jCheckBox2_actionAdapter(this));
    jCheckBox3.setText("Invertir Azul");
    jCheckBox3.addActionListener(new ventana_filtros_jCheckBox3_actionAdapter(this));
    jLienzoNegativo.setBorder(BorderFactory.createEtchedBorder());
    bAceptarNegativo.setText("Aceptar");
    bAceptarNegativo.addActionListener(new ventana_filtros_bAceptarNegativo_actionAdapter(this));
    bCancelarNegativo.setText("Cancelar");
    bCancelarNegativo.addActionListener(new ventana_filtros_bCancelarNegativo_actionAdapter(this));
    jPanelByN.setLayout(borderLayout4);
    jLienzoByN.setBorder(BorderFactory.createEtchedBorder());
    cbByN.setText("Blanco y negro");
    cbByN.addActionListener(new ventana_filtros_cbByN_actionAdapter(this));
    jPanel8.setMaximumSize(new Dimension(100, 100));
    jPanel8.setMinimumSize(new Dimension(100, 100));
    jPanel8.setPreferredSize(new Dimension(100, 100));
    bAceptarByN.setText("Aceptar");
    bAceptarByN.addActionListener(new ventana_filtros_bAceptarByN_actionAdapter(this));
    bCancelarByN.setText("Cancelar");
    bCancelarByN.addActionListener(new ventana_filtros_bCancelarByN_actionAdapter(this));
    jPanelSuavizado.setLayout(borderLayout5);
    jLienzoSuavizado.setBorder(BorderFactory.createEtchedBorder());
    jPanel4.setMaximumSize(new Dimension(100, 100));
    jPanel4.setMinimumSize(new Dimension(100, 100));
    jPanel4.setPreferredSize(new Dimension(100, 100));
    jPanelBandCombine.setLayout(borderLayout6);
    jPanel1.setMaximumSize(new Dimension(100, 100));
    jPanel1.setMinimumSize(new Dimension(100, 100));
    jPanel1.setPreferredSize(new Dimension(100, 100));
    jPanelLienzoBandCombine.setBorder(BorderFactory.createEtchedBorder());
    jTable1.setMaximumSize(new Dimension(98, 100));
    jTable1.setMinimumSize(new Dimension(98, 100));
    jTable1.setPreferredSize(new Dimension(98, 48));
    bAceptarBandCombine.setText("Aceptar");
    bCancelarBandCombine.setText("Cancelar");

    bSuavizar.setText("Suavizar");
    bSuavizar.addActionListener(new ventana_filtros_bSuavizar_actionAdapter(this));
    bAceptarSuavizado.setText("Aceptar");
    bAceptarSuavizado.addActionListener(new ventana_filtros_bAceptarSuavizado_actionAdapter(this));
    bCancelarSuavizado.setText("Cancelar");
    bCancelarSuavizado.addActionListener(new ventana_filtros_bCancelarSuavizado_actionAdapter(this));
    jPanelRealce.setLayout(borderLayout8);
    jPanel5.setMaximumSize(new Dimension(100, 100));
    jPanel5.setMinimumSize(new Dimension(100, 100));
    jPanel5.setPreferredSize(new Dimension(100, 100));
    bRealzar.setText("Realzar");
    bRealzar.addActionListener(new ventana_filtros_bRealzar_actionAdapter(this));
    bAceptarRealce.setText("Aceptar");
    bAceptarRealce.addActionListener(new ventana_filtros_bAceptarRealce_actionAdapter(this));
    bCancelarRealce.setText("Cancelar");
    bCancelarRealce.addActionListener(new ventana_filtros_bCancelarRealce_actionAdapter(this));
    jPanelFronteras.setLayout(borderLayout9);
    jPanel9.setMaximumSize(new Dimension(100, 100));
    jPanel9.setMinimumSize(new Dimension(100, 100));
    jPanel9.setPreferredSize(new Dimension(100, 100));
    jPanel9.setRequestFocusEnabled(true);
    cbFronteras.setText("Detectar front.");
    cbFronteras.addActionListener(new ventana_filtros_cbFronteras_actionAdapter(this));
    bAceptarFronteras.setText("Aceptar");
    bAceptarFronteras.addActionListener(new ventana_filtros_bAceptarFronteras_actionAdapter(this));
    bCancelarFronteras.setText("Cancelar");
    bCancelarFronteras.addActionListener(new ventana_filtros_bCancelarFronteras_actionAdapter(this));

    jPanel11.setMaximumSize(new Dimension(100, 100));
    jPanel11.setMinimumSize(new Dimension(100, 100));
    jPanel11.setPreferredSize(new Dimension(100, 100));
    jPanelRotacion.setLayout(borderLayout11);
    jPanel12.setMaximumSize(new Dimension(100, 100));
    jPanel12.setMinimumSize(new Dimension(100, 100));
    jPanel12.setPreferredSize(new Dimension(100, 100));
    rbGirar90.setText("Girar 90º");
    rbGirar180.setText("Girar 180º");
    rbGirar270.setText("Girar 270º");
    rbGirar360.setText("Girar 360º");
    jPanel7.add(lBrillo, null);
    this.getContentPane().add(jTabbedPane1,  BorderLayout.CENTER);
    jTabbedPane1.add(jPanelBrillo,  "Brillo");
    jPanelBrillo.add(jLienzoBrillo, BorderLayout.CENTER);
    jPanelBrillo.add(jPanel7,  BorderLayout.EAST);
    jPanel7.add(brillo, null);
    jPanel7.add(bAceptar, null);
    jPanel7.add(bCancelar, null);
    jTabbedPane1.add(jPanelNegativo,  "Negativo");
    jTabbedPane1.add(jPanelByN,  "Blanco y negro");
    jPanelByN.add(jLienzoByN,  BorderLayout.CENTER);
    jPanelByN.add(jPanel8,  BorderLayout.EAST);
    jPanel8.add(cbByN, null);
    jPanel8.add(bAceptarByN, null);
    jPanel8.add(bCancelarByN, null);
    jTabbedPane1.add(jPanelSuavizado,  "Suavizado");

    jTabbedPane1.add(jPanelBandCombine,  "BandCombine");
    jPanelBandCombine.add(jPanel1,  BorderLayout.EAST);
    jPanel1.add(jLabel1, null);
    jPanel1.add(jLabel2, null);
    jPanel1.add(jTable1, null);
    jPanelBandCombine.add(jPanelLienzoBandCombine, BorderLayout.CENTER);
    jTabbedPane1.add(jPanelRealce, "Realce");
    jPanelNegativo.add(jLienzoNegativo,  BorderLayout.CENTER);
    jPanelNegativo.add(jPanel2,  BorderLayout.EAST);
    jPanel2.add(jCheckBox1, null);
    jPanel2.add(jCheckBox2, null);
    jPanel2.add(jCheckBox3, null);
    jPanel2.add(bAceptarNegativo, null);
    jPanel2.add(bCancelarNegativo, null);
    jPanelSuavizado.add(jLienzoSuavizado, BorderLayout.CENTER);
    jPanelSuavizado.add(jPanel4, BorderLayout.EAST);
    jPanel4.add(bSuavizar, null);
    jPanel4.add(bAceptarSuavizado, null);
    jPanel4.add(bCancelarSuavizado, null);
    jPanelRealce.add(jPanel5,  BorderLayout.EAST);
    jPanel5.add(bRealzar, null);
    jPanel5.add(bAceptarRealce, null);
    jPanel5.add(bCancelarRealce, null);
    jPanelRealce.add(jPanelLienzoRealce, BorderLayout.CENTER);
    jTabbedPane1.add(jPanelFronteras,  "Detectar fronteras");
    jPanelFronteras.add(jPanel9,  BorderLayout.EAST);
    jPanel9.add(cbFronteras, null);
    jPanelFronteras.add(jPaneLienzoFronteras, BorderLayout.CENTER);
    jTabbedPane1.add(jPanelRotacion, "Rotacion");
    jPanelRotacion.add(jPanelLienzoRotacion,  BorderLayout.CENTER);
    jPanelRotacion.add(jPanel12,  BorderLayout.EAST);
    jPanel12.add(rbGirar90, null);
    jPanel12.add(rbGirar180, null);
    jPanel12.add(rbGirar270, null);
    jPanel12.add(rbGirar360, null);
    jPanel12.add(jLabel3, null);
    jPanel12.add(sGrados, null);
    jPanel12.add(bAceptarRotacion, null);
    jPanel12.add(bCancelarRotacion, null);
    jTabbedPane1.add(jPanelEscalado, "Escalado");
    jPanelEscalado.add(jPanel10,  BorderLayout.EAST);
    jPanel10.add(spinerEscalado, null);
    jPanel10.add(bAceptarEscalado, null);
    jPanel10.add(jButton3, null);
    jPanelEscalado.add(jScrollPane1,  BorderLayout.CENTER);
    jTabbedPane1.add(jPanelContraste, "Brillo y contraste");
    jPanelContraste.add(jPanel3,  BorderLayout.EAST);
    jPanel3.add(lContraste, null);
    jPanelContraste.add(jPanelLienzoBrilloyContraste, BorderLayout.CENTER);
    jTabbedPane1.add(jPanelShear, "Shear");
    jPanelShear.add(jPanel13,  BorderLayout.EAST);
    jPanel13.add(sliderShear, null);
    jPanel13.add(bAceptarShear, null);
    jPanel13.add(bCancelarShear, null);
    jScrollPane1.getViewport().add(jPanelLienzoEscalado, null);


    jPanel9.add(bAceptarFronteras, null);
    jPanel9.add(bCancelarFronteras, null);
    jPanel1.add(cbAplicarBandCombine, null);
    jPanel1.add(bAceptarBandCombine, null);
    jPanel1.add(bCancelarBandCombine, null);
    jPanel3.add(sliderContraste, null);
    jPanel3.add(bAceptarContraste, null);
    jPanel3.add(bCancelarContraste, null);
    jPanelShear.add(jPanelLienzoShear,  BorderLayout.CENTER);
  }

  /**
  * <p><u>Descripción</u>: Esta función le aplica a un canal de una imagen el efecto negativo.</p>
  * @param canal Canal para dar el efecto negativo, puede ser: rojo, verde, azul.
  */
  void negativo(String canal)
  {
    BufferedImage imgSource, img = jLienzoNegativo.getImagen();

    if (img.getType() != BufferedImage.TYPE_INT_RGB)
    {
        imgSource = new BufferedImage(img.getWidth(),img.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imgSource.createGraphics();
        g2d.drawImage(img, 0, 0, null);
    }
    else
      imgSource = img;

    ShortLookupTable invert = null;

    if( canal.compareTo("rojo") == 0 )
    {
      short[][] invertir = {invertido, identidad, identidad};
      invert = new ShortLookupTable(0, invertir);
    }
    else
      if( canal.compareTo("verde") == 0 )
      {
        short[][] invertir = {identidad, invertido, identidad};
        invert = new ShortLookupTable(0, invertir);
      }
      else
        if( canal.compareTo("azul") == 0 )
        {
          short[][] invertir = {identidad, identidad, invertido};
          invert = new ShortLookupTable(0, invertir);
        }

    operacion_negativo = new LookupOp(invert, null);
    imgdest = operacion_negativo.filter( imgSource , null);

    jLienzoNegativo.setImagen( imgdest );

    filtro_lookup = new mi_LookupOp( invert );

    jLienzoNegativo.repaint();
}


  void brillo_mouseDragged(MouseEvent e)
  {
    lBrillo.setText( "Brillo: " + brillo.getValue() );

    if (original.getType() != BufferedImage.TYPE_INT_RGB)
    {
        imgSource = new BufferedImage(original.getWidth(),original.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imgSource.createGraphics();
        g2d.drawImage(original, 0, 0, null);
    }
    else
      imgSource = original;

    RescaleOp rop = new RescaleOp(1.0F, brillo.getValue(), null);
    imgdest = rop.filter(imgSource, null);

    filtro_brillo = new mi_RescaleOp(brillo.getValue());

    jLienzoBrillo.setImagen( imgdest );

    jLienzoBrillo.repaint();

  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve acepta los cambios del filtro oportuno y actualiza la imagen.</p>
   */
  void aceptar_cambios()
  {
    invocador.jPanelDibujar.setImagen( imgdest );

    invocador.jPanelDibujar.repaint();

    dispose();
  }

  void this_internalFrameClosed(InternalFrameEvent e)
  {
    invocador.creador.num_ventanas_filtros = 0;
  }

  void bAceptar_actionPerformed(ActionEvent e)
  {
    invocador.jPanelDibujar.buffer.add(filtro_brillo);
    aceptar_cambios();
  }

  void bCancelar_actionPerformed(ActionEvent e) {
    dispose();
  }

  void jCheckBox1_actionPerformed(ActionEvent e) {
    negativo("rojo");
  }

  void jCheckBox2_actionPerformed(ActionEvent e) {
    negativo("verde");
  }

  void jCheckBox3_actionPerformed(ActionEvent e) {
    negativo("azul");
  }

  void bAceptarNegativo_actionPerformed(ActionEvent e)
  {
    invocador.jPanelDibujar.buffer.add(filtro_lookup);
    aceptar_cambios();
  }

  void bCancelarNegativo_actionPerformed(ActionEvent e) {
    dispose();
  }

  void cbByN_actionPerformed(ActionEvent e)
  {
    if( cbByN.isSelected() )
    {
      if (original.getType() != BufferedImage.TYPE_INT_RGB) {
        imgSource = new BufferedImage(original.getWidth(), original.getHeight(),
                                      BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imgSource.createGraphics();
        g2d.drawImage(original, 0, 0, null);
      }
      else
        imgSource = original;

      ColorConvertOp ccop = new ColorConvertOp(ColorSpace.getInstance(
          ColorSpace.CS_GRAY), null);
      imgdest = ccop.filter(imgSource, null);

      jLienzoByN.setImagen(imgdest);

      jLienzoByN.repaint();
    }
    else
    {
      jLienzoByN.setImagen(original);

      jLienzoByN.repaint();
    }

  }

  void bAceptarByN_actionPerformed(ActionEvent e) {
    aceptar_cambios();
  }

  void bCancelarByN_actionPerformed(ActionEvent e) {
    dispose();
  }

  void bSuavizar_actionPerformed(ActionEvent e) {
    if (original.getType() != BufferedImage.TYPE_INT_RGB) {
        imgSource = new BufferedImage(original.getWidth(), original.getHeight(),
                                      BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imgSource.createGraphics();
        g2d.drawImage(original, 0, 0, null);
      }
      else
        imgSource = original;

      float filtroMedia[] = {
                  0.1f, 0.1f, 0.1f,
                  0.1f, 0.2f, 0.1f,
                  0.1f, 0.1f, 0.1f
                 };
      Kernel k = new Kernel(3,3,filtroMedia);
      ConvolveOp cop = new ConvolveOp(k);
      imgdest = cop.filter(imgSource, null);

      filtro_convolve = new mi_ConvolveOp(filtroMedia);

      jLienzoSuavizado.setImagen(imgdest);

      jLienzoSuavizado.repaint();
  }

  void bAceptarSuavizado_actionPerformed(ActionEvent e) {

    invocador.jPanelDibujar.buffer.add(filtro_convolve);
    aceptar_cambios();
  }

  void bCancelarSuavizado_actionPerformed(ActionEvent e) {
    dispose();
  }

  void bRealzar_actionPerformed(ActionEvent e) {
    if (original.getType() != BufferedImage.TYPE_INT_RGB) {
        imgSource = new BufferedImage(original.getWidth(), original.getHeight(),
                                      BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imgSource.createGraphics();
        g2d.drawImage(original, 0, 0, null);
      }
      else
        imgSource = original;

      float filtroRealce[] = {
                    0.0f, -1.0f, 0.0f,
                   -1.0f,  5.0f, -1.0f,
                    0.0f, -1.0f, 0.0f
                   };

      Kernel k = new Kernel(3,3,filtroRealce);
      ConvolveOp cop = new ConvolveOp(k);
      imgdest = cop.filter(imgSource, null);

      filtro_convolve = new mi_ConvolveOp(filtroRealce);

      jPanelLienzoRealce.setImagen(imgdest);

      jPanelLienzoRealce.repaint();

  }

  void bAceptarRealce_actionPerformed(ActionEvent e) {
    invocador.jPanelDibujar.buffer.add(filtro_convolve);
    aceptar_cambios();
  }

  void bCancelarRealce_actionPerformed(ActionEvent e) {
    dispose();
  }

  void cbFronteras_actionPerformed(ActionEvent e) {
    if( cbFronteras.isSelected() )
    {
      if (original.getType() != BufferedImage.TYPE_INT_RGB) {
        imgSource = new BufferedImage(original.getWidth(), original.getHeight(),
                                      BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imgSource.createGraphics();
        g2d.drawImage(original, 0, 0, null);
      }
      else
        imgSource = original;

      float filtroLaplaciano[] = {
                  1.0f, 1.0f,  1.0f,
                  1.0f, -8.0f, 1.0f,
                  1.0f, 1.0f,  1.0f
                  };

      Kernel k = new Kernel(3,3,filtroLaplaciano);
      ConvolveOp cop = new ConvolveOp( k );
      imgdest = cop.filter(imgSource,null);

      filtro_convolve = new mi_ConvolveOp(filtroLaplaciano);

      jPaneLienzoFronteras.setImagen(imgdest);

      jPaneLienzoFronteras.repaint();
    }
    else
    {
      jPaneLienzoFronteras.setImagen(original);

      jPaneLienzoFronteras.repaint();
    }
  }

  void bAceptarFronteras_actionPerformed(ActionEvent e) {
    invocador.jPanelDibujar.buffer.add(filtro_convolve);
    aceptar_cambios();
  }

  void bCancelarFronteras_actionPerformed(ActionEvent e) {
    dispose();
  }

  void rbGirar90_actionPerformed(ActionEvent e) {
    if (original.getType() != BufferedImage.TYPE_INT_RGB) {
        imgSource = new BufferedImage(original.getWidth(), original.getHeight(),
                                      BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imgSource.createGraphics();
        g2d.drawImage(original, 0, 0, null);
      }
      else
        imgSource = original;

      AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(90.0), imgSource.getWidth()/2,imgSource.getHeight()/2);

      AffineTransformOp atop = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
      imgdest = atop.filter( imgSource, null);

      filtro_afine = new mi_AffineTransformOp(at);

      jPanelLienzoRotacion.setImagen(imgdest);

      jPanelLienzoRotacion.repaint();
  }

  void rbGirar180_actionPerformed(ActionEvent e) {
    if (original.getType() != BufferedImage.TYPE_INT_RGB) {
        imgSource = new BufferedImage(original.getWidth(), original.getHeight(),
                                      BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imgSource.createGraphics();
        g2d.drawImage(original, 0, 0, null);
      }
      else
        imgSource = original;

      AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(180.0), imgSource.getWidth()/2,imgSource.getHeight()/2);

      AffineTransformOp atop = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
      imgdest = atop.filter( imgSource, null);

      filtro_afine = new mi_AffineTransformOp(at);

      jPanelLienzoRotacion.setImagen(imgdest);

      jPanelLienzoRotacion.repaint();
  }

  void rbGirar270_actionPerformed(ActionEvent e) {
    if (original.getType() != BufferedImage.TYPE_INT_RGB) {
        imgSource = new BufferedImage(original.getWidth(), original.getHeight(),
                                      BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imgSource.createGraphics();
        g2d.drawImage(original, 0, 0, null);
      }
      else
        imgSource = original;

      AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(270.0), imgSource.getWidth()/2,imgSource.getHeight()/2);

      AffineTransformOp atop = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
      imgdest = atop.filter( imgSource, null);

      filtro_afine = new mi_AffineTransformOp(at);

      jPanelLienzoRotacion.setImagen(imgdest);

      jPanelLienzoRotacion.repaint();
  }

  void rbGirar360_actionPerformed(ActionEvent e) {
    if (original.getType() != BufferedImage.TYPE_INT_RGB) {
        imgSource = new BufferedImage(original.getWidth(), original.getHeight(),
                                      BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imgSource.createGraphics();
        g2d.drawImage(original, 0, 0, null);
      }
      else
        imgSource = original;

      AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(360.0), imgSource.getWidth()/2,imgSource.getHeight()/2);

      AffineTransformOp atop = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
      imgdest = atop.filter( imgSource, null);

      filtro_afine = new mi_AffineTransformOp(at);

      jPanelLienzoRotacion.setImagen(imgdest);

      jPanelLienzoRotacion.repaint();
  }

  void bAceptarRotacion_actionPerformed(ActionEvent e)
  {
    invocador.jPanelDibujar.buffer.add(filtro_afine);
    aceptar_cambios();
  }

  void bCancelarRotacion_actionPerformed(ActionEvent e) {
    dispose();
  }

  void spinerEscalado_stateChanged(ChangeEvent e) {

    lEscalado.setText("Escalado: " + Double.parseDouble(spinerEscalado.getValue().toString())/10.0);

    if (original.getType() != BufferedImage.TYPE_INT_RGB) {
        imgSource = new BufferedImage(original.getWidth(), original.getHeight(),
                                      BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imgSource.createGraphics();
        g2d.drawImage(original, 0, 0, null);
      }
      else
        imgSource = original;

      AffineTransform at = AffineTransform.getScaleInstance( Double.parseDouble(spinerEscalado.getValue().toString())/10.0, Double.parseDouble(spinerEscalado.getValue().toString())/10.0);

      AffineTransformOp atop = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
      imgdest = atop.filter(imgSource, null);
      jPanelLienzoEscalado.setImagen(imgdest);

      jPanelLienzoEscalado.repaint();

      // ***** Para que se actualize la imagen al escalarla y se le aplique el scroll *****
      jPanelLienzoEscalado.setSize(imgdest.getWidth(), imgdest.getHeight());
      jPanelLienzoEscalado.setMaximumSize( new Dimension(imgdest.getWidth()+1, imgdest.getHeight()+1) );
      jPanelLienzoEscalado.setMinimumSize( new Dimension(imgdest.getWidth()-1, imgdest.getHeight()-1) );
      jPanelLienzoEscalado.setPreferredSize( new Dimension(imgdest.getWidth(), imgdest.getHeight()) );
      // **********************************************************************************
  }

  void bAceptarEscalado_actionPerformed(ActionEvent e) {

    aceptar_cambios();

    invocador.jPanelDibujar.setSize(imgdest.getWidth(), imgdest.getHeight());
    invocador.setSize(imgdest.getWidth()+12, imgdest.getHeight()+37);

    // ***** Para que se actualize el scroll *****
    invocador.jPanelDibujar.setMaximumSize( new Dimension(imgdest.getWidth()+1, imgdest.getHeight()+1) );
    invocador.jPanelDibujar.setMinimumSize( new Dimension(imgdest.getWidth()-1, imgdest.getHeight()-1) );
    invocador.jPanelDibujar.setPreferredSize( new Dimension(imgdest.getWidth(), imgdest.getHeight()) );
    // *******************************************

  }

  void bCancelarEscalado_actionPerformed(ActionEvent e) {
    dispose();
  }

  void jButton3_actionPerformed(ActionEvent e) {
    dispose();
  }

  void cbAplicarBandCombine_actionPerformed(ActionEvent e) {

    if( cbAplicarBandCombine.isSelected() )
    {
      if (original.getType() != BufferedImage.TYPE_INT_RGB) {
        imgSource = new BufferedImage(original.getWidth(), original.getHeight(),
                                      BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imgSource.createGraphics();
        g2d.drawImage(original, 0, 0, null);
      }
      else
        imgSource = original;

      float arrayBandCombine[][] = {
                  {Float.parseFloat(modeloTabla.getValueAt(0,0).toString()), Float.parseFloat(modeloTabla.getValueAt(0,1).toString()),  Float.parseFloat(modeloTabla.getValueAt(0,2).toString())},
                  {Float.parseFloat(modeloTabla.getValueAt(1,0).toString()), Float.parseFloat(modeloTabla.getValueAt(1,1).toString()),  Float.parseFloat(modeloTabla.getValueAt(1,2).toString())},
                  {Float.parseFloat(modeloTabla.getValueAt(2,0).toString()), Float.parseFloat(modeloTabla.getValueAt(2,1).toString()),  Float.parseFloat(modeloTabla.getValueAt(2,2).toString())},
                  };

      BandCombineOp bcop = new BandCombineOp(arrayBandCombine, null);
      WritableRaster rasterdest = bcop.filter(imgSource.getRaster(), null);
      imgdest = new BufferedImage(imgSource.getColorModel(), rasterdest, false, null);

      filtro_bandas = new mi_BandCombineOp(arrayBandCombine);

      jPanelLienzoBandCombine.setImagen(imgdest);

      jPanelLienzoBandCombine.repaint();
    }
    else
    {
      jPanelLienzoBandCombine.setImagen(original);

      jPanelLienzoBandCombine.repaint();
    }
  }

  void bAceptarBandCombine_actionPerformed(ActionEvent e) {
    invocador.jPanelDibujar.buffer.add(filtro_bandas);
    aceptar_cambios();
  }

  void bCancelarBandCombine_actionPerformed(ActionEvent e) {
    dispose();
  }

  void sliderContraste_stateChanged(ChangeEvent e) {
    lContraste.setText("Contraste: " + sliderContraste.getValue());

    if (original.getType() != BufferedImage.TYPE_INT_RGB)
    {
        imgSource = new BufferedImage(original.getWidth(),original.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imgSource.createGraphics();
        g2d.drawImage(original, 0, 0, null);
    }
    else
      imgSource = original;

    for (int j=0; j<256; j++)
    {
        funcion_contraste[j] = (short)(K3 * (1.0 / (1.0 + Math.pow(128.0 / (float) j, sliderContraste.getValue()))));
    }

    ShortLookupTable contrast = new ShortLookupTable(0, funcion_contraste);

    LookupOp lop = new LookupOp(contrast, null);
    imgdest = lop.filter( imgSource , null);

    filtro_lookup = new mi_LookupOp(contrast);

    jPanelLienzoBrilloyContraste.setImagen( imgdest );

    jPanelLienzoBrilloyContraste.repaint();

  }

  void bCancelarContraste_actionPerformed(ActionEvent e) {
    dispose();
  }

  void bAceptarContraste_actionPerformed(ActionEvent e) {

    invocador.jPanelDibujar.buffer.add(filtro_lookup);
    aceptar_cambios();
  }

  void bCancelarShear_ancestorAdded(AncestorEvent e) {
    dispose();
  }

  void bAceptarShear_ancestorAdded(AncestorEvent e) {
    aceptar_cambios();
  }

  void bAceptarShear_actionPerformed(ActionEvent e) {
    invocador.jPanelDibujar.buffer.add(filtro_afine);
    aceptar_cambios();
  }

  void bCancelarShear_actionPerformed(ActionEvent e) {
    dispose();
  }

  void sliderShear_stateChanged(ChangeEvent e)
  {
    if (original.getType() != BufferedImage.TYPE_INT_RGB) {
    imgSource = new BufferedImage(original.getWidth(), original.getHeight(),
                                  BufferedImage.TYPE_INT_RGB);
    Graphics2D g2d = imgSource.createGraphics();
    g2d.drawImage(original, 0, 0, null);
  }
  else
    imgSource = original;

  AffineTransform at = AffineTransform.getShearInstance( sliderShear.getValue()/10.f ,0.0);

  AffineTransformOp atop = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
  imgdest = atop.filter( imgSource, null);

  filtro_afine = new mi_AffineTransformOp(at);

  jPanelLienzoShear.setImagen(imgdest);

  jPanelLienzoShear.repaint();
  }

  void sGrados_stateChanged(ChangeEvent e)
  {
    if (original.getType() != BufferedImage.TYPE_INT_RGB) {
        imgSource = new BufferedImage(original.getWidth(), original.getHeight(),
                                      BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imgSource.createGraphics();
        g2d.drawImage(original, 0, 0, null);
      }
      else
        imgSource = original;

      AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians( Double.parseDouble(sGrados.getValue().toString()) ), imgSource.getWidth()/2,imgSource.getHeight()/2);

      AffineTransformOp atop = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
      imgdest = atop.filter( imgSource, null);

      filtro_afine = new mi_AffineTransformOp(at);

      jPanelLienzoRotacion.setImagen(imgdest);

      jPanelLienzoRotacion.repaint();
  }

}

class ventana_filtros_brillo_mouseMotionAdapter extends java.awt.event.MouseMotionAdapter {
  ventana_filtros adaptee;

  ventana_filtros_brillo_mouseMotionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseDragged(MouseEvent e) {
    adaptee.brillo_mouseDragged(e);
  }
}

class ventana_filtros_this_internalFrameAdapter extends javax.swing.event.InternalFrameAdapter {
  ventana_filtros adaptee;

  ventana_filtros_this_internalFrameAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void internalFrameClosed(InternalFrameEvent e) {
    adaptee.this_internalFrameClosed(e);
  }
}

class ventana_filtros_bAceptar_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bAceptar_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bAceptar_actionPerformed(e);
  }
}

class ventana_filtros_bCancelar_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bCancelar_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bCancelar_actionPerformed(e);
  }
}

class ventana_filtros_jCheckBox1_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_jCheckBox1_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jCheckBox1_actionPerformed(e);
  }
}

class ventana_filtros_jCheckBox2_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_jCheckBox2_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jCheckBox2_actionPerformed(e);
  }
}

class ventana_filtros_jCheckBox3_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_jCheckBox3_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jCheckBox3_actionPerformed(e);
  }
}

class ventana_filtros_bAceptarNegativo_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bAceptarNegativo_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bAceptarNegativo_actionPerformed(e);
  }
}

class ventana_filtros_bCancelarNegativo_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bCancelarNegativo_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bCancelarNegativo_actionPerformed(e);
  }
}

class ventana_filtros_cbByN_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_cbByN_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cbByN_actionPerformed(e);
  }
}

class ventana_filtros_bAceptarByN_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bAceptarByN_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bAceptarByN_actionPerformed(e);
  }
}

class ventana_filtros_bCancelarByN_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bCancelarByN_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bCancelarByN_actionPerformed(e);
  }
}

class ventana_filtros_bSuavizar_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bSuavizar_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bSuavizar_actionPerformed(e);
  }
}

class ventana_filtros_bAceptarSuavizado_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bAceptarSuavizado_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bAceptarSuavizado_actionPerformed(e);
  }
}

class ventana_filtros_bCancelarSuavizado_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bCancelarSuavizado_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bCancelarSuavizado_actionPerformed(e);
  }
}

class ventana_filtros_bRealzar_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bRealzar_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bRealzar_actionPerformed(e);
  }
}

class ventana_filtros_bAceptarRealce_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bAceptarRealce_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bAceptarRealce_actionPerformed(e);
  }
}

class ventana_filtros_bCancelarRealce_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bCancelarRealce_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bCancelarRealce_actionPerformed(e);
  }
}

class ventana_filtros_cbFronteras_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_cbFronteras_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cbFronteras_actionPerformed(e);
  }
}

class ventana_filtros_bAceptarFronteras_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bAceptarFronteras_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bAceptarFronteras_actionPerformed(e);
  }
}

class ventana_filtros_bCancelarFronteras_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bCancelarFronteras_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bCancelarFronteras_actionPerformed(e);
  }
}

class ventana_filtros_rbGirar90_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_rbGirar90_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.rbGirar90_actionPerformed(e);
  }
}

class ventana_filtros_rbGirar180_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_rbGirar180_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.rbGirar180_actionPerformed(e);
  }
}

class ventana_filtros_rbGirar270_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_rbGirar270_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.rbGirar270_actionPerformed(e);
  }
}

class ventana_filtros_rbGirar360_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_rbGirar360_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.rbGirar360_actionPerformed(e);
  }
}

class ventana_filtros_bAceptarRotacion_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bAceptarRotacion_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bAceptarRotacion_actionPerformed(e);
  }
}

class ventana_filtros_bCancelarRotacion_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bCancelarRotacion_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bCancelarRotacion_actionPerformed(e);
  }
}

class ventana_filtros_spinerEscalado_changeAdapter implements javax.swing.event.ChangeListener {
  ventana_filtros adaptee;

  ventana_filtros_spinerEscalado_changeAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.spinerEscalado_stateChanged(e);
  }
}

class ventana_filtros_bAceptarEscalado_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bAceptarEscalado_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bAceptarEscalado_actionPerformed(e);
  }
}

class ventana_filtros_bCancelarEscalado_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bCancelarEscalado_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bCancelarEscalado_actionPerformed(e);
  }
}

class ventana_filtros_jButton3_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_jButton3_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton3_actionPerformed(e);
  }
}

class ventana_filtros_cbAplicarBandCombine_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_cbAplicarBandCombine_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cbAplicarBandCombine_actionPerformed(e);
  }
}

class ventana_filtros_bAceptarBandCombine_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bAceptarBandCombine_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bAceptarBandCombine_actionPerformed(e);
  }
}

class ventana_filtros_bCancelarBandCombine_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bCancelarBandCombine_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bCancelarBandCombine_actionPerformed(e);
  }
}

class ventana_filtros_sliderContraste_changeAdapter implements javax.swing.event.ChangeListener {
  ventana_filtros adaptee;

  ventana_filtros_sliderContraste_changeAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.sliderContraste_stateChanged(e);
  }
}

class ventana_filtros_bCancelarContraste_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bCancelarContraste_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bCancelarContraste_actionPerformed(e);
  }
}

class ventana_filtros_bAceptarContraste_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bAceptarContraste_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bAceptarContraste_actionPerformed(e);
  }
}

class ventana_filtros_bAceptarShear_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bAceptarShear_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bAceptarShear_actionPerformed(e);
  }
}

class ventana_filtros_bCancelarShear_actionAdapter implements java.awt.event.ActionListener {
  ventana_filtros adaptee;

  ventana_filtros_bCancelarShear_actionAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bCancelarShear_actionPerformed(e);
  }
}

class ventana_filtros_sliderShear_changeAdapter implements javax.swing.event.ChangeListener {
  ventana_filtros adaptee;

  ventana_filtros_sliderShear_changeAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.sliderShear_stateChanged(e);
  }
}

class ventana_filtros_sGrados_changeAdapter implements javax.swing.event.ChangeListener {
  ventana_filtros adaptee;

  ventana_filtros_sGrados_changeAdapter(ventana_filtros adaptee) {
    this.adaptee = adaptee;
  }
  public void stateChanged(ChangeEvent e) {
    adaptee.sGrados_stateChanged(e);
  }
}
