/* Dernière modification par Théotime Darmet
 * 
 * Objet regroupant tous les types d'éléments, superclasse de Soldat et Obstacle.
 * 
 */

package War;

public class Element {
	
	Position pos;
	public Element (Position p){
		this.pos = p;
	}
	public Position getPos(){
		return this.pos;
	}
	public void setPos(Position p){
		this.pos = p;
	}
}