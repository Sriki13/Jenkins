package unice.ihm.jenkins;

import java.util.Arrays;

import unice.ihm.jenkins.step.Step;

/**
 * @author Guillaume André
 */
public class MockRecipes {

    public static Recipe getPizzaRecipe() {
        return new Recipe("Beaucoup de finesse pour cette pizza un peu spéciale où la pâte traditionnelle est remplacée par une pâte feuilletée.\n" +
                "Mais hormis cette petite différence de pâte, les fondamentaux de la pizza sont là : sauce tomate, garniture variée et feuilles de basilic.",
                "pizza/main.jpg", "36 min",
                Arrays.asList(
                        new Ingredient("Jambon", 50, "g"),
                        new Ingredient("Huile d'olive", 1, "cuillière à soupe"),
                        new Ingredient("Pate feuilletée", 200, "g"),
                        new Ingredient("Sauce tomate", 120, "g"),
                        new Ingredient("Herbes de Provence", 1, "cuillière à soupe"),
                        new Ingredient("Chorizo", 50, "g"),
                        new Ingredient("Champignons", 100, "g"),
                        new Ingredient("Mozeralla", 50, "g")
                ),
                Arrays.asList(
                        new Step("", "pizza/01.jpg", "Faites dorer 50 g de jambon dans 1 cuillère à soupe d'huile d'olive sur feu vif."),
                        new Step("", "pizza/02.jpg", " Préchauffez votre four à 240°C (460°F). Étalez 200 g de Pâte feuilletée sur une plaque allant au four, si vous avez un papier laissez le en dessous.\n" +
                                "Piquez toute la surface de la pâte."),
                        new Step("", "pizza/03.jpg", "Étalez 120 g de Sauce tomate pour pizza sur toute la surface en laissant 0.5 cm au bord, et saupoudrez avec 1 cuillère à soupe d'herbes de Provence."),
                        new Step("", "pizza/04.jpg", "Répartissez dessus le jambon, puis tout ce que vous voulez comme ingrédients."),
                        new Step("", "pizza/05.jpg", "Ajoutez la mozzarella en petits cubes."),
                        new Step("", "pizza/06.jpg", "Ajoutez du fromage de chèvre, des champignons, etc."),
                        new Step("", "pizza/07.jpg", "Enfournez immédiatement dans un four bien chaud, et proche du bas du four plutôt qu'au milieu.\n" +
                                "Dès que la pizza est cuite, sortez du four, arrosez d'un filet d'Huile d'olive aux herbes et répartissez quelques feuilles de basilic.\n" +
                                "Servez immédiatement.")
                )
        );
    }

}
