import React, {Component} from 'react'
import {AUTH_TOKEN, AUTH_USERNAME} from "../../shared/utility";
import {withRouter} from "react-router-dom";
import Button from "@material-ui/core/Button"
import CheckIngredient from "./CheckIngredient/checkIngredient";
import axios from "../../axios/axios"
import RecipeService from "../../service/RecipeService/recipeService";
import RecipeFound from "./RecipesFound/recipesFound";
import Redirect from "react-router-dom/es/Redirect";
import Link from "@material-ui/core/Link";

class FindByIngredients extends Component {

    constructor(props) {
        super(props);

        let newUsername = localStorage.getItem(AUTH_USERNAME);

        let newIngredients = {};

        this.state = {
            ingredients: newIngredients,
            recipes: [],
            waitResponse: false,
            errMessage: null,
        }
    }

    componentDidMount() {
        if (localStorage.getItem(AUTH_TOKEN) == null || localStorage.getItem(AUTH_TOKEN) === undefined)
            this.props.history.push("/register")
    }

    ingredientChange = ((ingList) => {
        this.setState({ingredients: ingList}, () => {
            console.log(ingList);
            console.log(this.state.ingredients);
        });
    });


    searchRecipesByIngredients = (e) => {
        console.log(this.state.ingredients);
        RecipeService.searchRecipes(this.state.ingredients).then(respData => {
            console.log(respData.data);
            document.getElementById("showRecipes").style.visibility = "visible";
            this.setState({recipes:respData.data},()=>{
                console.log("recipes:");
                console.log(this.state.recipes);
            });
        })
    }
    render() {
        return (
            <div class="container">
                <CheckIngredient onIngredientChange={this.ingredientChange}/>
                <button className="btn btn-outline-success navbar-inverse my-2 my-sm-0" type="submit"
                        onClick={this.searchRecipesByIngredients}>Search
                </button>
                <div id="showRecipes" style={{visibility: "hidden"}}>
                    <div>
                        {this.state.recipes.length > 0 ?
                        <div>
                        <RecipeFound recipes = {this.state.recipes} />
                        </div> :
                            <div style={{display: 'flex', justifyContent: 'center', alignItems: 'center', height: '50vh'}}
                                 className="container text-black-50 text-lg-center">
                                <img alt="" style={{width: "10%"}}
                                     src={require('../../assets/loading.gif')}/>
                                Please wait while we fetch our data
                            </div> }
                    </div>
                </div>
            </div>
        )
    }
}

const style = {
    margin: 15,
};
export default withRouter(FindByIngredients);