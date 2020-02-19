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

public class mi_ConvolveOp extends objeto
{
  private float[] v;

  public mi_ConvolveOp(float [] a)
  {
    v = a;
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el filtro correspondiente a la transformaci�n.</p>
   * @return Array que contiene el filtro a aplicar
   */
  public float[] getFiltro()
  {
    return v;
  }

  public mi_ConvolveOp() {
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
