package super_paint;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.filechooser.FileFilter;

import java.net.URL;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;

import javax.media.*;
import javax.swing.event.*;


/**
 * <p>Título: Práctica de Sistemas Multimedia</p>
 * <p>Descripción: Práctica de Sistemas Multimedia</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Empresa: Piratas Sin Fronteras S.A.</p>
 * @author Francisco Jesús Delgado Almirón
 * @version 1.0
 */

public class Ventana_audio extends JInternalFrame
{
  JLabel jFichero = new JLabel();
  JButton bReproducir = new JButton();
  JButton bAbrir = new JButton();
  JButton bPausa = new JButton();
  JTextField tRuta = new JTextField();
  FlowLayout flowLayout1 = new FlowLayout();
  JButton bParar = new JButton();
  JLabel lInfor = new JLabel();
  JButton bAvance = new JButton();

  // ***** Atributos de la clase *****
  private URL mediaURL = null;
  private Player reproductor;
  private boolean pausado = false, empezado = false, avanzarrapido = false;
  private Time pausa = null;
  private Interfaz creador;
  // *********************************

  public Ventana_audio(Interfaz i)
  {
    creador = i;
    try
    {
      jbInit();
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception
  {
    ImageIcon icono_frame = new ImageIcon("iconos/imagen.gif");
    this.setFrameIcon(icono_frame);
    this.setClosable(true);
    ImageIcon reproducir = new ImageIcon("iconos/reproducir.gif");
    ImageIcon pausa = new ImageIcon("iconos/pausa.gif");
    ImageIcon parar = new ImageIcon("iconos/parar.gif");
    ImageIcon abrir = new ImageIcon("iconos/abrir.gif");
    ImageIcon avanze_rapido = new ImageIcon("iconos/avance_rapido.gif");
    bReproducir.setIcon(reproducir);
    bPausa.setIcon(pausa);
    bParar.setIcon(parar);
    bAbrir.setIcon(abrir);
    bAvance.setToolTipText("Avance rápido");
    bAvance.setIcon(avanze_rapido);

    this.setResizable(false);
    jFichero.setText("Fichero:");
    this.setTitle("Reproductor de sonido - Sin archivo");
    this.addInternalFrameListener(new Ventana_audio_this_internalFrameAdapter(this));
    this.getContentPane().setLayout(flowLayout1);
    bReproducir.addMouseListener(new Ventana_audio_bReproducir_mouseAdapter(this));
    bAbrir.setToolTipText("Abrir fichero");
    bAbrir.setSelected(false);
    bAbrir.setText("");
    bAbrir.addMouseListener(new Ventana_audio_bAbrir_mouseAdapter(this));
    bPausa.addMouseListener(new Ventana_audio_bPausa_mouseAdapter(this));
    bParar.addMouseListener(new Ventana_audio_bParar_mouseAdapter(this));
    tRuta.setPreferredSize(new Dimension(280, 20));
    tRuta.setRequestFocusEnabled(true);
    tRuta.setText("");
    lInfor.setPreferredSize(new Dimension(115, 15));
    lInfor.setRequestFocusEnabled(true);
    lInfor.setText("Estado: Parado");
    bReproducir.setToolTipText("Reproducir");
    bReproducir.setText("");
    bPausa.setToolTipText("Pausa");
    bPausa.setText("");
    bParar.setToolTipText("Parar");
    bParar.setText("");
    bAvance.addMouseListener(new Ventana_audio_bAvance_mouseAdapter(this));
    this.getContentPane().add(jFichero, null);
    this.getContentPane().add(tRuta, null);
    this.getContentPane().add(bAbrir, null);
    this.getContentPane().add(bReproducir, null);
    this.getContentPane().add(bPausa, null);
    this.getContentPane().add(bParar, null);
    this.getContentPane().add(bAvance, null);
    this.getContentPane().add(lInfor, null);

    creador.jMenuGuardar.setEnabled(false);
    creador.jMenuImprimir.setEnabled(false);
    creador.jMenuHistograma.setEnabled(false);

  }

  void bReproducir_mouseClicked(MouseEvent e)
  {
    if( mediaURL != null )
    {
      try
      {
        if( avanzarrapido )
        {
          pausa = reproductor.getMediaTime(); // cojo el instante para empezar de nuevo
          reproductor.stop(); // paro la reproducción
          reproductor.setRate(1.f); // pongo el rate para la reproducción normal
          reproductor.setMediaTime(pausa); // me coloco en el instante donde me quedé
          reproductor.start(); // reproduzco
          avanzarrapido = false;
          lInfor.setText("Estado: Reproduciendo");
        }
        else
          if(!empezado)
          {
            reproductor = Manager.createPlayer(mediaURL);
            reproductor.start();
            lInfor.setText("Estado: Reproduciendo");
            empezado = true;
          }
      }
      catch (NoPlayerException ex) {
        JOptionPane.showMessageDialog(this,
                                      "No se encontró archivos de multimedia.",
                                      "ERROR", JOptionPane.ERROR_MESSAGE);
      }
      catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error de escritra del fichero.",
                                      "ERROR", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  void bAbrir_mouseClicked(MouseEvent e)
  {
    JFileChooser abrir_musica = new JFileChooser();

    // ***** Me declaro los filtros *****
    FileFilter mp3 = new Filtro("Archivos mp3",".mp3"), wav = new Filtro("Archivos wav", ".wav");
    FileFilter wave = new Filtro("Archivoso wave", ".wave");
    abrir_musica.addChoosableFileFilter(wav);
    abrir_musica.addChoosableFileFilter(wave);
    abrir_musica.addChoosableFileFilter(mp3);
    // **********************************

    if( abrir_musica.showOpenDialog(this) == JFileChooser.APPROVE_OPTION )
    {
      try
      {
        mediaURL = abrir_musica.getSelectedFile().toURL();
        this.setTitle( "Reproductor de sonido - " + abrir_musica.getSelectedFile().getName() );
        tRuta.setText(abrir_musica.getSelectedFile().toString());
      }
      catch (Exception ex)
      {
        JOptionPane.showMessageDialog(this, "Error de lectura del fichero.", "ERROR", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  void bPausa_mouseClicked(MouseEvent e)
  {
    if( reproductor != null )
    {
      if (!pausado) { // si no está pausado el sonido
        pausa = reproductor.getMediaTime(); // cojo el instante donde se ha quedado pausado el sonido
        pausado = true; // digo que el sonido está pausado
        reproductor.stop(); // paro el sonido
        lInfor.setText("Estado: Pausa");
      }
      else { // si el sonido está pausado
        reproductor.setMediaTime(pausa); // pongo la reproducción en el momento en el que se pausó
        reproductor.start(); // reproduzco el sonido
        pausado = false; // y digo que el sonido ya no está pausado
        if(avanzarrapido)
          lInfor.setText("Estado: Avance rápido");
        else
          lInfor.setText("Estado: Reproduciendo");
      }
    }
  }

  void bParar_mouseClicked(MouseEvent e)
  {
    if (mediaURL != null)
    {
      if( avanzarrapido ) // si estoy avanzando rápido y quiero parar
      {
        reproductor.stop(); // paro el sonido
        reproductor.setRate(1.f); // le pongo el rate a 1 que es el rate para reproducción normal
        reproductor = null;
        empezado = false;
        avanzarrapido = false;
        lInfor.setText("Estado: Parado");
      }
      else
      {
        reproductor.stop(); // paro el sonido
        reproductor = null; // pongo el sonido a nulo
        empezado = false; // le digo que puede volver a empezar de nuevo
        lInfor.setText("Estado: Parado");
      }
    }
  }

  void bAvance_mouseClicked(MouseEvent e)
  {
    if( reproductor != null )
    {
      reproductor.setRate(2.f); // le pongo el rate para que avanze rápido
      avanzarrapido = true;
      lInfor.setText("Estado: Avance rápido");
    }
  }

  void this_internalFrameClosed(InternalFrameEvent e)
  {
    if( reproductor != null )
      reproductor.stop(); // Cuando cierro la ventana paro el sonido
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

class Ventana_audio_bReproducir_mouseAdapter extends java.awt.event.MouseAdapter {
  Ventana_audio adaptee;

  Ventana_audio_bReproducir_mouseAdapter(Ventana_audio adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.bReproducir_mouseClicked(e);
  }
}

class Ventana_audio_bAbrir_mouseAdapter extends java.awt.event.MouseAdapter {
  Ventana_audio adaptee;

  Ventana_audio_bAbrir_mouseAdapter(Ventana_audio adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.bAbrir_mouseClicked(e);
  }
}

class Ventana_audio_bPausa_mouseAdapter extends java.awt.event.MouseAdapter {
  Ventana_audio adaptee;

  Ventana_audio_bPausa_mouseAdapter(Ventana_audio adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.bPausa_mouseClicked(e);
  }
}

class Ventana_audio_bParar_mouseAdapter extends java.awt.event.MouseAdapter {
  Ventana_audio adaptee;

  Ventana_audio_bParar_mouseAdapter(Ventana_audio adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.bParar_mouseClicked(e);
  }
}

class Ventana_audio_bAvance_mouseAdapter extends java.awt.event.MouseAdapter {
  Ventana_audio adaptee;

  Ventana_audio_bAvance_mouseAdapter(Ventana_audio adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.bAvance_mouseClicked(e);
  }
}

class Ventana_audio_this_internalFrameAdapter extends javax.swing.event.InternalFrameAdapter {
  Ventana_audio adaptee;

  Ventana_audio_this_internalFrameAdapter(Ventana_audio adaptee) {
    this.adaptee = adaptee;
  }
  public void internalFrameClosed(InternalFrameEvent e) {
    adaptee.this_internalFrameClosed(e);
  }
  public void internalFrameActivated(InternalFrameEvent e) {
    adaptee.this_internalFrameActivated(e);
  }
}
