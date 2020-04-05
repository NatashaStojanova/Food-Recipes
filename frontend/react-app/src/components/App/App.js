import logo from '../../logo.svg';
import './App.css';
import React, {Component} from 'react';
import {BrowserRouter as Router, Route} from 'react-router-dom'
import Home from "../Home/home";
import Header from "../Header/header";
import Login from "../Login/login"
import Register from "../Register/register"
import Footer from "../Footer/footer";

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
              <Footer/>
        </Router>
      </div>

  );
}

export default App;
