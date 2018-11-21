/* Dernière modification par Théotime Darmet
 * 
 * Classe représentant l'ensemble des unitées du jeu.
 * 
 * Méthodes:
 -> attaqueCaC(Soldat s) Attaque la cible en prenant en compte les capacitées de mêlée. Marche toujours.
 -> attaqueDistance(Soldat s) Attaque la cible en prenant en compte les capacitées à distance. Marche toujours.
 -> attaque(Soldat s) Vérifie les conditions d'attaque et appelle en fonction attaqueCaC ou attaqueDistance. Echoue si la cible est hors de portée du lanceur.
 -> estMort() Vérifie si l'unité est morte (PV = 0).  
 * 
 */

package War;

public class Soldat extends Element{

	private	int pv;
	private int vision;
	private int degatCaC;
	private int degatDistance;
	private int portee;
	private boolean volant;
	private String nom = "undefind";
	
	public final static int EPEISTE_HUMAIN = 1;
	public final static int AIGLE = 2;
	public final static int ARCHER_GOBELIN = 3;
	
	public Soldat (Position p, int unite){
		super(p);
		switch(unite){
		case EPEISTE_HUMAIN:
			this.pv = 10;
			this.vision = 3;
			this.degatCaC = 5;
			this.degatDistance = 0;
			this.portee = 0;
			this.volant = false;
			break;
		case AIGLE:
			this.pv = 25;
			this.vision = 5;
			this.degatCaC = 12;
			this.degatDistance = 0;
			this.portee = 0;
			this.volant = true;
			break;
		case ARCHER_GOBELIN:
			this.pv = 6;
			this.vision = 3;
			this.degatCaC = 3;
			this.degatDistance = 3;
			this.portee = 3;
			this.volant = false;
			break;
		default:
			System.out.println("Affectation invalide: Unite");
			break;
		}
	}
	
	
	/* get et set */
	
	public int getPV(){
		return pv;
	}
	
	public int getDegatCaC() {
		return degatCaC;
	}
	
	public int getPortee() {
		return portee;
	}
	
	public Position getPos() {
		return super.getPos();
	}
	
	public int getVision() {
		return vision;
	}
	
	public int getDegatDistance() {
		return degatDistance;
	}
	
	public boolean getVolant() {
		return volant;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setPos(Position p) {
		super.setPos(p);
	}

	public void setDegatCaC(int degatCaC) {
		this.degatCaC = degatCaC;
	}
	
	public void setDegatDistance(int degatDistance) {
		this.degatDistance = degatDistance;
	}
	
	public void setPortee(int portee) {
		this.portee = portee;
	}
	
	public void setPv(int pv) {
		this.pv = pv;
	}
	
	public void setVision(int vision) {
		this.vision = vision;
	}
	
	public void setVolant(boolean volant) {
		this.volant = volant;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	/* Methodes de combat */
	
	/* Inflige a la cible s un nombre de dégâts aléatoire entre 1 et ses dégâts d'attaque. Renvoie le coup en action payé (1 si l'attaque est possible, 0 sinon) */
	
	public void attaqueCaC(Soldat s){
		int dommages = Math.min((int)(Math.random()*(this.degatCaC)+1), this.degatCaC);
		System.out.println("Attaque de " + this.getNom() + " sur " + s.getNom() + ". Dégâts infligés : " + dommages);
		System.out.println("Points de vie initiaux de " + s.getNom() + ": " + s.getPV());
		s.setPv(s.getPV()-dommages);
		System.out.println("Points de vie finaux de " + s.getNom() + ": " + s.getPV());
	}
	
	public void attaqueDistance(Soldat s){
		int dommages = Math.min((int)(Math.random()*(this.degatDistance)+1), this.degatDistance);
		System.out.println("Attaque de " + this.getNom() + " sur " + s.getNom() + ". Dégâts infligés : " + dommages);
		System.out.println("Points de vie initiaux de " + s.getNom() + ": " + s.getPV());
		s.setPv(s.getPV()-dommages);
		System.out.println("Points de vie finaux de " + s.getNom() + ": " + s.getPV());
	}
	
	public int attaque (Soldat s){
		if (this.getPos().distance(s.getPos()) <= 1){
			this.attaqueCaC(s);
			return 1;
		}
		if (this.getPos().distance(s.getPos()) <= this.getPortee()){
			this.attaqueDistance(s);
			return 1;
		}
		System.out.println("La cible est hors de portee");
		return 0;
	}
	
	public boolean estMort(){
		return (this.getPV() == 0);
	}
}