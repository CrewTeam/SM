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
