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
