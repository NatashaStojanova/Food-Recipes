import React, {Component, useEffect, useState} from 'react'
import axios from "../../../axios/axios"


const Ingredient = (props) => {



    const onIngredientChange = (e) => {
        debugger;
        setChecked(e.target.checked);
        if(e.target.value.checked){

        }

        e.preventDefault();
        props.onIngredientChange(e.target.name);
    };



    let [ingredients, setIngredient] = useState();
    const [checked, setChecked] = React.useState(false);

    useEffect(() => {
        axios.get("/ingredients").then((data) => {
            const ingredients = Object.keys(data.data).map((ingredient, index) => {
                return (
                    <tr key={index}>
                        <td scope="col">
                            <label>{data.data[index].name}</label>
                        </td>
                        <td scope="col">
                            <input id={ingredient} onChange={onIngredientChange} key={index} type="checkbox"
                                   name={"newIngredients"} value={data.data[index].id}  checked={checked}
                                   />
                        </td>
                        <td scope="col">
                            <input  id={data.data[index].id + "amount"} key={index} type="number"
                                    min="0" max="500"
                                    name="amount" placeholder="grams" onChange={onIngredientChange}/>

                        </td>
                    </tr>
                );
            });
            setIngredient(ingredients);
        });
    }, []);

    return(

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
                {ingredients}
                </tbody>
            </table>
        </div>

    )



}
export default Ingredient;