package super_paint;

import java.awt.Color;

/**
 * <p>T�tulo: Pr�ctica de Sistemas Multimedia</p>
 * <p>Descripci�n: Pr�ctica de Sistemas Multimedia</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Empresa: Piratas Sin Fronteras S.A.</p>
 * @author Francisco Jes�s Delgado Almir�n
 * @version 1.0
 */

public class mi_BandCombineOp extends objeto
{
  float[][] array;

  public mi_BandCombineOp()
  {
  }

  public mi_BandCombineOp(float[][] cosa)
  {
    array = cosa;
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve la matriz correspondiente a la transformaci�n.</p>
   * @return Matriz de la transformaci�n
   */
  public float[][] getArray()
  {
    return array;
  }

  /**
   * getColor
   *
   * @return Color
   */
  public Color getColor() {
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
