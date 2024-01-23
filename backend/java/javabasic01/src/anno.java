public class anno {

}
// 定义EnemyBehavior接口
interface EnemyBehavior {
    @Deprecated
    void move();
    void attack();
}

 class Game {
    public static void main(String[] args) {
        // 创建一个特殊的敌人并定义其独特行为（匿名内部类实现EnemyBehavior接口）
        EnemyBehavior enemy = new EnemyBehavior(){
            @Override
            public void move() {
                System.out.println("The special enemy sneaks towards the player.");
            }

            @Override
            public void attack() {
                System.out.println("The special enemy launches a surprise attack on the player!");
            }
        };

        try {
            System.out.println(enemy.getClass());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

//JAVA的底层工作。
class Game$1 implements EnemyBehavior {
        @Override
        public void move() {
            System.out.println("The special enemy sneaks towards the player.");
        }

        @Override
        public void attack() {
            System.out.println("The special enemy launches a surprise attack on the player!");
        }
}
