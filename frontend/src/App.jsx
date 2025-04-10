import {BrowserRouter, Routes, Route} from "react-router-dom";
import './App.css'
import Accueil from "./pages/Accueil.jsx";
import FormVendre from "./pages/FormVendre.jsx";
import Connexion from "./pages/Connexion.jsx";
import PropertiesRentListCard from "./components/propertiesDisplay/PropertiesRentListCard.jsx";


function FormeLouer() {
    return null;
}

function App() {

    return (
        <div>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Accueil/>}/>
                    <Route path="/sell" element={<FormVendre/>}/>
                    <Route path="/rent" element={<FormeLouer/>}/>
                    <Route path="/login" element={<Connexion/>}/>
                    <Route path="/search" element={<PropertiesRentListCard/>}/>
                </Routes>
            </BrowserRouter>
        </div>
    );
}
export default App;
