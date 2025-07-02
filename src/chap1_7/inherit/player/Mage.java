package chap1_7.inherit.player;

public class Mage extends Player {

    int mana;

    public Mage(String nickName) {
        super(nickName, 40);
        this.mana = 100;
    }

    @Override
    public void showStatus() {
        super.showStatus();
        System.out.println("# 마력: "+this.mana);
    }

    void fireBall(Player player) {
        /*
            파이어볼을 맞은 플레이어의 직업이 전사면 50의 데미지를 입혀라
            마법사면 60의 데미지
            사냥꾼이면 40의 데미지를 입혀주세요.

            만약 전사가 파이어볼을 맞으면 해당 전사는 돌진(dash)를 시전해야합니다.
         */
        System.out.printf("%s님이 파이어볼을 시전합니다.\n", this.nickName);
        if (this == player) {
            System.out.println("자기 자신에게는 시전할 수 없습니다");
            return;
        }

        if (player instanceof Warrior) {
            player.hp -= 50;
            if (player.hp < 0) player.hp = 0;
            System.out.printf("%s님이 -50의 데미지를 입었습니다. 남은 체력: %s\n", player.nickName, player.hp);
            ((Warrior) player).dash(this);
        } else if(player instanceof Mage) {
            player.hp -= 60;
            if (player.hp < 0) player.hp = 0;
            System.out.printf("%s님이 -60의 데미지를 입었습니다. 남은 체력: %s\n", player.nickName, player.hp);

        } else if (player instanceof Hunter) {
            player.hp -= 40;
            if (player.hp < 0) player.hp = 0;
            System.out.printf("%s님이 -40의 데미지를 입었습니다. 남은 체력: %s\n", player.nickName, player.hp);

        }
    }
}
