import React, { Component } from 'react';
import {
    MDBContainer,
    MDBCol,
    MDBCollapse,
    MDBCard,
    MDBCardBody,
    MDBCollapseHeader,
    MDBCardImage,
    MDBRow,
    MDBView
} from 'mdbreact';
import ViewAllRecipes from "./ViewAllRecipes/viewAllRecipes";
import CreateNewRecipes from "./CreateNewRecipes/createNewRecipes";
import CheckYourIngredients from "./CheckYourIngredients/checkYourIngredients";

class HomeRecipes extends Component {
    state = {
        collapseID: 'collapse1'
    };

    toggleCollapse = collapseID => () =>
        this.setState(prevState => ({
            collapseID: prevState.collapseID !== collapseID ? collapseID : ''
        }));

    render() {
        const { collapseID } = this.state;

        return (
            <div class="row">
                <br/>
            <ViewAllRecipes/>
            <CreateNewRecipes/>
            <CheckYourIngredients/>
            </div>

        );
    }
}

export default HomeRecipes;