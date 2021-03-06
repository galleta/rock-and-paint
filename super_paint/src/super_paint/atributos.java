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

public class atributos
{

  private Shape forma;
  private int grosor_linea, tipo_relleno, tama_fuente, estilo_fuente, tipo_trazo;
  private float transparencia;
  private String texto, nombre_fuente;
  private Color trazo, relleno, degradado1, degradado2;
  private boolean negrita, cursiva, subrayado, tachado;
  private Point punto_dibujar_texto;

  public atributos()
  {
  }

  /**
   * <p><u>Descripci�n</u>: Constructor.</p>
   * @param forma Forma a almacenar
   * @param grosor_linea Grosor de la l�nea
   * @param tipo_relleno Tipo de relleno de la forma
   * @param trazo Color del trazo
   * @param relleno Color del relleno (si lo tiene)
   * @param transparencia Nivel de transparencia de la figura (si la tiene)
   * @param tama_fuente Tama�o de la fuente (si es texto)
   * @param estilo_fuente Estilo de la fuente (si es texto)
   * @param nombre_fuente Nombre de la fuente (si es texto)
   * @param texto Texto para escribir (si es texto)
   * @param degradado1 Color 1 del degradado (si tiene relleno degradado)
   * @param degradado2 Color 2 del degradado (si tiene relleno degradado)
   * @param tipo_trazo Tipo del trazo de la figura
   * @param negrita Verdadero si la letra est� en negrita (si es texto)
   * @param cursiva Verdadero si la letra est� en cursiva (si es texto)
   * @param subrayado Verdadero si la letra est� subrayada (si es texto)
   * @param tachado Verdadero si la letra est� tachada (si es texto)
   * @param punto_dibujar_texto Punto donde se dibujar� el texto (si es texto)
   */
  public atributos(Shape forma, int grosor_linea, int tipo_relleno, Color trazo,
                   Color relleno, float transparencia, int tama_fuente,
                   int estilo_fuente, String nombre_fuente, String texto,
                   Color degradado1, Color degradado2, int tipo_trazo, boolean negrita,
                   boolean cursiva, boolean subrayado, boolean tachado,
                   Point punto_dibujar_texto)
  {
    this.forma = forma;
    this.grosor_linea = grosor_linea;
    this.tipo_relleno = tipo_relleno;
    this.trazo = trazo;
    this.relleno = relleno;
    this.transparencia = transparencia;
    this.tama_fuente = tama_fuente;
    this.estilo_fuente = estilo_fuente;
    this.nombre_fuente = nombre_fuente;
    this.texto = texto;
    this.degradado1 = degradado1;
    this.degradado2 = degradado2;
    this.tipo_trazo = tipo_trazo;
    this.negrita = negrita;
    this.cursiva = cursiva;
    this.subrayado = subrayado;
    this.tachado = tachado;
    this.punto_dibujar_texto = punto_dibujar_texto;
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el grosor de l�nea</p>
   * @return Grosor de l�nea
   */
  public int getGrosorLinea()
  {
    return grosor_linea;
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve la forma</p>
   * @return Forma
   */
  public Shape getForma()
  {
    return forma;
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el nivel de transparencia</p>
   * @return Nivel de transparencia
   */
  public float getTransparencia()
  {
    return transparencia;
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el tipo de relleno</p>
   * @return Tipo de relleno
   */
  public int getTipoTrazo()
  {
    return tipo_trazo;
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el color del trazo</p>
   * @return Color del trazo de la figura
   */
  public Color getColorTrazo()
  {
    return trazo;
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el tipo de relleno</p>
   * @return Tipo de relleno
   */
  public int getTipoRelleno()
  {
    return tipo_relleno;
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el color del relleno</p>
   * @return Color del relleno
   */
  public Color getColorRelleno()
  {
    return relleno;
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el color 1 del degradado</p>
   * @return Color 1 del degradado
   */
  public Color getDegradado1()
  {
    return degradado1;
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el color 2 del degradado</p>
   * @return Color 2 del degradado
   */
  public Color getDegradado2()
  {
    return degradado2;
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el tama�o de la fuente si es texto</p>
   * @return Tama�o de la fuente
   */
  public int getTamaFuente()
  {
    return tama_fuente;
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve si la letra est� en negrita si es texto</p>
   * @return Verdadero si est� en negrita y falso sino
   */
  public boolean getNegrita()
  {
    return negrita;
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve si la letra est� en cursiva si es texto</p>
   * @return Verdadero si est� en cursiva y falso sino
   */
  public boolean getCursiva()
  {
    return cursiva;
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve si la letra est� subrayada si es texto</p>
   * @return Verdadero si est� subrayada y falso sino
   */
  public boolean getSubrayado()
  {
    return subrayado;
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve si la letra est� tachada si es texto</p>
   * @return Verdadero si est� tachada y falso sino
   */
  public boolean getTachado()
  {
    return tachado;
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el nombre de la fuente si es texto</p>
   * @return Nombre de la fuente
   */
  public String getNombreFuente()
  {
    return nombre_fuente;
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el texto a dibujar</p>
   * @return Texto a dibujar
   */
  public String getTexto()
  {
    return texto;
  }

  /**
   * <p><u>Descripci�n</u>: Esta funci�n devuelve el punto para dibujar el texto</p>
   * @return Punto para dibujar el texto
   */
  public Point getPuntoDibujarTexto()
  {
    return punto_dibujar_texto;
  }

}
