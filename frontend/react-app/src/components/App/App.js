import logo from '../../logo.svg';
import './App.css';
import React, {Component} from 'react';
import {BrowserRouter as Router, Route} from 'react-router-dom'
import Home from "../Home/home";
import Header from "../Header/header";

function App() {
  return (
      <div className="App">
          <Router>
              <Header/>
              <Route path={"/"} exact render={() =>
                  <Home/>}>
              </Route>
        </Router>
      </div>

  );
}

export default App;
