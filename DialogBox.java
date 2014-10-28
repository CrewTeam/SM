package pr1;

import org.eclipse.swt.SWT; /*инструкция подключения классов и пакетов*/
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class DialogBox { /*public означает, что класс доступен
 за пределами того пакета, в котором он описан
слово class свидетельствует о том, что речь идет о классе,
 а не о чем-то другом; после него указывается 
название класса, в данном случае DialogBox */
    /**
     * 
     */
    private final Shell dialog;/* private Ограничивает область видимости инвариантов класса методами класса;
final - запрещает присвоение значений переменной вне тела класса, 
в котором она объявлена*/  
    private final Label label;
    private final Button closeButton;

    public DialogBox(Shell parentShell){
        dialog = new Shell(parentShell.getDisplay(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
        dialog.setSize(200, 100);
        dialog.setLayout(new GridLayout(1, false));
        label = new Label(dialog,SWT.NONE);
        closeButton = new Button(dialog, SWT.PUSH);
        GridData centerData = new GridData();
        centerData.horizontalAlignment = GridData.CENTER;
        centerData.grabExcessHorizontalSpace = true;
        closeButton.setText("OK");
        closeButton.setSize(50, 20);
        closeButton.setLayoutData(centerData);
        bind();
    }


    public void setText(String text){
         label.setText(text); //устанавливаем инвариант text
//объекта label равным текстовой константе*
    }

    public void setLocation(int x, int y)/*public - спецификатор доступа;
Ключевое слово void говорит  компилятору, что метод не возвращает никакого значения*/{
        dialog.setLocation(x, y);
    }
    
    public void open(){
        dialog.pack();
        dialog.open();
    }

    private void bind(){

        closeButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                dialog.dispose();
            }
        });
    }

}
