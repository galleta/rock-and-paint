package super_paint;

import javax.swing.*;
import java.awt.*;
import javax.media.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;
import javax.media.NoPlayerException;

/**
 * <p>T�tulo: Pr�ctica de Sistemas Multimedia</p>
 * <p>Descripci�n: Pr�ctica de Sistemas Multimedia</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Empresa: Piratas Sin Fronteras S.A.</p>
 * @author Francisco Jes�s Delgado Almir�n
 * @version 1.0
 */

public class ventana_video extends JInternalFrame
{
  private Interfaz creador;

  BorderLayout borderLayout1 = new BorderLayout();
  Player p;
  JPanel jPanelVideo = new JPanel();
  JPanel jPanel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JTextField tFichero = new JTextField();
  JButton bAbrir = new JButton();
  TitledBorder titledBorder1;
  BorderLayout borderLayout2 = new BorderLayout();

  public ventana_video(Interfaz i) {
    creador = i;
    try {
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
    titledBorder1 = new TitledBorder("");
    this.setTitle("Reproductor de v�deo - Sin archivo");
    this.addInternalFrameListener(new ventana_video_this_internalFrameAdapter(this));
    this.setClosable(true);

    ImageIcon abrir = new ImageIcon("iconos/abrir.gif");
    bAbrir.setIcon(abrir);
    bAbrir.addActionListener(new ventana_video_bAbrir_actionAdapter(this));

    this.getContentPane().setLayout(borderLayout1);
    jLabel1.setText("Fichero:");
    tFichero.setMaximumSize(new Dimension(100, 20));
    tFichero.setMinimumSize(new Dimension(100, 20));
    tFichero.setPreferredSize(new Dimension(200, 20));
    tFichero.setText("");
    jPanelVideo.setBorder(BorderFactory.createEtchedBorder());
    jPanelVideo.setLayout(borderLayout2);
    this.getContentPane().add(jPanelVideo,  BorderLayout.CENTER);
    this.getContentPane().add(jPanel1, BorderLayout.NORTH);
    jPanel1.add(jLabel1, null);
    jPanel1.add(tFichero, null);
    jPanel1.add(bAbrir, null);

    creador.jMenuGuardar.setEnabled(false);
    creador.jMenuImprimir.setEnabled(false);
    creador.jMenuHistograma.setEnabled(false);

  }

  void this_internalFrameActivated(InternalFrameEvent e) {
    creador.jMenuGuardar.setEnabled(false);
    creador.jMenuImprimir.setEnabled(false);
    creador.jMenuHistograma.setEnabled(false);
    creador.jMenuRehacer.setEnabled(false);
    creador.setUltimaVentanaImagenSeleccionada(null);
  }

  void bAbrir_actionPerformed(ActionEvent e)
  {
    JFileChooser abrir_video = new JFileChooser();

    // ***** Me declaro los filtros *****
    FileFilter avi = new Filtro("Archivos avi", ".avi");
    abrir_video.addChoosableFileFilter(avi);
    // **********************************

    if (abrir_video.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
      try
      {
        this.setTitle("Reproductor de v�deo - " +
                      abrir_video.getSelectedFile().
                      getName().substring(0,
                                          abrir_video.getSelectedFile().getName().
                                          length() - 4));
        tFichero.setText(abrir_video.getSelectedFile().toString());

        MediaLocator ml = new MediaLocator("file:" +
                                           abrir_video.getSelectedFile().
                                           toString());
        try
        {
          p = Manager.createPlayer(ml);
        }
        catch (NoPlayerException noPlayerException)
        {
         System.err.println("No se encontro archivos de multimedia");
        }
        catch (IOException iOException)
        {
         System.err.println("Error al leer la fuente");
        }
        p.addControllerListener(new miManejadorMedia(this));
        p.start();
      }
      catch(Exception ex){}

    }
  }

  void this_internalFrameClosed(InternalFrameEvent e) {
    if( p != null )
      p.stop();
  }
}

class miManejadorMedia extends ControllerAdapter {
  ventana_video adaptee;

  miManejadorMedia(ventana_video adaptee) {
    this.adaptee = adaptee;
  }
  public void realizeComplete(RealizeCompleteEvent e) {
    Component areaVisual = adaptee.p.getVisualComponent();
    if(areaVisual!=null)
    {
      adaptee.jPanelVideo.add(areaVisual, BorderLayout.CENTER);
    }
    Component panelControl = adaptee.p.getControlPanelComponent();
    if(panelControl!=null)
    {
      adaptee.jPanelVideo.add(panelControl, BorderLayout.SOUTH);
    }
    adaptee.validate();
  }
}

class ventana_video_this_internalFrameAdapter extends javax.swing.event.InternalFrameAdapter {
  ventana_video adaptee;

  ventana_video_this_internalFrameAdapter(ventana_video adaptee) {
    this.adaptee = adaptee;
  }
  public void internalFrameActivated(InternalFrameEvent e) {
    adaptee.this_internalFrameActivated(e);
  }
  public void internalFrameClosed(InternalFrameEvent e) {
    adaptee.this_internalFrameClosed(e);
  }
}

class ventana_video_bAbrir_actionAdapter implements java.awt.event.ActionListener {
  ventana_video adaptee;

  ventana_video_bAbrir_actionAdapter(ventana_video adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.bAbrir_actionPerformed(e);
  }
}
