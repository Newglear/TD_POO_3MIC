import java.awt.Color ;

public class Robot {

    /* 
     *  Les attributs de chaque Robot. 
     */

    /** Position du robot */
    protected int x, y ;

    /** Vitesse du robot */
    protected int vx, vy ;

    /** Etat du robot */
    private boolean vivant ;

    /** Sprite (==image) representant le robot */
    private Sprite image ;
    
    /** Plateau sur lequel le robot evolue */
    private Plateau plat ;

    /** Ce robot est-il arrete' ? */
    private boolean arrete ;

	private	Color col;

	private float time = 0.0f; 

	protected int Serie;

	protected String nom;

	public static final int maxExplosions =2;
	protected static int exp=0;
	public static int nbRob = 0;
	protected static Logs colLog = new Logs();
	protected static Logs expLog = new Logs();

    /* 
     *  Constructeur de Robot. 
     */

    /** Cree un nouveau robot avec l'image indiquee, a la position indiquee sur le plateau
     *  La vitesse de depart est aleatoire
     */
    public Robot (String Nom,String nomImage, int init_x, int init_y, Plateau pt,Color col) {
	this.x = init_x ;
	this.y = init_y ;
	this.vivant = true ;
	this.vx = this.randomV() ;
	this.vy = this.randomV() ;
	this.plat = pt ;
	this.image = pt.addSprite (nomImage, this.x, this.y) ;
	this.arrete = false ;
	this.col= col;
	this.nom = Nom;
	this.Serie = nbRob;
	nbRob++;
    }

    /*
     *  Méthodes
     */


    /** Renvoie une valeur de vitesse aleatoire */
    public int randomV() { return (int)(Math.random() * 6) - 3 ; }

    /** Recupere la largeur de l'image du robot */
    public int getLarg() { return this.image.getLarg() ; }

    /** Recupere la hauteur de l'image du robot */
    public int getHaut() { return this.image.getHaut() ; }


    /** Effectue un deplacement elementaire du robot */
    public void bouge() {

	if (this.vivant) {

	    this.x += this.vx ;
	    this.y += this.vy ;
	    	    
	    // Si le robot rejoint un bord de la fenetre, il rebondit et change de direction
	    int futurX = this.x + this.vx ;
	    int futurY = this.y + this.vy ;
	    
	    // Collision avec le bord gauche
	    if (futurX < 0) {
		this.vx = Math.abs(this.vx) ;
		this.vy = this.randomV() ;
	    }

	    // Collision avec le bord droit
	    if (futurX + this.getLarg() > this.plat.getLarg()) {
		this.vx = -Math.abs(this.vx) ;
		this.vy = this.randomV() ;
	    }

	    // Collision avec le bord haut 
	    if (futurY < 0) {
		this.vy = Math.abs(this.vy) ;
		this.vx = this.randomV() ;
	    }

	    // Collision avec le bord bas
	    if (futurY + this.getHaut() > this.plat.getHaut()) {
		this.vy = -Math.abs(this.vy) ;
		this.vx = this.randomV() ;
	    }
		this.time = this.time+1f; 
		if (this.time== 10f){
			plat.setColor(col);
			plat.drawCircle(this.x,this.y,5);
			this.time=0f;
			}
		
	}

	// Redessine le robot au nouvel endroit
	// Force a redessiner, meme si le robot n'a pas bouge.

	this.image.moveTo(this.x, this.y) ;

    }

    
    /** Teste si ce robot est en collision avec le robot 'autre' */
    public void testeCollision(Robot autre) {

	// Pour etre en collision, il faut une intersection sur les X ET sur les Y
	boolean enCollision = ((this.x + this.getLarg() >= autre.x) && (this.x < autre.x + autre.getLarg()) &&
			       (this.y + this.getHaut() >= autre.y) && (this.y < autre.y + autre.getHaut())) ;

	// Si on est en collision avec un robot different de soi-meme, on reagit et l'autre aussi.
	if (this.vivant && autre.vivant && (autre != this) && enCollision) {

	    // Si les deux robots sont deja arretes, on ne fait rien.
	    if (this.arrete && autre.arrete) {}
	    else {
		this.collision(autre) ;
		autre.collision(this) ;
		colLog.add("Collision détectée",this,autre);
	    }
	}
    }

    /** Arrêter ce robot. */
    public void arreterRobot() {
	this.vx = 0 ;
	this.vy = 0 ;
	this.arrete = true ;
    }

    /** Fait exploser ce robot */
    public void explose() {

		if(verExp()){
			exp += 1;
			this.image.playSequence(Images.explosion, false) ;
			this.vivant = false ;

		}
    }

    /** Reaction a une collision : on s'arrete */
    public void collision(Robot autre) {
		this.arreterRobot() ;
		direBonjour(autre);
    }
	public  int getSerie(){
		return this.Serie;
	}
	public String toString (){
		return "Moi "+this.nom+"suis un ROBOT en "+this.x+" "+this.y+" de la série"+this.Serie;
	}
	public static boolean verExp(){
		return exp < maxExplosions;
	}

	public void direBonjour(Robot autre) {
		try {
			System.out.println("Rebonjour, on s'est déjà croisé le" + colLog.trouveLigne(this, autre).getDate());
		} catch (PasTrouve e) {
			System.out.println("Bonjour,enchanté de vous rencontrer");
		}
	}
}
