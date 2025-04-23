import Navbar from "../../components/navbar/Navbar.jsx";
import "./Accueil.css";
import SearchBar from "../../components/searchBar/SearchBar.jsx";
import Filters from "../../components/filters/Filters.jsx";
import Display from "../../components/homePageDisplay/Display.jsx";
import React, {useState} from "react";
import PropertiesListCard from "../../components/propertiesDisplay/PropertiesListCard.jsx";


function Accueil() {

    const [filters, setFilters] = useState({})
    return (
        <div className={"container"}>
            <Navbar />
            <div className={"sloganBackground"}>
                <h1 className={"sloganText"}>Find your ideal property in Montreal or Laval with HomeBreeze</h1>
                <div className={"searchContainer"}>
                    <Filters setFilters={setFilters}/>
                </div>
            </div>
            <Display/>

        </div>
    )
}
export default Accueil;