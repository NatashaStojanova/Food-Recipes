import React from "react";
import { MDBContainer, MDBRow, MDBCol, MDBBtn, MDBInput } from 'mdbreact';

const Category = () => {
    return (
        <MDBContainer>
            <MDBRow>
                <MDBCol md="5">
                    <form>
                        <div className="grey-text">
                            <MDBInput label="Category"  group type="text" validate />
                        </div>
                        <div className="text-center">
                        </div>
                    </form>
                </MDBCol>
            </MDBRow>
        </MDBContainer>
    );
};

export default Category;