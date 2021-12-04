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
                    var student = createNewStudent(input);
                    students.add(student);
                    System.out.println("==> Thêm mới sinh viên thành công <==");
                    break;
                case 3:
                    if (subjects.size() > 0) {
                        var course = createNewCourse(input, subjects);
                        if (course != null) {
                            courses.add(course);
                            System.out.println("==> Thêm lớp học thành công <==");
                        } else {
                            System.out.println("==> Thêm lớp học thất bại <==");
                        }
                    } else {
                        System.out.println("==> Danh sách môn học rỗng <==");
                    }
                    break;
                case 4:
                    if (courses.size() > 0 && students.size() > 0) {
                        var isSucess = addStudentToCourse(courses, students, input);
                        if (isSucess) {
                            System.out.println("==> Thêm sinh viên vào lớp học thành công! <==");
                        } else {
                            System.out.println("==> Thêm sinh viên vào lớp học thất bại! <==");
                        }
                    } else {
                        System.out.println("==> Danh sách lớp học hoặc danh sách sinh viên rỗng. <==");
                    }
                    break;
                case 5:
                    showSubjects(subjects);
                    break;
                case 6:
                    showStudents(students);
                    break;
                case 7:
                    showCourses(courses);
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

    private static boolean addStudentToCourse(ArrayList<Course> courses,
                                              ArrayList<Student> students, Scanner input) {
        System.out.println("Nhập mã lớp học: ");
        var courseId = input.nextLine();
        var course = findCourseById(courses, courseId);
        if (course != null) {
            showStudentInCourse(course.getTranscriptOfStudents());
            System.out.println("Nhập mã sinh viên: ");
            var studentId = input.nextLine();
            var student = findStudentById(students, studentId);
            if (student != null) {
                course.addStudentToCourse(student);
                return true;
            } else {
                System.out.println("==> Sinh viên cần tìm không tồn tại <==");
                return false;
            }
        } else {
            System.out.println("==> Lớp cần tìm không tồn tại <==");
            return false;
        }
    }

    private static Student findStudentById(ArrayList<Student> students, String studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (studentId.compareTo(students.get(i).getId()) == 0) {
                return students.get(i);
            }
        }
        return null;
    }

    private static void showStudentInCourse(ArrayList<Course.TranscriptOfStudent> transcriptOfStudents) {
        System.out.println("==> Các sinh viên đã có trong lớp học: <==");
        System.out.printf("%-12s%-22s%-20s%-20s%-12s%-20s%-15s%-15s\n",
                "Mã SV", "Họ và tên", "Địa chỉ", "Email", "Giới tính", "Số ĐT",
                "Lớp", "Khoa");
        for (var item : transcriptOfStudents) {
            showStudent(item.getStudent());
        }
    }

    private static Course findCourseById(ArrayList<Course> courses, String courseId) {
        for (int i = 0; i < courses.size(); i++) {
            if (courseId.compareTo(courses.get(i).getId()) == 0) {
                return courses.get(i);
            }
        }
        return null;
    }

    private static void showCourses(ArrayList<Course> courses) {
        System.out.println("=================> Danh sách các lớp học <=================");
        System.out.printf("%-12s%-25s%-15s%-15s%-15s\n",
                "Mã lớp", "Tên lớp", "Phòng học", "Giờ học", "Môn học");
        for (var course : courses) {
            showCourse(course);
        }
    }

    private static void showCourse(Course course) {
        System.out.printf("%-12s%-25s%-15s%-15s%-15s\n",
                course.getId(), course.getName(), course.getClassRoom(),
                course.getTime(), course.getSubject().getName());
    }

    private static Course createNewCourse(Scanner input, ArrayList<Subject> subjects) {
        System.out.println("Nhập mã lớp học: ");
        var id = input.nextLine();
        System.out.println("Nhập tên lớp học: ");
        var name = input.nextLine();
        System.out.println("Nhập tên phòng học: ");
        var room = input.nextLine();
        System.out.println("Nhập giờ học: ");
        var time = input.nextLine();
        System.out.println("Nhập mã môn học: ");
        var subjectId = input.nextLine();
        var subject = findSubjectById(subjects, subjectId);
        if (subject == null) {
            System.out.println("==> Không tồn tại môn học có mã vừa nhập <==");
            return null;
        } else {
            return new Course(id, name, room, time, subject);
        }
    }

    private static Subject findSubjectById(ArrayList<Subject> subjects, String subjectId) {
        for (var s : subjects) {
            if (s.getId().compareTo(subjectId) == 0) {
                return s;
            }
        }
        return null;
    }

    private static void showStudents(ArrayList<Student> students) {
        System.out.println("===============================================> " +
                "Danh sách sinh viên <===============================================");
        System.out.printf("%-12s%-22s%-15s%-20s%-12s%-15s%-15s%-15s\n",
                "Mã SV", "Họ và tên", "Địa chỉ", "Email", "Giới tính", "Số ĐT",
                "Lớp", "Khoa");
        for (var student : students) {
            showStudent(student);
        }
    }

    private static void showStudent(Student student) {
        System.out.printf("%-12s%-22s%-15s%-20s%-12s%-15s%-15s%-15s\n",
                student.getId(), student.getFullName(), student.getAddress(),
                student.getEmail(), student.getGender(), student.getPhoneNumber(),
                student.getClassName(), student.getMajor());
    }

    private static Student createNewStudent(Scanner input) {
        System.out.println("Nhập mã sinh viên: ");
        var id = input.nextLine();
        System.out.println("Nhập họ và tên: ");
        var fullName = input.nextLine();
        System.out.println("Nhập địa chỉ: ");
        var address = input.nextLine();
        System.out.println("Nhập email: ");
        var email = input.nextLine();
        System.out.println("Nhập số điện thoại: ");
        var phoneNumber = input.nextLine();
        System.out.println("Nhập giới tính: ");
        var gender = input.nextLine();
        System.out.println("Nhập lớp: ");
        var className = input.nextLine();
        System.out.println("Nhập khoa: ");
        var major = input.nextLine();
        return new Student(id, address, fullName,
                email, gender, className, major, phoneNumber);
    }

    private static void showSubjects(ArrayList<Subject> subjects) {
        System.out.println("=========================> " +
                "DANH SÁCH MÔN HỌC <=========================");
        System.out.printf("%-12s%-25s%-12s%-12s%-12s\n",
                "Mã môn", "Tên môn", "Số tín", "Số tiết", "Số bài KT");
        for (var s : subjects) {
            showSubject(s);
        }
    }

    private static void showSubject(Subject s) {
        System.out.printf("%-12s%-25s%-12s%-12s%-12s\n",
                s.getId(), s.getName(), s.getCredit(),
                s.getNumOfLesson(), s.getNumOfExam());
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
