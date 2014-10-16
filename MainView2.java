
         /*
        * �������� ��������� � ������ ����������� ����
        * */
        dialogBox = new DialogBox(shell);//������� ���������� ����
        dialogBox.setLocation(rect.x + rect.width + 2, rect.y);//������ ��������� � ������

        /*
        * ��������� ������� ���� ( ����, � ���������)
         */
        Menu bar = new Menu(shell, SWT.BAR);
        shell.setMenuBar(bar);
        MenuItem fileMenu = new MenuItem(bar, SWT.CASCADE);
        fileMenu.setText("&����");//������� ������ "����"
        Menu subMenu = new Menu(shell, SWT.DROP_DOWN);
        fileMenu.setMenu(subMenu);
        aboutProgrammButton = new MenuItem(
                subMenu, SWT.NULL);
        aboutProgrammButton.setText("&� ���������\tCtrl+H");//������� ������ "� ���������"
        aboutProgrammButton.setAccelerator(SWT.CTRL + 'H');
        setSep(new MenuItem(subMenu, SWT.SEPARATOR));
        exitItem = new MenuItem(subMenu, SWT.NULL);
        exitItem.setText("&�����\tCtrl+E");//������� ������ "�����"
        exitItem.setAccelerator(SWT.CTRL + 'E');

        GridData centerData = new GridData(GridData.CENTER,
                GridData.BEGINNING, true, false, 3, 1);

        setFillData(new GridData(GridData.FILL,
                GridData.BEGINNING, true, false, 3, 1));

        /**
         * ������ ��� ������������� ����������� ���������
         * ���������� ������ � ������� �����������
         */

         /*
        * ��������� ��� ������� � ���������� ������ ��� ����� ��������,
        * � ����� �������� ����� ����� ����
         */

        Group parametersTextGroup = new Group(shell,SWT.NULL);
        parametersTextGroup.setText("��������� �������");//�������� ����������
        GridLayout parametersTextLayout = new GridLayout(2, false);
        parametersTextGroup.setLayout(parametersTextLayout);

        parametersTextGroup.setSize(500, 500);//������ ������

        final DigitalTextBox namingLength = new DigitalTextBox(parametersTextGroup, SWT.NONE, this);

        final DigitalTextBox itemLength = new DigitalTextBox(parametersTextGroup, SWT.NONE, this);

        final DigitalTextBox namingWidth = new DigitalTextBox(parametersTextGroup, SWT.NONE, this);

        final DigitalTextBox itemWidth = new DigitalTextBox(parametersTextGroup, SWT.NONE, this);

        final DigitalTextBox namingHeight = new DigitalTextBox(parametersTextGroup, SWT.NONE, this);

        final DigitalTextBox itemHeight = new DigitalTextBox(parametersTextGroup, SWT.NONE, this);
        
        final DigitalTextBox namingKol = new DigitalTextBox(parametersTextGroup, SWT.NONE, this);
        
        final DigitalTextBox itemKol = new DigitalTextBox(parametersTextGroup, SWT.NONE, this);


        namingHeight.setText("������");//�������� ���������� ����
        namingWidth.setText("������");//�������� ���������� ����
        namingLength.setText("�����");//�������� ���������� ����
        namingKol.setText("����������");//�������� ���������� ����
        namingHeight.setEnabled(false);
        namingWidth.setEnabled(false);
        namingLength.setEnabled(false);
        namingKol.setEnabled(false);
