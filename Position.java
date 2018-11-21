/* Dernière modification par Théotime Darmet
 * 
 * Objet Position contenant deux coordonnées int.
 * 
 * Methode:
 -> distance(Position p) -> Renvoie la distance en cases entre p et this.
 -> adjacent(Position p) -> Vérifie que la distance entre p et his est 1.
 * 
 * To String: "(x,y)"
 * 
 */

package War;

public class Position {
	
	private int posX;
	private int posY;
	
	public Position(int x, int y){
		this.posX = x;
		this.posY = y;
	}
	
	public void setPosition(int x, int y){
		this.posX = x;
		this.posY = y;
	}
	
	public int getX(){
		return this.posX;
	}
	
	public int getY(){
		return this.posY;
	}
	
	public boolean adjacent(Position p){
		return this.distance(p) == 1;
	}
	
	public int distance(Position p){
		int x = Math.abs(this.getX() - p.getX());
		int y = Math.abs(this.getY() - p.getY());
		
		if ( (this.getX()%2 == 0 && this.getY() > p.getY()) || (this.getX()%2 == 1 && this.getY() < p.getY())){
			return (x+y-Math.min((x+1)/2, y));
		}
		return (x+y-Math.min(x/2, y));	
	}
	
	public String toString(){
		return ("(" + this.getX() + "," + this.getY() + ")");
	}
	
	public boolean equals(Position p){
		return this.getX() == p.getX() && this.getY() == p.getY();
	}
}
