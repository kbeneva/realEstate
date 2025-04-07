import './SearchBar.css';

function SearchBar() {
    return (
        <div>
            <input className={"searchBar"} type="text" placeholder="Search by city" />
        </div>

    );
}

export default SearchBar;