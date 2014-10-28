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

         /*
        * Задается положение и размер диалогового окна
        * */
        dialogBox = new DialogBox(shell);//создаем диалоговое окно
        dialogBox.setLocation(rect.x + rect.width + 2, rect.y);//задаем положение и размер

        /*
        * Создается Главное меню ( Файл, О программе)
         */
        Menu bar = new Menu(shell, SWT.BAR);
        shell.setMenuBar(bar);
        MenuItem fileMenu = new MenuItem(bar, SWT.CASCADE);
        fileMenu.setText("&Файл");//создаем кнопку "файл"
        Menu subMenu = new Menu(shell, SWT.DROP_DOWN);
        fileMenu.setMenu(subMenu);
        aboutProgrammButton = new MenuItem(
                subMenu, SWT.NULL);
        aboutProgrammButton.setText("&О программе\tCtrl+H");//создаем кнопку "О программе"
        aboutProgrammButton.setAccelerator(SWT.CTRL + 'H');
        setSep(new MenuItem(subMenu, SWT.SEPARATOR));
        exitItem = new MenuItem(subMenu, SWT.NULL);
        exitItem.setText("&Выход\tCtrl+E");//создаем кнопку "Выход"
        exitItem.setAccelerator(SWT.CTRL + 'E');

        GridData centerData = new GridData(GridData.CENTER,
                GridData.BEGINNING, true, false, 3, 1);

        setFillData(new GridData(GridData.FILL,
                GridData.BEGINNING, true, false, 3, 1));

        /**
         * Объект для редатирования отображения элементов
         * Центрирует объект к котрому применяется
         */

         /*
        * Создаются две колонки с текстовыми полями для ввода значений,
        * а также название полей между ними
         */

        Group parametersTextGroup = new Group(shell,SWT.NULL);
        parametersTextGroup.setText("Параметры объекта");//название контейнера
        GridLayout parametersTextLayout = new GridLayout(2, false);
        parametersTextGroup.setLayout(parametersTextLayout);

        parametersTextGroup.setSize(500, 500);//задаем размер

        final DigitalTextBox namingLength = new DigitalTextBox(parametersTextGroup, SWT.NONE, this);

        final DigitalTextBox itemLength = new DigitalTextBox(parametersTextGroup, SWT.NONE, this);

        final DigitalTextBox namingWidth = new DigitalTextBox(parametersTextGroup, SWT.NONE, this);

        final DigitalTextBox itemWidth = new DigitalTextBox(parametersTextGroup, SWT.NONE, this);

        final DigitalTextBox namingHeight = new DigitalTextBox(parametersTextGroup, SWT.NONE, this);

        final DigitalTextBox itemHeight = new DigitalTextBox(parametersTextGroup, SWT.NONE, this);
        
        final DigitalTextBox namingKol = new DigitalTextBox(parametersTextGroup, SWT.NONE, this);
        
        final DigitalTextBox itemKol = new DigitalTextBox(parametersTextGroup, SWT.NONE, this);


        namingHeight.setText("Высота");//название текстового поля
        namingWidth.setText("Ширина");//название текстового поля
        namingLength.setText("Длина");//название текстового поля
        namingKol.setText("Количество");//название текстового поля
        namingHeight.setEnabled(false);
        namingWidth.setEnabled(false);
        namingLength.setEnabled(false);
        namingKol.setEnabled(false);


          /*
        * Контейнер для полей вывода результата и кнопки Выполнить'
         */

        Group  lowerGroup = new Group(shell,SWT.NULL);
        lowerGroup.setLayout(new GridLayout(1, false));
        lowerGroup.setLayoutData(centerData);


        final DigitalTextBox outputText = new DigitalTextBox(lowerGroup, SWT.NONE, this);//текстовое поле
         /*
        * Текстовое поле, в которое выводится результат
         */

//        outputText.setSize(200, 150);//задаем размер поля


         /*
        * Кнопка 'Вычислить!'
         */
        computeButton = new Button(lowerGroup, SWT.PUSH);//новая кнопка
        computeButton.setText("Вычислить");//название кнопки
        computeButton.setSize(250, 150);//задаем размер кнопки

         /*
        * Добавлется обработка нажатия на кнопку
         */
        computeButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                try{
                MainView.itemHeight = new Double(itemHeight.getText());
                MainView.itemWidth = new Double(itemWidth.getText());
                MainView.itemLength = new Double(itemLength.getText());
                MainView.itemKol = new Double(itemKol.getText());
                outputText.setText(compute().toString());
                }catch(Exception ex){
                           dialogBox = new DialogBox(shell);
                           dialogBox.setText("Поля должны быть заполнены положительными цифрами");
                           dialogBox.open();
                }

            }
        });

        bind();
    }

    /**
     * Открывает главное окно
     */

    public void open(){
        shell.pack();
        shell.open();


        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }

    /**
     *  Вычисляет место хранения,
     */
    private  final Double compute(){
           try{
        	   if((itemHeight>=0)&(itemLength>=0)&(itemWidth>=0)&(itemKol>=0)){	//если исходные данные неотрицательны, то
					
                      return itemHeight*itemLength*itemWidth*itemKol;//функция вычисления места хранения
        	   }
           }catch(Exception e){

           }
        return null;
    }

    public void close(){
          display.dispose();
    }


    /**
     *
     * Биндит события для кнопок выхода и 'О программе'
     */
    public void bind() {

        this.aboutProgrammButton.addSelectionListener(
                new SelectionAdapter() {
                    public void widgetSelected(SelectionEvent event) {
                        showAboutProgramm();
                    }
                });

      this.exitItem.addSelectionListener(new SelectionAdapter() {
          public void widgetSelected(SelectionEvent event) {
              display.dispose();
          }
      });
    }

    /**
     * Отображает окно "О программе..."
     */
    private void showAboutProgramm(){
        dialogBox = new DialogBox(shell);
        dialogBox.setText("Данная программа рассчитывает площадь склада, \nнеобходимую для хранения объектов.\n" +
                "Имеется возможность задания длины, ширины, \nвысоты и количества объектов");
        dialogBox.open();
    }//выводим диалоговое окно

	public static Double getWareHouseLength() {
		return wareHouseLength;
	}

	public static void setWareHouseLength(Double wareHouseLength) {
		MainView.wareHouseLength = wareHouseLength;
	}

	public static Double getWareHouseWidth() {
		return wareHouseWidth;
	}

	public static void setWareHouseWidth(Double wareHouseWidth) {
		MainView.wareHouseWidth = wareHouseWidth;
	}

	public static Double getWareHouseHeight() {
		return wareHouseHeight;
	}

	public static void setWareHouseHeight(Double wareHouseHeight) {
		MainView.wareHouseHeight = wareHouseHeight;
	}

	public static Double getWareHouseKol() {
		return wareHouseKol;
	}

	public static void setWareHouseKol(Double wareHouseKol) {
		MainView.wareHouseKol = wareHouseKol;
	}

	public GridData getFillData() {
		return fillData;
	}

	public void setFillData(GridData fillData) {
		this.fillData = fillData;
	}

	public MenuItem getSep() {
		return sep;
	}

	public void setSep(MenuItem sep) {
		this.sep = sep;
	}

}
