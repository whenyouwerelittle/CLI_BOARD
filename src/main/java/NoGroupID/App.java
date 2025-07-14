package NoGroupID;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// 오늘숙제 삭제 수정 오류성 입력 방지하는 기능 추가
public class App {
    Scanner sc;
    List<Article> articleList = new ArrayList<>();

    App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        int lastId = 1;

        System.out.println("== 게시판 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine().trim();

            if (command.equals("종료")) {
                break;
            } else if (command.equals("등록")) {
                System.out.print("제목 : ");
                String subject = sc.nextLine().trim();
                System.out.print("내용 : ");
                String content = sc.nextLine().trim();

                Article article  = new Article(lastId, subject, content);
                articleList.add(article);

                System.out.printf("%d번 게시글이 등록되었습니다.\n", lastId);
                lastId++;
            } else if (command.equals("목록")) {
                System.out.println("번호 / 제목 / 내용");
                System.out.println("----------------------");

                for (int i = articleList.size() - 1; i >= 0; i--) {
                    Article article = articleList.get(i);
                    System.out.printf("%d / %s / %s\n", article.getId(), article.getSubject(), article.getContent());
                }
            } else if (command.startsWith("삭제")) {
                String[] commandList = command.split("\\?", 2);
                String[] paramsStr = commandList[1].split("=", 2);

                String value =  paramsStr[1];
                int idx = Integer.parseInt(value);

                Article article = _getFindById(idx);

                if (article == null) {
                    System.out.printf("%d번 게시물은 존재하지 않습니다.\n", idx);
                }
                else {
                    articleList.remove(article);
                    System.out.printf("%d번 게시물이 삭제되었습니다.\n", idx);
                }
            } else if (command.startsWith("수정")) {
                String[] commandList = command.split("\\?", 2);
                String[] paramsStr = commandList[1].split("=", 2);

                String value =  paramsStr[1];
                int idx = Integer.parseInt(value);

                Article article = _getFindById(idx);

                if (article == null) {
                    System.out.printf("%d번 게시물은 존재하지 않습니다.\n", idx);
                }
                else {
                    System.out.printf("제목(기존) : %s\n", article.getSubject());
                    System.out.print("제목 : ");
                    String modifySubject = sc.nextLine();
                    article.setSubject(modifySubject);

                    System.out.printf("내용(기존) : %s\n", article.getContent());
                    System.out.print("내용 : ");
                    String modifyContent = sc.nextLine();
                    article.setContent(modifyContent);

                    System.out.printf("%d번 게시물이 수정되었습니다.\n", idx);
                }
            }
        }
    }

    private Article _getFindById(int id) {
        for ( Article item : articleList ) {
            if ( item.getId() == id ) {
                return item;
            }
        }
        return null;
    }
}