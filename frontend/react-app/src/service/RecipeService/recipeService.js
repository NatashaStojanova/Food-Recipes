import axios from "../../axios/axios"

const RecipeService = {
    addRecipe: (recipe) => {
        return axios.post("/recipes", recipe);
    }

}
export default RecipeService;