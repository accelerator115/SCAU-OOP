import java.util.Scanner;

public class ScoreAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int classCount = scanner.nextInt();
        for(int i=0 ;i < classCount; i++)
        {
            int studentCount = scanner.nextInt();

            double sum = 0.0;
            double max = Double.MIN_VALUE;
            double min = Double.MAX_VALUE;

            for (int j = 0; j < studentCount; j++)
            {
                double score = scanner.nextDouble();
                sum += score;

                if (score > max) {
                    max = score;
                }
                if (score < min) {
                    min = score;
                }
            }

            double average = sum / studentCount;

            System.out.printf("%.2f %.2f %.2f%n", average, max ,min);
        }
        scanner.close();
    }
}