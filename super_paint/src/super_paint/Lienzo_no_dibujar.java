package super_paint;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;



/**
 * <p>T�tulo: Pr�ctica de Sistemas Multimedia</p>
 * <p>Descripci�n: Pr�ctica de Sistemas Multimedia</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Empresa: Piratas Sin Fronteras S.A.</p>
 * @author Francisco Jes�s Delgado Almir�n
 * @version 1.0
 */

public class Lienzo_no_dibujar extends JPanel{

  private BufferedImage imagen;
  private Graphics2D g2d_imagen;

  /**
 * <p><u>Descripci�n</u>: Esta funci�n devuelve la imagen del lienzo.</p>
 * @return Imagen del lienzo
 */
  public BufferedImage getImagen()
  {
    return imagen;
  }

 /**
 * <p><u>Descripci�n</u>: Esta funci�n modifica la imagen del lienzo.</p>
 * @param i Imagen para sustituir por la del lienzo
 */
  public void setImagen(BufferedImage i)
  {
    imagen = i;
    g2d_imagen = imagen.createGraphics();
  }

  public void pintar_imagen()
  {
    g2d_imagen.drawImage(imagen,0,0,this);
  }

  public void paint(Graphics g)
  {
   super.paint(g);
   g2d_imagen = (Graphics2D) g;
   pintar_imagen();
  }

  public Lienzo_no_dibujar(BufferedImage i)
  {
    setImagen(i);
  }

  public Lienzo_no_dibujar()
  {
    imagen = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
    g2d_imagen = imagen.createGraphics();
    g2d_imagen.setPaint( Color.white );
    g2d_imagen.fill(new Rectangle2D.Float(0, 0, 300, 300));
  }


}
