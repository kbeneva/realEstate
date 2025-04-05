import Navbar from "../components/navbar/Navbar.jsx";
import "./Accueil.css";
import SearchBar from "../components/SearchBar.jsx";
import Filters from "../components/filters/Filters.jsx";
import Display from "../components/homePageDisplay/Display.jsx";


function Accueil() {
    return (
        <div className={"container"}>
            <Navbar />
            <div className={"sloganBackground"}>
                <h1 className={"sloganText"}>Find your ideal property in Montreal or Laval with HomeBreeze</h1>
                <div className={"searchContainer"}>
                    <SearchBar />
                    <Filters />
                </div>
            </div>
            <Display />

        </div>
    )
}
export default Accueil;