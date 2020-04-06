import React from "react";
import { MDBContainer, MDBRow, MDBCol, MDBBtn, MDBInput } from 'mdbreact';

const Recipe = () => {
    return (
        <MDBContainer>
            <MDBRow>
                <MDBCol md="5">
                    <form>
                        <p className="h2 text-center mb-4">Create new Recipe</p>
                        <div className="grey-text">
                            <MDBInput label="Name"  group type="text" validate />
                            <MDBInput label="Hours"/>
                            <MDBInput type="textarea" label="Description" rows="7" />
                        </div>
                        <div className="text-center">
                        </div>
                    </form>
                </MDBCol>
            </MDBRow>
        </MDBContainer>
    );
};

export default Recipe;