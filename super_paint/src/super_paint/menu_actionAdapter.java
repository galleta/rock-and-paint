package super_paint;

import java.awt.event.*;
import javax.swing.*;

/**
 * <p>Título: Práctica de Sistemas Multimedia</p>
 * <p>Descripción: Práctica de Sistemas Multimedia</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Empresa: Piratas Sin Fronteras S.A.</p>
 * @author Francisco Jesús Delgado Almirón
 * @version 1.0
 */

/*
Esta clase me la he creado para cuando tengo en el menú Ventanas todas las ventanas de imagen, música y vídeo, al hacerles
click (método actionPerformed) me ponga la ventana elegida al frente.
*/

public class menu_actionAdapter implements java.awt.event.ActionListener
{

  private Interfaz creador;
  private String titu;
  private JInternalFrame frame_interno;
  private int resta;

  public menu_actionAdapter() {
  }

  public menu_actionAdapter(Interfaz inter, String titulo, int restar) {
    titu = titulo;
    creador = inter;
    resta = restar;
  }

  /**
   * <p><u>Descripción</u>: Pone al frente la ventana a la que se le hace click.</p>
   * @param e ActionEvent
   */
  public void actionPerformed(ActionEvent e)
  {
    boolean seguirbuscando = true;
    JInternalFrame ventanas_abiertas[] = creador.escritorio.getAllFrames();

    for (int i = 0; i < ventanas_abiertas.length && seguirbuscando; i++)
    {
      if (ventanas_abiertas[i] instanceof Ventana_imagen)
      {
        if (ventanas_abiertas[i].getTitle().substring(0, ventanas_abiertas[i].getTitle().length() - resta).compareTo(titu) == 0)
        {
          frame_interno = (JInternalFrame)ventanas_abiertas[i];
          seguirbuscando = false;
        }
      }
      else
      {
          if (ventanas_abiertas[i] instanceof ventana_video)
          {
            if( ventanas_abiertas[i].getTitle().compareTo("Reproductor de vídeo - Sin archivo") == 0 )
            {
              frame_interno = (JInternalFrame)ventanas_abiertas[i];
            }
            else
            {
              if( ventanas_abiertas[i].getTitle().substring(23, ventanas_abiertas[i].getTitle().length()).compareTo(titu) == 0 )
               {
                 frame_interno = ventanas_abiertas[i];
                 seguirbuscando = true;
               }
            }
          }
          else
          {
              if( ventanas_abiertas[i] instanceof Ventana_audio )
              {
                if( ventanas_abiertas[i].getTitle().compareTo("Reproductor de sonido - Sin archivo") == 0 )
               {
                 if( ventanas_abiertas[i].getTitle().substring(24, ventanas_abiertas[i].getTitle().length()).compareTo(titu) == 0 )
                 {
                   frame_interno = ventanas_abiertas[i];
                   seguirbuscando = true;
                 }
               }
               else
               {
                   if( ventanas_abiertas[i].getTitle().substring(24, ventanas_abiertas[i].getTitle().length() - 4).compareTo(titu.substring(0,titu.length()-4)) == 0 )
                   {
                     frame_interno = ventanas_abiertas[i];
                     seguirbuscando = true;
                   }
               }
              }
          }
      }
    }

    frame_interno.toFront();
    try
    {
        frame_interno.setSelected(true);
    }
    catch (Exception ex)
    {
    }

  }
}
