package super_paint;

import java.awt.*;


/**
 * <p>Título: Práctica de Sistemas Multimedia</p>
 * <p>Descripción: Práctica de Sistemas Multimedia</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Empresa: Piratas Sin Fronteras S.A.</p>
 * @author Francisco Jesús Delgado Almirón
 * @version 1.0
 */

public class figura extends objeto
{
  public figura(atributos a)
  {
    atrib = a;
  }

  public figura()
  {
  }

  /**
   * <p><u>Descripción</u>: Devuelve el grosor de la línea de la figura</p>
   * @return Grosor de la línea de la figura
   */
  public int getTama()
  {
    return atrib.getGrosorLinea();
  }

  /**
  * <p><u>Descripción</u>: Esta función devuelve la forma</p>
  * @return Forma
  */
  public Shape getObjetoDibujar()
  {
    return atrib.getForma();
  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve el tipo de relleno</p>
   * @return Tipo de relleno
   */
  public int getTipoTrazo()
  {
    return atrib.getTipoTrazo();
  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve el color del trazo</p>
   * @return Color del trazo de la figura
   */
  public Color getColor()
  {
    return atrib.getColorTrazo();
  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve el color del relleno</p>
   * @return Color del relleno
   */
  public Color getColorRelleno()
  {
    return atrib.getColorRelleno();
  }

}
