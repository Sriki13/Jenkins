package unice.ihm.jenkins.entities;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Guillaume André
 */
public class MockRecipes {

    public static Recipe getPizzaRecipe() {
        return new Recipe("Pizza pate feuilletée", "Beaucoup de finesse pour cette pizza un peu spéciale où la pâte traditionnelle est remplacée par une pâte feuilletée.\n" +
                "Mais hormis cette petite différence de pâte, les fondamentaux de la pizza sont là : sauce tomate, garniture variée et feuilles de basilic.",
                "pizza/main.jpg", "11 min de préparation, 25 min de cuisson", 4,
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
                        new Step("", "pizza/01.jpg", "Faites dorer 50 g de jambon dans 1 cuillère à soupe d'huile d'olive sur feu vif. Réserver.",
                                Collections.singletonList(new Keyword("Réserver", "Mettre de coté."))),
                        new Step("", "pizza/02.jpg", " Préchauffez votre four à 240°C (460°F). Étalez 200 g de Pâte feuilletée sur une plaque allant au four, si vous avez un papier laissez le en dessous.\n" +
                                "Piquez toute la surface de la pâte.",
                                Collections.singletonList(new Keyword("Piquez", "Piquer le fond d'une tarte ou une pâte en général pour éviter qu'elle ne cloque à la cuisson. En général on fait ça avec une fourchette."))),
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
    
    public static Recipe getPastaRecipe() {
        return new Recipe("One Pot Pasta", "Mais qu'est-ce que c'est ?\n" + 
                          "On savait déjà qu'il est possible de faire cuire des pâtes courtes par absorption. Avec les One Pot Pasta, on va plus loin car on met absolument tous les ingrédients dans une sauteuse, y compris les pâtes, on ajoute du bouillon et une dizaine de minutes après, c'est prêt et on n'a même pas besoin d'égoutter.\n" + 
                          "Génial, non ?",
                "pasta/main.jpg", "15 min de préparation, 10 min de cuisson", 2,
                Arrays.asList(
                        new Ingredient("Spaghettis", 180, "g"),
                        new Ingredient("Bouillon de légumes", 45, "cl"),
                        new Ingredient("Tomates cerise", 12, "pieces"),
                        new Ingredient("Courgette", 1, "piece"),
                        new Ingredient("Oignon", 1, "piece"),
                        new Ingredient("Carotte", 1, "piece"),
                        new Ingredient("Concentré de tomates", 1, "cuillière à soupe"),
                        new Ingredient("Sel", 1, "cuillère à café"),
                        new Ingredient("Parmesan râpé pour servir", 75, "g")
                ),
                Arrays.asList(
                        new Step("", "pasta/01.jpg", "Ajoutez les pâtes et le reste des ingrédients dans la sauteuse."),
                        new Step("", "pasta/02.jpg", " Ajoutez le bouillon, le sel et allumez le feu sur feu moyen."),
                        new Step("", "pasta/03.jpg", "Mélangez une fois ou deux durant la cuisson, le liquide doit bouillir."),
                        new Step("", "pasta/main.jpg", "C'est prêt !\n" + "La cuisson prend une dizaine de minutes. Mélangez et servez avec le parmesan détaillé en copeaux.")
                )
        );
    }
    
    //new recipe added #2
    public static Recipe getGalettesRecipe() {
        return new Recipe("Galettes au quinoa et courgettes", "Des galettes légères et rapides à préparer, idéales en entrée ou comme plat végétarien.",
                "galettes/main.jpg", "15 min de préparation, 20 min de cuisson", 4,
                Arrays.asList(
                        new Ingredient("Quinoa", 125, "g"),
                        new Ingredient("Courgettes", 2, "pieces"),
                        new Ingredient("Parmesan râpé", 100, "g"),
                        new Ingredient("Chapelure", 50, "g"),
                        new Ingredient("Eau", 30, "cl"),
                        new Ingredient("Oeuf", 1, "piece"),
                        new Ingredient("Gousses d' ail haché", 3, "pieces"),
                        new Ingredient("Huile d'olive", 3, "cuillères à soupe"),
                        new Ingredient("Origan séché", 1/2, "cuillères à café"),
                        new Ingredient("Sel", 1/2, "cuillères à café")
                ),
                Arrays.asList(
                        new Step("", "galettes/01.jpg", "Râpez les courgettes. Placez-les avec 1/2 cuillère à café de sel dans une passoire pour les dégorger. Laissez reposer 10 minutes puis essorez les courgettes.\n" + "En attendant, préparez le quinoa. Mélangez l'eau et le quinoa dans une petite casserole, portez à ébullition et laissez cuire pendant 10 minutes. Retirer du feu, égrainez le quinoa avec une fourchette et laissez reposer dix minutes."),
                        new Step("", "galettes/02.jpg", "Versez le quinoa dans un saladier. Ajoutez les courgettes râpées."),
                        new Step("", "galettes/03.jpg", "Ajoutez l'ail haché."),
                        new Step("", "galettes/04.jpg", "Ajoutez l'oeuf."),
                        new Step("", "galettes/05.jpg", "Ajoutez l'origan."),
                        new Step("", "galettes/06.jpg", "Ajoutez la chapelure."),
                        new Step("", "galettes/07.jpg", "Ajoutez le parmesan râpé."),
                        new Step("", "galettes/08.jpg", "Assaisonnez avec du sel et du poivre, mélangez bien, puis formez des galettes."),
                        new Step("", "galettes/09.jpg", "Faites chauffer l'huile dans une pôele, ajoutez les galettes et faites-les dorer 2 minutes."),
                        new Step("", "galettes/10.jpg", "Retournez-les et faites-les dorer deux minutes de l'autre coté. Servez les galettes avec une sauce au yaourt."),
                        new Step("", "galettes/11.jpg", "Régalez-vous !")
                )
        );
    }

}
