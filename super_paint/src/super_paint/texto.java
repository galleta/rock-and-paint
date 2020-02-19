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

public class texto extends objeto
{

  public texto(atributos at)
  {
    atrib = at;
  }

  public texto()
  {
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el color del texto.</p>
   * @return Color del texto
   */
  public Color getColor()
  {
    return atrib.getColorTrazo();
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el tama�o de la fuente del texto.</p>
   * @return Tama�o de la fuente
   */
  public int getTama()
  {
    return atrib.getTamaFuente();
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve si el texto est� en negrita.</p>
   * @return Verdadero si est� en negrita y falso sino
   */
  public boolean getNegrita()
  {
    return atrib.getNegrita();
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve si el texto est� en cursiva.</p>
   * @return Verdadero si est� en cursiva y falso sino
   */
  public boolean getCursiva()
  {
    return atrib.getCursiva();
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve si el texto est� subrayado.</p>
   * @return Verdadero si est� subrayado y falso sino
   */
  public boolean getSubrayado()
  {
    return atrib.getSubrayado();
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve si el texto est� tachado.</p>
   * @return Verdadero si est� tachado y falso sino
   */
  public boolean getTachado()
  {
    return atrib.getTachado();
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el nombre de la fuente.</p>
   * @return Nombre de la fuente en la que est� el texto.
   */
  public String getNombreFuente()
  {
    return atrib.getNombreFuente();
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el texto a dibujar.</p>
   * @return Texto a dibujar
   */
  public String getTexto()
  {
    return atrib.getTexto();
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el ppunto donde se dibujar� el texto.</p>
   * @return Punto donde se dibujar� el texto.
   */
  public Point getPuntoDibujarTexto()
  {
    return atrib.getPuntoDibujarTexto();
  }

}
