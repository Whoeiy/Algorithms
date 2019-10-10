package AfterClassHomework;

public class chpt02080919 {
	public static void main(String args[]) {
		char charset[] = {'E','X','A','M','P','L','E'};
		SelectionSort(charset);
		for(int i = 0; i < charset.length; i++)
		{
			System.out.println(charset[i]);
		}
	}
	
	public static void SelectionSort(char array[]) {
		int i, j;
		int min;
		char temp;
		for(i = 0; i <= array.length - 2; i++)
		{
			min = i;
			for(j = i + 1; j <= array.length - 1; j++) {
				if(array[j] < array[i])
				{
					min = j;
				}
			}
			temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}
}
