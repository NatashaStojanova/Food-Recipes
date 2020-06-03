import React, {useEffect, useState} from "react";
import axios from "../../../axios/axios";
import Details from "./Details/details";

const RecipesFound = (props) => {

    const [recipe, setRecipe] = useState({});

    useEffect(() => {
        console.log("props:");
        console.log(props);
        setRecipe(props.recipes);
    }, []);

    const allRecipes = Object.keys(recipe).map((rec, index) => {
        return (
            <Details recipe={recipe[index]} key={index} colClass={"col-md-6 mt-2 col-sm-12"}/>
        );
    });
    return (
        <div className="container">
            <br/>
            <br/>
            <div className={"row"}>
                {allRecipes}
            </div>
        </div>
    )
};
export default RecipesFound;