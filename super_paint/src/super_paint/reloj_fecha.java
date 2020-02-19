package super_paint;

import java.util.*;
import java.text.SimpleDateFormat;


/**
 * <p>T�tulo: Pr�ctica de Sistemas Multimedia</p>
 * <p>Descripci�n: Pr�ctica de Sistemas Multimedia</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Empresa: Piratas Sin Fronteras S.A.</p>
 * @author Francisco Jes�s Delgado Almir�n
 * @version 1.0
 */

public class reloj_fecha extends Thread
{
  private Interfaz creador;
  private Calendar calendarioAhora = Calendar.getInstance();
  private Date fecha = calendarioAhora.getTime();
  private SimpleDateFormat formatoFecha = new SimpleDateFormat("hh:mm:ss - dd/MM/yyyy");

  public reloj_fecha(Interfaz i)
  {
    creador = i;
  }

  /**
   * <p><u>Descripci�n</u>: Muestra la hora y la fecha.</p>
   */
  public void run()
  {
    while(true)
    {
      calendarioAhora = Calendar.getInstance();
      fecha = calendarioAhora.getTime();
      formatoFecha = new SimpleDateFormat("hh:mm:ss - dd/MM/yyyy");
      creador.lFecha.setText(formatoFecha.format(fecha)); // muestro la hora y la fecha
      try {
        this.sleep(1000);
      }
      catch (InterruptedException ex)
      {
      }
    }
  }

}
