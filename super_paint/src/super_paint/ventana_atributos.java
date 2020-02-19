package super_paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 * <p>Título: Práctica de Sistemas Multimedia</p>
 * <p>Descripción: Práctica de Sistemas Multimedia</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Empresa: Piratas Sin Fronteras S.A.</p>
 * @author Francisco Jesús Delgado Almirón
 * @version 1.0
 */

public class ventana_atributos extends JInternalFrame
{
  private Interfaz creador;

  BorderLayout borderLayout1 = new BorderLayout();
  JTabbedPane jTabbedPane1 = new JTabbedPane();
  JPanel jPanelAtributos = new JPanel();
  JPanel jPanelTexto = new JPanel();
  JLabel lTipoTrazo = new JLabel();
  JSlider sGrosor = new JSlider();
  JLabel lRelleno = new JLabel();
  JComboBox cTipoTrazo = new JComboBox();
  JSlider sTransparencia = new JSlider();
  JLabel lGrosor = new JLabel();
  JLabel lTransparencia = new JLabel();
  JComboBox cRelleno = new JComboBox();
  FlowLayout flowLayout1 = new FlowLayout();
  FlowLayout flowLayout2 = new FlowLayout();
  JLabel lNegrita = new JLabel();
  JCheckBox cbTachado = new JCheckBox();
  JLabel lTamaFuente = new JLabel();
  JSlider sTamaFuente = new JSlider();
  JLabel lSubrayado = new JLabel();
  JPanel jPanelNegritaCursiva = new JPanel();
  JCheckBox cbSubrayado = new JCheckBox();
  JLabel lFuente = new JLabel();
  JComboBox cFuentes = new JComboBox();
  JCheckBox cbCursiva = new JCheckBox();
  JPanel jPanelSubrayadoTachado = new JPanel();
  JLabel lCursiva = new JLabel();
  JCheckBox cbNegrita = new JCheckBox();
  JLabel lTachado = new JLabel();

