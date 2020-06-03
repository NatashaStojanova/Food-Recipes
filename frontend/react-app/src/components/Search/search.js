import React from 'react';

const Search = (props) => {
    const onSearchTerm = (e) => {
        e.preventDefault();
        props.onSearchTerm(e.target.searchTerm.value);
    }

    return (
        <div className="form-group col-md-5">
            <form onSubmit={onSearchTerm} className="form-inline mt-2 mt-md-0">
                <input className="form-control mr-sm-2" name={"searchTerm"} type="text" placeholder="Search By Recipe Name"
                       aria-label="Search"/>
                <button className="btn btn-outline-success navbar-inverse my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    )
}
export default Search;