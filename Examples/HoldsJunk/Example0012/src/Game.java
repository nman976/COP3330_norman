import java.util.ArrayList;
public class Game {
    public static void main(String[] args){
        // using interface instead of just straight class. The behavior defines all the functions, giving us access to them.
        Kracken m1 = new Kracken();
        Shark m2 = new Shark();

        OrderAttack(m1);
        OrderAttack(m2);

        ArrayList<WaterMonsterBehavior> monsters = new ArrayList<>();
        monsters.add(new Shark());
        monsters.add(new Kracken());

        for(WaterMonsterBehavior m : monsters) {
            OrderAttack((WaterMonsterBehavior) m);
            }
        }

    public static void OrderAttack(WaterMonsterBehavior monster){
        monster.attack();
    }

}
