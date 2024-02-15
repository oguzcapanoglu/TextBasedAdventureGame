
public class SafeHouse extends NormalLocation{

	public SafeHouse(Player player) {
		super(player, "Güvenli ev");
	}
	
	public boolean getLocation() {
		player.setHealth(player.getrHealth());
		System.out.println("İYİLEŞTİNİZ...");
		System.out.println("Şuan Güvenli ev adlı yerdesiniz.");
		return true;
	}
}
