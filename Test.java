package War;

public class Test {
	
	public static void main(String[] args) {
		Carte c = new Carte(5, 5);
		Soldat Aragorn = new Soldat(new Position(2, 3), Soldat.EPEISTE_HUMAIN);
		Aragorn.setNom("Aragorn");
		Soldat GobNul = new Soldat(new Position(3, 3), Soldat.ARCHER_GOBELIN);
		GobNul.setNom("GobNul");
		Soldat AigleCool = new Soldat(new Position(2, 3), Soldat.AIGLE);
		AigleCool.setNom("AigleCool");
		c.ajouterUnite(Aragorn);
		c.ajouterUnite(GobNul);
		c.ajouterUnite(AigleCool);
		System.out.println(Aragorn.getPos());
		System.out.println(AigleCool.getPos());
		c.seDeplacer(Aragorn, new Position (3, 3));
		c.seDeplacer(AigleCool, new Position (3, 3));
		System.out.println(Aragorn.getPos());
		System.out.println(AigleCool.getPos());
		GobNul.attaque(AigleCool);
	}
}