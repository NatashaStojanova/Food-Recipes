import React, {Component} from 'react'
import {AUTH_TOKEN} from "../../shared/utility";
import {withRouter} from "react-router-dom";
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';
import Recipe from "./Recipe/recipe"
import Category from "./Category/category"
import Button from "@material-ui/core/Button";
import Ingredient from './Ingredient/ingredient'
import RecipeService from "../../service/RecipeService/recipeService";


class CreateRecipe extends Component{

    constructor(props) {
        super(props);

        let newUser = {
            name: "",
            username: "",
            email: "",
            password: "",

        }

        let newRecipe = {
            name: "",
            description: "",
            time: "",
            ingredientsList: [],
            category: "",

        }

        let newIngredients = [];

        let newCategory = "";

        this.state = {
            user:newUser,
            recipe:newRecipe,
            category:newCategory,
            ingredients: newIngredients,
            waitResponse: false,
            errMessage: null,
        }
    }

    componentDidMount() {
        if (localStorage.getItem(AUTH_TOKEN) == null || localStorage.getItem(AUTH_TOKEN) == undefined)
            this.props.history.push("/register")
    }


    ingredientChange = ((ingList) =>{
        this.setState({ingredients:ingList},()=>{
            //console.log(ingList);
            //console.log(this.state.ingredients);
        });
    });

    categoryChange = ((value) => {
        this.setState({category: value },()=>{
            //console.log(this.state.category);
            //console.log(this.state.ingredients);
        });
    });

    recipeChange = ((target,value) => {
        this.setState(prevState => {
            let recipe = this.state.recipe;
            recipe[target] = value;
            return{
                recipe:recipe,
            }
        },() =>{
            //console.log(this.state.recipe)
        })
    });

    saveRecipe = (e) => {
      console.log(this.state.recipe);
      console.log(this.state.ingredients);
      console.log(this.state.category);

        this.setState(prevState => {
            let ingList = this.state.ingredients;
            let categoryRecipe = this.state.category;
            this.state.recipe.ingredientsList = ingList;
            this.state.recipe.category = categoryRecipe;

        },() =>{
            console.log(this.state.recipe)
            RecipeService.addRecipe(this.state.recipe).then(recipeResp => {
            }).catch(error => {
                alert("an error occured")
            })
        })

    }

    render() {
        return(
            <div class="container">
                <Recipe onRecipeChange = {this.recipeChange}/>
                <Category onCategoryChange = {this.categoryChange}/>
                <Ingredient onIngredientChange = {this.ingredientChange}/>

            <Button color="primary" type="submit" onClick={this.saveRecipe}>Submit</Button>
            </div>
        )
    }
}

const style = {
    margin: 15,
};

export default withRouter(CreateRecipe);