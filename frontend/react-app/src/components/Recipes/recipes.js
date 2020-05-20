import React, {useEffect, useState} from "react";
import axios from "../../axios/axios";
import RecipeDetails from "./RecipeDetails/recipeDetails";
import Search from "../Search/search";
import Category from "../CreateRecipe/Category/category";

const Recipes = () => {

    const searchTerm = (term) => {
        if (term == '') {
            axios.get("/recipes").then((data) => {
                console.log(data.data);
                setRecipe(data.data);

            });
        } else {
            axios.get("/recipes/search/" + term).then((data) => {
                console.log(data.data);
                setRecipe(data.data);
            });
        }
    }

    const categoryChange = (category) => {
        debugger;
        axios.get("/recipes/category/" + category).then((data) => {
            console.log(data.data);
            setRecipe(data.data);
        });

    }

    const [recipe, setRecipe] = useState({});

    useEffect(() => {
        axios.get("/recipes").then((data) => {
            console.log(data.data);
            setRecipe(data.data);

        });
    }, []);

    const allRecipes = Object.keys(recipe).map((rec, index) => {
        return (
            <RecipeDetails recipe={recipe[index]} key={index} colClass={"col-md-6 mt-2 col-sm-12"}/>
        );
    });

    return (
        <div className="container">
            <br/>
            <div className="row">
                <Search onSearchTerm={searchTerm}/>
                <Category onCategoryChange = {categoryChange}/>
            </div>
            <br/>
            <div className={"row"}>
                {allRecipes}
            </div>
        </div>

    )
};

export default Recipes;