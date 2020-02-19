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

public abstract class objeto
{

  atributos atrib;

  public abstract int getTama();

  public abstract Color getColor();

  /**
   * objeto
   */
  public objeto()
  {
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el color 1 del degradado</p>
   * @return Color 1 del degradado
   */
  public Color getDegradado1()
  {
    return atrib.getDegradado1();
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el color 2 del degradado</p>
   * @return Color 2 del degradado
   */
  public Color getDegradado2()
  {
    return atrib.getDegradado2();
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el nivel de transparencia del texto, si la tiene.</p>
   * @return Nivel de transparencia del texto
   */
  public float getTransparencia()
  {
    return atrib.getTransparencia();
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve si el texto tiene relleno (degradado).</p>
   * @return Relleno del texto
   */
  public int getTipoRelleno()
  {
    return atrib.getTipoRelleno();
  }


}
