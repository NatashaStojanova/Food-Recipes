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

        }

        let newIngredients = [
            {
                isChecked: '',
                amount: '',
            },
            {
                isChecked: '',
                amount: '',
            }
        ];

        this.state = {
            user:newUser,
            newRecipe:newRecipe,
            ingredients: newIngredients,
            waitResponse: false,
            errMessage: null,
        }
    }




    componentDidMount() {
        if (localStorage.getItem(AUTH_TOKEN) == null || localStorage.getItem(AUTH_TOKEN) == undefined)
            this.props.history.push("/register")
    }


    ingredientChange = ((temp) => {

       debugger;
    });

    render() {
        return(
            <div class="container">
                <Recipe/>
                <Category/>
                <Ingredient onIngredientChange = {this.ingredientChange}/>

            <Button color="primary">Submit</Button>
            </div>


        )
    }
}

const style = {
    margin: 15,
};

export default withRouter(CreateRecipe);