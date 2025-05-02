import java.util.*;

public class c2115 {

    // 첫 훌이
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Set<String>> adj = new HashMap<>();
        Map<String, Integer> ind = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            int len = ingredients.get(i).size();
            ind.put(recipe, len);
            for (int j = 0; j < len; j++) {
                String ingredient = ingredients.get(i).get(j);
                if (!adj.containsKey(ingredient)) {
                    adj.put(ingredient, new HashSet<>());
                }
                Set<String> st = adj.get(ingredient);
                st.add(recipe);
            }
        }
        List<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        for (int i = 0; i < supplies.length; i++) {
            q.add(supplies[i]);
        }

        while (!q.isEmpty()) {
            String cur = q.poll();
            Set<String> nexts = adj.get(cur);
            if (nexts == null) continue;
            for (String next : nexts) {
                int value = ind.get(next) - 1;
                ind.put(next, value);
                if (value == 0) {
                    q.add(next);
                    ans.add(next);
                }
            }
        }
        return ans;
    }
}
