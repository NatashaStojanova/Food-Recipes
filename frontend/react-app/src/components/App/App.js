import logo from '../../logo.svg';
import './App.css';
import React, {Component} from 'react';
import {BrowserRouter as Router, Route} from 'react-router-dom'
import Home from "../Home/home";
import Header from "../Header/header";
import Login from "../Login/login"
import Register from "../Register/register"
import Footer from "../Footer/footer";
import CreateRecipe from "../CreateRecipe/createRecipe"
import HomeRecipes from "../HomeRecipes/homeRecipes";
import Recipes from "../Recipes/recipes";
import RecipeDetails from "../Recipes/RecipeDetails/recipeDetails";
function App() {
  return (
      <div className="App">
          <Router>
              <Header/>
              <Route path={"/"} exact render={() =>
                  <Home/>}>
              </Route>
              <Route path="/login" exact render={() => <Login/>}/>
              <Route path="/register" exact render={() => <Register/>}/>
              <Route path="/createRecipe" exact render={() => <CreateRecipe/>}/>
              <Route path="/homeRecipes" exact render={() => <HomeRecipes/>}/>
              <Route path="/allRecipes" exact render={() => <Recipes/>}/>
              <Route path="/recipe/:id/details" exact render={() => <RecipeDetails/>}/>

              <Footer/>
        </Router>
      </div>

  );
}

export default App;
