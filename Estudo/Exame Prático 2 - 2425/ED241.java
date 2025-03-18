import java.util.*;

public class ED241 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int flag = scanner.nextInt();
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Set<String> students = new HashSet<>();
        Map<String, Integer> problemSubmissions = new HashMap<>();
        Map<String, Integer> problemAccepted = new HashMap<>();
        Map<String, Set<String>> studentProblems = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String student = scanner.next();
            String problem = scanner.next();
            String result = scanner.next();
            scanner.nextLine(); // Consume the newline character

            students.add(student);

            problemSubmissions.put(problem, problemSubmissions.getOrDefault(problem, 0) + 1);
            if (result.equals("Accepted")) {
                problemAccepted.put(problem, problemAccepted.getOrDefault(problem, 0) + 1);
                studentProblems.computeIfAbsent(student, k -> new HashSet<>()).add(problem);
            }
        }

        switch (flag) {
            case 1:
                // Flag 1: Number of different students with at least one submission
                System.out.println(students.size());
                break;
            case 2:
                // Flag 2: Problem with the most submissions
                String mostSubmittedProblem = Collections.max(problemSubmissions.entrySet(), Map.Entry.comparingByValue()).getKey();
                System.out.println(mostSubmittedProblem + " " + problemSubmissions.get(mostSubmittedProblem));
                break;
            case 3:
                // Flag 3: Problems with an acceptance ratio >= 50%, in alphabetical order
                List<String> accessibleProblems = new ArrayList<>();
                for (String problem : problemSubmissions.keySet()) {
                    int totalSubmissions = problemSubmissions.get(problem);
                    int acceptedSubmissions = problemAccepted.getOrDefault(problem, 0);
                    if ((double) acceptedSubmissions / totalSubmissions >= 0.5) {
                        accessibleProblems.add(problem);
                    }
                }
                Collections.sort(accessibleProblems);
                for (String problem : accessibleProblems) {
                    System.out.println(problem);
                }
                break;
            case 4:
                // Flag 4: Students who solved all problems, in alphabetical order
                Set<String> allProblems = problemSubmissions.keySet();
                List<String> studentsSolvedAll = new ArrayList<>();
                for (String student : students) {
                    if (studentProblems.getOrDefault(student, Collections.emptySet()).containsAll(allProblems)) {
                        studentsSolvedAll.add(student);
                    }
                }
                Collections.sort(studentsSolvedAll);
                for (String student : studentsSolvedAll) {
                    System.out.println(student);
                }
                break;
        }

        scanner.close();
    }
}