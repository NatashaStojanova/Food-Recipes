import React from "react";
import { MDBContainer, MDBRow, MDBCol, MDBBtn, MDBInput } from 'mdbreact';

const Recipe = (props) => {
    const onRecipeChange = (e) => {
        e.preventDefault();
        props.onRecipeChange(e.target.name, e.target.value);
    };
    return (
        <MDBContainer>
            <MDBRow>
                <MDBCol md="5">
                    <form>
                        <p className="h2 text-center mb-4">Create new Recipe</p>
                        <div className="grey-text">
                            <MDBInput label="Name"  group type="text" validate name={"name"} onChange={onRecipeChange}/>
                            <MDBInput label="Hours" name={"time"} onChange={onRecipeChange}/>
                            <MDBInput type="textarea" label="Description" rows="7" name={"description"} onChange={onRecipeChange}/>
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