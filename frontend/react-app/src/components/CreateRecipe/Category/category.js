import React, {Component} from "react";
import axios from "../../../axios/axios";

class Category extends Component{
    constructor(props){
        super(props)

        this.state = {
            categories: [],
        }
    }

    onCategoryChange = (e) =>{

        this.props.onCategoryChange(e.target.value);
    }

    componentDidMount() {
        axios.get("/categories").then((data) => {
            const categories = Object.keys(data.data).map((category, index) => {
                return (
                    
                        <option
                            id={data.data[index].id}
                            key={index}
                            value={data.data[index].id}>
                            {data.data[index].name}
                        </option>

                );
            });
            this.setState({categories: categories});
        });
    }

    render() {
        return(
            <div className="form-group col-md-5">
                <select name="name" class="form-control"
                        onChange={this.onCategoryChange}>{this.state.categories}</select>
                <h6>Choose a category</h6>

            </div>
        )
    }
}
export default Category;