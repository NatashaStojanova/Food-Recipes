import React, {Component, useEffect, useState} from 'react'
import axios from "../../../axios/axios"

class Ingredient extends Component {

    constructor(props){
        super(props)

        this.state = {
            ingredients: [],
            ingedientsList: [],
            checkedList:[],
            isChecked: false,

        }
    }

    onIngredientChange = (e,id) => {
        let resultArray = {};
        let key = e.target.name;
        let val = e.target.value;

        if (key === "amount" || e.target.checked)      //if checked (true), then add this id into checkedList
        {
            resultArray = this.state.checkedList.filter(checkedIngredient => {
                return checkedIngredient.id !== id.toString()
            });
            if (key === "amount")
                resultArray.push({id: id.toString(), amount: val});
            else
                resultArray.push({id: id.toString(), amount: null});
        }
        else                    //if not checked (false), then remove this id from checkedList
        {
            resultArray = this.state.checkedList.filter(CheckedId=>{
                return CheckedId !== id.toString()
            })
        }

        this.setState({
            checkedList:resultArray
        });

        //console.log(resultArray)   // get all checked ID

        this.props.onIngredientChange(resultArray);
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
                                onChange={(e) => this.onIngredientChange(e, data.data[index].id)}

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
                                onChange={(e) => this.onIngredientChange(e, data.data[index].id)}
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