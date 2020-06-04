import React, {Component} from 'react'
import {AUTH_TOKEN, AUTH_USERNAME} from "../../shared/utility";
import {withRouter} from "react-router-dom";
import Recipe from "./Recipe/recipe"
import Category from "./Category/category"
import Button from "@material-ui/core/Button";
import Ingredient from './Ingredient/ingredient'
import RecipeService from "../../service/RecipeService/recipeService";
import {ImageUpload} from "./ImageUpload/imageUpload";

class CreateRecipe extends Component {

    constructor(props) {
        super(props);

        let newUsername = localStorage.getItem(AUTH_USERNAME);

        let newRecipe = {
            name: "",
            description: "",
            time: "",
            ingredientsList: {},
            category: "",
            username: "",

        }

        let newIngredients = {};

        let newCategory = "";

        let newImage = "";

        this.state = {
            username: newUsername,
            recipe: newRecipe,
            category: newCategory,
            image: newImage,
            ingredients: newIngredients,
            waitResponse: false,
            errMessage: null,
        }
    }

    componentDidMount() {
        if (localStorage.getItem(AUTH_TOKEN) == null || localStorage.getItem(AUTH_TOKEN) == undefined)
            this.props.history.push("/register")
    }


    ingredientChange = ((ingList) => {
        this.setState({ingredients: ingList}, () => {
            //console.log(ingList);
            console.log(this.state.ingredients);
        });
    });

    categoryChange = ((value) => {
        this.setState({category: value}, () => {
            //console.log(this.state.category);
            //console.log(this.state.ingredients);
        });
    });

    recipeChange = ((target, value) => {
        this.setState(prevState => {
            let recipe = this.state.recipe;
            recipe[target] = value;
            return {
                recipe: recipe,
            }
        }, () => {
            //console.log(this.state.recipe)
        })
    });

    fileUploadHandler = (selectedFile) => {
        this.setState({image: selectedFile})
    }

    saveRecipe = (e) => {

        this.setState(prevState => {
            let ingList = this.state.ingredients;
            let categoryRecipe = this.state.category;
            let userRecipe = this.state.username;

            this.state.recipe.ingredientsList = ingList;
            this.state.recipe.category = categoryRecipe;
            this.state.recipe.username = userRecipe;

        }, () => {
            console.log("eve go finalniot recept:")
            console.log(this.state.recipe)
            let formData = new FormData();
            formData.append('image', this.state.image);
            formData.append('name', this.state.recipe.name);
            formData.append('description', this.state.recipe.description);
            formData.append('category', this.state.recipe.category);
            formData.append('time', this.state.recipe.time);
            formData.append('username', this.state.recipe.username);
            formData.append("ingredientsList", JSON.stringify(this.state.recipe.ingredientsList));

            RecipeService.addRecipe(formData).then(recipeResp => {
                this.props.history.push("/allRecipes")
            }).catch(error => {
                alert("an error occured")
            })
        })

    }

    render() {
        return (
            <div class="container">
                <Recipe onRecipeChange={this.recipeChange}/>
                <Category onCategoryChange={this.categoryChange}/>
                <ImageUpload onFileUploadHandler={this.fileUploadHandler}/>
                <Ingredient onIngredientChange={this.ingredientChange}/>
                <Button color="primary" type="submit" onClick={this.saveRecipe}>Submit</Button>
            </div>
        )
    }
}

const style = {
    margin: 15,
};

export default withRouter(CreateRecipe);