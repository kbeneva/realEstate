import {BrowserRouter, Routes, Route} from "react-router-dom";
import './App.css'
import Accueil from "./pages/Accueil/Accueil.jsx";
import FormVendre from "./pages/FormVendre.jsx";
import FormLouer from "./pages/FormLouer.jsx";
import Connexion from "./pages/connexion/Connexion.jsx";
import ProfilClientFavoris from "./pages/profilClient/ProfilClientFavoris.jsx";
import ProfilAdmin from "./pages/profilAdmin/ProfilAdmin.jsx";
import ProfilAgentPropriete from "./pages/profilAgent/ProfilAgentPropriete.jsx";
import FilterPage from "./pages/PropertyView/FilterPage.jsx";
import PropertyView from "./pages/PropertyView/PropertyView.jsx";
import ContactAgentForm from "./pages/forms/ContactAgentForm.jsx";


function App() {

    return (
        <div>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Accueil/>}/>
                    <Route path="/sell" element={<FormVendre/>}/>
                    <Route path="/rent" element={<FormLouer/>}/>
                    <Route path="/login" element={<Connexion/>}/>
                    <Route path="/customerProfile" element={<ProfilClientFavoris/>}/>
                    <Route path="/agentProfile" element={<ProfilAgentPropriete/>}/>
                    <Route path="/adminProfile" element={<ProfilAdmin/>}/>
                    <Route path="/search" element={<FilterPage/>}/>
                    <Route path="/property/:typeProperty/:id" element={<PropertyView/>}/>
                    <Route path="/contact/:idAgent/:idProperty" element={<ContactAgentForm/>}/>

                </Routes>
            </BrowserRouter>
        </div>
    );
}
export default App;
