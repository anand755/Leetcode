package google.hash.code21.solution;

import java.io.*;
import java.util.*;

public class BruteForceOneSol {
    static class Pizza {
        int ingredientCount;
        String[] ingredients;

        public Pizza(String[] pizzaDetails) {
            this.ingredientCount = Integer.parseInt(pizzaDetails[0]);
            String[] tempIngredients = new String[this.ingredientCount];
            for (int i = 0; i < this.ingredientCount; i++) {
                tempIngredients[i] = pizzaDetails[i + 1];
            }
            this.ingredients = tempIngredients;
        }
    }

    static class PizzaCombinationScore {
        List<Pizza> pizzas;
        int score;

        public PizzaCombinationScore(List<Pizza> pizzas) {
            this.pizzas = pizzas;
            Set<String> uniqueIngredients = new HashSet<>();
            for (Pizza pizza : pizzas) {
                uniqueIngredients.addAll(Arrays.asList(pizza.ingredients));
            }
            int uniqueCount = uniqueIngredients.size();
            this.score = uniqueCount * uniqueCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Pizza> allPizzas = new ArrayList<>();
        int[] pizzaTeamCount = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int M = pizzaTeamCount[0];
        int T2 = pizzaTeamCount[1];
        int T3 = pizzaTeamCount[2];
        int T4 = pizzaTeamCount[3];

        while (M-- > 0) {
            String[] pizzaDetails = reader.readLine().split("\\s");
            Pizza pizza = new Pizza(pizzaDetails);
            allPizzas.add(pizza);
        }
        List<PizzaCombinationScore> L2 = new ArrayList<>();
        List<PizzaCombinationScore> L3 = new ArrayList<>();
        List<PizzaCombinationScore> L4 = new ArrayList<>();


        L2.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(0), allPizzas.get(1)))));
        L2.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(0), allPizzas.get(2)))));
        L2.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(0), allPizzas.get(3)))));
        L2.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(0), allPizzas.get(4)))));
        L2.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(1), allPizzas.get(2)))));
        L2.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(1), allPizzas.get(3)))));
        L2.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(1), allPizzas.get(4)))));
        L2.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(2), allPizzas.get(3)))));
        L2.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(2), allPizzas.get(4)))));
        L2.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(3), allPizzas.get(4)))));

        L3.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(0), allPizzas.get(1), allPizzas.get(2)))));
        L3.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(0), allPizzas.get(1), allPizzas.get(3)))));
        L3.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(0), allPizzas.get(1), allPizzas.get(4)))));
        L3.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(0), allPizzas.get(2), allPizzas.get(3)))));
        L3.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(0), allPizzas.get(2), allPizzas.get(4)))));
        L3.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(0), allPizzas.get(3), allPizzas.get(4)))));
        L3.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(1), allPizzas.get(2), allPizzas.get(3)))));
        L3.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(1), allPizzas.get(2), allPizzas.get(4)))));
        L3.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(1), allPizzas.get(3), allPizzas.get(4)))));
        L3.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(2), allPizzas.get(3), allPizzas.get(4)))));

        L4.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(0), allPizzas.get(1), allPizzas.get(2), allPizzas.get(3)))));
        L4.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(0), allPizzas.get(1), allPizzas.get(2), allPizzas.get(4)))));
        L4.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(0), allPizzas.get(1), allPizzas.get(3), allPizzas.get(4)))));
        L4.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(0), allPizzas.get(2), allPizzas.get(3), allPizzas.get(4)))));
        L4.add(new PizzaCombinationScore(new ArrayList<>(Arrays.asList(allPizzas.get(1), allPizzas.get(2), allPizzas.get(3), allPizzas.get(4)))));

        int ans = 0;
        int score2, score3, score4;
        int fT2 = 0;
        int fT3 = 0;
        int fT4 = 0;

        List<Pizza> FP = new ArrayList<>();
        List<Pizza> CP = new ArrayList<>();

        for (int t2 = 0; t2 <= T2; t2++) {
            //List<Pizza> CP = new ArrayList<>();
            for (PizzaCombinationScore pizzaCombo2 : L2) {
                if (!isPizzaAlreadyContains(CP, pizzaCombo2)) {

                    CP.addAll(pizzaCombo2.pizzas);
                    score2 = pizzaCombo2.score;

                    for (int t3 = 0; t3 <= T3; t3++) {
                        for (PizzaCombinationScore pizzaCombo3 : L3) {
                            if (!isPizzaAlreadyContains(CP, pizzaCombo3)) {
                                CP.addAll(pizzaCombo3.pizzas);
                                score3 = pizzaCombo3.score;

                                for (int t4 = 0; t4 <= T4; t4++) {
                                    for (PizzaCombinationScore pizzaCombo4 : L4) {
                                        if (!isPizzaAlreadyContains(CP, pizzaCombo4)) {
                                            CP.addAll(pizzaCombo4.pizzas);
                                            score4 = pizzaCombo4.score;

                                            int score = score2 + score3 + score4;
                                            if (score >= ans) {
                                                //FP = CP;
                                                FP.clear();
                                                FP.addAll(CP);

                                                fT2 = t2;
                                                fT3 = t3;
                                                fT4 = t4;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        FP.forEach(pizza -> {
            System.out.print(pizza.ingredientCount + " " + Arrays.toString(pizza.ingredients));
        });
        System.out.println("fT2 = " + fT2 + " fT3 = " + fT3 + " fT4 = " + fT4);
    }

    private static boolean isPizzaAlreadyContains(List<Pizza> cp, PizzaCombinationScore pizzaCombo) {
        for (Pizza pizza : pizzaCombo.pizzas) {
            if (cp.contains(pizza)) {
                return true;
            }
        }
        return false;
    }
}
