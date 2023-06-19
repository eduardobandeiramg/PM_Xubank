import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QMainWindow;

public class App {

    public static void main(String[] args) {

        QApplication.initialize(args);

        InterfaceGrafica gui = new InterfaceGrafica();
        QMainWindow mainWindow = new QMainWindow();
        mainWindow.show();
        gui.setupUi(mainWindow);
        QApplication.execStatic();
        QApplication.shutdown();


    }

}
