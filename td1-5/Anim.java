/** Boucle principale de la simulation */
import java.awt.Color ;	
public class Anim {

    /** Effectue une pause de la duree indiquee en millisecondes */
    public static void pause(int duree) {
	try {
	    Thread.currentThread().sleep(duree) ;
	} catch (InterruptedException e) {
	} 
    }

	/** Boucle principale */
    public void go() {
	
	Plateau plat ;
	Robot[] robots ;
	plat = new Plateau(800, 600) ;
	robots = new Robot[4] ;

	robots[0] = new Robot("John","Images/mini5.png", 80, 100, plat,Color.red) ;
	robots[1] = new Robot("James","Images/mini4.png", 600, 400, plat,Color.MAGENTA) ;
	robots[2] = new Robot("Willy","Images/mini1.png", 400, 100, plat,Color.blue) ;
	robots[3] = new Killer("Fred","Images/mini2.png", 300, 500, plat,Color.green,3,robots.length) ;
	// On repete la boucle d'animation sans arret
	while (true) {

	    // On fait evoluer chaque robot
	    for (int i = 0 ; i < robots.length ; i++) {
		robots[i].bouge () ;
	    }

	    // Puis on teste les collisions deux a deux
	    for (int i = 0 ; i < robots.length ; i++) {
		for (int j = i+1 ; j < robots.length ; j++) {
		    robots[i].testeCollision(robots[j]) ;
		}
	    }

	    // Petite pause
	    java.awt.Toolkit.getDefaultToolkit().sync(); // Sinon l'animation est saccadée - probablement à cause du Window Manager.
	    this.pause(12) ;
	}

    }
    

    public static void main(String[] args) {
	Anim an = new Anim() ;
	Images.init () ;
	an.go () ;
    }

}
