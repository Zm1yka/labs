package lab3Droids;

public class SupportDroid extends Droid {
    public SupportDroid(String name) {
        super(name, 80, 10);
    }

    @Override
    public void attack(Droid enemy) {
        System.out.println(name + " надає підтримку і атакує " + enemy.getName() + ", наносячи " + damage + " урону.");
        enemy.takeDamage(damage);
        System.out.println(enemy.getName() + " тепер має " + enemy.getHealth() + " здоров'я.");
    }
    
    public void heal(Droid ally) {
    	int healHp = 15;
    	ally.health += healHp;
    	System.out.println(name + " лікує " + ally.getName() + " на " + healHp + " здоров'я.");
    }
    
	@Override
	public int getDamage() {
		return damage;
	}
}
