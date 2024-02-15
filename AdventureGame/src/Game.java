import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);
	
	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Macera Oyununa Hoşgeldiniz !");
		System.out.println("Oyuna Başlamadan önce isminizi giriniz: ");
		String playerName = scan.nextLine();
		System.out.println("Merhaba " + playerName + ". Amacın; her bölgedeki canavarları yenip, eşyaları elde edip, tekrar güvenli eve dönmek. Boş Şans!");
		player = new Player(playerName);
		player.selectCha();
		
		start();
		
	}
	
	public void start() {
		while(true) {
			System.out.println();
			System.out.println("*****************************");
			System.out.println();
			System.out.println("Eylem gerçekleştirmek için bir konum seçiniz : ");
			System.out.println("1. Güvenli ev  \t-----> Size ait güvenli bir ev, burada düşman yok");
			System.out.println("2. Mağara \t-----> Karşınıza belki Zombi çıkabilir !!!");
			System.out.println("3. Orman \t-----> Karşınıza belki Vampir çıkabilir !!!");
			System.out.println("4. Nehir \t-----> Karşınıza belki Dev Ayı çıkabilir !!!");
			System.out.println("5. Dükkan \t-----> Silah veya Zırh satın alabilirsiniz !");
			System.out.println();
			System.out.println("Gitmek istediğiniz yeri seçiniz!");
			try {
			int selLoc = scan.nextInt();
			while(selLoc < 0 || selLoc> 5 ) {
				System.out.println("Lütfen geçerli bir yer seçiniz :");
				selLoc = scan.nextInt();
			}
			
			
			switch(selLoc) {
			case 1 :
				location = new SafeHouse(player);
				break;
			case 2:
				location = new Cave(player);
				break;
			case 3:
				location = new Forest(player);
				break;
			case 4: 
				location = new River(player);
				break;
			case 5 :
				location = new ToolStore(player);
				break;
			default:
				location = new SafeHouse(player);

			}
			if(location.getClass().getName().equals("SafeHouse")) {
				if(player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()) {
					System.out.println("TEBRİKLER OYUNU KAZANDINIZ !!!");
					break;
				}
			}
			if(!location.getLocation()) {
				System.err.println("OYUN BİTTİ!");
				break;
			}
		} catch (InputMismatchException e) {
            System.err.println("Lütfen sadece verilen sayıları giriniz.");
            scan.nextLine(); 
			}
		}
	}
	
	
}
