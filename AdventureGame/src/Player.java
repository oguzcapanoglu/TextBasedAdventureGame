import java.util.Scanner;

public class Player {
	private int damage, health, money, rHealth;
	private String name, cName;
	private Inventory inv;
	Scanner scan = new Scanner(System.in);
	
	

	public int getrHealth() {
		return rHealth;
	}

	public void setrHealth(int rHealthß) {
		this.rHealth = rHealthß;
	}

	public Player(String name) {
		this.name = name;
		this.inv= new Inventory();
	}

	public int getTotalDamage() {
		return this.getDamage()+ this.getInv().getDamage();
	}
	
	
	public void selectCha() {
		switch (chaMenu()) {
		case 1: 
			initPlayer("Samuray" , 5 , 21 , 15);
			break;
		case 2: 
			initPlayer("Okçu" , 7 , 18 , 20);
			break;
		case 3: 
			initPlayer("Şovayle" , 8 , 24 , 5);
			break;
		default:
			initPlayer("Samuray" , 5 , 21 , 15);
			break;
		}
		System.out.println("Karakter : " + getcName() + " , Hasar: +" + getDamage() + " , sağlık : "+ getHealth() + " , para : " + getMoney());
	}

	public int chaMenu() {
		System.out.println("lütfen karakter seçiniz ! : ");
		System.out.println("1- Samuray: \t Hasar : 5 \t Sağlık : 21 \t Para : 15");
		System.out.println("2- okçu: \t Hasar : 7 \t Sağlık : 18 \t Para : 20");
		System.out.println("3- şovalye: \t Hasar : 8 \t Sağlık : 25  \t Para : 5");
		System.out.println("Seçiminiz: ");
		int chaId = scan.nextInt();
		
		while(chaId< 1 || chaId >3) {
			System.out.println("lütfen geçerli bir karakter seçiniz. ");
		}
		
		return chaId;
	}
	
	public int getDamage() {
		return damage;
	}

	public void initPlayer(String cName, int dmg, int health, int money) {
		setcName(cName);
		setDamage(dmg);
		setHealth(health);
		setMoney(money);
		setrHealth(health);
		
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}
	
	
	
}
