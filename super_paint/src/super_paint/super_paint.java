package super_paint;

import javax.swing.UIManager;
import java.awt.*;

/**
 * <p>T�tulo: Pr�ctica de Sistemas Multimedia</p>
 * <p>Descripci�n: Pr�ctica de Sistemas Multimedia</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Empresa: Piratas Sin Fronteras S.A.</p>
 * @author Francisco Jes�s Delgado Almir�n
 * @version 1.0
 */

public class super_paint {
  boolean packFrame = false;

  //Construir la aplicaci�n
  public super_paint() {
    Interfaz frame = new Interfaz();
    //Validar marcos que tienen tama�os preestablecidos
    //Empaquetar marcos que cuentan con informaci�n de tama�o preferente �til. Ej. de su dise�o.
    if (packFrame) {
      frame.pack();
    }
    else {
      frame.validate();
    }
    //Centrar la ventana
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    frame.setVisible(true);
  }

  //M�todo Main
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    new super_paint();
  }
}