package chap2_4.collection.song;

import chap1_9.static_.util.InputUtils;

public class ArtistController {
    private ArtistRepository repository;

    public ArtistController() {
        this.repository = new ArtistRepository();
    }

    public void start() {


        while (true) {
            System.out.println("\n\n****** 음악 관리 프로그램 ******");
            System.out.printf("# 현재 등록된 가수: %d명\n", repository.count());
            System.out.println("# 1. 노래 등록하기");
            System.out.println("# 2. 노래 정보 검색");
            System.out.println("# 3. 등록된 가수 전체조회");
            System.out.println("# 4. 프로그램 종료");
            System.out.println("==================================");

            String menuNum = InputUtils.prompt(">> ");

            switch (menuNum) {
                case "1":
                    addArtistProcess();
                    break;
                case "2":
                    searchProcess();
                    break;
                case "3":
                    // 전체 등록되어있는 가수들의 이름과 노래의 개수를 출력
                    // ex) 동방신기 - 총 4곡
                    //     르세라핌 - 총 2곡
                    showAllArtist();
                    break;
                case "4":
                    System.out.println("# 프로그램을 종료합니까? [y/n]");
                    String exit = InputUtils.prompt(">> ");
                    if (exit.equalsIgnoreCase("y")) {
                        System.exit(0);
                    } else {
                        System.out.println("# 종료를 취소합니다.");
                    }
                    break;
                default:
                    System.out.println("# 메뉴를 잘못 입력했습니다.");
            }// end switch

            System.out.println("==== 계속하시려면 Enter... ====");
            InputUtils.prompt("");
        }

    } // end start()

    private void showAllArtist() {
    }

    private void searchProcess() {
    }

    private void addArtistProcess() {
        repository.
    }
}
