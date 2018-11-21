/* Dernière modification par Théotime Darmet
 *
 * Méthode définissant la carte de combat. Est composée d'un tableau d'obstacles (dont les valeurs maximales sont définis par les ints dimX et dimY)
 * d'un tableau d'entiers représentant la visibilité du joueur sur la zone et d'une liste de soldats.
 *
 */ 

package War;

public class Carte {
	
	private Obstacle[][] terrain;
	private Soldat[] unites;
	private int [][] visuel;
	private int dimX;
	private int dimY;
	private int nbUnit;

	public static final int CACHE = 0; /*Zone jamais vue (hexagone gris)*/
	public static final int DECOUVERT = 1; /*Zone cachée mais déjà révélée précédemment (hexagone gris)*/ 
	public static final int REVELE = 2; /*Une unité alliée voit la zone (hexagone coloré)*/
	public static final int MAX_UNITE = 90;
	
	public Carte (int tailleX, int tailleY){
		this.dimX = tailleX;
		this.dimY = tailleY;
		this.nbUnit = 0;
		this.terrain = new Obstacle[dimX][dimY];
		this.visuel = new int[dimX][dimY];
		for (int i = 0; i < this.dimY; i++){
			for (int j = 0; j < this.dimY; j++){
				this.terrain[i][j] = new Obstacle(new Position(i, j), Obstacle.TERRE);
				this.visuel[i][j] = this.CACHE;
			}
		}
		this.unites = new Soldat[MAX_UNITE];
	}
	
	public int getDimX() {
		return dimX;
	}
	
	public int getDimY() {
		return dimY;
	}
	
	public Obstacle getTerrain(Position p) {
		return terrain[p.getX()][p.getY()];
	}
	
	public int getVisuel(Position p){
		return visuel[p.getX()][p.getY()];
	}
	
	public Soldat getUnite(int n) {
		return unites[n];
	}
	
	public int getNbUnit() {
		return nbUnit;
	}
	
	public void setNbUnit(int nbUnit) {
		this.nbUnit = nbUnit;
	}
	
	public boolean unitePresente(Position p){
		for (int i = 0; i < getNbUnit(); i++){
			if (unites[i].getPos().equals(p)){
				return true;
			}
		}
		return false;
	}
	
	public Soldat unite(Position p){
		for (int i = 0; i < getNbUnit(); i++){
			if (unites[i].getPos().equals(p)){
				return unites[i];
			}
		}
		return null;
	}
	
	public boolean ajouterUnite(Soldat s){
		if (s.getVolant())
		{
			this.unites[this.getNbUnit()] = s;
			this.setNbUnit(this.getNbUnit()+1);
			return true;
		}
		if (this.getTerrain(s.getPos()).isPraticable())
		{
			if (this.unitePresente(s.getPos())){
				if (this.unite(s.getPos()).getVolant()){
					this.unites[this.getNbUnit()] = s;
					this.setNbUnit(this.getNbUnit()+1);
					return true;
				}
				System.out.println("Il y a déjà une unité terrestre en " + s.getPos());
				return false;
			}
			this.unites[this.getNbUnit()] = s;
			this.setNbUnit(this.getNbUnit()+1);
			return true;
		}
		System.out.println("Le terrain en " + s.getPos() + " n'est pas praticable.");
		return false;
	}
	
	public int seDeplacer(Soldat s, Position p){
		if(s.getPos().adjacent(p)){
			if (s.getVolant()){
				s.setPos(p);
				return 1;
			}
			if (this.getTerrain(p).isPraticable())
			{
				if (this.unitePresente(p)){
					if (this.unite(p).getVolant()){
						s.setPos(p);
						return 1;
					}
					System.out.println("Il y a déjà une unité terrestre en " + p);
					return 0;
				}
				s.setPos(p);
				return 1;
			}
			System.out.println("Le terrain en " + p + " n'est pas praticable.");
			return 0;
		}
		System.out.println("Le terrain en " + p + " n'est pas adjacent.");
		return 0;
	}
}