
public abstract class BattleLoc extends Location{
	protected Obstacle obstacle;
	protected String award;
	
	public BattleLoc(Player player ,String name, Obstacle obstacle,String award) {
		super(player);
		this.name = name;
		this.obstacle = obstacle;
		this.award = award;
	}

	public boolean getLocation() {
		int obsCount = this.obstacle.Count();
		System.out.println("Şuan buradasınız: " +  getName());
		System.out.println("Dikkatli ol! Burada "  +obsCount + " tane " + obstacle.getName() + " yaşıyor!");
		System.out.println("<S>avaş veya <K>aç ? (işaretli tuşlardan birine basınız)");
		String selCase = scan.next();
		selCase = selCase.toUpperCase();
		if(selCase.equals("S")) {
			playerStats();
			enemyStats();
			if(combat(obsCount)) {
				System.out.println(this.getName() + " Bölgesindeki Tüm düşmanları yendiniz!");
				if(this.award.equals("Food") && player.getInv().isFood() == false) {
					System.out.println(this.award + " Kazandınız!");
					player.getInv().setFood(true);
				}else if(this.award.equals("Firewood") && player.getInv().isFirewood() == false) {
					System.out.println(this.award + " Kazandınız!");
					player.getInv().setFirewood(true);
				}else if(this.award.equals("Water") && player.getInv().isWater() == false) {
					System.out.println(this.award + " Kazandınız!");
					player.getInv().setWater(true);;
				
				}
				return true;
			}
			if(player.getHealth() <= 0) {
				System.out.println("ÖLDÜNÜZ !");
				return false;
			}
			
				
			
		}
		return true; 
	}
	
	public boolean combat(int obsCount) {
		for(int i = 0; i<obsCount; i++) {
			int defObsHealth = obstacle.getHealth();
			while(player.getHealth()>0 && obstacle.getHealth()>0) {
				System.out.println("<V>ur veya <K>aç ? (işaretli tuşlardan birine basınız)");
				String selCase = scan.next();
				selCase = selCase.toUpperCase();
				if(selCase.equals("V")) {
					System.out.println("Hasar verdiniz !");
					obstacle.setHealth(obstacle.getHealth()- player.getTotalDamage());
					afterHit();
					if(obstacle.getHealth()>0) {
						System.out.println();
						System.out.println("Canavar size vurdu !");
						player.setHealth(player.getHealth()-(obstacle.getDamage()-player.getInv().getArmor()));
						afterHit();	
					}
				}else{
					return false;
				}
			}
			if(obstacle.getHealth() < player.getHealth()) {
					System.out.println("Düşmanı yendiniz !");
					player.setMoney(player.getMoney() + obstacle.getAward());
					System.out.println("Güncel paranız: "+ player.getMoney());
					obstacle.setHealth(defObsHealth);
					
			}else {
				return false;
				}
			
		}
		return true;
	}
	
	public void afterHit() {
		System.out.println("Savaşçı canı: " + player.getHealth());
		System.out.println(obstacle.getName() + " adlı canavarın canı: " + obstacle.getHealth());
	}
	
	public void playerStats() {
		System.err.println("Savaşçı değerleri \n**************** ");
		System.out.println("Can: " + player.getHealth());
		System.out.println("Hasar: " + player.getTotalDamage());
		System.out.println("Para: " + player.getMoney());
		if(player.getInv().getDamage()>0) {
			System.out.println("Silah :" + player.getInv().getwName());
		}
		if(player.getInv().getArmor()>0) {
			System.out.println("Zırh :" + player.getInv().getaName());
		}
	} 
	
	public void enemyStats() {
		System.err.println("\n"+obstacle.getName() + " değerleri \n****************");
		System.out.println("Can: " + obstacle.getHealth());
		System.out.println("Hasar: " + obstacle.getDamage());
		System.out.println("Ödül: " + obstacle.getAward());
	}
	
}


