package banque;
import java.util.Scanner;

//Scénario d'utilisation d'une appli bancaire avec 500 euros d'avoir disponible

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		ComptesCourant CourantGreg = new ComptesCourant();

		ComptesCourant DummyAccount = new ComptesCourant();
		DummyAccount.setID(239324);
		DummyAccount.setNom("Jean-Joseph");
		DummyAccount.setPrenom("Christian");
		DummyAccount.setSolde(100);
		
		
		System.out.println("Bienvenue chez SimplonCoin");
		System.out.println("Veuillez taper vos identifiants(nom/prénom) pour vous connecter.");
		String nom = sc.next();
		CourantGreg.setNom(nom);
		String prenom = sc.next();
		CourantGreg.setPrenom(prenom);

		System.out.println("Bon retour parmi nous Mr." + CourantGreg.getNom() + "  " + CourantGreg.getPrenom());

		while(running) {
			//Espace de connexion
			
			//
			
			
			//Choix des opérations
			System.out.println("Quelle(s) opération(s) voulez-vous effectuer ?");
			System.out.println("Consulter mes soldes - 1");
			System.out.println("***");

			System.out.println("Retirer de l'argent - 2");
			System.out.println("***");

			System.out.println("Versement - 3");
			System.out.println("***");

			System.out.println("Se deconnecter - 4");
			System.out.println("***");
			int actions = sc.nextInt();
			
			
			//Consultation du solde
			if(actions == 1) {
				System.out.println("Vos comptes ont actuellement : " + CourantGreg.getSolde());
				
				
				//Retrait d'argent
			} else if(actions == 2) {
				System.out.println("Quelle somme souhaitez vous retirer ?");

				double amount = sc.nextDouble();
				double newsold = CourantGreg.getSolde() - amount ;
				System.out.println("Vous avez retirer :" + amount + "euros.");
				System.out.println("Il vous reste : " + newsold + "euros.");
				running = true;
				if(amount > CourantGreg.getSolde()) {
					System.out.println("Vous n'avez pas assez d'argent.");
				}


				//Versement
			} else if(actions == 3) {
				System.out.println("Vers quels compte(s) souhaitez vous transferer de l'argent ?");
				System.out.println("[1]: " + DummyAccount.getNom() + "  " + DummyAccount.getPrenom() + "  :" + " ID de compte " + DummyAccount.getID());
				int x = sc.nextInt();
				if(x == 1) {
					System.out.println("Quelle somme souhaitez vous envoyer vers ce compte ?");
					double versAmount = sc.nextInt();
					if(versAmount > CourantGreg.getSolde()) {
						System.out.println("Vous n'avez pas assez d'argent.");
					} else {
						System.out.println("Vous avez envoyer : " + versAmount + " au compte numéro" + DummyAccount.getNom() + "  " + DummyAccount.getPrenom() + "  :" + " ID de compte " + DummyAccount.getID());
						System.out.println("Il vous reste :"  + (CourantGreg.getSolde() - versAmount) + "euros");
						double dummySold = versAmount + DummyAccount.getSolde();
						System.out.println("Votre ami a maintenant :" + (DummyAccount.getSolde() + versAmount) + " euros.");
					}

				}
				
				
				//Log out
			} else if(actions == 4) {
				running = false;
				System.out.println("Au revoir.");
			}


		}
	}


}
