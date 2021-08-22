import java.util.*;

public class account {
    public static Map<String, String> createAccountMap = new HashMap<>();
    public static Map<String, String> loginAccountMap = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("이 사이트에서 무엇을 하시겠습니까?");
            System.out.println("1. 계정 생성");
            System.out.println("2. 로그인");
            System.out.println("3. 로그아웃");
            System.out.println("4. 로그인 계정 확인");
            System.out.println("5. 종료");
            String input = scanner.nextLine();
            int pause = pauseInt(input);
            if (pause == 1) {
                createAccount();
            } else if (pause == 2) {
                loginAccount();
            } else if (pause == 3) {
                logoutAccount();
            } else if (pause == 4) {
                getLoginAccount();
            } else if (pause == 5) {
                System.out.println("사이트를 종료합니다.");
                break;
            } else {
                System.out.println("1부터 5까지의 번호만 입력하세요.");
            }
        }
    }

    public static void createAccount() {
        System.out.println("아이디와 비밀번호를 등록하시오");
        String id = scanner.nextLine();
        String password = scanner.nextLine();
        System.out.println("계정 생성에 성공하셨습니다!");
        System.out.println("생성한 계정은" + "\n" + "id: " + id + "\n" + "password: " + password);
        createAccountMap.put(id, password);
    }

    public static void loginAccount() {
        while (true) {
            System.out.println("아이디와 비밀번호를 입력하시오");
            String loginId = scanner.nextLine();
            if (loginId.equals("종료")) {
                System.out.println("시스템을 종료합니다.");
                break;
            } else {
                String loginPassword = scanner.nextLine();
                String get = createAccountMap.get(loginId);
                try {
                    if (get.equals(loginPassword)) {
                        System.out.println("계정 로그인에 성공하셨습니다!");
                        loginAccountMap.put(loginId, loginPassword);
                        break;
                    } else {
                        System.out.println("비밀번호가 틀립니다.");
                    }
                } catch (NullPointerException e) {
                    System.out.println("아이디가 올바르지 않습니다.");
                }
            }
        }
    }

    public static void logoutAccount() {
        while (true) {
            System.out.println("로그아웃 할 계정의 아이디와 비밀번호를 적어주시오");
            String logoutId = scanner.nextLine();
            if (logoutId.equals("종료")) {
                System.out.println("시스템을 종료합니다.");
                break;
            } else {
                String logoutPassword = scanner.nextLine();
                String get = createAccountMap.get(logoutId);
                try {
                    if (get.equals(logoutPassword)) {
                        System.out.println("계정 로그아웃에 성공하였습니다!");
                        loginAccountMap.remove(logoutId, logoutPassword);
                        break;
                    } else {
                        System.out.println("비밀번호가 틀립니다.");
                    }
                } catch (NullPointerException e) {
                    System.out.println("아이디가 올바르지 않습니다.");
                }
            }
        }
    }

    public static void getLoginAccount() {
        if (loginAccountMap.isEmpty()) {
            System.out.println("로그인한 계정이 없습니다.");
        } else {
            int size = loginAccountMap.size();
            System.out.println("로그인한 계정은 " + size + "개 입니다.");
            System.out.println(loginAccountMap);
        }
    }

    public static int pauseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
