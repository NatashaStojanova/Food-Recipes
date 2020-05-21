import React, {Component} from 'react'
import {AUTH_TOKEN, AUTH_USERNAME} from "../../shared/utility";
import {withRouter} from "react-router-dom";
import Button from "@material-ui/core/Button"
import CheckIngredient from "./CheckIngredient/checkIngredient";
import axios from "../../axios/axios"
import RecipeService from "../../service/RecipeService/recipeService";

class FindByIngredients extends Component {

    constructor(props) {
        super(props);

        let newUsername = localStorage.getItem(AUTH_USERNAME);

        let newIngredients = {};

        this.state = {
            ingredients: newIngredients,
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
            alert('success')
        }).catch(
            alert("an error occured")
        )
    }

    render() {
        return (
            <div class="container">
                <CheckIngredient onIngredientChange={this.ingredientChange}/>
                <Button color="primary" type="submit" onClick={this.searchRecipesByIngredients}>Search</Button>
            </div>
        )
    }
}

const style = {
    margin: 15,
};
export default withRouter(FindByIngredients);