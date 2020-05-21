import axios from "../../axios/axios"

const RecipeService = {
    addRecipe: (recipe) => {
        return axios.post("/recipes", recipe);
    },

    searchRecipes: (ingredients) => {
        console.log("ingredients:");
        console.log(ingredients);
        debugger;
        let form = new FormData();
        return axios.post("/recipes/checkIngredients", ingredients);
    }
}
export default RecipeService;