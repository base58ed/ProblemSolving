package introduction;

import java.io.*;
import java.util.stream.IntStream;


// 1) Stuck in the Java 6 wasteland

// Features only available through Jack compiler on Android Nougat and not available to
// the previous versions of Dalvik
public class S1_Java8Features {

	// Lambdas & Method References
	static class Lambdas {
		void oldAnonymousInst() {
			Runnable r = 	new Runnable() {
				@Override
				public void run() {
					System.out.println("why do I have to do so much without any purpose?");
				}
			};
		}

		void lambdaWay() {
			Runnable r = () -> {
				System.out.println("you know it's a lot more cleaner this way");
			};
		}
	}
	//... but you can use Retrolambda



	// Streams
	static class Streams {
		void oldLoops() {
			int accumulator = 0;
			for (int i = 0; i < 100; i++) {
				if (i % 2 == 0) {
					accumulator += i * 3;
				}
			}
		}

		void lambdaWay() {
			int sumOfEvenTripled = IntStream.range(0, 100)
					.filter(i -> i % 2 == 0)
					.map(i -> i * 3)
					.sum();
		}

		void lambdaWithMethodRefs() {
			int sumOfEvenTripled = IntStream.range(0, 100)
					.filter(this::isEven)
					.map(this::times3)
					.sum();
		}


		// minions
		int times3(int i) {
			return i * 3;
		}

		boolean isEven(int i) {
			return i % 2 == 0;
		}
	}

	//... but you can use Backport or RxJava



	// Try with Resources (a.k.a ARM block)
	static class SafeAndCleanTryCatch {
		static final String filename = "/tmp/somefile.txt";

		void oldButSafeReadFileContents() {
			BufferedReader br = null;
			FileReader fr = null;
			try {
				fr = new FileReader(filename);
				br = new BufferedReader(fr);

				String currentLine;
				while ((currentLine = br.readLine()) != null) {
					System.out.println(currentLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null)
						br.close();
					if (fr != null)
						fr.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		//~SERIOUSLY!!!


		void SafeAndCleanerReadFileContents() {
			try (FileReader fr = new FileReader(filename);
					 BufferedReader br = new BufferedReader(fr)) {

				String currentLine;
				while ((currentLine = br.readLine()) != null) {
					System.out.println(currentLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//... but you can set minSDKVersion to 19 or use Retrolambda
}
