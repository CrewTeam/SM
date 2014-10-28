package pr1;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import java.awt.*;
public class DigitalTextBox  {
    private final Text text;
    DialogBox dialogBox = null;
    MainView mainView = null;
	private int x;
	private int y;

    public DigitalTextBox(Composite parent, int style, MainView mainView) {
        text = new Text(parent, style);

        this.mainView = mainView;
        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.keyCode != SWT.BS)
                validateField();
            }
        });
    }


    /**
     * Метод для проверки на запись чисел в поле
     */
    private void validateField(){
        Point mousePos = MouseInfo.getPointerInfo().getLocation();
        setX(mousePos.x);
        setY(mousePos.y);
        this.dialogBox = new DialogBox(mainView.getShell());
    }

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
