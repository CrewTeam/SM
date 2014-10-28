/**
     * Получает текст из поля
     * @return
     */
    public String getText(){
        return text.getText();
    }

    /**
     * Устанавливает менеджер расположения для текстового поля
     * @param data
     */
    public void setLayoutData(GridData data){
        text.setLayoutData(data);
    }

    /**
     * Уcтанавливает текст в поле
     * @param text непосредственно текст
     */
    public void setText(String text){
        this.text.setText(text);
    }

    /**
     *  Устанавливает атрибут активности текстового поля
     * @param enable булевое значение ( фактически активно - true, неактивно - false)
     */
    public void setEnabled(Boolean enable){
        text.setEnabled(enable);
    }


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}
}
