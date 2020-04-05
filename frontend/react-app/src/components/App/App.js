import logo from '../../logo.svg';
import './App.css';
import React, {Component} from 'react';
import {BrowserRouter as Router, Route} from 'react-router-dom'
import Home from "../Home/home";
import Header from "../Header/header";
import Login from "../Login/login"

function App() {
  return (
      <div className="App">
          <Router>
              <Header/>
              <Route path={"/"} exact render={() =>
                  <Home/>}>
              </Route>
              <Route path="/login" exact render={() => <Login/>}/>
        </Router>
      </div>

  );
}

export default App;
