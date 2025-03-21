class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();  // Adjacency list
        Map<String, Integer> inDegree = new HashMap<>();    // Store the in-degree count
        Set<String> available = new HashSet<>(Arrays.asList(supplies)); // Set of available ingredients
        Queue<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();

        // Step 1: Initialize graph and in-degree
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            inDegree.put(recipe, ingredients.get(i).size()); // Set in-degree for recipe

            // Iterate through ingredients of this recipe
            for (String ing : ingredients.get(i)) {
                // Build dependency graph
                graph.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipe);
            }
        }

        // Step 2: Add initial supplies to the queue
        for (String supply : supplies) {
            queue.offer(supply);
        }

        // Step 3: Process the queue
        while (!queue.isEmpty()) {
            String ingredient = queue.poll();

            // If this ingredient is a recipe, add it to the result
            if (inDegree.containsKey(ingredient)) {
                result.add(ingredient);
            }

            // Reduce in-degree of dependent recipes
            if (graph.containsKey(ingredient)) {
                for (String recipe : graph.get(ingredient)) {
                    inDegree.put(recipe, inDegree.get(recipe) - 1);
                    if (inDegree.get(recipe) == 0) {
                        queue.offer(recipe); // Add to queue when all ingredients are available
                    }
                }
            }
        }

        return result;
    }
}