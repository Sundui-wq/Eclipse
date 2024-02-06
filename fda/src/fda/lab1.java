package fda;

import java.util.*;
public class lab1 {

	public static void main(String[] args) {
		
		int number, elem;
		Scanner scanner= new Scanner(System.in);
		System.out.print("Жагсаалтын уртыг оруулна уу:");
		number= scanner.nextInt();
		MyArrayLinearList l1= new MyArrayLinearList(number);
		for(int i=0 ; i<number ; i++) {
			System.out.print("Элемент"+i+"="); 
			elem= scanner.nextInt(); 
			l1.add(i, elem);
		}
		System.out.println("Жагсаалт үүсгэж утга оруулав");
	 
		
	    System.out.println("Жагсаалт:"+l1.toString());		
	    System.out.println("Үйлдлээ сонгон уу: \n1 Давхардал арилгах \n2 Санамсаргүй \n3 Солих \n4 Эрэмбэлэх \n5 Дундаж \n6 Их \n7 Бага \n8 Устгах \n9 Нийлбэр\n10 Холбох \n11 exit ");
		while(true)
		{
			int dugaar=scanner.nextInt();
			
			switch(dugaar) {
			case 1:
				MyArrayLinearList unique= l1.unique();
				System.out.println("Давхардлыг арилгасны дараа:"+unique.toString());
				break;
			
			case 2:
				MyArrayLinearList rand= l1.rand();
				System.out.println("Санамсаргүй:" +rand.toString());
				break;
			case 3:
				MyArrayLinearList reverse= l1.reverse();
				System.out.println("Солих:"+ reverse.toString());
				break;
			case 4:
				l1.Sort();
				System.out.println("Эрэмбэлэх:"+ l1.toString());
				break;
			
			case 5:
				System.out.println("Дундаж:"+ l1.average());
				break;
			case 6:
				System.out.println("Их:"+ l1.Max());
				break;
			case 7:
				System.out.println("Бага:"+ l1.Min());
				break;
			case 8:	
				l1.removeOdd();
				System.out.println("Устгах:"+ l1.toString());
				break;
			case 9:
				System.out.println("Нийлбэр:"+ l1.sum());
				break;
			case 10:	
				System.out.println("Залгах элементүүдийн уртыг оруулна уу=");
				int q1= scanner.nextInt();
				MyArrayLinearList addArray= new MyArrayLinearList(q1);
				for(int i=0 ; i<q1 ; i++) {
					System.out.print("+Элемент"+i+"=]");
					int element= scanner.nextInt();
					addArray.add(i, element);
				}
				MyArrayLinearList mergeArray = l1.merge(addArray);
				System.out.println("Холбох:" +mergeArray.toString());
				break;
			case 11:
				System.exit(0);
				
				default :
					System.out.println("Алдаа");
					

		}
		
	 }
	}
	//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
	//4:19
}
	


