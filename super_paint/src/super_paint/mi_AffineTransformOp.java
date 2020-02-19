package super_paint;

import java.awt.Color;
import java.awt.geom.AffineTransform;

/**
 * <p>T�tulo: Pr�ctica de Sistemas Multimedia</p>
 * <p>Descripci�n: Pr�ctica de Sistemas Multimedia</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Empresa: Piratas Sin Fronteras S.A.</p>
 * @author Francisco Jes�s Delgado Almir�n
 * @version 1.0
 */

public class mi_AffineTransformOp extends objeto
{
  private AffineTransform transfor;

  public mi_AffineTransformOp()
  {
  }

  public mi_AffineTransformOp(AffineTransform at)
  {
    transfor = at;
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve la transformaci�n correspondiente.</p>
   * @return Transformaci�n
   */
  public AffineTransform getTransformacion()
  {
    return transfor;
  }

  /**
   * getColor
   *
   * @return Color
   */
  public Color getColor()
  {
    return null;
  }

  /**
   * getTama
   *
   * @return int
   */
  public int getTama() {
    return 0;
  }

}
