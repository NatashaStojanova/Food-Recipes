import React, {Component} from 'react';
import {Link} from "react-router-dom";

/**
 * @author Natasha Stojanova (natashastojanova6@gmail.com)
 */
class Header extends Component {
    render() {
        return (
            <div>
                <nav className="navbar navbar-expand-lg navbar-dark bg-success">
                    <a className="navbar-brand" href="/">Home</a>
                    <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarNav">
                        <ul className="navbar-nav">
                            <li className="nav-item">
                                <a className="nav-link" href="/allRecipes">View All recipes</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="/createRecipe">Create recipe</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="/searchRecipes">Search by Ingredients</a>
                            </li>
                        </ul>
                    </div>
                    <div align="left">
                        <ul className="navbar-nav">
                            <li className="nav-item">
                                <a className="nav-link" href="/login">Login</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="/register">Register</a>
                            </li>

                        </ul>
                    </div>
                </nav>
            </div>
        );
    }
}

export default Header;