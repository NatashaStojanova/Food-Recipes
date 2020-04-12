import React, {Component, useEffect, useState} from 'react'
import axios from "../../../axios/axios"


class Ingredient extends Component {

    constructor(props){
        super(props)

        this.state = {
            ingredients: [],
            isChecked: false,

        }
    }

    onIngredientChange = (e) => {

        let final = [];
        let newIngredients = Object.keys(e.target.newIngredients).map((cbox) => {
            if (e.target.newIngredients[cbox].checked)
                return e.target.newIngredients[cbox];
        }).filter((item) => {
            if (item !== undefined)
                return item;
        }).map((item) => {
            let id = item.value;
            let amount = document.getElementById(id + "amount").value;
            let obj = {};
            obj[id] = amount;
            final.push(obj);
        });


    };




    componentDidMount() {
        axios.get("/ingredients").then((data) => {
            const ingredients = Object.keys(data.data).map((ingredient, index) => {
                return (
                    <tr key={index}>
                        <td scope="col">
                            <label>{data.data[index].name}</label>
                        </td>
                        <td scope="col">
                            <input
                                id={data.data[index].id}
                                key={index}
                                type="checkbox"
                                name={"newIngredients"}
                                value={data.data[index].id}
                                onClick={this.onIngredientChange}

                            />
                        </td>
                        <td scope="col">
                            <input
                                id={data.data[index].id + "amount"}
                                key={index}
                                type="number"
                                min="0"
                                max="500"
                                name="amount"
                                placeholder="grams"
                                onChange={this.onIngredientChange}
                            />
                        </td>
                    </tr>
                );
            });
            this.setState({ingredients: ingredients});
        });
    }


    render() {
        return (
            <div className="form-group">
                <table className="table tr-history table-striped small">
                    <thead>
                    <tr>
                        <th scope="col">
                            <h5>Ingredient</h5>
                        </th>
                        <th scope="col">
                            <h5>Check</h5>
                        </th>
                        <th scope="col">
                            <h5>Amount</h5>
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.state.ingredients}
                    </tbody>
                </table>
            </div>
        )
    }
}
export default Ingredient;