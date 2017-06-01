import java.io.IOException;

import coo.product.Management;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {

	@Override
	public void start(Stage stage) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	
    	Parent acteur = (Parent) loader.load(getClass().getResource("visual/customer/Page1.fxml"));
    	
    	Scene scene = new Scene(acteur, 1280.0, 720.0);
    	
    	stage.setTitle("SUBPAY-Accueil");
        stage.setScene(scene);
        stage.show();
	}

	public static void main(String[] args) {
		Management.importer("export.xml");
		launch(args);
	}
	
	public static void testExport(){ 
		Management.addBread("Avoine", "C:\\...");
		Management.addBread("Mie", "C:\\...");
		Management.getBread("Mie").addAllergen("Levure");
		Management.addBread("Olive", "C:\\...");
		Management.addSauce("Andalouse", "C:\\...");
		Management.addPromotion("mercredi", 5.5, false);
		Management.addPromotion("auth", 10, true);
		Management.addRecipe("poulet", "mouais", 214, "C:\\...");
		Management.getPromotion("mercredi").addRecipe("poulet");
		Management.getPromotion("mercredi").addRecipe("kebab");
		Management.addGarnish("tomate", "titi");
		Management.addGarnish("basilic", "titi");
		Management.addGarnish("cheddar", "titi");
		Management.addDrink("cola cola", "toto");
		Management.addDessert("brownie", "truc marron");
		Management.export("export.xml");
		Management.importer("export.xml");
	}
}
