package super_paint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileFilter;
import java.beans.*;



/**
 * <p>Título: Práctica de Sistemas Multimedia</p>
 * <p>Descripción: Práctica de Sistemas Multimedia</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Empresa: Piratas Sin Fronteras S.A.</p>
 * @author Francisco Jesús Delgado Almirón
 * @version 1.0
 */

public class Interfaz extends JFrame
{

  Ventana_formas formas_dib = new Ventana_formas(this);
  ventana_colores ven_col = new ventana_colores(this);
  ventana_atributos ven_atri = new ventana_atributos(this);

  JDesktopPane escritorio = new JDesktopPane();

  JPanel contentPane;
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanelCentral = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanelDibujo = new JPanel();
  JPanel jPanelBarraEstado = new JPanel();
  JPanel jPanel1 = new JPanel();
  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanel15 = new JPanel();
  JPanel jPanel27 = new JPanel();
  FlowLayout flowLayout2 = new FlowLayout();
  JLabel lFecha = new JLabel();

  JMenuBar jMenuBar1 = new JMenuBar();
  JMenu jMenuArchivo = new JMenu();
  JMenu jMenuEdicion = new JMenu();
  JMenu jMenuReproducir = new JMenu();
  JMenu jMenuAyuda = new JMenu();
  JMenuItem jMenuReproducirMusica = new JMenuItem();
  JMenuItem jMenuReproducirVideo = new JMenuItem();
  JMenuItem jMenuAcercaDe = new JMenuItem();
  JLabel lPosicionesRaton = new JLabel();

  // ***** Variables privadas de la clase *****
  private Ventana_imagen ultima_imagen_seleccionada;
  private boolean negrita = false, cursiva = false, subrayado = false, tachado = false,
      definirdegradado1 = true, definirdegradado2 = false;
  private int tipo_objeto = 0, grosor_de_linea = 3, tipo_relleno = 0,
      tipo_trazo = 0, tama_fuente = 12;
  private Color color_actual_relleno = Color.white,
      color_actual_trazo = Color.black, color_borrar = Color.white,
      degradado1 = Color.BLUE, degradado2 = Color.YELLOW;
  private String texto, fuente;
  private ImageIcon activado;
  private float transparencia = 1.0f;
  int num_ventanas_filtros = 0;

  // ***** Estas variables necesitan no ser privadas *****
  ImageIcon fondo = null;
  JLabel labelFondo = null;
  // *****************************************************

  BorderLayout borderLayout10 = new BorderLayout();
  JMenuItem jMenuImprimir = new JMenuItem();
  JMenuItem jMenuGuardar = new JMenuItem();
  JMenuItem jMenuAbrirImagen = new JMenuItem();
  JMenuItem jMenuNuevaImagen = new JMenuItem();
  JMenu jMenuVer = new JMenu();
  JMenuItem jMenuAtributos = new JMenuItem();
  JMenuItem jMenuHerramientas = new JMenuItem();
  JMenuItem jMenuColores = new JMenuItem();
  JMenuItem jMenuDeshacer = new JMenuItem();
  JMenuItem jMenuRehacer = new JMenuItem();
  JMenu jMenuVentanas = new JMenu();
  JMenuItem jMenuSalir = new JMenuItem();
  JMenuItem jMenuFiltros = new JMenuItem();
  JMenuItem jMenuHistograma = new JMenuItem();

  // *******************************************

