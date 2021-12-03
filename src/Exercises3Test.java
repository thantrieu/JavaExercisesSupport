import javax.xml.validation.SchemaFactoryConfigurationError;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercises3Test {
    public static void main(String[] args) {
        int choice = 0;
        ArrayList<Subject> subjects = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        var input = new Scanner(System.in);
        do {
            System.out.println("======================= MENU ============================");
            System.out.println("=   1. Thêm mới môn học vào danh sách môn học.          =");
            System.out.println("=   2. Thêm mới sinh viên vào danh sách sinh viên.      =");
            System.out.println("=   3. Thêm mới lớp học vào danh sách lớp học.          =");
            System.out.println("=   4. Thêm mới sinh viên vào lớp học nào đó.           =");
            System.out.println("=   5. Hiển thị danh sách môn học.                      =");
            System.out.println("=   6. Hiển thị danh sách sinh viên.                    =");
            System.out.println("=   7. Hiển thị danh sách lớp học.                      =");
            System.out.println("=   8. Nhập và tính điểm trung bình.                    =");
            System.out.println("=   9. Xét học lực cho các sinh viên trong lớp.         =");
            System.out.println("=   10. Tìm sinh viên theo mã trong lớp học nào đó.     =");
            System.out.println("=   0. Thoát chương trình.                              =");
            System.out.println("=========================================================");
            System.out.println("Xin mời chọn: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("======= CHƯƠNG TRÌNH KẾT THÚC =======");
                    break;
                case 1:
                    var s = createNewSubject(input);
                    subjects.add(s);
                    System.out.println("==> Thêm môn học thành công <==");
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    showSubjects(subjects);
                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                default:
                    System.out.println("=== Sai chức năng. Vui lòng chọn lại! ===");
                    break;
            }
        } while (choice != 0);
    }

    private static void showSubjects(ArrayList<Subject> subjects) {
        System.out.println("=========================> DANH SÁCH MÔN HỌC <=========================");
        System.out.printf("%-12s%-25s%-12s%-12s%-12s\n",
                "Mã môn", "Tên môn", "Số tín", "Số tiết", "Số bài KT");
        for (var s : subjects) {
            showSubject(s);
        }
    }

    private static void showSubject(Subject s) {
        System.out.printf("%-12s%-25s%-12s%-12s%-12s\n",
                s.getId(), s.getName(), s.getCredit(), s.getNumOfLesson(), s.getNumOfExam());
    }

    private static Subject createNewSubject(Scanner input) {
        System.out.println("Mã môn học: ");
        var id = input.nextLine();
        System.out.println("Tên môn học: ");
        var name = input.nextLine();
        System.out.println("Số tín chỉ: ");
        var credit = input.nextInt();
        System.out.println("Số tiết học: ");
        var lesson = input.nextInt();
        System.out.println("Số bài kiểm tra: ");
        var numOfExam = input.nextInt();
        return new Subject(id, name, credit, lesson, numOfExam);
    }
}
