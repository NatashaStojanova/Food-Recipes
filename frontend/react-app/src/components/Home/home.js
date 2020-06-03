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

const backgroundImage = require('../../assets/background.jpeg');
const divStyle = {
    width: '100%',
    height: '940px',
    backgroundImage: `url(${backgroundImage})`,
    backgroundSize: 'cover',
};
const divMargin = {
    marginLeft: '22px',
}
const hStyle = {color: 'green'};

export default class Home extends React.Component {
    render() {
        return (
            <div className="Component" style={divStyle}>
                <br/><br/><br/><br/>
                <div className="carousel-fade" align="left" style={divMargin}>
                    <h1 align="left">ENJOY OUR SPECIAL MEALS <br/> EVERY DAY</h1><br/>
                    <h3 align="left">Try out best recipes, share your experience <br/>
                        and find delicious food based on <br/>ingredients you have!</h3><br/>
                    <h2 align="left"><a href="/register">Click here to Join us!</a></h2>
                </div>
            </div>
        );
    }
}