  public ventana_atributos(Interfaz i) {
    try {
      creador = i;
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {

    ImageIcon icono_frame = new ImageIcon("iconos/imagen.gif");
    this.setFrameIcon(icono_frame);

    ImageIcon negrita = new ImageIcon("iconos/negrita.gif");
    lNegrita.setIcon(negrita);
    ImageIcon cursiva = new ImageIcon("iconos/cursiva.gif");
    lCursiva.setIcon(cursiva);
    ImageIcon subrayado = new ImageIcon("iconos/subrayado.gif");
    lSubrayado.setIcon(subrayado);
    ImageIcon tachado = new ImageIcon("iconos/tachado.gif");
    lTachado.setIcon(tachado);

    // ***** Cargo la lista de fuentes instaladas en el equipo *****
    GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    String[] fuentes = env.getAvailableFontFamilyNames();

    for(int i = 0; i < fuentes.length; i++)
    {
      cFuentes.addItem(fuentes[i]);
    }

    creador.setFuente( (String) cFuentes.getSelectedItem() ); // pongo la fuente inicial
    // *************************************************************

    this.setTitle("Herramientas");
    this.addInternalFrameListener(new ventana_atributos_this_internalFrameAdapter(this));
    this.setClosable(true);
    this.getContentPane().setLayout(borderLayout1);
    jPanelAtributos.setLayout(flowLayout1);
    lTipoTrazo.setText("Tipo de trazo:");
    sGrosor.setToolTipText("");
    sGrosor.setPreferredSize(new Dimension(90, 24));
    sGrosor.setMaximumSize(new Dimension(90, 24));
    sGrosor.setBorder(BorderFactory.createRaisedBevelBorder());
    sGrosor.setMajorTickSpacing(1);
    sGrosor.setMaximum(10);
    sGrosor.setMinimum(1);
    sGrosor.setValue(3);
    sGrosor.addMouseMotionListener(new ventana_atributos_sGrosor_mouseMotionAdapter(this));
    lRelleno.setText("Tipo de relleno:");
    cTipoTrazo.setPreferredSize(new Dimension(100, 19));
    cTipoTrazo.addActionListener(new ventana_atributos_cTipoTrazo_actionAdapter(this));
    sTransparencia.setMinimum(1);
    sTransparencia.setMaximum(10);
    sTransparencia.setMajorTickSpacing(1);
    sTransparencia.setBorder(BorderFactory.createRaisedBevelBorder());
    sTransparencia.setMaximumSize(new Dimension(90, 24));
    sTransparencia.setPreferredSize(new Dimension(90, 24));
    sTransparencia.setToolTipText("");
    sTransparencia.addMouseMotionListener(new ventana_atributos_sTransparencia_mouseMotionAdapter(this));
    lGrosor.setText("Grosor de línea: 3");
    lTransparencia.setText("Transparencia: 1.0");
    cRelleno.setPreferredSize(new Dimension(100, 19));
    cRelleno.addActionListener(new ventana_atributos_cRelleno_actionAdapter(this));
    jPanelTexto.setLayout(flowLayout2);
    lTamaFuente.setText("Tamaño fuente: 12");
    sTamaFuente.setValue(12);
    sTamaFuente.addMouseMotionListener(new ventana_atributos_sTamaFuente_mouseMotionAdapter(this));
    sTamaFuente.setPreferredSize(new Dimension(90, 24));
    sTamaFuente.setMaximumSize(new Dimension(90, 24));
    sTamaFuente.setMaximum(70);
    sTamaFuente.setBorder(BorderFactory.createRaisedBevelBorder());
    lFuente.setText("Tipo de fuente:");
    cFuentes.setPreferredSize(new Dimension(100, 19));
    cFuentes.addActionListener(new ventana_atributos_cFuentes_actionAdapter(this));
    cbNegrita.addActionListener(new ventana_atributos_cbNegrita_actionAdapter(this));
    cbCursiva.addActionListener(new ventana_atributos_cbCursiva_actionAdapter(this));
    cbSubrayado.addActionListener(new ventana_atributos_cbSubrayado_actionAdapter(this));
    cbTachado.addActionListener(new ventana_atributos_cbTachado_actionAdapter(this));
    this.getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
    jTabbedPane1.add(jPanelAtributos,  "Atributos formas");
    jPanelAtributos.add(lGrosor, null);
    jPanelAtributos.add(sGrosor, null);
    jPanelAtributos.add(lTipoTrazo, null);
    jPanelAtributos.add(cTipoTrazo, null);
    jPanelAtributos.add(lRelleno, null);
    jPanelAtributos.add(cRelleno, null);
    jPanelAtributos.add(lTransparencia, null);
    jPanelAtributos.add(sTransparencia, null);
    jTabbedPane1.add(jPanelTexto, "Atributos texto");
    jPanelNegritaCursiva.add(lNegrita, null);
    jPanelNegritaCursiva.add(cbNegrita, null);
    jPanelNegritaCursiva.add(lCursiva, null);
    jPanelNegritaCursiva.add(cbCursiva, null);
    jPanelTexto.add(lTamaFuente, null);
    jPanelTexto.add(sTamaFuente, null);
    jPanelTexto.add(lFuente, null);
    jPanelTexto.add(cFuentes, null);
    jPanelTexto.add(jPanelNegritaCursiva, null);
    jPanelTexto.add(jPanelSubrayadoTachado, null);
    jPanelSubrayadoTachado.add(lSubrayado, null);
    jPanelSubrayadoTachado.add(cbSubrayado, null);
    jPanelSubrayadoTachado.add(lTachado, null);
    jPanelSubrayadoTachado.add(cbTachado, null);
    cTipoTrazo.addItem("Continuo");
    cTipoTrazo.addItem("Punteado");
    cTipoTrazo.addItem("Redondeado");
    cRelleno.addItem("Sin relleno");
    cRelleno.addItem("Liso");
    cRelleno.addItem("Degradado Vert.");
    cRelleno.addItem("Degradado Horiz.");
  }

  void sGrosor_mouseDragged(MouseEvent e)
  {
    lGrosor.setText( "Grosor de línea: " + sGrosor.getValue() );
    creador.setGrosor(sGrosor.getValue());
  }

  void cTipoTrazo_actionPerformed(ActionEvent e) {
    creador.setTipoTrazo(cTipoTrazo.getSelectedIndex());
    // Aquí actualizo el tipo de trazo que quiere el usuario
    // El trazo redondeado lo he añadido yo :D
  }

  void cRelleno_actionPerformed(ActionEvent e) {
    creador.setTipoRelleno(cRelleno.getSelectedIndex());
    // Aquí actualizo el tipo de relleno que quiere el usuario
  }

  void sTransparencia_mouseDragged(MouseEvent e) {
    lTransparencia.setText("Transparencia: " + sTransparencia.getValue()/10.0f );
    creador.setTransparencia( sTransparencia.getValue()/10.0f );
  }

  void sTamaFuente_mouseDragged(MouseEvent e) {
    lTamaFuente.setText("Tamaño fuente: " + sTamaFuente.getValue());
    creador.setTamaFuente(sTamaFuente.getValue());
  }

  void cFuentes_actionPerformed(ActionEvent e) {
    creador.setFuente( (String)cFuentes.getSelectedItem() );
  }

  void cbNegrita_actionPerformed(ActionEvent e) {
    creador.cambiarNegrita( cbNegrita.isSelected() );
  }

  void cbCursiva_actionPerformed(ActionEvent e) {
    creador.cambiarCursiva( cbCursiva.isSelected() );
  }

  void cbSubrayado_actionPerformed(ActionEvent e) {
    creador.cambiarSubrayado( cbSubrayado.isSelected() );
  }

  void cbTachado_actionPerformed(ActionEvent e) {
    // El estilo tachado lo he añadido yo :D
    creador.cambiarTachado( cbTachado.isSelected() );
  }

  void this_internalFrameActivated(InternalFrameEvent e) {
    creador.jMenuGuardar.setEnabled(false);
    creador.jMenuImprimir.setEnabled(false);
    creador.jMenuHistograma.setEnabled(false);
    creador.jMenuDeshacer.setEnabled(false);
    creador.jMenuRehacer.setEnabled(false);
    creador.setUltimaVentanaImagenSeleccionada(null);
  }

}

class ventana_atributos_sGrosor_mouseMotionAdapter extends java.awt.event.MouseMotionAdapter {
  ventana_atributos adaptee;

  ventana_atributos_sGrosor_mouseMotionAdapter(ventana_atributos adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseDragged(MouseEvent e) {
    adaptee.sGrosor_mouseDragged(e);
  }
}

class ventana_atributos_cTipoTrazo_actionAdapter implements java.awt.event.ActionListener {
  ventana_atributos adaptee;

  ventana_atributos_cTipoTrazo_actionAdapter(ventana_atributos adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cTipoTrazo_actionPerformed(e);
  }
}

class ventana_atributos_cRelleno_actionAdapter implements java.awt.event.ActionListener {
  ventana_atributos adaptee;

  ventana_atributos_cRelleno_actionAdapter(ventana_atributos adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cRelleno_actionPerformed(e);
  }
}

class ventana_atributos_sTransparencia_mouseMotionAdapter extends java.awt.event.MouseMotionAdapter {
  ventana_atributos adaptee;

  ventana_atributos_sTransparencia_mouseMotionAdapter(ventana_atributos adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseDragged(MouseEvent e) {
    adaptee.sTransparencia_mouseDragged(e);
  }
}

class ventana_atributos_sTamaFuente_mouseMotionAdapter extends java.awt.event.MouseMotionAdapter {
  ventana_atributos adaptee;

  ventana_atributos_sTamaFuente_mouseMotionAdapter(ventana_atributos adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseDragged(MouseEvent e) {
    adaptee.sTamaFuente_mouseDragged(e);
  }
}

class ventana_atributos_cFuentes_actionAdapter implements java.awt.event.ActionListener {
  ventana_atributos adaptee;

  ventana_atributos_cFuentes_actionAdapter(ventana_atributos adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cFuentes_actionPerformed(e);
  }
}

class ventana_atributos_cbNegrita_actionAdapter implements java.awt.event.ActionListener {
  ventana_atributos adaptee;

  ventana_atributos_cbNegrita_actionAdapter(ventana_atributos adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cbNegrita_actionPerformed(e);
  }
}

class ventana_atributos_cbCursiva_actionAdapter implements java.awt.event.ActionListener {
  ventana_atributos adaptee;

  ventana_atributos_cbCursiva_actionAdapter(ventana_atributos adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cbCursiva_actionPerformed(e);
  }
}

class ventana_atributos_cbSubrayado_actionAdapter implements java.awt.event.ActionListener {
  ventana_atributos adaptee;

  ventana_atributos_cbSubrayado_actionAdapter(ventana_atributos adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cbSubrayado_actionPerformed(e);
  }
}

class ventana_atributos_cbTachado_actionAdapter implements java.awt.event.ActionListener {
  ventana_atributos adaptee;

  ventana_atributos_cbTachado_actionAdapter(ventana_atributos adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cbTachado_actionPerformed(e);
  }
}

class ventana_atributos_this_internalFrameAdapter extends javax.swing.event.InternalFrameAdapter {
  ventana_atributos adaptee;

  ventana_atributos_this_internalFrameAdapter(ventana_atributos adaptee) {
    this.adaptee = adaptee;
  }
  public void internalFrameActivated(InternalFrameEvent e) {
    adaptee.this_internalFrameActivated(e);
  }
}
