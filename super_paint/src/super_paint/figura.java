package super_paint;

import java.awt.*;


/**
 * <p>T�tulo: Pr�ctica de Sistemas Multimedia</p>
 * <p>Descripci�n: Pr�ctica de Sistemas Multimedia</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Empresa: Piratas Sin Fronteras S.A.</p>
 * @author Francisco Jes�s Delgado Almir�n
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
   * <p><u>Descripci�n</u>: Devuelve el grosor de la l�nea de la figura</p>
   * @return Grosor de la l�nea de la figura
   */
  public int getTama()
  {
    return atrib.getGrosorLinea();
  }

  /**
  * <p><u>Descripci�n</u>: Esta funci�n devuelve la forma</p>
  * @return Forma
  */
  public Shape getObjetoDibujar()
  {
    return atrib.getForma();
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el tipo de relleno</p>
   * @return Tipo de relleno
   */
  public int getTipoTrazo()
  {
    return atrib.getTipoTrazo();
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el color del trazo</p>
   * @return Color del trazo de la figura
   */
  public Color getColor()
  {
    return atrib.getColorTrazo();
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el color del relleno</p>
   * @return Color del relleno
   */
  public Color getColorRelleno()
  {
    return atrib.getColorRelleno();
  }

}
