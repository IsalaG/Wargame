/* Dernière modification par Théotime Darmet
 * 
 * Regroupe les types de terrain.
 * Pour le moment, seul EAU et TERRE sont défini.
 * 
 * Méthode
 -> isPraticable() -> renvoie vrai si le terrain est fondamentalement accessible par une unité terrestre (ne tient pas compte de l'éventuelle présence d'une unité ennemie).
 * 
 */

package War;

public class Obstacle extends Element{
	
	private boolean praticable;
	private String nom;
	
	public final static int TERRE = 0;
	public final static int EAU = 1;
	
	public Obstacle(Position p, int elem){
		super(p);
		switch(elem){
			case TERRE:
				this.praticable = true;
				this.nom = "Terre";
				break;
			case EAU:
				this.praticable = false;
				this.nom = "Eau";
				break;
			default:
				System.out.println("Affectation invalide: Obstacle");
				break;
		}
	}
	
    public boolean isPraticable() {
		return praticable;
	}
	
	public void changeTerrain(int elem){
		switch(elem){
		case TERRE:
			this.praticable = true;
			this.nom = "Terre";
			break;
		case EAU:
			this.praticable = false;
			this.nom = "Eau";
			break;
		default:
			System.out.println("Affectation invalide: Obstacle");
			break;
		}
	}
}