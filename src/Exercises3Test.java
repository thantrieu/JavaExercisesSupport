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

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

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
}
