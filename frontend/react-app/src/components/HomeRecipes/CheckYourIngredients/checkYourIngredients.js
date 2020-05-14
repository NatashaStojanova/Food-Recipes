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

class CheckYourIngredients extends Component {
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

            <div class="card card-image" style={{backgroundImage: `url()`}}>


                <div class="text-white text-center d-flex align-items-center rgba-black-strong py-5 px-4">
                    <div>
                        <h1 class="pink-text"><i class="fas fa-check"></i>Find food based on Ingredients</h1>
                        <h3 class="card-title pt-2"><strong>This is the card title</strong></h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellat fugiat, laboriosam, voluptatem,
                            optio vero odio nam sit officia accusamus minus error nisi architecto nulla ipsum dignissimos.
                            Odit sed qui, dolorum!.</p>
                        <a className="btn btn-pink" href="/createRecipe"><i className="fas fa-clone left"></i> Create
                            Recipe</a>
                    </div>
                </div>

            </div>



        );
    }
}

export default CheckYourIngredients;