import React, { Component } from 'react';
import {Link} from "react-router-dom";
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

class ViewAllRecipes extends Component {
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
                    <div class="text-white text-center d-flex align-items-center rgba-black-strong py-lg-5 px-4">
                        <br/>
                        <h1 class="pink-text"><i class="fas fa-eye"></i> <Link to={"/allRecipes"}>View All
                            Recipes</Link></h1>

                    </div>
                </div>

            </div>



        );
    }
}

export default ViewAllRecipes;