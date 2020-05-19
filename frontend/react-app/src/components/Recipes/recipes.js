import React, {Component} from 'react'
import axios from "../../axios/axios";
import {Link} from "react-router-dom";
import RecipeDetails from "./RecipeDetails/recipeDetails";

class Recipes extends Component{
    constructor(props){
        super(props)

        this.state = {
            recipes: [],
        }
    }

    componentDidMount() {
        axios.get("/recipes").then((data) => {
            const recipes = Object.keys(data.data).map((recipe, index) => {
                return (
                    <tr key={index}>
                        <td scope="col">
                            <label>{data.data[index].name}</label>
                        </td>
                        <td scope="col">
                            <label>{data.data[index].time} h</label>
                        </td>
                        <td scope="col">
                            <Link
                                className="btn btn-success"
                                id={data.data[index].id}
                                key={index}
                                to={"/recipe/" + data.data[index].id + "/details"}
                                type="button"
                                name="amount">View more...</Link>
                        </td>
                    </tr>
                );
            });
            this.setState({recipes: recipes});
        });
    }


    render() {
        return(
            <div className="form-group">
                <table className="table tr-history table-striped small">
                    <thead>
                    <tr>
                        <th scope="col">
                            <h5>Name:</h5>
                        </th>
                        <th scope="col">
                            <h5>Time:</h5>
                        </th>
                        <th scope="col">
                            <h5>More</h5>
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.state.recipes}
                    </tbody>
                </table>
            </div>
        )
    }
}
export default Recipes;