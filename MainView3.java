package pr1;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

/*
*основная функция
*/
public class MainView { 

    private final Display display;

    public Shell getShell() {
        return shell;
    }//указатель

    private final Shell shell;//задали тип
    private final MenuItem exitItem;//задали тип
    private final MenuItem aboutProgrammButton;//задали тип
    private final Button computeButton;//задали тип

    public DialogBox getDialogBox() {
        return dialogBox;
    }//указатель(диалоговое окно)

    private DialogBox dialogBox;

    private  static Double   wareHouseLength = 0.0;//задали тип и значение
    private  static Double   wareHouseWidth = 0.0;//задали тип и значение
    private  static Double   wareHouseHeight = 0.0;//задали тип и значение
    private  static Double   wareHouseKol = 0.0;//задали тип и значение
    private  static Double   itemLength = 0.0;//задали тип и значение
    private  static Double   itemWidth = 0.0;//задали тип и значение
    private  static Double   itemHeight = 0.0;//задали тип и значение
    private  static Double   itemKol = 0.0;//задали тип и значение
    private MenuItem sep;
    private GridData fillData;

    public Display getDisplay() {
        return display;
    }//указатель(основная панель)

    public MenuItem getExitItem() {
        return exitItem;
    }//указатель(кнопка "выход")

    public MenuItem getAboutProgrammButton() {
        return aboutProgrammButton;
    }//указатель(верхняя панель)

    public Button getComputeButton() {
        return computeButton;
    }//указатель (кнопка "вычислить")


    public MainView(){
        /*
        * Инициализируется основная панель
        * */
        display = new Display();
        shell = new Shell(display);//запускаем панель
        GridLayout mainWindowLayout = new GridLayout(3, false);//размещаем компоненты в таблицу
        shell.setLayout(mainWindowLayout);

        /*
        * Задается положение и размер панели
        * */
        Monitor primary = display.getPrimaryMonitor();
        Rectangle bounds = primary.getBounds();
        Rectangle rect = shell.getBounds();
        final int x = bounds.x + (bounds.width - rect.width) / 2;
        final int y = bounds.y + (bounds.height - rect.height) / 2;
        shell.setLocation(x, y);
