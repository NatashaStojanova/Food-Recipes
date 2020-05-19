import React, {useEffect, useState} from 'react'
import {useParams, withRouter} from "react-router-dom";
import axios from "../../../axios/axios"

const RecipeDetails = (props) => {
    const [recipe, setRecipe] = useState({});
    const {id} = useParams();

    useEffect(() => {
        axios.get("/recipes/" + id).then((data) => {
            console.log(data.data);
            setRecipe(data.data);
        });
    }, []);

    return (
        <div>
            Portfolio component
            <p>Topic: {id}</p>
            <div className="col-sm-6">
                {recipe !== undefined && recipe.ingredients !== undefined ?
                    <div>
                        <div className="card-header">
                            <div className="row">
                                <div className="col-md-6 font-weight-bold">
                                    Name: {recipe.name}
                                </div>
                                <div className="col-md-6 font-weight-bold">
                                    Description: {recipe.name}
                                </div>
                                <div className="col-md-6 font-weight-bold">
                                    Time: {recipe.name}
                                </div>
                                <div className="col-md-6 font-weight-bold">
                                    Rating: {recipe.name}
                                </div>
                            </div>
                        </div>
                        <span>
                            {recipe.ingredients.map((ingredient, index) => {
                                return <div key={index}>
                                    {ingredient.name}
                                    {ingredient.spicy}

                                </div>
                            })}
                        </span>
                    </div> :
                    <div style={{display: 'flex', justifyContent: 'center', alignItems: 'center', height: '50vh'}}
                         className="container text-black-50 text-lg-center">
                        <img alt="" style={{width: "10%"}}
                             src={require('../../../assets/loading.gif')}/>
                        Please wait while we fetch our data
                    </div>}
            </div>
        </div>
    );
};
export default withRouter(RecipeDetails);
