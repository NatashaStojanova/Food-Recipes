import React from 'react';

const Search = (props) => {
    debugger
    const onSearchTerm = (e) => {
        e.preventDefault();
        props.onSearchTerm(e.target.searchTerm.value);
    }

    return (
        <form onSubmit={onSearchTerm} className="form-inline mt-2 mt-md-0">
            <input className="form-control mr-sm-2" name={"searchTerm"} type="text" placeholder="Search By Recipe Name"
                   aria-label="Search"/>
            <button className="btn btn-primary navbar-inverse my-2 my-sm-0" type="submit">Search</button>
        </form>
    )
}
export default Search;