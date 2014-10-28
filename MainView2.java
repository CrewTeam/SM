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
