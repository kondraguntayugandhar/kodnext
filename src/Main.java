import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.next();
        double percentage = scanner.nextDouble();
        int backlogs = scanner.nextInt();
        int graduationYear = scanner.nextInt();
        int skillCount = scanner.nextInt();

        String[] skills = new String[skillCount];
        for (int i = 0; i < skillCount; i++) {
            skills[i] = scanner.next();
        }

        Candidate candidate = new Candidate(
                name,
                percentage,
                backlogs,
                graduationYear,
                skills);

        int jobCount = scanner.nextInt();
        Job[] jobs = new Job[jobCount];

        for (int i = 0; i < jobCount; i++) {
            String company = scanner.next();
            String role = scanner.next();
            double minPercentage = scanner.nextDouble();
            int minBacklogs = scanner.nextInt();
            int requiredGraduationYear = scanner.nextInt();
            int requiredSkillCount = scanner.nextInt();

            String[] requiredSkills = new String[requiredSkillCount];
            for (int j = 0; j < requiredSkillCount; j++) {
                requiredSkills[j] = scanner.next();
            }

            jobs[i] = new Job(
                    company,
                    role,
                    minPercentage,
                    minBacklogs,
                    requiredGraduationYear,
                    requiredSkills);
        }

        System.out.println("AVAILABLE JOBS");
        for (int i = 0; i < jobCount; i++) {
            System.out.println((i + 1) + ". " + jobs[i].getCompany() + " - " + jobs[i].getRole());
        }

        int selectedJobNumber = scanner.nextInt();
        Job selectedJob = jobs[selectedJobNumber - 1];

        System.out.println("Candidate : " + candidate.getName());
        System.out.println("Company   : " + selectedJob.getCompany());
        System.out.println("Role      : " + selectedJob.getRole());

        EligibilityChecker checker = new EligibilityChecker();
        boolean eligible = checker.evaluate(candidate, selectedJob);

        if (eligible) {
            System.out.println("Final Result : ELIGIBLE");
        } else {
            System.out.println("Final Result : NOT ELIGIBLE");
        }

        scanner.close();
    }
}
