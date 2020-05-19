import React, {useEffect, useState} from 'react'
import {useParams, withRouter} from "react-router-dom";
import axios from "../../../axios/axios"

const RecipeDetails = (props) => {
    const [recipe, setRecipe] = useState({});
    const {id} = useParams();

    useEffect(() => {
        axios.get("/recipes/" + id).then((data) => {
            console.log(data.data)
            setRecipe(data.data);
        });
    }, []);

    return (
        <div>
            Portfolio component
            <p>Topic: {id}</p>
            <div className="col-sm-6">
                <p>{recipe.name}</p>
                <p>{recipe.time}</p>
                <p>{recipe.rating}</p>
                <p>{recipe.description}</p>


            </div>

        </div>
    );
};
export default withRouter(RecipeDetails);
