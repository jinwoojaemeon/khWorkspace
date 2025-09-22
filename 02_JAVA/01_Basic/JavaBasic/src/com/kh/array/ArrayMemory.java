package com.kh.array;

public class ArrayMemory {

	public static void main(String[] args) {
		int i = 10;
		int[] iArr = new int[5];
		
		
		System.out.println(iArr.hashCode());
		// 기본적으로 자바는 메모리의 주소를 확인할 수 없다.
		// 객체 메모리 주소의 암호화된 해시값을 hashcode()로 가져올 수 있다.
		//System.out.print(iArr);
		
		double[] dArr = new double[3];
		System.out.println(dArr.hashCode());
		
		/*
		 * 실제 리터럴 값을 곧바로 담을 수 있는 변수를 일반변수
		 * 다른 메모리의 주소값을 담고있는 변수를 참조변수라고 한다.
		 * 
		 * 기본 자료형(원시타입) : int double, float, char, long .. .
		 *   --> 실제 리터럴 값을 바로 담을 수 있다.
		 *   
		 *   그 외 자료형(String, Scanner, int[], double[]) : 참조타입
		 *   --> 필요한 메모리의 크기가 가변적이기 때문이다.
		 */
		
		//iArr 전체 출력 / dArr 전체출력
		for(int num =0; num<iArr.length;num++) {
			System.out.print(iArr[num]);
		}
		System.out.println();
		for(double dNum : dArr) {
			System.out.print(dNum);
		}
		// >> 배열 생성 시에는 따로 초기화하지 않아도 기본값이 담겨있다.
		//   --> Heap이라는 메모리 공간은 절대 빈 공간을 허용하지 않기 때문이다. 
		//     >> 메모리가 할당될 때 JVM이 기본값으로 모두 초기화
		
		System.out.println(iArr);  // 자료형 + 2 + 주소값의 16진수 hash값 
		iArr = null;
		System.out.println(iArr);
		//iArr.hashCode();        // NullPointerExcetion -> 참조변수가 가지고있는 주소값이 없다. 
		
		int[] arr = new int[5];
		//System.out.println(arr[5]);   //ArrayIndexOutOfBoundsException 배열 index의 범위를 벗어났다. 0~4까지인데 5를 찾아서 .
										//>>배열의 크기를 벗어난 index를 제시하면 발생. 
		//배열의 가장 큰 단점 
		// 배열은 한번 지정하면 크기 변경이 불가능하다. 
		
		arr = new int[10];  // 기존의 new int[5]가 바뀌는 것이 아닌 새로운 메모리를 쓰는 것 뿐이다 .   
		System.out.println(arr.hashCode());
		// 주소값이 변경된 것을 볼 수 있다. -> 수정이 불가능하여 새로운 메모리 공간을 할당
		
		/*
		 *  연결이 끊어진 기존 배열의 메모리 공간은 Heap 영역에 남아있다. (어떤 변수에도 참조되지 않은 상태)
		 *  => 일정 시간이 지나면 "GC(가비지컬렉터)" 가 알아서 회수한다.
		 * 		=> Java에서의 "자동 메모리 관리" 특징 => 개발자는 코드에 집중할 수 있다.
		 */
		
		arr = null; // 배열을 더 이상 사용하지 않을 때 대입하면 메모리를 반환.
		
		int[] arr4 = {1,1,1,1,1};
		int[] arr5 = {1,1,1,1,1};
		System.out.println(arr4==arr5);
		// arr4 == arr5 => false. => 각 참조변수는 ==를 통해서 비교 시 주소값 빅를 하기 때문이다. 
		
		arr4= arr5;
		System.out.println(arr4==arr5);
		arr4[0] = 100;
		arr5[1] = 200;
		for(int j : arr4) {
			System.out.print(j + " ");
		}
		System.out.println();
		for(int k : arr5) {
			System.out.print(k + " ");
		}  // 위에서 arr4 = arr5를 했기 때문에 동일한 배열을 사용하고 있다.
	}

}
