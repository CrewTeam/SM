package pr1;

public class MainClass { /*public ��������, ��� ����� �������� �� ��������� 
���� ������, � ������� �� ������, ����� class ��������������� � ���, 
��� ���� ���� � ������, � �� � ���-�� ������; ����� ���� ����������� 
	�������� ������, � ������ ������ MainClass */

	public static void main(String[] args){ /* ����������� ������� public ��������,
         ��� ����� main(String[] args)����� � �������� ������ ������.
        	static ��������, ��� �� ����� ��������� ���������(�����) 
        	������� Index � ������, ����� ������������ ���� �����.
        	� ������� static ����������� ������ � ���������� ������, 
        	������������ ��� ������ � ������� � �����. 
        	��� ������ ����� ��������������� �������� ������ � ���������� 
        	� ������������ �����������.
        	void ��������, ��� ����� main(String[] args)�� ���������� ������ 
        	� ���������, ������� ��� �������, 
        	� ������ ������� �� ����� ������.
        	� ������ main ����� String[] args ��������,
        	��� ���� ����� �������� ������ �������� � ����� String,
        	 �.�. ��������� ������.
        	��������� ����� �������� �� ���������� �������, 
        	�� ������ ���� �� ��� �������� ����� main().
        	��� ������������ ���������� Java-���������������,
        	 ������� ������� ���������������� �����, 
        	�������� ���� ������ � ������ ������ main. 
        	*/

            MainView view  = new MainView(); /*��������� ������ view ������ MainView*/
            view.open();
        }
}
