import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.next();
        double percentage = scanner.nextDouble();
        int backlogs = scanner.nextInt();
        int graduationYear = scanner.nextInt();

        Candidate candidate = new Candidate(
            name,
            percentage,
            backlogs,
            graduationYear
        );

        System.out.println("Candidate: " + candidate.getName());
        System.out.println("Percentage: " + candidate.getPercentage());
        System.out.println("Backlogs: " + candidate.getBacklogs());
        System.out.println("Graduation Year: " + candidate.getGraduationYear());

        scanner.close();
    }
}