  /**
   * <p><u>Descripción</u>: Esta función actualiza la última ventana que se tiene seleccionada</p>
   * @param ima Ventana que se tiene seleccionada
   */
  void setUltimaVentanaImagenSeleccionada(Ventana_imagen ima)
  {
    ultima_imagen_seleccionada = ima;
  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve la última ventana que se ha tenido seleccionada</p>
   * @return Ventana que se ha tenido seleccionada
   */
  Ventana_imagen getUltimaVentanaImagenSeleccionada()
  {
    return ultima_imagen_seleccionada;
  }

  /**
   * <p><u>Descripción</u>: Esta función modifica el grado de la forma a dibujar.</p>
   * @param trans Grado de transparencia.
   */
  public void setTransparencia(float trans) {
    transparencia = trans;
  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve el grado de la forma a dibujar.</p>
   * @return El grado de transparencia dela imagen.
   */
  public float getTransparencia() {
    return transparencia;
  }

  /**
   * <p><u>Descripción</u>: Esta función indica si hay que definir el degradado 1.</p>
   * @param estado Verdadero si hay que definirlo y falso sino
   */
  public void setDefinirDegradado1(boolean estado) {
    definirdegradado1 = estado;
  }

  /**
   * <p><u>Descripción</u>: Esta función indica si hay que definir el degradado 2.</p>
   * @param estado Verdadero si hay que definirlo y falso sino
   */
  public void setDefinirDegradado2(boolean estado) {
    definirdegradado2 = estado;
  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve si hay que definir el degradado 1.</p>
   * @return Verdadero si hay que definirlo y falso sino
   */
  public boolean getDefinirDegradado1() {
    return definirdegradado1;
  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve si hay que definir el degradado 2.</p>
   * @return Verdadero si hay que definirlo y falso sino
   */
  public boolean getDefinirDegradado2() {
    return definirdegradado2;
  }

  /**
   * <p><u>Descripción</u>: Esta función modifica el primer color del degradado.</p>
   * @param col Color para el primer degradado
   */
  public void setDegradado1(Color col) {
    degradado1 = col;
  }

  /**
   * <p><u>Descripción</u>: Esta función modifica el segundo color del degradado.</p>
   * @param col Color para el segundo degradado
   */
  public void setDegradado2(Color col) {
    degradado2 = col;
  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve el primer color del degradado.</p>
   * @return Color 1 del degradado
   */
  public Color getDegradado1() {
    return degradado1;
  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve el segundo color del degradado.</p>
   * @return Color 2 del degradado
   */
  public Color getDegradado2() {
    return degradado2;
  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve el texto para dibujar.</p>
   * @return Texto para dibujar
   */
  public String getTexto() {
    return texto;
  }

  /**
   * <p><u>Descripción</u>: Esta función modifica el texto para dibujar.</p>
   * @param t Texto para dibujar
   */
  public void setTexto(String t) {
    texto = t;
  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve el tamaño de la fuente para dibujar texto.</p>
   * @return Tamaño de la fuente
   */
  public int getTamaFuente() {
    return tama_fuente;
  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve la fuente para dibujar texto.</p>
   * @return Fuente seleccionada
   */
  public String getFuente() {
    return fuente;
  }

  /**
   * <p><u>Descripción</u>: Esta función modifica el valor de la fuente para dibujar texto.</p>
   * @param f Fuente nueva
   */
  public void setFuente(String f) {
    fuente = f;
  }

  /**
   * <p><u>Descripción</u>: Esta función modifica el tamaño de la fuente para dibujar texto.</p>
   * @param tam Tamaño nuevo de la fuente
   */
  public void setTamaFuente(int tam) {
    tama_fuente = tam;
  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve el estado de la variable negrita.</p>
   * @return Verdadero si está seleccionada o falso sino
   */
  public boolean negrita() {
    return negrita;
  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve el estado de la variable cursiva.</p>
   * @return Verdadero si está seleccionada o falso sino
   */
  public boolean cursiva() {
    return cursiva;
  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve el estado de la variable subrayado.</p>
   * @return Verdadero si está seleccionada o falso sino
   */
  public boolean subrayado() {
    return subrayado;
  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve el estado de la variable tachado.</p>
   * @return Verdadero si está seleccionada o falso sino
   */
  public boolean tachado() {
    return tachado;
  }

  /**
   * <p><u>Descripción</u>: Esta función cambia el estado de la variable negrita.</p>
   * @param estado Verdadero o Falso
   */
  public void cambiarNegrita(boolean estado) {
    negrita = estado;
  }

  /**
   * <p><u>Descripción</u>: Esta función cambia el estado de la variable cursiva.</p>
   * @param estado Verdadero o Falso
   */
  public void cambiarCursiva(boolean estado) {
    cursiva = estado;
  }

  /**
   * <p><u>Descripción</u>: Esta función cambia el estado de la variable subrayado.</p>
   * @param estado Verdadero o Falso
   */
  public void cambiarSubrayado(boolean estado) {
    subrayado = estado;
  }

  /**
   * <p><u>Descripción</u>: Esta función cambia el estado de la variable tachado.</p>
   * @param estado Verdadero o Falso
   */
  public void cambiarTachado(boolean estado) {
    tachado = estado;
  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve el tipo de objeto seleccionado.</p>
   * @return El tipo de objeto seleccionado
   */
  public int getTipoObjeto() {
    return tipo_objeto;
  }

  /**
   * <p><u>Descripción</u>: Esta función modifica el tipo de objeto seleccionado.</p>
   * @param n Objeto a modificar
   */
  public void setTipoObjeto(int n) {
    tipo_objeto = n;
  }

  /**
   * <p><u>Descripción</u>: Esta función hace que aparezca la ventana de los atributos.</p>
   */
  public void mostrar_ventana_atributos() {
    escritorio.setForeground(Color.black);
    escritorio.setOpaque(false);
    escritorio.add(ven_atri);
    ven_atri.setLocation(0, 213);
    ven_atri.setSize(230, 180);
    ven_atri.setVisible(true);
  }

  /**
   * <p><u>Descripción</u>: Esta función hace que aparezca la ventana de las formas que se pueden dibujar.</p>
   */
  public void mostrar_ventana_formas() {
    escritorio.setForeground(Color.black);
    escritorio.setOpaque(false);
    escritorio.add(formas_dib);
    formas_dib.setSize(140, 210);
    formas_dib.setVisible(true);
  }

  /**
   * <p><u>Descripción</u>: Esta función hace que aparezca la ventana de los colores.</p>
   */
  public void mostrar_ventana_colores()
  {
    escritorio.add(ven_col);
    ven_col.setLocation( ( (int) Toolkit.getDefaultToolkit().getScreenSize().
                          getWidth()) - 145, 0);
    ven_col.setSize(140, 230);
    ven_col.setVisible(true);
  }

  /**
   * <p><u>Descripción</u>: Esta función hace que aparezca la ventana de los filtros.</p>
   */
  public void mostrar_ventana_filtros()
  {
    if( ultima_imagen_seleccionada != null )
    {
      ventana_filtros ven_fil = new ventana_filtros(ultima_imagen_seleccionada);
      escritorio.add(ven_fil);
      ven_fil.setLocation(145, 0);

      if( ultima_imagen_seleccionada.jPanelDibujar.getImagen().getWidth() > Toolkit.getDefaultToolkit().getScreenSize().getWidth() && ultima_imagen_seleccionada.jPanelDibujar.getImagen().getHeight() > Toolkit.getDefaultToolkit().getScreenSize().getHeight() )
        {
          ven_fil.setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 200, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 200);
        }
        else
        {
          ven_fil.setSize(ultima_imagen_seleccionada.jPanelDibujar.getImagen().getWidth() + 111, ultima_imagen_seleccionada.jPanelDibujar.getImagen().getHeight() + 60);
        }

      ven_fil.setVisible(true);
      num_ventanas_filtros++;
    }
}


  /**
   * <p><u>Descripción</u>: Esta función devuelve el grosor seleccionado para la línea.</p>
   * @return Grosor seleccionado
   */
  public int getGrosor() {
    return grosor_de_linea;
  }

  /**
   * <p><u>Descripción</u>: Esta función modifica el grosor seleccionado para la línea.</p>
   * @param gro Grosor deseado
   */
  public void setGrosor(int gro) {
    grosor_de_linea = gro;
  }

  /**
   * <p><u>Descripción</u>: Esta función modifica el color del trazo para la línea.</p>
   * @param c Color a poner el trazo del programa
   */
  public void setColorTrazo(Color c) {
    color_actual_trazo = c;
  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve el color del trazo de la línea.</p>
   * @return El color del trazo
   */
  public Color getColorTrazo() {
    return color_actual_trazo;
  }

  /**
   * <p><u>Descripción</u>: Esta función modifica el color del relleno para la línea.</p>
   * @param c Color a poner el relleno del programa
   */
  public void setColorRelleno(Color c) {
    color_actual_relleno = c;
  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve el color del relleno de la línea.</p>
   * @return El color del relleno
   */
  public Color getColorRelleno() {
    return color_actual_relleno;
  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve el tipo de relleno: 0 -> Sin relleno, 1 -> Relleno liso, 2 -> Relleno degradado.</p>
   * @return Devuelve el tipo de relleno
   */
  public int getTipoRelleno() {
    return tipo_relleno;
  }

  /**
   * <p><u>Descripción</u>: Esta función modifica el tipo de relleno para dibujar: 0 -> Sin relleno, 1 -> Relleno liso, 2 -> Relleno degradado.</p>
   * @param relle Tipo de relleno
   */
  public void setTipoRelleno(int relle) {
    tipo_relleno = relle;
  }

  /**
   * <p><u>Descripción</u>: Esta función muestra los puntos donde se sitúa el ratón en la imagen.</p>
   * @param x Coordenada x donde está situado el ratón
   * @param y Coordenada y donde está situado el ratón
   */
  public void mostrar_posicion_raton(int x, int y) {
    lPosicionesRaton.setText(x + ", " + y);
  }

  /**
   * <p><u>Descripción</u>: Esta función elimina las coordenadas de los puntos donde se sitúa el ratón en la imagen.</p>
   */
  public void ocultar_posicion_raton() {
    lPosicionesRaton.setText("              ");
  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve el tipo de trazo seleccionado para dibujar.</p>
   * @return El tipo de trazo seleccionado
   */
  public int getTipoTrazo() {
    return tipo_trazo;
  }

  /**
   * <p><u>Descripción</u>: Esta función modifica el tipo de trazo para dibujar.</p>
   * @param t Tipo de trazo
   */
  public void setTipoTrazo(int t) {
    tipo_trazo = t;
  }

  /**
   * <p><u>Descripción</u>: Esta función modifica el color de fondo de la imagen.</p>
   * @param c Color de fondo de la imagen
   */
  public void setColorFondo(Color c) {
    color_borrar = c;
  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve el color de fondo de la imagen.</p>
   * @return Color de fondo de la imagen
   */
  public Color getColorFondo() {
    return color_borrar;
  }

  /**
   * <p><u>Descripción</u>: Esta función agrega un nuevo menu a ventanas.</p>
   * @param menu Menu para insertar
   */
  public void nueva_ventana(JMenu menu) {
    jMenuVentanas.add(menu);
  }

  /**
   * <p><u>Descripción</u>: Esta función devuelve el nombre del fichero con extensión que se le pasa por parámetro.</p>
   * @param fichero Fichero con extensión
   * @return El nombre del fichero
   */
  public String getNombre(String fichero) {
    boolean parar = false;
    int i;
    String nombre = null;
    for (i = 0; i < fichero.length() && !parar; i++) {
      if (fichero.charAt(i) == '.') { // si fichero[i] es igual al punto
        parar = true;
      }
    }

    nombre = fichero.substring(0, i - 1);

    return nombre;
  }

  //Construir el marco
  public Interfaz() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  //Inicialización de componentes
  private void jbInit() throws Exception
  {

    jMenuVer.add(jMenuAtributos);
    jMenuAtributos.setText("Herramientas");

    jMenuAtributos.addActionListener(new herramientas_action(this));

    jMenuAtributos.setVisible(true);

    // ***** FONDO PARA EL PROGRAMA *****

    // Según la resolución de pantalla del usuario cargo una imagen u otra
    if (Toolkit.getDefaultToolkit().getScreenSize().getHeight() == 600 &&
        Toolkit.getDefaultToolkit().getScreenSize().getWidth() == 800) {
      // Resolución de pantalla 800x600
      fondo = new ImageIcon("imagenes/fondo_800x600.jpg");
    }
    else {
      if (Toolkit.getDefaultToolkit().getScreenSize().getHeight() == 768.0 &&
          Toolkit.getDefaultToolkit().getScreenSize().getWidth() == 1024.0) {
        // Resolución de pantalla 1024x768
        fondo = new ImageIcon("imagenes/fondo_1024x768.jpg");
      }
      else {
        // Resolución de pantalla 1280x1024
        fondo = new ImageIcon("imagenes/fondo_1280x1024.jpg");
      }
    }

    labelFondo = new JLabel(fondo);

    labelFondo.setBounds(0, 0, fondo.getIconWidth(), fondo.getIconHeight());
    jMenuVentanas.setText("Ventanas");
    jMenuColores.addActionListener(new Interfaz_jMenuColores_actionAdapter(this));
    jMenuSalir.setText("Salir");
    jMenuSalir.addActionListener(new Interfaz_jMenuSalir_actionAdapter(this));
    jMenuReproducirVideo.addActionListener(new
        Interfaz_jMenuReproducirVideo_actionAdapter(this));
    jMenuFiltros.setText("Filtros");
    jMenuHistograma.setText("Histograma");
    jMenuHistograma.addActionListener( new menu_histograma(this) );
    jMenuFiltros.addActionListener(new Interfaz_jMenuFiltros_actionAdapter(this));
    this.setJMenuBar(jMenuBar1);
    escritorio.add(labelFondo, escritorio.DEFAULT_LAYER);

    // **********************************

    ImageIcon imprimir = new ImageIcon("iconos/imprimir.gif");
    jMenuImprimir.setIcon(imprimir);
    jMenuImprimir.setEnabled(false);
    ImageIcon guardar = new ImageIcon("iconos/guardar.gif");
    jMenuGuardar.setActionCommand("Guardar");
    jMenuGuardar.setIcon(guardar);
    jMenuGuardar.setEnabled(false);
    jMenuGuardar.setSelectedIcon(null);
    ImageIcon paint = new ImageIcon("iconos/paint.gif");
    this.setIconImage(paint.getImage());
    ImageIcon abrir_imagen = new ImageIcon("iconos/abrir.gif");
    jMenuAbrirImagen.setIcon(abrir_imagen);
    ImageIcon nuevo = new ImageIcon("iconos/nuevo.gif");
    jMenuNuevaImagen.setIcon(nuevo);
    ImageIcon musica = new ImageIcon("iconos/tipo_audio.gif");
    jMenuReproducirMusica.setIcon(musica);
    ImageIcon video = new ImageIcon("iconos/tipo_video.gif");
    jMenuReproducirVideo.setIcon(video);
    ImageIcon deshacer = new ImageIcon("iconos/deshacer.gif");
    jMenuDeshacer.setIcon(deshacer);
    ImageIcon rehacer = new ImageIcon("iconos/rehacer.gif");
    jMenuRehacer.setIcon(rehacer);
    jMenuDeshacer.setEnabled(false);
    jMenuRehacer.setEnabled(false);

    reloj_fecha fecha = new reloj_fecha(this);
    fecha.start();

    mostrar_ventana_formas(); // muestro la ventana de atributos de dibujo
    mostrar_ventana_colores(); // muestro la ventana de los colores
    //mostrar_ventana_atributos();

    // ***** Maximizo la ventana *****
    this.setExtendedState(this.MAXIMIZED_BOTH);
    // *******************************//

    contentPane = (JPanel)this.getContentPane();
    contentPane.setLayout(borderLayout1);
    this.setSize(new Dimension(675, 520));
    this.setTitle("Rock'n'Paint");
    jPanelCentral.setLayout(borderLayout2);
    jPanelBarraEstado.setBorder(BorderFactory.createEtchedBorder());
    jPanelBarraEstado.setLayout(borderLayout5);
    jPanel27.setLayout(flowLayout2);
    jPanel27.setBorder(BorderFactory.createEtchedBorder());
    jMenuArchivo.setMnemonic('A');
    jMenuArchivo.setText("Archivo");
    jMenuEdicion.setMnemonic('E');
    jMenuEdicion.setText("Edición");
    jMenuReproducir.setMnemonic('R');
    jMenuReproducir.setText("Reproducir");
    jMenuAyuda.setText("Ayuda");
    jMenuReproducirMusica.setText("Reproducir música");
    jMenuReproducirMusica.addActionListener(new
        Interfaz_jMenuReproducirMusica_actionAdapter(this));
    jMenuReproducirVideo.setText("Reproducir vídeo");
    jMenuAcercaDe.setText("Acerca de Rock\'n\'Paint...");
    jMenuAcercaDe.addActionListener(new Interfaz_jMenuAcercaDe_actionAdapter(this));
    jPanel1.setBorder(BorderFactory.createEtchedBorder());
    jPanel1.setToolTipText("");
    lPosicionesRaton.setText("              ");
    jPanelDibujo.setLayout(borderLayout10);
    jMenuImprimir.setText("Imprimir...");
    jMenuImprimir.addActionListener(new Interfaz_jMenuImprimir_actionAdapter(this));
    jMenuNuevaImagen.setText("Nueva imagen");
    jMenuNuevaImagen.addActionListener(new
                                       Interfaz_jMenuNuevaImagen_actionAdapter(this));
    jMenuAbrirImagen.setText("Abrir imagen");
    jMenuAbrirImagen.addActionListener(new
                                       Interfaz_jMenuAbrirImagen_actionAdapter(this));
    jMenuGuardar.setText("Guardar");
    jMenuGuardar.addActionListener(new Interfaz_jMenuGuardar_actionAdapter(this));
    jMenuVer.setText("Ver");
    jMenuHerramientas.setText("Formas");
    jMenuHerramientas.addActionListener(new
        Interfaz_jMenuHerramientas_actionAdapter(this));
    jMenuBar1.addMouseListener(new Interfaz_jMenuBar1_mouseAdapter(this));
    jMenuColores.setText("Colores");
    jMenuDeshacer.setText("Deshacer");
    jMenuRehacer.setText("Rehacer");
    jMenuDeshacer.addActionListener(new Interfaz_jMenuDeshacer_actionAdapter(this));
    jMenuRehacer.addActionListener(new Interfaz_jMenuRehacer_actionAdapter(this));
    contentPane.add(jPanelCentral, BorderLayout.CENTER);

    jPanelCentral.add(jPanelDibujo, BorderLayout.CENTER);
    contentPane.add(jPanelBarraEstado, BorderLayout.SOUTH);
    jPanelBarraEstado.add(jPanel1, BorderLayout.WEST);
    jPanel1.add(lPosicionesRaton, null);
    jPanelBarraEstado.add(jPanel15, BorderLayout.CENTER);
    jPanelBarraEstado.add(jPanel27, BorderLayout.EAST);
    jPanel27.add(lFecha, null);
    jMenuBar1.add(jMenuArchivo);
    jMenuBar1.add(jMenuEdicion);
    jMenuBar1.add(jMenuVer);
    jMenuBar1.add(jMenuReproducir);
    jMenuBar1.add(jMenuVentanas);
    jMenuBar1.add(jMenuAyuda);
    jMenuReproducir.add(jMenuReproducirMusica);
    jMenuReproducir.add(jMenuReproducirVideo);
    jMenuAyuda.add(jMenuAcercaDe);

    jPanelDibujo.add(escritorio, BorderLayout.CENTER);
    jMenuArchivo.add(jMenuNuevaImagen);
    jMenuArchivo.add(jMenuAbrirImagen);
    jMenuArchivo.add(jMenuGuardar);
    jMenuArchivo.addSeparator();
    jMenuArchivo.add(jMenuImprimir);
    jMenuArchivo.addSeparator();
    jMenuArchivo.add(jMenuSalir);
    jMenuVer.add(jMenuHerramientas);
    jMenuVer.add(jMenuColores);
    jMenuVer.add(jMenuFiltros);
    jMenuHistograma.setEnabled(false);
    jMenuVer.add(jMenuHistograma);
    jMenuEdicion.add(jMenuDeshacer);
    jMenuEdicion.add(jMenuRehacer);
  }

  //Modificado para poder salir cuando se cierra la ventana
  protected void processWindowEvent(WindowEvent e) {
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      if (JOptionPane.showConfirmDialog(this, "¿Cerrar Rock'n'Paint?",
                                        "Rock'n'Paint",
                                        JOptionPane.YES_NO_OPTION) == 0) {
        System.exit(0);
      }
    }
  }

  void jMenuReproducirMusica_actionPerformed(ActionEvent e) {
    // ***** Creo y muestro la ventana para reproducir música *****
    Ventana_audio musica = new Ventana_audio(this);
    musica.setSize(450, 120);
    // centro la ventana
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = musica.getSize();
    if (frameSize.height > screenSize.height)
      frameSize.height = screenSize.height;
    if (frameSize.width > screenSize.width)
      frameSize.width = screenSize.width;
    musica.setLocation( (screenSize.width - frameSize.width) / 2,
                       (screenSize.height - frameSize.height) / 2);

    musica.setVisible(true);

    escritorio.remove(labelFondo); // borro el fondo

    escritorio.add(musica); // pongo la ventana de reproducción de música

    musica.toFront(); // pongo la ventana de musica al frente
    try {
      musica.setSelected(true);
    }
    catch (PropertyVetoException ex) {
    }

    escritorio.add(labelFondo, escritorio.DEFAULT_LAYER); // vuelvo a poner el fondo
    // ************************************************************
  }

  void jMenuAcercaDe_actionPerformed(ActionEvent e) {
    JOptionPane.showMessageDialog(this, "Alumno: Francisco Jesús Delgado Almirón\nDNI: 14630694-A\nSistemas Multimedia 2.009 - 2.010\n\nCualquier parecido con el Paint o con el\nPhotoshop, es producto de tu imaginación :D",
                                  "Acerca de Rock'n'Paint",
                                  JOptionPane.INFORMATION_MESSAGE);
  }

  void jMenuImprimir_actionPerformed(ActionEvent e) {
    // Solo imprimirá si se tiene seleccionada una ventana de imagen
    if (escritorio.getSelectedFrame() instanceof Ventana_imagen) {
      PrintJob pj; // me declaro el objeto "ventana de impresión"
      Graphics g_imprimir; // me declaro el graphics para pintar en la impresora
      pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "SCAT", null);
      try { // imprimo la imagen de la ventana de dibujo seleccionada :)
        g_imprimir = pj.getGraphics();
        g_imprimir.drawImage( (Image) ( (Ventana_imagen) escritorio.
                                       getSelectedFrame()).jPanelDibujar.
                             getImagen(), 0, 0, this);
        g_imprimir.dispose();
        pj.end();
      }
      catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "La impresión ha sido cancelada.",
                                      "Error de impresión",
                                      JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  void jMenuNuevaImagen_actionPerformed(ActionEvent e) {
    Ventana_dimensiones ima = new Ventana_dimensiones(this);
    ima.setSize(200, 170);
    // centro la ventana
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = ima.getSize();
    if (frameSize.height > screenSize.height)
      frameSize.height = screenSize.height;
    if (frameSize.width > screenSize.width)
      frameSize.width = screenSize.width;
    ima.setLocation( (screenSize.width - frameSize.width) / 2,
                    (screenSize.height - frameSize.height) / 2);
    ima.setVisible(true);
  }

  void jMenuAbrirImagen_actionPerformed(ActionEvent e) {
    // ***** OPCION DE ABRIR IMAGEN *****
    BufferedImage ima = null;
    JFileChooser abrir_imagen = new JFileChooser();

    // ***** Me declaro los filtros *****
    FileFilter jpg = new Filtro("Archivos jpg", ".jpg"),
        gif = new Filtro("Archivos gif", ".gif");
    FileFilter jpeg = new Filtro("Archivos jpeg", ".jpeg"),
        png = new Filtro("Archivos png", ".png");
    abrir_imagen.addChoosableFileFilter(gif);
    abrir_imagen.addChoosableFileFilter(png);
    abrir_imagen.addChoosableFileFilter(jpeg);
    abrir_imagen.addChoosableFileFilter(jpg);
    // **********************************

    setColorFondo(Color.white);

    if (abrir_imagen.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
      try
      {
        File f = new File(abrir_imagen.getSelectedFile().getAbsolutePath());

        ima = ImageIO.read(f);
        BufferedImage img_aux;

        if ( ( (Filtro) abrir_imagen.getFileFilter()).getExtension().compareTo(
            ".gif") == 0) {
          img_aux = new BufferedImage(ima.getWidth(), ima.getHeight(),
                                      BufferedImage.TYPE_BYTE_INDEXED);
          Graphics2D g2d_aux = img_aux.createGraphics();
          g2d_aux.drawImage(ima, 0, 0, null);
        }

        // ***** Creo y muestro la ventana de la imagen *****
        Ventana_imagen imagen = new Ventana_imagen(this, getNombre(abrir_imagen.getSelectedFile().getName()), ima.getWidth(), ima.getHeight(), ima);

        // ***** Si el tamaño es mas grande que la resolución de pantalla se hace la ventana mas pequeña
        if( ima.getWidth() > Toolkit.getDefaultToolkit().getScreenSize().getWidth() && ima.getHeight() > Toolkit.getDefaultToolkit().getScreenSize().getHeight() )
        {
          imagen.setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 200, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 200);
        }
        else
        {
          imagen.setSize(ima.getWidth() + 12, ima.getHeight() + 37);
        }

        // ***** Centro la ventana *****
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = imagen.getSize();
        if (frameSize.height > screenSize.height)
          frameSize.height = screenSize.height;
        if (frameSize.width > screenSize.width)
          frameSize.width = screenSize.width;
        imagen.setLocation( (screenSize.width - frameSize.width) / 2,
                           (screenSize.height - frameSize.height) / 2);

        imagen.setVisible(true);

        escritorio.remove(labelFondo);

        escritorio.add(imagen);

        imagen.toFront(); // pongo la imagen al frente
        try {
          imagen.setSelected(true);
        }
        catch (PropertyVetoException ex) {
        }

        escritorio.add(labelFondo, escritorio.DEFAULT_LAYER);

      }
      catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error de lectura en la imagen.",
                                      "ERROR", JOptionPane.ERROR_MESSAGE);
      }

    }
  }

  void jMenuGuardar_actionPerformed(ActionEvent e) {
    if (escritorio.getSelectedFrame() instanceof Ventana_imagen) {
      Ventana_imagen vi = (Ventana_imagen) escritorio.getSelectedFrame();

      JFileChooser guardar_imagen = new JFileChooser();

      // ***** Me declaro los filtros *****
      FileFilter jpg = new Filtro("JPG (*.jpg)", ".jpg");
      FileFilter jpeg = new Filtro("JPEG (*.jpeg)", ".jpeg");
      FileFilter png = new Filtro("PNG (*.png)", ".png");
      guardar_imagen.addChoosableFileFilter(png);
      guardar_imagen.addChoosableFileFilter(jpeg);
      guardar_imagen.addChoosableFileFilter(jpg);
      // **********************************

      if (guardar_imagen.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
        try {
          File fichero = new File(guardar_imagen.getSelectedFile() +
                                  ( (Filtro) guardar_imagen.getFileFilter()).
                                  getExtension());
          if ( ( (Filtro) guardar_imagen.getFileFilter()).getExtension().
              compareTo(".jpg") == 0) {
            ImageIO.write(vi.jPanelDibujar.getImagen(), "jpg", fichero);
          }
          else
          if ( ( (Filtro) guardar_imagen.getFileFilter()).getExtension().
              compareTo(".jpeg") == 0) {
            ImageIO.write(vi.jPanelDibujar.getImagen(), "jpeg", fichero);
          }
          else
          if ( ( (Filtro) guardar_imagen.getFileFilter()).getExtension().
              compareTo(".png") == 0) {
            ImageIO.write(vi.jPanelDibujar.getImagen(), "png", fichero);
          }

          vi.setTitle(guardar_imagen.getSelectedFile().getName() +
                      " - Rock'n'Paint");
        }
        catch (IOException ex) {
          JOptionPane.showMessageDialog(this, "Error de escritra de la imagen.",
                                        "ERROR", JOptionPane.ERROR_MESSAGE);
        }
      }

      vi.jPanelDibujar.borrar_buffer();

    }
  }

  void jMenuHerramientas_actionPerformed(ActionEvent e) {
    if (!formas_dib.isVisible())
      mostrar_ventana_formas();
  }

  void jMenuBar1_mouseEntered(MouseEvent e) {

    // ***** Pongo las ventanas que están abiertas *****

    JMenuItem menu;
    jMenuVentanas.removeAll();
    JInternalFrame ventanicas[] = escritorio.getAllFrames();

    for (int i = 0; i < ventanicas.length; i++) {
      if (ventanicas[i] instanceof Ventana_imagen) { // Ventana del tipo imagen
        menu = new JMenuItem();
        menu.setText(ventanicas[i].getTitle().substring(0,
            ventanicas[i].getTitle().length() - 15));
        menu.setIcon(new ImageIcon("iconos/tipo_imagen.gif"));

        menu.addActionListener(new menu_actionAdapter(this,
            ventanicas[i].
            getTitle().substring(0, ventanicas[i].getTitle().length() - 15), 15));

        jMenuVentanas.add(menu);
      }
      else
      if (ventanicas[i] instanceof Ventana_audio) { // Ventana del tipo sonido
        menu = new JMenuItem();
        if (ventanicas[i].getTitle().compareTo(
            "Reproductor de sonido - Sin archivo") == 0)
          menu.setText(ventanicas[i].getTitle().substring(24,
              ventanicas[i].getTitle().length()));
        else
          menu.setText(ventanicas[i].getTitle().substring(24,
              ventanicas[i].getTitle().length()));
        menu.addActionListener(new menu_actionAdapter(this,
            ventanicas[i].
            getTitle().substring(24, ventanicas[i].getTitle().length()), 0));
        menu.setIcon(new ImageIcon("iconos/tipo_audio.gif"));
        jMenuVentanas.add(menu);
      }
      else
      if (ventanicas[i] instanceof ventana_video) { // Ventana del tipo video
        menu = new JMenuItem();
        if (ventanicas[i].getTitle().compareTo(
            "Reproductor de vídeo - Sin archivo") == 0)
          menu.setText(ventanicas[i].getTitle().substring(23,
              ventanicas[i].getTitle().length()));
        else
          menu.setText(ventanicas[i].getTitle().substring(23,
              ventanicas[i].getTitle().length()));
        menu.addActionListener(new menu_actionAdapter(this,
            ventanicas[i].
            getTitle().substring(23, ventanicas[i].getTitle().length()), 0));
        menu.setIcon(new ImageIcon("iconos/tipo_video.gif"));
        jMenuVentanas.add(menu);
      }
    }

    // *************************************************

    // ***** Si tengo la ventana de herramientas visible se me marca en el menú como visible sino no
    if (formas_dib.isVisible())
      activado = new ImageIcon("iconos/activado.gif");
    else
      activado = null;
    jMenuHerramientas.setIcon(activado);

    if (ven_col.isVisible())
      activado = new ImageIcon("iconos/activado.gif");
    else
      activado = null;
    jMenuColores.setIcon(activado);

    if(num_ventanas_filtros > 0)
      activado = new ImageIcon("iconos/activado.gif");
    else
      activado = null;
    jMenuFiltros.setIcon(activado);

    if(ven_atri.isVisible())
      activado = new ImageIcon("iconos/activado.gif");
    else
      activado = null;
    jMenuAtributos.setIcon(activado);

    // *********************************************************************************************

    if (escritorio.getSelectedFrame() instanceof Ventana_imagen)
    {
      Ventana_imagen vi = (Ventana_imagen) escritorio.getSelectedFrame();
      if (vi.jPanelDibujar.se_puede_deshacer())
      {
        jMenuDeshacer.setEnabled(true);
      }
      else
      {
        jMenuDeshacer.setEnabled(false);
      }

      if(vi.jPanelDibujar.se_puede_rehacer())
        jMenuRehacer.setEnabled(true);
      else
        jMenuRehacer.setEnabled(false);
    }

  }

  void jMenuDeshacer_actionPerformed(ActionEvent e) {
    if (escritorio.getSelectedFrame() instanceof Ventana_imagen) {
      Ventana_imagen vi = (Ventana_imagen) escritorio.getSelectedFrame();

      vi.jPanelDibujar.deshacer();
    }
  }

  void jMenuRehacer_actionPerformed(ActionEvent e) {
    if (escritorio.getSelectedFrame() instanceof Ventana_imagen) {
      Ventana_imagen vi = (Ventana_imagen) escritorio.getSelectedFrame();

      vi.jPanelDibujar.rehacer();
    }
  }


  void jMenuColores_actionPerformed(ActionEvent e) {
    if (!ven_col.isVisible())
      mostrar_ventana_colores();
  }

  void jMenuSalir_actionPerformed(ActionEvent e) {
    if (JOptionPane.showConfirmDialog(this, "¿Cerrar Rock'n'Paint?",
                                      "Rock'n'Paint", JOptionPane.YES_NO_OPTION) ==
        0) {
      System.exit(0);
    }
  }

  void jMenuReproducirVideo_actionPerformed(ActionEvent e) {
    // ***** Creo y muestro la ventana para reproducir vídeo *****
    ventana_video video = new ventana_video(this);
    video.setSize(450, 500);
    // centro la ventana
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = video.getSize();
    if (frameSize.height > screenSize.height)
      frameSize.height = screenSize.height;
    if (frameSize.width > screenSize.width)
      frameSize.width = screenSize.width;
    video.setLocation( (screenSize.width - frameSize.width) / 2,
                      (screenSize.height - frameSize.height) / 2);
    //
    video.setVisible(true);

    escritorio.remove(labelFondo); // borro el fondo

    escritorio.add(video); // pongo la ventana de reproducción de música

    video.toFront(); // pongo la ventana de musica al frente
    try {
      video.setSelected(true);
    }
    catch (Exception ex) {
    }

    escritorio.add(labelFondo, escritorio.DEFAULT_LAYER); // vuelvo a poner el fondo
    // ************************************************************
  }

  class Interfaz_jMenuReproducirMusica_actionAdapter
      implements java.awt.event.ActionListener {
    Interfaz adaptee;

    Interfaz_jMenuReproducirMusica_actionAdapter(Interfaz adaptee) {
      this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
      adaptee.jMenuReproducirMusica_actionPerformed(e);
    }
  }

  class Interfaz_jMenuAcercaDe_actionAdapter
      implements java.awt.event.ActionListener {
    Interfaz adaptee;

    Interfaz_jMenuAcercaDe_actionAdapter(Interfaz adaptee) {
      this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
      adaptee.jMenuAcercaDe_actionPerformed(e);
    }
  }

  class Interfaz_jMenuImprimir_actionAdapter
      implements java.awt.event.ActionListener {
    Interfaz adaptee;

    Interfaz_jMenuImprimir_actionAdapter(Interfaz adaptee) {
      this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
      adaptee.jMenuImprimir_actionPerformed(e);
    }
  }

  class Interfaz_jMenuNuevaImagen_actionAdapter
      implements java.awt.event.ActionListener {
    Interfaz adaptee;

    Interfaz_jMenuNuevaImagen_actionAdapter(Interfaz adaptee) {
      this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
      adaptee.jMenuNuevaImagen_actionPerformed(e);
    }
  }

  class Interfaz_jMenuAbrirImagen_actionAdapter
      implements java.awt.event.ActionListener {
    Interfaz adaptee;

    Interfaz_jMenuAbrirImagen_actionAdapter(Interfaz adaptee) {
      this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
      adaptee.jMenuAbrirImagen_actionPerformed(e);
    }
  }

  class Interfaz_jMenuGuardar_actionAdapter
      implements java.awt.event.ActionListener {
    Interfaz adaptee;

    Interfaz_jMenuGuardar_actionAdapter(Interfaz adaptee) {
      this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
      adaptee.jMenuGuardar_actionPerformed(e);
    }
  }

  class Interfaz_jMenuHerramientas_actionAdapter
      implements java.awt.event.ActionListener {
    Interfaz adaptee;

    Interfaz_jMenuHerramientas_actionAdapter(Interfaz adaptee) {
      this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
      adaptee.jMenuHerramientas_actionPerformed(e);
    }
  }

  class Interfaz_jMenuBar1_mouseAdapter
      extends java.awt.event.MouseAdapter {
    Interfaz adaptee;

    Interfaz_jMenuBar1_mouseAdapter(Interfaz adaptee) {
      this.adaptee = adaptee;
    }

    public void mouseEntered(MouseEvent e) {
      adaptee.jMenuBar1_mouseEntered(e);
    }
  }

  class Interfaz_jMenuDeshacer_actionAdapter
      implements java.awt.event.ActionListener {
    Interfaz adaptee;

    Interfaz_jMenuDeshacer_actionAdapter(Interfaz adaptee) {
      this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
      adaptee.jMenuDeshacer_actionPerformed(e);
    }
  }

  class Interfaz_jMenuRehacer_actionAdapter
      implements java.awt.event.ActionListener {
    Interfaz adaptee;

    Interfaz_jMenuRehacer_actionAdapter(Interfaz adaptee) {
      this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
      adaptee.jMenuRehacer_actionPerformed(e);
    }
  }


  class Interfaz_jMenuColores_actionAdapter
      implements java.awt.event.ActionListener {
    Interfaz adaptee;

    Interfaz_jMenuColores_actionAdapter(Interfaz adaptee) {
      this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
      adaptee.jMenuColores_actionPerformed(e);
    }
  }

  class Interfaz_jMenuSalir_actionAdapter
      implements java.awt.event.ActionListener {
    Interfaz adaptee;

    Interfaz_jMenuSalir_actionAdapter(Interfaz adaptee) {
      this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
      adaptee.jMenuSalir_actionPerformed(e);
    }
  }

  class Interfaz_jMenuReproducirVideo_actionAdapter
      implements java.awt.event.ActionListener {
    Interfaz adaptee;

    Interfaz_jMenuReproducirVideo_actionAdapter(Interfaz adaptee) {
      this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
      adaptee.jMenuReproducirVideo_actionPerformed(e);
    }
  }

  void jMenuFiltros_actionPerformed(ActionEvent e) {
    if (num_ventanas_filtros == 0)
      mostrar_ventana_filtros();
  }
}

class Interfaz_jMenuFiltros_actionAdapter implements java.awt.event.ActionListener {
  Interfaz adaptee;

  Interfaz_jMenuFiltros_actionAdapter(Interfaz adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jMenuFiltros_actionPerformed(e);
  }
}


