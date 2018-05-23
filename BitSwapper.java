import java.util.Random;

public class BitSwapper{
	
	private int number;
	private int length;
	private boolean bitArray[];

	BitSwapper(int number){
		this.number = number;
		this.length = Integer.toBinaryString(number).length();
		this.bitArray = new boolean[this.length];
	}

	private static void printAsZeroOne(boolean[] bitArray, int length){
		for (int i=0; i<length; i++) {
			System.out.print(bitArray[i] ? 1 : 0);
		}
	}

	private static boolean[] changeIntegerToBitArray(int number, int length){
		boolean bitArray[] = new boolean[length];

		for(int i=length-1; i>=0; i--){
			if(number%2 == 1)
				bitArray[i] = true;
			else
				bitArray[i] = false;
			number/=2;
		}
		return bitArray;
	}

	public static boolean[] swapInArray(boolean[] bitArray, int length, int firstIndex, int secondIndex){
		boolean temp = bitArray[secondIndex];
		bitArray[secondIndex] = bitArray[firstIndex];
		bitArray[firstIndex] = temp;
		return bitArray;
	}

	public static boolean[] changePossitionOfBits(boolean[] bitArray, int length){
		for(int i=0; i<length-1; i+=2){
			swapInArray(bitArray, length, i, i+1);
		}
		return bitArray;
	}

	public static void main(String[] args){

		Random generator = new Random();
		int number = generator.nextInt(100);

		BitSwapper bitSwapper = new BitSwapper(number);
		boolean solution[] = new boolean[bitSwapper.length];
		
		bitSwapper.bitArray = changeIntegerToBitArray(bitSwapper.number, bitSwapper.length);
		printAsZeroOne(bitSwapper.bitArray, bitSwapper.length);

		System.out.println();

		solution = changePossitionOfBits(bitSwapper.bitArray, bitSwapper.length);
		printAsZeroOne(solution, bitSwapper.length);

	}
}