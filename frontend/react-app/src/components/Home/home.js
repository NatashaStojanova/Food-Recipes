import React from "react";
import {
    MDBCarousel,
    MDBCarouselCaption,
    MDBCarouselInner,
    MDBCarouselItem,
    MDBView,
    MDBMask,
    MDBContainer
} from "mdbreact";
import {Jumbotron} from 'reactstrap';

const Home = (props) => {
    return (
        <div>
            <Jumbotron
                style={{backgroundImage: `url(https://images.pexels.com/photos/940302/pexels-photo-940302.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260)`}}>
                <h1 className="display-3">Our Best Food Recipes Shared!</h1>
                <h2 className="display-5">Find and share everyday cooking inspiration on FoodRecipes.
                    Discover recipes, cooks, rate them and enjoy.</h2>
                <br/>
                <br/>
                <hr className="my-2"/>
                <br/>
                <p className="lead">
                    <h3 className="display-5">Sign up to get your ideas</h3>
                    <a href="/register" className="btn btn-primary">Get started</a>
                </p>
            </Jumbotron>
            <br/>
        </div>
    )
}
export default Home;