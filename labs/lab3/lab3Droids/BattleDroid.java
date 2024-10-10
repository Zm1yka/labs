package lab3Droids;

public class BattleDroid extends Droid {
    public BattleDroid(String name) {
        super(name, 100, 20);
    }

    @Override
    public void attack(Droid enemy) {
        System.out.println(name + " атакує " + enemy.getName() + " і наносить " + damage + " урону.");
        enemy.takeDamage(damage);
        System.out.println(enemy.getName() + " тепер має " + enemy.getHealth() + " здоров'я.");
    }

	@Override
	public int getDamage() {
		return damage;
	}
}
