package super_paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * <p>T�tulo: Pr�ctica de Sistemas Multimedia</p>
 * <p>Descripci�n: Pr�ctica de Sistemas Multimedia</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Empresa: Piratas Sin Fronteras S.A.</p>
 * @author Francisco Jes�s Delgado Almir�n
 * @version 1.0
 */

public class Ventana_dimensiones extends JDialog
{

  private Color fondillo = Color.white;

  FlowLayout flowLayout1 = new FlowLayout();
  JLabel jLabel1 = new JLabel();
  JTextField tAnchura = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField tAltura = new JTextField();
  JButton bAceptar = new JButton();

  private Interfaz creador;
  JLabel jLabel3 = new JLabel();
  JTextField jTitulo = new JTextField();
  JLabel jLabel4 = new JLabel();
  JComboBox cColorFondo = new JComboBox();

  public Ventana_dimensiones(Interfaz in) {
    creador = in;
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception
  {
    cColorFondo.addItem("Blanco");
    cColorFondo.addItem("Negro");
    cColorFondo.addItem("Gris");
    cColorFondo.addItem("Azul");
    cColorFondo.addItem("Verde");
    cColorFondo.addItem("Rojo");
    cColorFondo.addItem("Amarillo");
    cColorFondo.addItem("Naranja");
    cColorFondo.addItem("Rosa");
    cColorFondo.addItem("Personalizado");
    this.setModal(true);
    this.setTitle("Nuevo");
    jLabel1.setText("Anchura: ");
    this.setLocale(java.util.Locale.getDefault());
    this.getContentPane().setLayout(flowLayout1);
    tAnchura.setMaximumSize(new Dimension(150, 2147483647));
    tAnchura.setMinimumSize(new Dimension(150, 20));
    tAnchura.setPreferredSize(new Dimension(118, 20));
    tAnchura.setToolTipText("");
    tAnchura.setText("700");
    tAnchura.addFocusListener(new Ventana_dimensiones_tAnchura_focusAdapter(this));
    jLabel2.setText("Altura:     ");
    tAltura.setMaximumSize(new Dimension(150, 2147483647));
    tAltura.setMinimumSize(new Dimension(150, 20));
    tAltura.setPreferredSize(new Dimension(118, 20));
    tAltura.setText("700");
    tAltura.addFocusListener(new Ventana_dimensiones_tAltura_focusAdapter(this));
    bAceptar.setText("Aceptar");
    bAceptar.addMouseListener(new Ventana_dimensiones_bAceptar_mouseAdapter(this));
    jLabel3.setText("T�tulo:      ");
    jTitulo.setMaximumSize(new Dimension(150, 2147483647));
    jTitulo.setMinimumSize(new Dimension(150, 20));
    jTitulo.setPreferredSize(new Dimension(118, 20));
    jTitulo.setText("Nueva imagen");
    jLabel4.setText("Color de fondo:");
    cColorFondo.setMaximumSize(new Dimension(100, 32767));
    cColorFondo.setMinimumSize(new Dimension(100, 19));
    cColorFondo.setPreferredSize(new Dimension(90, 19));
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(tAnchura, null);
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(tAltura, null);
    this.getContentPane().add(jLabel3, null);
    this.getContentPane().add(jTitulo, null);
    this.getContentPane().add(jLabel4, null);
    this.getContentPane().add(cColorFondo, null);
    this.getContentPane().add(bAceptar, null);
    this.setResizable(false); // deshabilito la opci�n de maximizar
  }

  void bAceptar_mouseClicked(MouseEvent e)
  {
    if( (Integer.parseInt(tAnchura.getText()) <= 0 || Integer.parseInt(tAltura.getText()) <= 0))
      JOptionPane.showMessageDialog(this, "Dimensiones err�neas.\nLas dimensiones no puedes ser menores o iguales a cero.", "Error de dimensiones", JOptionPane.ERROR_MESSAGE);
    else
    {
    // ***** Creo y muestro la ventana de la imagen *****

    // ***** Le doy a la imagen el fondo *****
    switch( cColorFondo.getSelectedIndex() ) // Esto lo he agregado yo :D
    {
        case 1: // fondo negro
          fondillo = Color.black;
          break;
        case 2: // fondo gris
          fondillo = Color.gray;
          break;
        case 3: // fondo azul
          fondillo = Color.blue;
          break;
        case 4: // fondo verde
          fondillo = Color.green;
          break;
        case 5: // fondo rojo
          fondillo = Color.red;
          break;
        case 6: // fondo amarillo
          fondillo = Color.yellow;
          break;
        case 7: // fondo naranja
          fondillo = Color.orange;
          break;
        case 8: // fondo rosa
          fondillo = Color.pink;
          break;
        case 9: // fondo personalizado
          JColorChooser fondoPersonalizado = new JColorChooser();
          fondoPersonalizado.setVisible(true);
          fondillo = fondoPersonalizado.showDialog(null,"Seleccione el color del fondo", null);
          break;
    }
    creador.setColorFondo( fondillo );
    // ***************************************

    Ventana_imagen imagen = new Ventana_imagen(creador, jTitulo.getText(), Integer.parseInt(tAnchura.getText()), Integer.parseInt(tAltura.getText()), null );
    imagen.jPanelDibujar.setFondo( fondillo );
    imagen.setSize(Integer.parseInt(tAnchura.getText())+12, Integer.parseInt(tAltura.getText())+37);
    // centro la ventana
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = imagen.getSize();
    if (frameSize.height > screenSize.height)
      frameSize.height = screenSize.height;
    if (frameSize.width > screenSize.width)
      frameSize.width = screenSize.width;
    imagen.setLocation( (screenSize.width - frameSize.width) / 2,
                       (screenSize.height - frameSize.height) / 2);
    //
    imagen.setVisible(true);

    dispose(); // cierro la ventana

    creador.escritorio.remove(creador.labelFondo);

    creador.escritorio.add(imagen);

    imagen.toFront(); // pongo la imagen al frente
    try
    {
      imagen.setSelected(true);
    }
    catch (Exception ex)
    {
    }

    creador.escritorio.add(creador.labelFondo, creador.escritorio.DEFAULT_LAYER);

    // ************************************************************
    }
  }

  void tAnchura_focusLost(FocusEvent e)
  {
    if( tAnchura.getText().compareTo("") == 0 )
      tAnchura.setText("0");
  }

  void tAltura_focusLost(FocusEvent e) {
    if( tAltura.getText().compareTo("") == 0 )
      tAltura.setText("0");
  }

}

class Ventana_dimensiones_bAceptar_mouseAdapter extends java.awt.event.MouseAdapter {
  Ventana_dimensiones adaptee;

  Ventana_dimensiones_bAceptar_mouseAdapter(Ventana_dimensiones adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.bAceptar_mouseClicked(e);
  }
}

class Ventana_dimensiones_tAnchura_focusAdapter extends java.awt.event.FocusAdapter {
  Ventana_dimensiones adaptee;

  Ventana_dimensiones_tAnchura_focusAdapter(Ventana_dimensiones adaptee) {
    this.adaptee = adaptee;
  }
  public void focusLost(FocusEvent e) {
    adaptee.tAnchura_focusLost(e);
  }
}

class Ventana_dimensiones_tAltura_focusAdapter extends java.awt.event.FocusAdapter {
  Ventana_dimensiones adaptee;

  Ventana_dimensiones_tAltura_focusAdapter(Ventana_dimensiones adaptee) {
    this.adaptee = adaptee;
  }
  public void focusLost(FocusEvent e) {
    adaptee.tAltura_focusLost(e);
  }
}
